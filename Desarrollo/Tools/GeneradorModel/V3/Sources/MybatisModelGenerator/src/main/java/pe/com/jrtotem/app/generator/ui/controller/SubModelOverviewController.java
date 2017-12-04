package pe.com.jrtotem.app.generator.ui.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pe.com.jrtotem.app.generator.dto.ModelInputDto;
import pe.com.jrtotem.app.generator.mybatis.domain.ModelInputExample;
import pe.com.jrtotem.app.generator.mybatis.domain.SubModelInput;
import pe.com.jrtotem.app.generator.mybatis.query.domain.SubModelQuery;
import pe.com.jrtotem.app.generator.mybatis.query.domain.SubModelQueryCriteria;
import pe.com.jrtotem.app.generator.mybatis.query.mapper.SubModelQueryMapper;
import pe.com.jrtotem.app.generator.ui.model.ModelInputModel;
import pe.com.jrtotem.app.generator.ui.model.SubModelInputModel;

public class SubModelOverviewController {
	
	@FXML
    private TableView<SubModelInputModel> table;
        
	@FXML
    private TableColumn<SubModelInputModel, String> c_name_model;
	    
    @FXML
    private Button btnNew;
    
    @FXML
    private Button btnDelete;
        
    private Stage dialogStage;
    
    private ObservableList<SubModelInputModel> tableData = FXCollections.observableArrayList();
    
    private ModelInputOverViewController modelInputOverViewController;
    
    private ModelInputDto modelInputDto;

	public Stage getDialogStage() {
		return dialogStage;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
    
    public void reloadTable() throws Exception{
    	
    	tableData.clear();
    	
    	
    	SubModelQueryCriteria criteria = new SubModelQueryCriteria();
    	criteria.setId_model_input_parent(modelInputDto.getId_model_input().intValue());
    	
    	List<SubModelQuery> list = this.getModelInputOverViewController().getImodelInputCrudService().selectByQuery(SubModelQueryMapper.class, criteria);
    	
    	for (SubModelQuery subModelQuery : list) {
    		
			SubModelInputModel model = new SubModelInputModel();
				
			model.setName_model(new SimpleStringProperty(subModelQuery.getName_model()));
			model.setId_sub_model_input(new SimpleIntegerProperty(subModelQuery.getId_sub_model_input()));
			model.setId_model_input_parent(new SimpleIntegerProperty(subModelQuery.getId_model_input_parent()));
			model.setId_model_input_child(new SimpleIntegerProperty(subModelQuery.getId_model_input_child()));
			
			tableData.add(model);
			
		}
    	
    	table.setItems(tableData);
        // Initialize the person table with the two columns.
    	c_name_model.setCellValueFactory(cellData -> cellData.getValue().getName_model());
    }
    
    @FXML
    private void initialize() {
    	
    	{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/note_add.png"));
			btnNew.setGraphic(new ImageView(image));
		}
    	{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/delete.png"));
			btnDelete.setGraphic(new ImageView(image));
		}
    }
    
    public void setModel(ModelInputModel modelInputModel) throws Exception {
    	
    	ModelInputExample example = new ModelInputExample();
		example.createCriteria().andId_model_inputEqualTo(modelInputModel.getId_model_input().get());
		
    	List<ModelInputDto> list = this.getModelInputOverViewController().getImodelInputCrudService().list(example);
    	
    	modelInputDto = list.get(0);
    	    		    
    }
    
    @FXML
    private void handleDelete() throws Exception {
        int selectedIndex = table.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
        	
        	Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.setTitle("Confirmation Dialog");
        	alert.setHeaderText("Look, a Confirmation Dialog");
        	alert.setContentText("Are you sure continue?");

        	Optional<ButtonType> result = alert.showAndWait();
        	if (result.get() == ButtonType.OK){

            	SubModelInputModel model = table.getItems().get(selectedIndex);
            	
            	SubModelInput subModelInput = new SubModelInput();
            	subModelInput.setId_sub_model_input(model.getId_sub_model_input().get());
            	this.getModelInputOverViewController().getImodelInputCrudService().removeChild(subModelInput);
            	
            	table.getItems().remove(selectedIndex);
        	  
        	}
        	

        }
    }
    
    @FXML
    private void handleNew() throws Exception {
    	SubModelInputModel modelInputSimpleModel = new SubModelInputModel();
        this.showEditDialog(modelInputSimpleModel,true);
    }
        
    public boolean showEditDialog(SubModelInputModel modelInputSimpleModel, boolean isNew) throws Exception {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/pe/com/jrtotem/app/generator/ui/view/SubModelEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.dialogStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.setResizable(false);

            // Set the person into the controller.
            SubModelEditDialogController controller = loader.getController();
            controller.setSubModelOverviewController(this);
            controller.setDialogStage(dialogStage);
            controller.setModel(this.modelInputDto);
            
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

	public ModelInputOverViewController getModelInputOverViewController() {
		return modelInputOverViewController;
	}

	public void setModelInputOverViewController(ModelInputOverViewController modelInputOverViewController) {
		this.modelInputOverViewController = modelInputOverViewController;
	}
	
}
