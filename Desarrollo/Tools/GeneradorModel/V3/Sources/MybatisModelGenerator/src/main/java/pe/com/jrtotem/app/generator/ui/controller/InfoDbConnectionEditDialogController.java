package pe.com.jrtotem.app.generator.ui.controller;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pe.com.jrtotem.app.generator.dto.EngineDto;
import pe.com.jrtotem.app.generator.mybatis.domain.InfoDbConnection;
import pe.com.jrtotem.app.generator.mybatis.domain.InfoDbConnectionExample;
import pe.com.jrtotem.app.generator.ui.model.InfoDbConnectionModel;
import pe.com.jrtotem.app.generator.util.ConnectionDatabase;
import pe.com.jrtotem.app.generator.util.ConstanUtil;


public class InfoDbConnectionEditDialogController {
	
	@FXML
    private TextField txt_name;
	
    @FXML
    private ComboBox<EngineDto> cbo_engine;
    @FXML
    private TextField txt_class;
    @FXML
    private TextField txt_url;
    @FXML
    private TextField txt_user;
    @FXML
    private TextField txt_password;
    
    @FXML
    private Button btnSave;
    
    @FXML
    private Button btnCancel;
    
    @FXML
    private Button btnTest;
    
    private Integer id;

    private InfoDbConnectionOverviewController infoDbConnectionOverviewController;
    
    List<EngineDto> listEngine = new ArrayList<>();
    
    private Stage dialogStage;
    
    private boolean isNew = false;
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	    
    	{
    		
    		EngineDto dto = new EngineDto();
    		dto.setId_engine(ConstanUtil.MYSQL);
    		dto.setDescrip_engine("MYSQL");
    		listEngine.add(dto);

    	}
    	
    	{
    		
    		EngineDto dto = new EngineDto();
    		dto.setId_engine(ConstanUtil.ORACLE);
    		dto.setDescrip_engine("ORACLE");
    		listEngine.add(dto);
    	}

		{
			
			EngineDto dto = new EngineDto();
			dto.setId_engine(ConstanUtil.POSTGRES);
			dto.setDescrip_engine("POSTGRES");
			listEngine.add(dto);
		}
		
		{
			
			EngineDto dto = new EngineDto();
			dto.setId_engine(ConstanUtil.MSSQL);
			dto.setDescrip_engine("MSSQL");
			listEngine.add(dto);
		}
		
		{
			
			EngineDto dto = new EngineDto();
			dto.setId_engine(ConstanUtil.SQLITE);
			dto.setDescrip_engine("SQLITE");
			listEngine.add(dto);
		}
    	
		ObservableList<EngineDto> options = FXCollections.observableArrayList(listEngine);
		
		cbo_engine.getItems().addAll(options);
				
		cbo_engine.valueProperty().addListener(new ChangeListener<EngineDto>() {
			@Override
			public void changed(ObservableValue<? extends EngineDto> observable, EngineDto oldValue, EngineDto newValue) {
				
				String url="";
				String jdbcClass="";
				
					if(newValue.getId_engine().intValue() == ConstanUtil.MYSQL){
						
						url = ConstanUtil.URL_CONNECTION_MYSQL;
						jdbcClass = ConstanUtil.DRIVER_CLASS_MYSQL;
						
			    	}
			    	
			    	if(newValue.getId_engine().intValue() == ConstanUtil.POSTGRES){
			    		
			    		url = ConstanUtil.URL_CONNECTION_POSTGRES;
						jdbcClass = ConstanUtil.DRIVER_CLASS_POSTGRES;
			    		
			    	}
			    	
			    	if(newValue.getId_engine().intValue() == ConstanUtil.ORACLE){
			    		
			    		url = ConstanUtil.URL_CONNECTION_ORACLE;
						jdbcClass = ConstanUtil.DRIVER_CLASS_ORACLE;
			    		
			    	}
			    	
			    	if(newValue.getId_engine().intValue() == ConstanUtil.MSSQL){
			    		
			    		url = ConstanUtil.URL_CONNECTION_MSSQL;
						jdbcClass = ConstanUtil.DRIVER_CLASS_MSSQL;
			    		
			    	}
			    	
			    	if(newValue.getId_engine().intValue() == ConstanUtil.SQLITE){
			    		
			    		url = ConstanUtil.URL_CONNECTION_SQLITE;
						jdbcClass = ConstanUtil.DRIVER_CLASS_SQLITE;
			    		
			    	}
			    				    	
			    	txt_url.setText(url);
		    		txt_class.setText(jdbcClass);
				}
	    });
		
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/disk.png"));
			btnSave.setGraphic(new ImageView(image));
		}
		
		
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/cancel.png"));
			btnCancel.setGraphic(new ImageView(image));
		}
		
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/database_lightning.png"));
			btnTest.setGraphic(new ImageView(image));
		}
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    /**
     * Sets the person to be edited in the dialog.
     * 
     * @param person
     * @throws Exception 
     */
    public void setPerson(InfoDbConnectionModel infoDbConnectionModel, boolean isNew) throws Exception {
        
    	this.isNew = isNew;
    	
    	if(!this.isNew){
    		
    		InfoDbConnectionExample example = new InfoDbConnectionExample();
    		example.createCriteria().andId_info_db_connectionEqualTo(infoDbConnectionModel.getId_info_db_connection().get());
    		
        	List<InfoDbConnection> list = this.getInfoDbConnectionOverviewController().getiInfoDbConnectionCrudService().list(example);
        	
        	for (InfoDbConnection infoDbConnection : list) {
        		
        		for (EngineDto dto : listEngine) {
					if(dto.getId_engine().intValue() == infoDbConnection.getEngine().intValue()){
						cbo_engine.setValue(dto);
					}
				}
        		
        		txt_name.setText(infoDbConnection.getName());
        		txt_class.setText(infoDbConnection.getJdbc_class());
                txt_url.setText(infoDbConnection.getUrl());
                txt_user.setText(infoDbConnection.getName_user());
                txt_password.setText(infoDbConnection.getPassword_user());
                id = infoDbConnection.getId_info_db_connection().intValue();
                
			}
    		
    	}else{
    		
    		id=null;
    		
    	}
    
    }

    /**
     * Called when the user clicks ok.
     * @throws Exception 
     */
    @FXML
    private void handleOk() {
    	
        if (isInputValid()) {
        	
        	try{
        		
            	InfoDbConnection entity = new InfoDbConnection();
            	entity.setName(txt_name.getText());
            	entity.setEngine(cbo_engine.getValue().getId_engine());
            	entity.setJdbc_class(txt_class.getText());
            	entity.setUrl(txt_url.getText());
            	entity.setName_user(txt_user.getText());
            	entity.setPassword_user(txt_password.getText());
            	entity.setState(ConstanUtil.ESTADO_ACTIVO);
            	entity.setDate_record(ConstanUtil.getDateString());
            	
            	entity.setId_info_db_connection(id);
            	
            	if(this.isNew){
            		this.getInfoDbConnectionOverviewController().getiInfoDbConnectionCrudService().create(entity);
            	}else{
            		this.getInfoDbConnectionOverviewController().getiInfoDbConnectionCrudService().save(entity);
            	}
            	
            	        	
            	this.getInfoDbConnectionOverviewController().reloadTable();
            	
            	dialogStage.close();
            	
        	}catch(Exception e){
        		
        		ConstanUtil.showExceptionDialog(e);
        		
        	}

        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        
    	String errorMessage = "";

    	if (txt_name.getText() == null || txt_name.getText().length() == 0) {
            errorMessage += "No valid Name!\n"; 
        }
    	if (cbo_engine.getValue() == null) {
            errorMessage += "No valid Engine!\n"; 
        }
        if (txt_class.getText() == null || txt_class.getText().length() == 0) {
            errorMessage += "No valid JDBC Class!\n"; 
        }
        if (txt_url.getText() == null || txt_url.getText().length() == 0) {
            errorMessage += "No valid URL!\n"; 
        }
//        if (txt_user.getText() == null || txt_user.getText().length() == 0) {
//            errorMessage += "No valid User!\n"; 
//        }

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
    
	public InfoDbConnectionOverviewController getInfoDbConnectionOverviewController() {
		return infoDbConnectionOverviewController;
	}

	public void setInfoDbConnectionOverviewController(
			InfoDbConnectionOverviewController infoDbConnectionOverviewController) {
		this.infoDbConnectionOverviewController = infoDbConnectionOverviewController;
	}
	
	@FXML
	private void testConnection(){
		
		if(this.isInputValid()){
			
			boolean test = false;
			if(cbo_engine.getValue().getId_engine().intValue() == ConstanUtil.ORACLE){
				test = ConnectionDatabase.test(txt_class.getText(), txt_url.getText(), txt_user.getText(), txt_password.getText(), ConstanUtil.QUERY_TEST_ORACLE);
			}else{
				
				if(cbo_engine.getValue().getId_engine().intValue() == ConstanUtil.SQLITE){
					test = ConnectionDatabase.test(txt_class.getText(), txt_url.getText(), ConstanUtil.QUERY_TEST);
				}else{
					test = ConnectionDatabase.test(txt_class.getText(), txt_url.getText(), txt_user.getText(), txt_password.getText(), ConstanUtil.QUERY_TEST);
				}
				
			}
			
			if(test){
								
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Success!!");

				alert.showAndWait();
				
			}
			
		}
		
	}
    
}
