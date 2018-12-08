package application.classes;

import application.Pergunta;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControllerTEL {

    @FXML
    private Pane root;

    @FXML
    private Button btn_ajudar;

    @FXML
    private Button btn_sair;
    
    @FXML
    void jogar(MouseEvent btn_ajudar) {
    	Pergunta p = new Pergunta();
    	p.start(new Stage());
    	travarTela();
    }

    @FXML
    void sair(MouseEvent btn_sair) {
    	final Node source = (Node) btn_sair.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
    public void travarTela() {
    	btn_ajudar.setDisable(true);
    }

}
