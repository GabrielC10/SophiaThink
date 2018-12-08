package application;
	
import java.io.File;
import java.net.URL;

import application.telas.Conexao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Final extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Conexao c = new Conexao();
			c.Conectar();
			c.listarArray();
			URL url = new File("src/application/classes/TelaFinal.fxml").toURL();
			Pane root = (Pane) FXMLLoader.load(url);
			Scene scene = new Scene(root);
			primaryStage.setTitle("Sophia");
			primaryStage.initStyle(StageStyle.UNDECORATED);
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
