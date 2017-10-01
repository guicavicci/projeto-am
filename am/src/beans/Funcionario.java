package beans;


public class Funcionario{
	
	private int id_funcionario;
	private String cargo;
	private double salario;
	private String admissao;
	
	public String getAll() {
		return id_funcionario + "\n" + cargo + "\n" + "\n" + salario + "\n" + admissao;
	}
	
	public void setAll (int id, String cg, double s, String a) {
		id_funcionario =id;
		cargo=cg;
		salario=s;
		admissao = a;
		
	}
	
	
	public Funcionario() {
		super();
	}

	public Funcionario(int id_funcionario, String cargo, double salario, String admissao) {
		super();
		this.id_funcionario = id_funcionario;
		this.cargo = cargo;
		this.salario = salario;
		this.admissao = admissao;
	}


	public int getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(int id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getAdmissao() {
		return admissao;
	}

	public void setAdmissao(String admissao) {
		this.admissao = admissao;
	}
	
	
}
