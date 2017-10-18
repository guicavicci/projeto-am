package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Fornecedor;
import conexao.ConexaoFactory;

public class FornecedorDAO {
    
        private Connection con;
        private PreparedStatement estrutura;
    	private ResultSet resultado;
        
        public FornecedorDAO () throws Exception {
            con = new ConexaoFactory().conectar();
        }
        
        public String fechar () throws Exception {
            con.close();
            return "Conexao fechada com sucesso";
            
        }
    

        public String adcFornecedor(Fornecedor forn) throws Exception {
            estrutura = con.prepareStatement
                    ("INSERT INTO Fornecedor (ID_FORNECEDOR, NUMERO_CONTRATO, GERENTE_CONTRATO, STATUS) VALUES(?,?,?,?)");
            estrutura.setInt(1, forn.getIdFornecedor());
            estrutura.setString(2, forn.getNumeroContrato());
            estrutura.setString(3, forn.getGerenteContrato());
            estrutura.setBoolean(4, forn.isStatus());
            estrutura.execute();
            estrutura.close();
            
            //Contato
            ContatoDAO dao = new ContatoDAO ();
            dao.gravarContato(forn);
            dao.fechar();
            
            //Endereco
            EnderecoDAO end = new EnderecoDAO ();
            end.gravarEndereco(forn);
            end.fechar();
            
            
            return "Gravado com sucesso";
        
        }
        
        public Fornecedor getFornecedor(int i) throws Exception{
            Fornecedor forn = new Fornecedor();
            estrutura = con.prepareStatement
                    ("SELECT ID_FORNECEDOR, NUMERO_CONTRATO, GERENTE_CONTRATO FROM Fornecedor WHERE ID_FORNECEDOR = ? AND STATUS = 0");
            estrutura.setInt (1,i);
            resultado = estrutura.executeQuery();                            
            if(resultado.next()) {
            	forn.setId_fornecedor(resultado.getInt("ID_FORNECEDOR"));
                forn.setNumeroContrato(resultado.getString("NUMERO_CONTRATO"));
                forn.setGerenteContrato(resultado.getString("GERENTE_CONTRATO"));  
                
                //Contato
                ContatoDAO daocont = new ContatoDAO ();
                forn.setContatos(daocont.getContatoPorFornecedor(forn.getIdFornecedor()));
                
                //Endereco
                EnderecoDAO daoend = new EnderecoDAO ();
                forn.setEnderecos(daoend.getEnderecoPorFornecedor(resultado.getInt("ID_FORNECEDOR")));
                
            }
            resultado.close();
            estrutura.close();
            return forn;

        }
        
       
        /*
        	public int delete(int i) throws Exception {
            PreparedStatement estrutura = con.prepareStatement ("delete from Fornecedor where ID_FUNCIONARIO = ?");
            estrutura.setInt(1, i);
            int x = estrutura.executeUpdate();
            estrutura.close();
            return x;
        
} */

        public String alterarGerente(String gerente, int i) throws Exception {
            PreparedStatement estrutura = con.prepareStatement
            ("UPDATE Fornecedor SET GERENTE_CONTRATO = ? WHERE ID_FORNECEDOR = ?");
            estrutura.setString(1, gerente);
            estrutura.setInt(2, i);
            estrutura.executeUpdate();
            estrutura.close();
            return "Alterado com sucesso";
        }
        
        public String statusFornecedor(boolean s, int i) throws Exception {
            PreparedStatement estrutura = con.prepareStatement
            ("UPDATE Fornecedor SET STATUS = ? WHERE ID_FORNECEDOR = ?");
            estrutura.setBoolean(1, s);
            estrutura.setInt(2, i);
            estrutura.executeUpdate();
            estrutura.close();
            return "Alterado com sucesso";
        }
        

        
        
}


