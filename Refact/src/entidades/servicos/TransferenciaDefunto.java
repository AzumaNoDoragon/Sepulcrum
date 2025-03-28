package entidades.servicos;

import java.time.LocalDate;

public class TransferenciaDefunto extends ServicoTumulo {
    private int idTumuloDestino;

    public TransferenciaDefunto(String responsavelServico, String descricao, String informacoesAdicionaris,
            String statusServico, LocalDate dataServico, int idServico, int idTumulo, int idTumuloDestino) {
        super(responsavelServico, descricao, informacoesAdicionaris, statusServico, dataServico, idServico, idTumulo);
        this.idTumuloDestino = idTumuloDestino;
    }

    public int getIdTumuloDestino() {
        return idTumuloDestino;
    }

    public void setIdTumuloDestino(int idTumuloDestino) {
        this.idTumuloDestino = idTumuloDestino;
    }
}
