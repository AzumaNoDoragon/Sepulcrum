package entidades.servicos;

public class TransferenciaDefunto extends ServicoTumulo {
    private String motivoTransferencia;
    private int idTumuloDestino;

    public TransferenciaDefunto(int idTumulo, String motivoTransferencia, int idTumuloDestino) {
        super(idTumulo);
        this.motivoTransferencia = motivoTransferencia;
        this.idTumuloDestino = idTumuloDestino;
    }

    public String getMotivoTransferencia() {
        return motivoTransferencia;
    }

    public void setMotivoTransferencia(String motivoTransferencia) {
        this.motivoTransferencia = motivoTransferencia;
    }

    public int getIdTumuloDestino() {
        return idTumuloDestino;
    }

    public void setIdTumuloDestino(int idTumuloDestino) {
        this.idTumuloDestino = idTumuloDestino;
    }
}
