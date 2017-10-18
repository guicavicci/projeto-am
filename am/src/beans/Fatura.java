package beans;

public class Fatura
{
	private int idFatura;
	private String numeroFatura;
    private String consumoKwh;
    private double valor;
	
    public String getAll() {
    	
    	return idFatura + "\n" + numeroFatura + "\n" + consumoKwh + "\n" + valor;
    	
    }
    
    public void setAll(int id, String nf, String c, double v) {
    	idFatura = id;
    	numeroFatura = nf;
    	consumoKwh = c;
    	valor = v;
    }
    
    

	public Fatura() {
		super();
	}

	public Fatura(int id_fatura, String numeroFatura, String consumoKwh, double valor) {
		super();
		this.idFatura = id_fatura;
		this.numeroFatura = numeroFatura;
		this.consumoKwh = consumoKwh;
		this.valor = valor;
	}

	public int getIdFatura() {
		return idFatura;
	}

	public void setIdFatura(int id_fatura) {
		this.idFatura = id_fatura;
	}

	public String getNumeroFatura() {
		return numeroFatura;
	}

	public void setNumeroFatura(String numeroFatura) {
		this.numeroFatura = numeroFatura;
	}

	public String getConsumoKwh() {
		return consumoKwh;
	}

	public void setConsumoKwh(String consumoKwh) {
		this.consumoKwh = consumoKwh;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
   
    
}


