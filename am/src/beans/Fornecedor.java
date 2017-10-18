package beans;

import java.util.List;

public class Fornecedor {
	
	private int idFornecedor;
	private String numeroContrato;
	private String gerenteContrato;
	private List<Contato> contatos;
	private List<Endereco> enderecos;
	private boolean status;
	
	public String getAll() {
		return idFornecedor + "\n" + numeroContrato + "\n" + gerenteContrato + "\n" + contatos + "\n" + enderecos + "\n" + status;
		
	}
	
	public void setAll (int id, String nc, String gc, List<Contato> c, List<Endereco> e, boolean s ) {
		idFornecedor = id;
		numeroContrato = nc;
		gerenteContrato = gc;
		contatos = c;
		enderecos = e;
		status = s;
	
	}
	
	

	public Fornecedor() {
		super();
	}

	public Fornecedor(int id_fornecedor, String numeroContrato, String gerenteContrato, List<Contato> contato,
			List<Endereco> endereco, boolean status) {
		super();
		this.idFornecedor = id_fornecedor;
		this.numeroContrato = numeroContrato;
		this.gerenteContrato = gerenteContrato;
		this.contatos = contatos;
		this.enderecos = enderecos;
		this.status = status;
	}

	public int getIdFornecedor() {
		return idFornecedor;
	}

	public void setId_fornecedor(int id_fornecedor) {
		this.idFornecedor = id_fornecedor;
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

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
	
	