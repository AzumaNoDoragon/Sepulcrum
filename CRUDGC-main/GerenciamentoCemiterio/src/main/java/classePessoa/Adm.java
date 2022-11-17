package classePessoa;

public class Adm extends Pessoa {

	private Integer idAdm;

	public Adm(Integer telefonePessoa, Integer cpfPessoa, Integer rgPessoa, String nomePessoa, String emailPessoa,
			String senhaPessoa, Integer idAdm) {
		super(telefonePessoa, cpfPessoa, rgPessoa, nomePessoa, emailPessoa, senhaPessoa);
		this.idAdm = idAdm;
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

	public Integer getIdAdm() {
		return idAdm;
	}

	public void setIdAdm(Integer idAdm) {
		this.idAdm = idAdm;
	}

}