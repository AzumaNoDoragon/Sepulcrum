package entidades.localidade.tumulo.gerenciador;

import java.util.Scanner;

import entidades.localidade.tumulo.controle.CRUDTumulo;

public class GerenciadorTumulo {
    private final TelaTumulo tt = new TelaTumulo(new Scanner(System.in));
    private final CRUDTumulo cruT = new CRUDTumulo();

    public void executar(){
        int opc;
        do{
            opc = tt.menu();

            switch (opc) {
                case 1:
                    cruT.create();
                    break;
                case 2:
                    cruT.read();
                    break;
                case 3:
                    cruT.listarTumulo();
                    break;
                case 4:
                    cruT.update();
                    break;
                case 5:
                    cruT.delete();
                    break;
                default:
                    break;
            }
        }
    }

}
