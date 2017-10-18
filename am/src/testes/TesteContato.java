package testes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Contato;
import beans.Fornecedor;
import bo.ContatoBO;
import bo.FornecedorBO;
import excecao.Excecao;

public class TesteContato {
	
		
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

	public static void main(String[] args) {
		
		ContatoBO bo = new ContatoBO();
		Contato contato = new Contato();
		Fornecedor fornecedor = new Fornecedor ();
		FornecedorBO fornbo = new FornecedorBO ();
        Excecao excecao = new Excecao();
		 try
	        {
	           
	            do
	            {
	                char op =JOptionPane.showInputDialog
	                     ("Escolha uma opção:\n "
	                         + "<G> - Gravar Contato\n "
	                         + "<A> - Atualizar Contato\n "
	                         + "<P> - Pesquisar Contato").toUpperCase().charAt(0);
	                
	                if (op=='G')
	                {
	                	
	                   boolean newContato = textboo ("Digite [sim] para inserir um novo contato, ou [nao] para sair.");
	                   
	                   fornecedor = fornbo.consultarPorIds(textint ("Digite o id do fornecedor que deseja inserir esse novo contato: "));
	                   
	                   if (newContato) {
	                	   
	                	  fornecedor.setContatos(new ArrayList<>());
	                	   
	                   }
	           	   
	         	   
	                                          	
	                       while(newContato) {
	                    
	                        
	                    	contato.setIdContato(textint("Digite o id do contato: "));
	                    	
	                    	contato.setTelefone(texto("Digite o telefone do contato: "));
	                    	
	                    	contato.setEmail(texto("Digite o email do contato: "));
	                    	
	                    	contato.setFacebook(texto("Digite o facebook: "));
	                    	
	                    	fornecedor.getContatos().add(contato);
	                    	   
	                       
	                       System.out.println(bo.gravarContato(fornecedor));
	                       
	                      newContato = textboo ("Digite [sim] para inserir um novo contato, ou [nao] para sair.");
	                       
	                       
	                       
	                       }
	                                    	   
	                	   
	                   }
	                   
	                
	                
	                else if (op=='P')
	                {
	                    
	                	for (Contato c : bo.retornaContato(textint("Digite o id do contato que deseja selecionar: "))) {
	                		
	                		System.out.println("Id do contato" + c.getIdContato());
	                		System.out.println("Telefone: " + c.getTelefone());
	                		System.out.println(("Email: " + c.getEmail()));
	                		System.out.println("Facebook: " + c.getFacebook());
							
						}
	                	
	                }

				
	                else if (op=='A')
	                {
	                	
	                	String x = bo.alterarTelefonePorFornecedor(
	                			texto("Insira o novo telefone: "),
	                			textint("Digite o id do contato que terá o telefone alterado: "));
	                	
	                	System.out.println(x);

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
		 		catch(Exception exception){
	            String x = excecao.tratarExcecao(exception);
	            System.out.println(x);
	        }
	        
	    }
	}
