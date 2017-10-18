package beans;

import java.util.List;

public class Cliente {
    private int idCliente;
	private String numeroInstalacao;
    private String debitoPendente;
    private boolean status;
    private List<Fatura> fatura;
    
    public String getAll() {
        return idCliente + "\n" + numeroInstalacao + "\n" + debitoPendente + "\n" + "\n" + status + "\n" + fatura;
        
    }
    
 
    public void setAll(int id, String ac, String ni, String dp, boolean s, List<Fatura> f) {
        idCliente=id;
        numeroInstalacao=ni;
        debitoPendente=dp;
        status=s;
        fatura=f;
        
    }
    
    
	public Cliente() {
		super();
	}


	public Cliente(int id_cliente, String numeroInstalacao, String debitoPendente, boolean status,
			List<Fatura> fatura) {
		super();
		this.idCliente = id_cliente;
		this.numeroInstalacao = numeroInstalacao;
		this.debitoPendente = debitoPendente;
		this.status = status;
		this.fatura = fatura;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int id_cliente) {
		this.idCliente = id_cliente;
	}


	public String getNumeroInstalacao() {
		return numeroInstalacao;
	}


	public void setNumeroInstalacao(String numeroInstalacao) {
		this.numeroInstalacao = numeroInstalacao;
	}


	public String getDebitoPendente() {
		return debitoPendente;
	}


	public void setDebitoPendente(String debitoPendente) {
		this.debitoPendente = debitoPendente;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public List<Fatura> getFatura() {
		return fatura;
	}


	public void setFatura(List<Fatura> fatura) {
		this.fatura = fatura;
	}
    
  
    
}


