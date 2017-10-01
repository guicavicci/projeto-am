package beans;


public class PessoaFisica {
	private int id_pf;
	private String nome;
	private String cpf;
	private String rg;
	private String idade;
	
	public String getAll () {
		return id_pf + "\n" + nome + "\n" + cpf + "\n" + rg + "\n" + idade;
		
	}
	
	public void setAll(int id, String n, String c, String r, String i) {
		id_pf=id;
		nome=n;
		cpf =c;
		rg=r;
		idade = i;
		
	}
	

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(int id_pf, String nome, String cpf, String rg, String idade) {
		super();
		this.id_pf = id_pf;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.idade = idade;
	}

	public int getId_pf() {
		return id_pf;
	}

	public void setId_pf(int id_pf) {
		this.id_pf = id_pf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}
	
	
	
}