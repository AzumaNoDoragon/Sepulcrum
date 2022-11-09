package dominio;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exumacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idExumacao, idAdm, idTumulo, idDefunto;
	private String motivoExumacao, informacaoExumacao;
	private Calendar dataExumacao;

	public Exumacao(Integer idExumacao, Integer idAdm, Integer idTumulo, Integer idDefunto, String motivoExumacao,
			String informacaoExumacao, Calendar dataExumacao) {
		super();
		this.idExumacao = idExumacao;
		this.idAdm = idAdm;
		this.idTumulo = idTumulo;
		this.idDefunto = idDefunto;
		this.motivoExumacao = motivoExumacao;
		this.informacaoExumacao = informacaoExumacao;
		this.dataExumacao = dataExumacao;
	}

	public Integer getIdExumacao() {
		return idExumacao;
	}

	public void setIdExumacao(Integer idExumacao) {
		this.idExumacao = idExumacao;
	}

	public Integer getIdAdm() {
		return idAdm;
	}

	public void setIdAdm(Integer idAdm) {
		this.idAdm = idAdm;
	}

	public Integer getIdTumulo() {
		return idTumulo;
	}

	public void setIdTumulo(Integer idTumulo) {
		this.idTumulo = idTumulo;
	}

	public Integer getIdDefunto() {
		return idDefunto;
	}

	public void setIdDefunto(Integer idDefunto) {
		this.idDefunto = idDefunto;
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

	public Calendar getDataExumacao() {
		return dataExumacao;
	}

	public void setDataExumacao(Calendar dataExumacao) {
		this.dataExumacao = dataExumacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Exumacao [idExumacao=" + idExumacao + ", idAdm=" + idAdm + ", idTumulo=" + idTumulo + ", idDefunto="
				+ idDefunto + ", motivoExumacao=" + motivoExumacao + ", informacaoExumacao=" + informacaoExumacao
				+ ", dataExumacao=" + dataExumacao + "]";
	}
}