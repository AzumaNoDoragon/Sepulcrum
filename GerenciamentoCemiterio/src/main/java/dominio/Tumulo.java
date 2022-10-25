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
    private Integer idTumulo, ocupante;
    private String cemiterio, quadraTumulo, ruaTumulo, numeroTumulo, ocupadoDesde;
    private Boolean ocupado, perpetuo;

    public Integer getIdTumulo() {
        return idTumulo;
    }

    public void setIdTumulo(Integer idTumulo) {
        this.idTumulo = idTumulo;
    }

    public Integer getOcupante() {
        return ocupante;
    }

    public void setOcupante(Integer ocupante) {
        this.ocupante = ocupante;
    }

    public String getCemiterio() {
        return cemiterio;
    }

    public void setCemiterio(String cemiterio) {
        this.cemiterio = cemiterio;
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

    public String getOcupadoDesde() {
        return ocupadoDesde;
    }

    public void setOcupadoDesde(String ocupadoDesde) {
        this.ocupadoDesde = ocupadoDesde;
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Boolean getPerpetuo() {
        return perpetuo;
    }

    public void setPerpetuo(Boolean perpetuo) {
        this.perpetuo = perpetuo;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
