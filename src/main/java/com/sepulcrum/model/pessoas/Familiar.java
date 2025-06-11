package com.sepulcrum.model.pessoas;

import java.sql.Date;

import com.sepulcrum.model.pessoas.utils.PessoasVivas;

public class Familiar extends PessoasVivas {
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
        } else if(grauStr.equals("NaoParente")){
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