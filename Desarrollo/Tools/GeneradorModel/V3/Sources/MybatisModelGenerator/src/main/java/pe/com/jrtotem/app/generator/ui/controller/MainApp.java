package pe.com.jrtotem.app.generator.ui.controller;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static Stage primaryStage;
    private BorderPane rootLayout;
       
 	public static ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Override
    public void start(Stage primaryStage) {
    	
    	MainApp.primaryStage = primaryStage;
    	MainApp.primaryStage.setTitle("Mybatis Model Generator");

        initRootLayout();

        showModelInputOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
        	
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/pe/com/jrtotem/app/generator/ui/view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/icons/silk/application_form.png")));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showInfoDbConnectionOverview() {
        try {
        	
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/pe/com/jrtotem/app/generator/ui/view/InfoBdConnectionOverview.fxml"));
            AnchorPane infoDbOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(infoDbOverview);
                        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showModelInputOverview() {
        try {
        	
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/pe/com/jrtotem/app/generator/ui/view/ModelInputOverView.fxml"));
            AnchorPane anchorPane = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(anchorPane);
                        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

	public static void main(String[] args) {
    	
        launch(args);
        
    }
}
