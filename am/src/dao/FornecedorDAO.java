package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Fornecedor;
import conexao.ConexaoFactory;

public class FornecedorDAO {
    
        private Connection con;
        private PreparedStatement estrutura;
        
        public FornecedorDAO () throws Exception {
            con = new ConexaoFactory().conectar();
        }
        
        public String fechar () throws Exception {
            con.close();
            return "Conexao fechada com sucesso";
            
        }
    

        public String adcFornecedor(Fornecedor forn) throws Exception {
            estrutura = con.prepareStatement
                    ("INSERT INTO Fornecedor (ID_FORNECEDOR, NUMERO_CONTRATO, GERENTE_CONTRATO) VALUES(?,?,?)");
            estrutura.setInt(1, forn.getId_fornecedor());
            estrutura.setString(2, forn.getNumeroContrato());
            estrutura.setString(3, forn.getGerenteContrato());
            estrutura.execute();
            estrutura.close();
            return "Gravado com sucesso";
        
        }
        
        public int delete(int i) throws Exception {
            PreparedStatement estrutura = con.prepareStatement ("delete from Fornecedor where ID_FUNCIONARIO = ?");
            estrutura.setInt(1, i);
            int x = estrutura.executeUpdate();
            estrutura.close();
            return x;
        
}

        public String alterarGerente(String gerente, int i) throws Exception {
            PreparedStatement estrutura = con.prepareStatement
            ("update Fornecedor set GERENTE_CONTRATO = ? where ID_FORNECEDOR = ?");
            estrutura.setString(1, gerente);
            estrutura.setInt(2, i);
            estrutura.executeUpdate();
            estrutura.close();
            return "Alterado com sucesso";
        }
        
        public Fornecedor getFornecedor(int i) throws Exception{
            Fornecedor forn = new Fornecedor();
            estrutura = con.prepareStatement
                    ("SELECT NUMERO_CONTRATO, GERENTE_CONTRATO FROM Fornecedor WHERE ID_FORNECEDOR = ?");
            estrutura.setInt (1,i);
            ResultSet resultado = estrutura.executeQuery();                            
            if(resultado.next()) {
                forn.setNumeroContrato(resultado.getString("numero_contrato"));
                forn.setGerenteContrato(resultado.getString("gerente_contrato"));    
                
            }
            resultado.close();
            estrutura.close();
            return forn;

        }
        
        
}


