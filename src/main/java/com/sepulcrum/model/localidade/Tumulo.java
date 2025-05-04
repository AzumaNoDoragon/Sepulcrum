package com.sepulcrum.model.localidade;

import com.sepulcrum.model.localidade.utils.Localidade;

public class Tumulo extends Localidade{
    private Tipo tipo;
    private Situacao situacao;
    private String dataOcupacao;
    private int cemCnpj;

    private enum Tipo{
        CovaRasa, TumuloAlvenaria, JazigoPerpetuo, Ossuario, Mausoleu, Columbario
    }
    
    private enum Situacao{
        Vazio, Reservado, Comprado, Ocupado, Manutencao, AguardandoExumação, DesativadoIndisponível
    
    }
    public Tumulo(String rua, String numero, Tipo tipo, Situacao situacao, String dataOcupacao, int cemCnpj,
            int defCertidaoObito, String tipoStr, String situacaoStr) {
        super(rua, numero);
        setTipo(tipoStr);
        setSituacao(situacaoStr);
        this.dataOcupacao = dataOcupacao;
        this.cemCnpj = cemCnpj;
    }

    public void setTipo(String tipoStr){
        if(tipoStr.equals("Cova Rasa")){
            this.tipo = Tipo.CovaRasa;
        } else if(tipoStr.equals("Tumulo Alvenaria")){
            this.tipo = Tipo.TumuloAlvenaria;
        } else if(tipoStr.equals("Jazigo Perpetuo")){
            this.tipo = Tipo.JazigoPerpetuo;
        } else if(tipoStr.equals("Ossuario")){
            this.tipo = Tipo.Ossuario;
        } else if(tipoStr.equals("Mausoleu")){
            this.tipo = Tipo.Mausoleu;
        } else if(tipoStr.equals("Columbario")){
            this.tipo = Tipo.Columbario;
        }
    }

    public void setSituacao(String situacaoStr){
        if(situacaoStr.equals("Vazio")){
            this.situacao = Situacao.Vazio;
        } else if(situacaoStr.equals("Reservado")){
            this.situacao = Situacao.Reservado;
        } else if(situacaoStr.equals("Comprado")){
            this.situacao = Situacao.Comprado;
        } else if(situacaoStr.equals("Ocupado")){
            this.situacao = Situacao.Ocupado;
        } else if(situacaoStr.equals("Manutencao")){
            this.situacao = Situacao.Manutencao;
        } else if(situacaoStr.equals("Aguardando Exumação")){
            this.situacao = Situacao.AguardandoExumação;
        } else if(situacaoStr.equals("Desativado/Indisponível")){
            this.situacao = Situacao.DesativadoIndisponível;
        }
    }

    public String getTipo() {
        return tipo.name();
    }

    public String getDataOcupacao() {
        return dataOcupacao;
    }

    public void setDataOcupacao(String dataOcupacao) {
        this.dataOcupacao = dataOcupacao;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public int getCemCnpj() {
        return cemCnpj;
    }

    public void setCemCnpj(int cemCnpj) {
        this.cemCnpj = cemCnpj;
    }
}