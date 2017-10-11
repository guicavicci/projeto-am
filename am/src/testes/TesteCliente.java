package testes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Cliente;
import beans.Fatura;
import bo.ClienteBO;

public class TesteCliente {
	
	static String texto (String texto) {
		return JOptionPane.showInputDialog(texto);
		
	}
	
	static int textint (String textint) {
		return Integer.parseInt(JOptionPane.showInputDialog(textint));
		
	}
	
	static boolean textboo (String textboo) {
		textboo = JOptionPane.showInputDialog(textboo);
		return textboo.equalsIgnoreCase("sim") ?  true : false;
		
	}

    public static void main(String[] args) {
        ClienteBO bo = null;
        Cliente cliente = null;
        try{
            bo = new ClienteBO();
            do{
                char op =texto
                        ("Escolha uma opção:\n "
                                + "<G> - Gravar Cliente\n "
                                + "<C> - Consultar\n "
                                + "<A> - Alterar Cliente\n"
                                + "<D> - Desativar").toUpperCase().charAt(0);
                if (op=='G'){
                	bo = new ClienteBO();
                    cliente.setId_cliente(	
                    		textint("Digite o valor do debito: "));
                    
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
                    	System.out.println("Digite o id da fatura" + fat.getId_fatura());
                    	System.out.println("Numero da fatura: " + fat.getNumeroFatura());
                    	System.out.println("Consumo: " + fat.getConsumoKwh());
                    	System.out.println("Valor da fatura: " + fat.getValor());
                    	
                    	cliente.getFatura().add(fat);
             
                    		
                    
                    System.out.println(bo.AdicionarNovoCliente(cliente));		
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
			       		
			       		System.out.println("Id da fatura: " + f.getId_fatura());
			       		System.out.println("Numero da fatura: " + f.getNumeroFatura());
			       		System.out.println("Consumo KWH: " + f.getConsumoKwh());
			       		System.out.println("Valor: " + f.getValor());
			       		
						
					}
                	
                
                }
                else if (op=='A'){
                	bo.modificarDebitoPendente(
							
							texto ("Digite a valor do novo debito pendente : "),
							textint ("Digite o id do Cliente : "));
                	

                }
                else if (op == 'D') {
                
                	String d = bo.desativarCliente(
                 			
                 			textboo("Digite 1 para desativar o Cliente:"),
                 			textint("Digite o id do Cliente que deseja desativar")
                 			);
                	System.out.println(d);
                	
                }
                else{
                    System.out.println("Opção inválida!!!");
                }
            }while(JOptionPane.showConfirmDialog
                    (null, "Continuar?", "ClienteDAO",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE)==0);
        }catch(Exception e){
            e.printStackTrace();
        }


    }

}


