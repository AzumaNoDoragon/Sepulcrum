package entidades.localidade.cemiterio.gerenciador;

import java.util.Scanner;

public class GerenciadorCemiterio {
    private final TelaCemiterio tc = new TelaCemiterio(new Scanner(System.in));

    public void executar(){
        int opc;
        do{
            opc = tc.menu();

            switch (opc) {
                case 1:
                    // create
                    System.out.println("Crud do Cemiterio");
                    break;
                case 2:
                    // read
                    System.out.println("Crud do Cemiterio");
                    break;
                case 3:
                    // update
                    System.out.println("Crud do Cemiterio");
                    break;
                case 4:
                    // delete
                    System.out.println("Crud do Cemiterio");
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
