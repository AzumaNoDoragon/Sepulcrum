package entidades.pessoas;

public class Defunto extends Pessoas {
    private String dataFalecimento, causaMorte;
    private int idParente, idTumulo;

    public Defunto(String nome, int id, int cpf, int rg, int dataNascimento, String dataFalecimento, String causaMorte,
            int idParente, int idTumulo) {
        super(nome, id, cpf, rg, dataNascimento);
        this.dataFalecimento = dataFalecimento;
        this.causaMorte = causaMorte;
        this.idParente = idParente;
        this.idTumulo = idTumulo;
    }

    public String getDataFalecimento(){
        return dataFalecimento;
    }

    public void setDataFalecimento(String dataFalecimento){
        this.dataFalecimento = dataFalecimento;
    }

    public String getCausaMorte(){
        return causaMorte;
    }

    public void getCausaMorte(String causaMorte){
        this.causaMorte = causaMorte;
    }

    public int getIdParente(){
        return idParente;
    }

    public void setIdParente(int idParente){
        this.idParente = idParente;
    }

    public int getIdTumulo(){
        return idTumulo;
    }

    public void setIdTumulo(int idTumulo){
        this.idTumulo = idTumulo;
    }
}
