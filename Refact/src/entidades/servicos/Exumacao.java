package entidades.servicos;

public class Exumacao extends ServicoTumulo {
    private String localExumacao, motivoExumacao;
    private int idDefunto;
    
    public Exumacao(int idTumulo, String localExumacao, String motivoExumacao, int idDefunto) {
        super(idTumulo);
        this.localExumacao = localExumacao;
        this.motivoExumacao = motivoExumacao;
        this.idDefunto = idDefunto;
    }

    public String getLocalExumacao() {
        return localExumacao;
    }

    public void setLocalExumacao(String localExumacao) {
        this.localExumacao = localExumacao;
    }

    public String getMotivoExumacao() {
        return motivoExumacao;
    }

    public void setMotivoExumacao(String motivoExumacao) {
        this.motivoExumacao = motivoExumacao;
    }

    public int getIdDefunto() {
        return idDefunto;
    }

    public void setIdDefunto(int idDefunto) {
        this.idDefunto = idDefunto;
    }
}
