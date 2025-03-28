package entidades.servicos;

import java.time.LocalDate;

public abstract class ServicoTumulo extends ServicosCemiterio {
    protected int idTumulo;

    public ServicoTumulo(String responsavelServico, String descricao, String informacoesAdicionaris,
            String statusServico, LocalDate dataServico, int idServico, int idTumulo) {
        super(responsavelServico, descricao, informacoesAdicionaris, statusServico, dataServico, idServico);
        this.idTumulo = idTumulo;
    }

    public int getIdTumulo() {
        return idTumulo;
    }

    public void setIdTumulo(int idTumulo) {
        this.idTumulo = idTumulo;
    }
}
