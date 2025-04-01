package entidades.servicos.transferenciaDefunto;

import entidades.servicos.heranca.ServicoTumulo;

public class TransferenciaDefunto extends ServicoTumulo {
    private int idTumuloDestino;

    public int getIdTumuloDestino() {
        return idTumuloDestino;
    }

    public void setIdTumuloDestino(int idTumuloDestino) {
        this.idTumuloDestino = idTumuloDestino;
    }
}
