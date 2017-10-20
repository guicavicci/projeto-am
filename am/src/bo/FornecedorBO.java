package bo;

import beans.Fornecedor;
import dao.FornecedorDAO;

public class FornecedorBO {
    
    public static String adicionarNovoFornecedor(Fornecedor f)throws Exception{
    	  
    	//Abre conexao
    	FornecedorDAO dao = new FornecedorDAO();
    	
    	if (dao.getFornecedor(f.getIdFornecedor()).getIdFornecedor()>0) {
    		
    		return "ID do fornecedorr já cadastrado em nosso banco dados";
    	}
    	
    	dao.adcFornecedor(f);
    	dao.fechar();
    	
       
        return "Fornecedor Adicionado!";
    }

    public static Fornecedor consultarPorIds(int i) throws Exception{
       
    	if (i < 0) {
    		
    		return new Fornecedor();
    	}
    	
    	FornecedorDAO dao = new FornecedorDAO();
    	Fornecedor f = dao.getFornecedor(i);
    	dao.fechar();
    	
        return f;
    }
    
    public static String mudarGerente(String g, int i) throws Exception {
       
    	if (g.length() > 20) {
    		
    		return "Excedeu o limite de caracteres!";
    		
    		
    	}
    	FornecedorDAO dao = new FornecedorDAO();
    	dao.alterarGerente(g, i);
    	dao.fechar();
    		
        return "Gerente alterado!";
    }
          
    public static String statusFornecedor (boolean s, int i) throws Exception {
    	
    	FornecedorDAO dao = new FornecedorDAO();
    	dao.statusFornecedor(s, i);
    	dao.fechar();
    	
        return "Fornecedor modificado!";
        
    
    }
   
}
