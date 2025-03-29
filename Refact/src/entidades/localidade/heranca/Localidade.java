package entidades.localidade.heranca;

public abstract class Localidade {
    protected String rua;
    protected int id, numero;

    public Localidade(String rua, int id, int numero) {
        this.rua = rua;
        this.id = id;
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}