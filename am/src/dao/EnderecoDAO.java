package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Endereco;
import beans.Fornecedor;
import conexao.ConexaoFactory;

public class EnderecoDAO {
	
	private Connection con;
	private PreparedStatement estrutura;
	private ResultSet rs;
	
	public EnderecoDAO() throws Exception {
		
		con = new ConexaoFactory().conectar();	
		
	}
	
	public String fechar() throws Exception {
		con.close();
		return "Conexao fechada com sucesso!";
		
	}

	public String gravarEndereco(Fornecedor forn) throws Exception{
		
		for (Endereco end : forn.getEnderecos()) {
			estrutura = con.prepareStatement("INSERT INTO ENDERECO (ID_ENDERECO, RUA, NUMERO, CIDADE, ID_FORNECEDOR_FK_E) VALUES (?,?,?,?,?)");
			estrutura.setInt(1, end.getId_endereco());
			estrutura.setString(2, end.getRua());
			estrutura.setInt(3, end.getNumero());
			estrutura.setString(4, end.getCidade());
			estrutura.setInt(5, forn.getId_fornecedor());
			estrutura.executeUpdate();
			estrutura.close();
		}
					
		return "Inserido com sucesso!";
	}
	
	
	public List<Endereco> getEnderecoPorFornecedor (int i) throws Exception {
		
		List<Endereco> lista = new ArrayList<>();
		
		Endereco end = new Endereco();
		estrutura.getConnection().prepareStatement
		("SELECT ID_ENDERECO, RUA, NUMERO, CIDADE FROM ENDERECO WHERE ID_FORNCEDOR = ?");
		estrutura.setInt(1, i);
		rs = estrutura.executeQuery();
		
		while (rs.next()){
			
			lista.add(new Endereco
					(rs.getInt("ID_ENDERECO"),
					 rs.getString("RUA"),
					 rs.getInt("NUMERO"),
					 rs.getString("CIDADE")));
			
		}
		
		rs.close();
		estrutura.close();
		return lista;
	}
	
	public String mudarEndereco (Endereco end) throws Exception {
		estrutura.getConnection().prepareStatement
		("UPDATE ENDERECO SET RUA = ?, NUMERO = ?, CIDADE = ? WHERE ID_FORNECEDOR");
		estrutura.setString(1, end.getRua());
		estrutura.setInt(2, end.getNumero());
		estrutura.setString(3, end.getCidade());
		estrutura.executeUpdate();
		estrutura.close();
		return "Atualizado com sucesso";
	}
	

    /*
	public int delete(int i) throws Exception {
        PreparedStatement estrutura = con.prepareStatement ("DELETE FROM ENDERECO WHERE ID_ENDERECO = ?");
        estrutura.setInt(1, i);
        int z = estrutura.executeUpdate();
        estrutura.close();
        return z;
    }*/
    

    
}

