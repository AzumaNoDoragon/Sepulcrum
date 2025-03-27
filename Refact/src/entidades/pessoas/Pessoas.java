package entidades.pessoas;

public class Pessoas {
    private String nome;
    private int id, cpf, rg, dataNascimento;

    public Pessoas(String nome, int id, int cpf, int rg, int dataNascimento) {
        this.nome = nome;
        this.id = id;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public int getCpf(){
        return cpf;
    }
    
    public void setCpf(int cpf){
        this.cpf = cpf;
    }

    public int getRg(){
        return rg;
    }

    public void setRg(int rg){
        this.rg = rg;
    }

    public int getDataNascimento(){
        return dataNascimento;
    }

    public void setDataNascimento(int dataNascimento){
        this.dataNascimento = dataNascimento;
    }
}
