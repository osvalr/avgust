package pe.com.kapcom.generator.gui.angularjs;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import pe.com.kapcom.generator.gui.angularjs.bean.ConfigBean;
import pe.com.kapcom.generator.gui.angularjs.bean.SubModelBean;
import pe.com.kapcom.generator.gui.angularjs.util.PropUtil;

public class App {
	static ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	static VelocityEngine velocityEngine = (VelocityEngine) ctx.getBean("velocityEngine");
	static ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) throws JAXBException, JsonParseException, JsonMappingException, IOException {
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

		if (fileJson == null) {
			System.out.println("Error: formato json no valido.");
			return;
		}

		String pathXml = "workspaces/" + folder + "/" + configBean.getNameModelXml();

		File xml = new File(pathXml);

		JAXBContext jc = JAXBContext.newInstance(ModelType.class.getPackage().getName());
		Unmarshaller u = jc.createUnmarshaller();
		JAXBElement<ModelType> element = (JAXBElement<ModelType>) u.unmarshal(xml);
		ModelType modelType = element.getValue();

		velocityEngine.init();

		VelocityContext velocityContext = new VelocityContext();
		setDefault(velocityContext);
		
		velocityContext.put("configBean", configBean);
		velocityContext.put("inputProperties", modelType.getInputProperties().getProperty());
		velocityContext.put("outputProperties", modelType.getOutputProperties().getProperty());
		velocityContext.put("propertyId", modelType.getOutputProperties().getProperty().get(0).getName());
		
		//
		String pathController = configBean.getPathSrc() + "/" + configBean.getNameCrud() + "/controllers/";
		String pathServices = configBean.getPathSrc() + "/" + configBean.getNameCrud() + "/services/"; 
		String pathViews = configBean.getPathSrc() + "/" + configBean.getNameCrud() + "/views/"; 
		
		if(modelType.getSubModels().getSubModel().isEmpty()){
			//SimpleController
			{
				StringWriter stringWriter = new StringWriter();
				Template template = null;
				
				template = velocityEngine.getTemplate("template/SimpleController.vm", "UTF-8");
					
				template.merge(velocityContext, stringWriter);
				
				String controllerJs = pathController+"MainController.js";
				
				Path path = Paths.get(pathController);
				Files.createDirectories(path);
				Files.write(Paths.get(controllerJs), stringWriter.toString().getBytes());
				System.out.println("Writer file: "+controllerJs);
			}
			
			//SimpleService
			{
				StringWriter stringWriter = new StringWriter();
				Template template = null;

				template = velocityEngine.getTemplate("template/SimpleService.vm", "UTF-8");

				template.merge(velocityContext, stringWriter);

				String serviceJs = pathServices + "MainService.js";

				Path path = Paths.get(pathServices);
				Files.createDirectories(path);
				Files.write(Paths.get(serviceJs), stringWriter.toString().getBytes());
				System.out.println("Writer file: " + serviceJs);
			}
			
			//SimpleView
			{
				StringWriter stringWriter = new StringWriter();
				Template template = null;

				template = velocityEngine.getTemplate("template/SimpleView.vm", "UTF-8");

				template.merge(velocityContext, stringWriter);

				String viewHtml = pathViews + "MainView.html";

				Path path = Paths.get(pathViews);
				Files.createDirectories(path);
				Files.write(Paths.get(viewHtml), stringWriter.toString().getBytes());
				System.out.println("Writer file: " + viewHtml);
			}
		}else{
			
			for(SubModelBean s : configBean.getSubModels()){
				ModelType subModel = buscarSubModel(modelType, s.getNameModel());
				if(subModel != null){
					s.setPropertyId(subModel.getOutputProperties().getProperty().get(0).getName());
					s.setInputs(subModel.getInputProperties().getProperty());
					s.setOutputs(subModel.getOutputProperties().getProperty());
				}
			}
			
			//ComplexController
			{
				StringWriter stringWriter = new StringWriter();
				Template template = null;
				
				template = velocityEngine.getTemplate("template/ComplexController.vm", "UTF-8");
					
				template.merge(velocityContext, stringWriter);
				
				String controllerJs = pathController+"MainController.js";
				
				Path path = Paths.get(pathController);
				Files.createDirectories(path);
				Files.write(Paths.get(controllerJs), stringWriter.toString().getBytes());
				System.out.println("Writer file: "+controllerJs);
			}
			
			for(SubModelBean s : configBean.getSubModels()){
				//SubModelController
				{
					VelocityContext velocitySm = new VelocityContext();
					setDefault(velocitySm);
					velocitySm.put("configBean", configBean);
					velocitySm.put("subModel", s);
					
					StringWriter stringWriter = new StringWriter();
					Template template = null;
					
					template = velocityEngine.getTemplate("template/SubModelController.vm", "UTF-8");
						
					template.merge(velocitySm, stringWriter);
					
					String controllerJs = pathController+s.getNameCrud()+"Controller.js";
					
					Path path = Paths.get(pathController);
					Files.createDirectories(path);
					Files.write(Paths.get(controllerJs), stringWriter.toString().getBytes());
					System.out.println("Writer file: "+controllerJs);
				}
			}
			
			//SimpleService
			{
				StringWriter stringWriter = new StringWriter();
				Template template = null;

				template = velocityEngine.getTemplate("template/SimpleService.vm", "UTF-8");

				template.merge(velocityContext, stringWriter);

				String serviceJs = pathServices + "MainService.js";

				Path path = Paths.get(pathServices);
				Files.createDirectories(path);
				Files.write(Paths.get(serviceJs), stringWriter.toString().getBytes());
				System.out.println("Writer file: " + serviceJs);
			}
			
			StringBuilder tabs= new StringBuilder();
			int index = 1;
			for(SubModelBean s : configBean.getSubModels()){
				//SubModelViews
				{
					VelocityContext velocitySm = new VelocityContext();
					setDefault(velocitySm);
					velocitySm.put("configBean", configBean);
					velocitySm.put("subModel", s);
					velocitySm.put("index", index);
					
					StringWriter stringWriter = new StringWriter();
					Template template = null;
					
					template = velocityEngine.getTemplate("template/TabView.vm", "UTF-8");
						
					template.merge(velocitySm, stringWriter);
					tabs.append(stringWriter.toString());
				}
				index++;
			}
			//View
			{
				List<String> sm = new ArrayList<>();
				
				for(SubModelBean s : configBean.getSubModels()){
					sm.add(s.getNameCrud());
				}
				
				velocityContext.put("tabs", tabs);
				velocityContext.put("nameSubmodels", sm);
				StringWriter stringWriter = new StringWriter();
				Template template = null;

				template = velocityEngine.getTemplate("template/ComplexView.vm", "UTF-8");

				template.merge(velocityContext, stringWriter);

				String viewHtml = pathViews + "MainView.html";

				Path path = Paths.get(pathViews);
				Files.createDirectories(path);
				Files.write(Paths.get(viewHtml), stringWriter.toString().getBytes());
				System.out.println("Writer file: " + viewHtml);
			}
		}
		
		

	}

	public static void imprimirGuia() {
		System.out.println("******************");
		System.out.println("Ingrese los parametros necesarios:");
		System.out.println("(1) Carpeta donde se guardan los archivos de configuración *.json");
		System.out.println("(2) nombre del archivo .json");
		System.out.println("Ejemplo: GeneradorGUIAngularJS negotium catalogo.json");
		System.out.println("******************");
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
	public static String getCopy(VelocityEngine velocityEngine, VelocityContext velocityContext, String pathTemplate) {
		StringWriter stringWriter = new StringWriter();
		Template template = null;
		template = velocityEngine.getTemplate(pathTemplate, "UTF-8");
		template.merge(velocityContext, stringWriter);
		return stringWriter.toString();
	}
	public static ModelType buscarSubModel(ModelType modelType, String name){
		for(ModelType sm : modelType.getSubModels().getSubModel()){
			if(sm.getName().equals(name)){
				return sm;
			}
		}
		return null;
	}
}
