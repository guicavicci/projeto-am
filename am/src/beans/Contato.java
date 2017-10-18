package beans;

public class Contato {
	
	private int idContato;
	private String telefone;
	private String email;
	private String facebook;
	
	
	public String getAll (){
		
		return idContato + "\n" + telefone + "\n" + email + "\n" + facebook;
		
	} 
	
	public void setAll (int id, String t, String e, String f) {
		idContato = id;
		telefone = t;
		email = e;
		facebook = f;
		
	}
	
	public Contato() {
		super();
	}
	public Contato(int id_contato, String telefone, String email, String facebook) {
		super();
		this.idContato = id_contato;
		this.telefone = telefone;
		this.email = email;
		this.facebook = facebook;
	}
	public int getIdContato() {
		return idContato;
	}
	public void setIdContato(int id_contato) {
		this.idContato = id_contato;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	
	
}
