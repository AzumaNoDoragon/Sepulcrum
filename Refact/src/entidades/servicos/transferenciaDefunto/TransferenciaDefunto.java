package entidades.servicos.transferenciaDefunto;

import entidades.servicos.heranca.ServicoTumulo;

public class TransferenciaDefunto extends ServicoTumulo {
    private int idTumuloDestino, idDefunto;

    public int getIdDefunto() {
        return idDefunto;
    }

    public void setIdDefunto(int idDefunto) {
        this.idDefunto = idDefunto;
    }

    public int getIdTumuloDestino() {
        return idTumuloDestino;
    }

    public void setIdTumuloDestino(int idTumuloDestino) {
        this.idTumuloDestino = idTumuloDestino;
    }
}
