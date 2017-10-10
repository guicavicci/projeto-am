package bo;

import beans.Fornecedor;
import dao.FornecedorDAO;

public class FornecedorBO {
    
    public static String adicionarNovoFornecedor(Fornecedor f)throws Exception{
    	
    	FornecedorDAO dao = new FornecedorDAO();
    	dao.adcFornecedor(f);
    	dao.fechar();
    	
       
        return "Fornecedor Adicionado!";
    }

    public static Fornecedor consultarPorIds(int i) throws Exception{
       
    	FornecedorDAO dao = new FornecedorDAO();
    	Fornecedor f = dao.getFornecedor(i);
    	dao.fechar();
    	
        return f;
    }
    
    public static String mudarGerente(String g, int i) throws Exception {
       
    	FornecedorDAO dao = new FornecedorDAO();
    	dao.alterarGerente(g, i);
    	dao.fechar();
    		
        return "Gerente alterado!";
    }
          
    public static String desativarFornecedor (boolean s, int i) throws Exception {
    	
    	FornecedorDAO dao = new FornecedorDAO();
    	dao.DesativarFornecedor(s, i);
    	dao.fechar();
    	
        return "Usuario desativado!";
        
    
    }
   
}
