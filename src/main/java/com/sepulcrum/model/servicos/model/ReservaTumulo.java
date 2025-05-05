package com.sepulcrum.model.servicos.model;

import com.sepulcrum.model.servicos.model.utils.Servicos;

public class ReservaTumulo extends Servicos{
    private String idPessoa; // == Familiar

    public ReservaTumulo(String statusServicoStr, String tipoServicoStr, String descricao, String admCpf, String tumRua,
            String tumNumero, String cemCnpj, int idServico, String idPessoa) {
        super(statusServicoStr, tipoServicoStr, descricao, admCpf, tumRua, tumNumero, cemCnpj, idServico);
        this.idPessoa = idPessoa;
    }

    public String getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(String idPessoa) {
        this.idPessoa = idPessoa;
    }
}