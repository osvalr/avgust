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
import pe.com.jrtotem.app.generator.mybatis.domain.InfoDbConnection;
import pe.com.jrtotem.app.generator.mybatis.domain.InfoDbConnectionExample;
import pe.com.jrtotem.app.generator.service.IInfoDbConnectionCrudService;
import pe.com.jrtotem.app.generator.ui.model.InfoDbConnectionModel;
import pe.com.jrtotem.app.generator.util.ConstanUtil;

public class InfoDbConnectionOverviewController {

	@FXML
    private TableView<InfoDbConnectionModel> table;
    
	@FXML
    private TableColumn<InfoDbConnectionModel, Number> c_id_info_db_connection;
    
	@FXML
    private TableColumn<InfoDbConnectionModel, String> c_name;
	
    @FXML
    private TableColumn<InfoDbConnectionModel, String> c_url;
    
    @FXML
    private TableColumn<InfoDbConnectionModel, String> c_engine;
    
    @FXML
    private TableColumn<InfoDbConnectionModel, String> c_jdbc_class;

    @FXML
    private TableColumn<InfoDbConnectionModel, String> c_date_record;
    
    @FXML
    private Button btnNew;
    
    @FXML
    private Button btnEdit;
    
    @FXML
    private Button btnDelete;
        
    private Stage dialogStage;
    
    private ObservableList<InfoDbConnectionModel> tableData = FXCollections.observableArrayList();
    
    //Service
    private IInfoDbConnectionCrudService iInfoDbConnectionCrudService;
    
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     * @throws Exception 
     */
    public InfoDbConnectionOverviewController() throws Exception {
    	
    	this.reloadTable();    	
    	
    }
    
    public void reloadTable() throws Exception{
    	
    	tableData.clear();
    	
    	InfoDbConnectionExample example = new InfoDbConnectionExample();
    	example.createCriteria().andStateEqualTo(ConstanUtil.ESTADO_ACTIVO);
    	List<InfoDbConnection> list = this.getiInfoDbConnectionCrudService().list(example);
    	
    	for (InfoDbConnection infoDbConnection : list) {
    		
			InfoDbConnectionModel model = new InfoDbConnectionModel();
			
			String textEngine = null;
			
			if(infoDbConnection.getEngine().intValue() == ConstanUtil.MYSQL){
				textEngine = "MYSQL";
			}
			if(infoDbConnection.getEngine().intValue() == ConstanUtil.POSTGRES){
				textEngine = "POSTGRES";
			}
			if(infoDbConnection.getEngine().intValue() == ConstanUtil.ORACLE){
				textEngine = "ORACLE";
			}
			if(infoDbConnection.getEngine().intValue() == ConstanUtil.MSSQL){
				textEngine = "MSSQL";
			}
			
			model.setEngine(new SimpleStringProperty(textEngine));
			model.setName(new SimpleStringProperty(infoDbConnection.getName()));
			model.setId_info_db_connection(new SimpleIntegerProperty(infoDbConnection.getId_info_db_connection()));
			model.setUrl(new SimpleStringProperty(infoDbConnection.getUrl()));
			model.setJdbc_class(new SimpleStringProperty(infoDbConnection.getJdbc_class()));
			model.setDate_record(new SimpleStringProperty(infoDbConnection.getDate_record()));
			
			tableData.add(model);
		}
    }
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	table.setItems(tableData);
        // Initialize the person table with the two columns.
    	c_id_info_db_connection.setCellValueFactory(cellData -> cellData.getValue().getId_info_db_connection());
    	c_name.setCellValueFactory(cellData -> cellData.getValue().getName());
    	c_engine.setCellValueFactory(cellData -> cellData.getValue().getEngine());
    	c_url.setCellValueFactory(cellData -> cellData.getValue().getUrl());
    	c_jdbc_class.setCellValueFactory(cellData -> cellData.getValue().getJdbc_class());
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
    
    /**
     * Called when the user clicks on the delete button.
     * @throws Exception 
     */
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

            	InfoDbConnectionModel model = table.getItems().get(selectedIndex);
            	
            	InfoDbConnection entity = new InfoDbConnection();
            	entity.setId_info_db_connection(model.getId_info_db_connection().intValue());
            	
            	iInfoDbConnectionCrudService.remove(entity);
            	
            	table.getItems().remove(selectedIndex);
        	  
        	}
        	

        }
    }
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     * @throws Exception 
     */
    @FXML
    private void handleNew() throws Exception {
        InfoDbConnectionModel infoDbConnectionModel = new InfoDbConnectionModel();
        this.showPersonEditDialog(infoDbConnectionModel,true);
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     * @throws Exception 
     */
    @FXML
    private void handleEdit() throws Exception {
    	InfoDbConnectionModel infoDbConnectionModel = table.getSelectionModel().getSelectedItem();
        if (infoDbConnectionModel != null) {
        	
            this.showPersonEditDialog(infoDbConnectionModel,false);

        } else {
            // Nothing selected.
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("No Selection");
        	alert.setHeaderText("No Connection Selected");
        	alert.setContentText("Please select a Connection in the table.");

        	alert.showAndWait();

        }
    } 
    
    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     * 
     * @param person the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     * @throws Exception 
     */
    public boolean showPersonEditDialog(InfoDbConnectionModel infoDbConnectionModel, boolean isNew) throws Exception {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/pe/com/jrtotem/app/generator/ui/view/InfoDbConnectionEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(MainApp.primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.setResizable(false);

            // Set the person into the controller.
            InfoDbConnectionEditDialogController controller = loader.getController();
            controller.setInfoDbConnectionOverviewController(this);
            controller.setDialogStage(dialogStage);
            controller.setPerson(infoDbConnectionModel,isNew);
            
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

	public IInfoDbConnectionCrudService getiInfoDbConnectionCrudService() {
		if(iInfoDbConnectionCrudService == null){
			iInfoDbConnectionCrudService = (IInfoDbConnectionCrudService) MainApp.ctx.getBean("infoDbConnectionCrudService");
		}
		return iInfoDbConnectionCrudService;
	}

	public void setiInfoDbConnectionCrudService(IInfoDbConnectionCrudService iInfoDbConnectionCrudService) {
		this.iInfoDbConnectionCrudService = iInfoDbConnectionCrudService;
	}

	public Stage getDialogStage() {
		return dialogStage;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
    
}
