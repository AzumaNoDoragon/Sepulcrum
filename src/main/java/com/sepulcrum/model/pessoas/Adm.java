package com.sepulcrum.model.pessoas;

import java.sql.Date;
import com.sepulcrum.model.pessoas.utils.PessoasVivas;

public class Adm extends PessoasVivas{
    private Cargo cargo;
    private String cemCnpj;
    private Date dataContratacao;

    private enum Cargo{
        Coveiro, Adm
    }

    public Adm(String nome, String cpf, Date dataNascimento, String email, String telefone, String cargoStr, 
            String cemCnpj,  Date dataContratacao) {
        super(nome, cpf, dataNascimento, email, telefone);
        setCargo(cargoStr);
        this.cemCnpj = cemCnpj;
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

    public String getCemCnpj() {
        return cemCnpj;
    }

    public void setCemCnpj(String cemCnpj) {
        this.cemCnpj = cemCnpj;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
}