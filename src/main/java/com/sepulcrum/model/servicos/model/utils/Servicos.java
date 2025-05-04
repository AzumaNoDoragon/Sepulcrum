package com.sepulcrum.model.servicos.model.utils;

public class Servicos {
    protected StatusServico statusServico;
    protected String tipoServico, dataServico, descricao, informacoesAdicionais, admCpf, tumRua, tumNumero, cemCnpj;
    protected int idServico;

    protected enum StatusServico{
        Marcado,
        Andamento,
        Concluido,
        Adiaco,
        Cancelado
    }

    public Servicos(String tipoServico, String dataServico, String descricao,
            String admCpf, String tumRua, String tumNumero, String cemCnpj, int idServico, String statusServicoStr) {
        setStatusServico(statusServicoStr);
        this.tipoServico = tipoServico;
        this.dataServico = dataServico;
        this.descricao = descricao;
        this.admCpf = admCpf;
        this.tumRua = tumRua;
        this.tumNumero = tumNumero;
        this.cemCnpj = cemCnpj;
        this.idServico = idServico;
    }

    public void setStatusServico(String statusServicoStr){
        if(statusServicoStr.equals("Marcado")){
            this.statusServico = StatusServico.Marcado;
        } else if(statusServicoStr.equals("Andamento")){
            this.statusServico = StatusServico.Andamento;
        } else if(statusServicoStr.equals("Concluido")){
            this.statusServico = StatusServico.Concluido;
        } else if(statusServicoStr.equals("Adiaco")){
            this.statusServico = StatusServico.Adiaco;
        } else if(statusServicoStr.equals("Cancelado")){
            this.statusServico = StatusServico.Cancelado;
        }
    }

    public String getStatusServico() {
        return statusServico.name();
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getDataServico() {
        return dataServico;
    }

    public void setDataServico(String dataServico) {
        this.dataServico = dataServico;
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

    public String getAdmCpf() {
        return admCpf;
    }

    public void setAdmCpf(String admCpf) {
        this.admCpf = admCpf;
    }

    public String getTumRua() {
        return tumRua;
    }

    public void setTumRua(String tumRua) {
        this.tumRua = tumRua;
    }

    public String getTumNumero() {
        return tumNumero;
    }

    public void setTumNumero(String tumNumero) {
        this.tumNumero = tumNumero;
    }

    public String getCemCnpj() {
        return cemCnpj;
    }

    public void setCemCnpj(String cemCnpj) {
        this.cemCnpj = cemCnpj;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }
}