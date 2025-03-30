package entidades.localidade.cemiterio.gerenciador;

import java.util.Scanner;

import entidades.localidade.cemiterio.controle.CRUDCemiterio;

public class GerenciadorCemiterio {
    private final TelaCemiterio tc = new TelaCemiterio(new Scanner(System.in));
    private final CRUDCemiterio crud = new CRUDCemiterio();

    public void executar(){
        int opc;
        do{
            opc = tc.menu();

            switch (opc) {
                case 1:
                    crud.create();
                    break;
                case 2:
                    crud.read();
                    break;
                case 3:
                    crud.listarCemiterio();
                    break;
                case 4:
                    crud.update();   
                    break;
                case 5:
                    crud.delete();
                    break;
                default:
                    if(opc != 0){
                        System.out.println("Opção invalida!");
                    }
                    break;
            }
        }while (opc != 0);
    }
}
