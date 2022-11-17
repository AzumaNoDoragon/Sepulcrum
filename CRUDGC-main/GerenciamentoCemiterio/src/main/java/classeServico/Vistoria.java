package classeServico;

public class Vistoria {

	private Integer idVistoria, dataVistoria;
	private String informacaoVistoria;
	private Boolean realizadoVistoria;

	public Vistoria(Integer idVistoria, Integer dataVistoria, String informacaoVistoria, Boolean realizadoVistoria) {
		super();
		this.idVistoria = idVistoria;
		this.dataVistoria = dataVistoria;
		this.informacaoVistoria = informacaoVistoria;
		this.realizadoVistoria = realizadoVistoria;
	}

	public Integer getIdVistoria() {
		return idVistoria;
	}

	public void setIdVistoria(Integer idVistoria) {
		this.idVistoria = idVistoria;
	}

	public Integer getDataVistoria() {
		return dataVistoria;
	}

	public void setDataVistoria(Integer dataVistoria) {
		this.dataVistoria = dataVistoria;
	}

	public String getInformacaoVistoria() {
		return informacaoVistoria;
	}

	public void setInformacaoVistoria(String informacaoVistoria) {
		this.informacaoVistoria = informacaoVistoria;
	}

	public Boolean getRealizadoVistoria() {
		return realizadoVistoria;
	}

	public void setRealizadoVistoria(Boolean realizadoVistoria) {
		this.realizadoVistoria = realizadoVistoria;
	}

}