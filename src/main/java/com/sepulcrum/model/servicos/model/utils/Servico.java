package com.sepulcrum.model.servicos.model.utils;

public class Servico {
    protected String tipoServico, dataServico, descricao, informacoesAdicionais, statusServico;
    protected int idServico, idResponsavelServico, idTumulo;
    
    public int getIdTumulo() {
        return idTumulo;
    }

    public void setIdTumulo(int idTumulo) {
        this.idTumulo = idTumulo;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

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