package entidades.localidade.cemiterio.gerenciador;

import java.util.Scanner;
import entidades.localidade.cemiterio.controle.CRUDCemiterio;

public class GerenciadorCemiterio {
    private final TelaCemiterio tc = new TelaCemiterio(new Scanner(System.in));
    private final CRUDCemiterio crudC = new CRUDCemiterio();

    public void executar(){
        int opc;
        do{
            opc = tc.menu();

            switch (opc) {
                case 1:
                    crudC.create();
                    break;
                case 2:
                    crudC.read();
                    break;
                case 3:
                    crudC.listarCemiterio();
                    break;
                case 4:
                    crudC.update();   
                    break;
                case 5:
                    crudC.delete();
                    break;
                default:
                    if(opc != 0){
                        tc.msgOpcInvalida();
                    }
                    break;
            }
        }while (opc != 0);
    }
}
