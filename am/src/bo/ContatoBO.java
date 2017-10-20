package bo;

import java.util.ArrayList;
import java.util.List;

import beans.Contato;
import beans.Fornecedor;
import dao.ContatoDAO;

public class ContatoBO {
	
	public static String gravarContato (Fornecedor forn) throws Exception {
		
		//Abre conexao
		ContatoDAO dao = new ContatoDAO();	
		dao.gravarContato(forn);
		
		return "Contato gravado com sucesso!";
		
		
	}
	
	public static List<Contato> retornaContatoPorFornecedor (int i) throws Exception {
		ContatoDAO dao = new ContatoDAO();
		
		if (i <= 0) {
		List<Contato> z = new ArrayList<>();
		
		return z;
			
		}
		List<Contato> c = dao.getContatoPorFornecedor(i);
		dao.fechar();
		
		return c;
		
	}
	
	public static List<Contato> retornaContato(int i) throws Exception {
		ContatoDAO dao = new ContatoDAO();
		
		if (i <= 0) {
		List<Contato> z = new ArrayList<>();
		
		return z;
		
		}
		
		List<Contato> c = dao.getContato(i);
		dao.fechar();
		
		return c;
		
	}
	
	public static String alterarTelefonePorFornecedor (String t, int i) throws Exception {
		
		if (t.length()>10) {
			
			return "Excedeu o limite de caracteres";
		}
		
		//Abre a conexao
		ContatoDAO dao = new ContatoDAO();
		
		dao.mudarTelefone(t, i);
		dao.fechar();		
		
		return "Telefone alterado!";
	}
	
	public static String apagarContato (int i) throws Exception{
		ContatoDAO dao = new ContatoDAO();
		dao.deletarContato(i);
		dao.fechar();
		
		
		return "Contato deletado com sucesso!";
		
		
		
	}

}
