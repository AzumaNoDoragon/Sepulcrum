package domain.servicos.transferenciaDefunto;

import domain.servicos.utils.ServicoTumulo;

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
