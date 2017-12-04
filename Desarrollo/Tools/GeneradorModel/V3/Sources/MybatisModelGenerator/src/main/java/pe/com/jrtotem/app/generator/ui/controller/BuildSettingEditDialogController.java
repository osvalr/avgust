package pe.com.jrtotem.app.generator.ui.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SystemUtils;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import pe.com.jrtotem.app.generator.mybatis.domain.BuildSetting;
import pe.com.jrtotem.app.generator.mybatis.domain.BuildSettingExample;
import pe.com.jrtotem.app.generator.ui.model.BuildSettingModel;
import pe.com.jrtotem.app.generator.util.ConstanUtil;

public class BuildSettingEditDialogController {

	@FXML
    private TextField txt_name_build;
	
	@FXML
    private TextField txt_main_path;
	
	@FXML
    private ComboBox<String> cbo_model_path;
	
	@FXML
    private ComboBox<String> cbo_criteria_path;
	
	@FXML
    private ComboBox<String> cbo_mapper_path;
	
	@FXML
    private ComboBox<String> cbo_xml_mapper_path;
	
	@FXML
    private Button btnSave;
	
	@FXML
    private Button btnCancel;
	
	@FXML
    private Button btnChoose;
	
	@FXML
    private Button btnRefresh;
	
	private Stage dialogStage;
	
	private boolean isNew = false;
	
	private Integer id;
	
	private BuildSettingOverviewController buildSettingOverviewController;
	
    @FXML
    private void initialize() {
    	        	

		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/zoom.png"));
			btnChoose.setGraphic(new ImageView(image));
		}
		
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/arrow_refresh.png"));
			btnRefresh.setGraphic(new ImageView(image));
		}
		
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/disk.png"));
			btnSave.setGraphic(new ImageView(image));
		}
		
		
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/cancel.png"));
			btnCancel.setGraphic(new ImageView(image));
		}
		
		
    }
    
    public void setModel(BuildSettingModel buildSettingModel, boolean isNew) throws Exception {
        
    	this.isNew = isNew;
    	
    	if(!this.isNew){
    		
    		BuildSettingExample example = new BuildSettingExample();
    		example.createCriteria().andId_build_settingEqualTo(buildSettingModel.getId_build_setting().get());
    		
        	List<BuildSetting> list = this.getBuildSettingOverviewController().getiBuildSettingCrudService().list(example);
        	
        	for (BuildSetting buildSetting : list) {
        		        		
        		txt_name_build.setText(buildSetting.getName_setting());
        		txt_main_path.setText(buildSetting.getMain_path());
        		
        		loadCboPakages(txt_main_path.getText()+"/", cbo_model_path);
    			loadCboPakages(txt_main_path.getText()+"/", cbo_criteria_path);
    			loadCboPakages(txt_main_path.getText()+"/", cbo_mapper_path);
    			loadCboPakages(txt_main_path.getText()+"/", cbo_xml_mapper_path);
        		
                cbo_model_path.getSelectionModel().select(buildSetting.getModel_path());
                cbo_criteria_path.getSelectionModel().select(buildSetting.getCriteria_path());
                cbo_mapper_path.getSelectionModel().select(buildSetting.getMapper_path());
                cbo_xml_mapper_path.getSelectionModel().select(buildSetting.getXml_path());
                setId(buildSetting.getId_build_setting().intValue());
                
			}
    		
    	}else{
    		
    		setId(null);
    		
    	}
    
    }
    
    @FXML
    private void handleOk() {
    	
        if (isInputValid()) {
        	
        	try{
        		
            	BuildSetting entity = new BuildSetting();
            	entity.setName_setting(txt_name_build.getText());
            	entity.setMain_path(txt_main_path.getText());
            	entity.setModel_path(cbo_model_path.getValue());
            	entity.setCriteria_path(cbo_criteria_path.getValue());
            	entity.setMapper_path(cbo_mapper_path.getValue());
            	entity.setXml_path(cbo_xml_mapper_path.getValue());
            	entity.setState(ConstanUtil.ESTADO_ACTIVO);
            	entity.setDate_record(ConstanUtil.getDateString());
            	
            	entity.setId_build_setting(id);
            	
            	if(this.isNew){
            		this.getBuildSettingOverviewController().getiBuildSettingCrudService().create(entity);
            	}else{
            		this.getBuildSettingOverviewController().getiBuildSettingCrudService().save(entity);
            	}
            	
            	        	
            	this.getBuildSettingOverviewController().reloadTable();
            	
            	dialogStage.close();
            	
        	}catch(Exception e){
        		
        		ConstanUtil.showExceptionDialog(e);
        		
        	}

        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        
    	String errorMessage = "";

    	if (txt_name_build.getText() == null || txt_name_build.getText().length() == 0) {
            errorMessage += "No valid Name!\n"; 
        }
    	if (txt_main_path.getText() == null || txt_main_path.getText().length() == 0) {
            errorMessage += "No valid Main Path!\n"; 
        }
    	
    	if (cbo_model_path.getValue() == null) {
            errorMessage += "No valid Model Path!\n"; 
        }
        
    	if (cbo_criteria_path.getValue() == null) {
            errorMessage += "No valid Criteria Path!\n"; 
        }
    	
    	if (cbo_mapper_path.getValue() == null) {
            errorMessage += "No valid Mapper Path!\n"; 
        }
    	
    	if (cbo_xml_mapper_path.getValue() == null) {
            errorMessage += "No valid Xml Mapper Path Path!\n"; 
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

    @FXML
    private void choose() {
    	DirectoryChooser fileChooser = new DirectoryChooser();
		if(txt_main_path.getText().equals("")){
			fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		}else{
			fileChooser.setInitialDirectory(new File(txt_main_path.getText()));
		}
		
		File result = fileChooser.showDialog(dialogStage);
		
		if (result != null) {
			
			txt_main_path.setText(result.getAbsolutePath());
			
			loadCboPakages(result.getAbsolutePath()+"/", cbo_model_path);
			loadCboPakages(result.getAbsolutePath()+"/", cbo_criteria_path);
			loadCboPakages(result.getAbsolutePath()+"/", cbo_mapper_path);
			loadCboPakages(result.getAbsolutePath()+"/", cbo_xml_mapper_path);
			
		}
    }
    
    @FXML
    private void refresh() {
    	
		if(txt_main_path != null && !txt_main_path.getText().equals("")){
			loadCboPakages(txt_main_path.getText()+"/", cbo_model_path);
			loadCboPakages(txt_main_path.getText()+"/", cbo_criteria_path);
			loadCboPakages(txt_main_path.getText()+"/", cbo_mapper_path);
			loadCboPakages(txt_main_path.getText()+"/", cbo_xml_mapper_path);
		}
    }
    
    public void displayDirectoryContents(File dir,List<String> listPath) {
		
		File[] files = dir.listFiles();
		
 		for (File file : files) {
			if (file.isDirectory()) {
				
				File subDirectory = new File(file.getAbsolutePath());
				File[] listSubDirectory = subDirectory.listFiles();
				boolean existsFoder = false;
				for(File sf : listSubDirectory){
					if(sf.isDirectory()){
						existsFoder = true;
					}
				}
				if(existsFoder){
					displayDirectoryContents(file,listPath);
				}else{
					listPath.add(file.getAbsolutePath());
				}
				
			}
		}
 		
	}
	
	public void loadCboPakages(String path, ComboBox<String> cboPackage){
		
		if(SystemUtils.IS_OS_WINDOWS){
			path = path.replace("/", "\\");
		}
		File directory = new File(path);
		List<String> listPath = new ArrayList<String>();
		List<String> listPackages = new ArrayList<String>();
		displayDirectoryContents(directory, listPath);
		for (String p : listPath) {
			
			String np = p.replace(path, "");
			
			listPackages.add(np);
		}

		cboPackage.getItems().clear();

		for (String pk : listPackages) {

			cboPackage.getItems().add(pk);
		}		
		
	}
    
	public BuildSettingOverviewController getBuildSettingOverviewController() {
		return buildSettingOverviewController;
	}

	public void setBuildSettingOverviewController(BuildSettingOverviewController buildSettingOverviewController) {
		this.buildSettingOverviewController = buildSettingOverviewController;
	}

	public Stage getDialogStage() {
		return dialogStage;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
   
}
