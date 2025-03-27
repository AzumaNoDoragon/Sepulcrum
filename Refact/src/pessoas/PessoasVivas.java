package pessoas;

public class PessoasVivas extends Pessoas{
    private String email;
    private int telefone;

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
