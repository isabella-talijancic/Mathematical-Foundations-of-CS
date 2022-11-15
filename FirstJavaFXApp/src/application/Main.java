package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/**
 * Main is a Java class that will launch the application and show the Main.fxml.
 * 
 * @author Isabella Talijancic (juu530)
 * UTSA CS 3333 - Project
 * Fall 2022
 */
public class Main extends Application {
	
	public static Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// give access to the other controllers to this primary stage!
			stage = primaryStage;
			primaryStage.setTitle("Math Found of CS");
			
			// Connect to the FXML (contains our layout) and load it in
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("view/Main.fxml") );
			AnchorPane layout = (AnchorPane) loader.load();
			
			// Put the layout onto the scene
			Scene scene = new Scene( layout );
			
			// Set the scene on the stage
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
