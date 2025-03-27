package entidades.servicos;

public abstract class ServicoTumulo {
    protected int idTumulo;

    public ServicoTumulo(int idTumulo) {
        this.idTumulo = idTumulo;
    }

    public int getIdTumulo() {
        return idTumulo;
    }

    public void setIdTumulo(int idTumulo) {
        this.idTumulo = idTumulo;
    }
}
