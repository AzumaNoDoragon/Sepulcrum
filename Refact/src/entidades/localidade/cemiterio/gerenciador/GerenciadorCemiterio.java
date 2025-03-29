package entidades.localidade.cemiterio.gerenciador;

import entidades.localidade.cemiterio.Cemiterio;

public class GerenciadorCemiterio {
    private final TelaCemiterio tc;
    private Cemiterio c;
    private final DAOCemiterio daoC;

    public GerenciadorCemiterio(){
        System.out.println("Passo 1: ");
        tc = new TelaCemiterio(null);
        c = new Cemiterio(null, 0, 0, null, null, null, 0, 0, 0);
        daoC = new DAOCemiterio();
    }

    


}
