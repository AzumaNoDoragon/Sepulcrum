package classePessoa;

public class Parente extends Pessoa {

	private Integer idParente;

	public Parente(Integer telefonePessoa, Integer cpfPessoa, Integer rgPessoa, String nomePessoa, String emailPessoa,
			String senhaPessoa, Integer idParente) {
		super(telefonePessoa, cpfPessoa, rgPessoa, nomePessoa, emailPessoa, senhaPessoa);
		this.idParente = idParente;
	}

	@Override
	public Integer getTelefonePessoa() {
		// TODO Auto-generated method stub
		return super.getTelefonePessoa();
	}

	@Override
	public void setTelefonePessoa(Integer telefonePessoa) {
		// TODO Auto-generated method stub
		super.setTelefonePessoa(telefonePessoa);
	}

	@Override
	public Integer getCpfPessoa() {
		// TODO Auto-generated method stub
		return super.getCpfPessoa();
	}

	@Override
	public void setCpfPessoa(Integer cpfPessoa) {
		// TODO Auto-generated method stub
		super.setCpfPessoa(cpfPessoa);
	}

	@Override
	public Integer getRgPessoa() {
		// TODO Auto-generated method stub
		return super.getRgPessoa();
	}

	@Override
	public void setRgPessoa(Integer rgPessoa) {
		// TODO Auto-generated method stub
		super.setRgPessoa(rgPessoa);
	}

	@Override
	public String getNomePessoa() {
		// TODO Auto-generated method stub
		return super.getNomePessoa();
	}

	@Override
	public void setNomePessoa(String nomePessoa) {
		// TODO Auto-generated method stub
		super.setNomePessoa(nomePessoa);
	}

	@Override
	public String getEmailPessoa() {
		// TODO Auto-generated method stub
		return super.getEmailPessoa();
	}

	@Override
	public void setEmailPessoa(String emailPessoa) {
		// TODO Auto-generated method stub
		super.setEmailPessoa(emailPessoa);
	}

	@Override
	public String getSenhaPessoa() {
		// TODO Auto-generated method stub
		return super.getSenhaPessoa();
	}

	@Override
	public void setSenhaPessoa(String senhaPessoa) {
		// TODO Auto-generated method stub
		super.setSenhaPessoa(senhaPessoa);
	}

	public Integer getIdParente() {
		return idParente;
	}

	public void setIdParente(Integer idParente) {
		this.idParente = idParente;
	}

}