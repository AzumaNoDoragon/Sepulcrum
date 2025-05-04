package com.sepulcrum.model.localidade;

import com.sepulcrum.model.localidade.utils.Localidade;

public class Cemiterio extends Localidade {
    private String cnpj, nome, estado, cidade, telefone, cep, admCpf;
    private int capacidadeMax;

    public Cemiterio(String rua, String numero, String cnpj, String nome, String estado, String cidade, String telefone,
            String cep, String admCpf) {
        super(rua, numero);
        this.cnpj = cnpj;
        this.nome = nome;
        this.estado = estado;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.admCpf = admCpf;
    }

    public String getAdmCpf() {
        return admCpf;
    }

    public void setAdmCpf(String admCpf) {
        this.admCpf = admCpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCapacidadeMax() {
        return capacidadeMax;
    }

    public void setCapacidadeMax(int capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}