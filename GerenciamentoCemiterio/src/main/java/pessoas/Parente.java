package pessoas;

public class Parente {

	private Integer idParente, telefoneParente, cpfParente, rgParente;
	private String nomeParente, emailParente, senhaParente;

	public Parente(Integer idParente, Integer telefoneParente, Integer cpfParente, Integer rgParente,
			String nomeParente, String emailParente, String senhaParente) {
		super();
		this.idParente = idParente;
		this.telefoneParente = telefoneParente;
		this.cpfParente = cpfParente;
		this.rgParente = rgParente;
		this.nomeParente = nomeParente;
		this.emailParente = emailParente;
		this.senhaParente = senhaParente;
	}

	public Integer getIdParente() {
		return idParente;
	}

	public void setIdParente(Integer idParente) {
		this.idParente = idParente;
	}

	public Integer getTelefoneParente() {
		return telefoneParente;
	}

	public void setTelefoneParente(Integer telefoneParente) {
		this.telefoneParente = telefoneParente;
	}

	public Integer getCpfParente() {
		return cpfParente;
	}

	public void setCpfParente(Integer cpfParente) {
		this.cpfParente = cpfParente;
	}

	public Integer getRgParente() {
		return rgParente;
	}

	public void setRgParente(Integer rgParente) {
		this.rgParente = rgParente;
	}

	public String getNomeParente() {
		return nomeParente;
	}

	public void setNomeParente(String nomeParente) {
		this.nomeParente = nomeParente;
	}

	public String getEmailParente() {
		return emailParente;
	}

	public void setEmailParente(String emailParente) {
		this.emailParente = emailParente;
	}

	public String getSenhaParente() {
		return senhaParente;
	}

	public void setSenhaParente(String senhaParente) {
		this.senhaParente = senhaParente;
	}

}