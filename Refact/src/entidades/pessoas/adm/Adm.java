package entidades.pessoas.adm;

import entidades.pessoas.heranca.PessoasVivas;

public class Adm extends PessoasVivas{
    private String cargo, dataContratacao;

    public String getCargo(){
        return cargo;
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    public String getDataContratacao(){
        return dataContratacao;
    }

    public void setDataContratacao(String dataContratacao){
        this.dataContratacao = dataContratacao;
    }
}