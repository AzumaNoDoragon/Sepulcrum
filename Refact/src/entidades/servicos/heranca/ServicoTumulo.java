package entidades.servicos.heranca;

public abstract class ServicoTumulo extends ServicosCemiterio {
    protected int idTumulo;

    public int getIdTumulo() {
        return idTumulo;
    }

    public void setIdTumulo(int idTumulo) {
        this.idTumulo = idTumulo;
    }
}
