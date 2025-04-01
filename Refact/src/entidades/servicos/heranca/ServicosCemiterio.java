package entidades.servicos.heranca;

public abstract class ServicosCemiterio {
    protected String dataServico, descricao, informacoesAdicionaris, statusServico;
    protected int idServico, responsavelServico;

    public int getResponsavelServico() {
        return responsavelServico;
    }

    public void setResponsavelServico(int responsavelServico) {
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
