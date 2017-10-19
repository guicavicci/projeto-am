package testes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Contato;
import beans.Endereco;
import beans.Fornecedor;
import bo.ContatoBO;
import bo.FornecedorBO;
import excecao.Excecao;

public class TesteFornecedor {
	
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
	
	static boolean status (String status) {
		status = JOptionPane.showInputDialog(status);
		return status.equalsIgnoreCase("desativar") ?  true : false;
		
	}

    public static void main(String[] args) {
        FornecedorBO bo = new FornecedorBO();
        Excecao excecao = new Excecao();
        try{
            do{
                char op =texto
                        ("Escolha uma opcao:\n "
                                + "<G> - Gravar Fornecedor\n "
                                + "<C> - Consultar\n "
                                + "<A> - Alterar Gerente\n"
                                + "<S> - Alterar status").toUpperCase().charAt(0);
                if (op=='G'){
                    bo = new FornecedorBO();
                    Fornecedor fornecedor = new Fornecedor();
                    fornecedor.setId_fornecedor(
                    		textint("Digite o id do Fornecedor: "));
                    fornecedor.setNumeroContrato(
                       		texto("Digite o numero do contrato:"));
                    fornecedor.setGerenteContrato(
                    		texto("Digite o nome do gerente do contrato: "));
                    fornecedor.setStatus(		
                    		textboo("Deseja criar um usuario com status ativo? (0 ou 1)"));
                    		                    		
                    //Contato
                    
                    boolean newContato = textboo ("Digite [sim] para cadastrar um novo contato, e [nao] para sair");
                    
                    if(newContato) {
                    	fornecedor.setContatos(new ArrayList<Contato>()); 	
                    	
                    }
                    
                    while(newContato) {
                    	Contato contato = new Contato();
                    	
                    	contato.setIdContato(
                    	textint("Digite o id do contato: "));
                    	
                    	contato.setTelefone(
                		texto("Digite o telefone:"));
                    	
                    	contato.setEmail(
                		texto("Digite o email:"));
                    	
                    	contato.setFacebook(
                		texto("Digite o facebook:"));
                    	
                    	fornecedor.getContatos().add(contato);
                    	
                    	newContato = textboo ("Digite [sim] para cadastrar um novo contato, e [não] para sair");
                    	
                    }
                    
                    	
           		
                
                    
                
                //Endereco
                	boolean newEndereco = textboo("Digite [sim] para cadastrar um novo endereco, e [nao] para sair");
                    
                    if(newEndereco) {
                    	fornecedor.setEnderecos(new ArrayList<Endereco>());
                    }
                    
                    while(newEndereco) {
                    	Endereco endereco = new Endereco();
                    	endereco.setIdEndereco(textint("Digite o id do Endereco: "));
                    	
                    	endereco.setRua(
                  		texto("Digite o rua:"));
                    	
                    	endereco.setNumero(
                  		textint("Digite o numero:"));
                    	
                    	endereco.setCidade(
                  		texto("Digite a cidade:"));
                    	
                  		fornecedor.getEnderecos().add(endereco);
                  		newEndereco = textboo("Digite [sim] para cadastrar um novo endereco, e [nao] para sair");
                    }
                    
                    
                    
                    
            		System.out.println(bo.adicionarNovoFornecedor(fornecedor));    
    
                    
                }else if (op=='C'){
                	//Consultar
                    bo = new FornecedorBO();
                    Fornecedor forn = bo.consultarPorIds(textint("Digite o id do Fornecedor:"));
                    
                    System.out.println("Numero do contrato: " + forn.getNumeroContrato());
                    System.out.println("Gerente: " + forn.getGerenteContrato());
                   
                    boolean listaContato = textboo("Digite [sim] para listar os contatos, e [nao] para sair");
                    Contato cont = new Contato();
                    for (Contato c : forn.getContatos()) {
                    System.out.println("Id do contato: " + c.getIdContato());
                    System.out.println("Telefone: " + c.getTelefone());
                    System.out.println("Email: " + c.getEmail());
                    System.out.println("Facebook: " + c.getFacebook());
                    }
                    
                    boolean listaEndereco = textboo("Digite [sim] para listar os enderecos, e [nao] para sair");
                    Endereco end = new Endereco();
                    for (Endereco e : forn.getEnderecos()) {
                    	System.out.println(("Id do Endereco: " + e.getIdEndereco()));
                    	System.out.println("Rua: " + e.getRua());
                    	System.out.println("Numero: " + e.getNumero());
                    	System.out.println("Cidade: " + e.getCidade());
						
					}
                }else if (op=='A'){
                    bo = new FornecedorBO();
                    String p = bo.mudarGerente(
                    		texto("Digite o nome do novo gerente:"),
                    		textint ("Digite o id que ira ter o gerente alterado:"));
                    		              		
                    System.out.println(p);


                }
                else if (op == 'S') {
             	
                	bo = new FornecedorBO();
                	String d = bo.statusFornecedor(
                			status("Digite [deastivar] para desativar ou [ativar] para ativar o Fornecedor: "),
                			textint("Digite o id do Fornecedor que tera o status alterado: ")
                			);
                	System.out.println(d);
                	
                }
                else{
                    System.out.println("Opcao invalida!!!");
                }
            }while(JOptionPane.showConfirmDialog
                    (null, "Continuar?", "FornecedorBO",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE)==0);
        }catch(Exception exception){
            String x = excecao.tratarExcecao(exception);
            System.out.println(x);
        }


    }

}


