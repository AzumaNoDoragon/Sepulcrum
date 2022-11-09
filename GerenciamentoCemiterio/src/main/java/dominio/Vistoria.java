package dominio;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vistoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVistoria, idCemiterio, idAdm;
	private String informacaoVistoria;
	private Calendar dataVistoria;
	private Boolean realizadoVistoria;

	public Vistoria(Integer idVistoria, Integer idCemiterio, Integer idAdm, String informacaoVistoria,
			Calendar dataVistoria, Boolean realizadoVistoria) {
		super();
		this.idVistoria = idVistoria;
		this.idCemiterio = idCemiterio;
		this.idAdm = idAdm;
		this.informacaoVistoria = informacaoVistoria;
		this.dataVistoria = dataVistoria;
		this.realizadoVistoria = realizadoVistoria;
	}

	public Integer getIdVistoria() {
		return idVistoria;
	}

	public void setIdVistoria(Integer idVistoria) {
		this.idVistoria = idVistoria;
	}

	public Integer getIdCemiterio() {
		return idCemiterio;
	}

	public void setIdCemiterio(Integer idCemiterio) {
		this.idCemiterio = idCemiterio;
	}

	public Integer getIdAdm() {
		return idAdm;
	}

	public void setIdAdm(Integer idAdm) {
		this.idAdm = idAdm;
	}

	public String getInformacaoVistoria() {
		return informacaoVistoria;
	}

	public void setInformacaoVistoria(String informacaoVistoria) {
		this.informacaoVistoria = informacaoVistoria;
	}

	public Calendar getDataVistoria() {
		return dataVistoria;
	}

	public void setDataVistoria(Calendar dataVistoria) {
		this.dataVistoria = dataVistoria;
	}

	public Boolean getRealizadoVistoria() {
		return realizadoVistoria;
	}

	public void setRealizadoVistoria(Boolean realizadoVistoria) {
		this.realizadoVistoria = realizadoVistoria;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Vistoria [idVistoria=" + idVistoria + ", idCemiterio=" + idCemiterio + ", idAdm=" + idAdm
				+ ", informacaoVistoria=" + informacaoVistoria + ", dataVistoria=" + dataVistoria
				+ ", realizadoVistoria=" + realizadoVistoria + "]";
	}
}