package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Contato;
import beans.Fornecedor;
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

	public String gravarContato(Fornecedor f) throws Exception{
		
		for (Contato cont : f.getContatos()) {
			
		estrutura = con.prepareStatement("INSERT INTO CONTATO (ID_CONTATO, TELEFONE, EMAIL, FACEBOOK, ID_FORNECEDOR_FK_C) VALUES (?,?,?,?,?)");
		estrutura.setInt(1, cont.getId_contato());
		estrutura.setString(2, cont.getTelefone());
		estrutura.setString(3, cont.getEmail());
		estrutura.setString(4, cont.getFacebook());
		estrutura.setInt(5, f.getId_fornecedor());
		
		estrutura.executeUpdate();
		estrutura.close();
		}
		
		return "Gravado com sucesso";
	}
	
	
	public List<Contato> getContatoPorFornecedor (int i) throws Exception {
		
		List<Contato> lista = new ArrayList<>();
		estrutura.getConnection().prepareStatement
		("SELECT ID_CONTATO, TELEFONE, EMAIL, FACEBOOK FROM CONTATO WHERE ID_FORNECEDOR_FK_C = ?");
		estrutura.setInt(1, i);
		rs = estrutura.executeQuery();
		
		while (rs.next())
			
			lista.add(new Contato(
					rs.getInt("ID_CONTATO"),
					rs.getString("TELEFONE"),
					rs.getString("EMAIL"),
					rs.getString("FACEBOOK")
					
					
					
					));
		estrutura.close();
		rs.close();
		return lista;
				

			
	
	}
	
	public List<Contato> getContato(int i) throws Exception {
		
		List<Contato> lista = new ArrayList<>();
		estrutura.getConnection().prepareStatement
		("SELECT ID_CONTATO, TELEFONE, EMAIL, FACEBOOK FROM CONTATO WHERE ID_CONTATO = ?");
		estrutura.setInt(1, i);
		rs = estrutura.executeQuery();
		
		while (rs.next())
			
			lista.add(new Contato(
					rs.getInt("ID_CONTATO"),
					rs.getString("TELEFONE"),
					rs.getString("EMAIL"),
					rs.getString("FACEBOOK")
					
					
					
					));
		estrutura.close();
		rs.close();
		return lista;
				

			
	
	}
	
	
	public String mudarTelefone(String tel, int i) throws Exception {
		
		
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
