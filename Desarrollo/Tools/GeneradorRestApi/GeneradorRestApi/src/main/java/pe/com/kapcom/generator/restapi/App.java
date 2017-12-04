package pe.com.kapcom.generator.restapi;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pe.com.jrtotem.app.generator.jaxb.ModelType;
import pe.com.jrtotem.app.generator.jaxb.PropertyType;
import pe.com.jrtotem.app.generator.util.PropUtil;
import pe.com.kapcom.generator.bean.ConfigBean;
import pe.com.kapcom.generator.bean.CrudBean;
import pe.com.kapcom.generator.bean.DetailCrudBean;
import pe.com.kapcom.generator.bean.SubModelBean;

public class App {
	static ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	static VelocityEngine velocityEngine = (VelocityEngine) ctx.getBean("velocityEngine");
	static ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException, JAXBException {
		String folder;
		String fileJson;

		if (args.length == 0) {
			imprimirGuia();
			return;
		}

		folder = args[0];
		fileJson = args[1];

		String pathJsonConfig = "workspaces/" + folder + "/" + fileJson;

		File json = new File(pathJsonConfig);

		if (!json.exists()) {
			System.out.println("Error: No existe el archivo de configuración.");
			imprimirGuia();
			return;
		}

		ConfigBean configBean = mapper.readValue(new File(pathJsonConfig), ConfigBean.class);
		//
		String pathDefault = "workspaces/" + folder + "/" + "configDefault.properties";
		
		configBean.setPathSrc(PropUtil.getInstance().getPropVal(pathDefault, "pathSrc")); 
		configBean.setPackageService(PropUtil.getInstance().getPropVal(pathDefault, "packageService"));
		configBean.setPackageImplement(PropUtil.getInstance().getPropVal(pathDefault, "packageImplement"));
		configBean.setPackageRest(PropUtil.getInstance().getPropVal(pathDefault, "packageRest"));
		configBean.setPackageRepository(PropUtil.getInstance().getPropVal(pathDefault, "packageRepository"));
		

		if (fileJson == null) {
			System.out.println("Error: formato json no valido.");
			return;
		}

		String pathXml = "workspaces/"+folder+"/"+configBean.getNameModelXml();
		
		File xml = new File(pathXml);
		
		JAXBContext jc = JAXBContext.newInstance(ModelType.class.getPackage().getName());
        Unmarshaller u = jc.createUnmarshaller();
        JAXBElement<ModelType> element = (JAXBElement<ModelType>) u.unmarshal(xml);
        ModelType modelType = element.getValue();
        
        CrudBean crudBean = new CrudBean();
        crudBean.setNameCrud(configBean.getNameCrud());
        crudBean.setPath(configBean.getPath());
        crudBean.setPropertyId(buscarPropertyId(modelType));
        crudBean.setPackageService(configBean.getPackageService());
        crudBean.setPackageImplement(configBean.getPackageImplement());
        crudBean.setPackageRepository(configBean.getPackageRepository());
        crudBean.setPackageModel(modelType.getPackageModel());
        crudBean.setPackageMapper(modelType.getPackageMapper());
        crudBean.setPackageRest(configBean.getPackageRest());
        crudBean.setNameModel(modelType.getNameModel());
        crudBean.setNameModelCriteria(modelType.getNameCriteria());
        crudBean.setNameModelMapper(modelType.getNameMapper());
        crudBean.setNameRepository(configBean.getNameRepository());
        
        if(modelType.getSubModels().getSubModel()!= null && !modelType.getSubModels().getSubModel().isEmpty()){
        	
        	for(SubModelBean smb : configBean.getSubModels()){
        		
        		DetailCrudBean detailCrudBean = new DetailCrudBean();
        		ModelType sm = buscarSubModel(modelType, smb.getNameSubModel());
        		
        		if(sm == null){
        			System.out.println("No se encontro sub model: "+ smb.getNameSubModel());
        			return;
        		}
        		
        		{
        	        CrudBean crud = new CrudBean();
        	        crud.setPropertyId(buscarPropertyIdSubModels(modelType, smb.getNameSubModel()));
        	        crud.setNameCrud(smb.getNameCrud());
        	        crud.setPackageService(configBean.getPackageService());
        	        crud.setPackageImplement(configBean.getPackageImplement());
        	        crud.setPackageRepository(configBean.getPackageRepository());
        	        crud.setPackageModel(sm.getPackageModel());
        	        crud.setPackageMapper(sm.getPackageMapper());
        	        crud.setPackageRest(configBean.getPackageRest());
        	        crud.setNameModel(sm.getNameModel());
        	        crud.setNameModelCriteria(sm.getNameCriteria());
        	        crud.setNameModelMapper(sm.getNameMapper());
        	        crud.setNameRepository(smb.getNameRepository());
        	        detailCrudBean.setCrudBean(crud);
        		}
        		
        		detailCrudBean.setNamePropertyList("list"+sm.getName());
        		detailCrudBean.setNameCrud(smb.getNameCrud());
        		detailCrudBean.setPropertyId(buscarPropertyIdSubModels(modelType, smb.getNameSubModel()));
        		
        		List<DetailCrudBean> details = crudBean.getDetails();
        		if(details == null){
        			details = new ArrayList<>();
        		}
        		
        		details.add(detailCrudBean);
        		crudBean.setDetails(details);
        		
        	}
        }
        
        Map<String, Object> crudMap = mapper.convertValue(crudBean, Map.class);
        
        velocityEngine.init();
		
		VelocityContext velocityContext = new VelocityContext();
		setDefault(velocityContext);
		
		for (Map.Entry<String, Object> entry : crudMap.entrySet()) {
			velocityContext.put(entry.getKey(), entry.getValue());			
		}
		
		//Service
		{
			StringWriter stringWriter = new StringWriter();
			Template template = null;
			
			template = velocityEngine.getTemplate("template/service.vm", "UTF-8");
				
			template.merge(velocityContext, stringWriter);
			
			String pathPackages = configBean.getPackageService().replace(".", "/");
			
			String pathFileJava = configBean.getPathSrc()+"/"+pathPackages+"/"+crudBean.getNameCrud()+"Service"+".java";

			Files.write(Paths.get(pathFileJava), stringWriter.toString().getBytes());
			System.out.println("Writer file: "+pathFileJava);
		}
		
		//Implement
		{
			StringWriter stringWriter = new StringWriter();
			Template template = null;
			
			if(crudBean.getDetails() != null && !crudBean.getDetails().isEmpty()){
				template = velocityEngine.getTemplate("template/implMasterDetail.vm", "UTF-8");	
			}else{
				template = velocityEngine.getTemplate("template/implSimple.vm", "UTF-8");
			}
			
			template.merge(velocityContext, stringWriter);
			
			String pathPackages = configBean.getPackageImplement().replace(".", "/");
			
			String pathFileJava = configBean.getPathSrc()+"/"+pathPackages+"/"+crudBean.getNameCrud()+"ServiceImpl"+".java";

			Files.write(Paths.get(pathFileJava), stringWriter.toString().getBytes());
			System.out.println("Writer file: "+pathFileJava);
		}
		
		//submodel
		if(crudBean.getDetails()!=null){
			for(DetailCrudBean d : crudBean.getDetails()){
				CrudBean c = d.getCrudBean();
				Map<String, Object> cm = mapper.convertValue(c, Map.class);
				VelocityContext v2 = new VelocityContext();
				setDefault(v2);
				
				for (Map.Entry<String, Object> entry : cm.entrySet()) {
					v2.put(entry.getKey(), entry.getValue());			
				}
				//Service
				{
					
					StringWriter stringWriter = new StringWriter();
					Template template = null;
					
					template = velocityEngine.getTemplate("template/service.vm", "UTF-8");
						
					template.merge(v2, stringWriter);
					
					String pathPackages = configBean.getPackageService().replace(".", "/");
					
					String pathFileJava = configBean.getPathSrc()+"/"+pathPackages+"/"+c.getNameCrud()+"Service"+".java";

					Files.write(Paths.get(pathFileJava), stringWriter.toString().getBytes());
					System.out.println("Writer file: "+pathFileJava);
				}
				//Implement
				{
					StringWriter stringWriter = new StringWriter();
					Template template = null;
					
					template = velocityEngine.getTemplate("template/implSimple.vm", "UTF-8");
					
					template.merge(v2, stringWriter);
					
					String pathPackages = configBean.getPackageImplement().replace(".", "/");
					
					String pathFileJava = configBean.getPathSrc()+"/"+pathPackages+"/"+c.getNameCrud()+"ServiceImpl"+".java";

					Files.write(Paths.get(pathFileJava), stringWriter.toString().getBytes());
					System.out.println("Writer file: "+pathFileJava);
				}
			}	
		}
		
        
		//Rest
		{
			StringWriter stringWriter = new StringWriter();
			Template template = null;
			
			if(crudBean.getDetails() != null && !crudBean.getDetails().isEmpty()){
				template = velocityEngine.getTemplate("template/restMasterDetail.vm", "UTF-8");	
			}else{
				template = velocityEngine.getTemplate("template/restSimple.vm", "UTF-8");
			}
			
			template.merge(velocityContext, stringWriter);
			
			String pathPackages = configBean.getPackageRest().replace(".", "/");
			
			String pathFileJava = configBean.getPathSrc()+"/"+pathPackages+"/"+crudBean.getNameCrud()+"RestController"+".java";

			Files.write(Paths.get(pathFileJava), stringWriter.toString().getBytes());
			System.out.println("Writer file: "+pathFileJava);
		}

	}

	public static void imprimirGuia() {
		System.out.println("******************");
		System.out.println("Ingrese los parametros necesarios:");
		System.out.println("(1) Carpeta donde se guardan los archivos de configuración *.json");
		System.out.println("(2) nombre del archivo .json");
		System.out.println("Ejemplo: GeneradorRestApi negotium catalogo.json");
		System.out.println("******************");
	}
	public static String buscarPropertyId(ModelType modelType){
		if(modelType.getOutputProperties().getProperty()!=null || !modelType.getOutputProperties().getProperty().isEmpty()){
			PropertyType propertyType = modelType.getOutputProperties().getProperty().get(0);
			return propertyType.getName();
		}
		return null;
	}
	public static String buscarPropertyIdSubModels(ModelType modelType, String nameSubModel){
		for(ModelType subModel : modelType.getSubModels().getSubModel()){
			if(subModel.getName().equals(nameSubModel)){
				if(subModel.getOutputProperties().getProperty()!=null || !subModel.getOutputProperties().getProperty().isEmpty()){
					PropertyType propertyType = subModel.getOutputProperties().getProperty().get(0);
					return propertyType.getName();
				}
			}
		}
		return null;
	}
	public static ModelType buscarSubModel(ModelType modelType, String name){
		for(ModelType sm : modelType.getSubModels().getSubModel()){
			if(sm.getName().equals(name)){
				return sm;
			}
		}
		return null;
	}
	public static String getCopy(VelocityEngine velocityEngine, VelocityContext velocityContext, String pathTemplate) {
		StringWriter stringWriter = new StringWriter();
		Template template = null;
		template = velocityEngine.getTemplate(pathTemplate, "UTF-8");
		template.merge(velocityContext, stringWriter);
		return stringWriter.toString();
	}
	public static void setDefault(VelocityContext velocityContext) {
		SimpleDateFormat formateador;
		String datetimeCreate;
		Integer anho;

		formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		datetimeCreate = formateador.format(new Date());
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		anho = c.get(Calendar.YEAR);

		velocityContext.put("datetimeCreate", datetimeCreate);
		velocityContext.put("anho", anho.toString());
		velocityContext.put("copy", getCopy(velocityEngine, velocityContext, "template/copy.vm"));
	}
}
