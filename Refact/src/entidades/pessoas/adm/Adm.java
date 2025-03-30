package entidades.pessoas.adm;

import entidades.pessoas.heranca.PessoasVivas;

public class Adm extends PessoasVivas{
    private String cargo, dataContratacao;

    public Adm(String nome, int id, String cpf, String rg, String dataNascimento, String email, String telefone) {
        super(nome, id, cpf, rg, dataNascimento, email, telefone);
    }

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