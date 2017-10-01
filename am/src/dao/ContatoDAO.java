package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Contato;
import beans.Endereco;
import conexao.ConexaoFactory;

public class ContatoDAO {
	
	private Connection con;
	private PreparedStatement estrutura;
	private ResultSet rs;
	
	public ContatoDAO() throws Exception {
		
		con = new ConexaoFactory().conectar();	
		
	}
	
	public String fechar() throws Exception {
		con.close();
		return "Conexao fechada com sucesso!";
		
	}

	public String gravarContato(Contato cont) throws Exception{
		
		
		estrutura = con.prepareStatement("INSERT INTO CONTATO (ID_CONTATO, TELEFONE, EMAIL, FACEBOOK) VALUES (?,?,?,?)");
		estrutura.setInt(1, cont.getId_contato());
		estrutura.setString(2, cont.getTelefone());
		estrutura.setString(3, cont.getEmail());
		estrutura.setString(4, cont.getFacebook());
		
		int x = estrutura.executeUpdate();
			
		estrutura.close();
		
		return "Total de: " + x + "Linhas inseridas";
	}
	
	
	public Contato getContato (int i) throws Exception {
		
		Contato cont = new Contato();
		estrutura.getConnection().prepareStatement
		("SELECT ID_CONTATO, TELEFONE, EMAIL, FACEBOOK FROM CONTATO WHERE ID_CONTATO = ?");
		estrutura.setInt(1, i);
		rs = estrutura.executeQuery();
		
		if (rs.next()){
			cont.setId_contato(rs.getInt("ID_CONTATO"));
			cont.setTelefone(rs.getString("TELEFONE"));
			cont.setEmail(rs.getString("EMAIL"));
			cont.setFacebook(rs.getString("FACEBOOK"));
			
		}
		rs.close();
		estrutura.close();
		return cont;
	}
	
	public String mudarTelefone (String tel, int i) throws Exception {
		estrutura.getConnection().prepareStatement("UPDATE CONTATO SET TELEFONE = ? WHERE ID_CONTATO = ?");
		estrutura.setString(1, tel);
		estrutura.setInt(2, i);
		int x = estrutura.executeUpdate();
		
		return x + " Linhas atualizadas";
		
	}
	
	public String deletarContato (int i) throws Exception {
		estrutura.getConnection().prepareStatement("DELETE FROM CONTATO WHERE ID = ?");
		estrutura.setInt(1, i);
		int x = estrutura.executeUpdate();
		
		
		
		
		return x + " Linhas excluidas";
		
		
	}
	
}
