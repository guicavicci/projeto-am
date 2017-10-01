package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Cliente;
import conexao.ConexaoFactory;

public class ClienteDAO {
	private Connection con;
	private PreparedStatement estrutura;
	private ResultSet rs;
	
	public ClienteDAO () throws Exception {
		con = new ConexaoFactory().conectar();
	}
	
	public String fechar () throws Exception {
		con.close();
		return "Conexao fechada com sucesso";
		
	}
	
	public String gravarCliente(Cliente cliente) throws Exception {
		estrutura = con.prepareStatement
				("INSERT INTO Cliente (ID_CLIENTE, NUMERO_INSTALACAO, DEBITO PENDENTE) VALUES(?,?,?)");
		estrutura.setInt(1, cliente.getId_cliente());
		estrutura.setString(2, cliente.getNumeroInstalacao());
		estrutura.setString(3, cliente.getDebitoPendente());
		estrutura.execute();
		estrutura.close();
		return "Gravado com sucesso";
	}
	
	public Cliente selecionarCliente(int i) throws Exception{
		Cliente cliente = new Cliente();
		estrutura = con.prepareStatement
				("SELECT ID_CLIENTE, NUMERO_INSTALACAO, DEBITO PENDENTE FROM CLIETE WHERE ID_CLIENTE = ?");
		estrutura.setInt(1, i);
		rs = estrutura.executeQuery();							
		if(rs.next()) {
			cliente.setId_cliente(rs.getInt("ID_CLIENTE"));
			cliente.setNumeroInstalacao(rs.getString("numero_instalacao"));
			cliente.setDebitoPendente(rs.getString("debito_pentende"));
			
		}
		rs.close();
		estrutura.close();
		return cliente;

	}
	
	public int deletarCliente(int i) throws Exception {
		PreparedStatement estrutura = con.prepareStatement("DELETE FROM CLIENTE WHERE ID_CLIENTE = ?");
		estrutura.setInt(1, i);
		int x = estrutura.executeUpdate();
		estrutura.close();
		return x;
		
	}
	
	public int atualizarDebitoPendente (Cliente cliente) throws Exception{
		PreparedStatement estrutura = con.prepareStatement
		("UPDATE CLIENTE SET DEBITO_PENDENTE = ? WHERE ID_CLIENTE = ?");
		estrutura.setString(1, cliente.getDebitoPendente());
		estrutura.setInt(2, cliente.getId_cliente());
		int z = estrutura.executeUpdate();
		estrutura.close();
		System.out.println(z);
		return z;
	}
	
}
