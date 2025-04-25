package com.sepulcrum.model.pessoas.utils;

public abstract class PessoasVivas extends Pessoas{
    protected String email, telefone;

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
}