package entidades.servicos;

import java.time.LocalDate;

public class Exumacao extends ServicoTumulo {
    private int idDefunto;

    public Exumacao(String responsavelServico, String descricao, String informacoesAdicionaris, String statusServico,
            LocalDate dataServico, int idServico, int idTumulo, int idDefunto) {
        super(responsavelServico, descricao, informacoesAdicionaris, statusServico, dataServico, idServico, idTumulo);
        this.idDefunto = idDefunto;
    }

    public int getIdDefunto() {
        return idDefunto;
    }

    public void setIdDefunto(int idDefunto) {
        this.idDefunto = idDefunto;
    }
}
