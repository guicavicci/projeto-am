package beans;

public class Fornecedor extends PessoaJuridica{
	
	private int id_fornecedor;
	private String numeroContrato;
	private String gerenteContrato;
	
	public String getAll() {
		return id_fornecedor + "\n" + numeroContrato + "\n" + gerenteContrato;
		
	}
	
	public void setAll (int id, String nc, String gc) {
		id_fornecedor = id;
		numeroContrato = nc;
		gerenteContrato = gc;
	
	}
	

	public Fornecedor() {
		super();
	}

	public Fornecedor(int id_fornecedor, String numeroContrato, String gerenteContrato) {
		super();
		this.id_fornecedor = id_fornecedor;
		this.numeroContrato = numeroContrato;
		this.gerenteContrato = gerenteContrato;
	}

	public int getId_fornecedor() {
		return id_fornecedor;
	}

	public void setId_fornecedor(int id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}

	public String getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public String getGerenteContrato() {
		return gerenteContrato;
	}

	public void setGerenteContrato(String gerenteContrato) {
		this.gerenteContrato = gerenteContrato;
	}
	
	
	
}
	
	