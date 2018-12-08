package application.classes;

import java.net.URL;
import java.util.ResourceBundle;

import application.Login;
import application.Sophia;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller implements Initializable{

    @FXML
    private Pane root;

    @FXML
    private ImageView img_view;

    @FXML
    private Button btn_jogar;

    @FXML
    private Button btn_opcoes;

    @FXML
    private Button btn_sair;
    
    @Override
	public void initialize(URL url, ResourceBundle rs) {
		// TODO Auto-generated method stub
    	btn_opcoes.setOnMouseClicked((MouseEvent e)->{
			try {
				Login l = new Login();
				l.start(new Stage());
			}
			catch(Exception ex){
				alert(ex.getMessage());
			}
		});
	}
    
    @FXML
    void cancelar(MouseEvent btn_sair) {
     	Platform.exit();
		System.exit(0);
    }

    @FXML 
    void jogarGame(MouseEvent btn_jogar) {
    	Sophia s = new Sophia();
    	s.start(new Stage());
    }
    
    public void alert(String mensagem){
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	alert.setHeaderText(null);
    	alert.setTitle("Mensagem");
    	alert.setContentText(mensagem);
    	alert.show();
    }

}
