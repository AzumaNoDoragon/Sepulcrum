package domain.pessoas.parente.model;

import domain.pessoas.utils.PessoasVivas;

public class Parente extends PessoasVivas {
    private String grauParentesco;
    private int idDefunto;
    
    public String getGrauParentesco(){
        return grauParentesco;
    }

    public void setGrauParentesco(String grauParentesco){
        this.grauParentesco = grauParentesco;
    }

    public int getIdDefunto(){
        return idDefunto;
    }

    public void setIdDefunto(int idDefunto){
        this.idDefunto = idDefunto;
    }
}
