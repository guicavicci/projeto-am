package testes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Endereco;
import beans.Fornecedor;
import bo.EnderecoBO;

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
        EnderecoBO bo = null;
        try{
            bo = new EnderecoBO();
            do{
                char op =texto
                        ("Escolha uma opção:\n "
                                + "<G> - Gravar Endereco\n "
                                + "<C> - Consultar\n "
                                + "<A> - Mudar Cidade\n"
                                + "<D> - Deletar").toUpperCase().charAt(0);
                if (op=='G'){
                    bo = new EnderecoBO();
                    Endereco end = new Endereco();
                    Fornecedor forn = new Fornecedor();
                    
                    boolean newEndereco = textboo ("Digite [sim] para inserir um novo Endereco, ou [nao] para sair.");
                    
                    if (newEndereco) {
                    	
                    	forn.setEnderecos(new ArrayList<>());
                    }
                    
                    while (newEndereco){
                    	
                    
                    forn.setId_fornecedor(
                    		textint("Digite o ID do fornecedor que sera atribuido esse endereco: "));
                    
                    end.setId_endereco(	
                    		textint("Digite o id do endereco: "));
                    
                    end.setRua(                    
                    		texto("Digite o rua: "));
                    
                    end.setNumero(
                    		textint("Digite o numero: "));
                    
                    end.setCidade(
                    		texto("Digite o cidade: "));
                    
                    forn.getEnderecos().add(end);
                    
                    }

                    
                    System.out.println(bo.adicionarNovoEndereco(forn));

                }else if (op=='C'){
                	//Consultar
                	
                	
                    bo = new EnderecoBO();
                    int i = (textint("Digite o id do Endereco:"));
                 	Endereco end = new Endereco();
                 	bo.retornaEndereco(i);
                    	
                    
                }else if (op=='A'){
                    bo = new EnderecoBO();
                    String end = bo.alterarEndereco(
                    		texto("Digite a nova rua: "),
                    		textint("Digite o novo numero: "),
                    		texto ("Digite a nova cidade: "),
                    		textint("Digite o id que será: "));
                    		              		
                    System.out.println(end);


                }
                else if (op == 'D') {
                	//Deletar
             	
                	bo = new EnderecoBO();
                	bo.deletarEndereco(
                			textint("Digite o id do Endereco que será excluido! "));           	
                }
                
                else{
                    System.out.println("Opção inválida!!!");
                }
            }while(JOptionPane.showConfirmDialog
                    (null, "Continuar?", "EnderecoDAO",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE)==0);
        }catch(Exception e){
            e.printStackTrace();
        }


    }

}


