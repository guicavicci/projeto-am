package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

	public String gravarEndereco(Endereco end) throws Exception{
		
		
		estrutura = con.prepareStatement("INSERT INTO ENDERECO (ID_ENDERECO, RUA, NUMERO, CIDADE) VALUES (?,?,?,?)");
		estrutura.setInt(1, end.getId_endereco());
		estrutura.setString(2, end.getRua());
		estrutura.setInt(3, end.getNumero());
		estrutura.setString(4, end.getCidade());
		int x = estrutura.executeUpdate();
			
		estrutura.close();
		
		return "Total de: " + x + "Linhas inseridas";
	}
	
	
	public Endereco getEndereco (int i) throws Exception {
		
		Endereco end = new Endereco();
		estrutura.getConnection().prepareStatement
		("SELECT ID_ENDERECO, RUA, NUMERO, CIDADE FROM ENDERECO WHERE ID_ENDERECO = ?");
		estrutura.setInt(1, i);
		rs = estrutura.executeQuery();
		
		if (rs.next()){
			end.setId_endereco(rs.getInt("id_endereco"));
			end.setRua(rs.getString("rua"));
			end.setNumero(rs.getInt("numero"));
			end.setCidade(rs.getString("cidade"));			
			
		}
		rs.close();
		estrutura.close();
		return end;
	}
	
}
