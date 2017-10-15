package beans;

public class Fatura
{
	private int id_fatura;
	private String numeroFatura;
    private String consumoKwh;
    private double valor;
	
    public String getAll() {
    	
    	return id_fatura + "\n" + numeroFatura + "\n" + consumoKwh + "\n" + valor;
    	
    }
    
    public void setAll(int id, String nf, String c, double v) {
    	id_fatura = id;
    	numeroFatura = nf;
    	consumoKwh = c;
    	valor = v;
    }
    
    

	public Fatura() {
		super();
	}

	public Fatura(int id_fatura, String numeroFatura, String consumoKwh, double valor) {
		super();
		this.id_fatura = id_fatura;
		this.numeroFatura = numeroFatura;
		this.consumoKwh = consumoKwh;
		this.valor = valor;
	}

	public int getId_fatura() {
		return id_fatura;
	}

	public void setId_fatura(int id_fatura) {
		this.id_fatura = id_fatura;
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


