package testes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Contato;
import beans.Endereco;
import beans.Fornecedor;
import bo.FornecedorBO;

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

    public static void main(String[] args) {
        FornecedorBO bo = null;
        try{
            bo = new FornecedorBO();
            do{
                char op =texto
                        ("Escolha uma opção:\n "
                                + "<G> - Gravar Fornecedor\n "
                                + "<C> - Consultar\n "
                                + "<A> - Alterar Gerente\n"
                                + "<D> - Deletar").toUpperCase().charAt(0);
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
                    		textboo("Deseja criar um usuário com status ativo? (0 ou 1)"));
                    		                    		
                    //Contato
                    
                    boolean newContato = textboo ("Digite [sim] para cadastrar um novo contato, e [não] para sair");
                    
                    if(newContato) {
                    	fornecedor.setContatos(new ArrayList<Contato>()); 	
                    	
                    }
                    
                    while(newContato) {
                    	Contato contato = new Contato();
                    	
                    	contato.setId_contato(
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
                	boolean newEndereco = textboo("Digite [sim] para cadastrar um novo endereco, e [não] para sair");
                    
                    if(newEndereco) {
                    	fornecedor.setEnderecos(new ArrayList<Endereco>());
                    }
                    
                    while(newEndereco) {
                    	Endereco endereco = new Endereco();
                    	endereco.setId_endereco(textint("Digite o id do Endereco: "));
                    	
                    	endereco.setRua(
                  		texto("Digite o rua:"));
                    	
                    	endereco.setNumero(
                  		textint("Digite o numero:"));
                    	
                    	endereco.setCidade(
                  		texto("Digite a cidade:"));
                    	
                  		fornecedor.getEnderecos().add(endereco);
                  		newEndereco = textboo("Digite [sim] para cadastrar um novo endereco, e [não] para sair");
                    }
                    
                    
                    
                    
            		System.out.println(bo.adicionarNovoFornecedor(fornecedor));    
    
                    
                }else if (op=='C'){
                	//Consultar
                    bo = new FornecedorBO();
                    Fornecedor forn = bo.consultarPorIds(textint("Digite o contrato do Fornecedor:"));
                    
                    System.out.println("Numero do contrato: " + forn.getNumeroContrato());
                    System.out.println("Gerente: " + forn.getGerenteContrato());

                }else if (op=='A'){
                    bo = new FornecedorBO();
                    String p = bo.mudarGerente(
                    		texto("Digite o nome do novo gerente:"),
                    		textint ("Digite o id que irá ter o gerente alterado:"));
                    		              		
                    System.out.println(p);


                }
                else if (op == 'D') {
             	
                	bo = new FornecedorBO();
                	String d = bo.desativarFornecedor(
                			textboo("Digite [1] para desativar o Fornecedor: "),
                			textint("Digite o id do Fornecedor que será desativado: ")
                			);
                	System.out.println(d);
                	
                }
                else{
                    System.out.println("Opção inválida!!!");
                }
            }while(JOptionPane.showConfirmDialog
                    (null, "Continuar?", "FornecedorBO",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE)==0);
        }catch(Exception e){
            e.printStackTrace();
        }


    }

}


