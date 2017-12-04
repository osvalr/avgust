package pe.com.jrtotem.app.generator.ui.controller;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pe.com.jrtotem.app.generator.dto.DataTypeDto;
import pe.com.jrtotem.app.generator.dto.PropertyDto;
import pe.com.jrtotem.app.generator.util.ConstanUtil;

public class ParamEditDialogController {

	@FXML
	private TextField txt_name;
	
	@FXML
	private ComboBox<String> cbo_data_type;
	
	@FXML
	private Button btnSave;
	
	@FXML
	private Button btnCancel;
	
	private Stage dialogStage;
	
	private PropertyDto propertyDto;
	
	private List<PropertyDto> listProperties;
	
	private ModelInputEditDialogController modelInputEditDialogController;
	
	@FXML
    private void initialize() throws Exception {
    	    	   
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/disk.png"));
			btnSave.setGraphic(new ImageView(image));
		}
		
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/cancel.png"));
			btnCancel.setGraphic(new ImageView(image));
		}
				
		for(DataTypeDto dataTypeDto : ConstanUtil.DATA_TYPES){
			cbo_data_type.getItems().add(dataTypeDto.getNameDataType());
		}

    }
	
	public void setData(){
		txt_name.setText(propertyDto.getName());
		cbo_data_type.setValue(propertyDto.getData_type());
	}
	
	@FXML
    private void handleOk() {
    	
        if (isInputValid()) {
        	
        	try{
        		
        		if(listProperties == null){
        			listProperties = new ArrayList<>();
        		}
        		
            	PropertyDto p = this.getModelInputEditDialogController().buscarParametro(txt_name.getText(), listProperties, propertyDto.getType());
            	
            	if(p != null){
            		
            		if(!p.getName().equals(propertyDto.getName())){
            			
            			throw new Exception("There is already a record with that name");
                		
            		}else{
            			
            			if(propertyDto.getName() == null){
            				listProperties.add(propertyDto);
            				propertyDto.setNewEntry(true);
            			}
            			
            			propertyDto.setName(txt_name.getText());
                		propertyDto.setData_type(cbo_data_type.getValue());
                		
                		if(propertyDto.getType().equals(ConstanUtil.OUT)){
                			checkDataTypesInput();
                		}
                		if(propertyDto.getType().equals(ConstanUtil.INPUT)){
                			checkDataTypesOut();
                		}
                		
                		this.getModelInputEditDialogController().loadTablesParams();
                		this.getModelInputEditDialogController().setLoaded(true);
                		
            		}
            		
            	}else if(p == null){
            		
            		if(propertyDto.getName() == null){
        				listProperties.add(propertyDto);
        				propertyDto.setNewEntry(true);
        			}
            		
            		propertyDto.setName(txt_name.getText());
            		propertyDto.setData_type(cbo_data_type.getValue());
            		            		
            		this.getModelInputEditDialogController().loadTablesParams();
            		this.getModelInputEditDialogController().setLoaded(true);
            		
            	}
            	
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

    	if (txt_name.getText() == null || txt_name.getText().length() == 0) {
            errorMessage += "No valid Name!\n"; 
        }
    	if (cbo_data_type.getValue() == null) {
            errorMessage += "No valid Data Type!\n"; 
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

	public PropertyDto getPropertyDto() {
		return propertyDto;
	}

	public void setPropertyDto(PropertyDto propertyDto) {
		this.propertyDto = propertyDto;
	}

	public List<PropertyDto> getListProperties() {
		return listProperties;
	}

	public void setListProperties(List<PropertyDto> listProperties) {
		this.listProperties = listProperties;
	}

	public ModelInputEditDialogController getModelInputEditDialogController() {
		return modelInputEditDialogController;
	}

	public void setModelInputEditDialogController(ModelInputEditDialogController modelInputEditDialogController) {
		this.modelInputEditDialogController = modelInputEditDialogController;
	}
	public PropertyDto findPropertyByNameAndType(String name,String type){
		for(PropertyDto propertyDto:listProperties){
			if(propertyDto.getType().equals(type) && propertyDto.getName().equals(name)){
				return propertyDto;
			}
		}
		return null;
	}
	public void checkDataTypesInput(){
		for (PropertyDto propertyDto : listProperties) {
			if(propertyDto.getType().equals(ConstanUtil.INPUT)){
				PropertyDto p = findPropertyByNameAndType(propertyDto.getName(), ConstanUtil.OUT);
				if(p != null){
					propertyDto.setData_type(p.getData_type());
				}
			}
		}
	}
	public void checkDataTypesOut(){
		for (PropertyDto propertyDto : listProperties) {
			if(propertyDto.getType().equals(ConstanUtil.OUT)){
				PropertyDto p = findPropertyByNameAndType(propertyDto.getName(), ConstanUtil.INPUT);
				if(p != null){
					propertyDto.setData_type(p.getData_type());
				}
			}
		}
	}
}
