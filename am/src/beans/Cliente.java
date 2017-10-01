package beans;

public class Cliente {
    private int id_cliente;
	private String numeroInstalacao;
    private String debitoPendente;
    
    public String getAll() {
        return id_cliente + "\n" + numeroInstalacao + "\n" + debitoPendente;
        
    }
    
    public void setAll(int id, String ac, String ni, String dp) {
        id_cliente=id;
        numeroInstalacao=ni;
        debitoPendente=dp;
        
    }
    
    

	public Cliente() {
		super();
	}

	public Cliente(int id_cliente, String numeroInstalacao, String debitoPendente) {
		super();
		this.id_cliente = id_cliente;
		this.numeroInstalacao = numeroInstalacao;
		this.debitoPendente = debitoPendente;
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
    
    
    
    
}


