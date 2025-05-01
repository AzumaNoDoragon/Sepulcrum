package com.sepulcrum.model.pessoas;

import java.sql.Date;

import com.sepulcrum.model.pessoas.utils.Pessoas;

public class Finado extends Pessoas {
    private String causaMorte;
    private int certidaoObito, cpfFamiliar, idTumulo;

    public Finado(String nome, int cpf, Date dataNascimento, int certidaoObito, int cpfFamiliar, int idTumulo) {
        super(nome, cpf, dataNascimento);
        this.certidaoObito = certidaoObito;
        this.cpfFamiliar = cpfFamiliar;
        this.idTumulo = idTumulo;
    }

    public String getCausaMorte() {
        return causaMorte;
    }

    public void setCausaMorte(String causaMorte) {
        this.causaMorte = causaMorte;
    }

    public int getCertidaoObito() {
        return certidaoObito;
    }

    public void setCertidaoObito(int certidaoObito) {
        this.certidaoObito = certidaoObito;
    }

    public int getCpfFamiliar() {
        return cpfFamiliar;
    }

    public void setCpfFamiliar(int cpfFamiliar) {
        this.cpfFamiliar = cpfFamiliar;
    }

    public int getIdTumulo() {
        return idTumulo;
    }

    public void setIdTumulo(int idTumulo) {
        this.idTumulo = idTumulo;
    }

    @Override
    public void setCpf(int cpf){
        if(cpf == 0){
            this.cpf = certidaoObito;
        } else{
            this.cpf = cpf;
        }
    }
}