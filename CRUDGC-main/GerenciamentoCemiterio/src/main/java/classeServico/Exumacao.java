package classeServico;

public class Exumacao {

	private Integer idExumacao, dataExumacao;
	private String motivoExumacao, informacaoExumacao;

	public Exumacao(Integer idExumacao, Integer dataExumacao, String motivoExumacao, String informacaoExumacao) {
		super();
		this.idExumacao = idExumacao;
		this.dataExumacao = dataExumacao;
		this.motivoExumacao = motivoExumacao;
		this.informacaoExumacao = informacaoExumacao;
	}

	public Integer getIdExumacao() {
		return idExumacao;
	}

	public void setIdExumacao(Integer idExumacao) {
		this.idExumacao = idExumacao;
	}

	public Integer getDataExumacao() {
		return dataExumacao;
	}

	public void setDataExumacao(Integer dataExumacao) {
		this.dataExumacao = dataExumacao;
	}

	public String getMotivoExumacao() {
		return motivoExumacao;
	}

	public void setMotivoExumacao(String motivoExumacao) {
		this.motivoExumacao = motivoExumacao;
	}

	public String getInformacaoExumacao() {
		return informacaoExumacao;
	}

	public void setInformacaoExumacao(String informacaoExumacao) {
		this.informacaoExumacao = informacaoExumacao;
	}

}