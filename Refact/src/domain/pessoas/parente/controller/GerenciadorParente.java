package domain.pessoas.parente.controller;

import java.util.Scanner;

import domain.pessoas.parente.view.TelaParente;

public class GerenciadorParente {
    private final TelaParente tp = new TelaParente(new Scanner(System.in));
    private final CRUDParente crudP = new CRUDParente();

    public void executar(){
        int opc;
        do{
            opc = tp.menu();

            switch (opc) {
                case 1:
                    crudP.create();
                    break;
                case 2:
                    crudP.read();
                    break;
                case 3:
                    crudP.listar();
                    break;
                case 4:
                    crudP.update();   
                    break;
                case 5:
                    crudP.delete();
                    break;
                case 0:
                    tp.msgRetornando();
                    break;
                default:
                    if(opc != 0){
                        tp.msgOpcInvalida();
                    }
                    break;
            }
        }while (opc != 0);
    }
}