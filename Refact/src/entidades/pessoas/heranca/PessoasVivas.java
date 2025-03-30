package entidades.pessoas.heranca;

public abstract class PessoasVivas extends Pessoas{
    protected String email, telefone;

    public PessoasVivas(String nome, int id, String cpf, String rg, String dataNascimento, String email, String telefone) {
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

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
}