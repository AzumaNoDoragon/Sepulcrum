package entidades.pessoas;

public class Parente extends PessoasVivas {
    private String grauParentesco;
    private int idDefunto;
    
    public Parente(String nome, int id, int cpf, int rg, int dataNascimento, String email, int telefone,
            String grauParentesco, int idDefunto) {
        super(nome, id, cpf, rg, dataNascimento, email, telefone);
        this.grauParentesco = grauParentesco;
        this.idDefunto = idDefunto;
    }

    public String getGrauParentesco(){
        return grauParentesco;
    }

    public void setGrauParentesco(String grauParentesco){
        this.grauParentesco = grauParentesco;
    }

    public int getIdDefunto(){
        return idDefunto;
    }

    public void setIdDefunto(int idDefunto){
        this.idDefunto = idDefunto;
    }
}
