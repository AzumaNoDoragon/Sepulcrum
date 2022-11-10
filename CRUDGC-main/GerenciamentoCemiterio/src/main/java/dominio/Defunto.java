package dominio;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Defunto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDefunto, idTumulo, idParente, certidaoObitoDefunto, rgDefunto, cpfDefunto;
	private Boolean pessoaPublicaDefunto;
	private String nomeDefunto, causaMorteDefunto;
	private Calendar dataNascimentoDefunto, dataObitoDefunto;

	public Defunto(Integer idDefunto, Integer idTumulo, Integer idParente, Integer certidaoObitoDefunto,
			Integer rgDefunto, Integer cpfDefunto, Boolean pessoaPublicaDefunto, String nomeDefunto,
			String causaMorteDefunto, Calendar dataNascimentoDefunto, Calendar dataObitoDefunto) {
		super();
		this.idDefunto = idDefunto;
		this.idTumulo = idTumulo;
		this.idParente = idParente;
		this.certidaoObitoDefunto = certidaoObitoDefunto;
		this.rgDefunto = rgDefunto;
		this.cpfDefunto = cpfDefunto;
		this.pessoaPublicaDefunto = pessoaPublicaDefunto;
		this.nomeDefunto = nomeDefunto;
		this.causaMorteDefunto = causaMorteDefunto;
		this.dataNascimentoDefunto = dataNascimentoDefunto;
		this.dataObitoDefunto = dataObitoDefunto;
	}

	public Integer getIdDefunto() {
		return idDefunto;
	}

	public void setIdDefunto(Integer idDefunto) {
		this.idDefunto = idDefunto;
	}

	public Integer getIdTumulo() {
		return idTumulo;
	}

	public void setIdTumulo(Integer idTumulo) {
		this.idTumulo = idTumulo;
	}

	public Integer getIdParente() {
		return idParente;
	}

	public void setIdParente(Integer idParente) {
		this.idParente = idParente;
	}

	public Integer getCertidaoObitoDefunto() {
		return certidaoObitoDefunto;
	}

	public void setCertidaoObitoDefunto(Integer certidaoObitoDefunto) {
		this.certidaoObitoDefunto = certidaoObitoDefunto;
	}

	public Integer getRgDefunto() {
		return rgDefunto;
	}

	public void setRgDefunto(Integer rgDefunto) {
		this.rgDefunto = rgDefunto;
	}

	public Integer getCpfDefunto() {
		return cpfDefunto;
	}

	public void setCpfDefunto(Integer cpfDefunto) {
		this.cpfDefunto = cpfDefunto;
	}

	public Boolean getPessoaPublicaDefunto() {
		return pessoaPublicaDefunto;
	}

	public void setPessoaPublicaDefunto(Boolean pessoaPublicaDefunto) {
		this.pessoaPublicaDefunto = pessoaPublicaDefunto;
	}

	public String getNomeDefunto() {
		return nomeDefunto;
	}

	public void setNomeDefunto(String nomeDefunto) {
		this.nomeDefunto = nomeDefunto;
	}

	public String getCausaMorteDefunto() {
		return causaMorteDefunto;
	}

	public void setCausaMorteDefunto(String causaMorteDefunto) {
		this.causaMorteDefunto = causaMorteDefunto;
	}

	public Calendar getDataNascimentoDefunto() {
		return dataNascimentoDefunto;
	}

	public void setDataNascimentoDefunto(Calendar dataNascimentoDefunto) {
		this.dataNascimentoDefunto = dataNascimentoDefunto;
	}

	public Calendar getDataObitoDefunto() {
		return dataObitoDefunto;
	}

	public void setDataObitoDefunto(Calendar dataObitoDefunto) {
		this.dataObitoDefunto = dataObitoDefunto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Defunto [idDefunto=" + idDefunto + ", idTumulo=" + idTumulo + ", idParente=" + idParente
				+ ", certidaoObitoDefunto=" + certidaoObitoDefunto + ", rgDefunto=" + rgDefunto + ", cpfDefunto="
				+ cpfDefunto + ", pessoaPublicaDefunto=" + pessoaPublicaDefunto + ", nomeDefunto=" + nomeDefunto
				+ ", causaMorteDefunto=" + causaMorteDefunto + ", dataNascimentoDefunto=" + dataNascimentoDefunto
				+ ", dataObitoDefunto=" + dataObitoDefunto + "]";
	}
}
