package com.sepulcrum.model.servicos.model;

import com.sepulcrum.model.servicos.model.utils.Servicos;

public class Exumacao extends Servicos {
    private int idServico;
    private String finCertidaoObito;
    
    public Exumacao(String tipoServico, String dataServico, String descricao, String admCpf, String tumRua,
            String tumNumero, String cemCnpj, int idServico, String statusServicoStr, int idServico2,
            String finCertidaoObito) {
        super(tipoServico, dataServico, descricao, admCpf, tumRua, tumNumero, cemCnpj, idServico, statusServicoStr);
        idServico = idServico2;
        this.finCertidaoObito = finCertidaoObito;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getFinCertidaoObito() {
        return finCertidaoObito;
    }

    public void setFinCertidaoObito(String finCertidaoObito) {
        this.finCertidaoObito = finCertidaoObito;
    }
}
