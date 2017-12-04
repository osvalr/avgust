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
import pe.com.jrtotem.app.generator.mybatis.domain.InfoDbConnection;
import pe.com.jrtotem.app.generator.mybatis.domain.InfoDbConnectionKey;
import pe.com.jrtotem.app.generator.mybatis.domain.ModelInputExample;
import pe.com.jrtotem.app.generator.mybatis.mapper.InfoDbConnectionMapper;
import pe.com.jrtotem.app.generator.service.IModelInputCrudService;
import pe.com.jrtotem.app.generator.ui.model.ModelInputModel;
import pe.com.jrtotem.app.generator.util.ConstanUtil;

public class ModelInputOverViewController {
	@FXML
    private TableView<ModelInputModel> table;
    
	@FXML
    private TableColumn<ModelInputModel, Number> c_id_model_input;
    
	@FXML
    private TableColumn<ModelInputModel, String> c_name_model;
	
    @FXML
    private TableColumn<ModelInputModel, String> c_name_connection;
    
    @FXML
    private TableColumn<ModelInputModel, String> c_date_record;
    
    @FXML
    private Button btnNew;
    
    @FXML
    private Button btnEdit;
    
    @FXML
    private Button btnDelete;
    
    @FXML
    private Button btnGenerateArtifact;
    
    @FXML
    private Button btnSubModels;
        
    private ObservableList<ModelInputModel> tableData = FXCollections.observableArrayList();
    
    //Service
    private IModelInputCrudService imodelInputCrudService;
    
    public ModelInputOverViewController() throws Exception {
    	
    	this.reloadTable();    	
    	
    }
    
    @FXML
    private void initialize() {
    	
    	table.setItems(tableData);
        // Initialize the person table with the two columns.
    	c_id_model_input.setCellValueFactory(cellData -> cellData.getValue().getId_model_input());
    	c_name_model.setCellValueFactory(cellData -> cellData.getValue().getName_model());
    	c_name_connection.setCellValueFactory(cellData -> cellData.getValue().getName_connection());
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
    	{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/cog_go.png"));
			btnGenerateArtifact.setGraphic(new ImageView(image));
		}
    	{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/chart_organisation.png"));
			btnSubModels.setGraphic(new ImageView(image));
		}
    	
    }
    
    public void reloadTable() throws Exception{
    	
    	tableData.clear();
    	
    	ModelInputExample example = new ModelInputExample();
    	example.createCriteria().andStateEqualTo(ConstanUtil.ESTADO_ACTIVO);
    	List<ModelInputDto> list = this.getImodelInputCrudService().list(example);
    	
		for (ModelInputDto modelInputDto : list) {

			ModelInputModel model = new ModelInputModel();

			model.setId_model_input(new SimpleIntegerProperty(modelInputDto.getId_model_input()));
			model.setName_model(new SimpleStringProperty(modelInputDto.getName_model()));
			model.setSql_text(new SimpleStringProperty(modelInputDto.getSql_text()));
			model.setDate_record(new SimpleStringProperty(modelInputDto.getDate_record()));
			
			InfoDbConnectionKey infoDbConnectionKey = new InfoDbConnectionKey();
			infoDbConnectionKey.setId_info_db_connection(modelInputDto.getId_info_db_connection());
			
			InfoDbConnection infoDbConnection = this.getImodelInputCrudService().selectByPrimaryKey(InfoDbConnectionMapper.class, infoDbConnectionKey);
			
			model.setName_connection(new SimpleStringProperty(infoDbConnection.getName()));
			model.setId_info_db_connection(new SimpleIntegerProperty(infoDbConnection.getId_info_db_connection()));

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

        		ModelInputModel modelInputModel = table.getItems().get(selectedIndex);
            	
            	ModelInputExample modelInputExample = new ModelInputExample();
            	modelInputExample.createCriteria().andId_model_inputEqualTo(modelInputModel.getId_model_input().intValue());
            	
            	List<ModelInputDto> list = this.getImodelInputCrudService().list(modelInputExample);
            	
            	for (ModelInputDto modelInputDto : list) {
            		
            		imodelInputCrudService.remove(modelInputDto);
                	table.getItems().remove(selectedIndex);
    			}
        		
        	}
        }
    }
    
    @FXML
    private void handleNew() throws Exception {
        ModelInputModel modelInputModel = new ModelInputModel();
        this.showEditDialog(modelInputModel,true);
    }

    @FXML
    private void handleEdit() throws Exception {
    	
    	ModelInputModel modelInputModel = table.getSelectionModel().getSelectedItem();
        if (modelInputModel != null) {
        	
            this.showEditDialog(modelInputModel,false);

        } else {
            // Nothing selected.
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("No Selection");
        	alert.setHeaderText("No Model Selected");
        	alert.setContentText("Please select a Model in the table.");

        	alert.showAndWait();

        }
    } 
    
    public boolean showEditDialog(ModelInputModel modelInputModel, boolean isNew) throws Exception {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/pe/com/jrtotem/app/generator/ui/view/ModelInputEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(MainApp.primaryStage);
            Scene scene = new Scene(page);
            scene.getStylesheets().add(this.getClass().getResource("java-keywords.css").toExternalForm());
            dialogStage.setScene(scene);
            dialogStage.setResizable(false);

            // Set the person into the controller.
            ModelInputEditDialogController controller = loader.getController();
            controller.setModelInputOverViewController(this);
            controller.loadConnections();
            controller.setDialogStage(dialogStage);
            controller.setModel(modelInputModel,isNew);
            
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @FXML
    private void handleGenerateArtifacts() throws Exception {
        
    	ModelInputModel modelInputModel = table.getSelectionModel().getSelectedItem();
        if (modelInputModel != null) {
        	
        	try {
                // Load the fxml file and create a new stage for the popup dialog.
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("/pe/com/jrtotem/app/generator/ui/view/GenerateArtifactsForm.fxml"));
                AnchorPane page = (AnchorPane) loader.load();

                // Create the dialog Stage.
                Stage dialogStage = new Stage();
                dialogStage.setTitle("Generate Artifacts");
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(MainApp.primaryStage);
                Scene scene = new Scene(page);
                dialogStage.setScene(scene);
                dialogStage.setResizable(false);

                // Set the person into the controller.
                GenerateArtifactsFormController controller = loader.getController();
                controller.setDialogStage(dialogStage);
                controller.setModelInputOverViewController(this);
                controller.setModel(modelInputModel);
                controller.loadData();
                
                // Show the dialog and wait until the user closes it
                dialogStage.showAndWait();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            // Nothing selected.
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("No Selection");
        	alert.setHeaderText("No record Selected");
        	alert.setContentText("Please select a record in the table.");

        	alert.showAndWait();

        }
    	
    }
    
    @FXML
    private void handleSubModels() throws Exception {
        
    	ModelInputModel modelInputModel = table.getSelectionModel().getSelectedItem();
        if (modelInputModel != null) {
        	
        	try {
                // Load the fxml file and create a new stage for the popup dialog.
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("/pe/com/jrtotem/app/generator/ui/view/SubModelOverview.fxml"));
                AnchorPane page = (AnchorPane) loader.load();

                // Create the dialog Stage.
                Stage dialogStage = new Stage();
                dialogStage.setTitle("Sub Models");
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(MainApp.primaryStage);
                Scene scene = new Scene(page);
                dialogStage.setScene(scene);
                dialogStage.setResizable(false);

                // Set the person into the controller.
                SubModelOverviewController controller = loader.getController();
                controller.setDialogStage(dialogStage);
                controller.setModelInputOverViewController(this);
                controller.setModel(modelInputModel);
                controller.reloadTable();
                
                // Show the dialog and wait until the user closes it
                dialogStage.showAndWait();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            // Nothing selected.
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("No Selection");
        	alert.setHeaderText("No record Selected");
        	alert.setContentText("Please select a record in the table.");

        	alert.showAndWait();

        }
    	
    }
    
	public IModelInputCrudService getImodelInputCrudService() {
		if(imodelInputCrudService == null){
			imodelInputCrudService = (IModelInputCrudService) MainApp.ctx.getBean("modelInputCrudService");
		}
		return imodelInputCrudService;
	}

	public void setImodelInputCrudService(IModelInputCrudService imodelInputCrudService) {
		this.imodelInputCrudService = imodelInputCrudService;
	}

    
    
}
