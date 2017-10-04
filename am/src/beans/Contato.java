package beans;

public class Contato {
	
	private int id_contato;
	private String telefone;
	private String email;
	private String facebook;
	
	
	public String getAll (){
		
		return id_contato + "\n" + telefone + "\n" + email + "\n" + facebook;
		
	} 
	
	public void setAll (int id, String t, String e, String f) {
		id_contato = id;
		telefone = t;
		email = e;
		facebook = f;
		
	}
	
	public Contato() {
		super();
	}
	public Contato(int id_contato, String telefone, String email, String facebook) {
		super();
		this.id_contato = id_contato;
		this.telefone = telefone;
		this.email = email;
		this.facebook = facebook;
	}
	public int getId_contato() {
		return id_contato;
	}
	public void setId_contato(int id_contato) {
		this.id_contato = id_contato;
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
