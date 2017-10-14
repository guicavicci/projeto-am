package beans;

public class Fatura
{
	private int id_fatura;
	private String numeroFatura;
    private String consumoKwh;
    private double valor;
    private int fkcliente;
	
    public String getAll() {
    	
    	return id_fatura + "\n" + numeroFatura + "\n" + consumoKwh + "\n" + valor + "\n" + fkcliente;
    	
    }
    
    public void setAll(int id, String nf, String c, double v, int fk) {
    	id_fatura = id;
    	numeroFatura = nf;
    	consumoKwh = c;
    	valor = v;
    	fkcliente =fk;
    }
    
    

	public Fatura() {
		super();
	}

	public Fatura(int id_fatura, String numeroFatura, String consumoKwh, double valor, int fkcliente) {
		super();
		this.id_fatura = id_fatura;
		this.numeroFatura = numeroFatura;
		this.consumoKwh = consumoKwh;
		this.valor = valor;
		this.fkcliente = fkcliente;
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

	public int getFkcliente() {
		return fkcliente;
	}

	public void setFkcliente(int fkcliente) {
		this.fkcliente = fkcliente;
	}
    
   
    
}


