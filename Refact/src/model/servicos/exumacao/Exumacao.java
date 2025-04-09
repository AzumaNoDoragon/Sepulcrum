package model.servicos.exumacao;

import model.servicos.utils.ServicoTumulo;

public class Exumacao extends ServicoTumulo {
    private int idDefunto;
    
    public int getIdDefunto() {
        return idDefunto;
    }

    public void setIdDefunto(int idDefunto) {
        this.idDefunto = idDefunto;
    }
}
