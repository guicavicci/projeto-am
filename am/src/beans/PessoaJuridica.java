package beans;


public class PessoaJuridica{
		private int id_pj;
		private String numeroContrato;
		private String razaoSocial;
		private String cnpj;

		
		public String getAll() {
			return id_pj + "\n" + numeroContrato + "\n" + razaoSocial + "\n" + cnpj; 
			
			
		}
		
		public void setAll (int i, String n, String em, String t, String nc, String rs, String c) {
			id_pj = i;
			numeroContrato =nc;
			razaoSocial=rs;
			cnpj=c;
			
			
		}
		

		public PessoaJuridica() {
			super();
		}

		public PessoaJuridica(int id_pj, String numeroContrato, String razaoSocial, String cnpj) {
			super();
			this.id_pj = id_pj;
			this.numeroContrato = numeroContrato;
			this.razaoSocial = razaoSocial;
			this.cnpj = cnpj;
		}

		public int getId_pj() {
			return id_pj;
		}

		public void setId_pj(int id_pj) {
			this.id_pj = id_pj;
		}

		public String getNumeroContrato() {
			return numeroContrato;
		}

		public void setNumeroContrato(String numeroContrato) {
			this.numeroContrato = numeroContrato;
		}

		public String getRazaoSocial() {
			return razaoSocial;
		}

		public void setRazaoSocial(String razaoSocial) {
			this.razaoSocial = razaoSocial;
		}

		public String getCnpj() {
			return cnpj;
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}
		

}
