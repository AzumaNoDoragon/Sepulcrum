package com.sepulcrum.model.pessoas;

import java.sql.Date;

import com.sepulcrum.model.pessoas.utils.Pessoas;

public class Finado extends Pessoas {
    private String causaMorte, tumRua, tumNumero, certidaoObito;

    public Finado(String nome, String cpf, Date dataNascimento, String causaMorte, String tumRua, String tumNumero,
            String certidaoObito, String cpfFamiliar) {
        super(nome, cpf, dataNascimento);
        this.causaMorte = causaMorte;
        this.tumRua = tumRua;
        this.tumNumero = tumNumero;
        this.certidaoObito = certidaoObito;
    }

    public String getCausaMorte() {
        return causaMorte;
    }

    public void setCausaMorte(String causaMorte) {
        this.causaMorte = causaMorte;
    }

    public String getCertidaoObito() {
        return certidaoObito;
    }

    public void setCertidaoObito(String certidaoObito) {
        this.certidaoObito = certidaoObito;
    }

    @Override
    public void setCpf(String cpf){
        if(cpf.equals("0")){
            this.cpf = certidaoObito;
        } else{
            this.cpf = cpf;
        }
    }

    public String getTumRua() {
        return tumRua;
    }

    public void setTumRua(String tumRua) {
        this.tumRua = tumRua;
    }

    public String getTumNumero() {
        return tumNumero;
    }

    public void setTumNumero(String tumNumero) {
        this.tumNumero = tumNumero;
    }
}