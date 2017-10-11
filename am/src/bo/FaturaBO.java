package bo;

import java.util.ArrayList;
import java.util.List;

import beans.Cliente;
import beans.Fatura;
import dao.FaturaDAO;;

public class FaturaBO{
	
 public static String adicionarNovaFatura(Cliente cli) throws Exception {
	 
	 FaturaDAO dao = new FaturaDAO();
	 dao.adicionarFatura(cli);
	 dao.fechar();
	 
	 return "Fatura adicionada";
	 
 }
 
 
 public static List<Fatura> mostrarFatura (int i) throws Exception {
	 
	 FaturaDAO dao = new FaturaDAO();

	 List<Fatura>  fat = dao.consultarPorCliente(i);
	 dao.fechar();
	 
	 return fat;
	 
	 
 }
 
 
 public static String acrescimoJuros (double j, int i) throws Exception {
	 
	 FaturaDAO dao = new FaturaDAO ();
	 dao.adicionarJuros(j, i);
	 dao.fechar();
	 
	 return "Juros adicionado!";
 }
   
}


