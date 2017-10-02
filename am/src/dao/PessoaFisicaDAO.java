package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.PessoaFisica;
import conexao.ConexaoFactory;

public class PessoaFisicaDAO {
	private Connection con;
	private PreparedStatement estrutura;
	private ResultSet resultado;
	
	public PessoaFisicaDAO () throws Exception {
		con = new ConexaoFactory().conectar();
		
	}
	
	public String fechar () throws Exception {
		con.close();
		
		
		return "Conexão fechada com sucesso";
		
	}
	
	public String gravar(PessoaFisica pf) throws Exception {
		estrutura = con.prepareStatement
				("INSERT INTO PESSOA_FISICA (id_pf, nome, cpf, rg, idade) VALUES(?,?,?,?,?)");
		estrutura.setInt (1,pf.getId_pf());
		estrutura.setString (2,pf.getNome());
		estrutura.setString(5, pf.getCpf());
		estrutura.setString(6, pf.getRg());
		estrutura.setString(7, pf.getIdade());
		estrutura.execute();
		estrutura.close();
		return "Gravado com sucesso";


	}
	
	public PessoaFisica getPessoaFisica(int n) throws Exception{
		PessoaFisica pf = new PessoaFisica();
		estrutura = con.prepareStatement
				("SELECT id_pf, nome, cpf, rg, idade FROM PESSOA_FISICA WHERE id_pf = ?");
		estrutura.setInt (1,n);
		resultado = estrutura.executeQuery();							
		if(resultado.next()) {
			pf.setNome(resultado.getString("nome"));
			pf.setCpf(resultado.getString("cpf"));
			pf.setRg(resultado.getString("rg"));
			pf.setIdade(resultado.getString("idade"));


		}
		resultado.close();
		estrutura.close();
		return pf;

	}
	
	public int delete (int i) throws Exception {
		estrutura = con.prepareStatement("DELETE FROM PESSOA_FISICA WHERE id_pf = ?");
		estrutura.setInt(1, i);
		int x = estrutura.executeUpdate();
		estrutura.close();
		return x;
		
	}
	
	
	public String corrigeCPF(String x, int y) throws Exception{
		estrutura = con.prepareStatement
		("UPDATE PESSOA_FISICA SET cpf = ? WHERE id_pf =?");
		estrutura.setString(1,  x);
		estrutura.setInt(2, y);
		int z = estrutura.executeUpdate();
		return "Total de " + z + "Linhas atualizadas";
	}
	
	
	

}



