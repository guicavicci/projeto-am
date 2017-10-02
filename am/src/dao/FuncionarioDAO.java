package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Funcionario;
import conexao.ConexaoFactory;

public class FuncionarioDAO {
	
	 private Connection con;
	 private PreparedStatement estrutura;
	 private ResultSet resultado;

	    public FuncionarioDAO() throws Exception{
	        con = new ConexaoFactory().conectar();
	    }
	    public String fechar()throws Exception{
	        con.close();
	        return "Fechado com sucesso!";
	    }
	    

	    public String gravar(Funcionario func) throws Exception{
	        PreparedStatement estrutura = null;
	        estrutura = con.prepareStatement
	                ("INSERT INTO Funcionario (ID_FUNCIONARIO, CARGO, SALARIO, ADMISSAO) VALUES (?,?,?)");
	        estrutura.setInt(1, func.getId_funcionario());
	        estrutura.setString(2, func.getCargo());
	        estrutura.setDouble(3, func.getSalario());
	        estrutura.setString(4, func.getAdmissao());
	        estrutura.execute();
	        estrutura.close();
	        return "Gravado com sucesso!";
	    }
	    
	    public Funcionario getFuncionario(int n)throws Exception{
	    	Funcionario func = new Funcionario();
	        PreparedStatement estrutura = con.prepareStatement("SELECT ID_FUNCIONARIO, CARGO, SALARIO, ADMISSAO FROM Funcionario WHERE ID_FUNCIONARIO = ?");
	        estrutura.setInt(1, n);
	        ResultSet resultado = estrutura.executeQuery();
	        if(resultado.next()){
	        	func.setId_funcionario(resultado.getInt("ID_FUNCIONARIO"));
	        	func.setCargo(resultado.getString("cargo"));
	        	func.setSalario(resultado.getDouble("salario"));
	        	func.setAdmissao(resultado.getString("ADMISSAO"));

	        }
	        
	        resultado.close();
	        estrutura.close();
	        return func;
	    }
	    
	    public int delete(int i) throws Exception{
	        PreparedStatement estrutura = con.prepareStatement("DELETE FROM Funcionario WHERE ID_FUNCIONARIO = ?");
	        estrutura.setInt(1, i);
	        int x = estrutura.executeUpdate();
	        estrutura.close();
	        return x;
	    }
	    
	    public String upSalario(Double s, int i)throws Exception{
	        PreparedStatement estrutura = con.prepareStatement("UPDATE Funcionario SET salario = salario + ?/100*salario WHERE ID_FUNCIONARIO=?");
	        estrutura.setDouble(1,  s);
	        estrutura.setInt(2, i);
	        int x = estrutura.executeUpdate();
	        estrutura.close();
	        return "O numero de linhas atualizadas foram" + x;
	    }
	    

}
