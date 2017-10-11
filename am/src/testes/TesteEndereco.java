package testes;

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
                    
                    end.setId_endereco(	
                    		textint("Digite o id: "));
                    
                    end.setRua(                    
                    		texto("Digite o rua:"));
                    
                    end.setNumero(
                    		textint("Digite o numero: "));
                    
                    end.setCidade(
                    		texto("Digite o cidade: "));
                    
                    forn.setId_fornecedor(
                    		textint("Digite o ID do fornecedor que será atribuido esse contato: "));
                    
                    System.out.println(bo.adicionarNovoEndereco(forn));

                }else if (op=='C'){
                	//Consultar
                    bo = new EnderecoBO();
                    Endereco end = bo.retornaEndereco(textint("Digite o cep do Endereco:"));
                    
                    System.out.println("Rua: " + end.getRua());
                    System.out.println("Numero: " + end.getNumero());
                    System.out.println("Cidade: " + end.getCidade());

                }else if (op=='A'){
                    bo = new EnderecoBO();
                    String end = bo.alterarEndereco(
                    		texto("Digite a nova cidade: "),
                    		texto ("Digite o cep que terá a cidade alterada: "));
                    		              		
                    System.out.println(end + "campo email atualizado");


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


