package com.sepulcrum.model.servicos.model.exumacao;

import com.sepulcrum.model.servicos.model.utils.Servico;

public class Exumacao extends Servico {
    private int idDefunto;
    
    public int getIdDefunto() {
        return idDefunto;
    }

    public void setIdDefunto(int idDefunto) {
        this.idDefunto = idDefunto;
    }
}
