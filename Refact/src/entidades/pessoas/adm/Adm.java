package entidades.pessoas.adm;

import entidades.pessoas.heranca.PessoasVivas;

public class Adm extends PessoasVivas{
    private String cargo, dataContratacao;

    public Adm(String nome, int id, int cpf, int rg, int dataNascimento, String email, int telefone, String cargo,
            String dataContratacao) {
        super(nome, id, cpf, rg, dataNascimento, email, telefone);
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
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