package com.sepulcrum.model.pessoas;

import java.sql.Date;
import com.sepulcrum.model.pessoas.utils.PessoasVivas;

public class Adm extends PessoasVivas{
    private String cargo;
    private Date dataContratacao;

    public Adm(String nome, int cpf, Date dataNascimento, String email, String telefone, String cargo,
            Date dataContratacao) {
        super(nome, cpf, dataNascimento, email, telefone);
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
    }

    public String getCargo(){
        return cargo;
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    public Date getDataContratacao(){
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao){
        this.dataContratacao = dataContratacao;
    }
}