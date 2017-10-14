package testes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Cliente;
import beans.Fatura;
import bo.ClienteBO;
import bo.FaturaBO;

public class TesteFatura
{
	
	static String texto (String texto) {
		return JOptionPane.showInputDialog(texto);
		
	}
	
	static int textint (String textint) {
		return Integer.parseInt(JOptionPane.showInputDialog(textint));
		
	}
	
	static double textdoub (String textdoub) {
		return Integer.parseInt(JOptionPane.showInputDialog(textdoub));
		
	}
	
	static boolean textboo (String textboo) {
		textboo = JOptionPane.showInputDialog(textboo);
		return textboo.equalsIgnoreCase("sim") ?  true : false;
		
	}
    public static void main(String[] args)
    {
        FaturaBO bo = null;
        Fatura fat = new Fatura();
        Cliente cli = new Cliente();
        try
        {
            bo = new FaturaBO();
            do
            {
                char op =JOptionPane.showInputDialog
                     ("Escolha uma opção:\n "
                         + "<G> - Gravar fatura\n "
                         + "<A> - Atualizar taxa de fatura\n "
                         + "<P> - Pesquisar fatura").toUpperCase().charAt(0);
                
                if (op=='G')
                {
                	
                   boolean newFatura = textboo ("Digite [sim] para inserir uma fatura, ou [nao] para sair.");
                   
                   ClienteBO bocli = new ClienteBO();
                   Cliente cliente = bocli.consultarCliente(textint ("Digite o id do cliente que deseja inserir essa nova fatura: "));
                   
                   if (newFatura) {
                	   
                	   cliente.setFatura(new ArrayList<>());
                	   
                   }
           	   
            	   
                       
                   	
                       while(newFatura) {
                    
                        
                       fat.setId_fatura(
                       textint ("Insira o id da fatura: ") + fat.getId_fatura());
                       
                       fat.setNumeroFatura
                       (texto ("Insira o numero da fatura: " ) + fat.getNumeroFatura());
                       
                       fat.setConsumoKwh
                       (texto ("Insira o consumo em KWH: " ) + fat.getConsumoKwh());
                       
                       fat.setValor
                       (textdoub("Insira o valor: ") + fat.getValor());
                       
                       fat.setFkcliente(cliente.getId_cliente());
                       
                       //cliente.setId_cliente
                       //(cliente.getId_cliente());
                       
                       
                       
                       
                       
                      cliente.getFatura().add(fat);
                       

                       System.out.println(bocli.AdicionarNovoCliente(cliente));
                       
                       }
                       
                                 		              
                      	
                       
                      
                	   
                	   
                   }
                   
                
                
                else if (op=='P')
                {
                    
                	bo.mostrarFatura(textint("Digite o id da Fatura que deseja selecionar: "));
                }
                else if (op=='A')
                {
                	
                	bo.acrescimoJuros(
                			textdoub("Insira o valor que será acrescentado de juros %: "),
                			textint("Digite o id da Fatura que sofrerá o acescimo: "));

                }
                else
                {
                    System.out.println("Opção inválida!!!");
                }
            }
            while(JOptionPane.showConfirmDialog
                         (null, "Continuar?", "ProdutoDAO",
                         JOptionPane.YES_NO_OPTION,
                         JOptionPane.QUESTION_MESSAGE)==0);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
}


