package gerenciamento;

public class Tumulo {

	private Integer idTumulo, numeroTumulo, ocupadoDesdeTumulo;
	private Boolean permaneteTumulo, quadraTumulo, ruaTumulo, ocupadoTumulo;

	public Tumulo(Integer idTumulo, Integer numeroTumulo, Integer ocupadoDesdeTumulo, Boolean permaneteTumulo,
			Boolean quadraTumulo, Boolean ruaTumulo, Boolean ocupadoTumulo) {
		super();
		this.idTumulo = idTumulo;
		this.numeroTumulo = numeroTumulo;
		this.ocupadoDesdeTumulo = ocupadoDesdeTumulo;
		this.permaneteTumulo = permaneteTumulo;
		this.quadraTumulo = quadraTumulo;
		this.ruaTumulo = ruaTumulo;
		this.ocupadoTumulo = ocupadoTumulo;
	}

	public Integer getIdTumulo() {
		return idTumulo;
	}

	public void setIdTumulo(Integer idTumulo) {
		this.idTumulo = idTumulo;
	}

	public Integer getNumeroTumulo() {
		return numeroTumulo;
	}

	public void setNumeroTumulo(Integer numeroTumulo) {
		this.numeroTumulo = numeroTumulo;
	}

	public Integer getOcupadoDesdeTumulo() {
		return ocupadoDesdeTumulo;
	}

	public void setOcupadoDesdeTumulo(Integer ocupadoDesdeTumulo) {
		this.ocupadoDesdeTumulo = ocupadoDesdeTumulo;
	}

	public Boolean getPermaneteTumulo() {
		return permaneteTumulo;
	}

	public void setPermaneteTumulo(Boolean permaneteTumulo) {
		this.permaneteTumulo = permaneteTumulo;
	}

	public Boolean getQuadraTumulo() {
		return quadraTumulo;
	}

	public void setQuadraTumulo(Boolean quadraTumulo) {
		this.quadraTumulo = quadraTumulo;
	}

	public Boolean getRuaTumulo() {
		return ruaTumulo;
	}

	public void setRuaTumulo(Boolean ruaTumulo) {
		this.ruaTumulo = ruaTumulo;
	}

	public Boolean getOcupadoTumulo() {
		return ocupadoTumulo;
	}

	public void setOcupadoTumulo(Boolean ocupadoTumulo) {
		this.ocupadoTumulo = ocupadoTumulo;
	}
}