package entidades.pessoas;

public abstract class PessoasVivas extends Pessoas{
    protected String email;
    protected int telefone;

    public PessoasVivas(String nome, int id, int cpf, int rg, int dataNascimento, String email, int telefone) {
        super(nome, id, cpf, rg, dataNascimento);
        this.email = email;
        this.telefone = telefone;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public int getTelefone(){
        return telefone;
    }

    public void setTelefone(int telefone){
        this.telefone = telefone;
    }
}