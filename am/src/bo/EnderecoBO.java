package bo;

import java.util.List;

import beans.Endereco;
import beans.Fornecedor;
import dao.EnderecoDAO;

public class EnderecoBO {
	
	public static String adicionarNovoEndereco(Fornecedor forn) throws Exception {
		EnderecoDAO dao = new EnderecoDAO();
		dao.gravarEndereco(forn);
		dao.fechar();
		
		return "Endereco adicionado com sucesso!";
	} 
	
	
	public static List<Endereco> retornaEndereco (int i) throws Exception {
		EnderecoDAO dao = new EnderecoDAO();
		List<Endereco> listaEnd = dao.getEnderecoPorFornecedor(i);
		dao.fechar();
		
		return listaEnd;
		
	}
	
	public static String alterarEndereco (String r,int n, String c, int i) throws Exception {
		
		EnderecoDAO dao = new EnderecoDAO();
		dao.mudarEndereco(r, n, c, i);
		dao.fechar();
		
		return "Endereco alterado!";
	}
	
	public static String deletarEndereco (int i) throws Exception {
		EnderecoDAO dao = new EnderecoDAO();
		dao.delete(i);
		dao.fechar();
		
		return "Endereco deletado!";
	}


}

