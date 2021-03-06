package testes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Contato;
import beans.Endereco;
import beans.Fornecedor;
import bo.EnderecoBO;
import bo.FornecedorBO;
import excecao.Excecao;

public class TesteEndereco {
	
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
        EnderecoBO bo = new EnderecoBO();
        Endereco end = new Endereco();
        Fornecedor forn = new Fornecedor();
        FornecedorBO boforn = new FornecedorBO();
        Excecao excecao = new Excecao();
        try{
            do{
                char op =texto
                        ("Escolha uma opcao:\n "
                                + "<G> - Gravar Endereco\n "
                                + "<C> - Consultar\n "
                                + "<A> - Alterar Endereco\n"
                                + "<D> - Deletar Endereco").toUpperCase().charAt(0);
                if (op=='G'){

                    
                    boolean newEndereco = textboo ("Digite [sim] para inserir um novo Endereco, ou [nao] para sair.");
                    forn = boforn.consultarPorIds(textint("Digite o id do fornecedor que deseja inserir um novo endereco: "));
                    
                    if (newEndereco) {
                    	
                    	forn.setEnderecos(new ArrayList<>());
                    }
                    
                    while (newEndereco){
                    	
                                           
                    end.setIdEndereco(	
                    		textint("Digite o id do endereco: "));
                    
                    end.setRua(                    
                    		texto("Digite a rua: "));
                    
                    end.setNumero(
                    		textint("Digite o numero: "));
                    
                    end.setCidade(
                    		texto("Digite a cidade: "));
                    
                    forn.getEnderecos().add(end);
                    
                    System.out.println(bo.adicionarNovoEndereco(forn));
                    
                    newEndereco = textboo ("Digite [sim] para inserir um novo Endereco, ou [nao] para sair.");
                    
                    }

                    
 
                    
              

                }else if (op=='C'){
                	//Consultar
                	
                	for (Endereco e : bo.retornaEndereco(textint("Digite o id do Endereco: "))) {
                		
                		System.out.println("Id do Endereco: " + e.getIdEndereco());
                		System.out.println("Rua: " + e.getRua());
                		System.out.println("Numero: " + e.getRua());
                		System.out.println("Cidade: " + e.getCidade());
                		
						
					}
                	

                    
                }else if (op=='A'){
                  String x = bo.alterarEndereco(
                    		texto("Digite a nova rua: "),
                    		textint("Digite o novo numero: "),
                    		texto ("Digite a nova cidade: "),
                    		textint("Digite o id do endereco que sera alterado: "));
                    		              		
                    System.out.println(x);


                }
                else if (op=='D'){
                    String x = bo.deletarEndereco(
                      		textint("Digite o id do endereco que sera deletado: "));
                      		              		
                      System.out.println(x);


                  }
                               
                else{
                    System.out.println("Opcao invalida!!!");
                }
            }while(JOptionPane.showConfirmDialog
                    (null, "Continuar?", "EnderecoDAO",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE)==0);
        }catch(Exception exception){
            String x = excecao.tratarExcecao(exception);
            System.out.println(x);
        }


    }

}


