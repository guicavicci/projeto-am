package beans;

import java.util.List;

public class Cliente {
    private int id_cliente;
	private String numeroInstalacao;
    private String debitoPendente;
    private List<Fatura> fatura;
    
    public String getAll() {
        return id_cliente + "\n" + numeroInstalacao + "\n" + debitoPendente + "\n" + fatura;
        
    }
    
 
    public void setAll(int id, String ac, String ni, String dp, List<Fatura> f) {
        id_cliente=id;
        numeroInstalacao=ni;
        debitoPendente=dp;
        fatura=f;
        
    }
    
    public Cliente() {
		super();
	}


	public Cliente(int id_cliente, String numeroInstalacao, String debitoPendente, List<Fatura> fatura) {
		super();
		this.id_cliente = id_cliente;
		this.numeroInstalacao = numeroInstalacao;
		this.debitoPendente = debitoPendente;
		this.fatura = fatura;
	}


	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
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

	public List<Fatura> getFatura() {
		return fatura;
	}

	public void setFatura(List<Fatura> fatura) {
		this.fatura = fatura;
	}
    
    
	
    
}


