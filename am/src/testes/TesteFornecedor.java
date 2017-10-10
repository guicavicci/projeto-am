package testes;

import javax.swing.JOptionPane;

import beans.Fornecedor;
import bo.FornecedorBO;
import dao.FornecedorDAO;

public class TesteFornecedor {
	
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
                    Fornecedor obj = new Fornecedor();
                    obj.setAll(
                    		textint("Digite o id do Fornecedor: "),
                    		texto("Digite o numero do contrato:"),
                    		texto("Digite o nome do gerente do contrato: "),
                    		textint("Digite o id do contato: "),
                    		texto("Digite o telefone:"),
                    		texto("Digite o email:"),
                    		texto("Digite o facebook:"),
                    		textint("Digite o id do Endereco: "),
                    		texto("Digite o rua:"),
                    		textint("Digite o numero:"),
                    		texto("Digite a cidade:"),
                    		textboo("Digite 0, para criar um usuário com status ativo")
                    		
                    		);
                    System.out.println(bo.adicionarNovoFornecedor(obj));

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


