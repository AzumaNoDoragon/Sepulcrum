package com.sepulcrum.model.servico;

import java.sql.Date;

import com.sepulcrum.model.servico.utils.Servico;

public class ReservaTumulo extends Servico{
    private String cpfPessoa; // == Familiar

    public ReservaTumulo(String tipoServicoStr, String descricao, String statusServicoStr, Date dataServico,
            String tumRua, String tumNumero, String cemCnpj, String admCpf, String idPessoa) {
        super(tipoServicoStr, descricao, statusServicoStr, dataServico, tumRua, tumNumero, cemCnpj, admCpf);
        this.cpfPessoa = idPessoa;
    }

    public String getIdPessoa() {
        return cpfPessoa;
    }

    public void setIdPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }
}