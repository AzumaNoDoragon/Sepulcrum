package entidades.servicos.exumacao.gerenciador;

import entidades.servicos.exumacao.controle.CRUDExumacao;

public class GerenciadorExumacao {
    private TelaExumacao te = new TelaExumacao();
    private final CRUDExumacao crudE = new CRUDExumacao();

    public void executar(){
        int opc;
        do{
            opc = te.menu();

            switch (opc) {
                case 1:
                    crudE.create();
                    break;
                case 2:
                    crudE.read();
                    break;
                case 3:
                    crudE.listarExumacao();
                    break;
                case 4:
                    crudE.update();   
                    break;
                case 5:
                    crudE.delete();
                    break;
                case 0:
                    te.msgSaida();
                    break;
                default:
                    if(opc != 0){
                        te.msgOpcInvalida();
                    }
                    break;
            }
        }while (opc != 0);
    }
}