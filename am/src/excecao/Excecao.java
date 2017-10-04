package excecao;

import java.sql.SQLException;

public class Excecao extends Exception{
	public static String tratarExcecao(Exception e){
		if(e instanceof NumberFormatException){
			return "Numero invalido";
		}else if (e instanceof SQLException){
			if(e.getMessage().indexOf("invalid username")>=0){
				return "Usuario ou senha invalido";
			}else if(e.getMessage().indexOf("tabela ou view")>=0){
				return "Problema na tabela";
			}
			return "Erro ao conectar no banco de dados";
		}else{
			return "Ocorreu um erro inesperado";
		}
	}
}