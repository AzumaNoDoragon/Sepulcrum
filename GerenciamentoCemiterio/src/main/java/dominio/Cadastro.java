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
    private Integer idFalecido, ocupa;
    private Boolean pessoaPublica;
    private String nome, certidaoObito, dataNascimento, dataObito;

    public Integer getIdFalecido() {
        return idFalecido;
    }

    public void setIdFalecido(Integer idFalecido) {
        this.idFalecido = idFalecido;
    }

    public Integer getOcupa() {
        return ocupa;
    }

    public void setOcupa(Integer ocupa) {
        this.ocupa = ocupa;
    }

    public Boolean getPessoaPublica() {
        return pessoaPublica;
    }

    public void setPessoaPublica(Boolean pessoaPublica) {
        this.pessoaPublica = pessoaPublica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCertidaoObito() {
        return certidaoObito;
    }

    public void setCertidaoObito(String certidaoObito) {
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
}