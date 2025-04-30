package com.sepulcrum.model.servicos.model;

import com.sepulcrum.model.servicos.model.utils.Servico;

public class TransferenciaDefunto extends Servico {
    private int idTumuloDestino, idDefunto;

    public int getIdDefunto() {
        return idDefunto;
    }

    public void setIdDefunto(int idDefunto) {
        this.idDefunto = idDefunto;
    }

    public int getIdTumuloDestino() {
        return idTumuloDestino;
    }

    public void setIdTumuloDestino(int idTumuloDestino) {
        this.idTumuloDestino = idTumuloDestino;
    }
}
