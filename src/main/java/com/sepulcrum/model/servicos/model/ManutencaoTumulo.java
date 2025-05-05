package com.sepulcrum.model.servicos.model;

import com.sepulcrum.model.servicos.model.utils.Servicos;

public class ManutencaoTumulo extends Servicos{
    public ManutencaoTumulo(String statusServicoStr, String tipoServicoStr, String descricao, String admCpf,
            String tumRua, String tumNumero, String cemCnpj, int idServico) {
        super(statusServicoStr, tipoServicoStr, descricao, admCpf, tumRua, tumNumero, cemCnpj, idServico);
    }
}