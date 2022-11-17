package classePessoa;

public class Pessoa {

	protected Integer telefonePessoa, cpfPessoa, rgPessoa;
	protected String nomePessoa, emailPessoa, senhaPessoa;

	public Pessoa(Integer telefonePessoa, Integer cpfPessoa, Integer rgPessoa, String nomePessoa, String emailPessoa,
			String senhaPessoa) {
		super();
		this.telefonePessoa = telefonePessoa;
		this.cpfPessoa = cpfPessoa;
		this.rgPessoa = rgPessoa;
		this.nomePessoa = nomePessoa;
		this.emailPessoa = emailPessoa;
		this.senhaPessoa = senhaPessoa;
	}

	public Integer getTelefonePessoa() {
		return telefonePessoa;
	}

	public void setTelefonePessoa(Integer telefonePessoa) {
		this.telefonePessoa = telefonePessoa;
	}

	public Integer getCpfPessoa() {
		return cpfPessoa;
	}

	public void setCpfPessoa(Integer cpfPessoa) {
		this.cpfPessoa = cpfPessoa;
	}

	public Integer getRgPessoa() {
		return rgPessoa;
	}

	public void setRgPessoa(Integer rgPessoa) {
		this.rgPessoa = rgPessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getEmailPessoa() {
		return emailPessoa;
	}

	public void setEmailPessoa(String emailPessoa) {
		this.emailPessoa = emailPessoa;
	}

	public String getSenhaPessoa() {
		return senhaPessoa;
	}

	public void setSenhaPessoa(String senhaPessoa) {
		this.senhaPessoa = senhaPessoa;
	}

}