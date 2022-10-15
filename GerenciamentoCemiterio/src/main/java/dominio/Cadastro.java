package dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cadastro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Boolean pessoaPublica;
	private String cemiterio, nome, quadra, rua;
	private Integer numero, certidaoObito;
	private String dataNascimento, dataObito;

	public Cadastro(Integer id, Boolean pessoaPublica, String cemiterio, String nome, String quadra, String rua,
			Integer numero, Integer certidaoObito, String dataNascimento, String dataObito) {
		super();
		this.id = id;
		this.pessoaPublica = pessoaPublica;
		this.cemiterio = cemiterio;
		this.nome = nome;
		this.quadra = quadra;
		this.rua = rua;
		this.numero = numero;
		this.certidaoObito = certidaoObito;
		this.dataNascimento = dataNascimento;
		this.dataObito = dataObito;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getPessoaPublica() {
		return pessoaPublica;
	}

	public void setPessoaPublica(Boolean pessoaPublica) {
		this.pessoaPublica = pessoaPublica;
	}

	public String getCemiterio() {
		return cemiterio;
	}

	public void setCemiterio(String cemiterio) {
		this.cemiterio = cemiterio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getQuadra() {
		return quadra;
	}

	public void setQuadra(String quadra) {
		this.quadra = quadra;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getCertidaoObito() {
		return certidaoObito;
	}

	public void setCertidaoObito(Integer certidaoObito) {
		this.certidaoObito = certidaoObito;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDataObito() {
		return dataObito;
	}

	public void setDataObito(String dataObito) {
		this.dataObito = dataObito;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Cadastro [id=" + id + ", pessoaPublica=" + pessoaPublica + ", cemiterio=" + cemiterio + ", nome=" + nome
				+ ", quadra=" + quadra + ", rua=" + rua + ", numero=" + numero + ", certidaoObito=" + certidaoObito
				+ ", dataNascimento=" + dataNascimento + ", dataObito=" + dataObito + "]";
	}
}