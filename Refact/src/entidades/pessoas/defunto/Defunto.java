package entidades.pessoas.defunto;

import entidades.pessoas.heranca.Pessoas;

public class Defunto extends Pessoas {
    private String dataFalecimento, causaMorte;
    private int idParente, idTumulo;
    
    public Defunto(String nome, int id, String cpf, String rg, String dataNascimento) {
        super(nome, id, cpf, rg, dataNascimento);
    }

    public String getDataFalecimento() {
        return dataFalecimento;
    }

    public void setDataFalecimento(String dataFalecimento) {
        this.dataFalecimento = dataFalecimento;
    }

    public String getCausaMorte() {
        return causaMorte;
    }

    public void setCausaMorte(String causaMorte) {
        this.causaMorte = causaMorte;
    }

    public int getIdParente() {
        return idParente;
    }

    public void setIdParente(int idParente) {
        this.idParente = idParente;
    }

    public int getIdTumulo() {
        return idTumulo;
    }

    public void setIdTumulo(int idTumulo) {
        this.idTumulo = idTumulo;
    }

}
