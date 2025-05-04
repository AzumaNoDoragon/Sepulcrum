package com.sepulcrum.model.servicos.model;

import com.sepulcrum.model.servicos.model.utils.Servicos;

public class TransferenciaDefunto extends Servicos {
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
