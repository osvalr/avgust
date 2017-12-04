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
import pe.com.jrtotem.app.generator.mybatis.domain.BuildSetting;
import pe.com.jrtotem.app.generator.mybatis.domain.BuildSettingExample;
import pe.com.jrtotem.app.generator.service.IBuildSettingCrudService;
import pe.com.jrtotem.app.generator.ui.model.BuildSettingModel;
import pe.com.jrtotem.app.generator.util.ConstanUtil;

public class BuildSettingOverviewController {
	
	@FXML
    private TableView<BuildSettingModel> table;
    
	@FXML
    private TableColumn<BuildSettingModel, Number> c_id_build_setting;
    
	@FXML
    private TableColumn<BuildSettingModel, String> c_name_setting;
	    
    @FXML
    private TableColumn<BuildSettingModel, String> c_date_record;
    
    @FXML
    private Button btnNew;
    
    @FXML
    private Button btnEdit;
    
    @FXML
    private Button btnDelete;
        
    private ObservableList<BuildSettingModel> tableData = FXCollections.observableArrayList();
    
    //Service
    private IBuildSettingCrudService iBuildSettingCrudService;
    
    private Stage dialogStage;
    
    @FXML
    private void initialize() throws Exception {
    	
    	this.reloadTable();
    	
    	table.setItems(tableData);
        // Initialize the person table with the two columns.
    	c_id_build_setting.setCellValueFactory(cellData -> cellData.getValue().getId_build_setting());
    	c_name_setting.setCellValueFactory(cellData -> cellData.getValue().getName_setting());
    	c_date_record.setCellValueFactory(cellData -> cellData.getValue().getDate_record());
    	
    	{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/note_add.png"));
			btnNew.setGraphic(new ImageView(image));
		}
    	{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/pencil_go.png"));
			btnEdit.setGraphic(new ImageView(image));
		}
    	{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/delete.png"));
			btnDelete.setGraphic(new ImageView(image));
		}

    }
    
    public void reloadTable() throws Exception{
    	
    	tableData.clear();
    	
    	BuildSettingExample example = new BuildSettingExample();
    	example.createCriteria().andStateEqualTo(ConstanUtil.ESTADO_ACTIVO);
    	List<BuildSetting> list = this.getiBuildSettingCrudService().list(example);
    	
		for (BuildSetting buildSetting : list) {

			BuildSettingModel model = new BuildSettingModel();

			model.setId_build_setting(new SimpleIntegerProperty(buildSetting.getId_build_setting()));
			model.setName_setting(new SimpleStringProperty(buildSetting.getName_setting()));
			model.setDate_record(new SimpleStringProperty(buildSetting.getDate_record()));

			tableData.add(model);
		}
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

            	BuildSettingModel buildSettingModel = table.getItems().get(selectedIndex);
            	
            	BuildSettingExample buildSettingExample = new BuildSettingExample();
            	buildSettingExample.createCriteria().andId_build_settingEqualTo(buildSettingModel.getId_build_setting().intValue());
            	
            	List<BuildSetting> list = this.getiBuildSettingCrudService().list(buildSettingExample);
            	
            	for (BuildSetting buildSetting : list) {
            		
            		this.getiBuildSettingCrudService().remove(buildSetting);
                	table.getItems().remove(selectedIndex);
    			}
        		
        	}
        	
        }
    }
    
    @FXML
    private void handleNew() throws Exception {
        BuildSettingModel buildSettingModel = new BuildSettingModel();
        this.showEditDialog(buildSettingModel,true);
    }

    @FXML
    private void handleEdit() throws Exception {
    	
    	BuildSettingModel buildSettingModel = table.getSelectionModel().getSelectedItem();
        if (buildSettingModel != null) {
        	
            this.showEditDialog(buildSettingModel,false);

        } else {
            // Nothing selected.
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("No Selection");
        	alert.setHeaderText("No Model Selected");
        	alert.setContentText("Please select a Model in the table.");

        	alert.showAndWait();

        }
    } 
    
    public boolean showEditDialog(BuildSettingModel buildSettingModel, boolean isNew) throws Exception {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/pe/com/jrtotem/app/generator/ui/view/BuildSettingEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.dialogStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.setResizable(false);

            // Set the person into the controller.
            BuildSettingEditDialogController controller = loader.getController();
            controller.setBuildSettingOverviewController(this);
            controller.setDialogStage(dialogStage);
            controller.setModel(buildSettingModel,isNew);
            
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

	public IBuildSettingCrudService getiBuildSettingCrudService() {
		if(iBuildSettingCrudService == null){
			iBuildSettingCrudService = (IBuildSettingCrudService) MainApp.ctx.getBean("buildSettingCrudService");
		}
		return iBuildSettingCrudService;
	}

	public void setiBuildSettingCrudService(IBuildSettingCrudService iBuildSettingCrudService) {
		this.iBuildSettingCrudService = iBuildSettingCrudService;
	}

	public Stage getDialogStage() {
		return dialogStage;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
    
}
