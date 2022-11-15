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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * CombController is a Java class that will need to implement the EventHandler interface,
 * and handle any events that occur when the user interacts with Comb.fxml. 
 * 
 * @author Isabella Talijancic (juu530)
 * @author Amalia Talijancic (fwn783)
 * UTSA CS 3333 - Project
 * Fall 2022
 */
public class CombController implements EventHandler<ActionEvent> {

	@FXML
	Button enterButton, backButton, exitButton;
	@FXML
    ImageView bannerImageView;
	@FXML
    Image bannerImage;
	@FXML
	Label welcome, warningLabel, resultLabel;
	@FXML
	TextField aField, bField;
	
	@Override
	public void handle(ActionEvent event) {
		
		//check which button was pressed...
		Button sourceButton = (Button) event.getSource();
		String buttonText = sourceButton.getText();
		
		if(buttonText!=null && buttonText.contains("Calculate") ) {
			if(aField.getText().isEmpty()) {
				warningLabel.setVisible(true);
			}
			else if(bField.getText().isEmpty()) {
				warningLabel.setVisible(true);
			}
			else if(!aField.getText().isEmpty() && !bField.getText().isEmpty()) {
				
				//traverse input string
		        for (int i = 0; i < aField.getText().length(); i++) {
		        	
		        	//check if each character is a not digit
		            if (!Character.isDigit(aField.getText().charAt(i))) {
		            	warningLabel.setVisible(true);
		            }
		        }
				
				//do stuff!
		        convertMethods(aField.getText(),bField.getText());
			}
		}
		else if(buttonText!=null && buttonText.contains("Return to menu") ) {
			// move the user back to the main view
			try {
				Parent root = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
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
	
	private void convertMethods(String a, String b) {
		
		int aConvert = Integer.parseInt(a);
		int bConvert = Integer.parseInt(b);
		
		Prime input = new Prime(aConvert, bConvert);
		
		//Prime.primeAMethod(aConvert);
		//Prime.primeBMethod(bConvert);
		
		//resultLabel.setText(Integer.toString(Prime.primeAMethod(aConvert)));
		
		resultLabel.setText(input.toString());
	}

}
