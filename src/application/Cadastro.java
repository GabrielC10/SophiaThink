package application;

import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Cadastro extends Application{
	@Override
	public void start(Stage primaryStage) {
		try {
			URL url = new File("src/application/classes/Cadastro.fxml").toURL();
			TabPane root = (TabPane) FXMLLoader.load(url);
			Scene scene = new Scene(root);
			primaryStage.setTitle("Sophia - Gerenciador");
			primaryStage.initModality(Modality.APPLICATION_MODAL);
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
