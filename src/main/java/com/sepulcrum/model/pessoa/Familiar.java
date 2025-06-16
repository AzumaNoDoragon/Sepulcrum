package com.sepulcrum.model.pessoa;

import java.sql.Date;
import com.sepulcrum.model.pessoa.utils.PessoaViva;

public class Familiar extends PessoaViva {
    private Grau grauParentesco;
    private String certidaoObito, rg;

    private enum Grau{
        Ascendente, Descendente, Colateral, Conjuge, NaoParente
    }

    public Familiar(String nome, String cpf, Date dataNascimento, String email, String telefone) {
        super(nome, cpf, dataNascimento, email, telefone);
    }

    public void setGrauParentesco(String grauStr){
        if(grauStr.equals("Ascendente")){
            this.grauParentesco = Grau.Ascendente;
        } else if(grauStr.equals("Descendente")){
            this.grauParentesco = Grau.Descendente;
        } else if(grauStr.equals("Colateral")){
            this.grauParentesco = Grau.Colateral;
        } else if(grauStr.equals("Conjuge")){
            this.grauParentesco = Grau.Conjuge;
        } else if(grauStr.equals("Não Parente")){
            this.grauParentesco = Grau.NaoParente;
        }
    }

    public String getGrauParentesco(){
        return grauParentesco.name();
    }

    public String getCertidaoObito() {
        return certidaoObito;
    }

    public void setCertidaoObito(String certidaoObito) {
        this.certidaoObito = certidaoObito;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}