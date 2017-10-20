package testes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Cliente;
import beans.Fatura;
import bo.ClienteBO;
import excecao.Excecao;

public class TesteCliente {
	
	static String texto (String texto) {
		return JOptionPane.showInputDialog(texto);
		
	}
	
	static int textint (String textint) {
		return Integer.parseInt(JOptionPane.showInputDialog(textint));
		
	}
	
	static double textdoub (String textdoub) {
		return Double.parseDouble(JOptionPane.showInputDialog(textdoub));
		
	}
	
	static boolean textboo (String textboo) {
		textboo = JOptionPane.showInputDialog(textboo);
		return textboo.equalsIgnoreCase("sim") ?  true : false;
		
	}
	
	static boolean status (String status) {
		status = JOptionPane.showInputDialog(status);
		return status.equalsIgnoreCase("desativar") ?  true : false;
		
	}
	

    public static void main(String[] args) {
        ClienteBO bo = new ClienteBO();
        Cliente cliente = new Cliente();
        Excecao excecao = new Excecao();
        try{
            bo = new ClienteBO();
            do{
                char op =texto
                        ("Escolha uma opcao:\n "
                                + "<G> - Gravar Cliente\n "
                                + "<C> - Consultar\n "
                                + "<A> - Alterar Debito Pendente Cliente\n"
                                + "<S> - Alterar status").toUpperCase().charAt(0);
                if (op=='G'){
                    cliente.setIdCliente(	
                    		textint("Digite o id do cliente: "));
                    
                    cliente.setNumeroInstalacao(               
                    		texto("Digite o numero instalacao: "));
                    		
                    cliente.setDebitoPendente(
                    texto("Digite o debito pendente: "));
                    		
                    cliente.setStatus(
                    		textboo("Digite o status: "));
                    
                    boolean newFatura = textboo ("Digite [sim] para inserir uma fatura, ou [nao] para sair.");
                    
                    if (newFatura) {
                    	
                    	cliente.setFatura(new ArrayList<>());
                    }
                    
                    while (newFatura) {
                    
                    	Fatura fat = new Fatura();
                    	
                    	fat.setIdFatura(textint("Digite o id da fatura: "));
                    	
                    	fat.setNumeroFatura(texto("Digite o numero da fatura: "));
                    	
                    	fat.setConsumoKwh(texto("Digite o consumo em KWH: "));
                    	
                    	fat.setValor(textdoub("Digite o valor: "));
                    	               	
                    	
                    	cliente.getFatura().add(fat);
             
                    		
                    
                    System.out.println(bo.AdicionarNovoCliente(cliente));		
                    
                    newFatura = textboo ("Digite [sim] para inserir uma fatura, ou [nao] para sair.");
                    
                    
                    }
                }else if (op=='C'){
                	//Consultar
                    bo = new ClienteBO();
                    int i = textint("Digite o id do Cliente : ");
					cliente = ClienteBO.consultarCliente(i);
					
					System.out.println("Numero instalacao: " + cliente.getNumeroInstalacao());
					System.out.println("Debito pendente: " + cliente.getDebitoPendente());
					

					
			       	Fatura fat = new Fatura();
			       	for (Fatura f : cliente.getFatura()) {
			       		
			       		System.out.println("Id da fatura: " + f.getIdFatura());
			       		System.out.println("Numero da fatura: " + f.getNumeroFatura());
			       		System.out.println("Consumo KWH: " + f.getConsumoKwh());
			       		System.out.println("Valor: " + f.getValor());
			       		
						
					}
                	
                
                }
                else if (op=='A'){
                	String x = bo.modificarDebitoPendente(
							
							texto ("Digite o novo novo debito pendente : "),
							textint ("Digite o id do Cliente : "));
                	
                	System.out.println(x);

                }
                else if (op == 'S') {
                
                	String d = bo.alterarStatusCliente(
                 			
                 			status("Digite [deastivar] para desativar ou [ativar] para ativar o Cliente: "),
                 			textint("Digite o id do Cliente que deseja alterar o status: ")
                 			);
                	System.out.println(d);
                	
                }
                else{
                    System.out.println("Opcao invalida!!!");
                }
            }while(JOptionPane.showConfirmDialog
                    (null, "Continuar?", "ClienteDAO",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE)==0);
        }catch(Exception exception){
            String x = excecao.tratarExcecao(exception);
            System.out.println(x);
        }


    }

}


