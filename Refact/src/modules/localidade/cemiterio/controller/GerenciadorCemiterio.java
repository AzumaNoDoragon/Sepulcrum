package modules.localidade.cemiterio.controller;

import java.util.Scanner;

import modules.localidade.cemiterio.database.CRUDCemiterio;

public class GerenciadorCemiterio {
    private final TelaGerenciadorCemiterio tc = new TelaGerenciadorCemiterio(new Scanner(System.in));
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
                    crudC.listar();
                    break;
                case 4:
                    crudC.update();   
                    break;
                case 5:
                    crudC.delete();
                    break;
                case 0:
                    tc.msgRetornando();
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
