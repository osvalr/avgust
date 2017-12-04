package pe.com.jrtotem.app.generator.ui.controller;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;

import org.apache.commons.lang.SystemUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pe.com.jrtotem.app.generator.dto.BuildSettingDto;
import pe.com.jrtotem.app.generator.dto.ModelDto;
import pe.com.jrtotem.app.generator.dto.ModelInputDto;
import pe.com.jrtotem.app.generator.dto.PropertyDto;
import pe.com.jrtotem.app.generator.jaxb.ModelType;
import pe.com.jrtotem.app.generator.jaxb.ObjectFactory;
import pe.com.jrtotem.app.generator.jaxb.PropertiesType;
import pe.com.jrtotem.app.generator.jaxb.PropertyType;
import pe.com.jrtotem.app.generator.jaxb.SubModelsType;
import pe.com.jrtotem.app.generator.mybatis.domain.BuildSetting;
import pe.com.jrtotem.app.generator.mybatis.domain.BuildSettingExample;
import pe.com.jrtotem.app.generator.mybatis.domain.BuildSettingKey;
import pe.com.jrtotem.app.generator.mybatis.domain.ModelInputExample;
import pe.com.jrtotem.app.generator.mybatis.domain.SubModelInput;
import pe.com.jrtotem.app.generator.mybatis.domain.SubModelInputExample;
import pe.com.jrtotem.app.generator.mybatis.mapper.BuildSettingMapper;
import pe.com.jrtotem.app.generator.mybatis.mapper.SubModelInputMapper;
import pe.com.jrtotem.app.generator.mybatis.query.domain.SubModelQuery;
import pe.com.jrtotem.app.generator.mybatis.query.domain.SubModelQueryCriteria;
import pe.com.jrtotem.app.generator.mybatis.query.mapper.SubModelQueryMapper;
import pe.com.jrtotem.app.generator.ui.model.ModelInputModel;
import pe.com.jrtotem.app.generator.util.ConstanUtil;
import pe.com.jrtotem.app.generator.util.ModelUitl;

public class GenerateArtifactsFormController {
	
	@FXML
    private TextField txt_path_output;
	@FXML
    private Button btnChoose;
	@FXML
    private Button btnGenerateXml;
	@FXML
    private Button btnClose;
	
	@FXML
    private ComboBox<BuildSettingDto> cbo_build_setting;
	@FXML
    private Button btnRefresh;
	@FXML
    private Button btnBuilds;
	
	/*
	 * 
	 */
	
	@FXML
    private ComboBox<BuildSettingDto> cbo_build_setting_xml;
	@FXML
    private Button btnRefresh_xml;
	@FXML
    private Button btnBuilds_xml;
	
	/*
	 * 
	 */
	
	@FXML
    private Button btnGenerateArtifacts;

	private Stage dialogStage;
	
	private ModelInputOverViewController modelInputOverViewController;
	
	private ModelInputDto modelInputDto;
	
    @FXML
    private void initialize() {
    	        	
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/cog.png"));
			btnGenerateXml.setGraphic(new ImageView(image));
		}

		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/zoom.png"));
			btnChoose.setGraphic(new ImageView(image));
		}
		
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/arrow_refresh.png"));
			btnRefresh.setGraphic(new ImageView(image));
		}
		
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/wrench_orange.png"));
			btnBuilds.setGraphic(new ImageView(image));
		}
		
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/cog.png"));
			btnGenerateArtifacts.setGraphic(new ImageView(image));
		}
		
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/arrow_refresh.png"));
			btnRefresh_xml.setGraphic(new ImageView(image));
		}
		
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/wrench_orange.png"));
			btnBuilds_xml.setGraphic(new ImageView(image));
		}
    }

    @FXML
    public void loadData() throws Exception{
    	
    	cbo_build_setting.getItems().clear();
    	cbo_build_setting_xml.getItems().clear();
    	
    	BuildSettingExample example = new BuildSettingExample();
    	example.createCriteria().andStateEqualTo(ConstanUtil.ESTADO_ACTIVO);
    	
    	List<BuildSetting> list = this.getModelInputOverViewController().getImodelInputCrudService().selectByExample(BuildSettingMapper.class, example);
    	
    	ObservableList<BuildSettingDto> listDto = FXCollections.observableArrayList();
    	
    	for (BuildSetting buildSetting : list) {
			BuildSettingDto dto = new BuildSettingDto();
			dto.setId_build_setting(buildSetting.getId_build_setting());
			dto.setName_setting(buildSetting.getName_setting());
			listDto.add(dto);
		}
    	
    	cbo_build_setting.setItems(listDto);
		cbo_build_setting_xml.setItems(listDto);
    }
    
    @FXML
    private void handleBuildSettings() throws Exception {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/pe/com/jrtotem/app/generator/ui/view/BuildSettingOverview.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Build Settings");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.dialogStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.setResizable(false);

            // Set the person into the controller.
            BuildSettingOverviewController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void setModel(ModelInputModel modelInputModel) throws Exception {
    	
    	ModelInputExample example = new ModelInputExample();
		example.createCriteria().andId_model_inputEqualTo(modelInputModel.getId_model_input().get());
		
    	List<ModelInputDto> list = this.getModelInputOverViewController().getImodelInputCrudService().list(example);
    	
    	modelInputDto = list.get(0);
    	    		    
    }
    
    @FXML
    public void choose(){
    	DirectoryChooser fileChooser = new DirectoryChooser();
		if(txt_path_output.getText().equals("")){
			fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		}else{
			fileChooser.setInitialDirectory(new File(txt_path_output.getText()));
		}
		
		File result = fileChooser.showDialog(dialogStage);
		
		if (result != null) {
			
			txt_path_output.setText(result.getAbsolutePath());
			
		}
    }
    
    @FXML
    public void generateXml(){
    	
    	if(isInputValidXml()){

	    	try{
	    		
	    		BuildSettingKey key = new BuildSettingKey();
	    		key.setId_build_setting(cbo_build_setting_xml.getValue().getId_build_setting());
	    		
	    		BuildSetting buildSetting = this.getModelInputOverViewController().getImodelInputCrudService().selectByPrimaryKey(BuildSettingMapper.class, key);
	    		
	    		ObjectFactory factory = new ObjectFactory();
	            
	    		ModelType modelType = this.loadModelType(modelInputDto, buildSetting, factory);
	    		
	            SubModelsType subModelsType = factory.createSubModelsType();
	            
	            SubModelInputExample example = new SubModelInputExample();
	            example.createCriteria().andId_model_input_parentEqualTo(modelInputDto.getId_model_input());
	            
	            List<SubModelInput> list = this.getModelInputOverViewController().getImodelInputCrudService().selectByExample(SubModelInputMapper.class, example);
	            
	            for (SubModelInput subModelInput : list) {
	            	
	            	ModelInputExample modelInputExample = new ModelInputExample();
	            	modelInputExample.createCriteria().andId_model_inputEqualTo(subModelInput.getId_model_input_child());
	            	
	            	List<ModelInputDto> listModelInputDto = this.getModelInputOverViewController().getImodelInputCrudService().list(modelInputExample);
	            	
	            	for (ModelInputDto modelInputDto : listModelInputDto) {
	            		ModelType subModelType = this.loadModelType(modelInputDto, buildSetting, factory);
	            		subModelsType.getSubModel().add(subModelType);
					}
	            	
				}
	            
	            modelType.setSubModels(subModelsType);
	            
	            JAXBContext context = JAXBContext.newInstance("pe.com.jrtotem.app.generator.jaxb");
	            JAXBElement<ModelType> element = factory.createModel(modelType);
	            Marshaller marshaller = context.createMarshaller();
	            marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
	            File f = new File(txt_path_output.getText());
	            if (!f.exists()) {
	                f.mkdirs();
	            }
	            marshaller.marshal(element, new File(txt_path_output.getText() + "/" + modelInputDto.getName_model()+".xml"));
	            
	            Alert alert = new Alert(AlertType.INFORMATION);
	            alert.setTitle("Information Dialog");
	            alert.setHeaderText("Look, an Information Dialog");
	            alert.setContentText("File created successfully!");
	
	            alert.showAndWait();
	    		
	    	}catch(Exception e){
	    		ConstanUtil.showExceptionDialog(e);
	    	}
    	}
    }
    
    public ModelType loadModelType(ModelInputDto modelInputDto, BuildSetting buildSetting, ObjectFactory factory){
    	
    	ModelType modelType = factory.createModelType();
        modelType.setName(modelInputDto.getName_model());
        modelType.setMainPath(buildSetting.getMain_path());
        modelType.setModelPath(buildSetting.getModel_path());
        modelType.setCriteriaPath(buildSetting.getCriteria_path());
        modelType.setMapperPath(buildSetting.getMapper_path());
        modelType.setXmlMapperPath(buildSetting.getXml_path());
        
        ModelDto modelDto = ModelUitl.loadData(modelInputDto,buildSetting);
        
        modelType.setNameModel(modelDto.getNameModel());
    	modelType.setNameCriteria(modelDto.getNameCriteria());
    	modelType.setNameMapper(modelDto.getNameMapper());
    	modelType.setNameXmlMapper(modelDto.getNameXmlMapper());
        
    	modelType.setPackageModel(modelDto.getPackageModel());
    	modelType.setNamespaceModel(modelDto.getNamespaceModel());
    	
    	modelType.setPackageCriteria(modelDto.getPackageCriteria());
    	modelType.setNamespaceCriteria(modelDto.getNamespaceCriteria());
    	
    	modelType.setPackageMapper(modelDto.getPackageMapper());
    	modelType.setNamespaceMapper(modelDto.getNamespaceMapper());
    	
    	modelType.setPackageXmlMapper(modelDto.getPackageXmlMapper());
    	modelType.setNamespaceXmlMapper(modelDto.getNamespaceXmlMapper());
    		            
        PropertiesType outPropertiesType = factory.createPropertiesType();
        PropertiesType inputPropertiesType = factory.createPropertiesType();
        
        for(PropertyDto propertyDto: modelInputDto.getListPropertyDtos()){
        	PropertyType propertyType = factory.createPropertyType();
        	propertyType.setName(propertyDto.getName());
        	propertyType.setDataType(propertyDto.getData_type());
        	
        	if(propertyDto.getType().equals(ConstanUtil.OUT)){
        		outPropertiesType.getProperty().add(propertyType);
        	}else{
        		inputPropertiesType.getProperty().add(propertyType);
        	}
        }
         
        modelType.setInputProperties(inputPropertiesType);
        modelType.setOutputProperties(outPropertiesType);
        
        return modelType;
    }
    
    @FXML
    public void generateArtifacts(){
    	
    	if(isInputValidArtifacts()){

	    	try{
	    		
	    		BuildSettingKey key = new BuildSettingKey();
	    		key.setId_build_setting(cbo_build_setting.getValue().getId_build_setting());
	    		
	    		BuildSetting buildSetting = this.getModelInputOverViewController().getImodelInputCrudService().selectByPrimaryKey(BuildSettingMapper.class, key);
	    			            
	    		SubModelQueryCriteria criteria = new SubModelQueryCriteria();
	    		criteria.setId_model_input_parent(modelInputDto.getId_model_input());
	    		
	    		List<SubModelQuery> listSubModelQuery = this.getModelInputOverViewController().getImodelInputCrudService().selectByQuery(SubModelQueryMapper.class, criteria);
	    		
	            ModelDto modelDto = ModelUitl.loadDataArtifacts(modelInputDto,buildSetting,listSubModelQuery);
	            /**/
	            VelocityEngine velocityEngine = (VelocityEngine) MainApp.ctx.getBean("velocityEngine");
	            SimpleDateFormat formateador;
	        	String datetimeCreate;
	        	Integer anho;

	    		velocityEngine.init();
	    		
	    		formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    		datetimeCreate = formateador.format(new Date());
	    		Calendar c = Calendar.getInstance();
	    		c.setTime(new Date());
	    		anho = c.get(Calendar.YEAR);
	            
	    		VelocityContext velocityContext = new VelocityContext();
	    		velocityContext.put("datetimeCreate", datetimeCreate);
      		  	velocityContext.put("anho", anho.toString());
      		    velocityContext.put("copy", this.getCopy(velocityEngine, velocityContext, "template/copy.vm"));
        		velocityContext.put("modelDto", modelDto);

      		  	String slash = "/";
      		  	
      		  	if(SystemUtils.IS_OS_WINDOWS){
      		  	slash = "\\";
      		  	}
      		  	
      		    String fileNameModel = buildSetting.getMain_path()  + slash + buildSetting.getModel_path()+ slash + modelDto.getNameModel() +".java";
      		    String fileNameCriteria = buildSetting.getMain_path()  + slash + buildSetting.getCriteria_path()+ slash + modelDto.getNameCriteria() +".java";
      		    String fileNameMapper = buildSetting.getMain_path()  + slash + buildSetting.getMapper_path()+ slash + modelDto.getNameMapper() +".java";
      		    String fileNameXmlMapper = buildSetting.getMain_path()  + slash + buildSetting.getXml_path()+ slash + modelDto.getNameXmlMapper() +".xml";
      		  	
      		    String baseTemplate = "template/";
      		    
      		    String templateModel = baseTemplate+"model.vm";
	      		String templateCriteria = baseTemplate+"criteria.vm";
	      		String templateMapper = baseTemplate+"mapper.vm";
	      		String templateXmlMapper = baseTemplate+"xml_mapper.vm";
      		    
      		    
      		  	this.createArtifact(velocityEngine, velocityContext, templateModel, fileNameModel);
      		  	this.createArtifact(velocityEngine, velocityContext, templateCriteria, fileNameCriteria);
      		  	this.createArtifact(velocityEngine, velocityContext, templateMapper, fileNameMapper);
      		  	this.createArtifact(velocityEngine, velocityContext, templateXmlMapper, fileNameXmlMapper);
	    		
	            Alert alert = new Alert(AlertType.INFORMATION);
	            alert.setTitle("Information Dialog");
	            alert.setHeaderText("Look, an Information Dialog");
	            alert.setContentText("File created successfully!");
	
	            alert.showAndWait();
	    		
	    	}catch(Exception e){
	    		ConstanUtil.showExceptionDialog(e);
	    	}
    	}
    }
    
    public void createArtifact(VelocityEngine velocityEngine, VelocityContext velocityContext, String pathTemplate, String fileName){
    	StringWriter stringWriter = new StringWriter();
		Template template = null;
		template = velocityEngine.getTemplate(pathTemplate, "UTF-8");
		template.merge(velocityContext, stringWriter);
		ModelUitl.createFile(fileName, stringWriter.toString());
    }
    
    public String getCopy(VelocityEngine velocityEngine, VelocityContext velocityContext, String pathTemplate){
    	StringWriter stringWriter = new StringWriter();
		Template template = null;
		template = velocityEngine.getTemplate(pathTemplate, "UTF-8");
		template.merge(velocityContext, stringWriter);
		return stringWriter.toString();
    }
    
    private boolean isInputValidXml() {
        
    	String errorMessage = "";

    	if (txt_path_output.getText() == null || txt_path_output.getText().length() == 0) {
            errorMessage += "No valid Path Output!\n"; 
        }
    	
    	if (cbo_build_setting_xml.getValue() == null) {
            errorMessage += "No valid Build Path!\n"; 
        }
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("Invalid Fields");
        	alert.setHeaderText("Please correct invalid fields");
        	alert.setContentText(errorMessage);

        	alert.showAndWait();
            return false;
        }
    }
    
    private boolean isInputValidArtifacts() {
        
    	String errorMessage = "";
    	
    	if (cbo_build_setting.getValue() == null) {
            errorMessage += "No valid Build Path!\n"; 
        }
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("Invalid Fields");
        	alert.setHeaderText("Please correct invalid fields");
        	alert.setContentText(errorMessage);

        	alert.showAndWait();
            return false;
        }
    }
    
	public Stage getDialogStage() {
		return dialogStage;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public ModelInputOverViewController getModelInputOverViewController() {
		return modelInputOverViewController;
	}

	public void setModelInputOverViewController(ModelInputOverViewController modelInputOverViewController) {
		this.modelInputOverViewController = modelInputOverViewController;
	}
	
}
