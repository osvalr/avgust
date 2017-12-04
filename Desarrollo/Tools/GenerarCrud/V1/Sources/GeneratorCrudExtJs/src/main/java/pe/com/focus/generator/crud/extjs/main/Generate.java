package pe.com.focus.generator.crud.extjs.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;

import pe.com.focus.generator.crud.extjs.bean.ColumnGridPanelBean;
import pe.com.focus.generator.crud.extjs.bean.EntityBean;
import pe.com.focus.generator.crud.extjs.bean.FieldBean;
import pe.com.focus.generator.crud.extjs.bean.SortBean;
import pe.com.focus.generator.crud.extjs.bean.SubModelBean;
import pe.com.focus.generator.crud.extjs.jaxb.ModelType;
import pe.com.focus.generator.crud.extjs.jaxb.PropertyType;
import pe.com.focus.generator.crud.extjs.mybatis.mapper.InfoColumnsMysqlQueryMapper;
import pe.com.focus.generator.crud.extjs.mybatis.model.InfoColumnsMysqlQuery;
import pe.com.focus.generator.crud.extjs.mybatis.model.InfoColumnsMysqlQueryCriteria;
import pe.com.focus.generator.crud.extjs.schema.Controller;
import pe.com.focus.generator.crud.extjs.schema.Crud;
import pe.com.focus.generator.crud.extjs.schema.Entity;
import pe.com.focus.generator.crud.extjs.schema.Listener;
import pe.com.focus.generator.crud.extjs.schema.Model;
import pe.com.focus.generator.crud.extjs.schema.ParameterStore;
import pe.com.focus.generator.crud.extjs.schema.Property;
import pe.com.focus.generator.crud.extjs.schema.Service;
import pe.com.focus.generator.crud.extjs.schema.SubModel;
import pe.com.focus.generator.crud.extjs.util.GeneratorObject;
import pe.com.focus.generator.crud.extjs.util.PropUtil;

public class Generate {
	
	@Autowired
	private VelocityEngine velocityEngine;
	
	@Autowired
	private InfoColumnsMysqlQueryMapper infoColumnsMysqlQueryMapper;
	
	private SimpleDateFormat formateador;
	private String datetimeCreate;
	private Integer anho;
	private String pathTemplate;
        private String stringOutput;
	
	public String loadConfig(JAXBElement<Crud> menuElement) throws ClassNotFoundException, MalformedURLException{

		stringOutput = "";
		velocityEngine.setProperty("resource.loader", "class");
		velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		velocityEngine.init();
		
		 formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		 datetimeCreate = formateador.format(new Date());
		 Calendar c = Calendar.getInstance();
		 c.setTime(new Date());
		 anho = c.get(Calendar.YEAR);
		 
		 if(menuElement.getValue().getModel().getBackend().getController().getTypeFw() == null){
			 menuElement.getValue().getModel().getBackend().getController().setTypeFw("struts2");
		 }
		 
		 pathTemplate = menuElement.getValue().getPathTemplate();
		 
		 if(pathTemplate == null){
			 pathTemplate = "template/";
		 }else{
			 pathTemplate = "template/"+pathTemplate+"/";
		 }
		 
         Model model = menuElement.getValue().getModel();
         
         if(model.getSubModels() == null || model.getSubModels().getSubModel().isEmpty()){
        	 
        	this.createService(menuElement);
     		this.createServiceImpl(menuElement);
    		this.createController(menuElement);
    		this.createControllerExtJs(menuElement);
    		
         }else{
        	 
        	this.createServiceWithSubModel(menuElement);
        	this.createServiceImplWithSubModel(menuElement);
        	this.createControllerWithSubModel(menuElement);
        	this.createControllerExtJsWithSubModel(menuElement);
    		this.createSubModelExtJs(menuElement);
    		
         }
         
         this.createStoreExtJs(menuElement);
         this.createModelExtJs(menuElement);
 		 this.createFormFilterExtJs(menuElement);
          
                 return stringOutput;
	}
	
	public void createService(JAXBElement<Crud> menuElement){
		
		  Crud crud = menuElement.getValue();
          Model model = menuElement.getValue().getModel();
          Service service = model.getBackend().getService();
          VelocityContext velocityContext = new VelocityContext();
          StringWriter stringWriter = new StringWriter();
          String nombre;
          
          if(crud.isGenerateServiceBackEnd()){
        		  
        		  Template template = null;
        		  
        		  if(crud.getType() != null){
        			  if(crud.getType().equals("function")){
        				  template = velocityEngine.getTemplate(pathTemplate+"ServiceMybatisFunction.vm", "UTF-8");
            		  }else{
            			  template = velocityEngine.getTemplate(pathTemplate+"ServiceMybatisSimple.vm", "UTF-8");
            		  }
        		  }else{
        			  template = velocityEngine.getTemplate(pathTemplate+"ServiceMybatisSimple.vm", "UTF-8");
        		  }

        		  String nameService = (service.getNameService() == null) ? crud.getName() : service.getNameService();
                          
          		  velocityContext.put("datetimeCreate", datetimeCreate);
        		  velocityContext.put("anho", anho.toString());
        		  velocityContext.put("nameApp", crud.getNameApp());
        		  
          		  velocityContext.put("packageService", service.getPackageService());
          		  velocityContext.put("nameService", nameService);
          		  velocityContext.put("nameModel", this.getNameClass(model.getClassModel()));
          		  velocityContext.put("classModel", model.getClassModel());
                          velocityContext.put("classMapperModel", model.getClassMapperModel());
        		  
        		  template.merge(velocityContext, stringWriter);
        		  nombre = service.getPathProject()  + "/" + service.getPackageService().replace(".", "/") + "/" + nameService + "Service.java";
        		  this.createFile(nombre, stringWriter.toString());
        		  System.out.println("Service created : " + nombre);
                          stringOutput += "Service created : " + nombre + "\n";
          }
          

	}
	
	public void createServiceWithSubModel(JAXBElement<Crud> menuElement){
		Crud crud = menuElement.getValue();
        Model model = menuElement.getValue().getModel();
        Service service = model.getBackend().getService();
        VelocityContext velocityContext = new VelocityContext();
        StringWriter stringWriter = new StringWriter();
        String nombre;
        
        if(crud.isGenerateServiceBackEnd()){
          List<SubModel> subModels = model.getSubModels().getSubModel();
  		  List<String> classSubModels = new ArrayList<String>();
  		  String listsParam = "";
  		  for (SubModel subModel : subModels) {
  			  classSubModels.add(subModel.getClassModel());
  			  if(!listsParam.equals("")){
  				  listsParam += ", ";
  			  }
  			  listsParam += "List<"+this.getNameClass(subModel.getClassModel())+"> list"+this.getNameClass(subModel.getClassModel())+"";
  		  }
  		  
  		  Template template = velocityEngine.getTemplate(pathTemplate+"ServiceMybatisWithSubModels.vm", "UTF-8");
  		  String nameService = (service.getNameService() == null) ? crud.getName() : service.getNameService();
  		  velocityContext.put("datetimeCreate", datetimeCreate);
  		  velocityContext.put("anho", anho.toString());
  		  velocityContext.put("nameApp", crud.getNameApp());
  		  
  		  velocityContext.put("packageService", service.getPackageService());
  		  velocityContext.put("nameService", nameService);
  		  velocityContext.put("nameModel", this.getNameClass(model.getClassModel()));
  		  velocityContext.put("classModel", model.getClassModel());
  		  velocityContext.put("classSubModels", classSubModels);
  		  velocityContext.put("listsParam", listsParam);
                  velocityContext.put("classMapperModel", model.getClassMapperModel());
  		  
  		  template.merge(velocityContext, stringWriter);
  		  nombre = service.getPathProject()  + "/" + service.getPackageService().replace(".", "/") + "/" + nameService + "Service.java";
  		  this.createFile(nombre, stringWriter.toString());
  		  System.out.println("Service created : " + nombre);
                  stringOutput += "Service created : " + nombre + "\n";
        }

	}
	public void createServiceImpl(JAXBElement<Crud> menuElement){
		
		Crud crud = menuElement.getValue();
        Model model = menuElement.getValue().getModel();
        Service service = model.getBackend().getService();
        List<Entity> entities = crud.getModel().getEntities().getEntity();
        VelocityContext velocityContext = new VelocityContext();
        StringWriter stringWriter = new StringWriter();
        String nombre;
        
        if(crud.isGenerateServiceBackEnd()){

    		  Template template = null;
    		  
    		  if(crud.getType() != null){
    			  if(crud.getType().equals("function")){
    				  template = velocityEngine.getTemplate(pathTemplate+"ServiceImplMybatisFunction.vm", "UTF-8"); 
        		  }else{
        			  template = velocityEngine.getTemplate(pathTemplate+"ServiceImplMybatisSimple.vm", "UTF-8");
        		  }
    		  }else{
    			  template = velocityEngine.getTemplate(pathTemplate+"ServiceImplMybatisSimple.vm", "UTF-8");
    		  }

      		  String nameService = (service.getNameService() == null) ? crud.getName() : service.getNameService();
      		  String nameServiceImpl = (service.getNameServiceImpl() == null) ? crud.getName() : service.getNameServiceImpl();
      		  
      		  velocityContext.put("datetimeCreate", datetimeCreate);
    		  velocityContext.put("anho", anho.toString());
    		  velocityContext.put("nameApp", crud.getNameApp());
    		  
      		  velocityContext.put("packageServiceImpl", service.getPackageServiceImpl());
      		  velocityContext.put("nameServiceImpl", nameServiceImpl);
      		  velocityContext.put("packageService", service.getPackageService());
    		  velocityContext.put("nameService", nameService);
      		  velocityContext.put("nameModel", this.getNameClass(model.getClassModel()));
      		  velocityContext.put("classModel", model.getClassModel());
                  velocityContext.put("classMapperModel", model.getClassMapperModel());
      		  
      		  List<EntityBean> beans = new ArrayList<EntityBean>();
      		  String returnProperty = "";
      		  
      		  for (Entity entity : entities) {
      			  
      			  EntityBean eb = new EntityBean();
      			  eb.setClassEntity(entity.getClassEntity());
      			  eb.setClassMapperEntity(entity.getClassMapper());
      			  eb.setNameEntity(this.getNameClass(entity.getClassEntity()));
      			  eb.setNameMapperEntity(this.getNameClass(entity.getClassMapper()));
      			  eb.setNameVarEntity(this.getNameVar(this.getNameClass(entity.getClassEntity())));
      			  eb.setPrimaryKeySetMethod(this.getNameSetMethod(entity.getPrimaryKey()));
      			  eb.setPrimaryKeyGetMethod(this.getNameGetMethod(entity.getPrimaryKey()));
      			  
      			  if(entity.getReturnProperty() != null){
      				if(entity.getReturnProperty().equals("true")){
        				  returnProperty = this.getNameVar(this.getNameClass(entity.getClassEntity())) +"." + this.getNameGetMethod(entity.getPrimaryKey())+"();";
        			  } 
      			  }
      			  
      			  List<EntityBean> subBeans = new ArrayList<EntityBean>();
      			
      			  if(entity.getEntities() != null){
      			  for (Entity subEntity : entity.getEntities().getEntity()) {
	        			  
	        			  EntityBean seb = new EntityBean();
	        			  seb.setClassEntity(subEntity.getClassEntity());
	        			  seb.setClassMapperEntity(subEntity.getClassMapper());
	        			  seb.setNameEntity(this.getNameClass(subEntity.getClassEntity()));
	        			  seb.setNameMapperEntity(this.getNameClass(subEntity.getClassMapper()));
	        			  seb.setNameVarEntity(this.getNameVar(this.getNameClass(subEntity.getClassEntity())));
	        			  seb.setPrimaryKeySetMethod(this.getNameSetMethod(subEntity.getPrimaryKey()));
	        			  seb.setPrimaryKeyGetMethod(this.getNameGetMethod(subEntity.getPrimaryKey()));
	        			  
	        			  if(subEntity.getJoinProperty() != null){
	        				  seb.setJoinProperty(this.formatProperty(subEntity.getJoinProperty()));
		        			  seb.setJoinPropertyGetMethod(this.getNameGetMethod(subEntity.getJoinProperty()));
		        			  seb.setJoinPropertySetMethod(this.getNameSetMethod(subEntity.getJoinProperty()));
	        			  }

	        			  if(subEntity.getReturnProperty() != null){
	            				if(subEntity.getReturnProperty().equals("true")){
	              				  returnProperty = this.getNameVar(this.getNameClass(subEntity.getClassEntity())) +"." + this.getNameGetMethod(subEntity.getPrimaryKey())+"();";
	              			  } 
	        			  }
	        			  
	        			  String otherProperties = "";
	        			  String targetProperty = "";
    					  String valueProperty = "";
    					  
	        			  if(subEntity.getOtherProperties() != null){
	        				  otherProperties = "";
	        				  for(Property p : subEntity.getOtherProperties().getProperty()){

	        					  if(p.getTargetProperty() == null){
	        						  targetProperty = p.getName();
	        					  }else{
	        						  targetProperty = p.getTargetProperty();
	        					  }

		        				  for (Entity e : entities) {
		        					  if(e.getPrimaryKey().equals(p.getName())){
		        						  
			        					  if(p.getValue() == null){
			        						  valueProperty = this.getNameVar(this.getNameClass(e.getClassEntity()))+"."+this.getNameGetMethod(e.getPrimaryKey())+"()";
			        					  }else{
			        						  valueProperty = p.getValue();
			        					  }
		        						  
		        						  otherProperties += "\n		"+this.getNameVar(this.getNameClass(subEntity.getClassEntity()))+"."+this.getNameSetMethod(targetProperty)+"("+valueProperty+");";
		        						  break;
		        					  }
		        					  for (Entity se : entity.getEntities().getEntity()) {
		        						  if(se.getPrimaryKey().equals(p.getName())){
		        							  
		        							  if(p.getValue() == null){
				        						  valueProperty = this.getNameVar(this.getNameClass(e.getClassEntity()))+"."+this.getNameGetMethod(e.getPrimaryKey())+"()";
				        					  }else{
				        						  valueProperty = p.getValue();
				        					  }
		        							  
			        						  otherProperties += "\n		"+this.getNameVar(this.getNameClass(subEntity.getClassEntity()))+"."+this.getNameSetMethod(targetProperty)+"("+valueProperty+");";
			        						  break;
			        					  }
		        					  }
		        				  }
		        				  
	        				  }
	        				 
	        				  
	        			  }
	        			  seb.setOtherProperties(otherProperties);
	        			  subBeans.add(seb);
	        			  
      			  }
      			  }
      			  

      			  eb.setSubBeans(subBeans);
      			  beans.add(eb);
      			  
      		  }
      		  
      		 velocityContext.put("returnProperty", returnProperty);
      		
      		 velocityContext.put("entity", beans);
      		 List<EntityBean> beansDelete = new ArrayList<EntityBean>();
      		 for (int i = beans.size()-1 ; i > -1; i--) {
      			
      			for (int j = beans.get(i).getSubBeans().size()-1 ; j > -1; j--) {
          			beansDelete.add(beans.get(i).getSubBeans().get(j));
          		 }
      			 beansDelete.add(beans.get(i));
      			
      		 }
      		 
      		 velocityContext.put("entityDelete", beansDelete);
      		  
      		  
      		  template.merge(velocityContext, stringWriter);
      		  nombre = service.getPathProject()  + "/" + service.getPackageServiceImpl().replace(".", "/") + "/" + nameService + "ServiceImpl.java";
      		  this.createFile(nombre, stringWriter.toString());
      		  System.out.println("Service Implement created : " + nombre);
                  stringOutput += "Service Implement created : " + nombre + "\n";
      		  
        }
        

	}
	
	public void createServiceImplWithSubModel(JAXBElement<Crud> menuElement){
		
		Crud crud = menuElement.getValue();
        Model model = menuElement.getValue().getModel();
        Service service = model.getBackend().getService();
        List<Entity> entities = crud.getModel().getEntities().getEntity();
        VelocityContext velocityContext = new VelocityContext();
        StringWriter stringWriter = new StringWriter();
        String nombre;
        
        if(crud.isGenerateServiceBackEnd()){
    		  List<SubModel> subModels = model.getSubModels().getSubModel();
	  		  String listsParam = "";
	  		  for (SubModel subModel : subModels) {
	  			  if(!listsParam.equals("")){
	  				  listsParam += ", ";
	  			  }
	  			  listsParam += "List<"+this.getNameClass(subModel.getClassModel())+"> list"+this.getNameClass(subModel.getClassModel())+"";
	  		  }
    		  Template template = velocityEngine.getTemplate(pathTemplate+"ServiceImplMybatisWithSubModels.vm", "UTF-8");
    		  String nameService = (service.getNameService() == null) ? crud.getName() : service.getNameService();
    		  String nameServiceImpl = (service.getNameServiceImpl() == null) ? crud.getName() : service.getNameServiceImpl();
    		  
    		  velocityContext.put("datetimeCreate", datetimeCreate);
    		  velocityContext.put("anho", anho.toString());
    		  velocityContext.put("nameApp", crud.getNameApp());
  		  
    		  velocityContext.put("packageServiceImpl", service.getPackageServiceImpl());
    		  velocityContext.put("nameServiceImpl", nameServiceImpl);
    		  velocityContext.put("packageService", service.getPackageService());
    		  velocityContext.put("nameService", nameService);
    		  velocityContext.put("nameModel", this.getNameClass(model.getClassModel()));
    		  velocityContext.put("classModel", model.getClassModel());
    		  velocityContext.put("listsParam", listsParam);
    		  velocityContext.put("classMapperModel", model.getClassMapperModel());
    		  
    		  
    		  List<EntityBean> beans = new ArrayList<EntityBean>();
    		  String returnProperty = "";
    		
    		  for (Entity entity : entities) {
    			  
    			  EntityBean eb = new EntityBean();
    			  eb.setClassEntity(entity.getClassEntity());
    			  eb.setClassMapperEntity(entity.getClassMapper());
    			  eb.setNameEntity(this.getNameClass(entity.getClassEntity()));
    			  eb.setNameMapperEntity(this.getNameClass(entity.getClassMapper()));
    			  eb.setNameVarEntity(this.getNameVar(this.getNameClass(entity.getClassEntity())));
    			  eb.setPrimaryKeySetMethod(this.getNameSetMethod(entity.getPrimaryKey()));
    			  eb.setPrimaryKeyGetMethod(this.getNameGetMethod(entity.getPrimaryKey()));

    			  if(entity.getReturnProperty() != null){
        				if(entity.getReturnProperty().equals("true")){
          				  returnProperty = this.getNameVar(this.getNameClass(entity.getClassEntity())) +"." + this.getNameGetMethod(entity.getPrimaryKey())+"();";
          			  } 
    			  }
    			  
    			  List<EntityBean> subBeans = new ArrayList<EntityBean>();
    			  
    			  if(entity.getEntities() != null){
    			  for (Entity subEntity : entity.getEntities().getEntity()) {
	        			  
	        			  EntityBean seb = new EntityBean();
	        			  seb.setClassEntity(subEntity.getClassEntity());
	        			  seb.setClassMapperEntity(subEntity.getClassMapper());
	        			  seb.setNameEntity(this.getNameClass(subEntity.getClassEntity()));
	        			  seb.setNameMapperEntity(this.getNameClass(subEntity.getClassMapper()));
	        			  seb.setNameVarEntity(this.getNameVar(this.getNameClass(subEntity.getClassEntity())));
	        			  seb.setPrimaryKeySetMethod(this.getNameSetMethod(subEntity.getPrimaryKey()));
	        			  seb.setPrimaryKeyGetMethod(this.getNameGetMethod(subEntity.getPrimaryKey()));
	        			  
	        			  if(subEntity.getJoinProperty() != null){
	        				  seb.setJoinProperty(this.formatProperty(subEntity.getJoinProperty()));
		        			  seb.setJoinPropertyGetMethod(this.getNameGetMethod(subEntity.getJoinProperty()));
		        			  seb.setJoinPropertySetMethod(this.getNameSetMethod(subEntity.getJoinProperty()));
	        			  }
	        			  
	        			  if(subEntity.getReturnProperty() != null){
	            				if(subEntity.getReturnProperty().equals("true")){
	              				  returnProperty = this.getNameVar(this.getNameClass(subEntity.getClassEntity())) +"." + this.getNameGetMethod(subEntity.getPrimaryKey())+"();";
	              			  } 
	        			  }
	        			  
	        			  String otherProperties = "";
	        			  if(subEntity.getOtherProperties() != null){
	        				  otherProperties = "";
	        				  for(Property p : subEntity.getOtherProperties().getProperty()){
	        					  String targetProperty = "";
	        					  String valueProperty = "";
	        					  
	        					  if(p.getTargetProperty() == null){
	        						  targetProperty = p.getName();
	        					  }else{
	        						  targetProperty = p.getTargetProperty();
	        					  }

		        				  for (Entity e : entities) {
		        					  if(e.getPrimaryKey().equals(p.getName())){
		        						  
			        					  if(p.getValue() == null){
			        						  valueProperty = this.getNameVar(this.getNameClass(e.getClassEntity()))+"."+this.getNameGetMethod(e.getPrimaryKey())+"()";
			        					  }else{
			        						  valueProperty = p.getValue();
			        					  }
		        						  
		        						  otherProperties += "\n		"+this.getNameVar(this.getNameClass(subEntity.getClassEntity()))+"."+this.getNameSetMethod(targetProperty)+"("+valueProperty+");";
		        						  break;
		        					  }
		        					  for (Entity se : entity.getEntities().getEntity()) {
		        						  if(se.getPrimaryKey().equals(p.getName())){
		        							  
		        							  if(p.getValue() == null){
				        						  valueProperty = this.getNameVar(this.getNameClass(e.getClassEntity()))+"."+this.getNameGetMethod(e.getPrimaryKey())+"()";
				        					  }else{
				        						  valueProperty = p.getValue();
				        					  }
		        							  
			        						  otherProperties += "\n		"+this.getNameVar(this.getNameClass(subEntity.getClassEntity()))+"."+this.getNameSetMethod(targetProperty)+"("+valueProperty+");";
			        						  break;
			        					  }
		        					  }
		        				  }
	        				  }
	        				
	        			  }
	        			  seb.setOtherProperties(otherProperties);
	        			  subBeans.add(seb);
	        			  
    			  }
    			  }
    			  

    			  eb.setSubBeans(subBeans);
    			  beans.add(eb);
    		  }
    		  
    		 velocityContext.put("returnProperty", returnProperty);
    		  
    		 velocityContext.put("entity", beans);
    		 List<EntityBean> beansDelete = new ArrayList<EntityBean>();
    		 for (int i = beans.size()-1 ; i > -1; i--) {
     			for (int j = beans.get(i).getSubBeans().size()-1 ; j > -1; j--) {
        			beansDelete.add(beans.get(i).getSubBeans().get(j));
        		 }
    			beansDelete.add(beans.get(i));
    		 }
    		 
    		 velocityContext.put("entityDelete", beansDelete);
    		 
    		List<SubModelBean> beansSubModels = new ArrayList<SubModelBean>();
  		  
  		for (SubModel subModel : subModels) {
  			  
  			  Entity entity = subModel.getEntities().getEntity().get(0);
  			  Entity entityMain = model.getEntities().getEntity().get(0);
  			
  			  SubModelBean sm = new SubModelBean();
  			  sm.setClassEntity(entity.getClassEntity());
  			  sm.setClassMapperEntity(entity.getClassMapper());
  			  sm.setNameEntity(this.getNameClass(entity.getClassEntity()));
  			  sm.setNameMapperEntity(this.getNameClass(entity.getClassMapper()));
  			  sm.setNameVarEntity(this.getNameVar(this.getNameClass(entity.getClassEntity())));
  			  sm.setPrimaryKeySetMethod(this.getNameSetMethod(entity.getPrimaryKey()));
  			  sm.setPrimaryKeyGetMethod(this.getNameGetMethod(entity.getPrimaryKey()));
  			  sm.setNameModel(this.getNameClass(subModel.getClassModel()));
  			  sm.setNameVarModel(this.getNameVar(this.getNameClass(subModel.getClassModel())));
  			  sm.setPropertyGetMethod(this.getNameGetMethod(subModel.getIdProperty()));
  			  sm.setPropertySetMethod(this.getNameSetMethod(subModel.getIdProperty()));
  			  sm.setJoinProperty(this.formatProperty(subModel.getJoinProperty()));
  			  sm.setJoinPropertyGetMethod(this.getNameGetMethod(subModel.getJoinProperty()));
  			  sm.setJoinPropertySetMethod(this.getNameSetMethod(subModel.getJoinProperty()));
  			  sm.setNameVarEntityMain(this.getNameVar(this.getNameClass(entityMain.getClassEntity())));
  			  sm.setClassModel(subModel.getClassModel());
  			  
  			  for (Entity e : entities) {
  				  if(e.getPrimaryKey().equals(subModel.getJoinProperty())){
  					  sm.setNameVarModelProperty(this.getNameVar(this.getNameClass(e.getClassEntity())));
  					  break;
  				  }
  				  for (Entity se : e.getEntities().getEntity()) {
  					  if(se.getPrimaryKey().equals(subModel.getJoinProperty())){
      					  sm.setNameVarModelProperty(this.getNameVar(this.getNameClass(se.getClassEntity())));
      					  break;
      				  }
  				  }
  			  }
  			  
  			  if(subModel.getEmpty() != null){
  				  if(subModel.getEmpty().equals("true")){
      				  sm.setEmpty("true");
      			  } 
  			  }else{
  				  sm.setEmpty("false");
  			  }
  			  
  			  beansSubModels.add(sm);
  		  }
  		  velocityContext.put("subModels", beansSubModels);
    		  
    		  template.merge(velocityContext, stringWriter);
    		  nombre = service.getPathProject()  + "/" + service.getPackageServiceImpl().replace(".", "/") + "/" + nameService + "ServiceImpl.java";
    		  this.createFile(nombre, stringWriter.toString());
    		  System.out.println("Service Implement created : " + nombre);
                  stringOutput += "Service Implement created : " + nombre + "\n";

        }
	}
	
	public void createController(JAXBElement<Crud> menuElement){
		
		Crud crud = menuElement.getValue();
        Model model = menuElement.getValue().getModel();
        Service service = model.getBackend().getService();
        Controller controller = model.getBackend().getController();
        VelocityContext velocityContext = new VelocityContext();
        StringWriter stringWriter = new StringWriter();
        String nombre;
        
        if(crud.isGenerateControllerBackEnd()){
          	  if(model.getBackend().getController().getTypeFw().equals("struts2")){
          		  
          		  Template template = velocityEngine.getTemplate(pathTemplate+"ControllerStrust2.vm", "UTF-8");
          		  String nameService = (service.getNameService() == null) ? crud.getName() : service.getNameService();
          		  String nameController = (controller.getNameController() == null) ? crud.getName() : controller.getNameController();
          		  
          		  velocityContext.put("datetimeCreate", datetimeCreate);
        		  velocityContext.put("anho", anho.toString());
        		  velocityContext.put("nameApp", crud.getNameApp());
        		  
        		  velocityContext.put("module", (controller.getModule() == null) ? "/" : "/"+controller.getModule());
          		  velocityContext.put("packageController", controller.getPackageController());
          		  velocityContext.put("nameController", nameController);
          		  
          		  velocityContext.put("packageService", service.getPackageService());
        		  velocityContext.put("nameService", nameService);
        		  velocityContext.put("varNameService", this.getNameVar(nameService));
        		  velocityContext.put("nameGetMethodService", this.getNameGetMethod(nameService));
        		  velocityContext.put("nameSetMethodService", this.getNameSetMethod(nameService));
        		  
          		  velocityContext.put("nameModel", this.getNameClass(model.getClassModel()));
          		  velocityContext.put("classModel", model.getClassModel());
          		  velocityContext.put("nameVarModel", this.getNameVar(this.getNameClass(model.getClassModel())));
          		  velocityContext.put("nameGetMethodModel", this.getNameGetMethod(this.getNameClass(model.getClassModel())));
          		  velocityContext.put("nameSetMethodModel", this.getNameSetMethod(this.getNameClass(model.getClassModel())));
          		  velocityContext.put("nameIdPropertySetMethod", this.getNameSetMethod(model.getIdProperty()));
          		  velocityContext.put("nameIdPropertyGetMethod", this.getNameGetMethod(model.getIdProperty()));
          		  
          		  velocityContext.put("nameModelCriteria", this.getNameClass(model.getClassModelCriteria()));
        		  velocityContext.put("classModelCriteria", model.getClassModelCriteria());
        		  velocityContext.put("nameVarModelCriteria", this.getNameVar(this.getNameClass(model.getClassModelCriteria())));
        		  velocityContext.put("nameGetMethodModelCriteria", this.getNameGetMethod(this.getNameClass(model.getClassModelCriteria())));
        		  velocityContext.put("nameSetMethodModelCriteria", this.getNameSetMethod(this.getNameClass(model.getClassModelCriteria())));
        		  
        		  velocityContext.put("nameMapperModel", this.getNameClass(model.getClassMapperModel()));
        		  velocityContext.put("classMapperModel", model.getClassMapperModel());
          		  
          		  template.merge(velocityContext, stringWriter);
          		  nombre = controller.getPathProject()  + "/" + controller.getPackageController().replace(".", "/") + "/" + nameService + "Action.java";
          		  this.createFile(nombre, stringWriter.toString());
          		  System.out.println("Action created : " + nombre);
                          stringOutput += "Action created : " + nombre + "\n";
          		  
          	  }else{
          		  
        		  Template template = null;
        		  
        		  if(crud.getType() != null){
        			  if(crud.getType().equals("function")){
        				  template = velocityEngine.getTemplate(pathTemplate+"ControllerSpringMVCFunction.vm", "UTF-8"); 
            		  }else{
            			  template = velocityEngine.getTemplate(pathTemplate+"ControllerSpringMVC.vm", "UTF-8");
            		  }
        		  }else{
        			  template = velocityEngine.getTemplate(pathTemplate+"ControllerSpringMVC.vm", "UTF-8");
        		  }

          		  String nameService = (service.getNameService() == null) ? crud.getName() : service.getNameService();
          		  String nameController = (controller.getNameController() == null) ? crud.getName() : controller.getNameController();
          		  
          		  velocityContext.put("datetimeCreate", datetimeCreate);
        		  velocityContext.put("anho", anho.toString());
        		  velocityContext.put("nameApp", crud.getNameApp());
        		  
        		  velocityContext.put("module", (controller.getModule() == null) ? "/" : "/"+controller.getModule());
          		  velocityContext.put("packageController", controller.getPackageController());
          		  velocityContext.put("nameController", nameController);
          		  
          		  velocityContext.put("packageService", service.getPackageService());
        		  velocityContext.put("nameService", nameService);
        		  velocityContext.put("varNameService", this.getNameVar(nameService));
        		  velocityContext.put("nameGetMethodService", this.getNameGetMethod(nameService));
        		  velocityContext.put("nameSetMethodService", this.getNameSetMethod(nameService));
        		  
          		  velocityContext.put("nameModel", this.getNameClass(model.getClassModel()));
          		  velocityContext.put("nameModelAlter", (model.getNameModel() != null) ? model.getNameModel() : this.getNameClass(model.getClassModel()));
          		  velocityContext.put("classModel", model.getClassModel());
          		  velocityContext.put("nameVarModel", this.getNameVar(this.getNameClass(model.getClassModel())));
          		  velocityContext.put("nameGetMethodModel", this.getNameGetMethod(this.getNameClass(model.getClassModel())));
          		  velocityContext.put("nameSetMethodModel", this.getNameSetMethod(this.getNameClass(model.getClassModel())));
          		  velocityContext.put("nameIdPropertySetMethod", this.getNameSetMethod(model.getIdProperty()));
          		  velocityContext.put("nameIdPropertyGetMethod", this.getNameGetMethod(model.getIdProperty()));
          		  
          		  velocityContext.put("nameModelCriteria", this.getNameClass(model.getClassModelCriteria()));
        		  velocityContext.put("classModelCriteria", model.getClassModelCriteria());
        		  velocityContext.put("nameVarModelCriteria", this.getNameVar(this.getNameClass(model.getClassModelCriteria())));
        		  velocityContext.put("nameGetMethodModelCriteria", this.getNameGetMethod(this.getNameClass(model.getClassModelCriteria())));
        		  velocityContext.put("nameSetMethodModelCriteria", this.getNameSetMethod(this.getNameClass(model.getClassModelCriteria())));
        		  
        		  velocityContext.put("nameMapperModel", this.getNameClass(model.getClassMapperModel()));
        		  velocityContext.put("classMapperModel", model.getClassMapperModel());
          		  
          		  template.merge(velocityContext, stringWriter);
          		  nombre = controller.getPathProject()  + "/" + controller.getPackageController().replace(".", "/") + "/" + nameService + "Controller.java";
          		  this.createFile(nombre, stringWriter.toString());
          		  System.out.println("Controller Spring MVC created : " + nombre);
                          stringOutput += "Controller Spring MVC created : " + nombre + "\n";
          	  }

        }
        

	}
	
	public void createControllerWithSubModel(JAXBElement<Crud> menuElement){
		
		Crud crud = menuElement.getValue();
        Model model = menuElement.getValue().getModel();
        Service service = model.getBackend().getService();
        Controller controller = model.getBackend().getController();
        VelocityContext velocityContext = new VelocityContext();
        StringWriter stringWriter = new StringWriter();
        String nombre;
        
        if(crud.isGenerateControllerBackEnd()){
          	  if(model.getBackend().getController().getTypeFw().equals("struts2")){
          		  
          		  Template template = velocityEngine.getTemplate(pathTemplate+"ControllerStrust2WithSubModels.vm", "UTF-8");
          		  String nameService = (service.getNameService() == null) ? crud.getName() : service.getNameService();
          		  String nameController = (controller.getNameController() == null) ? crud.getName() : controller.getNameController();
          		  
          		  velocityContext.put("datetimeCreate", datetimeCreate);
        		  velocityContext.put("anho", anho.toString());
        		  velocityContext.put("nameApp", crud.getNameApp());
        		  
        		  velocityContext.put("module", (controller.getModule() == null) ? "/" : "/"+controller.getModule());
          		  velocityContext.put("packageController", controller.getPackageController());
          		  velocityContext.put("nameController", nameController);
          		  
          		  velocityContext.put("packageService", service.getPackageService());
        		  velocityContext.put("nameService", nameService);
        		  velocityContext.put("varNameService", this.getNameVar(nameService));
        		  velocityContext.put("nameGetMethodService", this.getNameGetMethod(nameService));
        		  velocityContext.put("nameSetMethodService", this.getNameSetMethod(nameService));
        		  
          		  velocityContext.put("nameModel", this.getNameClass(model.getClassModel()));
          		  velocityContext.put("classModel", model.getClassModel());
          		  velocityContext.put("nameVarModel", this.getNameVar(this.getNameClass(model.getClassModel())));
          		  velocityContext.put("nameGetMethodModel", this.getNameGetMethod(this.getNameClass(model.getClassModel())));
          		  velocityContext.put("nameSetMethodModel", this.getNameSetMethod(this.getNameClass(model.getClassModel())));
          		  
          		  velocityContext.put("nameModelCriteria", this.getNameClass(model.getClassModelCriteria()));
        		  velocityContext.put("classModelCriteria", model.getClassModelCriteria());
        		  velocityContext.put("nameVarModelCriteria", this.getNameVar(this.getNameClass(model.getClassModelCriteria())));
        		  velocityContext.put("nameGetMethodModelCriteria", this.getNameGetMethod(this.getNameClass(model.getClassModelCriteria())));
        		  velocityContext.put("nameSetMethodModelCriteria", this.getNameSetMethod(this.getNameClass(model.getClassModelCriteria())));
        		  velocityContext.put("nameIdPropertyGetMethod", this.getNameGetMethod(model.getIdProperty()));
        		  
        		  velocityContext.put("nameMapperModel", this.getNameClass(model.getClassMapperModel()));
        		  velocityContext.put("classMapperModel", model.getClassMapperModel());
        		  
        		  List<SubModel> subModels = model.getSubModels().getSubModel();
        		  List<Map<String, String>> listSubmodels = new ArrayList<Map<String,String>>();
        		  String lists = "";
        		  for (SubModel subModel : subModels) {
        			  if(!lists.equals("")){
        				  lists += ", ";
        			  }
        			  lists += "list"+this.getNameClass(subModel.getClassModel())+"";
        		  }
        		  
        		  for (SubModel subModel : subModels) {
        			  Map<String, String> subModelsMap = new HashMap<String, String>();
        			  subModelsMap.put("nameModel", this.getNameClass(subModel.getClassModel()));
        			  subModelsMap.put("nameModelAlter", (subModel.getNameModel() != null) ? subModel.getNameModel() : this.getNameClass(subModel.getClassModel()));
        			  subModelsMap.put("classModel", subModel.getClassModel());
        			  subModelsMap.put("nameVarModel", this.getNameVar(this.getNameClass(subModel.getClassModel())));
        			  subModelsMap.put("nameGetMethodModel", this.getNameGetMethod(this.getNameClass(subModel.getClassModel())));
        			  subModelsMap.put("nameSetMethodModel", this.getNameSetMethod(this.getNameClass(subModel.getClassModel())));
              		  
        			  subModelsMap.put("nameModelCriteria", this.getNameClass(subModel.getClassModelCriteria()));
        			  subModelsMap.put("classModelCriteria", subModel.getClassModelCriteria());
        			  subModelsMap.put("nameVarModelCriteria", this.getNameVar(this.getNameClass(subModel.getClassModelCriteria())));
        			  subModelsMap.put("nameGetMethodModelCriteria", this.getNameGetMethod(this.getNameClass(subModel.getClassModelCriteria())));
        			  subModelsMap.put("nameSetMethodModelCriteria", this.getNameSetMethod(this.getNameClass(subModel.getClassModelCriteria())));
            		  
        			  subModelsMap.put("nameMapperModel", this.getNameClass(subModel.getClassMapperModel()));
        			  subModelsMap.put("classMapperModel", subModel.getClassMapperModel());
        			  subModelsMap.put("joinProperty", subModel.getJoinProperty());
        			  subModelsMap.put("joinPropertySetMethod", this.getNameSetMethod(subModel.getJoinProperty()));
        			  subModelsMap.put("joinPropertyGetMethod", this.getNameGetMethod(subModel.getJoinProperty()));
        			  subModelsMap.put("propertyGetMethod", this.getNameGetMethod(subModel.getIdProperty()));
        			  subModelsMap.put("propertySetMethod", this.getNameSetMethod(subModel.getIdProperty()));
        			  
        			  
        			  
        			  listSubmodels.add(subModelsMap);
				}
        		  
        		  velocityContext.put("lists", lists);
        		  velocityContext.put("subModels", listSubmodels);
        		  
        		  
          		  
          		  template.merge(velocityContext, stringWriter);
          		  nombre = controller.getPathProject()  + "/" + controller.getPackageController().replace(".", "/") + "/" + nameService + "Action.java";
          		  this.createFile(nombre, stringWriter.toString());
          		  System.out.println("Action created : " + nombre);
                          stringOutput += "Action created : " + nombre + "\n";
          		  
          	  }else{
          		  Template template = velocityEngine.getTemplate(pathTemplate+"ControllerSpringMVCWithSubModels.vm", "UTF-8");
          		  String nameService = (service.getNameService() == null) ? crud.getName() : service.getNameService();
          		  String nameController = (controller.getNameController() == null) ? crud.getName() : controller.getNameController();
          		  
          		  velocityContext.put("datetimeCreate", datetimeCreate);
        		  velocityContext.put("anho", anho.toString());
        		  velocityContext.put("nameApp", crud.getNameApp());
        		  
        		  velocityContext.put("module", (controller.getModule() == null) ? "/" : "/"+controller.getModule());
          		  velocityContext.put("packageController", controller.getPackageController());
          		  velocityContext.put("nameController", nameController);
          		  
          		  velocityContext.put("packageService", service.getPackageService());
        		  velocityContext.put("nameService", nameService);
        		  velocityContext.put("varNameService", this.getNameVar(nameService));
        		  velocityContext.put("nameGetMethodService", this.getNameGetMethod(nameService));
        		  velocityContext.put("nameSetMethodService", this.getNameSetMethod(nameService));
        		  
          		  velocityContext.put("nameModel", this.getNameClass(model.getClassModel()));
          		  velocityContext.put("nameModelAlter", (model.getNameModel() != null) ? model.getNameModel() : this.getNameClass(model.getClassModel()));
          		  velocityContext.put("classModel", model.getClassModel());
          		  velocityContext.put("nameVarModel", this.getNameVar(this.getNameClass(model.getClassModel())));
          		  velocityContext.put("nameGetMethodModel", this.getNameGetMethod(this.getNameClass(model.getClassModel())));
          		  velocityContext.put("nameSetMethodModel", this.getNameSetMethod(this.getNameClass(model.getClassModel())));
          		  
          		  velocityContext.put("nameModelCriteria", this.getNameClass(model.getClassModelCriteria()));
        		  velocityContext.put("classModelCriteria", model.getClassModelCriteria());
        		  velocityContext.put("nameVarModelCriteria", this.getNameVar(this.getNameClass(model.getClassModelCriteria())));
        		  velocityContext.put("nameGetMethodModelCriteria", this.getNameGetMethod(this.getNameClass(model.getClassModelCriteria())));
        		  velocityContext.put("nameSetMethodModelCriteria", this.getNameSetMethod(this.getNameClass(model.getClassModelCriteria())));
        		  velocityContext.put("nameIdPropertyGetMethod", this.getNameGetMethod(model.getIdProperty()));
        		  
        		  velocityContext.put("nameMapperModel", this.getNameClass(model.getClassMapperModel()));
        		  velocityContext.put("classMapperModel", model.getClassMapperModel());
        		  
        		  List<SubModel> subModels = model.getSubModels().getSubModel();
        		  List<Map<String, String>> listSubmodels = new ArrayList<Map<String,String>>();
        		  String lists = "";
        		  for (SubModel subModel : subModels) {
        			  if(!lists.equals("")){
        				  lists += ", ";
        			  }
        			  lists += "list"+this.getNameClass(subModel.getClassModel())+"";
        		  }
        		  
        		  for (SubModel subModel : subModels) {
        			  Map<String, String> subModelsMap = new HashMap<String, String>();
        			  subModelsMap.put("nameModel", this.getNameClass(subModel.getClassModel()));
        			  subModelsMap.put("nameModelAlter", (subModel.getNameModel() != null) ? subModel.getNameModel() : this.getNameClass(subModel.getClassModel()));
        			  subModelsMap.put("classModel", subModel.getClassModel());
        			  subModelsMap.put("nameVarModel", this.getNameVar(this.getNameClass(subModel.getClassModel())));
        			  subModelsMap.put("nameGetMethodModel", this.getNameGetMethod(this.getNameClass(subModel.getClassModel())));
        			  subModelsMap.put("nameSetMethodModel", this.getNameSetMethod(this.getNameClass(subModel.getClassModel())));
              		  
        			  subModelsMap.put("nameModelCriteria", this.getNameClass(subModel.getClassModelCriteria()));
        			  subModelsMap.put("classModelCriteria", subModel.getClassModelCriteria());
        			  subModelsMap.put("nameVarModelCriteria", this.getNameVar(this.getNameClass(subModel.getClassModelCriteria())));
        			  subModelsMap.put("nameGetMethodModelCriteria", this.getNameGetMethod(this.getNameClass(subModel.getClassModelCriteria())));
        			  subModelsMap.put("nameSetMethodModelCriteria", this.getNameSetMethod(this.getNameClass(subModel.getClassModelCriteria())));
            		  
        			  subModelsMap.put("nameMapperModel", this.getNameClass(subModel.getClassMapperModel()));
        			  subModelsMap.put("classMapperModel", subModel.getClassMapperModel());
        			  subModelsMap.put("joinProperty", subModel.getJoinProperty());
        			  subModelsMap.put("joinPropertySetMethod", this.getNameSetMethod(subModel.getJoinProperty()));
        			  subModelsMap.put("joinPropertyGetMethod", this.getNameGetMethod(subModel.getJoinProperty()));
        			  subModelsMap.put("propertyGetMethod", this.getNameGetMethod(subModel.getIdProperty()));
        			  subModelsMap.put("propertySetMethod", this.getNameSetMethod(subModel.getIdProperty()));
        			  
        			  
        			  
        			  listSubmodels.add(subModelsMap);
				}
        		  
        		  velocityContext.put("lists", lists);
        		  velocityContext.put("subModels", listSubmodels);
        		  
        		  
          		  
          		  template.merge(velocityContext, stringWriter);
          		  nombre = controller.getPathProject()  + "/" + controller.getPackageController().replace(".", "/") + "/" + nameService + "Controller.java";
          		  this.createFile(nombre, stringWriter.toString());
          		  System.out.println("Controller Spring MVC created : " + nombre);
                          stringOutput += "Controller Spring MVC created : " + nombre + "\n";

          	  }
        }
        
	}
	
	public void createStoreExtJs(JAXBElement<Crud> menuElement){
		
		Crud crud = menuElement.getValue();
        Model model = menuElement.getValue().getModel();
        Controller controller = model.getBackend().getController();
        VelocityContext velocityContext = new VelocityContext();
        StringWriter stringWriter = new StringWriter();
        String nombre;
        
        if(crud.isGenerateStoreFrontEnd()){
        	
        	String nameStoreExtJs = "MainStore";
        	
        	if(controller.getTypeFw().equals("springMVC")){
        		
      		  Template template = null;
    		  
      		  if(crud.getType() != null){
      			  if(crud.getType().equals("function")){
      				  template = velocityEngine.getTemplate(pathTemplate+"StoreExtJs5SpringMVCFunction.vm", "UTF-8"); 
          		  }else{
          			  template = velocityEngine.getTemplate(pathTemplate+"StoreExtJs5SpringMVC.vm", "UTF-8");
          		  }
      		  }else{
      			  template = velocityEngine.getTemplate(pathTemplate+"StoreExtJs5SpringMVC.vm", "UTF-8");
    		  }

      		  String nameController = (controller.getNameController() == null) ? crud.getName() : controller.getNameController();
      		  

      		  velocityContext.put("datetimeCreate", datetimeCreate);
    		  velocityContext.put("anho", anho.toString());
    		  velocityContext.put("nameApp", crud.getNameApp());
    		  
    		  velocityContext.put("module", (controller.getModule() == null) ? "" : controller.getModule()+"/");
      		  velocityContext.put("nameController", nameController);
      		  velocityContext.put("nameStoreExtJs", nameStoreExtJs);
      		  velocityContext.put("name", crud.getName());
      		  velocityContext.put("varNameModel", this.getNameVar(this.getNameClass(model.getClassModel())));
      		  
	      		File file = new File(crud.getPathAppExtJs()+"/store/"+crud.getName());
	      		if(!file.exists()){
	      			file.mkdirs();
	      		}
      		  
      		  template.merge(velocityContext, stringWriter);
      		  nombre = crud.getPathAppExtJs()  + "/store/" + crud.getName() + "/" + nameStoreExtJs + ".js";
      		  this.createFile(nombre, stringWriter.toString());
      		  System.out.println("Store ExtJs Spring MVC created : " + nombre);
                  stringOutput += "Store ExtJs Spring MVC created : " + nombre + "\n";
        	}else{
      		  Template template = velocityEngine.getTemplate(pathTemplate+"StoreExtJs5.vm", "UTF-8");
      		  String nameController = (controller.getNameController() == null) ? crud.getName() : controller.getNameController();
  
      		  velocityContext.put("datetimeCreate", datetimeCreate);
    		  velocityContext.put("anho", anho.toString());
    		  velocityContext.put("nameApp", crud.getNameApp());
    		  
    		  velocityContext.put("module", (controller.getModule() == null) ? "" : controller.getModule()+"/");
      		  velocityContext.put("nameController", nameController);
      		  velocityContext.put("nameStoreExtJs", nameStoreExtJs);
      		  velocityContext.put("name", crud.getName());
      		  velocityContext.put("varNameModel", this.getNameVar(this.getNameClass(model.getClassModel())));
      		  
	      		File file = new File(crud.getPathAppExtJs()+"/store/"+crud.getName());
	      		if(!file.exists()){
	      			file.mkdirs();
	      		}
      		  
      		  template.merge(velocityContext, stringWriter);
      		  nombre = crud.getPathAppExtJs()  + "/store/" + crud.getName() + "/" + nameStoreExtJs + ".js";
      		  this.createFile(nombre, stringWriter.toString());
      		  System.out.println("Store ExtJs Struts2 created : " + nombre);
                  stringOutput += "Store ExtJs Struts2 created : " + nombre + "\n";
        	}
        	
        	

          		  
          	if(model.getSubModels() != null){
          		
          		if(controller.getTypeFw().equals("springMVC")){
	  	      		  List<SubModel> subModels = model.getSubModels().getSubModel();
	  	      		
	  	      		  Template templateSubModel = velocityEngine.getTemplate(pathTemplate+"StoreExtJs5SpringMVCSubModel.vm", "UTF-8");
	  	      		  
	  	      		  for (SubModel subModel : subModels) {
	  	      			  
	  	            		  String nameStoreExtJsSubModel = (subModel.getNameModel() != null) ? subModel.getNameModel()+"Store" : this.getNameClass(subModel.getClassModel())+"Store";
	  		  
	  		          		  velocityContext.put("datetimeCreate", datetimeCreate);
	  		        		  velocityContext.put("anho", anho.toString());
	  		        		  velocityContext.put("nameApp", crud.getNameApp());
	  		        		  
	  		        		  velocityContext.put("module", (controller.getModule() == null) ? "" : controller.getModule()+"/");
	  		          		  velocityContext.put("nameStoreExtJs", nameStoreExtJs);
	  		          		  velocityContext.put("name", crud.getName());
	  		          		  velocityContext.put("varNameModel", this.getNameVar(this.getNameClass(subModel.getClassModel())));
	  		          		  velocityContext.put("nameModel", this.getNameClass(subModel.getClassModel()));
	  		          		  velocityContext.put("nameModelAlter", (subModel.getNameModel() != null) ? subModel.getNameModel() : this.getNameClass(subModel.getClassModel()));
	  		          		  
	  		    	      		File fileSubModel = new File(crud.getPathAppExtJs()+"/store/"+crud.getName());
	  		    	      		if(!fileSubModel.exists()){
	  		    	      			fileSubModel.mkdirs();
	  		    	      		}
	  		    	      	  stringWriter= new StringWriter();
	  		    	      	  templateSubModel.merge(velocityContext, stringWriter);
	  		          		  nombre = crud.getPathAppExtJs()  + "/store/" + crud.getName() + "/" + nameStoreExtJsSubModel + ".js";
	  		          		  this.createFile(nombre, stringWriter.toString());
	  		          		  System.out.println("Store SubModel ExtJs created : " + nombre);
                                                  stringOutput += "Store SubModel ExtJs created : " + nombre + "\n";
	  		        }
          		}else{
	  	      		  List<SubModel> subModels = model.getSubModels().getSubModel();
	  	      		
	  	      		  Template templateSubModel = velocityEngine.getTemplate(pathTemplate+"StoreExtJs5SubModel.vm", "UTF-8");
	  	      		  
	  	      		  for (SubModel subModel : subModels) {
	  	      			  
	  	            		  String nameStoreExtJsSubModel = this.getNameClass(subModel.getClassModel())+"Store";
	  		  
	  		          		  velocityContext.put("datetimeCreate", datetimeCreate);
	  		        		  velocityContext.put("anho", anho.toString());
	  		        		  velocityContext.put("nameApp", crud.getNameApp());
	  		        		  
	  		        		  velocityContext.put("module", (controller.getModule() == null) ? "" : controller.getModule()+"/");
	  		          		  velocityContext.put("nameStoreExtJs", nameStoreExtJs);
	  		          		  velocityContext.put("name", crud.getName());
	  		          		  velocityContext.put("varNameModel", this.getNameVar(this.getNameClass(subModel.getClassModel())));
	  		          		  velocityContext.put("nameModel", this.getNameClass(subModel.getClassModel()));
	  		          		  velocityContext.put("nameModelAlter", (subModel.getNameModel() != null) ? subModel.getNameModel() : this.getNameClass(subModel.getClassModel()));
	  		          		  
	  		    	      		File fileSubModel = new File(crud.getPathAppExtJs()+"/store/"+crud.getName());
	  		    	      		if(!fileSubModel.exists()){
	  		    	      			fileSubModel.mkdirs();
	  		    	      		}
	  		    	      	  stringWriter= new StringWriter();
	  		    	      	  templateSubModel.merge(velocityContext, stringWriter);
	  		          		  nombre = crud.getPathAppExtJs()  + "/store/" + crud.getName() + "/" + nameStoreExtJsSubModel + ".js";
	  		          		  this.createFile(nombre, stringWriter.toString());
	  		          		  System.out.println("Store SubModel ExtJs created : " + nombre);
                                                  stringOutput += "Store SubModel ExtJs created : " + nombre + "\n";
	  		        }
          		}
          		

          	}
        }
	}

	public void createControllerExtJs(JAXBElement<Crud> menuElement){
		
		Crud crud = menuElement.getValue();
        Model model = menuElement.getValue().getModel();
        VelocityContext velocityContext = new VelocityContext();
        StringWriter stringWriter = new StringWriter();
        String nombre;
        
        if(crud.isGenerateControllerFrontEnd()){
        		
        		  Template template = null;
        		  
          		  if(crud.getType() != null){
          			  if(crud.getType().equals("function")){
          				  template = velocityEngine.getTemplate(pathTemplate+"ControllerExtJs5Function.vm", "UTF-8"); 
              		  }else{
              			  template = velocityEngine.getTemplate(pathTemplate+"ControllerExtJs5.vm", "UTF-8");
              		  }
          		  }else{
          			  	template = velocityEngine.getTemplate(pathTemplate+"ControllerExtJs5.vm", "UTF-8");
        		  }

          		  String nameControllerExtJs = "MainController";

          		  velocityContext.put("datetimeCreate", datetimeCreate);
        		  velocityContext.put("anho", anho.toString());
        		  velocityContext.put("nameApp", crud.getNameApp());
        		  
          		  velocityContext.put("nameControllerExtJs", nameControllerExtJs);
          		  velocityContext.put("name", crud.getName());
          		  velocityContext.put("idProperty", model.getIdProperty());
          		  
    	      		File file = new File(crud.getPathAppExtJs()+"/controller/"+crud.getName());
    	      		if(!file.exists()){
    	      			file.mkdirs();
    	      		}
          		  
          		  template.merge(velocityContext, stringWriter);
          		  nombre = crud.getPathAppExtJs()  + "/controller/" +crud.getName() + "/" + nameControllerExtJs + ".js";
          		  this.createFile(nombre, stringWriter.toString());
          		  System.out.println("Controller ExtJs created : " + nombre);
                          stringOutput += "Controller ExtJs created : " + nombre + "\n";
        }
        
	}

	public void createControllerExtJsWithSubModel(JAXBElement<Crud> menuElement){
		
		Crud crud = menuElement.getValue();
        Model model = menuElement.getValue().getModel();
        VelocityContext velocityContext = new VelocityContext();
        StringWriter stringWriter = new StringWriter();
        String nombre;
        
        if(crud.isGenerateControllerFrontEnd()){
      	  	  
        	  List<SubModel> subModels = model.getSubModels().getSubModel();
  		
    		  Template template = velocityEngine.getTemplate(pathTemplate+"ControllerExtJs5WithSubModels.vm", "UTF-8");
    		  String nameControllerExtJs = "MainController";

    		  velocityContext.put("datetimeCreate", datetimeCreate);
    		  velocityContext.put("anho", anho.toString());
    		  velocityContext.put("nameApp", crud.getNameApp());
  		  
    		  velocityContext.put("nameControllerExtJs", nameControllerExtJs);
    		  velocityContext.put("name", crud.getName());
    		  velocityContext.put("idProperty", model.getIdProperty());
    		  
    		  List<Map<String, String>> listSubmodels = new ArrayList<Map<String,String>>();
    		  List<String[]> listStoresSubModel = new ArrayList<String[]>();
    		        		  
    		  for (SubModel subModel : subModels) {
    			Map<String, String> subModelsMap = new HashMap<String, String>();
    			subModelsMap.put("nameModel", this.getNameClass(subModel.getClassModel()));
    			subModelsMap.put("nameModelAlter", (subModel.getNameModel() != null) ? subModel.getNameModel() : this.getNameClass(subModel.getClassModel()));
    			subModelsMap.put("joinProperty", subModel.getJoinProperty());
    			listSubmodels.add(subModelsMap);
    			String[] store = new String[4];
    			store[0] = "subModel_"+((subModel.getNameModel() != null) ? subModel.getNameModel() : this.getNameClass(subModel.getClassModel()))+".store.reload({params: {"+subModel.getJoinProperty()+": "+subModel.getJoinProperty()+".getValue(), start:0, limit:10}});";
    			store[1] = "subModel_"+((subModel.getNameModel() != null) ? subModel.getNameModel() : this.getNameClass(subModel.getClassModel()))+".store.reload({\n";
    			store[1] += "params: {"+subModel.getJoinProperty()+": "+subModel.getJoinProperty()+".getValue(), start:0, limit:10},\n";
    			store[1] += "scope: this,\n";
    			store[1] += "callback: function(records, operation, success) {\n";
    			store[1] += "if (success) {\n";
    			store[1] += "__CALL__\n";
    			store[1] += "}\n";
    			store[1] += "}\n";
    			store[1] += "});\n";
    			store[2] = "subModel_"+((subModel.getNameModel() != null) ? subModel.getNameModel() : this.getNameClass(subModel.getClassModel()))+".store.reload({params: {"+subModel.getJoinProperty()+": -1, start:0, limit:10}});";
    			store[3] = "subModel_"+((subModel.getNameModel() != null) ? subModel.getNameModel() : this.getNameClass(subModel.getClassModel()))+".store.reload({\n";
    			store[3] += "params: {"+subModel.getJoinProperty()+": -1, start:0, limit:10},\n";
    			store[3] += "scope: this,\n";
    			store[3] += "callback: function(records, operation, success) {\n";
    			store[3] += "if (success) {\n";
    			store[3] += "__CALL__\n";
    			store[3] += "}\n";
    			store[3] += "}\n";
    			store[3] += "});\n";

    			listStoresSubModel.add(store);
    		  }
    		  int size = listStoresSubModel.size()-1;
    		  String calls = "__CALL__";
    		  String callsEmpty = "__CALL__";
    		  
    		  if(listStoresSubModel.size() == 1){
    			calls = calls.replace("__CALL__", listStoresSubModel.get(0)[0]);
    		  }else{
        		  for (int i=0;i<listStoresSubModel.size();i++) {
    				if((i-size) == 0){
    					calls = calls.replace("__CALL__", listStoresSubModel.get(i)[0]);
    				}else{
    					calls = calls.replace("__CALL__", listStoresSubModel.get(i)[1]);
    				}
        		  }
    		  }

    		  if(listStoresSubModel.size() == 1){
    			callsEmpty = callsEmpty.replace("__CALL__", listStoresSubModel.get(0)[2]);
    		  }else{
        		  for (int i=0;i<listStoresSubModel.size();i++) {
    				if((i-size) == 0){
    					callsEmpty = callsEmpty.replace("__CALL__", listStoresSubModel.get(i)[2]);
    				}else{
    					callsEmpty = callsEmpty.replace("__CALL__", listStoresSubModel.get(i)[3]);
    				}
        		  }
    		  }



    		  velocityContext.put("callStoresLoad", calls);
    		  velocityContext.put("callStoresLoadEmpty", callsEmpty);
    		  velocityContext.put("subModels", listSubmodels);
    		
	      		File file = new File(crud.getPathAppExtJs()+"/controller/"+crud.getName());
	      		if(!file.exists()){
	      			file.mkdirs();
	      		}
    		  
    		  template.merge(velocityContext, stringWriter);
    		  nombre = crud.getPathAppExtJs()  + "/controller/" +crud.getName() + "/" + nameControllerExtJs + ".js";
    		  this.createFile(nombre, stringWriter.toString());
    		  System.out.println("Controller with SubModels ExtJs created : " + nombre);
                  stringOutput += "Controller with SubModels ExtJs created : " + nombre + "\n";
    		  
      		  Template templateSubModel = velocityEngine.getTemplate(pathTemplate+"ControllerExtJs5SubModel.vm", "UTF-8");
      		  
      		for (SubModel subModel : subModels) {
        		  String nameControllerExtJsSubModel = (subModel.getNameModel() != null) ? subModel.getNameModel()+"Controller" : this.getNameClass(subModel.getClassModel())+"Controller";

          		  velocityContext.put("datetimeCreate", datetimeCreate);
        		  velocityContext.put("anho", anho.toString());
        		  velocityContext.put("nameApp", crud.getNameApp());
        		  
          		  velocityContext.put("nameControllerExtJs", nameControllerExtJsSubModel);
          		  velocityContext.put("name", crud.getName());
          		  velocityContext.put("idProperty", model.getIdProperty());
          		  velocityContext.put("nameModel", this.getNameClass(subModel.getClassModel()));
          		  velocityContext.put("nameModelAlter", (subModel.getNameModel() != null) ? subModel.getNameModel() : this.getNameClass(subModel.getClassModel()));
          		  velocityContext.put("joinProperty", subModel.getJoinProperty());
          		  
          		  String descriptivos = "";
          		  
          		  if(subModel.getFields() != null){
          			for (pe.com.focus.generator.crud.extjs.schema.Field f : subModel.getFields().getField()) {
              			if(f.getXtype() != null){
                			  if(f.getXtype().equals("combo") || f.getXtype().equals("combobox")){
      							if(f.getDescrip() != null){
      								descriptivos += "var "+f.getName()+" = form.getForm().findField('"+f.getName()+"');\n        ";
      								descriptivos += "values."+f.getDescrip()+" = "+f.getName()+".getRawValue();\n        \n        ";
      							}else{
      								descriptivos += "var "+f.getName()+" = form.getForm().findField('"+f.getName()+"');\n        ";
      								descriptivos += "values."+(f.getName().replace("id", "descrip"))+" = "+f.getName()+".getRawValue();\n        \n        ";
      							}
      						}
              			}

              		  }
          		  }
          		  
          		velocityContext.put("descriptivos", descriptivos);
          		  
    	      	  File fileSubModel = new File(crud.getPathAppExtJs()+"/controller/"+crud.getName());
    	      		
    	      	  if(!fileSubModel.exists()){
    	      		  fileSubModel.mkdirs();
    	      	  }
    	      		
    	      	  stringWriter = new StringWriter();
    	      	  templateSubModel.merge(velocityContext, stringWriter);
          		  nombre = crud.getPathAppExtJs()  + "/controller/" +crud.getName() + "/" + nameControllerExtJsSubModel + ".js";
          		  this.createFile(nombre, stringWriter.toString());
          		  System.out.println("Controller SubModel ExtJs created : " + nombre);
                          stringOutput += "Controller SubModel ExtJs created : " + nombre + "\n";
      		}
        }
	}
	
	public void createModelExtJs(JAXBElement<Crud> menuElement) throws ClassNotFoundException, MalformedURLException{
	
        if(!menuElement.getValue().isGenerateModelFrontEnd()){
            return;
        }
        
        JAXBElement<ModelType> menuElementModelType = null;
        
        if(menuElementModelType == null){
            try {
            	
                JAXBContext jc = JAXBContext.newInstance(ModelType.class.getPackage().getName());
                Unmarshaller u = jc.createUnmarshaller();
                menuElementModelType = (JAXBElement<ModelType>) u.unmarshal(new File(GeneratorObject.configCrudBean.getXmlModel()));
                
            } catch (JAXBException ex) {
            }
        }
        
        Crud crud = menuElement.getValue();
        Model model = crud.getModel();
        VelocityContext velocityContext = new VelocityContext();
        StringWriter stringWriter = new StringWriter();
        String nombre;
        
        String[] dataTypeJava = {"integer","string","double","date"};
        String[] dataTypeExtJs = {"integer","string","float","date"};
        
//        File root = new File(model.getPathModel());
//        File sourceFile = new File(root, model.getClassModel().replace(".", "/")+".java");
//
//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        compiler.run(null, null, null, sourceFile.getPath());

//        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { root.toURI().toURL() });
//        Class<?> aClass = Class.forName(model.getClassModel(), true, classLoader);
//        
//        Field[] fields = aClass.getDeclaredFields();
		
		List<FieldBean> fieldsBean = new ArrayList<FieldBean>();
		
		for (PropertyType field : menuElementModelType.getValue().getOutputProperties().getProperty()) {
			FieldBean fieldBean = new FieldBean();
			fieldBean.setName(field.getName());
			
			for (int i=0;i<dataTypeJava.length;i++) {
				if(dataTypeJava[i].equals(field.getDataType())){
					fieldBean.setDataType(dataTypeExtJs[i]);
					break;
				}
			}
			if(!fieldBean.getName().equals("serialVersionUID")){
				fieldsBean.add(fieldBean);
			}
			
		}
		
		FieldBean ft = new FieldBean();
		ft.setName("tokenField");
		ft.setDataType("string");
		fieldsBean.add(ft);
		
		
		if(crud.isGenerateModelFrontEnd()){
			
    		File file = new File(crud.getPathAppExtJs()+"/view/"+crud.getName());
    		if(!file.exists()){
    			file.mkdirs();
    		}
    		
    		File fileModel = new File(crud.getPathAppExtJs()+"/model/"+crud.getName());
    		if(!fileModel.exists()){
    			fileModel.mkdirs();
    		}
			
			Template template = velocityEngine.getTemplate(pathTemplate+"ModelExtJs5.vm", "UTF-8");
			String nameModelExtJs = "MainModel";
 		  
			  velocityContext.put("datetimeCreate", datetimeCreate);
    		  velocityContext.put("anho", anho.toString());
    		  velocityContext.put("nameApp", crud.getNameApp());
    		  
    		  velocityContext.put("fieldsBean", fieldsBean);
    		  velocityContext.put("idProperty", model.getIdProperty());
    		  velocityContext.put("name", crud.getName());
			
			template.merge(velocityContext, stringWriter);
    		nombre = crud.getPathAppExtJs()  + "/model/" +crud.getName() + "/" + nameModelExtJs + ".js";
    		this.createFile(nombre, stringWriter.toString());
    		System.out.println("Model ExtJs created : " + nombre);
                stringOutput += "Model ExtJs created : " + nombre + "\n";
    		
    		// GridPanelExtJs5 //
    		template = velocityEngine.getTemplate(pathTemplate+"GridPanelExtJs5.vm", "UTF-8");
    		velocityContext = new VelocityContext();
    		
			velocityContext.put("datetimeCreate", datetimeCreate);
			velocityContext.put("anho", anho.toString());
    		velocityContext.put("nameApp", crud.getNameApp());
    		
    		if(crud.getTitleCrud() == null){
    			velocityContext.put("titleCrud", crud.getName());
    		}else{
    			velocityContext.put("titleCrud", crud.getTitleCrud());
    		}
    		
    		velocityContext.put("name", crud.getName());
    		
    		List<ColumnGridPanelBean> columns = new ArrayList<ColumnGridPanelBean>();
    		List<String> ignoreList = new ArrayList<String>();
    		for (FieldBean fieldBean : fieldsBean) {
    			
    			ColumnGridPanelBean column = new ColumnGridPanelBean();
    			column.setFieldModel(fieldBean.getName());
    			
    			if(model.getFields() != null){
    				if(fieldBean.getName().equals("tokenField")){
    					ignoreList.add(fieldBean.getName());
    				}else{
    					for (pe.com.focus.generator.crud.extjs.schema.Field field : model.getFields().getField()) {
        					
        					if(field.getName().equals(fieldBean.getName())){
        						
        						String ignore = (field.getIgnoreInList() == null) ? "false" : field.getIgnoreInList();
            					if(ignore.equals("true")){
            						ignoreList.add(fieldBean.getName());
            					}
            						            						
	            					if(field.getFieldLabelList() == null){
	            						
		    							if(field.getFieldLabel() == null){
	        								column.setHeader(fieldBean.getName());
	        							}else{
	        								column.setHeader(field.getFieldLabel());
	        							}
		    							
	        						}else{
	        							column.setHeader(field.getFieldLabelList());
	        						}

            						if(field.getShowInList() != null){
            							if(field.getShowInList().equals("false")){
            								column.setHidden("true");
            							}else{
            								column.setHidden("false");
            							}
            							
            						}else{
            							column.setHidden("false");
            						}
            						
            						column.setFlex(field.getFlexGridColumn());

            					break;
        					}
        					
        				}
    				}
    				
    				
    				if(column.getHeader() == null){
    					column.setHeader(fieldBean.getName());
    				}
    				if(column.getHidden() == null){
    					column.setHidden("false");
    				}
    				
    				if(column.getFlex() == null){
    					column.setFlex("115 / 100");
    				}

    			}else{
    				
    				if(!fieldBean.getName().equals("tokenField")){
    					
    					column.setHeader(fieldBean.getName());
        				column.setHidden("false");
        				column.setFlex("115 / 100");
        				
    				}else{
    					ignoreList.add(fieldBean.getName());
    				}
    				
    				
    			}
    			columns.add(column);
			}
    		
    		List<ColumnGridPanelBean> objsIgnore = new ArrayList<ColumnGridPanelBean>();
    		for(ColumnGridPanelBean column : columns){
    			for(String name : ignoreList){
    				if(name.equals(column.getFieldModel())){
    					objsIgnore.add(column);
    					break;
    				}
    			}
    		}
    		
    		for(ColumnGridPanelBean obj : objsIgnore){
    			columns.remove(obj);
    		}
    		
    		velocityContext.put("columns", columns);
    		stringWriter = new StringWriter();
    		template.merge(velocityContext, stringWriter);
    		
    		nombre = crud.getPathAppExtJs()  + "/view/"+crud.getName()+"/List.js";
    		if(crud.getType() != null){
    			if(crud.getType().equals("crud")){
    				this.createFile(nombre, stringWriter.toString());
    	    		System.out.println("GridPanel ExtJs created : " + nombre);
                        stringOutput += "GridPanel ExtJs created : " + nombre + "\n";
        		}
    		}else{
    			this.createFile(nombre, stringWriter.toString());
        		System.out.println("GridPanel ExtJs created : " + nombre);
                        stringOutput += "GridPanel ExtJs created : " + nombre + "\n";
    		}
    		
    		
    		// FormEditExtJs5 //
    		template = velocityEngine.getTemplate(pathTemplate+"FormEditExtJs5.vm", "UTF-8");
    		velocityContext = new VelocityContext();
    		
			velocityContext.put("datetimeCreate", datetimeCreate);
			velocityContext.put("anho", anho.toString());
    		velocityContext.put("nameApp", crud.getNameApp());
    		  
    		velocityContext.put("name", crud.getName());
    		
    		if(model.getTitleModel() == null){
    			velocityContext.put("titleModel", this.getNameClass(model.getClassModel()));
    		}else{
    			velocityContext.put("titleModel", model.getTitleModel());
    		}
    		
    		if(model.getWidthWindows() == null){
    			
    			if(model.getSubModels() == null){
    				velocityContext.put("widthWindows", "350");
    			}else{
    				velocityContext.put("widthWindows", "'65%'");
    			}
    			
    		}else{
    			
    			int index = model.getWidthWindows().indexOf("%");
    			if(index > -1){
    				velocityContext.put("widthWindows", "'"+model.getWidthWindows()+"'");
    			}else{
    				velocityContext.put("widthWindows", model.getWidthWindows());
    			}
    			
    		}
    		
    		List<String> fieldsProperty = new ArrayList<String>();
    		boolean isIgnore = false;
    		for (FieldBean fieldBean : fieldsBean) {
    			
    			Map<String,String> fieldProperty = new HashMap<String, String>();
    			fieldProperty.put("name", "'"+fieldBean.getName()+"'");
    			fieldProperty.put("xtype", "'textfield'");
    			fieldProperty.put("fieldLabel", "'"+fieldBean.getName()+"'");
    			
    			if(fieldBean.getName().equals(model.getIdProperty())){
    				fieldProperty.put("hidden", "true");
    				fieldProperty.put("allowBlank", "true");
    			}
    			
    			if(fieldBean.getName() != null){
					if(fieldBean.getName().equals("tokenField")){
						fieldProperty.put("allowBlank", "true");
						fieldProperty.put("hidden", "true");
					}
				}
    			
    			if(model.getTables() != null){
    				String param = "";
    				for (String table : model.getTables().split(",")) {
						if(param.equals("")){
							param += "'"+table+"'";
						}else{
							param += ",'"+table+"'";
						}
					}
    				InfoColumnsMysqlQueryCriteria criteria = new InfoColumnsMysqlQueryCriteria();
    				criteria.setTable_name(param);
    				
    				String nameDriverJDBC = PropUtil.getInstance().getPropVal("database.properties", "jdbc.driverClassName");
    				List<InfoColumnsMysqlQuery> columnsDb = null;
    				if(nameDriverJDBC.equals("com.mysql.jdbc.Driver")){
    					columnsDb = infoColumnsMysqlQueryMapper.getListQuery(criteria);
    				}else if(nameDriverJDBC.equals("org.postgresql.Driver")){
    					columnsDb = infoColumnsMysqlQueryMapper.getListQueryPostgres(criteria);
    				}
    				
    				
    				for (InfoColumnsMysqlQuery columnDb : columnsDb) {
    					
    					if(columnDb.getColumn_name().equals(fieldBean.getName())){
        					
    						if(columnDb.getCharacter_maximum_length() != null){
    							fieldProperty.put("minLength", "1");
    							fieldProperty.put("maxLength", columnDb.getCharacter_maximum_length());
    						}
    						if(columnDb.getData_type().equals("date") || columnDb.getData_type().equals("datetime") || columnDb.getData_type().equals("timestamp")){
    							fieldProperty.put("xtype", "'datefield'");
    							fieldProperty.put("format", "'d/m/Y'");
    						}
    						if(columnDb.getIs_nullable().equals("YES")){
    							fieldProperty.put("allowBlank", "true");		
    						}
    						break;
    					}

					}
    			}
    			
    			if(model.getFields() != null){
    				for (pe.com.focus.generator.crud.extjs.schema.Field field : model.getFields().getField()) {
    					
    					if(field.getName().equals(fieldBean.getName())){
    						
    						String ignore = (field.getIgnoreInForm() == null) ? "false" : field.getIgnoreInForm();
    						
    						if(ignore.equals("true")){
    							isIgnore = true;
    						}
        						
        						if(field.getFieldLabelForm() == null){
        							if(field.getFieldLabel() == null){
        								fieldProperty.put("fieldLabel","'"+fieldBean.getName()+"'");
	        						}else{
	        							fieldProperty.put("fieldLabel","'"+field.getFieldLabel()+"'");
	        						}
        						}else{
        							fieldProperty.put("fieldLabel","'"+field.getFieldLabelForm()+"'");
        						}
        						
        						if(field.getStore() != null){
        							if(field.getStore().getData() != null){
        								String textStore = "{\n											    	"; 
        								String textFields = "";
        								String[] f = field.getStore().getFields().split(",");
        								for (String tf : f) {
        									if(!textFields.equals("")){
        										textFields += ",";
        										fieldProperty.put("displayField", "'"+tf+"'");
        	    								
        									}else{
        										textFields = "fields: [";
        										fieldProperty.put("valueField", "'"+tf+"'");
        									}
        									textFields += "'"+tf+"'";
    									}
        								textFields += "],";
        								
        								textStore += textFields+"\n											    	";
        								textStore += "data : [\n											    		";
        								textStore += field.getStore().getData()+"\n											    	]\n											    }";
        								
        								
        								fieldProperty.put("store", textStore);
        								fieldProperty.put("queryMode", "'local'");

        							}else if(field.getStore().getUrl() != null){
        								String textStore = "{\n											    	"; 
        								String textFields = "";
        								String[] f = field.getStore().getFields().split(",");
        								for (String tf : f) {
        									if(!textFields.equals("")){
        										textFields += ",";
        										fieldProperty.put("displayField", "'"+tf+"'");
        	    								
        									}else{
        										textFields = "fields: [";
        										fieldProperty.put("valueField", "'"+tf+"'");
        									}
        									textFields += "'"+tf+"'";
    									}
        								textFields += "],";
        								
        								textStore += textFields+"\n											    	";
        								textStore += "proxy: {\n											    		";
        								textStore += "type: '"+((field.getStore().getTypeProxy() == null) ? "ajax" : field.getStore().getTypeProxy())+"',\n											    		";
        								textStore += "url: '"+field.getStore().getUrl()+"',\n											    		";
        								textStore += "reader: {\n											    			";
        								textStore += "type: '"+((field.getStore().getTypeReader() == null) ? "json" : field.getStore().getTypeReader())+"',\n											    			";
        								textStore += "rootProperty: '"+((field.getStore().getRootProperty() == null) ? "listRecords" : field.getStore().getRootProperty())+"'\n											    		";
        								textStore += "}\n											    	";
        								
        								textStore += "},\n											    	";
        								textStore += "autoLoad: "+((field.getStore().getAutoLoad() == null) ? "false" : field.getStore().getAutoLoad())+"\n											    }";
        								
        								fieldProperty.put("store", textStore);
        								fieldProperty.put("queryMode", "'local'");
        							}
        						}
        						
        						if(field.getListeners() != null){
        							
        							for(Listener listener : field.getListeners().getListener()){
        								
                							String textListener = "{\n											    	";
            								textListener += ""+listener.getType()+": ";
            								textListener += "function(field, newValue, oldValue) {\n\n											    		";
//            								textListener += "if(value === 0){\n											    			";
//            								textListener += "field.setValue('');\n											    		";
//            								textListener += "}\n											    		";
            								textListener += "var form = Ext.getCmp('form_crud_"+crud.getName()+"');\n											    		";
            								textListener += "var on_field = form.getForm().findField('"+listener.getOnIdField()+"');\n											    		";
            								textListener += "on_field.setDisabled(true);\n											    		";
            								textListener += "on_field.store.removeAll();\n											    		";
            								for(ParameterStore ps : listener.getParameters().getParameterStore()){
            									if(!ps.getIdFieldValue().equals("this")){
            										textListener += "var field_"+ps.getIdFieldValue()+" = form.getForm().findField('"+ps.getIdFieldValue()+"');\n											    		";
            									}
            								}
            								textListener += "on_field.store.reload({\n											    			";
            								textListener += "params: {\n											    				";
            								String params = "";
            								for(ParameterStore ps : listener.getParameters().getParameterStore()){
            										if(!params.equals("")){
            											params += ",\n											    				";
            										}
            										params += ""+ps.getNameParameter()+": "+((ps.getIdFieldValue().equals("this")) ? "field.getValue()" : ("field_" + ps.getIdFieldValue()+".getValue()"));
            								}
            								textListener += params+"\n											    			";
            								textListener += "}\n											    		";
            								textListener += "});\n											    		";
            								textListener += "on_field.setDisabled(false);\n											    		";
            								textListener += "if(oldValue != null){\n											    			";
            								textListener += "on_field.setValue('');\n											    		";
            								textListener += "}\n											    	";
            								textListener += "}\n											    }";
            								
            								
            								fieldProperty.put("listeners", textListener);
        								    								
        							}
        							
        						}
        						
        						
        						if(field.getXtype() != null){
        							fieldProperty.put("xtype", "'"+field.getXtype()+"'");
        							if(field.getXtype().equals("combobox") || field.getXtype().equals("combo")){
        								fieldProperty.put("emptyText", "'-- Seleccione Opción --'");
//        								if(field.getListeners() == null){
//        									
//        									String textListener = "{\n											    	";
//            								textListener += "change: ";
//            								textListener += "function(field, newValue, oldValue) {\n\n											    		";
////            								textListener += "if(value === 0){\n											    			";
////            								textListener += "field.setValue('');\n											    		";
////            								textListener += "}\n											    	";
//            								textListener += "}\n											    }";
//            								
//            								fieldProperty.put("listeners", textListener);
//        								}
        							}
        						}
        						
        						if(field.getVtype() != null){
        							fieldProperty.put("vtype", "'"+field.getVtype()+"'");
        						}
        						
    							if(field.getFormat() != null){
    								fieldProperty.put("format", "'"+field.getFormat()+"'");						
    							}
    							
    							if(field.getAllowBlank() != null){
    								if(field.getAllowBlank().equals("true")){
    									fieldProperty.put("allowBlank", "true");
    								}else{
    									fieldProperty.put("allowBlank", "false");
    								}
    							}
    							
    							if(field.getEmptyText() != null){
    								fieldProperty.put("emptyText", "'"+field.getEmptyText()+"'");
    							}
    							
    							if(field.getMinLength() != null){
    								fieldProperty.put("minLength", field.getMinLength().toString());
    							}
    							
    							if(field.getMaxLength() != null){
    								fieldProperty.put("maxLength", field.getMaxLength().toString());
    							}
    							
    							if(field.getQueryMode() != null){
    								fieldProperty.put("queryMode", "'"+field.getQueryMode()+"'");
    							}
    							
    							if(field.getDisplayField() != null){
    								fieldProperty.put("displayField", "'"+field.getDisplayField()+"'");
    							}
    							
    							if(field.getValueField() != null){
    								fieldProperty.put("valueField", "'"+field.getValueField()+"'");
    							}
    							
    							if(field.getEditable() != null){
    								fieldProperty.put("editable", field.getEditable());
    							}
    							
    							if(field.getId() != null){
    								fieldProperty.put("id", "'"+field.getId()+"'");
    							}
    							
    							if(field.getDisabled() != null){
    								fieldProperty.put("disabled", field.getDisabled());
    							}
    							
    							if(field.getValue() != null){
    								fieldProperty.put("value", field.getValue());
    							}
    							if(field.getHidden() != null){
    								fieldProperty.put("hidden", field.getHidden());
    							}
    							if(field.getReadOnly() != null){
    								fieldProperty.put("readOnly", field.getReadOnly());
    							}
        						
        						if(field.getShowInForm() != null){
        							if(field.getShowInForm().equals("false")){
        								fieldProperty.put("hidden", "true");
        								fieldProperty.put("allowBlank", "true");
        							}else{
        								fieldProperty.put("hidden", "false");
        							}
        							
        						}else{
        							fieldProperty.put("hidden", "false");
        						}
        					
    						break;
    					}

    				}
    			}
    			String field = "";
    			
    			for (Map.Entry<String, String> entry : fieldProperty.entrySet())
    			{
    				if(!field.equals("")){
        				field = field + ",\n											    ";
        			}
    					
    				field += entry.getKey()+" : " +entry.getValue();
    			}
    			if(!isIgnore){
    				fieldsProperty.add(field);
    			}
    			isIgnore = false;
			}
    		
			velocityContext.put("fieldsProperty", fieldsProperty);
			
			if(model.getSubModels() != null){
				List<SubModel> subModels = model.getSubModels().getSubModel();
				List<String> listDetails = new ArrayList<String>();
				for (SubModel subModel : subModels) {
					
					String detail = "";
					
					if(subModel.getTitleModel() == null){
		    			detail = "title: '"+this.getNameClass(subModel.getClassModel())+"',\n					    		";
		    		}else{
		    			detail = "title: '"+subModel.getTitleModel()+"',\n					    		";
		    		}
					
					detail += "glyph:'xf022@FontAwesome',\n					    		";
					detail += "items: [{id:'subModel_"+((subModel.getNameModel() != null) ? subModel.getNameModel() : this.getNameClass(subModel.getClassModel()))+"', xtype:'"+((subModel.getNameModel() != null) ? subModel.getNameModel() : this.getNameClass(subModel.getClassModel()))+"List'}]";
					listDetails.add(detail);
				}
				velocityContext.put("detailSubModels", listDetails);
				velocityContext.put("cantSubModels", listDetails.size());
			}else{
				velocityContext.put("cantSubModels", 0);
			}
			
			
    		stringWriter = new StringWriter();
    		template.merge(velocityContext, stringWriter);
    		
    		nombre = crud.getPathAppExtJs()  + "/view/"+crud.getName()+"/Edit.js";
    		this.createFile(nombre, stringWriter.toString());
    		System.out.println("FormEdit ExtJs created : " + nombre);
                stringOutput += "FormEdit ExtJs created : " + nombre + "\n";
    		
		}
	}
	
	public void createSubModelExtJs(JAXBElement<Crud> menuElement) throws ClassNotFoundException, MalformedURLException{
		
                if(!menuElement.getValue().isGenerateModelFrontEnd()){
                    return;
                }
        
                JAXBElement<ModelType> menuElementModelType = null;

                if(menuElementModelType == null){
                    try {
                      
                        JAXBContext jc = JAXBContext.newInstance(ModelType.class.getPackage().getName());
                        Unmarshaller u = jc.createUnmarshaller();
                        menuElementModelType = (JAXBElement<ModelType>) u.unmarshal(new File(GeneratorObject.configCrudBean.getXmlModel()));
                        
                    } catch (JAXBException ex) {
                    }
                }
                
		Crud crud = menuElement.getValue();

		if(crud.getModel().getSubModels() != null){
			
			List<SubModel> subModels = crud.getModel().getSubModels().getSubModel();
			
			for (SubModel model : subModels) {
			       VelocityContext velocityContext = new VelocityContext();
			        StringWriter stringWriter = new StringWriter();
			        String nombre;
			        
			        String[] dataTypeJava = {"integer","string","double","date"};
			        String[] dataTypeExtJs = {"integer","string","float","date"};
			         
//			        File root = new File(crud.getModel().getPathModel());
//			        File sourceFile = new File(root, model.getClassModel().replace(".", "/")+".java");
//
//			        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//			        compiler.run(null, null, null, sourceFile.getPath());
//
//			        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { root.toURI().toURL() });
//			        Class<?> aClass = Class.forName(model.getClassModel(), true, classLoader); // Should print "hello".
//
//					Field[] fields = aClass.getDeclaredFields();
			        
			        ModelType subModelType = null;
			        for (ModelType modelType : menuElementModelType.getValue().getSubModels().getSubModel()) {
			        	
			        	int index = model.getClassModel().indexOf(modelType.getName());
			        	
			        	if(index>=0){
			        		subModelType = modelType;
			        	}
					}
			        
					List<FieldBean> fieldsBean = new ArrayList<FieldBean>();
					
					for (PropertyType field : subModelType.getOutputProperties().getProperty()) {
						FieldBean fieldBean = new FieldBean();
						fieldBean.setName(field.getName());
						
						for (int i=0;i<dataTypeJava.length;i++) {
							if(dataTypeJava[i].equals(field.getDataType())){
								fieldBean.setDataType(dataTypeExtJs[i]);
								break;
							}
						}
						
						if(!fieldBean.getName().equals("serialVersionUID")){
							fieldsBean.add(fieldBean);
						}
					}
					
					if(crud.isGenerateModelFrontEnd()){
						
			    		File file = new File(crud.getPathAppExtJs()+"/view/"+crud.getName());
			    		if(!file.exists()){
			    			file.mkdirs();
			    		}
			    		
			    		File fileModel = new File(crud.getPathAppExtJs()+"/model/"+crud.getName());
			    		if(!fileModel.exists()){
			    			fileModel.mkdirs();
			    		}
						
						Template template = velocityEngine.getTemplate(pathTemplate+"ModelExtJs5SubModel.vm", "UTF-8");
						String nameModelExtJs = (model.getNameModel() != null) ? model.getNameModel()+"Model" : this.getNameClass(model.getClassModel())+"Model";
			 		  
						  velocityContext.put("datetimeCreate", datetimeCreate);
			    		  velocityContext.put("anho", anho.toString());
			    		  velocityContext.put("nameApp", crud.getNameApp());
			    		  
			    		  velocityContext.put("fieldsBean", fieldsBean);
			    		  velocityContext.put("idProperty", model.getIdProperty());
			    		  velocityContext.put("name", crud.getName());
			    		  velocityContext.put("nameModel", this.getNameClass(model.getClassModel()));
			    		  velocityContext.put("nameModelAlter", (model.getNameModel() != null) ? model.getNameModel() : this.getNameClass(model.getClassModel()));
						
						template.merge(velocityContext, stringWriter);
			    		nombre = crud.getPathAppExtJs()  + "/model/" +crud.getName() + "/" + nameModelExtJs + ".js";
			    		this.createFile(nombre, stringWriter.toString());
			    		System.out.println("Sub Model ExtJs created : " + nombre);
                                        stringOutput += "Sub Model ExtJs created : " + nombre + "\n";
			    		
			    		// GridPanelExtJs5SubModel //
			    		template = velocityEngine.getTemplate(pathTemplate+"GridPanelExtJs5SubModel.vm", "UTF-8");
			    		velocityContext = new VelocityContext();
			    		
						velocityContext.put("datetimeCreate", datetimeCreate);
						velocityContext.put("anho", anho.toString());
			    		velocityContext.put("nameApp", crud.getNameApp());
			    		  
			    		velocityContext.put("name", crud.getName());
			    		velocityContext.put("nameModel", this.getNameClass(model.getClassModel()));
			    		velocityContext.put("nameModelAlter", (model.getNameModel() != null) ? model.getNameModel() : this.getNameClass(model.getClassModel()));
			    		
			    		List<ColumnGridPanelBean> columns = new ArrayList<ColumnGridPanelBean>();
			    		List<String> ignoreList = new ArrayList<String>();
			    		for (FieldBean fieldBean : fieldsBean) {
			    			
			    			ColumnGridPanelBean column = new ColumnGridPanelBean();
			    			column.setFieldModel(fieldBean.getName());
			    			
			    			if(model.getFields() != null){
			    				for (pe.com.focus.generator.crud.extjs.schema.Field field : model.getFields().getField()) {
			    					
			    					if(field.getName().equals(fieldBean.getName())){
			    						
			    						String ignore = (field.getIgnoreInList() == null) ? "false" : field.getIgnoreInList();
			        					if(ignore.equals("true")){
			        						ignoreList.add(fieldBean.getName());
			        					}
				    						
//			        					column.setHeader((field.getFieldLabel()==null) ? fieldBean.getName() : field.getFieldLabel() );

				    						if(field.getFieldLabelList() == null){
				    							if(field.getFieldLabel() == null){
		            								column.setHeader(fieldBean.getName());
		            							}else{
		            								column.setHeader(field.getFieldLabel());
		            							}
		            						}else{
		            							column.setHeader(field.getFieldLabelList());
		            						}
				    						
				    						if(field.getShowInList() != null){
				    							if(field.getShowInList().equals("false")){
				    								column.setHidden("true");
				    							}else{
				    								column.setHidden("false");
				    							}
				    							
				    						}else{
				    							column.setHidden("false");
				    						}
				    						
				    						column.setFlex(field.getFlexGridColumn());

			        					break;
			    					}
			    					
			    				}
			    				
			    				if(column.getHeader() == null){
			    					column.setHeader(fieldBean.getName());
			    				}
			    				if(column.getHidden() == null){
			    					column.setHidden("false");
			    				}
			    				
			    				if(column.getFlex() == null){
			    					column.setFlex("115 / 100");
			    				}

			    			}else{
			    				column.setHeader(fieldBean.getName());
			    				column.setHidden("false");
			    				column.setFlex("115 / 100");
			    			}
			    			columns.add(column);
						}
			    		
			    		List<ColumnGridPanelBean> objsIgnore = new ArrayList<ColumnGridPanelBean>();
			    		for(ColumnGridPanelBean column : columns){
			    			for(String name : ignoreList){
			    				if(name.equals(column.getFieldModel())){
			    					objsIgnore.add(column);
			    					break;
			    				}
			    			}
			    		}
			    		
			    		for(ColumnGridPanelBean obj : objsIgnore){
			    			columns.remove(obj);
			    		}
			    		
			    		velocityContext.put("columns", columns);
			    		stringWriter = new StringWriter();
			    		template.merge(velocityContext, stringWriter);
			    		
			    		nombre = crud.getPathAppExtJs()  + "/view/"+crud.getName()+"/"+((model.getNameModel() != null) ? model.getNameModel()+"List.js" : this.getNameClass(model.getClassModel())+"List.js");
			    		this.createFile(nombre, stringWriter.toString());
			    		System.out.println("Sub SubModel GridPanel ExtJs created : " + nombre); 
                                        stringOutput += "Sub SubModel GridPanel ExtJs created : " + nombre + "\n";
			    		
			    		// FormEditExtJs5SubModel //
			    		template = velocityEngine.getTemplate(pathTemplate+"FormEditExtJs5SubModel.vm", "UTF-8");
			    		velocityContext = new VelocityContext();
			    		
						velocityContext.put("datetimeCreate", datetimeCreate);
						velocityContext.put("anho", anho.toString());
			    		velocityContext.put("nameApp", crud.getNameApp());
			    		  
			    		velocityContext.put("name", crud.getName());
			    		velocityContext.put("nameModel", this.getNameClass(model.getClassModel()));
			    		velocityContext.put("nameModelAlter", (model.getNameModel() != null) ? model.getNameModel() : this.getNameClass(model.getClassModel()));
			    	
			    		if(model.getWidthWindows() == null){
			    			velocityContext.put("widthWindows", "350");
			    		}else{
			    			
			    			int index = model.getWidthWindows().indexOf("%");
			    			if(index > -1){
			    				velocityContext.put("widthWindows", "'"+model.getWidthWindows()+"'");
			    			}else{
			    				velocityContext.put("widthWindows", model.getWidthWindows());
			    			}
			    			
			    		}
			    		
			    		List<String> fieldsProperty = new ArrayList<String>();
			    		boolean isIgnore = false;
			    		for (FieldBean fieldBean : fieldsBean) {
			    			
			    			Map<String,String> fieldProperty = new HashMap<String, String>();
			    			fieldProperty.put("name", "'"+fieldBean.getName()+"'");
			    			fieldProperty.put("xtype", "'textfield'");
			    			fieldProperty.put("fieldLabel", "'"+fieldBean.getName()+"'");
			    			if(fieldBean.getName().equals(model.getIdProperty())){
			    				fieldProperty.put("hidden", "true");
			    	            fieldProperty.put("allowBlank", "true");
			    			}
			    			
			    			if(model.getTables() != null){
			    				String param = "";
			    				for (String table : model.getTables().split(",")) {
									if(param.equals("")){
										param += "'"+table+"'";
									}else{
										param += ",'"+table+"'";
									}
								}
			    				
			    				InfoColumnsMysqlQueryCriteria criteria = new InfoColumnsMysqlQueryCriteria();
			    				criteria.setTable_name(param);
			    				
			    				String nameDriverJDBC = PropUtil.getInstance().getPropVal("database.properties", "jdbc.driverClassName");
			    				List<InfoColumnsMysqlQuery> columnsDb = null;
			    				if(nameDriverJDBC.equals("com.mysql.jdbc.Driver")){
			    					columnsDb = infoColumnsMysqlQueryMapper.getListQuery(criteria);
			    				}else if(nameDriverJDBC.equals("org.postgresql.Driver")){
			    					columnsDb = infoColumnsMysqlQueryMapper.getListQueryPostgres(criteria);
			    				}

			    				
			    				for (InfoColumnsMysqlQuery columnDb : columnsDb) {
			    					
			    					if(columnDb.getColumn_name().equals(fieldBean.getName())){
			        					
			    						if(columnDb.getCharacter_maximum_length() != null){
			    							fieldProperty.put("minLength", "1");
			    							fieldProperty.put("maxLength", columnDb.getCharacter_maximum_length());
			    						}
			    						if(columnDb.getData_type().equals("date") || columnDb.getData_type().equals("datetime")){
			    							fieldProperty.put("xtype", "'datefield'");
			    							fieldProperty.put("format", "'d/m/Y'");
			    						}
			    						if(columnDb.getIs_nullable().equals("YES")){
			    							fieldProperty.put("allowBlank", "true");		
			    						}
			    						break;
			    					}

								}
			    			}
			    			
			    			if(model.getFields() != null){
			    				for (pe.com.focus.generator.crud.extjs.schema.Field field : model.getFields().getField()) {
			    					
			    					if(field.getName().equals(fieldBean.getName())){
			    						
			    						String ignore = (field.getIgnoreInForm() == null) ? "false" : field.getIgnoreInForm();
			    						
			    						if(ignore.equals("true")){
			    							isIgnore = true;
			    						}
			    						
//			    						fieldProperty.put("fieldLabel", "'"+((field.getFieldLabel()==null) ? fieldBean.getName() : field.getFieldLabel())+"'");
			    						
			    						if(field.getFieldLabelForm() == null){
		        							if(field.getFieldLabel() == null){
		        								fieldProperty.put("fieldLabel","'"+fieldBean.getName()+"'");
			        						}else{
			        							fieldProperty.put("fieldLabel","'"+field.getFieldLabel()+"'");
			        						}
		        						}else{
		        							fieldProperty.put("fieldLabel","'"+field.getFieldLabelForm()+"'");
		        						}
			    						
			    						if(field.getStore() != null){
			    							if(field.getStore().getData() != null){
			    								String textStore = "{\n								"; 
			    								String textFields = "";
			    								String[] f = field.getStore().getFields().split(",");
			    								for (String tf : f) {
			    									if(!textFields.equals("")){
			    										textFields += ",";
			    										fieldProperty.put("displayField", "'"+tf+"'");
			    	    								
			    									}else{
			    										textFields = "fields: [";
			    										fieldProperty.put("valueField", "'"+tf+"'");
			    									}
			    									textFields += "'"+tf+"'";
												}
			    								textFields += "],";
			    								
			    								textStore += textFields+"\n								";
			    								textStore += "data : [\n								        ";
			    								textStore += field.getStore().getData()+"\n								]\n						}";
			    								
			    								
			    								fieldProperty.put("store", textStore);
			    								fieldProperty.put("queryMode", "'local'");

			    							}else if(field.getStore().getUrl() != null){
			    								String textStore = "{\n								"; 
			    								String textFields = "";
			    								String[] f = field.getStore().getFields().split(",");
			    								for (String tf : f) {
			    									if(!textFields.equals("")){
			    										textFields += ",";
			    										fieldProperty.put("displayField", "'"+tf+"'");
			    	    								
			    									}else{
			    										textFields = "fields: [";
			    										fieldProperty.put("valueField", "'"+tf+"'");
			    									}
			    									textFields += "'"+tf+"'";
												}
			    								textFields += "],";
			    								
			    								textStore += textFields+"\n								";
			    								textStore += "proxy: {\n							         ";
			    								textStore += "type: '"+((field.getStore().getTypeProxy() == null) ? "ajax" : field.getStore().getTypeProxy())+"',\n							         ";
			    								textStore += "url: '"+field.getStore().getUrl()+"',\n							         ";
			    								textStore += "reader: {\n							             ";
			    								textStore += "type: '"+((field.getStore().getTypeReader() == null) ? "json" : field.getStore().getTypeReader())+"',\n							             ";
			    								textStore += "rootProperty: '"+((field.getStore().getRootProperty() == null) ? "listRecords" : field.getStore().getRootProperty())+"'\n							         ";
			    								textStore += "}\n						    	";
			    								
			    								textStore += "},\n								";
			    								textStore += "autoLoad: "+((field.getStore().getAutoLoad() == null) ? "false" : field.getStore().getAutoLoad())+"\n					    }";
			    								
			    								fieldProperty.put("store", textStore);
			    								fieldProperty.put("queryMode", "'local'");
			    							}
			    						}
			    						
			    						if(field.getListeners() != null){
			    							
			    							for(Listener listener : field.getListeners().getListener()){
			    								
			    									
			            							String textListener = "{\n						     ";
			        								textListener += listener.getType()+": ";
			        								textListener += "function(field, newValue, oldValue) {\n\n						          ";
			        								
			        								textListener += "var form = Ext.getCmp('form_submodel_"+this.getNameClass(model.getClassModel())+"');\n						          ";
			        								textListener += "var on_field = form.getForm().findField('"+listener.getOnIdField()+"');\n						          ";
			        								textListener += "on_field.setDisabled(true);\n						          ";
			        								textListener += "on_field.store.removeAll();\n						          ";
			        								for(ParameterStore ps : listener.getParameters().getParameterStore()){
			        									if(!ps.getIdFieldValue().equals("this")){
			        										textListener += "var field_"+ps.getIdFieldValue()+" = form.getForm().findField('"+ps.getIdFieldValue()+"');\n						          ";
			        									}
			        								}
			        								textListener += "on_field.store.reload({\n						               ";
			        								textListener += "params: {\n						                   		";
			        								String params = "";
			        								for(ParameterStore ps : listener.getParameters().getParameterStore()){
			        										if(!params.equals("")){
			        											params += ",\n						                   		";
			        										}
			        										params += ""+ps.getNameParameter()+": "+((ps.getIdFieldValue().equals("this")) ? "field.getValue()" : ("field_" + ps.getIdFieldValue()+".getValue()"));
			        								}
			        								textListener += params+"\n						               ";
			        								textListener += "}\n						          ";
			        								textListener += "});\n						          ";
			        								textListener += "on_field.setDisabled(false);\n						          ";
		            								textListener += "if(oldValue != null){\n										";
		            								textListener += "on_field.setValue('');\n						          ";
		            								textListener += "}\n						    ";
		 
			        								textListener += "}\n						}";
			        								fieldProperty.put("listeners", textListener);
			    												    								
			    							}
			    							
			    						}
			    						
			    						if(field.getXtype() != null){
			    							fieldProperty.put("xtype", "'"+field.getXtype()+"'");
			    							if(field.getXtype().equals("combobox") || field.getXtype().equals("combo")){
			    								fieldProperty.put("emptyText", "'-- Seleccione Opción --'");
//			    								if(field.getListeners() == null){
//		        									
//		        									String textListener = "{\n											    	";
//		            								textListener += "change: ";
//		            								textListener += "function(field, newValue, oldValue) {\n\n											    		";
////		            								textListener += "if(value === 0){\n											    			";
////		            								textListener += "field.setValue('');\n											    		";
////		            								textListener += "}\n											    	";
//		            								textListener += "}\n											    }";
//		            								
//		            								fieldProperty.put("listeners", textListener);
//		        								}
			    							}
			    						}
			    						
			    						if(field.getVtype() != null){
			    							fieldProperty.put("vtype", "'"+field.getVtype()+"'");
			    						}
			    						
										if(field.getFormat() != null){
											fieldProperty.put("format", "'"+field.getFormat()+"'");						
										}
										
										if(field.getAllowBlank() != null){
											if(field.getAllowBlank().equals("true")){
												fieldProperty.put("allowBlank", "true");
											}
										}
										
										if(field.getEmptyText() != null){
											fieldProperty.put("emptyText", "'"+field.getEmptyText()+"'");
										}
										
										if(field.getMinLength() != null){
											fieldProperty.put("minLength", field.getMinLength().toString());
										}
										
										if(field.getMaxLength() != null){
											fieldProperty.put("maxLength", field.getMaxLength().toString());
										}
										
										if(field.getQueryMode() != null){
											fieldProperty.put("queryMode", "'"+field.getQueryMode()+"'");
										}
										
										if(field.getDisplayField() != null){
											fieldProperty.put("displayField", "'"+field.getDisplayField()+"'");
										}
										
										if(field.getValueField() != null){
											fieldProperty.put("valueField", "'"+field.getValueField()+"'");
										}
										
										if(field.getEditable() != null){
											fieldProperty.put("editable", field.getEditable());
										}
										
										if(field.getId() != null){
											fieldProperty.put("id", "'"+field.getId()+"'");
										}
										
										if(field.getDisabled() != null){
											fieldProperty.put("disabled", field.getDisabled());
										}
										
										if(field.getValue() != null){
		    								fieldProperty.put("value", field.getValue());
		    							}
										
										if(field.getHidden() != null){
		    								fieldProperty.put("hidden", field.getHidden());
		    							}
										if(field.getReadOnly() != null){
		    								fieldProperty.put("readOnly", field.getReadOnly());
		    							}
			    						
			    						if(field.getShowInForm() != null){
			    							if(field.getShowInForm().equals("false")){
			    								fieldProperty.put("hidden", "true");
			    								fieldProperty.put("allowBlank", "true");
			    							}else{
			    								fieldProperty.put("hidden", "false");
			    							}
			    							
			    						}else{
			    							fieldProperty.put("hidden", "false");
			    						}
			    						
			    						break;
			    					}
			    					
			    				}
			    			}
			    			String field = "";
			    			for (Map.Entry<String, String> entry : fieldProperty.entrySet())
			    			{
			    				if(!field.equals("")){
			        				field = field + ",\n						";
			        			}
			    					
			    				field += entry.getKey()+" : " +entry.getValue();
			    			}
			    			if(!isIgnore){
			    				fieldsProperty.add(field);
			    			}
			    			isIgnore = false;

						}
			    		
						velocityContext.put("fieldsProperty", fieldsProperty);
			    		stringWriter = new StringWriter();
			    		template.merge(velocityContext, stringWriter);
			    		
			    		nombre = crud.getPathAppExtJs()  + "/view/"+crud.getName()+"/"+((model.getNameModel() != null) ? model.getNameModel()+"Edit.js" : this.getNameClass(model.getClassModel())+"Edit.js");
			    		this.createFile(nombre, stringWriter.toString());
			    		System.out.println("Sub SubModel FormEdit ExtJs created : " + nombre);
                                        stringOutput += "Sub SubModel FormEdit ExtJs created : " + nombre + "\n";
			    		
					}
			}
		}
        
 
	}

	public void createToolBarPagingExtJs(JAXBElement<Crud> menuElement){
		
		Crud crud = menuElement.getValue();
        VelocityContext velocityContext = new VelocityContext();
        StringWriter stringWriter = new StringWriter();
        String nombre;
        
        if(crud.isGenerateModelFrontEnd()){
        	
    		String nameToolbarPaging = "ToolbarPaging";

    		Template template = velocityEngine.getTemplate(pathTemplate+"ToolBarExtJs5.vm", "UTF-8");
    		
    		velocityContext.put("datetimeCreate", datetimeCreate);
    		velocityContext.put("anho", anho.toString());
    		velocityContext.put("nameApp", crud.getNameApp());
    		velocityContext.put("name", crud.getName());

    		File file = new File(crud.getPathAppExtJs() + "/view/"+ crud.getName());
    		if (!file.exists()) {
    			file.mkdirs();
    		}

    		template.merge(velocityContext, stringWriter);
    		nombre = crud.getPathAppExtJs() + "/view/" + crud.getName() + "/"+ nameToolbarPaging + ".js";
    		
    		if(crud.getType() != null){
    			if(crud.getType().equals("crud")){
    				this.createFile(nombre, stringWriter.toString());
    				System.out.println("ToolbarPaging ExtJs created : " + nombre);
                                stringOutput += "ToolbarPaging ExtJs created : " + nombre + "\n";
    			}
    		}else{
    			this.createFile(nombre, stringWriter.toString());
    			System.out.println("ToolbarPaging ExtJs created : " + nombre);
                        stringOutput += "ToolbarPaging ExtJs created : " + nombre + "\n";
    		}
        }
        
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void createFormFilterExtJs(JAXBElement<Crud> menuElement) throws ClassNotFoundException, MalformedURLException{
		
            if(!menuElement.getValue().isGenerateModelFrontEnd()){
                return;
            }
        
            JAXBElement<ModelType> menuElementModelType = null;

            if(menuElementModelType == null){
                try {
                  
                    JAXBContext jc = JAXBContext.newInstance(ModelType.class.getPackage().getName());
                    Unmarshaller u = jc.createUnmarshaller();
                    menuElementModelType = (JAXBElement<ModelType>) u.unmarshal(new File(GeneratorObject.configCrudBean.getXmlModel()));
                    
                } catch (JAXBException ex) {
                }
            }    
        
            
		Crud crud = menuElement.getValue();
        Model model = crud.getModel();
        VelocityContext velocityContext = new VelocityContext();
        StringWriter stringWriter = new StringWriter();
        String nombre;
        
//        File root = new File(model.getPathModel());
//        File sourceFile = new File(root, model.getClassModel().replace(".", "/")+".java");
//
//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        compiler.run(null, null, null, sourceFile.getPath());

//        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { root.toURI().toURL() });
//        Class<?> aClass = Class.forName(model.getClassModel(), true, classLoader);
//
//		Field[] fields = aClass.getDeclaredFields();

//        File rootCriteria = new File(model.getPathModel());
//        File sourceFileCriteria = new File(rootCriteria, model.getClassModelCriteria().replace(".", "/")+".java");
//
//        JavaCompiler compilerCriteria = ToolProvider.getSystemJavaCompiler();
//        compilerCriteria.run(null, null, null, sourceFileCriteria.getPath());
//
//        URLClassLoader classLoaderCriteria = URLClassLoader.newInstance(new URL[] { root.toURI().toURL() });
//        Class<?> aClassCriteria = Class.forName(model.getClassModelCriteria(), true, classLoaderCriteria);
//
//		Field[] fieldsCriteria = aClassCriteria.getDeclaredFields();

		List<FieldBean> fieldsBean = new ArrayList<FieldBean>();
		
		for (PropertyType field : menuElementModelType.getValue().getInputProperties().getProperty()) {
			
			if(!field.getName().equals("order_column") && !field.getName().equals("order_direction")){
				FieldBean fieldBean = new FieldBean();
				fieldBean.setName(field.getName());
				fieldsBean.add(fieldBean);
			}
			
		}
		
		List<SortBean> sortColumns = new ArrayList<SortBean>();
		Integer i = 0;
		for (PropertyType field : menuElementModelType.getValue().getOutputProperties().getProperty()) {
			if(model.getFields() != null){
				
				for (pe.com.focus.generator.crud.extjs.schema.Field field2 : model.getFields().getField()) {
					if(field.getName().equals(field2.getName())){
						
						if(field2.getIgnoreInList() == null){
							if(field2.getShowInList() == null){
								SortBean sb = new SortBean();
								sb.setNumColumn(i);
								
								if(field2.getFieldLabelForm() == null){
									
									if(field2.getFieldLabelList() == null){
										if(field2.getFieldLabel() == null){
											sb.setNameColumn("'"+field2.getName()+"'");
										}else{
											sb.setNameColumn("'"+field2.getFieldLabel()+"'");
										}
									}else{
										sb.setNameColumn("'"+field2.getFieldLabelList()+"'");
									}
									
									
								}else{
									sb.setNameColumn("'"+field2.getFieldLabelForm()+"'");
								}
								sortColumns.add(sb);
								break;
							}
						}
						
					}
					
				}
				
			}
			i++;
		}
		
		
		
		if(crud.isGenerateModelFrontEnd()){
			
    		File file = new File(crud.getPathAppExtJs()+"/view/"+crud.getName());
    		if(!file.exists()){
    			file.mkdirs();
    		}
			
			Template template = null;
    		// FormFilterExtJs5 // 
    		template = velocityEngine.getTemplate(pathTemplate+"FormFilterExtJs5.vm", "UTF-8");
    		velocityContext = new VelocityContext();
    		
			velocityContext.put("datetimeCreate", datetimeCreate);
			velocityContext.put("anho", anho.toString());
    		velocityContext.put("nameApp", crud.getNameApp());
    		velocityContext.put("sortColumns", sortColumns);
    		  
    		velocityContext.put("name", crud.getName());
    		List container = new ArrayList();
    		List<String> fieldsProperty = new ArrayList<String>();
    		Integer j = 0;
    		pe.com.focus.generator.crud.extjs.schema.Field fieldFilter = null;
    		boolean isIgnore = false;
    		for (FieldBean fieldBean : fieldsBean) {
    			fieldFilter= null;
    			j++;
    			Map<String,String> fieldProperty = new HashMap<String, String>();
    			fieldProperty.put("name", "'"+fieldBean.getName()+"'");
    			fieldProperty.put("xtype", "'textfield'");
    			fieldProperty.put("fieldLabel", "'"+fieldBean.getName()+"'");

    			if(model.getFieldsCriteria() != null){
    				for (pe.com.focus.generator.crud.extjs.schema.Field field : model.getFieldsCriteria().getField()) {
    					
    					if(field.getName().equals(fieldBean.getName())){   					
    						fieldFilter = field;
    						break;
    					}
    					
    				}
    			}
    			
    			if(fieldFilter == null){
    				if(model.getFields() != null){
    					for (pe.com.focus.generator.crud.extjs.schema.Field f : model.getFields().getField()) {
    						if(fieldBean.getName().equals(f.getName())){
    							fieldFilter = f;
    							break;
    						}
    					}
    				}
    				
    			}
    			
    			if(fieldFilter != null){
    				
    				if(fieldFilter.getIgnoreInFilter() != null){
    					
    					if(fieldFilter.getIgnoreInFilter().equals("true")){
    						isIgnore = true;
    					}
    				}
    						
    	    				if(fieldFilter.getFieldLabelFilter() == null){
    	    					if(fieldFilter.getFieldLabelForm() == null){
    	    						
    	    						if(fieldFilter.getFieldLabel() == null){
    	    							fieldProperty.put("fieldLabel","'"+fieldBean.getName()+"'");
    	    						}else{
    	    							fieldProperty.put("fieldLabel","'"+fieldFilter.getFieldLabel()+"'");
    	    						}
    	    						
    	    					}else{
    	    						fieldProperty.put("fieldLabel","'"+fieldFilter.getFieldLabelForm()+"'");
    	    					}
    	    				}else{
    	    					fieldProperty.put("fieldLabel","'"+fieldFilter.getFieldLabelFilter()+"'");
    	    				}
    						
    	    				if(fieldFilter.getStore() != null){
    	    					if(fieldFilter.getStore().getData() != null){
    	    						String textStore = "{\n								"; 
    	    						String textFields = "";
    	    						String recordEmpty = "";
    	    						String[] f = fieldFilter.getStore().getFields().split(",");
    	    						for (String tf : f) {
    	    							
    	    							if(recordEmpty.equals("")){
    	    								recordEmpty += tf +":''";
    	    							}else{
    	    								recordEmpty += ","+tf +":'-- Todos --'";
    	    							}
    	    							
    	    							if(!textFields.equals("")){
    	    								textFields += ",";
    	    								fieldProperty.put("displayField", "'"+tf+"'");
    	    								
    	    							}else{
    	    								textFields = "fields: [";
    	    								fieldProperty.put("valueField", "'"+tf+"'");
    	    							}
    	    							textFields += "'"+tf+"'";
    	    						}
    	    						textFields += "],";
    	    						
    	    						textStore += textFields+"\n									";
    	    						textStore += "data : [\n							         ";
    	    						textStore += fieldFilter.getStore().getData()+"\n									],\n								}";
    	    						textStore += "listeners: {\n								        ";
    	    						textStore += "load: function(store) {\n								        	";
    	    						textStore += "var rec = { "+recordEmpty+" };\n								        	";
    	    						textStore += "store.insert(0, rec);\n								        ";
    	    						textStore += "}\n									";
    	    						textStore += "}\n								";
    	    						textStore += "}";

    	    						
    	    						fieldProperty.put("store", textStore);
    	    						fieldProperty.put("queryMode", "'local'");

    	    					}else if(fieldFilter.getStore().getUrl() != null){
    	    						String textStore = "{\n									"; 
    	    						String textFields = "";
    	    						String[] f = fieldFilter.getStore().getFields().split(",");
    	    						String recordEmpty = "";
    	    						for (String tf : f) {
    	    							
    	    							if(recordEmpty.equals("")){
    	    								recordEmpty += tf +":''";
    	    							}else{
    	    								recordEmpty += ","+tf +":'-- Todos --'";
    	    							}
    	    							
    	    							
    	    							if(!textFields.equals("")){
    	    								textFields += ",";
    	    								fieldProperty.put("displayField", "'"+tf+"'");
    	    								
    	    							}else{
    	    								textFields = "fields: [";
    	    								fieldProperty.put("valueField", "'"+tf+"'");
    	    							}
    	    							textFields += "'"+tf+"'";
    	    						}
    	    						textFields += "],";
    	    						
    	    						textStore += textFields+"\n									";
    	    						textStore += "proxy: {\n												";
    	    						textStore += "type: '"+((fieldFilter.getStore().getTypeProxy() == null) ? "ajax" : fieldFilter.getStore().getTypeProxy())+"',\n												";
    	    						textStore += "url: '"+fieldFilter.getStore().getUrl()+"',\n												";
    	    						textStore += "reader: {\n													";
    	    						textStore += "type: '"+((fieldFilter.getStore().getTypeReader() == null) ? "json" : fieldFilter.getStore().getTypeReader())+"',\n													";
    	    						textStore += "rootProperty: '"+((fieldFilter.getStore().getRootProperty() == null) ? "listRecords" : fieldFilter.getStore().getRootProperty())+"'\n												";
    	    						textStore += "}\n									";
    	    						
    	    						textStore += "},\n									";
    	    						textStore += "autoLoad: "+((fieldFilter.getStore().getAutoLoad() == null) ? "false" : fieldFilter.getStore().getAutoLoad())+",\n									";
    	    						textStore += "listeners: {\n								        ";
    	    						textStore += "load: function(store) {\n								        	";
    	    						textStore += "var rec = { "+recordEmpty+" };\n								        	";
    	    						textStore += "store.insert(0, rec);\n								        ";
    	    						textStore += "}\n									";
    	    						textStore += "}\n								";
    	    						textStore += "}";
    	    						fieldProperty.put("store", textStore);
    	    						fieldProperty.put("queryMode", "'local'");
    	    					}
    	    				}
    	    				
    	    				
    	    				if(fieldFilter.getListeners() != null){
    	    					
    	    					for(Listener listener : fieldFilter.getListeners().getListener()){
    	    						
    	    							
    	    							String textListener = "{\n									";
    	    							textListener += ""+listener.getType()+": ";
    	    							textListener += "function(field, newValue, oldValue) {\n\n										";
    	    							textListener += "var on_field = form.getForm().findField('"+listener.getOnIdField()+"');\n										";
    	    							textListener += "on_field.setDisabled(true);\n										";
    	    							textListener += "on_field.store.removeAll();\n										";
    	    							for(ParameterStore ps : listener.getParameters().getParameterStore()){
    	    								if(!ps.getIdFieldValue().equals("this")){
    	    									textListener += "var field_"+ps.getIdFieldValue()+" = form.getForm().findField('"+ps.getIdFieldValue()+"');\n										";
    	    								}
    	    							}
    	    							textListener += "on_field.store.reload({\n											";
    	    							textListener += "params: {\n												";
    	    							String params = "";
    	    							for(ParameterStore ps : listener.getParameters().getParameterStore()){
    	    									if(!params.equals("")){
    	    										params += ",\n												";
    	    									}
    	    									params += ""+ps.getNameParameter()+": "+((ps.getIdFieldValue().equals("this")) ? "field.getValue()" : ("field_" + ps.getIdFieldValue()+".getValue()"));
    	    							}
    	    							textListener += params+"\n											";
    	    							textListener += "}\n										";
    	    							textListener += "});\n										";
    	    							textListener += "on_field.setDisabled(false);\n										";
        								textListener += "if(oldValue != null){\n											";
        								textListener += "on_field.setValue('');\n										";
        								textListener += "}\n									";

    	    							textListener += "}\n								}";
    	    							fieldProperty.put("listeners", textListener);
    	    							    								
    	    					}
    	    					
    	    				}
    	    				
    	    				if(fieldFilter.getXtype() != null){
    	    					fieldProperty.put("xtype", "'"+fieldFilter.getXtype()+"'");
    	    					if(fieldFilter.getXtype().equals("combobox") || fieldFilter.getXtype().equals("combo")){
    	    						fieldProperty.put("value", "''");
//    	    						if(fieldFilter.getListeners() == null){
//    									
//    									String textListener = "{\n											    	";
//    									textListener += "change: ";
//    									textListener += "function(field, newValue, oldValue) {\n\n											    		";
////    									textListener += "if(value === 0){\n											    			";
////    									textListener += "field.setValue('');\n											    		";
////    									textListener += "}\n											    	";
//    									textListener += "}\n											    }";
//    									
//    									fieldProperty.put("listeners", textListener);
//    								}
    	    					}
    	    				}
    	    				
    	    				if(fieldFilter.getVtype() != null){
    	    					fieldProperty.put("vtype", "'"+fieldFilter.getVtype()+"'");
    	    				}
    	    				
    	    				if(fieldFilter.getFormat() != null){
    	    					fieldProperty.put("format", "'"+fieldFilter.getFormat()+"'");						
    	    				}
    	    				
    	    				if(fieldFilter.getEmptyText() != null){
    	    					fieldProperty.put("emptyText", "'"+fieldFilter.getEmptyText()+"'");
    	    				}
    	    				
    	    				if(fieldFilter.getMinLength() != null){
    	    					fieldProperty.put("minLength", fieldFilter.getMinLength().toString());
    	    				}
    	    				
    	    				if(fieldFilter.getMaxLength() != null){
    	    					fieldProperty.put("maxLength", fieldFilter.getMaxLength().toString());
    	    				}
    	    				
    	    				if(fieldFilter.getQueryMode() != null){
    	    					fieldProperty.put("queryMode", "'"+fieldFilter.getQueryMode()+"'");
    	    				}
    	    				
    	    				if(fieldFilter.getDisplayField() != null){
    	    					fieldProperty.put("displayField", "'"+fieldFilter.getDisplayField()+"'");
    	    				}
    	    				
    	    				if(fieldFilter.getValueField() != null){
    	    					fieldProperty.put("valueField", "'"+fieldFilter.getValueField()+"'");
    	    				}
    	    				
    	    				if(fieldFilter.getEditable() != null){
    	    					fieldProperty.put("editable", fieldFilter.getEditable());
    	    				}
    	    				
    	    				if(fieldFilter.getId() != null){
    	    					fieldProperty.put("id", "'"+fieldFilter.getId()+"'");
    	    				}
    	    				
    	    				if(fieldFilter.getDisabled() != null){
    	    					fieldProperty.put("disabled", fieldFilter.getDisabled());
    	    				}
    	    				
    	    				if(fieldFilter.getValue() != null){
    	    					fieldProperty.put("value", fieldFilter.getValue());
    	    				}
    	    				
    	    				if(fieldFilter.getHidden() != null){
    							fieldProperty.put("hidden", fieldFilter.getHidden());
    						}
    	    				
    					
    				    				

    			}
    			

    			
    			String field = "";
    			for (Map.Entry<String, String> entry : fieldProperty.entrySet())
    			{

    					if(!field.equals("")){
        					field = field + ",\n								";
        				}
    					
    					field += entry.getKey()+" : " +entry.getValue();

    			}
    			
    			if(!isIgnore){
    				fieldsProperty.add(field);
    			}
    			isIgnore = false;
    			
//        		fieldsProperty.add(field);
        		
        		if(j== fieldsBean.size()){
        			container.add(fieldsProperty);
        		}else{
        			if(fieldsProperty.size() == 6){
        				List<String> list = new ArrayList<String>(fieldsProperty); 
        				container.add(list);
        				fieldsProperty.clear();
        			}
        		}
			}
    		
			velocityContext.put("container", container);

    		stringWriter = new StringWriter();
    		template.merge(velocityContext, stringWriter);
    		
    		nombre = crud.getPathAppExtJs()  + "/view/"+crud.getName()+"/Filter.js";
    		
    		if(crud.getType() != null){
    			if(crud.getType().equals("crud")){
    				this.createFile(nombre, stringWriter.toString());
    	    		System.out.println("FormFilter ExtJs created : " + nombre);
                        stringOutput += "FormFilter ExtJs created : " + nombre + "\n";
    			}
    		}else{
    			this.createFile(nombre, stringWriter.toString());
        		System.out.println("FormFilter ExtJs created : " + nombre);
                        stringOutput += "FormFilter ExtJs created : " + nombre + "\n";
    		}
		}
	}

	public String getNameSetMethod(String property){
		return "set"+property.substring(0, 1).toUpperCase() + property.substring(1, property.length());
	}
	
	public String getNameGetMethod(String property){
		return "get"+property.substring(0, 1).toUpperCase() + property.substring(1, property.length());
	}
	
	public String getNameVar(String nameClass){
		return nameClass.substring(0, 1).toLowerCase() + nameClass.substring(1, nameClass.length());
	}
	
	public String formatProperty(String property){
		return property.substring(0, 1).toUpperCase() + property.substring(1, property.length());
	}
	
	public String getNameClass(String clazz){
		
		int index = -1;
		for (int i = 0; i < clazz.length(); i++) {
			if(clazz.charAt(i) == '.'){
				index = i+1;
			}
		}
		
		return clazz.substring(index, clazz.length());
	}
	
	public String getPathClass(String clazz){
		
		int index = -1;
		for (int i = 0; i < clazz.length(); i++) {
			if(clazz.charAt(i) == '.'){
				index = i+1;
			}
		}
		
		return clazz.substring(0, index).replace(".", "/");
	}
	
	public void createFile(String nombre, String contenido) {
        try {
        	
            String fileName = nombre;
//            FileWriter fw;
            
//            fw = new FileWriter(fileName);
//
//            BufferedWriter bw = new BufferedWriter(fw);
            
            BufferedWriter bw = new BufferedWriter
                (new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8"));
            
            bw.write(contenido);
            bw.close();
//            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
