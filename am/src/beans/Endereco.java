package beans;

public class Endereco {
    private int idEndereco;
    private String rua;
    private int numero;
    private String cidade;

    public String getAll() {
        return  idEndereco + "\n" + rua + "\n" + numero + "\n" + cidade; 
    }
    
    public void setAll(int id, String r, int n, String cid){
        idEndereco = id;
        rua = r;
        numero = n;
        cidade = cid;
    }
    
    

	public Endereco() {
		super();
	}

	public Endereco(int id_endereco, String rua, int numero, String cidade) {
		super();
		this.idEndereco = id_endereco;
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int id_endereco) {
		this.idEndereco = id_endereco;
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


