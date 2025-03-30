package entidades.servicos.heranca;

import java.time.LocalDate;

public abstract class ServicosCemiterio {
    protected String responsavelServico, descricao, informacoesAdicionaris, statusServico;
    protected LocalDate dataServico;
    protected int idServico;

    public ServicosCemiterio(String responsavelServico, String descricao, String informacoesAdicionaris,
            String statusServico, LocalDate dataServico, int idServico) {
        this.responsavelServico = responsavelServico;
        this.descricao = descricao;
        this.informacoesAdicionaris = informacoesAdicionaris;
        this.statusServico = statusServico;
        this.dataServico = dataServico;
        this.idServico = idServico;
    }

    public String getResponsavelServico() {
        return responsavelServico;
    }

    public void setResponsavelServico(String responsavelServico) {
        this.responsavelServico = responsavelServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getInformacoesAdicionaris() {
        return informacoesAdicionaris;
    }

    public void setInformacoesAdicionaris(String informacoesAdicionaris) {
        this.informacoesAdicionaris = informacoesAdicionaris;
    }

    public String getStatusServico() {
        return statusServico;
    }

    public void setStatusServico(String statusServico) {
        this.statusServico = statusServico;
    }

    public LocalDate getDataServico() {
        return dataServico;
    }

    public void setDataServico(LocalDate dataServico) {
        this.dataServico = dataServico;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }
}
