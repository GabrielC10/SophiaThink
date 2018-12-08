package application.classes;

import java.net.URL;
import java.util.ResourceBundle;

import application.telas.Conexao;
import application.telas.Informacoes;
import application.telas.Pessoa;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControllerEDIT implements Initializable{
	
	Integer index;
	Integer chamada;
	
    @FXML
    private Pane root;

    @FXML
    private TextField txt_nome;

    @FXML
    private TextField txt_idade;

    @FXML
    private TextField txt_email;

    @FXML
    private Button btn_salvar;

    @FXML
    private Button btn_cancelar;

    @FXML
    private CheckBox btn_careca;

    @FXML
    private CheckBox btn_barba;

    @FXML
    private CheckBox btn_masculino;
    

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
    private CheckBox btn_branco;

    @FXML
    private CheckBox btn_oculos;

    @FXML
    private CheckBox btn_segundop;

    @FXML
    private CheckBox btn_loiro;

    @FXML
    private CheckBox btn_formou;
    
    @FXML
    private TextField txt_codeedit;
    
    @FXML
    private Button btn_atualizar;
    
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
        		Conexao c = new Conexao();
            	Pessoa p = new Pessoa();
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
            	inf.setEh_branco(btn_branco.isSelected());
            	inf.setUsa_oculos(btn_oculos.isSelected());
            	inf.setCursa_segundop(btn_segundop.isSelected());
            	inf.setEh_loiro(btn_loiro.isSelected());
            	inf.setSe_formou(btn_formou.isSelected());
            	System.out.println(btn_masculino.isSelected());
            	System.out.println(inf.isSexo());
            	c.Conectar();
            	c.ReceberAlunos();
            	c.alterarAluno(chamada, p, inf);
            	alert("Salvo com sucesso!");
            	limparCampo();
            	txt_nome.setEditable(false);
        		txt_idade.setEditable(false);
        		txt_email.setEditable(false);
        		btn_careca.setDisable(true);
        		btn_careca.setSelected(false);
        		btn_masculino.setDisable(true);
        		btn_masculino.setSelected(false);
        		btn_barba.setDisable(true);
        		btn_barba.setSelected(false);
        		btn_ansi.setDisable(true);
        		btn_ansi.setSelected(false);
        		btn_azuis.setDisable(true);
        		btn_azuis.setSelected(false);
        		btn_verdes.setDisable(true);
        		btn_verdes.setSelected(false);
        		btn_alto.setDisable(true);
        		btn_alto.setSelected(false);
        		btn_loiro.setDisable(true);
        		btn_loiro.setSelected(false);
        		btn_longo.setDisable(true);
        		btn_longo.setSelected(false);
        		btn_professor.setDisable(true);
        		btn_professor.setSelected(false);
        		btn_coordenador.setDisable(true);
        		btn_coordenador.setSelected(false);
        		btn_trabalha.setDisable(true);
        		btn_trabalha.setSelected(false);
        		btn_branco.setDisable(true);
        		btn_branco.setSelected(false);
        		btn_oculos.setDisable(true);
        		btn_oculos.setSelected(false);
        		btn_segundop.setDisable(true);
        		btn_segundop.setSelected(false);
        		btn_formou.setDisable(true);
        		btn_formou.setSelected(false);
        		txt_codeedit.setEditable(true);
    		}
    	}
    	catch(Exception e){
    		alert(e.getMessage());
    	}
    }
    
    @FXML
    void atualizar(MouseEvent btn_atualizar) {
    	atualizarCod();
    }
    
    @FXML
    public void atualizarCod(){
    	Conexao c = new Conexao();
    	c.Conectar();
    	c.ReceberAlunos();
    	index = Integer.parseInt(txt_codeedit.getText());
    	if (index <= 0) {
    		alert("Código inválido, tente novamente");
    	}
    	else {
    		for(int x = 0; x < c.alunos.size(); x++) {
    			if (c.alunos.get(x).getNchamada() == index) {
    				index = x;
    				chamada = c.alunos.get(x).getNchamada();
    				txt_nome.setEditable(true);
    	    		txt_idade.setEditable(true);
    	    		txt_email.setEditable(true);
    	    		btn_careca.setDisable(false);
    	    		btn_masculino.setDisable(false);
    	    		btn_barba.setDisable(false);
    	    		btn_ansi.setDisable(false);
    	    		btn_azuis.setDisable(false);
    	    		btn_verdes.setDisable(false);
    	    		btn_alto.setDisable(false);
    	    		btn_loiro.setDisable(false);
    	    		btn_longo.setDisable(false);
    	    		btn_professor.setDisable(false);
    	    		btn_coordenador.setDisable(false);
    	    		btn_trabalha.setDisable(false);
    	    		btn_branco.setDisable(false);
    	    		btn_oculos.setDisable(false);
    	    		btn_segundop.setDisable(false);
    	    		btn_formou.setDisable(false);
    	    		txt_codeedit.setEditable(true);
    		    	System.out.println(index);
    		    	txt_nome.setText(c.alunos.get(index).getNome());
    		    	txt_idade.setText(c.alunos.get(index).getIdade().toString());
    		    	txt_email.setText(c.alunos.get(index).getEmail());
    		    	btn_careca.setSelected(c.infs.get(index).isCareca());
    		    	btn_masculino.setSelected(c.infs.get(index).isSexo());
    		    	btn_barba.setSelected(c.infs.get(index).isBarba());
    		    	btn_ansi.setSelected(c.infs.get(index).isCursa_ansi());
    		    	btn_azuis.setSelected(c.infs.get(index).isOlhos_azuis());
    		    	btn_verdes.setSelected(c.infs.get(index).isOlhos_verdes());
    		    	btn_alto.setSelected(c.infs.get(index).isAlto());
    		    	btn_longo.setSelected(c.infs.get(index).isCabelo_longo());
    		    	btn_professor.setSelected(c.infs.get(index).isEh_professor());
    		    	btn_coordenador.setSelected(c.infs.get(index).isEh_coordenador());
    		    	btn_trabalha.setSelected(c.infs.get(index).isTrabalha());
    		    	btn_branco.setSelected(c.infs.get(index).isEh_branco());
    		    	btn_oculos.setSelected(c.infs.get(index).isUsa_oculos());
    		    	btn_segundop.setSelected(c.infs.get(index).isCursa_segundop());
    		    	btn_loiro.setSelected(c.infs.get(index).isEh_loiro());
    		    	btn_formou.setSelected(c.infs.get(index).isSe_formou());
    		    	alert("Atualizado com sucesso!");
    			}
    		}
    	}
    }
    
    public void alert(String mensagem){
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	alert.setHeaderText(null);
    	alert.setTitle("Mensagem");
    	alert.setContentText(mensagem);
    	alert.show();
    }
    
    public void limparCampo(){
    	txt_nome.setText("");
    	txt_idade.setText("");
    	txt_email.setText("");
    	btn_masculino.setSelected(false);
    	btn_careca.setSelected(false);
    	btn_barba.setSelected(false);
    	txt_codeedit.setText("");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ControllerCRUD a = new ControllerCRUD();
		Conexao c = new Conexao();
    	c.Conectar();
    	c.ReceberAlunos();
    	System.out.println("INICIALIZOU");
		System.out.println(a.codigo_pessoa);
		for(int x = 0; x < c.alunos.size(); x++) {
			if (c.alunos.get(x).getNchamada() == a.codigo_pessoa) {
				index = x;
				chamada = c.alunos.get(x).getNchamada();
				txt_nome.setEditable(true);
	    		txt_idade.setEditable(true);
	    		txt_email.setEditable(true);
	    		btn_careca.setDisable(false);
	    		btn_masculino.setDisable(false);
	    		btn_barba.setDisable(false);
	    		btn_ansi.setDisable(false);
	    		btn_azuis.setDisable(false);
	    		btn_verdes.setDisable(false);
	    		btn_alto.setDisable(false);
	    		btn_loiro.setDisable(false);
	    		btn_longo.setDisable(false);
	    		btn_professor.setDisable(false);
	    		btn_coordenador.setDisable(false);
	    		btn_trabalha.setDisable(false);
	    		btn_branco.setDisable(false);
	    		btn_oculos.setDisable(false);
	    		btn_segundop.setDisable(false);
	    		btn_formou.setDisable(false);
	    		txt_codeedit.setEditable(false);
		    	System.out.println(index);
		    	txt_codeedit.setText(c.alunos.get(index).getNchamada().toString());
		    	txt_nome.setText(c.alunos.get(index).getNome());
		    	txt_idade.setText(c.alunos.get(index).getIdade().toString());
		    	txt_email.setText(c.alunos.get(index).getEmail());
		    	btn_careca.setSelected(c.infs.get(index).isCareca());
		    	btn_masculino.setSelected(c.infs.get(index).isSexo());
		    	btn_barba.setSelected(c.infs.get(index).isBarba());
		    	btn_ansi.setSelected(c.infs.get(index).isCursa_ansi());
		    	btn_azuis.setSelected(c.infs.get(index).isOlhos_azuis());
		    	btn_verdes.setSelected(c.infs.get(index).isOlhos_verdes());
		    	btn_alto.setSelected(c.infs.get(index).isAlto());
		    	btn_longo.setSelected(c.infs.get(index).isCabelo_longo());
		    	btn_professor.setSelected(c.infs.get(index).isEh_professor());
		    	btn_coordenador.setSelected(c.infs.get(index).isEh_coordenador());
		    	btn_trabalha.setSelected(c.infs.get(index).isTrabalha());
		    	btn_branco.setSelected(c.infs.get(index).isEh_branco());
		    	btn_oculos.setSelected(c.infs.get(index).isUsa_oculos());
		    	btn_segundop.setSelected(c.infs.get(index).isCursa_segundop());
		    	btn_loiro.setSelected(c.infs.get(index).isEh_loiro());
		    	btn_formou.setSelected(c.infs.get(index).isSe_formou());
		    }
		}
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
}
