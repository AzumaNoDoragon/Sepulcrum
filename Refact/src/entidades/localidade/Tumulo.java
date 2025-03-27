package entidades.localidade;

public class Tumulo extends Localidade{
    private String tipo, dataOcupacao, situacao;
    private int idCemiterio, idDefunto;

    public Tumulo(String rua, int id, int numero, String tipo, String dataOcupacao, String situacao, int idCemiterio,
            int idDefunto) {
        super(rua, id, numero);
        this.tipo = tipo;
        this.dataOcupacao = dataOcupacao;
        this.situacao = situacao;
        this.idCemiterio = idCemiterio;
        this.idDefunto = idDefunto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDataOcupacao() {
        return dataOcupacao;
    }

    public void setDataOcupacao(String dataOcupacao) {
        this.dataOcupacao = dataOcupacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getIdCemiterio() {
        return idCemiterio;
    }

    public void setIdCemiterio(int idCemiterio) {
        this.idCemiterio = idCemiterio;
    }

    public int getIdDefunto() {
        return idDefunto;
    }

    public void setIdDefunto(int idDefunto) {
        this.idDefunto = idDefunto;
    }
}