package beans;

public class Endereco {
    private int id_endereco;
    private String rua;
    private int numero;
    private String cidade;

    public String getAll() {
        return  id_endereco + "\n" + rua + "\n" + numero + "\n" + cidade; 
    }
    
    public void setAll(int id, String r, int n, String cid){
        id_endereco = id;
        rua = r;
        numero = n;
        cidade = cid;
    }
    
    

	public Endereco() {
		super();
	}

	public Endereco(int id_endereco, String rua, int numero, String cidade) {
		super();
		this.id_endereco = id_endereco;
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
	}

	public int getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
    
    
}


