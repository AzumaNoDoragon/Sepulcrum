package entidades.servicos.vistoria.gerenciador;

import java.util.Scanner;
import entidades.servicos.vistoria.controle.CRUDVistoria;

public class GerenciadorVistoria {
    private final TelaVistoria tv = new TelaVistoria(new Scanner(System.in));
    private final CRUDVistoria crucV = new CRUDVistoria();

    public void executar(){
        int opc;
        do{
            opc = tv.menu();

            switch (opc) {
                case 1:
                    crucV.create();
                    break;
                case 2:
                    crucV.read();
                    break;
                case 3:
                    crucV.listar();
                    break;
                case 4:
                    crucV.update();   
                    break;
                case 5:
                    crucV.delete();
                    break;
                case 0:
                    tv.msgSaida();
                    break;
                default:
                    if(opc != 0){
                        tv.msgOpcInvalida();
                    }
                    break;
            }
        }while (opc != 0);
    }
}