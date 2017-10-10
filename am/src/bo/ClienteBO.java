package bo;

import beans.Cliente;
import dao.ClienteDAO;

public class ClienteBO {
	
	public static String AdicionarNovoCliente (Cliente cli) throws Exception {
		
		//Abre conexão
		ClienteDAO dao = new ClienteDAO();
		dao.gravarCliente(cli);
		dao.fechar();
		
		return "Adicionado com sucesso!";
		
	}
	
	public static Cliente consultarCliente (int id) throws Exception {
		
		ClienteDAO dao = new ClienteDAO ();
		Cliente cli = dao.selecionarCliente(id);
		dao.fechar();
		
		return cli;
		
		
		
		
	}
	
	
	public static String desativarCliente (boolean s, int i) throws Exception {
		
		ClienteDAO dao = new ClienteDAO ();
		dao.desativarCliente(s, i);
		dao.fechar();
		return "Desativado com sucesso";
		
		
	}
	
	public static String modificarDebitoPendente (Cliente cli) throws Exception {
		
		ClienteDAO dao = new ClienteDAO();
		dao.atualizarDebitoPendente(cli);
		dao.fechar();
		return "Modificado!";
		
		
	}
	

	
}
