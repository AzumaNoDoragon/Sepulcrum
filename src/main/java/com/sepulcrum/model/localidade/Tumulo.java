package com.sepulcrum.model.localidade;

import com.sepulcrum.model.localidade.utils.Localidade;

public class Tumulo extends Localidade{
    private String tipo, dataOcupacao, situacao;
    private int idCemiterio, idDefunto;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDataOcupacao() {
        return dataOcupacao;
    }

    public void setDataOcupacao(String dataOcupacao) {
        this.dataOcupacao = dataOcupacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getIdCemiterio() {
        return idCemiterio;
    }

    public void setIdCemiterio(int idCemiterio) {
        this.idCemiterio = idCemiterio;
    }

    public int getIdDefunto() {
        return idDefunto;
    }

    public void setIdDefunto(int idDefunto) {
        this.idDefunto = idDefunto;
    }
}