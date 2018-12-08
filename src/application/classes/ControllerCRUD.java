package application.classes;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Editar;
import application.telas.Conexao;
import application.telas.Informacoes;
import application.telas.Pessoa;
import application.telas.Questions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ControllerCRUD implements Initializable {
	
	public static Integer codigo_pessoa = 0;
	
	@FXML
    private TabPane root;

    @FXML
    private Tab cadastrar;

    @FXML
    private AnchorPane anchor;

    @FXML
    private TextField txt_nome;

    @FXML
    private TextField txt_idade;

    @FXML
    private TextField txt_email;

    @FXML
    private CheckBox btn_careca;

    @FXML
    private CheckBox btn_barba;

    @FXML
    private CheckBox btn_masculino;

    @FXML
    private Button btn_salvar;

    @FXML
    private Button btn_cancelar;
    
    @FXML
    private CheckBox btn_ansi;

    @FXML
    private CheckBox btn_azuis;

    @FXML
    private CheckBox btn_verdes;

    @FXML
    private CheckBox btn_alto;

    @FXML
    private CheckBox btn_longo;

    @FXML
    private CheckBox btn_professor;

    @FXML
    private CheckBox btn_coordenador;

    @FXML
    private CheckBox btn_trabalha;

    @FXML
    private CheckBox btn_corpele;

    @FXML
    private CheckBox btn_oculos;

    @FXML
    private CheckBox btn_segundop;

    @FXML
    private CheckBox btn_loiro;

    @FXML
    private CheckBox btn_formou;

    @FXML
    private Tab alterar;

    @FXML
    private Button btn_cancelartab;
    
    @FXML
    private TableView<Pessoa> tb_alterar;

    @FXML
    private TableColumn<Pessoa, Integer> cln_codigo;

    @FXML
    private TableColumn<Pessoa, String> cln_nome;
     
    @FXML
    private Button btn_atualizar;

    @FXML
    public TextField txt_codigoalter;
    
    @FXML
    private Button btn_selecao;
    
    @FXML
    private Button btn_excluir;
    
    @FXML
    private TextField txt_excluir;
    
    @FXML
    private TableView<Questions> tb_perguntas;

    @FXML
    private TableColumn<Questions, String> table_perg;
    
    @FXML
    private Button btn_ir;
    
    ObservableList<Pessoa> list = FXCollections.observableArrayList();
    ObservableList<Questions> perg = FXCollections.observableArrayList();
    
    @FXML
    void atualizar(MouseEvent btn_atualizar){
    	list.clear();
    	popularTable();
    }
    
    public void fecharTela(){
    	Stage primaryStage = new Stage();
	    primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent evento){
				btn_cancelar.getScene().getWindow().getOnCloseRequest();
				primaryStage.close();
			}
		});
    }
    
    @FXML
    void cancelar(MouseEvent btn_cancelar) {
    	final Node source = (Node) btn_cancelar.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void salvar(MouseEvent btn_salvar) {
    	try {
    		if(txt_nome.getText().equals("")) {
    			alert("Insira o nome");
    		}
    		else {
    			Pessoa p = new Pessoa();
    	    	Conexao c = new Conexao();
    	    	c.Conectar();
    	    	Informacoes inf = new Informacoes();
    	    	p.setNome(txt_nome.getText());
    	    	p.setEmail(txt_email.getText());
    	    	p.setIdade(Integer.parseInt(txt_idade.getText()));
    	    	inf.setBarba(btn_barba.isSelected());
    	    	inf.setCareca(btn_careca.isSelected());
    	    	inf.setSexo(btn_masculino.isSelected());
    	    	inf.setCursa_ansi(btn_ansi.isSelected());
    	    	inf.setOlhos_azuis(btn_azuis.isSelected());
    	    	inf.setOlhos_verdes(btn_verdes.isSelected());
    	    	inf.setAlto(btn_alto.isSelected());
    	    	inf.setCabelo_longo(btn_longo.isSelected());
    	    	inf.setEh_professor(btn_professor.isSelected());
    	    	inf.setEh_coordenador(btn_coordenador.isSelected());
    	    	inf.setTrabalha(btn_trabalha.isSelected());
    	    	inf.setEh_branco(btn_corpele.isSelected());
    	    	inf.setUsa_oculos(btn_oculos.isSelected());
    	    	inf.setCursa_segundop(btn_segundop.isSelected());
    	    	inf.setEh_loiro(btn_loiro.isSelected());
    	    	inf.setSe_formou(btn_formou.isSelected());
    	    	System.out.println(p.getNome());
    	    	System.out.println(p.getEmail());
    	    	System.out.println(p.getIdade());
    	    	System.out.println(inf.isBarba());
    	    	System.out.println(inf.isCareca());
    	    	System.out.println(inf.isSexo());
    	    	System.out.println(inf.isCursa_ansi());
    	    	System.out.println(inf.isOlhos_azuis());
    	    	System.out.println(inf.isOlhos_verdes());
    	    	c.inserirAluno(p, inf);
    	    	alert("Salvo com sucesso!");
    	    	limparCampo();
    		}
	    }
    	catch(Exception e) {
    		alert(e.getMessage());
    	}
    }
    
    public void alert(String mensagem){
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	alert.setHeaderText(null);
    	alert.setTitle("Mensagem");
    	alert.setContentText(mensagem);
    	alert.show();
    }
    
	public void limparCampo() {
		txt_nome.setText("");
		txt_idade.setText("");
		txt_email.setText("");
		btn_careca.setSelected(false);
		btn_longo.setDisable(false);
		btn_careca.setDisable(false);
		btn_verdes.setDisable(false);
		btn_azuis.setDisable(false);
		btn_masculino.setSelected(false);
		btn_barba.setSelected(false);
		btn_ansi.setSelected(false);
		btn_azuis.setSelected(false);
		btn_verdes.setSelected(false);
		btn_alto.setSelected(false);
		btn_longo.setSelected(false);
		btn_professor.setSelected(false);
		btn_coordenador.setSelected(false);
		btn_trabalha.setSelected(false);
		btn_corpele.setSelected(false);
		btn_oculos.setSelected(false);
		btn_segundop.setSelected(false);
		btn_loiro.setSelected(false);
		btn_formou.setSelected(false);
	}
	
	public void popularTable(){
		Conexao c = new Conexao();
		c.Conectar();
		c.ReceberAlunos();
		System.out.println("Entrou no Método");
		list.clear();
		for (Pessoa p : c.alunos){
			list.add(p);
			System.out.println(p.getNome());
			System.out.println(c.alunos.size());
		}
		cln_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cln_codigo.setCellValueFactory(new PropertyValueFactory<>("nchamada"));
		tb_alterar.setItems(list);
	}
	
	public void popularTablePerg(){
		System.out.println("Entrou no Método");
		perg.clear();
		ArrayList<Questions> lista1 = new ArrayList<Questions>();
		Questions p = new Questions();
    	p.setId_pergunta(1);
    	p.setPergunta("Essa pessoa é careca?");
    	lista1.add(p);
    	Questions p2 = new Questions();
    	p2.setId_pergunta(2);
    	p2.setPergunta("Essa pessoa tem barba?");
    	lista1.add(p2);
    	Questions p3 = new Questions();
    	p3.setId_pergunta(3);
    	p3.setPergunta("Essa pessoa é Homem?");
    	lista1.add(p3);
    	Questions p4 = new Questions();
    	p4.setId_pergunta(4);
    	p4.setPergunta("Essa pessoa cursa ANSI?");
    	lista1.add(p4);
    	Questions p5 = new Questions();
    	p5.setId_pergunta(5);
    	p5.setPergunta("Essa pessoa tem olhos azuis?");
    	lista1.add(p5);
    	Questions p6 = new Questions();
    	p6.setId_pergunta(6);
    	p6.setPergunta("Essa pessoa tem olhos verdes?");
    	lista1.add(p6);
    	Questions p7 = new Questions();
    	p7.setId_pergunta(7);
    	p7.setPergunta("Essa pessoa é alta?");
    	lista1.add(p7);
    	Questions p8 = new Questions();
    	p8.setId_pergunta(8);
    	p8.setPergunta("Essa pessoa tem cabelo longo?");
    	lista1.add(p8);
    	Questions p9 = new Questions();
    	p9.setId_pergunta(9);
    	p9.setPergunta("Essa pessoa é professor?");
    	lista1.add(p9);
    	Questions p10 = new Questions();
    	p10.setId_pergunta(10);
    	p10.setPergunta("Essa pessoa é coordenador?");
    	lista1.add(p10);
    	Questions p11 = new Questions();
    	p11.setId_pergunta(11);
    	p11.setPergunta("Essa pessoa trabalha?");
    	lista1.add(p11);
    	Questions p12 = new Questions();
    	p12.setId_pergunta(12);
    	p12.setPergunta("Essa pessoa é branca?");
    	lista1.add(p12);
    	Questions p13 = new Questions();
    	p13.setId_pergunta(13);
    	p13.setPergunta("Essa pessoa usa óculos?");
    	lista1.add(p13);
    	Questions p14 = new Questions();
    	p14.setId_pergunta(14);
    	p14.setPergunta("Essa pessoa cursa segundo período?");
    	lista1.add(p14);
    	Questions p15 = new Questions();
    	p15.setId_pergunta(15);
    	p15.setPergunta("Essa pessoa é loira?");
    	lista1.add(p15);
    	Questions p16 = new Questions();
    	p16.setId_pergunta(16);
    	p16.setPergunta("Essa pessoa se formou?");
    	lista1.add(p16);
    for (Questions x : lista1) {
			perg.add(x);
		}
		table_perg.setCellValueFactory(new PropertyValueFactory<>("pergunta"));
		tb_perguntas.setItems(perg);
	}
	
	@FXML
    void editscape(MouseEvent btn_selecao) {
    	try {
    		codigo_pessoa = tb_alterar.getSelectionModel().getSelectedItem().getNchamada();
			Editar edit = new Editar();
			edit.start(new Stage());
		}
		catch(Exception e) {
			alert("Não foi possível completar sua ação!");
		}
    }
	
	@FXML
	void excluir() {
		Conexao c = new Conexao();
		c.Conectar();
		c.ReceberAlunos();
		try {
			Integer codigo = tb_alterar.getSelectionModel().getSelectedItem().getNchamada();
			c.deletarAluno(codigo);
			alert("Atualize a lista!");
			txt_excluir.setText("");
		}
		catch(Exception ae) {
			alert(ae.getMessage());
		}
	}
	
	@FXML
	void cancelartab(MouseEvent btn_cancelartab) {
		final Node source = (Node) btn_cancelartab.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
	}
	
	@FXML
	void desativarCb(MouseEvent btn_longo) {
		if(this.btn_longo.isSelected() == true) {
			this.btn_careca.setSelected(false);
			this.btn_careca.setDisable(true);
		}
		else if(this.btn_longo.isSelected() == false) {
			this.btn_careca.setSelected(false);
			this.btn_careca.setDisable(false);
		}
	}
	
	@FXML
	void desativarCr(MouseEvent btn_careca) {
		if(this.btn_careca.isSelected() == true) {
			this.btn_longo.setSelected(false);
			this.btn_longo.setDisable(true);
		}
		else if(this.btn_careca.isSelected() == false) {
			this.btn_longo.setSelected(false);
			this.btn_longo.setDisable(false);
		}
	}
	
	@FXML
	void desativarAz(MouseEvent btn_azuis) {
		if(this.btn_azuis.isSelected() == true) {
			this.btn_verdes.setSelected(false);
			this.btn_verdes.setDisable(true);
		}
		else if(this.btn_azuis.isSelected() == false) {
			this.btn_verdes.setSelected(false);
			this.btn_verdes.setDisable(false);
		}
	}
	
	@FXML
	void desativarVe(MouseEvent btn_verdes) {
		if(this.btn_verdes.isSelected() == true) {
			this.btn_azuis.setSelected(false);
			this.btn_azuis.setDisable(true);
		}
		else if(this.btn_verdes.isSelected() == false) {
			this.btn_azuis.setSelected(false);
			this.btn_azuis.setDisable(false);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		popularTablePerg();
	}
	
	@FXML
    void editscapeIr(MouseEvent btn_ir) {
    	try {
    		codigo_pessoa = Integer.parseInt(txt_excluir.getText());
			Editar edit = new Editar();
			edit.start(new Stage());
		}
		catch(Exception e) {
			alert("Não foi possível completar sua ação!");
		}
    }
}

