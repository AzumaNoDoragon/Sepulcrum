package com.sepulcrum.model.servico;

import java.sql.Date;

import com.sepulcrum.model.servico.utils.Servico;

public class ManutencaoTumulo extends Servico{
    public ManutencaoTumulo(String tipoServicoStr, String descricao, String statusServicoStr, Date dataServico,
            String tumRua, String tumNumero, String cemCnpj, String admCpf) {
        super(tipoServicoStr, descricao, statusServicoStr, dataServico, tumRua, tumNumero, cemCnpj, admCpf);
    }
}