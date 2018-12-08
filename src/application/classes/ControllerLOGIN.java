package application.classes;

import application.Cadastro;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControllerLOGIN {
	
	public static Integer controle;
    @FXML
    private Pane root;

    @FXML
    private TextField txt_Usuario;

    @FXML
    private PasswordField txt_Senha;
    
    @FXML
    private Button btn_entrar;
    
    @FXML
    private Button btn_sair;
    
    @FXML
    void actionEntrar(MouseEvent btn_entrar) {
    
    	System.out.println(txt_Usuario.getText());
    	System.out.println(txt_Senha.getText());
    	if(txt_Usuario.getText().equals("admin") && txt_Senha.getText().equals("admin")) {
    		Cadastro c = new Cadastro();
			c.start(new Stage());
    	}
    	else {
    		alert("Usuário ou senha inválido");
    	}
    	final Node source = (Node) btn_entrar.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    void executarSair(MouseEvent btn_sair) {
    	final Node source = (Node) btn_sair.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void alert(String mensagem){
    	Alert alert = new Alert(Alert.AlertType.ERROR);
    	alert.setHeaderText(null);
    	alert.setTitle("Mensagem");
    	alert.setContentText(mensagem);
    	alert.show();
    }
}
