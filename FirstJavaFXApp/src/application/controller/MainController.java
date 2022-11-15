package application.controller;

import java.io.File;
import java.util.Random;

import application.Main;
import application.model.Prime;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * MainController is a Java class that will need to implement the EventHandler interface,
 * and handle any events that occur when the user interacts with Main.fxml. 
 * 
 * @author Isabella Talijancic (juu530)
 * UTSA CS 3333 - Project
 * Fall 2022
 */
public class MainController implements EventHandler<ActionEvent> {

	@FXML
	Button prime, combinatorics, exitButton;
	@FXML
    ImageView bannerImageView;
	@FXML
    Image bannerImage;
	@FXML
	Label welcome;
	
	@Override
	public void handle(ActionEvent event) {
		
		//check which button was pressed...
		Button sourceButton = (Button) event.getSource();
		String buttonText = sourceButton.getText();
		
		if(buttonText!=null && buttonText.contains("Primes, GCD, LCM") ) {
			//System.out.println("Trick");
			// move the user to the trick view
			try {
				Parent root = FXMLLoader.load(getClass().getResource("../view/Prime.fxml"));
				Main.stage.setScene( new Scene(root, 600, 600) );
				Main.stage.show();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(buttonText!=null && buttonText.contains("Combinatorics") ) {
			//System.out.println("Treat");
			// move the user to the treat view
			try {
				Parent root = FXMLLoader.load(getClass().getResource("../view/Comb.fxml"));
				Main.stage.setScene( new Scene(root, 600, 600) );
				Main.stage.show();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(buttonText!=null && buttonText.contains("Exit the program") ) {
			// exit the program
			try {
				Stage stage = (Stage) exitButton.getScene().getWindow();
			    stage.close();
							
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
