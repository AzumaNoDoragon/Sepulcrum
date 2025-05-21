package com.sepulcrum.model.pessoas;

import java.sql.Date;

import com.sepulcrum.model.pessoas.utils.Pessoas;

public class Finado extends Pessoas {
    private String causaMorte, tumRua, tumNumero, certidaoObito;
    private Date dataFalecimento;

    public Finado(String nome, String cpf, Date dataNascimento, Date dataFalecimento, String certidaoObito, String causaMorte, String tumRua, 
            String tumNumero) {
        super(nome, cpf, dataNascimento);
        this.causaMorte = causaMorte;
        this.tumRua = tumRua;
        this.tumNumero = tumNumero;
        this.certidaoObito = certidaoObito;
        this.dataFalecimento = dataFalecimento;
    }
    
    @Override
    public void setNome(String nome){
        if(nome == null || nome.isBlank()){
            this.nome = "Não identificado(a)";
        } else{
            this.nome = nome;
        }
    }
    
    @Override
    public void setCpf(String cpf){
        if(cpf == null || cpf.isBlank() || cpf.equals("0")){
            this.cpf = certidaoObito;
        } else{
            this.cpf = cpf;
        }
    }

    @Override
    public void setDataNascimento(Date dataNascimento){
        this.dataNascimento = Date.valueOf("1900-01-01");
        System.out.println(dataNascimento);
        /*if(dataNascimento == null){
            this.dataNascimento = Date.valueOf("1900-01-01");
        } else{
            this.dataNascimento = dataNascimento;
        }*/
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

    public Date getDataFalecimento() {
        return dataFalecimento;
    }

    public void setDataFalecimento(Date dataFalecimento){
        if(dataFalecimento == null){
            this.dataFalecimento = Date.valueOf("1900-01-01");
        } else{
            this.dataFalecimento = dataFalecimento;
        }
    }
}