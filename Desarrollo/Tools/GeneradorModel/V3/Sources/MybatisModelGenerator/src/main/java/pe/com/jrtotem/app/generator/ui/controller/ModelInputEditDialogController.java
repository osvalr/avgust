package pe.com.jrtotem.app.generator.ui.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

import com.foundationdb.sql.parser.SQLParser;
import com.foundationdb.sql.parser.StatementNode;
import com.foundationdb.sql.parser.ValueNode;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pe.com.jrtotem.app.generator.dto.ConnectionDto;
import pe.com.jrtotem.app.generator.dto.DataTypeDto;
import pe.com.jrtotem.app.generator.dto.ModelInputDto;
import pe.com.jrtotem.app.generator.dto.PropertyDto;
import pe.com.jrtotem.app.generator.dto.PropertyModel;
import pe.com.jrtotem.app.generator.mybatis.domain.InfoDbConnection;
import pe.com.jrtotem.app.generator.mybatis.domain.InfoDbConnectionExample;
import pe.com.jrtotem.app.generator.mybatis.domain.InfoDbConnectionKey;
import pe.com.jrtotem.app.generator.mybatis.domain.ModelInputExample;
import pe.com.jrtotem.app.generator.mybatis.mapper.InfoDbConnectionMapper;
import pe.com.jrtotem.app.generator.ui.model.ModelInputModel;
import pe.com.jrtotem.app.generator.util.ColumnVisitor;
import pe.com.jrtotem.app.generator.util.ConnectionDatabase;
import pe.com.jrtotem.app.generator.util.ConstanUtil;
import pe.com.jrtotem.app.generator.util.WhereVisitor;

public class ModelInputEditDialogController {
	
	@FXML
    private TextField txt_name_model;
	
    @FXML
    private ComboBox<ConnectionDto> cbo_connections;
        
    @FXML
    private CodeArea txt_sql_text = new CodeArea();
            
    @FXML
    private Button btnSave;
    
    @FXML
    private Button btnCancel;
    
    @FXML
    private Button btnLoad;
    
    @FXML
    private Button btnRefreshConnections;
    
    @FXML
    private Button btnConnections;
    
    @FXML
    private Button btnAddParamInput;
    
    @FXML
    private Button btnEditParamInput;
    
    @FXML
    private Button btnADeleteParamInput;
    
    @FXML
    private Button btnAddParamOutput;
    
    @FXML
    private Button btnEditParamOutput;
    
    @FXML
    private Button btnDeleteParamOutput;
    
    /***************/
    @FXML
    private TableView<PropertyModel> tableParamsOutput;
    
    @FXML
    private TableColumn<PropertyModel, String> c_name_param_output;
    
    @FXML
    private TableColumn<PropertyModel, String> c_data_type_param_output;
    
    @FXML
    private TableView<PropertyModel> tableParamsInput;
    
    @FXML
    private TableColumn<PropertyModel, String> c_name_param_input;
    
    @FXML
    private TableColumn<PropertyModel, String> c_data_type_param_input;
    
    private ObservableList<PropertyModel> tableDataParamsOutput;
    
    private ObservableList<PropertyModel> tableDataParamsInput;
    
    private List<PropertyDto> listProperties = new ArrayList<>();
    
    /***************/
    
    private Integer id;

    private ModelInputOverViewController modelInputOverViewController;
    
    private List<ConnectionDto> listConnections;
    
    private Stage dialogStage;
    
    private boolean isNew = false;
    
    private String outs = "";
    private String froms = "";
    private String inputs = "";
    
    private boolean isLoaded = false;
        
    @FXML
    private void initialize() throws Exception {
    	
    	txt_sql_text.setStyle("-fx-border-color: #C0C0C0; -fx-border-width: 1; "
                + "-fx-border-radius: 2; -fx-focus-color: transparent");
    	
    	txt_sql_text.setParagraphGraphicFactory(LineNumberFactory.get(txt_sql_text));
    	
    	txt_sql_text.richChanges().subscribe(change -> {
    		txt_sql_text.setStyleSpans(0, ConstanUtil.computeHighlighting(txt_sql_text.getText()));
        });
    	   
    	tableParamsInput.setRowFactory( tv -> {
    	    TableRow<PropertyModel> row = new TableRow<>();
    	    row.setOnMouseClicked(event -> {
    	        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
    	        	
    	        	PropertyModel rowData = row.getItem();
    	        	DataTypeDto dataTypeDto = ConstanUtil.findByNameDataType(rowData.getData_type().getValue());
    	            txt_sql_text.replaceSelection("#{"+rowData.getName().get()+",jdbcType="+dataTypeDto.getDbDataType()+"}");
    	            
    	        }
    	    });
    	    return row ;
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
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/database_go.png"));
			btnLoad.setGraphic(new ImageView(image));
		}
		
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/arrow_refresh.png"));
			btnRefreshConnections.setGraphic(new ImageView(image));
		}
		
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/disconnect.png"));
			btnConnections.setGraphic(new ImageView(image));
		}
		
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/add.png"));
			btnAddParamOutput.setGraphic(new ImageView(image));
		}
		
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/pencil_go.png"));
			btnEditParamOutput.setGraphic(new ImageView(image));
		}
		
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/delete.png"));
			btnDeleteParamOutput.setGraphic(new ImageView(image));
		}
		
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/add.png"));
			btnAddParamInput.setGraphic(new ImageView(image));
		}
		
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/pencil_go.png"));
			btnEditParamInput.setGraphic(new ImageView(image));
		}
		
		{
			Image image = new Image(getClass().getResourceAsStream("/icons/silk/delete.png"));
			btnADeleteParamInput.setGraphic(new ImageView(image));
		}
		
		
    }
    
    @FXML
    public void loadConnections() throws Exception{
    	
    	if(this.getModelInputOverViewController() != null){
        	InfoDbConnectionExample example = new InfoDbConnectionExample();
        	example.createCriteria().andStateEqualTo(ConstanUtil.ESTADO_ACTIVO);
        	
        	List<InfoDbConnection> list = this.getModelInputOverViewController().getImodelInputCrudService().selectByExample(InfoDbConnectionMapper.class, example);
        	
        	listConnections = new ArrayList<>();
        	
        	for (InfoDbConnection infoDbConnection : list) {
    			ConnectionDto dto = new ConnectionDto();
    			dto.setId_connection(infoDbConnection.getId_info_db_connection());
    			dto.setDescrip_connection(infoDbConnection.getName());
    			listConnections.add(dto);
    		}    	
        	
        	ObservableList<ConnectionDto> options = FXCollections.observableArrayList(listConnections);
        	cbo_connections.getItems().clear();
        	cbo_connections.getItems().addAll(options);
    	}
    	
    }

    public void setModel(ModelInputModel modelInputModel, boolean isNew) throws Exception {
        
    	this.isNew = isNew;
    	
    	if(!this.isNew){
    		
    		ModelInputExample example = new ModelInputExample();
    		example.createCriteria().andId_model_inputEqualTo(modelInputModel.getId_model_input().get());
    		
        	List<ModelInputDto> list = this.getModelInputOverViewController().getImodelInputCrudService().list(example);
        	
        	for (ModelInputDto modelInputDto : list) {
        		
        		for (ConnectionDto dto : listConnections) {
					if(dto.getId_connection().intValue() == modelInputDto.getId_info_db_connection().intValue()){
						cbo_connections.setValue(dto);
					}
				}
        		
        		txt_name_model.setText(modelInputDto.getName_model());
        		txt_sql_text.replaceText(0, 0, modelInputDto.getSql_text());
                id = modelInputDto.getId_model_input().intValue();
                
                listProperties = modelInputDto.getListPropertyDtos();
                
                for (PropertyDto propertyDto : listProperties) {
                	propertyDto.setNewEntry(true);
				}
                
                loadTablesParams();
			}
    		
    	}else{
    		
    		id=null;
    		
    	}
    
    }
        
    @FXML
    public boolean showConnectionsDialog() throws Exception {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/pe/com/jrtotem/app/generator/ui/view/InfoBdConnectionOverview.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Connections");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(MainApp.primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.setResizable(false);

            // Set the person into the controller.
            InfoDbConnectionOverviewController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @FXML
    public boolean showEditParamOutputDialog() throws Exception {
        try {
        	
        	PropertyModel propertyModel = tableParamsOutput.getSelectionModel().getSelectedItem();
            if (propertyModel != null) {
            	
                // Load the fxml file and create a new stage for the popup dialog.
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("/pe/com/jrtotem/app/generator/ui/view/ParamEditDialog.fxml"));
                AnchorPane page = (AnchorPane) loader.load();

                // Create the dialog Stage.
                Stage dialogStage = new Stage();
                dialogStage.setTitle("Params");
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(MainApp.primaryStage);
                Scene scene = new Scene(page);
                dialogStage.setScene(scene);
                dialogStage.setResizable(false);

                // Set the person into the controller.
                ParamEditDialogController controller = loader.getController();
                controller.setDialogStage(dialogStage);
                controller.setListProperties(listProperties);
                PropertyDto p = this.buscarParametro(propertyModel.getName().get(), listProperties, ConstanUtil.OUT);
                controller.setPropertyDto(p);
                controller.setData();
                controller.setModelInputEditDialogController(this);
                
                
                // Show the dialog and wait until the user closes it
                dialogStage.showAndWait();
            	
            } else {
            	
                // Nothing selected.
            	Alert alert = new Alert(AlertType.ERROR);
            	alert.setTitle("No Selection");
            	alert.setHeaderText("No record Selected");
            	alert.setContentText("Please select a record in the table.");

            	alert.showAndWait();
            }
            
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @FXML
    public boolean showAddParamOutputDialog() throws Exception {

          try{  	
                // Load the fxml file and create a new stage for the popup dialog.
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("/pe/com/jrtotem/app/generator/ui/view/ParamEditDialog.fxml"));
                AnchorPane page = (AnchorPane) loader.load();

                // Create the dialog Stage.
                Stage dialogStage = new Stage();
                dialogStage.setTitle("Params");
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(MainApp.primaryStage);
                Scene scene = new Scene(page);
                dialogStage.setScene(scene);
                dialogStage.setResizable(false);

                // Set the person into the controller.
                ParamEditDialogController controller = loader.getController();
                controller.setDialogStage(dialogStage);
                controller.setListProperties(listProperties);
                PropertyDto p = new PropertyDto();
                p.setType(ConstanUtil.OUT);
                controller.setPropertyDto(p);
                controller.setData();
                controller.setModelInputEditDialogController(this);
                
                
                // Show the dialog and wait until the user closes it
                dialogStage.showAndWait();
            
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @FXML
    public boolean showEditParamInputDialog() throws Exception {
        try {
        	
        	PropertyModel propertyModel = tableParamsInput.getSelectionModel().getSelectedItem();
            if (propertyModel != null) {
            	
                // Load the fxml file and create a new stage for the popup dialog.
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("/pe/com/jrtotem/app/generator/ui/view/ParamEditDialog.fxml"));
                AnchorPane page = (AnchorPane) loader.load();

                // Create the dialog Stage.
                Stage dialogStage = new Stage();
                dialogStage.setTitle("Params");
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(MainApp.primaryStage);
                Scene scene = new Scene(page);
                dialogStage.setScene(scene);
                dialogStage.setResizable(false);

                // Set the person into the controller.
                ParamEditDialogController controller = loader.getController();
                controller.setDialogStage(dialogStage);
                controller.setListProperties(listProperties);
                PropertyDto p = this.buscarParametro(propertyModel.getName().get(), listProperties, ConstanUtil.INPUT);
                controller.setPropertyDto(p);
                controller.setData();
                controller.setModelInputEditDialogController(this);
                
                
                // Show the dialog and wait until the user closes it
                dialogStage.showAndWait();
            	
            } else {
            	
                // Nothing selected.
            	Alert alert = new Alert(AlertType.ERROR);
            	alert.setTitle("No Selection");
            	alert.setHeaderText("No record Selected");
            	alert.setContentText("Please select a record in the table.");

            	alert.showAndWait();
            }
            
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @FXML
    public boolean showAddParamInputDialog() throws Exception {

          try{  	
                // Load the fxml file and create a new stage for the popup dialog.
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("/pe/com/jrtotem/app/generator/ui/view/ParamEditDialog.fxml"));
                AnchorPane page = (AnchorPane) loader.load();

                // Create the dialog Stage.
                Stage dialogStage = new Stage();
                dialogStage.setTitle("Params");
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(MainApp.primaryStage);
                Scene scene = new Scene(page);
                dialogStage.setScene(scene);
                dialogStage.setResizable(false);

                // Set the person into the controller.
                ParamEditDialogController controller = loader.getController();
                controller.setDialogStage(dialogStage);
                controller.setListProperties(listProperties);
                PropertyDto p = new PropertyDto();
                p.setType(ConstanUtil.INPUT);
                controller.setPropertyDto(p);
                controller.setData();
                controller.setModelInputEditDialogController(this);
                
                
                // Show the dialog and wait until the user closes it
                dialogStage.showAndWait();
            
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @FXML
    private void handleOk() {
    	
        if (isInputValid()) {
        	
        	try{
        		
        		if(!this.cutSqlText()){
       			 return;
       		 	}
        		
            	ModelInputDto dto = new ModelInputDto();
            	dto.setName_model(txt_name_model.getText());
            	dto.setId_info_db_connection(cbo_connections.getValue().getId_connection());
            	dto.setSql_text(txt_sql_text.getText());
            	dto.setId_model_input(id);
            	
            	dto.setOutputs(outs);
            	dto.setInputs(inputs);
            	dto.setFroms(froms);
            	
            	dto.setListPropertyDtos(listProperties);
            	
            	if(this.isNew){
            		this.getModelInputOverViewController().getImodelInputCrudService().create(dto);
            	}else{
            		
            		if(isLoaded){
            			dto.setNewOutput(true);
            		}
            		
            		this.getModelInputOverViewController().getImodelInputCrudService().save(dto);
            	}
            	
            	        	
            	this.getModelInputOverViewController().reloadTable();
            	
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

    	if (txt_name_model.getText() == null || txt_name_model.getText().length() == 0) {
            errorMessage += "No valid Name!\n"; 
        }
    	if (cbo_connections.getValue() == null) {
            errorMessage += "No valid Connection!\n"; 
        }
        if (txt_sql_text.getText() == null || txt_sql_text.getText().length() == 0) {
            errorMessage += "No valid SQL Text Class!\n"; 
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
    
    public boolean cutSqlText(){
    	try{
   		 String sqlCode = txt_sql_text.getText();
		 
		 
   		 {
   			 int index = sqlCode.indexOf("SELECT");
   			 if(index == -1){
   				 throw new Exception("Could not be found reserved word SELECT (in uppercase) ");
   			 }
   		 }
   		 
   		 {
   			 int index = sqlCode.indexOf("FROM");
   			 if(index == -1){
   				 throw new Exception("Could not be found reserved word FROM (in uppercase) ");
   			 }
   		 }
   		 
   		 {
   			 int index = sqlCode.indexOf("WHERE");
   			 if(index == -1){
   				 throw new Exception("Could not be found reserved word WHERE (in uppercase) ");
   			 }
   		 }
   		 
   		 outs = sqlCode.substring(sqlCode.indexOf("SELECT"),sqlCode.indexOf("FROM"));
   		 outs = outs.replace("SELECT", "");
   		 
   		 froms = sqlCode.substring(sqlCode.indexOf("FROM"),sqlCode.indexOf("WHERE"));
   		 froms = froms.replace("FROM", "");
   		 
   		 inputs = sqlCode.substring(sqlCode.indexOf("WHERE"),sqlCode.length());
   		 inputs = inputs.replace("WHERE", "");
   		 
   		 inputs = inputs.replaceAll(";", "");
   		 
   		 isLoaded=true;
   		 
   		 return true;
   		 
    	}catch(Exception e){
    		ConstanUtil.showExceptionDialog(e);
    		return false;
    	}
    }
    
    @FXML
    private void handleLoadParams() throws Exception {
    	
    	if (isInputValid()) {
    	
    		try{

       		 if(!this.cutSqlText()){
       			 return;
       		 }
       		 
       		 String sqlCode = txt_sql_text.getText();
       		 
       		 if(this.listProperties !=null){
       			 for(PropertyDto pg : this.listProperties){
    					if(pg.getType().equals(ConstanUtil.INPUT)){
    						String value = "null";												
    						sqlCode = sqlCode.replace("#{"+pg.getName()+"}", value);
    					}
    			 }
       		 }
       		 
       		 
       		 
       		 InfoDbConnectionKey infoDbConnectionKey = new InfoDbConnectionKey();
       		 infoDbConnectionKey.setId_info_db_connection(cbo_connections.getValue().getId_connection());
       		 InfoDbConnection infoDbConnection = this.getModelInputOverViewController().getImodelInputCrudService().selectByPrimaryKey(InfoDbConnectionMapper.class, infoDbConnectionKey);
       		 
       		 if(infoDbConnection.getEngine().intValue() == ConstanUtil.SQLITE){
       			listProperties = ConnectionDatabase.loadParams(infoDbConnection.getJdbc_class(), infoDbConnection.getUrl(), sqlCode);
       		 }else{
       			listProperties = ConnectionDatabase.loadParams(infoDbConnection.getJdbc_class(), infoDbConnection.getUrl(), infoDbConnection.getName_user(), infoDbConnection.getPassword_user(), sqlCode);
       		 }
       		 
       		 
       		    		 
       		try {
       			
       			SQLParser parser = new SQLParser();
       			StatementNode stmt = null;

       			stmt = parser.parseStatement(sqlCode);
       			WhereVisitor v = new WhereVisitor();
       			stmt.accept(v);

       			ColumnVisitor cv = new ColumnVisitor();

       			for (ValueNode vn : v.whereClauses) {
       				vn.accept(cv);
       			}

       			Set<String> inputs = cv.columns;

       			for (String i : inputs) {

       				PropertyDto p = new PropertyDto();
       				p.setType(ConstanUtil.INPUT);
       				p.setData_type(ConstanUtil.STRING);
       				p.setName(i);
       				p.setNewEntry(true);

       				for (PropertyDto pg : listProperties) {
       					if (pg.getName().equals(i) && pg.getType().equals(ConstanUtil.OUT)) {
       						p.setData_type(pg.getData_type());
       						break;
       					}
       				}

       				listProperties.add(p);
       			}
       		} catch (Exception ex) {
       			
       			String[] operadoresComparacion = { "=", ">", "<", ">=", "<=", "<>", "!=", "!<", "!>", " in ", " not in ",
       					" like ", " exists ", " not exists ", " is not null ", " is null ", " IN ", " NOT IN ", " LIKE ",
       					" EXISTS ", " NOT EXISTS ", " IS NOT NULL ", " IS NULL " };
       			

       			int indexWhere = sqlCode.indexOf("WHERE");
       			sqlCode = sqlCode.substring((indexWhere), sqlCode.length());
       			sqlCode = sqlCode.replace("WHERE", "");
       			String[] arr = sqlCode.split("\n");
       			for (int i = 0; i < arr.length; i++) {

       				for (int j = 0; j < operadoresComparacion.length; j++) {
       					if (j > 8) {
       						arr[i] = arr[i].replace(operadoresComparacion[j], " opc ");
       					} else {
       						arr[i] = arr[i].replace(operadoresComparacion[j], "opc");
       					}
       				}
       			}

       			for (String s : arr) {

       				String[] line = s.split("opc");
       				if (line.length > 1) {
       					String param = line[0];
       					param = param.replace(".", "###");
       					String[] arrParam = param.split("###");
       					if (arrParam.length > 1) {

       						String[] arrNameParam = arrParam[1].trim().split(",");
       						String nameParam = arrNameParam[0];

       						PropertyDto parametrosGenerador = new PropertyDto();
       						PropertyDto pg = buscarParametro(nameParam, listProperties);

       						parametrosGenerador.setName(nameParam);
       						parametrosGenerador.setType(ConstanUtil.INPUT);
       						parametrosGenerador.setNewEntry(true);
       						if (pg == null) {

       							parametrosGenerador.setData_type(ConstanUtil.STRING);

       						} else {

       							parametrosGenerador.setData_type(pg.getData_type());

       						}
       						
       						listProperties.add(parametrosGenerador);

       					}

       				}

       			}

       		}
       		
       		loadTablesParams();
       		isLoaded = true;
       		
       	 }catch(Exception e){
       		 ConstanUtil.showExceptionDialog(e);
       	 }
    		
    	}
    	 
    	

    }
    
    public void loadTablesParams(){
		{
			tableParamsOutput.getItems().clear();
			tableDataParamsOutput = FXCollections.observableArrayList();
						
			for (PropertyDto propertyDto : listProperties) {
				
				if(propertyDto.getType().equals(ConstanUtil.OUT)){
					PropertyModel model = new PropertyModel();
					if(propertyDto.getId_property() != null){
						model.setId_property(new SimpleIntegerProperty(propertyDto.getId_property()));
					}
					model.setName(new SimpleStringProperty(propertyDto.getName()));
					model.setData_type(new SimpleStringProperty(propertyDto.getData_type()));
					
					tableDataParamsOutput.add(model);
				}
				
			}
			tableParamsOutput.setItems(tableDataParamsOutput);
	    	c_name_param_output.setCellValueFactory(cellData -> cellData.getValue().getName());
	    	c_data_type_param_output.setCellValueFactory(cellData -> cellData.getValue().getData_type());
		}
    	
		{
			tableParamsInput.getItems().clear();
			tableDataParamsInput = FXCollections.observableArrayList();
			for (PropertyDto propertyDto : listProperties) {
				
				if(propertyDto.getType().equals(ConstanUtil.INPUT)){
					PropertyModel model = new PropertyModel();
					if(propertyDto.getId_property() != null){
						model.setId_property(new SimpleIntegerProperty(propertyDto.getId_property()));
					}
					model.setName(new SimpleStringProperty(propertyDto.getName()));
					model.setData_type(new SimpleStringProperty(propertyDto.getData_type()));
					
					tableDataParamsInput.add(model);
				}
				
			}
			tableParamsInput.setItems(tableDataParamsInput);
	    	c_name_param_input.setCellValueFactory(cellData -> cellData.getValue().getName());
	    	c_data_type_param_input.setCellValueFactory(cellData -> cellData.getValue().getData_type());
		}
    }
    
    @FXML
    public void deleteParamOut(){
    	
    	PropertyModel propertyModel = tableParamsOutput.getSelectionModel().getSelectedItem();
        if (propertyModel != null) {
        	
        	Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.setTitle("Confirmation Dialog");
        	alert.setHeaderText("Look, a Confirmation Dialog");
        	alert.setContentText("Are you sure to proceed?");

        	Optional<ButtonType> result = alert.showAndWait();
        	if (result.get() == ButtonType.OK){
        	    PropertyDto p = this.buscarParametro(propertyModel.getName().get(), listProperties, ConstanUtil.OUT);
        	    listProperties.remove(p);
        	    this.loadTablesParams();
        	    isLoaded=true;
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
    public void deleteParamInput(){
    	
    	PropertyModel propertyModel = tableParamsInput.getSelectionModel().getSelectedItem();
        if (propertyModel != null) {
        	
        	Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.setTitle("Confirmation Dialog");
        	alert.setHeaderText("Look, a Confirmation Dialog");
        	alert.setContentText("Are you sure to proceed?");

        	Optional<ButtonType> result = alert.showAndWait();
        	if (result.get() == ButtonType.OK){
        	    PropertyDto p = this.buscarParametro(propertyModel.getName().get(), listProperties, ConstanUtil.INPUT);
        	    listProperties.remove(p);
        	    this.loadTablesParams();
        	    isLoaded=true;
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
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
	public ModelInputOverViewController getModelInputOverViewController() {
		return modelInputOverViewController;
	}

	public void setModelInputOverViewController(ModelInputOverViewController modelInputOverViewController) {
		this.modelInputOverViewController = modelInputOverViewController;
	}

	public TextField getTxt_name_model() {
		return txt_name_model;
	}

	public void setTxt_name_model(TextField txt_name_model) {
		this.txt_name_model = txt_name_model;
	}

	public ComboBox<ConnectionDto> getCbo_connections() {
		return cbo_connections;
	}

	public void setCbo_connections(ComboBox<ConnectionDto> cbo_connections) {
		this.cbo_connections = cbo_connections;
	}

	public CodeArea getTxt_sql_text() {
		return txt_sql_text;
	}

	public void setTxt_sql_text(CodeArea txt_sql_text) {
		this.txt_sql_text = txt_sql_text;
	}

	public Button getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(Button btnSave) {
		this.btnSave = btnSave;
	}

	public Button getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(Button btnCancel) {
		this.btnCancel = btnCancel;
	}

	public Button getBtnLoad() {
		return btnLoad;
	}

	public void setBtnLoad(Button btnLoad) {
		this.btnLoad = btnLoad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public Stage getDialogStage() {
		return dialogStage;
	}
	public PropertyDto buscarParametro(String nameParam,List<PropertyDto> list){
		for(PropertyDto p : list){
			if(p.getName().equals(nameParam)){
				return p;
			}
		}
		return null;
	}
	public PropertyDto buscarParametro(String nameParam,List<PropertyDto> list,String tipoIO){
		for(PropertyDto p : list){
			if(p.getType().equals(tipoIO)){
				if(p.getName().equals(nameParam)){
					return p;
				}
			}
		}
		return null;
	}
	public String replaceRange(String str, int start, int end, String replace) {
	    return str.substring(0, start) + replace + str.substring(end);
	}

	public boolean isLoaded() {
		return isLoaded;
	}

	public void setLoaded(boolean isLoaded) {
		this.isLoaded = isLoaded;
	}

}
