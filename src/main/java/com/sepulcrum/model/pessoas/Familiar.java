package com.sepulcrum.model.pessoas;

import java.sql.Date;

import com.sepulcrum.model.pessoas.utils.PessoasVivas;

public class Familiar extends PessoasVivas {
    private String grauParentesco;
    private int certidaoObito;
    
    public Familiar(String nome, int cpf, Date dataNascimento, String email, String telefone, String grauParentesco,
            int certidaoObito) {
        super(nome, cpf, dataNascimento, email, telefone);
        this.grauParentesco = grauParentesco;
        this.certidaoObito = certidaoObito;
    }

    public String getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
    }

    public int getCertidaoObito() {
        return certidaoObito;
    }

    public void setCertidaoObito(int certidaoObito) {
        this.certidaoObito = certidaoObito;
    }
}