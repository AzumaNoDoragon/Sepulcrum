package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAdm, idCemiterio;
	private String nomeAdm, emailAdm, senhaAdm;

	public Adm(Integer idAdm, Integer idCemiterio, String nomeAdm, String emailAdm, String senhaAdm) {
		super();
		this.idAdm = idAdm;
		this.idCemiterio = idCemiterio;
		this.nomeAdm = nomeAdm;
		this.emailAdm = emailAdm;
		this.senhaAdm = senhaAdm;
	}

	public Integer getIdAdm() {
		return idAdm;
	}

	public void setIdAdm(Integer idAdm) {
		this.idAdm = idAdm;
	}

	public Integer getIdCemiterio() {
		return idCemiterio;
	}

	public void setIdCemiterio(Integer idCemiterio) {
		this.idCemiterio = idCemiterio;
	}

	public String getNomeAdm() {
		return nomeAdm;
	}

	public void setNomeAdm(String nomeAdm) {
		this.nomeAdm = nomeAdm;
	}

	public String getEmailAdm() {
		return emailAdm;
	}

	public void setEmailAdm(String emailAdm) {
		this.emailAdm = emailAdm;
	}

	public String getSenhaAdm() {
		return senhaAdm;
	}

	public void setSenhaAdm(String senhaAdm) {
		this.senhaAdm = senhaAdm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Adm [idAdm=" + idAdm + ", idCemiterio=" + idCemiterio + ", nomeAdm=" + nomeAdm + ", emailAdm="
				+ emailAdm + ", senhaAdm=" + senhaAdm + "]";
	}
}