package entidades.servicos;

public class Vistoria {
    private boolean realizadoVistoria;
    private String comentariosVistoria;
    
    public Vistoria(boolean realizadoVistoria, String comentariosVistoria) {
        this.realizadoVistoria = realizadoVistoria;
        this.comentariosVistoria = comentariosVistoria;
    }

    public boolean isRealizadoVistoria() {
        return realizadoVistoria;
    }

    public void setRealizadoVistoria(boolean realizadoVistoria) {
        this.realizadoVistoria = realizadoVistoria;
    }

    public String getComentariosVistoria() {
        return comentariosVistoria;
    }

    public void setComentariosVistoria(String comentariosVistoria) {
        this.comentariosVistoria = comentariosVistoria;
    }
}
