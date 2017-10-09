package beans;

import java.util.List;

public class Fornecedor {
	
	private int id_fornecedor;
	private String numeroContrato;
	private String gerenteContrato;
	private List<Contato> contato;
	private List<Endereco> endereco;
	private boolean status;
	
	public String getAll() {
		return id_fornecedor + "\n" + numeroContrato + "\n" + gerenteContrato + "\n" + contato + "\n" + endereco + "\n" + status;
		
	}
	
	public void setAll (int id, String nc, String gc, List<Contato> c, List<Endereco> e, boolean s ) {
		id_fornecedor = id;
		numeroContrato = nc;
		gerenteContrato = gc;
		contato = c;
		status = s;
	
	}
	
	

	public Fornecedor() {
		super();
	}

	public Fornecedor(int id_fornecedor, String numeroContrato, String gerenteContrato, List<Contato> contato,
			List<Endereco> endereco, boolean status) {
		super();
		this.id_fornecedor = id_fornecedor;
		this.numeroContrato = numeroContrato;
		this.gerenteContrato = gerenteContrato;
		this.contato = contato;
		this.endereco = endereco;
		this.status = status;
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

	public List<Contato> getContato() {
		return contato;
	}

	public void setContato(List<Contato> contato) {
		this.contato = contato;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
	
	