package com.sakerk.generador.definition;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.sakerk.generador.schema.Query;
import com.sakerk.generador.schema.QueryGenerator;
import com.sakerk.generador.schema.Target;

public class GeneradorUtil {
	
	public String generarQuery(QueryGenerador query){
		return this.generarJavaClassAndInterface(query);
	}
	
	public String generarJavaClassAndInterface(QueryGenerador query){
		String classQuery = "package "+query.getPackageDto()+"; \n\n";
			   classQuery += "public class "+query.getNombreQuery()+" implements java.io.Serializable { \n\n";
			   classQuery += "private static final long serialVersionUID = 1L;";
			   classQuery += "\n";
			   classQuery += this.generarAtributos(query.getParametros(), Constantes.OUT);
			   classQuery += "\n";
			   classQuery += this.generarGetterAndSetter(query.getParametros(), Constantes.OUT);
			   classQuery += "\n";
			   classQuery += "} \n";
			   
		String classCriteria = "package "+query.getPackageDto()+"; \n\n";
			   classCriteria += "public class "+query.getNombreQuery()+"Criteria { \n\n";
			   
			   classCriteria += "private String orderColumn;\n";
			   classCriteria += "private String orderDirecction;\n";
			   
			   classCriteria += this.generarAtributos(query.getParametros(), Constantes.INPUT);
			   classCriteria += "\n";
			   
			   classCriteria += "public "+query.getNombreQuery()+"Criteria() {\n";
			   classCriteria += "this.orderColumn = \"1\";\n";
			   classCriteria += "this.orderDirecction = \"ASC\";\n";
			   classCriteria += "}\n";
			   
			   classCriteria += this.generarGetterAndSetter(query.getParametros(), Constantes.INPUT);
			  
			   classCriteria += "public String getOrderColumn() {\n";
			   classCriteria += "return orderColumn;\n";
			   classCriteria += "}\n";
			   
			   classCriteria += "public void setOrderColumn(String orderColumn) {\n";
			   classCriteria += "this.orderColumn = orderColumn;\n";
			   classCriteria += "}\n";
			   
			   classCriteria += "public String getOrderDirecction() {\n";
			   classCriteria += "return orderDirecction;\n";
			   classCriteria += "}\n";
			   
			   classCriteria += "public void setOrderDirecction(String orderDirecction) {\n";
			   classCriteria += "this.orderDirecction = orderDirecction;\n";
			   classCriteria += "}\n";
			   
			   classCriteria += "\n";
			   classCriteria += "} \n";


		 String classInterface = "package "+query.getPackageDao()+"; \n\n";
				classInterface += "import java.util.List; \n";
				classInterface += "import java.util.Map; \n";
				classInterface += "import org.apache.ibatis.session.RowBounds; \n";
				classInterface += "import "+query.getPackageDto()+"."+query.getNombreQuery()+"; \n";
				classInterface += "import "+query.getPackageDto()+"."+query.getNombreQuery()+"Criteria; \n\n";
				classInterface += "public interface "+query.getNombreQuery()+"Mapper { \n";
				classInterface += "   List<"+query.getNombreQuery()+"> getListQueryByCriteria("+query.getNombreQuery()+"Criteria criteria); \n";
				classInterface += "   List<"+query.getNombreQuery()+"> getListQueryByMap(Map<String, Object> paramMap); \n";
				classInterface += "   List<"+query.getNombreQuery()+"> getListQueryPaginationByCriteria("+query.getNombreQuery()+"Criteria criteria, RowBounds rowBounds); \n";
				classInterface += "   List<"+query.getNombreQuery()+"> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); \n";
				classInterface += "   int getCountRowsByCriteria("+query.getNombreQuery()+"Criteria criteria); \n";
				classInterface += "   int getCountRowsByMap(Map<String, Object> paramMap); \n";
				classInterface += "} \n";
				
			String mapperXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";
			mapperXml += "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" > \n";
			mapperXml += "<mapper namespace=\""+query.getPackageDao()+"."+query.getNombreQuery()+"Mapper\"> \n\n";
			
			mapperXml += "<sql id=\"outs\"> \n";
			mapperXml +="<![CDATA[\n";
			mapperXml += query.getOutput() + "\n";
			mapperXml +="]]>\n";
			mapperXml += "</sql> \n\n";
			
			mapperXml += "<sql id=\"from\"> \n";
			mapperXml +="<![CDATA[\n";
			mapperXml += query.getFrom() + "\n";
			mapperXml +="]]>\n";
			mapperXml += "</sql> \n\n";
			
			mapperXml += "<sql id=\"inputs\"> \n";
			mapperXml +="<![CDATA[\n";
			mapperXml += query.getInput() + "\n";
			mapperXml +="]]>\n";
			mapperXml += "</sql> \n\n";
			
			mapperXml += "<sql id=\"order\"> \n";
			mapperXml +="<![CDATA[\n";
			mapperXml +="ORDER BY ${orderColumn} ${orderDirecction}\n";
			mapperXml +="]]>\n";
			mapperXml += "</sql> \n\n";
			
			mapperXml += "<select id=\"getListQueryByCriteria\" resultType=\""+query.getPackageDto()+"."+query.getNombreQuery()+"\" parameterType=\""+query.getPackageDto()+"."+query.getNombreQuery()+"Criteria\"> \n";
			mapperXml += "select \n";
			mapperXml += "<include refid=\"outs\" /> \n";
			mapperXml += "from \n";
			mapperXml += "<include refid=\"from\" /> \n";
			mapperXml += "where \n";
			mapperXml += "<include refid=\"inputs\" /> \n";
			mapperXml += "<include refid=\"order\" /> \n";
			mapperXml += "</select> \n\n";
			
			mapperXml += "<select id=\"getListQueryByMap\" resultType=\""+query.getPackageDto()+"."+query.getNombreQuery()+"\" parameterType=\"java.util.Map\"> \n";
			mapperXml += "select \n";
			mapperXml += "<include refid=\"outs\" /> \n";
			mapperXml += "from \n";
			mapperXml += "<include refid=\"from\" /> \n";
			mapperXml += "where \n";
			mapperXml += "<include refid=\"inputs\" /> \n";
			mapperXml += "<include refid=\"order\" /> \n";
			mapperXml += "</select> \n\n";
			
			mapperXml += "<select id=\"getListQueryPaginationByCriteria\" resultType=\""+query.getPackageDto()+"."+query.getNombreQuery()+"\" parameterType=\""+query.getPackageDto()+"."+query.getNombreQuery()+"Criteria\"> \n";
			mapperXml += "select \n";
			mapperXml += "<include refid=\"outs\" /> \n";
			mapperXml += "from \n";
			mapperXml += "<include refid=\"from\" /> \n";
			mapperXml += "where \n";
			mapperXml += "<include refid=\"inputs\" /> \n";
			mapperXml += "<include refid=\"order\" /> \n";
			mapperXml += "</select> \n\n";
			
			mapperXml += "<select id=\"getListQueryPaginationByMap\" resultType=\""+query.getPackageDto()+"."+query.getNombreQuery()+"\" parameterType=\"java.util.Map\"> \n";
			mapperXml += "select \n";
			mapperXml += "<include refid=\"outs\" /> \n";
			mapperXml += "from \n";
			mapperXml += "<include refid=\"from\" /> \n";
			mapperXml += "where \n";
			mapperXml += "<include refid=\"inputs\" /> \n";
			mapperXml += "<include refid=\"order\" /> \n";
			mapperXml += "</select> \n\n";
			
			mapperXml += "<select id=\"getCountRowsByCriteria\" resultType=\"java.lang.Integer\" parameterType=\""+query.getPackageDto()+"."+query.getNombreQuery()+"Criteria\"> \n";
			mapperXml += "select \n";
			mapperXml += "count(*) \n";
			mapperXml += "from \n";
			mapperXml += "<include refid=\"from\" /> \n";
			mapperXml += "where \n";
			mapperXml += "<include refid=\"inputs\" /> \n";
			mapperXml += "</select> \n\n";
			
			mapperXml += "<select id=\"getCountRowsByMap\" resultType=\"java.lang.Integer\" parameterType=\"java.util.Map\"> \n";
			mapperXml += "select \n";
			mapperXml += "count(*) \n";
			mapperXml += "from \n";
			mapperXml += "<include refid=\"from\" /> \n";
			mapperXml += "where \n";
			mapperXml += "<include refid=\"inputs\" /> \n";
			mapperXml += "</select> \n\n";
			
			mapperXml += "</mapper> \n";
			
			String classWrapperQuery = "";
			String classWrapperQueryCriteria = "";
			if(query.getTipoQuery().intValue() == Constantes.TIPO_QUERY_SPRINGMVCCRUD){
				classWrapperQuery = "package "+query.getPackageDto()+"; \n\n";
				classWrapperQuery += "public class "+query.getNombreQuery()+"Wrapper { \n\n";
				classWrapperQuery += "private "+query.getNombreQuery()+" data;\n";
				classWrapperQuery += "public "+query.getNombreQuery()+" getData() {\n";
				classWrapperQuery += "return data;\n";
				classWrapperQuery += "}\n";
				classWrapperQuery += "public void setData("+query.getNombreQuery()+" data) {\n";
				classWrapperQuery += "this.data = data;\n";
				classWrapperQuery += "}\n";
				classWrapperQuery += "} \n";
				   
			   classWrapperQueryCriteria = "package "+query.getPackageDto()+"; \n\n";
			   classWrapperQueryCriteria += "public class "+query.getNombreQuery()+"CriteriaWrapper { \n\n";
			   classWrapperQueryCriteria += "private "+query.getNombreQuery()+"Criteria data;\n";
			   classWrapperQueryCriteria += "public "+query.getNombreQuery()+"Criteria getData() {\n";
			   classWrapperQueryCriteria += "return data;\n";
			   classWrapperQueryCriteria += "}\n";
			   classWrapperQueryCriteria += "public void setData("+query.getNombreQuery()+"Criteria data) {\n";
			   classWrapperQueryCriteria += "this.data = data;\n";
			   classWrapperQueryCriteria += "}\n";
			   classWrapperQueryCriteria += "} \n";
			}

			
					 
				 
		String rutaDao = query.getRutaSalidaJava()+"/"+query.getPackageDao().replace(".", "/")+"/"+query.getNombreQuery()+"Mapper.java";
		String rutaDto = query.getRutaSalidaJava()+"/"+query.getPackageDto().replace(".", "/")+"/"+query.getNombreQuery()+".java";
		String rutaDtoCriteria = query.getRutaSalidaJava()+"/"+query.getPackageDto().replace(".", "/")+"/"+query.getNombreQuery()+"Criteria.java";
		String rutaMapper = query.getRutaSalidaResources()+"/"+query.getPackageMapper().replace(".", "/")+"/"+query.getNombreQuery()+"Mapper.xml";
		
		String rutaDtoWrapper = null;
		String rutaDtoCriteriaWrapper = null;
		if(query.getTipoQuery().intValue() == Constantes.TIPO_QUERY_SPRINGMVCCRUD){
			 rutaDtoWrapper = query.getRutaSalidaJava()+"/"+query.getPackageDto().replace(".", "/")+"/"+query.getNombreQuery()+"Wrapper.java";
			 rutaDtoCriteriaWrapper = query.getRutaSalidaJava()+"/"+query.getPackageDto().replace(".", "/")+"/"+query.getNombreQuery()+"CriteriaWrapper.java";
		}
				//System.out.println(classQuery);
			   //System.out.println(classCriteria);
			   //System.out.println(classInterface);
			   //System.out.println(mapperXml);
			   
			   this.crearArchivo(rutaDto, classQuery);
			   this.crearArchivo(rutaDao, classInterface);
			   this.crearArchivo(rutaDtoCriteria, classCriteria);
			   this.crearArchivo(rutaMapper, mapperXml);
			   
			   if(query.getTipoQuery().intValue() == Constantes.TIPO_QUERY_SPRINGMVCCRUD){
				   this.crearArchivo(rutaDtoWrapper, classWrapperQuery);
				   this.crearArchivo(rutaDtoCriteriaWrapper, classWrapperQueryCriteria);
			   }
			   
			   System.out.println(rutaDao);
			   System.out.println(rutaDto);
			   System.out.println(rutaDtoCriteria);
			   System.out.println(rutaMapper);
			   
			   String textResponse = "";
			   textResponse = textResponse + rutaDao + "\n";
			   textResponse = textResponse + rutaDto + "\n";
			   textResponse = textResponse + rutaDtoCriteria + "\n";
			   textResponse = textResponse + rutaMapper + "\n";
			   
			   if(query.getTipoQuery().intValue() == Constantes.TIPO_QUERY_SPRINGMVCCRUD){
				   System.out.println(rutaDtoWrapper);
				   System.out.println(rutaDtoCriteriaWrapper);
				   textResponse = textResponse + rutaDtoWrapper + "\n";
				   textResponse = textResponse + rutaDtoCriteriaWrapper + "\n";
			   }
			   
			   
			   
			   return textResponse;
	}
	
	public String generarAtributos(List<ParametrosGenerador> params, String tipoIO){
		
		String atributos = "";
		
		for(ParametrosGenerador param : params){
			if(param.getTipoEntradaSalida().equals(tipoIO)){
				atributos += "private "+param.getTipoDato()+" "+param.getNombreParametro()+"; \n";
			}
		}
		
		return atributos;
	}
	

	public String generarGetterAndSetter(List<ParametrosGenerador> params, String tipoIO){

		String gettSetter = "";
		for(ParametrosGenerador param : params){
			if(param.getTipoEntradaSalida().equals(tipoIO)){
				gettSetter += "public "+param.getTipoDato()+" get"+this.getNombreMetodo(param.getNombreParametro())+"() { \n";
				gettSetter += "  return "+param.getNombreParametro()+"; \n";
				gettSetter += "} \n";
				
				gettSetter += "public void set"+this.getNombreMetodo(param.getNombreParametro())+"("+param.getTipoDato()+" "+param.getNombreParametro()+") { \n";
				gettSetter += "  this."+param.getNombreParametro()+" = "+param.getNombreParametro()+"; \n";
				gettSetter += "} \n";
				
			}
		}
		
		return gettSetter;
	}
	
	public String getNombreMetodo(String nombreMetodo){
		return nombreMetodo.substring(0, 1).toUpperCase() + nombreMetodo.substring(1, nombreMetodo.length());
	}
	public String getNombreMetodoLower(String nombreMetodo){
		return nombreMetodo.substring(0, 1).toLowerCase() + nombreMetodo.substring(1, nombreMetodo.length());
	}
	
	public void crearArchivo(String nombre, String contenido) {
        try {
        	
            String fileName = nombre;
            FileWriter fw;
            
            fw = new FileWriter(fileName);

            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
	
	public String generarParametros(List<ParametrosGenerador> params){
		
		String atributos = "";
		
		for(int i=0;i<params.size();i++){
			if(params.get(i).getTipoEntradaSalida().equals(Constantes.INPUT)){
					atributos += ", "+params.get(i).getTipoDato()+" "+params.get(i).getNombreParametro()+"";
					
			}
		}
		atributos = atributos.replaceFirst(",", "");
		atributos = atributos.replaceFirst(" ", "");
		return atributos;
	}

	public String generarSetterParametros(List<ParametrosGenerador> params){
		
		String atributos = "";
		
		for(int i=0;i<params.size();i++){
			if(params.get(i).getTipoEntradaSalida().equals(Constantes.INPUT)){
				atributos += "criteria.set"+this.getNombreMetodo(params.get(i).getNombreParametro())+"("+params.get(i).getNombreParametro()+"); \n";
			}
		}

		return atributos;
	}
	
	public List<QueryGenerador> parseQuery(JAXBElement<QueryGenerator> menuElement){
		
		
		List<QueryGenerador> querys = new ArrayList<QueryGenerador>();
		

		
		for(Query q: menuElement.getValue().getQuerys().getQuery()){
			
			if(q.isGenerate()){
				QueryGenerador query = new QueryGenerador();
				
				query.setNombreQuery(q.getName());
				
				for(Target t : menuElement.getValue().getConfigs().getTarget()){
					
					if(t.getType().equals("javaModelGenerator")){
						query.setPackageDto(t.getTargetPackage());
						query.setRutaSalidaJava(t.getTargetProject());
					}
					if(t.getType().equals("sqlMapGenerator")){
						query.setPackageMapper(t.getTargetPackage());
						query.setRutaSalidaResources(t.getTargetProject());
					}
					if(t.getType().equals("javaClientGenerator")){
						query.setPackageDao(t.getTargetPackage());
						query.setRutaSalidaJava(t.getTargetProject());
					}
				}
				
				List<ParametrosGenerador> parametros = new ArrayList<ParametrosGenerador>();
				
				String sql = q.getSql();
								
				int pos_begin_outs=sql.indexOf("@");
				int pos_end_outs=sql.indexOf("@",pos_begin_outs+1);
				
				int pos_begin_from=sql.indexOf("@",pos_end_outs+1);
				int pos_end_from=sql.indexOf("@",pos_begin_from+1);
				
				int pos_begin_inputs=sql.indexOf("@",pos_end_from+1);
				int pos_end_inputs=sql.indexOf("@",pos_begin_inputs+1);
						
				String outs = sql.substring(pos_begin_outs+1,pos_end_outs);
				String from = sql.substring(pos_begin_from+1,pos_end_from);
				String inputs = sql.substring(pos_begin_inputs+1,pos_end_inputs);
				
				

								
				query.setFrom(from);
				
				
				
				String[] arrOuts = outs.split(",\\r?\\n");
						
				for(String x:arrOuts){
					
					String out  = x.substring(x.indexOf(".")+1,x.length());
					 int pos_alias = (out.indexOf(" as ") != -1) ? out.indexOf(" as ") : out.indexOf(" AS ");
					 int pos_space = out.indexOf(" ");
					 ParametrosGenerador parametro = new ParametrosGenerador();
					 parametro.setTipoEntradaSalida((out.toUpperCase().indexOf("INPUT") != -1) ? Constantes.INPUT : Constantes.OUT);
					 
					 if(pos_alias != -1){
							int pos_begin_alias=out.indexOf("\"");
							int pos_end_alias=out.indexOf("\"",pos_begin_alias+1);
							String property = out.substring(pos_begin_alias+1,pos_end_alias);
											
							parametro.setNombreParametro(property);
							
							
					 }else{
						 if(pos_space == -1){
							 String property = out.substring(0,out.length());
								parametro.setNombreParametro(property);
						 }else{
							 String property = out.substring(0,pos_space);
								parametro.setNombreParametro(property); 
						 }
					 }
					 			 
					 if(out.toUpperCase().indexOf("#INTEGER") !=-1){
						 parametro.setTipoDato(Constantes.INTEGER);
					 }
					 if(out.toUpperCase().indexOf("#DOUBLE") !=-1){
						 parametro.setTipoDato(Constantes.DOUBLE);
					 }
					 if(out.toUpperCase().indexOf("#STRING") !=-1){
						 parametro.setTipoDato(Constantes.STRING);
					 }
					 if(out.toUpperCase().indexOf("#BYTE") !=-1){
						 parametro.setTipoDato(Constantes.BYTE);
					 }
					 if(out.toUpperCase().indexOf("#DATE") !=-1){
						 parametro.setTipoDato(Constantes.DATE);
					 }
					 if(parametro.getTipoDato() == null){
						 parametro.setTipoDato(Constantes.STRING);
					 }
					 
					 parametros.add(parametro);
				}
				
				int pos_start_input = inputs.indexOf("#");
				int pos_start_key = pos_start_input + 2;
				int post_end_key = inputs.indexOf("}", pos_start_key);
				pos_start_input = post_end_key;
				
				while (pos_start_input>0) {
					String[] arrIn = inputs.substring(pos_start_key,post_end_key).split("&");
					ParametrosGenerador parametro = new ParametrosGenerador();
					parametro.setNombreParametro(arrIn[0].trim());
					parametro.setTipoEntradaSalida(Constantes.INPUT);
					
					 if(arrIn[1].indexOf("#INTEGER") !=-1){
						 parametro.setTipoDato(Constantes.INTEGER);
					 }
					 if(arrIn[1].indexOf("#DOUBLE") !=-1){
						 parametro.setTipoDato(Constantes.DOUBLE);
					 }
					 if(arrIn[1].indexOf("#STRING") !=-1){
						 parametro.setTipoDato(Constantes.STRING);
					 }
					 if(arrIn[1].indexOf("#BYTE") !=-1){
						 parametro.setTipoDato(Constantes.BYTE);
					 }
					 if(arrIn[1].indexOf("#DATE") !=-1){
						 parametro.setTipoDato(Constantes.DATE);
					 }
					 if(parametro.getTipoDato() == null){
						 parametro.setTipoDato(Constantes.STRING);
					 }

					 parametros.add(parametro);

//					 query.setParametros(parametros);
					
					pos_start_input = inputs.indexOf("#",pos_start_input);
					if(pos_start_input>0){
						pos_start_key = pos_start_input + 2;
						post_end_key = inputs.indexOf("}", pos_start_key);
						pos_start_input = post_end_key;
					}
					
					
				}
				outs = outs.replaceAll("OUT", "");
				String[] datatypes = {"#INTEGER","#DOUBLE","#STRING","#BYTE","#DATE"};
				for(String x:datatypes){
					outs = outs.replaceAll(x, "");
				}
				for(String x:datatypes){
					inputs = inputs.replaceAll(x, "");
				}
				inputs = inputs.replaceAll("&", "");
				inputs = inputs.replaceAll(";", "");
				query.setInput(inputs);
				query.setOutput(outs);
				querys.add(query);
				query.setParametros(parametros);
			}
			

		}
		
		return querys;
	}
	@SuppressWarnings("unchecked")
	public void loadXml(String fileXml) throws JAXBException {

            JAXBContext jc = JAXBContext.newInstance(QueryGenerator.class.getPackage().getName());
            Unmarshaller u = jc.createUnmarshaller();
            JAXBElement<QueryGenerator> menuElement = (JAXBElement<QueryGenerator>)u.unmarshal(GeneradorUtil.class.getResourceAsStream("/"+fileXml));
            
            List<QueryGenerador> list = parseQuery(menuElement);
            
            for(QueryGenerador q : list){
        		this.generarQuery(q);
        		//System.out.println(q.getParametros().toString());
            }
	}
}
