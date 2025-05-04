package com.sepulcrum.model.servicos.model.utils;

import java.sql.Date;

public class Servicos {
    protected StatusServico statusServico;
    protected TipoServico tipoServico;
    protected String descricao, informacoesAdicionais, admCpf, tumRua, tumNumero, cemCnpj;
    protected int idServico;
    protected Date dataServico;

    protected enum StatusServico{
        Marcado,
        Andamento,
        Concluido,
        Adiado,
        Cancelado
    }

    protected enum TipoServico{
        Exumacao,
        ManutencaoTumulo,
        ReservaTumulo,
        TransferenciaTumulo,
        vistoria
    }

    public Servicos(String statusServicoStr, String tipoServicoStr, String descricao, String admCpf, String tumRua, 
            String tumNumero, String cemCnpj, int idServico) {
        setStatusServico(statusServicoStr);
        setTipoServico(tipoServicoStr);
        this.descricao = descricao;
        this.admCpf = admCpf;
        this.tumRua = tumRua;
        this.tumNumero = tumNumero;
        this.cemCnpj = cemCnpj;
        this.idServico = idServico;
    }

    public String getStatusServico() {
        return statusServico.name();
    }

    public void setStatusServico(String statusServicoStr){
        if(statusServicoStr.equals("Marcado")){
            this.statusServico = StatusServico.Marcado;
        } else if(statusServicoStr.equals("Andamento")){
            this.statusServico = StatusServico.Andamento;
        } else if(statusServicoStr.equals("Concluido")){
            this.statusServico = StatusServico.Concluido;
        } else if(statusServicoStr.equals("Adiado")){
            this.statusServico = StatusServico.Adiado;
        } else if(statusServicoStr.equals("Cancelado")){
            this.statusServico = StatusServico.Cancelado;
        }
    }

    public String getTipoServico() {
        return tipoServico.name();
    }

    public void setTipoServico(String tipoServico){
        if(tipoServico.equals("Exumacao")){
            this.tipoServico = TipoServico.Exumacao;
        } else if(tipoServico.equals("ManutencaoTumulo")){
            this.tipoServico = TipoServico.ManutencaoTumulo;
        } else if(tipoServico.equals("ReservaTumulo")){
            this.tipoServico = TipoServico.ReservaTumulo;
        } else if(tipoServico.equals("TransferenciaTumulo")){
            this.tipoServico = TipoServico.TransferenciaTumulo;
        } else if(tipoServico.equals("vistoria")){
            this.tipoServico = TipoServico.vistoria;
        }
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

    public Date getDataServico() {
        return dataServico;
    }

    public void setDataServico(Date dataServico) {
        this.dataServico = dataServico;
    }
}