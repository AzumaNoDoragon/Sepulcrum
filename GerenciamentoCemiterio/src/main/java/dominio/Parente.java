package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idParente, idDefunto, cpfParente, rgParente;
	private String nomeParente, emailParente, senhaParente;

	public Parente(Integer idParente, Integer idDefunto, Integer cpfParente, Integer rgParente, String nomeParente,
			String emailParente, String senhaParente) {
		super();
		this.idParente = idParente;
		this.idDefunto = idDefunto;
		this.cpfParente = cpfParente;
		this.rgParente = rgParente;
		this.nomeParente = nomeParente;
		this.emailParente = emailParente;
		this.senhaParente = senhaParente;
	}

	public Integer getIdParente() {
		return idParente;
	}

	public void setIdParente(Integer idParente) {
		this.idParente = idParente;
	}

	public Integer getIdDefunto() {
		return idDefunto;
	}

	public void setIdDefunto(Integer idDefunto) {
		this.idDefunto = idDefunto;
	}

	public Integer getCpfParente() {
		return cpfParente;
	}

	public void setCpfParente(Integer cpfParente) {
		this.cpfParente = cpfParente;
	}

	public Integer getRgParente() {
		return rgParente;
	}

	public void setRgParente(Integer rgParente) {
		this.rgParente = rgParente;
	}

	public String getNomeParente() {
		return nomeParente;
	}

	public void setNomeParente(String nomeParente) {
		this.nomeParente = nomeParente;
	}

	public String getEmailParente() {
		return emailParente;
	}

	public void setEmailParente(String emailParente) {
		this.emailParente = emailParente;
	}

	public String getSenhaParente() {
		return senhaParente;
	}

	public void setSenhaParente(String senhaParente) {
		this.senhaParente = senhaParente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Parente [idParente=" + idParente + ", idDefunto=" + idDefunto + ", cpfParente=" + cpfParente
				+ ", rgParente=" + rgParente + ", nomeParente=" + nomeParente + ", emailParente=" + emailParente
				+ ", senhaParente=" + senhaParente + "]";
	}
}