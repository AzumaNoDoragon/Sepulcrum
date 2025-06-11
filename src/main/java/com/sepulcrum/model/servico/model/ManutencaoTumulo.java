package com.sepulcrum.model.servico.model;

import java.sql.Date;

import com.sepulcrum.model.servico.model.utils.Servicos;

public class ManutencaoTumulo extends Servicos{
    public ManutencaoTumulo(String tipoServicoStr, String descricao, String statusServicoStr, Date dataServico,
            String tumRua, String tumNumero, String cemCnpj, String admCpf) {
        super(tipoServicoStr, descricao, statusServicoStr, dataServico, tumRua, tumNumero, cemCnpj, admCpf);
    }
}