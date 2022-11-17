package pessoas;

public class Adm {

	private Integer idAdm, telefoneAdm, cpfAdm, rgAdm;
	private String nomeAdm, emailAdm, senhaAdm;

	public Adm(Integer idAdm, Integer telefoneAdm, Integer cpfAdm, Integer rgAdm, String nomeAdm, String emailAdm,
			String senhaAdm) {
		super();
		this.idAdm = idAdm;
		this.telefoneAdm = telefoneAdm;
		this.cpfAdm = cpfAdm;
		this.rgAdm = rgAdm;
		this.nomeAdm = nomeAdm;
		this.emailAdm = emailAdm;
		this.senhaAdm = senhaAdm;
	}

	public Integer getIdAdm() {
		return idAdm;
	}

	public void setIdAdm(Integer idAdm) {
		this.idAdm = idAdm;
	}

	public Integer getTelefoneAdm() {
		return telefoneAdm;
	}

	public void setTelefoneAdm(Integer telefoneAdm) {
		this.telefoneAdm = telefoneAdm;
	}

	public Integer getCpfAdm() {
		return cpfAdm;
	}

	public void setCpfAdm(Integer cpfAdm) {
		this.cpfAdm = cpfAdm;
	}

	public Integer getRgAdm() {
		return rgAdm;
	}

	public void setRgAdm(Integer rgAdm) {
		this.rgAdm = rgAdm;
	}

	public String getNomeAdm() {
		return nomeAdm;
	}

	public void setNomeAdm(String nomeAdm) {
		this.nomeAdm = nomeAdm;
	}

	public String getEmailAdm() {
		return emailAdm;
	}

	public void setEmailAdm(String emailAdm) {
		this.emailAdm = emailAdm;
	}

	public String getSenhaAdm() {
		return senhaAdm;
	}

	public void setSenhaAdm(String senhaAdm) {
		this.senhaAdm = senhaAdm;
	}
}
