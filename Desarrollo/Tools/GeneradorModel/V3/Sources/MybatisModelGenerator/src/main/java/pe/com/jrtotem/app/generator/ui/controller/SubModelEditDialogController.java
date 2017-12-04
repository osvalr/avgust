package pe.com.jrtotem.app.generator.ui.controller;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pe.com.jrtotem.app.generator.dto.ModelInputDto;
import pe.com.jrtotem.app.generator.mybatis.domain.SubModelInput;
import pe.com.jrtotem.app.generator.mybatis.query.domain.ModelAvailableQuery;
import pe.com.jrtotem.app.generator.mybatis.query.domain.ModelAvailableQueryCriteria;
import pe.com.jrtotem.app.generator.mybatis.query.mapper.ModelAvailableQueryMapper;
import pe.com.jrtotem.app.generator.util.ConstanUtil;

public class SubModelEditDialogController {

	@FXML
    private ComboBox<ModelAvailableQuery> cbo_model;
	
	@FXML
    private Button btnSave;
    
    @FXML
    private Button btnCancel;
	
	private ModelInputDto modelInputDto;
	
	private SubModelOverviewController subModelOverviewController;
	
	private Stage dialogStage;
	
    @FXML
    private void initialize() {
    	    		
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/disk.png"));
			btnSave.setGraphic(new ImageView(image));
		}
		
		
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/cancel.png"));
			btnCancel.setGraphic(new ImageView(image));
		}

    }
	
    public void setModel(ModelInputDto modelInputDto) throws Exception {
    	
    	this.modelInputDto = modelInputDto;
    	
    	ModelAvailableQueryCriteria criteria = new ModelAvailableQueryCriteria();
    	criteria.setId_model_input(modelInputDto.getId_model_input());
    	criteria.setId_model_input_parent(modelInputDto.getId_model_input());
    	
    	List<ModelAvailableQuery> listModelAvailableQuery = this.getSubModelOverviewController().getModelInputOverViewController().getImodelInputCrudService().selectByQuery(ModelAvailableQueryMapper.class, criteria);
    	
    	cbo_model.getItems().clear();
    	
    	for (ModelAvailableQuery modelAvailableQuery : listModelAvailableQuery) {
    		cbo_model.getItems().add(modelAvailableQuery);
		}
    	
    }
    
    @FXML
    private void handleOk() {
    	
        if (isInputValid()) {
        	
        	try{
        		
            	SubModelInput entity = new SubModelInput();
            	entity.setId_model_input_parent(modelInputDto.getId_model_input());
            	entity.setId_model_input_child(cbo_model.getValue().getId_model_input().intValue());
            	
            	this.getSubModelOverviewController().getModelInputOverViewController().getImodelInputCrudService().createChild(entity);
            	
            	this.getSubModelOverviewController().reloadTable();
            	
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

    	if (cbo_model.getValue() == null) {
            errorMessage += "No valid Model!\n"; 
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
    
	public SubModelOverviewController getSubModelOverviewController() {
		return subModelOverviewController;
	}

	public void setSubModelOverviewController(SubModelOverviewController subModelOverviewController) {
		this.subModelOverviewController = subModelOverviewController;
	}

	public Stage getDialogStage() {
		return dialogStage;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
}
