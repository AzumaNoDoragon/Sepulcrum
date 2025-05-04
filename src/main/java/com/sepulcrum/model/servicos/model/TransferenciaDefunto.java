package com.sepulcrum.model.servicos.model;

import com.sepulcrum.model.servicos.model.utils.Servicos;

public class TransferenciaDefunto extends Servicos {
    private String tumNumeroDestino, tumRuaDestino, cemCnpjDestino, finCertidaoObito;

    public TransferenciaDefunto(String statusServicoStr, String tipoServicoStr, String descricao, String admCpf,
            String tumRua, String tumNumero, String cemCnpj, int idServico, String tumNumeroDestino,
            String tumRuaDestino, String cemCnpjDestino, String finCertidaoObito) {
        super(statusServicoStr, tipoServicoStr, descricao, admCpf, tumRua, tumNumero, cemCnpj, idServico);
        this.tumNumeroDestino = tumNumeroDestino;
        this.tumRuaDestino = tumRuaDestino;
        this.cemCnpjDestino = cemCnpjDestino;
        this.finCertidaoObito = finCertidaoObito;
    }

    public String getTumNumeroDestino() {
        return tumNumeroDestino;
    }

    public void setTumNumeroDestino(String tumNumeroDestino) {
        this.tumNumeroDestino = tumNumeroDestino;
    }

    public String getTumRuaDestino() {
        return tumRuaDestino;
    }

    public void setTumRuaDestino(String tumRuaDestino) {
        this.tumRuaDestino = tumRuaDestino;
    }

    public String getCemCnpjDestino() {
        return cemCnpjDestino;
    }

    public void setCemCnpjDestino(String cemCnpjDestino) {
        this.cemCnpjDestino = cemCnpjDestino;
    }

    public String getFinCertidaoObito() {
        return finCertidaoObito;
    }

    public void setFinCertidaoObito(String finCertidaoObito) {
        this.finCertidaoObito = finCertidaoObito;
    }
}