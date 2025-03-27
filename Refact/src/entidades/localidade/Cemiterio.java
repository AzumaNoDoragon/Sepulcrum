package entidades.localidade;

public class Cemiterio extends Localidade {
    private String nome, estado, cidade;
    private int capacidadeMax, telefone, cep;

    public Cemiterio(String rua, int id, int numero, String nome, String estado, String cidade, int capacidadeMax,
            int telefone, int cep) {
        super(rua, id, numero);
        this.nome = nome;
        this.estado = estado;
        this.cidade = cidade;
        this.capacidadeMax = capacidadeMax;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCapacidadeMax() {
        return capacidadeMax;
    }

    public void setCapacidadeMax(int capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }
}