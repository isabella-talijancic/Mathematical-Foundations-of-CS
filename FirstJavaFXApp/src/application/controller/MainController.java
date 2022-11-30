package application.controller;

import java.nio.file.Paths;

import application.Main;
import application.model.Prime;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
	
	MediaPlayer mediaplayer, mediaPlayerSFX;
	
	@Override
	public void handle(ActionEvent event) {
		
		//check which button was pressed...
		Button sourceButton = (Button) event.getSource();
		String buttonText = sourceButton.getText();
		
		if(buttonText!=null && buttonText.contains("Primes, GCD, LCM") ) {

			try {
				playSound("SahbaPrimes");
				Parent root = FXMLLoader.load(getClass().getResource("../view/Prime.fxml"));
				Main.stage.setScene( new Scene(root, 600, 600) );
				Main.stage.show();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(buttonText!=null && buttonText.contains("Binomial Theorem") ) {
			//System.out.println("Treat");
			// move the user to the treat view
			try {
				playSound("SahbaBinomial");
				Parent root = FXMLLoader.load(getClass().getResource("../view/Binomial.fxml"));
				Main.stage.setScene( new Scene(root, 600, 600) );
				Main.stage.show();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

		else if(buttonText!=null && buttonText.contains("Number Conversion") ) {
			//System.out.println("Treat");
			// move the user to the treat view
			try {
				playSound("SahbaBinomial");
				Parent root = FXMLLoader.load(getClass().getResource("../view/numConversion.fxml"));
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
	
	/**
     * Creates a new Media object to play sound effects.
     * 
     * @param soundName Name of mp3 sound effect audio (String)
     */
    public void playSound(String soundName) {
        String s = "src/application/audio/" + soundName + ".mp3";
        Media soundEffect = new Media(Paths.get(s).toUri().toString());
        mediaPlayerSFX = new MediaPlayer(soundEffect);
        mediaPlayerSFX.play();
        // mediaPlayer.setStartTime(Duration.seconds(0));
        // mediaPlayer.setAutoPlay(true);
    }

}
