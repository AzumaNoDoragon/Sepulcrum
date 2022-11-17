package gerenciamento;

public class Defunto {

	private Integer idDefunto, certidaoObitoDefunto, cpfDefunto, rgDefunto, dataNascimentoDefunto, dataObitoDefunto;
	private Boolean pessoaPublicaDefunto;
	private String causaMorteDefunto, nomeDefunto;

	public Defunto(Integer idDefunto, Integer certidaoObitoDefunto, Integer cpfDefunto, Integer rgDefunto,
			Integer dataNascimentoDefunto, Integer dataObitoDefunto, Boolean pessoaPublicaDefunto,
			String causaMorteDefunto, String nomeDefunto, String emailDefunto, String senhaDefunto) {
		super();
		this.idDefunto = idDefunto;
		this.certidaoObitoDefunto = certidaoObitoDefunto;
		this.cpfDefunto = cpfDefunto;
		this.rgDefunto = rgDefunto;
		this.dataNascimentoDefunto = dataNascimentoDefunto;
		this.dataObitoDefunto = dataObitoDefunto;
		this.pessoaPublicaDefunto = pessoaPublicaDefunto;
		this.causaMorteDefunto = causaMorteDefunto;
	}

	public Integer getIdDefunto() {
		return idDefunto;
	}

	public void setIdDefunto(Integer idDefunto) {
		this.idDefunto = idDefunto;
	}

	public Integer getCertidaoObitoDefunto() {
		return certidaoObitoDefunto;
	}

	public void setCertidaoObitoDefunto(Integer certidaoObitoDefunto) {
		this.certidaoObitoDefunto = certidaoObitoDefunto;
	}

	public Integer getCpfDefunto() {
		return cpfDefunto;
	}

	public void setCpfDefunto(Integer cpfDefunto) {
		this.cpfDefunto = cpfDefunto;
	}

	public Integer getRgDefunto() {
		return rgDefunto;
	}

	public void setRgDefunto(Integer rgDefunto) {
		this.rgDefunto = rgDefunto;
	}

	public Integer getDataNascimentoDefunto() {
		return dataNascimentoDefunto;
	}

	public void setDataNascimentoDefunto(Integer dataNascimentoDefunto) {
		this.dataNascimentoDefunto = dataNascimentoDefunto;
	}

	public Integer getDataObitoDefunto() {
		return dataObitoDefunto;
	}

	public void setDataObitoDefunto(Integer dataObitoDefunto) {
		this.dataObitoDefunto = dataObitoDefunto;
	}

	public Boolean getPessoaPublicaDefunto() {
		return pessoaPublicaDefunto;
	}

	public void setPessoaPublicaDefunto(Boolean pessoaPublicaDefunto) {
		this.pessoaPublicaDefunto = pessoaPublicaDefunto;
	}

	public String getCausaMorteDefunto() {
		return causaMorteDefunto;
	}

	public void setCausaMorteDefunto(String causaMorteDefunto) {
		this.causaMorteDefunto = causaMorteDefunto;
	}

	public String getNomeDefunto() {
		return nomeDefunto;
	}

	public void setNomeDefunto(String nomeDefunto) {
		this.nomeDefunto = nomeDefunto;
	}
}