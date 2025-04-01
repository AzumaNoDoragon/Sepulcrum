package entidades.servicos.exumacao;

import entidades.servicos.heranca.ServicoTumulo;

public class Exumacao extends ServicoTumulo {
    private int idDefunto;
    
    public int getIdDefunto() {
        return idDefunto;
    }

    public void setIdDefunto(int idDefunto) {
        this.idDefunto = idDefunto;
    }
}
