package application.classes;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControllerACHOU implements Initializable{

	private String nome;
	public static String dale;
	public static Integer verificacao1 = 0; 

    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static String vamo;

	@FXML
    private Pane root;

    @FXML
    public TextField txt_Nome;

    @FXML
    private Button btn_Sim;

    @FXML
    private Button btn_Nao;
    
    public void inserirTxt() {
    	ControllerPERG p = new ControllerPERG();
    	vamo = p.perg;
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
    	txt_Nome.setText(dale);
	}
    
    @FXML
    void aptSim(MouseEvent btn_Sim) {
    	verificacao1 = 1;
    	final Node source = (Node) btn_Sim.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
    @FXML 
    void aptNao(MouseEvent btn_Nao) {
    	verificacao1 = 0;
    	final Node source = (Node) btn_Nao.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
