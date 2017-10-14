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
				("INSERT INTO Cliente (ID_CLIENTE, NUMERO_INSTALACAO, DEBITO_PENDENTE, STATUS) VALUES(?,?,?)");
		estrutura.setInt(1, cliente.getId_cliente());
		estrutura.setString(2, cliente.getNumeroInstalacao());
		estrutura.setString(3, cliente.getDebitoPendente());
		estrutura.execute();
		estrutura.close();
		
		//Fatura
		
		FaturaDAO dao = new FaturaDAO();
		dao.adicionarFatura(cliente);
		dao.fechar();
		return "Gravado com sucesso";
	}
	
	public Cliente selecionarCliente(int i) throws Exception{
		Cliente cliente = new Cliente();
		estrutura = con.prepareStatement
				("SELECT ID_CLIENTE, NUMERO_INSTALACAO, DEBITO_PENDENTE FROM CLIENTE WHERE ID_CLIENTE = ? AND STATUS = 0");
		estrutura.setInt(1, i);
		rs = estrutura.executeQuery();							
		if(rs.next()) {
			cliente.setId_cliente(rs.getInt("ID_CLIENTE"));
			cliente.setNumeroInstalacao(rs.getString("numero_instalacao"));
			cliente.setDebitoPendente(rs.getString("debito_pentende"));
		
		//Fatura
		
		FaturaDAO dao = new FaturaDAO();
		cliente.setFatura(dao.consultarPorCliente(rs.getInt("ID_CLIENTE")));
		dao.fechar();

		}
		
		rs.close();
		estrutura.close();
		return cliente;

	}
	
	
	
	/*
	public int deletarCliente(int i) throws Exception {
		PreparedStatement estrutura = con.prepareStatement("DELETE FROM CLIENTE WHERE ID_CLIENTE = ?");
		estrutura.setInt(1, i);
		int x = estrutura.executeUpdate();
		estrutura.close();
		return x;
		
	} */
	
	public int atualizarDebitoPendente (String d, int i) throws Exception{
		PreparedStatement estrutura = con.prepareStatement
		("UPDATE CLIENTE SET DEBITO_PENDENTE = ? WHERE ID_CLIENTE = ?");
		estrutura.setString(1, d);
		estrutura.setInt(2, i);
		int z = estrutura.executeUpdate();
		estrutura.close();
		return z;
	}
	
	public int desativarCliente(boolean s, int i) throws Exception{
		PreparedStatement estrutura = con.prepareStatement
		("UPDATE CLIENTE SET STATUS = ? WHERE ID_CLIENTE = ?");
		estrutura.setBoolean(1, s);
		estrutura.setInt(2, i);
		int z = estrutura.executeUpdate();
		estrutura.close();
		return z;
	}
	
}
