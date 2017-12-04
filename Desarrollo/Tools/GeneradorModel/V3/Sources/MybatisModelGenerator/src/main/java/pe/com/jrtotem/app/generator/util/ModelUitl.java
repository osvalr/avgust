package pe.com.jrtotem.app.generator.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import pe.com.jrtotem.app.generator.dto.DataTypeDto;
import pe.com.jrtotem.app.generator.dto.ModelDto;
import pe.com.jrtotem.app.generator.dto.ModelInputDto;
import pe.com.jrtotem.app.generator.dto.PropertyDto;
import pe.com.jrtotem.app.generator.mybatis.domain.BuildSetting;
import pe.com.jrtotem.app.generator.mybatis.query.domain.SubModelQuery;

public class ModelUitl {

	public static ModelDto loadDataArtifacts(ModelInputDto modelInputDto,BuildSetting buildSetting,List<SubModelQuery> listSubModelQuery){
		ModelDto modelType = loadData(modelInputDto, buildSetting);
		
		modelType.setOut(modelInputDto.getOutputs());
		modelType.setFrom(modelInputDto.getFroms());
		modelType.setInput(modelInputDto.getInputs());
		
		modelType.setAttributesOut(generarAtributos(modelInputDto.getListPropertyDtos(), ConstanUtil.OUT));
		modelType.setMethodsOut(generarGetterAndSetter(modelInputDto.getListPropertyDtos(), ConstanUtil.OUT));
		
		modelType.setAttributesInput(generarAtributos(modelInputDto.getListPropertyDtos(), ConstanUtil.INPUT));
		modelType.setMethodsInput(generarGetterAndSetter(modelInputDto.getListPropertyDtos(), ConstanUtil.INPUT));
		
		modelType.setAttributesSubModels(generarSubModelAtributos(listSubModelQuery));
		modelType.setMethodsSubModels(generarSubModelGetterAndSetter(listSubModelQuery));
		
		return modelType;
	}
	
	public static ModelDto loadData(ModelInputDto modelInputDto,BuildSetting buildSetting){
		
		ModelDto modelType = new ModelDto();
		
		{
        	String name = modelInputDto.getName_model();
        	modelType.setNameModel(name);
        	modelType.setNameCriteria(name+"Criteria");
        	modelType.setNameMapper(name+"Mapper");
        	modelType.setNameXmlMapper(name+"Mapper");
        }
        
        {
        	
        	String namespace = buildSetting.getModel_path().replace("src/main/java/", "");
        	namespace = namespace.replace("src\\main\\java\\", "");
        	
        	namespace = namespace.replace("/", ".");
        	namespace = namespace.replace("\\", ".");
        	
        	modelType.setPackageModel(namespace);
        	
        	namespace = namespace + "." + modelType.getNameModel();
        	modelType.setNamespaceModel(namespace);
        	
        	
        }
        
        {
        	
        	String namespace = buildSetting.getCriteria_path().replace("src/main/java/", "");
        	namespace = namespace.replace("src\\main\\java\\", "");
        	
        	namespace = namespace.replace("/", ".");
        	namespace = namespace.replace("\\", ".");
        	
        	modelType.setPackageCriteria(namespace);
        	
        	namespace = namespace + "." + modelType.getNameCriteria();
        	modelType.setNamespaceCriteria(namespace);
        }
        
        {
        	
        	String namespace = buildSetting.getMapper_path().replace("src/main/java/", "");
        	namespace = namespace.replace("src\\main\\java\\", "");
        	
        	namespace = namespace.replace("/", ".");
        	namespace = namespace.replace("\\", ".");
        	
        	modelType.setPackageMapper(namespace);
        	
        	namespace = namespace + "." + modelType.getNameMapper();
        	modelType.setNamespaceMapper(namespace);
        }

		{
			
			String namespace = buildSetting.getXml_path().replace("src/main/resources/", "");
			namespace = namespace.replace("src\\main\\resources\\", "");
			
			namespace = namespace.replace("/", ".");
			namespace = namespace.replace("\\", ".");
			
			modelType.setPackageXmlMapper(namespace);
			
			namespace = namespace + "." + modelType.getNameXmlMapper();
			modelType.setNamespaceXmlMapper(namespace);
		}
		
		return modelType;
	}
	
	public static String generarAtributos(List<PropertyDto> params, String tipoIO){
		
		String atributos = "";
		
		for(PropertyDto param : params){
			if(param.getType().equals(tipoIO)){
				
				if(ConstanUtil.OUT.equals(tipoIO)){
					if(!isIgnoreConlumn(param.getName())){
						DataTypeDto dataTypeDto = ConstanUtil.findByNameDataType(param.getData_type());
						atributos += "	private "+dataTypeDto.getNamespace()+" "+param.getName()+"; \n";
					}	
				}else{
					DataTypeDto dataTypeDto = ConstanUtil.findByNameDataType(param.getData_type());
					atributos += "	private "+dataTypeDto.getNamespace()+" "+param.getName()+"; \n";
				}
				
			}
		}
		
		return atributos;
	}
	
	public static String generarSubModelAtributos(List<SubModelQuery> params){
		
		String atributos = "";
		
		for(SubModelQuery param : params){
			atributos += "	private java.util.List<"+param.getName_model()+"> list"+param.getName_model()+"; \n";
		}
		
		return atributos;
	}
	

	public static String generarGetterAndSetter(List<PropertyDto> params, String tipoIO){

		String gettSetter = "";
		for(PropertyDto param : params){
			if(param.getType().equals(tipoIO)){
				
				if(ConstanUtil.OUT.equals(tipoIO)){
					if(!isIgnoreConlumn(param.getName())){
						DataTypeDto dataTypeDto = ConstanUtil.findByNameDataType(param.getData_type());
						gettSetter += "	public "+dataTypeDto.getNamespace()+" get"+getNombreMetodo(param.getName())+"() { \n";
						gettSetter += "	  return "+param.getName()+"; \n";
						gettSetter += "	} \n";
						
						gettSetter += "	public void set"+getNombreMetodo(param.getName())+"("+dataTypeDto.getNamespace()+" "+param.getName()+") { \n";
						gettSetter += "	  this."+param.getName()+" = "+param.getName()+"; \n";
						gettSetter += "	} \n";
					}	
				}else{
					DataTypeDto dataTypeDto = ConstanUtil.findByNameDataType(param.getData_type());
					gettSetter += "	public "+dataTypeDto.getNamespace()+" get"+getNombreMetodo(param.getName())+"() { \n";
					gettSetter += "	  return "+param.getName()+"; \n";
					gettSetter += "	} \n";
					
					gettSetter += "	public void set"+getNombreMetodo(param.getName())+"("+dataTypeDto.getNamespace()+" "+param.getName()+") { \n";
					gettSetter += "	  this."+param.getName()+" = "+param.getName()+"; \n";
					gettSetter += "	} \n";
				}
				
				
			}
		}
		
		return gettSetter;
	}
	
	public static String generarSubModelGetterAndSetter(List<SubModelQuery> params){

		String gettSetter = "";
		for(SubModelQuery param : params){

					gettSetter += "	public java.util.List<"+param.getName_model()+"> get"+getNombreMetodo("list"+param.getName_model())+"() { \n";
					gettSetter += "	  return "+"list"+param.getName_model()+"; \n";
					gettSetter += "	} \n";
					
					gettSetter += "	public void set"+getNombreMetodo("list"+param.getName_model())+"(java.util.List<"+param.getName_model()+"> "+"list"+param.getName_model()+") { \n";
					gettSetter += "	  this."+"list"+param.getName_model()+" = "+"list"+param.getName_model()+"; \n";
					gettSetter += "	} \n";

		}
		
		return gettSetter;
	}
	
	public static String getNombreMetodo(String nombreMetodo){
		return nombreMetodo.substring(0, 1).toUpperCase() + nombreMetodo.substring(1, nombreMetodo.length());
	}
	
	public static boolean isIgnoreConlumn(String name){
		for (String val : ConstanUtil.IGNORE_COLUMNS) {
			if(val.equals(name)){
				return true;
			}
		}
		return false;
	}
	
	public static void createFile(String nombre, String contenido) {
        try {
        	
            String fileName = nombre;
            BufferedWriter bw = new BufferedWriter
                (new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8"));
            
            bw.write(contenido);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
