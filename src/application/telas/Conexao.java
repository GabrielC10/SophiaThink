package application.telas;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

//THIS IS MY CODE MOTHERFUCKER!
public class Conexao {
	private Connection conexao = null;
	private Statement statement = null;
	private Object resultset = null;
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/sophiadb";
	private String user = "root";
	private String pass = "";
	public List<Pessoa> alunos = new ArrayList<Pessoa>();
	public List<Informacoes> infs = new ArrayList<Informacoes>();
	public Pessoa person = new Pessoa();
	public Informacoes infor = new Informacoes();
	public Integer tamanho = 0;
	public String getUrl(){
		return url;
	}
	
	public void Conectar(){
		try {
			Class.forName(driver);
			this.conexao = DriverManager.getConnection(url, user, pass);
			this.statement = this.conexao.createStatement();
		} catch (Exception e){
			alert(e.getMessage());
		}
	}
	
	public boolean verificaConexao(){
		if(this.conexao != null){
			return true;
		}
		else {
			return false;
		}
	}
	
	public void listarTabela(){
		try{
			String comando = "SELECT * FROM alunos ORDER BY nchamada";
			this.resultset = this.statement.executeQuery(comando);
			this.statement = this.conexao.createStatement();
			while(((ResultSet) this.resultset).next()){
				System.out.println("ID: "+((ResultSet) this.resultset).getString("nchamada")+" - NOME: "+((ResultSet) this.resultset).getString("nome")+" - EMAIL: "+((ResultSet) this.resultset).getString("email"));
			}
		} catch (Exception e){
			alert(e.getMessage());
		}
	}
	
	public void inserirAluno(Pessoa aluno, Informacoes inf){
		String comando = "INSERT INTO alunos(nome, idade, email) VALUES (?,?,?)";
		String comando2 = "INSERT INTO informacoes(sexo, barba, careca, cursa_ansi, olhos_azuis, olhos_verdes, alto, cabelo_longo, eh_professor, eh_coordenador, trabalha, eh_branco, usa_oculos, cursa_segundop, eh_loiro, se_formou) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement cmd = (PreparedStatement)this.conexao.prepareStatement(comando);
			PreparedStatement cmd2 = (PreparedStatement)this.conexao.prepareStatement(comando2);
			cmd.setString(1, aluno.getNome());
			cmd.setInt(2, aluno.getIdade());
			cmd.setString(3, aluno.getEmail());
			cmd2.setBoolean(1, inf.isSexo());
			cmd2.setBoolean(2, inf.isBarba());
			cmd2.setBoolean(3, inf.isCareca());
			cmd2.setBoolean(4, inf.isCursa_ansi());
			cmd2.setBoolean(5, inf.isOlhos_azuis());
			cmd2.setBoolean(6, inf.isOlhos_verdes());
			cmd2.setBoolean(7, inf.isAlto());
			cmd2.setBoolean(8, inf.isCabelo_longo());
			cmd2.setBoolean(9, inf.isEh_professor());
			cmd2.setBoolean(10, inf.isEh_coordenador());
			cmd2.setBoolean(11, inf.isTrabalha());
			cmd2.setBoolean(12, inf.isEh_branco());
			cmd2.setBoolean(13, inf.isUsa_oculos());
			cmd2.setBoolean(14, inf.isCursa_segundop());
			cmd2.setBoolean(15, inf.isEh_loiro());
			cmd2.setBoolean(16, inf.isSe_formou());
			cmd.executeUpdate();
			cmd2.executeUpdate();
			cmd.close();
			cmd2.close();
		} catch(Exception e) {
			alert(e.getMessage());
		}
	}
	
	public void deletarAluno(Integer number){
		String comando = "DELETE FROM alunos WHERE nchamada = ?";
		String comando2 = "DELETE FROM informacoes WHERE id_carac = ?";
		try{
			PreparedStatement cmd = (PreparedStatement)this.conexao.prepareStatement(comando);
			PreparedStatement cmd2 = (PreparedStatement)this.conexao.prepareStatement(comando2);
			cmd.setInt(1, number);
			cmd.executeUpdate();
			cmd2.setInt(1,  number);
			cmd2.executeUpdate();
			cmd.close();
			cmd2.close();
		} catch(Exception e){
			alert(e.getMessage());
		}
	}
	
	public void ReceberAlunos(){
		ResultSet rs = null;
		try {
			PreparedStatement cmd = (PreparedStatement)this.conexao.prepareStatement("SELECT * FROM alunos");
			rs = cmd.executeQuery();
			while (rs.next()){
				Pessoa alewno = new Pessoa();
				alewno.setNome(rs.getString("nome"));
				alewno.setNchamada(rs.getInt("nchamada"));
				alewno.setIdade(rs.getInt("idade"));
				alewno.setEmail(rs.getString("email"));
				alunos.add(alewno);
			}
			PreparedStatement cmd2 = (PreparedStatement)this.conexao.prepareStatement("SELECT * FROM informacoes");
			rs = cmd2.executeQuery();
			while(rs.next()){
				Informacoes inf = new Informacoes();
				inf.setSexo(rs.getBoolean("sexo"));
				inf.setBarba(rs.getBoolean("barba"));
				inf.setCareca(rs.getBoolean("careca"));
				inf.setId_carac(rs.getInt("id_carac"));
				inf.setCursa_ansi(rs.getBoolean("cursa_ansi"));
				inf.setOlhos_azuis(rs.getBoolean("olhos_azuis"));
				inf.setOlhos_verdes(rs.getBoolean("olhos_verdes"));
				inf.setAlto(rs.getBoolean("alto"));
				inf.setCabelo_longo(rs.getBoolean("cabelo_longo"));
				inf.setEh_professor(rs.getBoolean("eh_professor"));
				inf.setEh_coordenador(rs.getBoolean("eh_coordenador"));
				inf.setTrabalha(rs.getBoolean("trabalha"));
				inf.setEh_branco(rs.getBoolean("eh_branco"));
				inf.setUsa_oculos(rs.getBoolean("usa_oculos"));
				inf.setCursa_segundop(rs.getBoolean("cursa_segundop"));
				inf.setEh_loiro(rs.getBoolean("eh_loiro"));
				inf.setSe_formou(rs.getBoolean("se_formou"));
				infs.add(inf);
			}
			cmd.close();
		} catch (SQLException e) {
			alert(e.getMessage());
		}
	}
	
	public void listarArray(){
		ReceberAlunos();
		tamanho = alunos.size();
		System.out.println("");
		for (Pessoa x : alunos){
			System.out.println("NOME: "+x.getNome()+"| CÓDIGO: "+x.getNchamada());
		}
		System.out.println("");
		for (Informacoes z : infs){
			System.out.println("SEXO: "+z.isSexo()+" | BARBA: "+z.isBarba()+" | COR DO CABELO: "+z.isCareca()+" | CURSA ANSI: "+z.isCursa_ansi()+" | AZUIS: "+z.isOlhos_azuis()+" | VERDES: "+z.isOlhos_verdes());
		}
	}
	
	public void alterarAluno(Integer code, Pessoa aluno, Informacoes inf){
		String comando = "UPDATE alunos SET nome = ?, email = ?, idade = ? WHERE nchamada = ?";
		String comando2 = "UPDATE informacoes SET sexo = ?, barba = ?, careca = ?, cursa_ansi = ?, olhos_azuis = ?, olhos_verdes = ?, alto = ?, cabelo_longo = ?, eh_professor = ?, eh_coordenador = ?, trabalha = ?, eh_branco = ?, usa_oculos = ?, cursa_segundop = ?, eh_loiro = ?, se_formou = ? WHERE id_carac = ?";
		try{
			PreparedStatement cmd = (PreparedStatement)this.conexao.prepareStatement(comando);
			PreparedStatement cmd2 = (PreparedStatement)this.conexao.prepareStatement(comando2);
			cmd.setString(1, aluno.getNome());
			cmd.setString(2, aluno.getEmail());
			cmd.setInt(3, aluno.getIdade());
			cmd.setInt(4, code);
			cmd2.setBoolean(1, inf.isSexo());
			cmd2.setBoolean(2, inf.isBarba());
			cmd2.setBoolean(3, inf.isCareca());
			cmd2.setBoolean(4, inf.isCursa_ansi());
			cmd2.setBoolean(5, inf.isOlhos_azuis());
			cmd2.setBoolean(6, inf.isOlhos_verdes());
			cmd2.setBoolean(7, inf.isAlto());
			cmd2.setBoolean(8, inf.isCabelo_longo());
			cmd2.setBoolean(9, inf.isEh_professor());
			cmd2.setBoolean(10, inf.isEh_coordenador());
			cmd2.setBoolean(11, inf.isTrabalha());
			cmd2.setBoolean(12, inf.isEh_branco());
			cmd2.setBoolean(13, inf.isUsa_oculos());
			cmd2.setBoolean(14, inf.isCursa_segundop());
			cmd2.setBoolean(15, inf.isEh_loiro());
			cmd2.setBoolean(16, inf.isSe_formou());
			cmd2.setInt(17, code);
			cmd.executeUpdate();
			cmd2.executeUpdate();
			cmd.close();
			cmd2.close();
		} catch (SQLException e){
			alert(e.getMessage());
		}
	}
	
	public void alert(String mensagem){
    	Alert alert = new Alert(Alert.AlertType.ERROR);
    	alert.setHeaderText(null);
    	alert.setTitle("Mensagem");
    	alert.setContentText(mensagem);
    	alert.show();
    }
}
