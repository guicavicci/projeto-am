package bo;

import beans.Cliente;
import dao.ClienteDAO;

public class ClienteBO {
	
	public static String AdicionarNovoCliente (Cliente cli) throws Exception {
		
		//Abre conexaoo
		
		ClienteDAO dao = new ClienteDAO();
		
		if(dao.selecionarCliente(cli.getIdCliente()).getIdCliente()>0) {
			dao.fechar();
			
			return "Esse ID ja esta cadastrado em nosso banco de dados!";
			
			
		}
		dao.gravarCliente(cli);
		dao.fechar();
		
		return "Adicionado com sucesso!";
		
	}
	
	public static Cliente consultarCliente (int id) throws Exception {
		
		if (id < 1) {
			return new Cliente ();
		}
		
		ClienteDAO dao = new ClienteDAO ();
		Cliente cli = dao.selecionarCliente(id);
		dao.fechar();
		
		return cli;
		
		
		
		
	}
	
	
	public static String alterarStatusCliente (boolean s, int i) throws Exception {
		
		if (i < 0) {
			
			return "Esse cliente não existe em nosso banco de dados!";
		}
		
		//Abre conexao
		ClienteDAO dao = new ClienteDAO ();
		

		dao.statusCliente(s, i);
		dao.fechar();
		return "Cliente modificado!";
		
		
	}
	
	public static String modificarDebitoPendente (String d, int i) throws Exception {
		
		if (d.length()>20) {
			
			return "Quantidade de caracteres excedido";
		}
		
		ClienteDAO dao = new ClienteDAO();
		dao.atualizarDebitoPendente(d, i);
		dao.fechar();
		return "Modificado!";
		
		
	}
	

	
}
