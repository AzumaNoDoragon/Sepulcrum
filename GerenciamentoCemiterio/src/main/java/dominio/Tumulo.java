package dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tumulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTumulo, idCemiterio, idDefunto;
	private String quadraTumulo, ruaTumulo, numeroTumulo, ocupadoDesdeTumulo;
	private Boolean permaneteTumulo, ocupadoTumulo;

	public Tumulo(Integer idTumulo, Integer idCemiterio, Integer idDefunto, String quadraTumulo, String ruaTumulo,
			String numeroTumulo, String ocupadoDesdeTumulo, Boolean permaneteTumulo, Boolean ocupadoTumulo) {
		super();
		this.idTumulo = idTumulo;
		this.idCemiterio = idCemiterio;
		this.idDefunto = idDefunto;
		this.quadraTumulo = quadraTumulo;
		this.ruaTumulo = ruaTumulo;
		this.numeroTumulo = numeroTumulo;
		this.ocupadoDesdeTumulo = ocupadoDesdeTumulo;
		this.permaneteTumulo = permaneteTumulo;
		this.ocupadoTumulo = ocupadoTumulo;
	}

	public Integer getIdTumulo() {
		return idTumulo;
	}

	public void setIdTumulo(Integer idTumulo) {
		this.idTumulo = idTumulo;
	}

	public Integer getIdCemiterio() {
		return idCemiterio;
	}

	public void setIdCemiterio(Integer idCemiterio) {
		this.idCemiterio = idCemiterio;
	}

	public Integer getIdDefunto() {
		return idDefunto;
	}

	public void setIdDefunto(Integer idDefunto) {
		this.idDefunto = idDefunto;
	}

	public String getQuadraTumulo() {
		return quadraTumulo;
	}

	public void setQuadraTumulo(String quadraTumulo) {
		this.quadraTumulo = quadraTumulo;
	}

	public String getRuaTumulo() {
		return ruaTumulo;
	}

	public void setRuaTumulo(String ruaTumulo) {
		this.ruaTumulo = ruaTumulo;
	}

	public String getNumeroTumulo() {
		return numeroTumulo;
	}

	public void setNumeroTumulo(String numeroTumulo) {
		this.numeroTumulo = numeroTumulo;
	}

	public String getOcupadoDesdeTumulo() {
		return ocupadoDesdeTumulo;
	}

	public void setOcupadoDesdeTumulo(String ocupadoDesdeTumulo) {
		this.ocupadoDesdeTumulo = ocupadoDesdeTumulo;
	}

	public Boolean getPermaneteTumulo() {
		return permaneteTumulo;
	}

	public void setPermaneteTumulo(Boolean permaneteTumulo) {
		this.permaneteTumulo = permaneteTumulo;
	}

	public Boolean getOcupadoTumulo() {
		return ocupadoTumulo;
	}

	public void setOcupadoTumulo(Boolean ocupadoTumulo) {
		this.ocupadoTumulo = ocupadoTumulo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Tumulo [idTumulo=" + idTumulo + ", idCemiterio=" + idCemiterio + ", idDefunto=" + idDefunto
				+ ", quadraTumulo=" + quadraTumulo + ", ruaTumulo=" + ruaTumulo + ", numeroTumulo=" + numeroTumulo
				+ ", ocupadoDesdeTumulo=" + ocupadoDesdeTumulo + ", permaneteTumulo=" + permaneteTumulo
				+ ", ocupadoTumulo=" + ocupadoTumulo + "]";
	}
}
