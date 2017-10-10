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
		dao.selecionarCliente(id);
		dao.fechar();
		
		return dao;
		
		
		
		
	}
	

	
}
