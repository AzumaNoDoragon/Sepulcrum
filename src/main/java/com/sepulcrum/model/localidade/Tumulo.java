package com.sepulcrum.model.localidade;

import java.sql.Date;
import com.sepulcrum.model.localidade.utils.Localidade;

public class Tumulo extends Localidade{
    private Tipo tipo;
    private Situacao situacao;
    private String cemCnpj, famCpf;
    private Date dataOcupacao;

    private enum Tipo{
        CovaRasa, TumuloAlvenaria, JazigoPerpetuo, Ossuario, Mausoleu, Columbario
    }
    
    private enum Situacao{
        Vazio, Reservado, Comprado, Ocupado, Manutencao, AguardandoExumação, DesativadoIndisponível
    }
    
    public Tumulo(String tipoStr, String situacaoStr, Date dataOcupacao, String rua, String numero, String cemCnpj) {
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

    public Date getDataOcupacao() {
        return dataOcupacao;
    }

    public void setDataOcupacao(Date dataOcupacao) {
        this.dataOcupacao = dataOcupacao;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getSituacao() {
        return situacao.name();
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public String getCemCnpj() {
        return cemCnpj;
    }

    public void setCemCnpj(String cemCnpj) {
        this.cemCnpj = cemCnpj;
    }

    
    public String getFamCpf() {
        return famCpf;
    }

    public void setFamCpf(String famCpf) {
        this.famCpf = famCpf;
    }
}