package com.sepulcrum.model.pessoa;

import java.sql.Date;
import com.sepulcrum.model.pessoa.utils.PessoaViva;

public class Adm extends PessoaViva{
    private Cargo cargo;
    private Date dataContratacao;

    private enum Cargo{
        Coveiro, Adm
    }

    public Adm(String nome, String cpf, Date dataNascimento, Date dataContratacao, String email, String telefone, String cargoStr) {
        super(nome, cpf, dataNascimento, email, telefone);
        setCargo(cargoStr);
        this.dataContratacao = dataContratacao;
    }

    public void setCargo(String cargoStr){
        if(cargoStr.equals("Coveiro")){
            this.cargo = Cargo.Coveiro;
        } else if(cargoStr.equals("Adm")){
            this.cargo = Cargo.Adm;
        }
    }

    public String getCargo() {
        return cargo.name();
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
}