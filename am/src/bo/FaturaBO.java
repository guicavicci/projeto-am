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
 
 
 public static List<Fatura> mostrarFaturaPorCliente (int i) throws Exception {
	 
	 if (i < 1) {
		 
		 List<Fatura> x = new ArrayList<>();
		 return  x;
	 }
	 
	 FaturaDAO dao = new FaturaDAO();

	 List<Fatura>  fat = dao.consultarPorCliente(i);
	 dao.fechar();
	 
	 return fat;
	 
	 
 }
 
 
 public static List<Fatura> mostrarFatura(int i) throws Exception {
	 
	 FaturaDAO dao = new FaturaDAO();

	 List<Fatura>  fat = dao.consultarPorFatura(i);
	 dao.fechar();
	 
	 return fat;
	 
	 
 }
 
 public static String acrescimoJuros (double j, int i) throws Exception {
	 if (i < 0) {
		 
		 return "Digite um id valido!";
	 }
	 
	 FaturaDAO dao = new FaturaDAO ();
	 dao.adicionarJuros(j, i);
	 dao.fechar();
	 
	 return "Juros adicionado!";
 }
 
 public static String apagarFatura (int i) throws Exception {
	 
	 FaturaDAO dao = new FaturaDAO ();
	 dao.deletarFatura(i);
	 dao.fechar();
	 
	 return "Fatura apagada!";
 }
   
}


