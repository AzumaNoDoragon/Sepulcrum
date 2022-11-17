package gerenciamento;

public class Cemiterio {

	private Integer idCemiterio, numeroCemiterio, telefoneCemiterio, cepCemiterio;
	private String nomeCemiterio, quadraCemiterio, ruaCemiterio, estadoCemiterio, cidadeCemiterio;

	public Cemiterio(Integer idCemiterio, Integer numeroCemiterio, Integer telefoneCemiterio, Integer cepCemiterio,
			String nomeCemiterio, String quadraCemiterio, String ruaCemiterio, String estadoCemiterio,
			String cidadeCemiterio) {
		super();
		this.idCemiterio = idCemiterio;
		this.numeroCemiterio = numeroCemiterio;
		this.telefoneCemiterio = telefoneCemiterio;
		this.cepCemiterio = cepCemiterio;
		this.nomeCemiterio = nomeCemiterio;
		this.quadraCemiterio = quadraCemiterio;
		this.ruaCemiterio = ruaCemiterio;
		this.estadoCemiterio = estadoCemiterio;
		this.cidadeCemiterio = cidadeCemiterio;
	}

	public Integer getIdCemiterio() {
		return idCemiterio;
	}

	public void setIdCemiterio(Integer idCemiterio) {
		this.idCemiterio = idCemiterio;
	}

	public Integer getNumeroCemiterio() {
		return numeroCemiterio;
	}

	public void setNumeroCemiterio(Integer numeroCemiterio) {
		this.numeroCemiterio = numeroCemiterio;
	}

	public Integer getTelefoneCemiterio() {
		return telefoneCemiterio;
	}

	public void setTelefoneCemiterio(Integer telefoneCemiterio) {
		this.telefoneCemiterio = telefoneCemiterio;
	}

	public Integer getCepCemiterio() {
		return cepCemiterio;
	}

	public void setCepCemiterio(Integer cepCemiterio) {
		this.cepCemiterio = cepCemiterio;
	}

	public String getNomeCemiterio() {
		return nomeCemiterio;
	}

	public void setNomeCemiterio(String nomeCemiterio) {
		this.nomeCemiterio = nomeCemiterio;
	}

	public String getQuadraCemiterio() {
		return quadraCemiterio;
	}

	public void setQuadraCemiterio(String quadraCemiterio) {
		this.quadraCemiterio = quadraCemiterio;
	}

	public String getRuaCemiterio() {
		return ruaCemiterio;
	}

	public void setRuaCemiterio(String ruaCemiterio) {
		this.ruaCemiterio = ruaCemiterio;
	}

	public String getEstadoCemiterio() {
		return estadoCemiterio;
	}

	public void setEstadoCemiterio(String estadoCemiterio) {
		this.estadoCemiterio = estadoCemiterio;
	}

	public String getCidadeCemiterio() {
		return cidadeCemiterio;
	}

	public void setCidadeCemiterio(String cidadeCemiterio) {
		this.cidadeCemiterio = cidadeCemiterio;
	}
}