package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cemiterio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCemiterio, numeroCemiterio, telefoneCemiterio, cepCemiterio;
	private String nomeCemiterio, estadoCemiterio, cidadeCemiterio, bairroCemiterio, ruaCemiterio;

	public Cemiterio(Integer idCemiterio, Integer numeroCemiterio, Integer telefoneCemiterio, Integer cepCemiterio,
			String nomeCemiterio, String estadoCemiterio, String cidadeCemiterio, String bairroCemiterio,
			String ruaCemiterio) {
		super();
		this.idCemiterio = idCemiterio;
		this.numeroCemiterio = numeroCemiterio;
		this.telefoneCemiterio = telefoneCemiterio;
		this.cepCemiterio = cepCemiterio;
		this.nomeCemiterio = nomeCemiterio;
		this.estadoCemiterio = estadoCemiterio;
		this.cidadeCemiterio = cidadeCemiterio;
		this.bairroCemiterio = bairroCemiterio;
		this.ruaCemiterio = ruaCemiterio;
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

	public String getBairroCemiterio() {
		return bairroCemiterio;
	}

	public void setBairroCemiterio(String bairroCemiterio) {
		this.bairroCemiterio = bairroCemiterio;
	}

	public String getRuaCemiterio() {
		return ruaCemiterio;
	}

	public void setRuaCemiterio(String ruaCemiterio) {
		this.ruaCemiterio = ruaCemiterio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Cemiterio [idCemiterio=" + idCemiterio + ", numeroCemiterio=" + numeroCemiterio + ", telefoneCemiterio="
				+ telefoneCemiterio + ", cepCemiterio=" + cepCemiterio + ", nomeCemiterio=" + nomeCemiterio
				+ ", estadoCemiterio=" + estadoCemiterio + ", cidadeCemiterio=" + cidadeCemiterio + ", bairroCemiterio="
				+ bairroCemiterio + ", ruaCemiterio=" + ruaCemiterio + "]";
	}
}