package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Cliente;
import beans.Fatura;
import conexao.ConexaoFactory;

public class FaturaDAO
{
    private Connection con;
    private PreparedStatement estrutura;
    private ResultSet resultado;
    
    public FaturaDAO(){}

    //Construtor (abre conexão)
    public FaturaDAO(Connection con)throws Exception
    {
        con = new ConexaoFactory().conectar();
    }
    //Fecha conexão
    public String fechar()throws Exception
    {
        con.close();
        return "Conexão fechada com sucesso!";
    }
    
    //Criar fatura
    public String adicionarFatura(Cliente cli)throws Exception
    {
    	for (Fatura fatura : cli.getFatura()) {
			
		
         estrutura = con.prepareStatement
        ("INSERT INTO FATURA (ID_FATURA, NUMERO_FATURA, CONSUMO_KWH, VALOR, ID_CLIENTE_FK_F) VALUES (?,?,?,?,?)");
        estrutura.setInt(1, fatura.getId_fatura());
        estrutura.setString(2, fatura.getNumeroFatura());
        estrutura.setString(3, fatura.getConsumoKwh());
        estrutura.setDouble(4, fatura.getValor());
        estrutura.setInt(5, cli.getId_cliente());
        estrutura.executeUpdate();
        estrutura.close();
    	}
        
        
        return "Criado com sucesso!";
    } 
    
    
    //Pegar fatura
    public List<Fatura> consultarPorCliente(int i) throws Exception
    {
    	List<Fatura> lista = new ArrayList <>();
        estrutura = con.prepareStatement
        ("SELECT id_fatura, NUMERO_FATURA, CONSUMO_KWH,  FROM FATURA, VALOR WHERE ID_CLIENTE_FK_F = ?");
        estrutura.setInt(1, i);
        resultado = estrutura.executeQuery();
        while(resultado.next())
        {
        	lista.add( new Fatura (
        			  resultado.getInt("id_fatura"),
        			  resultado.getString("NUMERO_FATURA"),
        			  resultado.getString("CONSUMO_KWH"),
        			  resultado.getDouble("VALOR")
        			
        			));
        	
   
        	
        }
        
     	return lista;
        	
			
    }

    /*
    //Deletar fatura
    public int delete(int i)throws Exception
    {
        PreparedStatement estrutura = con.prepareStatement
        ("DELETE FROM FATURA WHERE ID_CLIENTE_FK_F = ?");
        estrutura.setLong(1, i);
        int x = estrutura.executeUpdate();
        estrutura.close();
        return x;
    } */
    
    public int adicionarJuros(double taxa, int i) throws Exception
    {
        PreparedStatement estrutura = con.prepareStatement
        ("UPDATE FATURA SET VALOR = VALOR + ?/100*VALOR WHERE ID_FATURA = ?");
        estrutura.setDouble(1, taxa);
        estrutura.setLong(2, i);
        int x = estrutura.executeUpdate();
        estrutura.close();
        return x;
    }
}


