package com.sepulcrum.model.servico;

import java.sql.Date;

import com.sepulcrum.model.servico.utils.Servico;

public class TransferenciaDefunto extends Servico {
    private String tumNumeroDestino, tumRuaDestino, cemCnpjDestino, finCertidaoObito;

    public TransferenciaDefunto(String tipoServicoStr, String descricao, String statusServicoStr, Date dataServico,
            String tumRua, String tumNumero, String cemCnpj, String admCpf, String tumRuaDestino, String tumNumeroDestino,
            String cemCnpjDestino, String finCertidaoObito) {
        super(tipoServicoStr, descricao, statusServicoStr, dataServico, tumRua, tumNumero, cemCnpj, admCpf);
        this.tumRuaDestino = tumRuaDestino;
        this.tumNumeroDestino = tumNumeroDestino;
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