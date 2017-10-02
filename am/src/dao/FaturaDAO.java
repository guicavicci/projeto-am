package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    public String criar(Fatura fatura)throws Exception
    {
         estrutura = con.prepareStatement
        ("INSERT INTO FATURA (ID_FATURA, NUMERO_FATURA, CONSUMO_KWH, VALOR) VALUES (?,?,?,?)");
        estrutura.setInt(1, fatura.getId_fatura());
        estrutura.setString(2, fatura.getNumeroFatura());
        estrutura.setString(3, fatura.getConsumoKwh());
        estrutura.setDouble(4, fatura.getValor());
        int nm = estrutura.executeUpdate();
        estrutura.close();
        return nm + " linha foi criada!";
    }
    //Pegar fatura
    public Fatura getFatura(int i) throws Exception
    {
        Fatura fatura = new Fatura();
        estrutura = con.prepareStatement
        ("SELECT * FROM FATURA WHERE ID_FATURA = ?");
        estrutura.setLong(1, i);
        resultado = estrutura.executeQuery();
        if(resultado.next())
        {
        	fatura.setId_fatura(resultado.getInt("ID_FATURA"));
        	fatura.setNumeroFatura(resultado.getString("NUMERO_FATURA"));
        	fatura.setConsumoKwh(resultado.getString("CONSUMO_KWH"));
        	fatura.setValor(resultado.getDouble("VALOR"));
        }
        return fatura;
    }
    //Deletar fatura
    public int delete(int i)throws Exception
    {
        PreparedStatement estrutura = con.prepareStatement
        ("DELETE FROM FATURA WHERE ID_FATURA = ?");
        estrutura.setLong(1, i);
        int x = estrutura.executeUpdate();
        estrutura.close();
        return x;
    }
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


