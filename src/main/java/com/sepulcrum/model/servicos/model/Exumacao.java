package com.sepulcrum.model.servicos.model;

import com.sepulcrum.model.servicos.model.utils.Servicos;

public class Exumacao extends Servicos {
    private String finCertidaoObito;

    public Exumacao(String statusServicoStr, String tipoServicoStr, String descricao, String admCpf, String tumRua,
            String tumNumero, String cemCnpj, int idServico, String finCertidaoObito) {
        super(statusServicoStr, tipoServicoStr, descricao, admCpf, tumRua, tumNumero, cemCnpj, idServico);
        this.finCertidaoObito = finCertidaoObito;
    }

    public String getFinCertidaoObito() {
        return finCertidaoObito;
    }

    public void setFinCertidaoObito(String finCertidaoObito) {
        this.finCertidaoObito = finCertidaoObito;
    }
}
