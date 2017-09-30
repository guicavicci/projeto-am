package beans;


public class PessoaFisica {
	private String cpf;
	private String rg;
	private String dataNascimento;
	
	public String getAll () {
		return cpf + "\n" + rg + "\n" + dataNascimento;
		
	}
	
	public void setAll(String c, String r, String dn) {
		cpf =c;
		rg=r;
		dataNascimento = dn;
		
	}
	
	
}