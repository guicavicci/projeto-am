package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.PessoaFisica;
import beans.PessoaJuridica;
import conexao.ConexaoFactory;

public class PessoaJuridicaDAO {
	
		private Connection con;
		private PreparedStatement estrutura;
		private ResultSet resultado;
		
		public PessoaJuridicaDAO () throws Exception {
			
			con = new ConexaoFactory().conectar();
			
		}
		
		public String fechar () throws Exception {
			con.close();
			return "Conexao fechada com sucesso!";
			
		}
		
		public String gravar(PessoaJuridica pj) throws Exception {
			estrutura = con.prepareStatement
					("INSERT INTO PESSOA_JURIDICA (id, nome, email, telefone, numero_contrato, razao_social, inscricao_estadual) VALUES(?,?,?,?,?,?,?)");
			estrutura.setInt (1,pj.getId_pj());
			estrutura.setString(5, pj.getNumeroContrato());
			estrutura.setString(6, pj.getRazaoSocial());
			estrutura.setString(7, pj.getCnpj());
			
			estrutura.executeUpdate();
			estrutura.close();
			return "Gravado com sucesso";


		}
		
		public PessoaJuridica getPessoaJuridica(int n) throws Exception{
			PessoaJuridica pj = new PessoaJuridica();
			estrutura = con.prepareStatement
					("SELECT numero_contrato, razao_social, cnpj FROM Pessoa WHERE id_pj= ?");
			estrutura.setInt (1,n);
			resultado = estrutura.executeQuery();							
			if(resultado.next()) {
				pj.setNumeroContrato(resultado.getString("numero_contrato"));
				pj.setRazaoSocial(resultado.getString("razao_social"));
				pj.setCnpj(resultado.getString("cnpj"));


			}
			resultado.close();
			estrutura.close();
			return pj;

		}
	
		public String delete (String c) throws Exception {
			estrutura = con.prepareStatement("DELETE FROM Pessoa WHERE cnpj = ?");
			estrutura.setString(1, c);
			int i = estrutura.executeUpdate();
			estrutura.close();
			return i + "PJ's deletados";
			
		}
		
		public String atualizarNumeroContrato (String x, int y) throws Exception{
			estrutura = con.prepareStatement
			("UPDATE Pessoa SET numero_contrato = ? WHERE id_pj =?");
			estrutura.setString(1,  x);
			estrutura.setInt(2, y);
			int z = estrutura.executeUpdate();
			return z + "linhas atualizadas";
		}
		
		

}
