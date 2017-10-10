package testes;

import javax.swing.JOptionPane;

import beans.Cliente;
import beans.Endereco;
import bo.ClienteBO;
import bo.EnderecoBO;
import bo.ClienteBO;
import dao.ClienteDAO;

public class TesteCliente {
	
	static String texto (String texto) {
		return JOptionPane.showInputDialog(texto);
		
	}
	
	static int textint (String textint) {
		return Integer.parseInt(JOptionPane.showInputDialog(textint));
		
	}
	
	static boolean textboo (String textboo) {
		return Boolean.parseBoolean(JOptionPane.showInputDialog(textboo));

		
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
                    Cliente obj = new Cliente();
                    obj.setAll(	
                    		textint("Digite o valor do debito: "),
                    		texto("Digite o numero instalacao: "),
                    		texto("Digite o debito pendente: "));
                    		textboo("Digite o status: ");
                    		
                    
                    System.out.println(bo.AdicionarNovoCliente(obj));		

                }else if (op=='C'){
                	//Consultar
                    bo = new ClienteBO();
                    int numeroInscricao = textint("Digite o id do Cliente : ");
					cliente = ClienteBO.consultarCliente(numeroInscricao);
					

                }else if (op=='A'){
                	bo.modificarDebitoPendente(
							
							texto ("Digite a valor do novo debito pendente : "),
							textint ("Digite o id do Cliente : "));
                	

                }
                else if (op == 'D') {
                	//Deletar
            	
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


