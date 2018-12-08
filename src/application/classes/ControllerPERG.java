package application.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import application.Final;
import application.Pergunta;
import application.telas.Conexao;
import application.telas.Informacoes;
import application.telas.Pessoa;
import application.telas.Questions;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class ControllerPERG {
	List<Questions> perguntas = new ArrayList<Questions>();
	List<Integer> indexz = new ArrayList<Integer>();
	List<Informacoes> infss = new ArrayList<Informacoes>();
	Informacoes people = new Informacoes();
	Random rand = new Random();
	Integer raiz = 0;
	boolean nao = false;
	boolean sim = true;
	Integer indexperg;
	public String perg;
	public static Integer dale = 0;
	
	@FXML
    private Pane root;

    @FXML
    private ImageView img_view;

    @FXML
    private TextField txt_pergunta;

    @FXML
    private Button btn_sim;

    @FXML
    private Button btn_nao;

    @FXML
    private Button btn_talvez;
   
    @FXML
    private Button btn_iniciar;
    
    @FXML
    private Button btn_reiniciar;
    
    @FXML
    private Button btn_Sairk;
    
    @FXML
    void iniciar() {
    	Conexao c = new Conexao();
    	c.Conectar();
    	c.ReceberAlunos();
    	for (Informacoes x : c.infs) {
    		infss.add(x);
    	}
    	sortearPerg();
    	btn_iniciar.setVisible(false);
    	System.out.println(infss.size());
    	for(Informacoes x : infss) {
    		System.out.println("Sexo: "+x.isSexo()+" Barba: "+x.isBarba()+" Careca: "+x.isCareca());
    	}
    }
    
    public void sortearPerg() {
    	if(raiz == 0) {
	    	Questions p = new Questions();
	    	p.setId_pergunta(1);
	    	p.setPergunta("Essa pessoa é careca?");
	    	perguntas.add(p);
	    	Questions p2 = new Questions();
	    	p2.setId_pergunta(2);
	    	p2.setPergunta("Essa pessoa tem barba?");
	    	perguntas.add(p2);
	    	Questions p3 = new Questions();
	    	p3.setId_pergunta(3);
	    	p3.setPergunta("Essa pessoa é Homem?");
	    	perguntas.add(p3);
	    	Questions p4 = new Questions();
	    	p4.setId_pergunta(4);
	    	p4.setPergunta("Essa pessoa cursa ANSI?");
	    	perguntas.add(p4);
	    	Questions p5 = new Questions();
	    	p5.setId_pergunta(5);
	    	p5.setPergunta("Essa pessoa tem olhos azuis?");
	    	perguntas.add(p5);
	    	Questions p6 = new Questions();
	    	p6.setId_pergunta(6);
	    	p6.setPergunta("Essa pessoa tem olhos verdes?");
	    	perguntas.add(p6);
	    	Questions p7 = new Questions();
	    	p7.setId_pergunta(7);
	    	p7.setPergunta("Essa pessoa é alta?");
	    	perguntas.add(p7);
	    	Questions p8 = new Questions();
	    	p8.setId_pergunta(8);
	    	p8.setPergunta("Essa pessoa tem cabelo longo?");
	    	perguntas.add(p8);
	    	Questions p9 = new Questions();
	    	p9.setId_pergunta(9);
	    	p9.setPergunta("Essa pessoa é professor?");
	    	perguntas.add(p9);
	    	Questions p10 = new Questions();
	    	p10.setId_pergunta(10);
	    	p10.setPergunta("Essa pessoa é coordenador?");
	    	perguntas.add(p10);
	    	Questions p11 = new Questions();
	    	p11.setId_pergunta(11);
	    	p11.setPergunta("Essa pessoa trabalha?");
	    	perguntas.add(p11);
	    	Questions p12 = new Questions();
	    	p12.setId_pergunta(12);
	    	p12.setPergunta("Essa pessoa é branca?");
	    	perguntas.add(p12);
	    	Questions p13 = new Questions();
	    	p13.setId_pergunta(13);
	    	p13.setPergunta("Essa pessoa usa óculos?");
	    	perguntas.add(p13);
	    	Questions p14 = new Questions();
	    	p14.setId_pergunta(14);
	    	p14.setPergunta("Essa pessoa cursa segundo período?");
	    	perguntas.add(p14);
	    	Questions p15 = new Questions();
	    	p15.setId_pergunta(15);
	    	p15.setPergunta("Essa pessoa é loira?");
	    	perguntas.add(p15);
	    	Questions p16 = new Questions();
	    	p16.setId_pergunta(16);
	    	p16.setPergunta("Essa pessoa se formou?");
	    	perguntas.add(p16);
	    	raiz = 1;
    	}
    	if(perguntas.size() > 1) {
    		Integer quantia = perguntas.size();
    		Integer sortear = rand.nextInt(quantia);
    		System.out.println(sortear);
        	txt_pergunta.setText(perguntas.get(sortear).getPergunta());
        	indexz.add(sortear);
        	int dale = sortear;
        	indexperg = dale;
        	System.out.println("Pergunta: "+indexperg);
        }
    	else if (perguntas.size() == 1) {
    		Integer quantia = perguntas.size();
    	    int sortear = rand.nextInt(quantia);
    	    System.out.println(sortear);
        	txt_pergunta.setText(perguntas.get(sortear).getPergunta());
        	System.out.println("Pergunta: "+sortear);
        	indexperg = sortear;
    	}
	}
    
    @FXML
    void executarNao(MouseEvent btn_nao) {
    	System.out.println("Inicio do Método");
    	if(perguntas.get(indexperg).getId_pergunta() == 1) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
        		if(infss.get(x).isCareca() == true) {
        			System.out.println("normal careca");
        			infss.remove(x);
        			people.setCareca(false);
        			x = 0;
        		}
        	}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 2) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
        		if(infss.get(x).isBarba() == true) {
        			System.out.println("Removeu sem barba");
        			infss.remove(x);
        			people.setBarba(false);
        			x = 0;
        		}
        	}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 3) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
        		if(infss.get(x).isSexo() == true) {
        			System.out.println("Removeu masculino");
        			infss.remove(x);
        			people.setSexo(false);
        			x = 0;
        		}
        	}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 4) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
    			if(infss.get(x).isCursa_ansi() == true) {
    				System.out.println("Removou cursa ansi");
    				infss.remove(x);
    				people.setCursa_ansi(false);
    				x = 0;
    			}
    		}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 5) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
    			if(infss.get(x).isOlhos_azuis() == true) {
    				System.out.println("Removeu olhos azuis");
    				infss.remove(x);
    				people.setOlhos_azuis(false);
    				x = 0;
    			}
    		}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 6) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
    			if(infss.get(x).isOlhos_verdes() == true) {
    				System.out.println("Removeu olhos verdes");
    				infss.remove(x);
    				people.setOlhos_verdes(false);
    				x = 0;
    			}
    		}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 7) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
    			if(infss.get(x).isAlto() == true) {
    				System.out.println("Removeu pessoa alta");
    				infss.remove(x);
    				people.setAlto(false);
    				x = 0;
    			}
    		}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 8) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
    			if(infss.get(x).isCabelo_longo() == true) {
    				System.out.println("Removeu cabelo longo");
    				infss.remove(x);
    				people.setCabelo_longo(false);
    				x = 0;
    			}
    		}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 9) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
    			if(infss.get(x).isEh_professor() == true) {
    				System.out.println("Removeu professor");
    				infss.remove(x);
    				people.setEh_professor(false);
    				x = 0;
    			}
    		}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 10) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
    			if(infss.get(x).isEh_coordenador() == true) {
    				System.out.println("Removeu coordenador");
    				infss.remove(x);
    				people.setEh_coordenador(false);
    				x = 0;
    			}
    		}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 11) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
    			if(infss.get(x).isTrabalha() == true) {
    				System.out.println("Removeu trabalhador");
    				infss.remove(x);
    				people.setTrabalha(false);
    				x = 0;
    			}
    		}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 12) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
    			if(infss.get(x).isEh_branco() == true) {
    				System.out.println("Removeu branco");
    				infss.remove(x);
    				people.setEh_branco(false);
    				x = 0;
    			}
    		}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 13) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
    			if(infss.get(x).isUsa_oculos() == true) {
    				System.out.println("Removeu usa oculos");
    				infss.remove(x);
    				people.setUsa_oculos(false);
    				x = 0;
    			}
    		}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 14) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
    			if(infss.get(x).isCursa_segundop() == true) {
    				System.out.println("Removeu segundo p");
    				infss.remove(x);
    				people.setCursa_segundop(false);
    				x = 0;
    			}
    		}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 15) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
    			if(infss.get(x).isEh_loiro() == true) {
    				System.out.println("Removeu loiro");
    				infss.remove(x);
    				people.setEh_loiro(false);
    				x = 0;
    			}
    		}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 16) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
    			if(infss.get(x).isSe_formou() == true) {
    				System.out.println("Removeu se formou");
    				infss.remove(x);
    				people.setSe_formou(false);
    				x = 0;
    			}
    		}
    	}
    	for(Informacoes x : infss) {
    		System.out.println(x.getId_carac());
    		System.out.println("Sexo: "+x.isSexo()+" Barba: "+x.isBarba()+" Careca: "+x.isCareca());
    	}
    	System.out.println("Entrou no método");
    	sortearPerg();
    	segundaVerificacao();
    }

    @FXML
    void executarSim(MouseEvent btn_sim) {
    	if(perguntas.get(indexperg).getId_pergunta() == 1) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
        		if(infss.get(x).isCareca() == false) {
        			System.out.println("normal careca");
        			people.setCareca(true);
        			infss.remove(x);
        			x = 0;
        		}
        	}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 2) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
        		if(infss.get(x).isBarba() == false) {
        			System.out.println("Removeu sem barba");
        			infss.remove(x);
        			people.setBarba(true);
        			x = 0;
        		}
        	}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 3) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
        		if(infss.get(x).isSexo() == false) {
        			System.out.println("Removeu masculino");
        			infss.remove(x);
        			people.setSexo(true);
        			x = 0;
        		}
        	}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 4) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
        		if(infss.get(x).isCursa_ansi() == false) {
        			System.out.println("Removeu ansi");
        			infss.remove(x);
        			people.setCursa_ansi(true);
        			x = 0;
        		}
        	}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 5) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
        		if(infss.get(x).isOlhos_azuis() == false) {
        			System.out.println("Removeu azuis");
        			infss.remove(x);
        			people.setOlhos_azuis(true);
        			x = 0;
        		}
        	}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 6) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
        		if(infss.get(x).isOlhos_verdes() == false) {
        			System.out.println("Removeu verdes");
        			infss.remove(x);
        			people.setOlhos_verdes(true);
        			x = 0;
        		}
        	}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 7) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
        		if(infss.get(x).isAlto() == false) {
        			System.out.println("Removeu alto");
        			infss.remove(x);
        			people.setAlto(true);
        			x = 0;
        		}
        	}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 8) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
        		if(infss.get(x).isCabelo_longo() == false) {
        			System.out.println("Removeu longo");
        			infss.remove(x);
        			people.setCabelo_longo(true);
        			x = 0;
        		}
        	}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 9) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
        		if(infss.get(x).isEh_professor() == false) {
        			System.out.println("Removeu prof");
        			infss.remove(x);
        			people.setEh_professor(true);
        			x = 0;
        		}
        	}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 10) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
        		if(infss.get(x).isEh_coordenador() == false) {
        			System.out.println("Removeu coord");
        			infss.remove(x);
        			people.setEh_coordenador(true);
        			x = 0;
        		}
        	}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 11) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
        		if(infss.get(x).isTrabalha() == false) {
        			System.out.println("Removeu trab");
        			infss.remove(x);
        			people.setTrabalha(true);
        			x = 0;
        		}
        	}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 12) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
        		if(infss.get(x).isEh_branco() == false) {
        			System.out.println("Removeu branco");
        			infss.remove(x);
        			people.setEh_branco(true);
        			x = 0;
        		}
        	}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 13) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
        		if(infss.get(x).isUsa_oculos() == false) {
        			System.out.println("Removeu óculos");
        			infss.remove(x);
        			people.setUsa_oculos(true);
        			x = 0;
        		}
        	}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 14) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
        		if(infss.get(x).isCursa_segundop() == false) {
        			System.out.println("Removeu segundop");
        			infss.remove(x);
        			people.setCursa_segundop(true);
        			x = 0;
        		}
        	}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 15) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
        		if(infss.get(x).isEh_branco() == false) {
        			System.out.println("Removeu branco");
        			infss.remove(x);
        			people.setEh_branco(true);
        			x = 0;
        		}
        	}
    	}
    	else if(perguntas.get(indexperg).getId_pergunta() == 16) {
    		int de = indexperg;
    		perguntas.remove(de);
    		for(int x = 0; x < infss.size(); x++) {
        		if(infss.get(x).isSe_formou() == false) {
        			System.out.println("Removeu formou");
        			infss.remove(x);
        			people.setSe_formou(true);
        			x = 0;
        		}
        	}
    	}
    	for(Informacoes x : infss) {
    		System.out.println(x.getId_carac());
    		System.out.println("Sexo: "+x.isSexo()+" Barba: "+x.isBarba()+" Careca: "+x.isCareca());
    	}
    	System.out.println("Entrou no método");
    	
    	sortearPerg();
    	segundaVerificacao();
    }

    @FXML
    void executarTalvez(MouseEvent btn_talvez) {
    	final Node source = (Node) btn_talvez.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    void executarReiniciar(MouseEvent btn_reiniciar) {
    	final Node source = (Node) btn_reiniciar.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        Pergunta p = new Pergunta();
        p.start(new Stage());
    }
    
    @FXML
    void executarSairk(MouseEvent btn_Sairk) {
    	final Node source = (Node) btn_Sairk.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void alert(String mensagem){
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	alert.setHeaderText(null);
    	alert.setTitle("Mensagem");
    	alert.setContentText(mensagem);
    	alert.show();
    }
    
    public void segundaVerificacao() {
    	Integer verificacao = 0;
    	Conexao c = new Conexao();
    	c.Conectar();
    	c.ReceberAlunos();
    	Pessoa lun = new Pessoa();
    	if(infss.size() == 0) {
			alert("Impossível localizar essa pessoa!");
			btn_sim.setDisable(true);
			btn_nao.setDisable(true);
			btn_talvez.setDisable(true);
			btn_reiniciar.setVisible(true);
			btn_reiniciar.setDisable(false);
			btn_Sairk.setVisible(true);
			btn_Sairk.setDisable(false);
		}
    	if (infss.size() < 5) {
    		for (Informacoes x : infss) {
        		if (x.isBarba() == people.isBarba()) {
        			verificacao++;
        			System.out.println("Primeira Verificação");
        			if (x.isCareca() == people.isCareca()) {
        				verificacao++;
        				System.out.println("Segunnda Verificação");
        				if(x.isSexo() == people.isSexo()) {
        					verificacao++;
        					System.out.println("Terceira Verificação");
        					if(x.isCursa_ansi() == people.isCursa_ansi()) {
        						verificacao++;
        						System.out.println("Quarta verificação");
        						if(x.isOlhos_azuis() == people.isOlhos_azuis()) {
        							verificacao++;
        							System.out.println("Quinta Verificação");
        							if(x.isOlhos_verdes() == people.isOlhos_verdes()) {
        								verificacao++;
        								System.out.println("Sexta Verificação");
        								if(x.isAlto() == people.isAlto()) {
        									verificacao++;
        									System.out.println("Sétima Verificação");
        									if(x.isCabelo_longo() == people.isCabelo_longo()) {
        										verificacao++;
        										System.out.println("Oitava Verificação");
        										if(x.isEh_professor() == people.isEh_professor()) {
        											verificacao++;
        											System.out.println("Nona Verificação");
        											if(x.isEh_coordenador() == people.isEh_coordenador()) {
        												verificacao++;
        												System.out.println("Décima Verificação");
        												if(x.isTrabalha() == people.isTrabalha()) {
        													verificacao++;
        													System.out.println("Décima primeira Verificação");
        													if(x.isEh_branco() == people.isEh_branco()) {
        														verificacao++;
        														System.out.println("Décima segunda verificação");
        														if(x.isUsa_oculos() == people.isUsa_oculos()) {
        															verificacao++;
        															System.out.println("Décima terceira Verificação");
        															if(x.isCursa_segundop() == people.isCursa_segundop()) {
        																verificacao++;
        																System.out.println("Décima quarta Verificação");
        																if(x.isEh_loiro() == people.isEh_loiro()) {
        																	verificacao++;
        																	System.out.println("Décima quinta Verificação");
        																	if(x.isSe_formou() == people.isSe_formou()) {
        																		verificacao++;
        																		System.out.println("Décima sexta verificação");
        																		System.out.println("DSHJFHSJF: "+verificacao);
        																	}
    											        				}
        															}
        														}
        													}
        												}
        											}
        										}
        									}
        								}
        							}
        						}
        					}
        				}
        			}
        		}
        		if(perguntas.size() == 0) {
        			for (Pessoa z : c.alunos) { 
    					if(x.getId_carac() == z.getNchamada()) {
    						lun.setNome(z.getNome());
    					}
    				}
        			ControllerACHOU a = new ControllerACHOU();
        			a.dale = lun.getNome();
        			Final f = new Final();
        			f.start(new Stage());
        			//alert(lun.getNome());
        			dale = a.verificacao1;
        			System.out.println(a.verificacao1);
        			btn_sim.setDisable(true);
        			btn_nao.setDisable(true);
        			btn_talvez.setDisable(true);
        			btn_reiniciar.setVisible(true);
        			btn_reiniciar.setDisable(false);
        			btn_Sairk.setVisible(true);
        			btn_Sairk.setDisable(false);
        		}
        	}
    	}
    }
}
