package com.sepulcrum.model.servico;

import java.sql.Date;

import com.sepulcrum.model.servico.utils.Servico;

public class Exumacao extends Servico {
    private String finCertidaoObito;
    
    public Exumacao(String tipoServicoStr, String descricao, String statusServicoStr, Date dataServico, String tumRua,
            String tumNumero, String cemCnpj, String admCpf, String finCertidaoObito) {
        super(tipoServicoStr, descricao, statusServicoStr, dataServico, tumRua, tumNumero, cemCnpj, admCpf);
        this.finCertidaoObito = finCertidaoObito;
    }

    public String getFinCertidaoObito() {
        return finCertidaoObito;
    }

    public void setFinCertidaoObito(String finCertidaoObito) {
        this.finCertidaoObito = finCertidaoObito;
    }
}