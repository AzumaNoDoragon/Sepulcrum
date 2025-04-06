package modules.servicos.utils;

public abstract class ServicosCemiterio {
    protected String dataServico, descricao, informacoesAdicionais, statusServico;
    protected int idServico, idResponsavelServico;

    public int getIdResponsavelServico() {
        return idResponsavelServico;
    }

    public void setIdResponsavelServico(int idResponsavelServico) {
        this.idResponsavelServico = idResponsavelServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

    public String getStatusServico() {
        return statusServico;
    }

    public void setStatusServico(String statusServico) {
        this.statusServico = statusServico;
    }

    public String getDataServico() {
        return dataServico;
    }

    public void setDataServico(String dataServico) {
        this.dataServico = dataServico;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }
}
