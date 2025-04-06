package modules.pessoas.adm.controller;

import java.util.Scanner;

import modules.pessoas.adm.view.TelaGerenciadorAdm;

public class GerenciadorAdm {
    private final TelaGerenciadorAdm ta = new TelaGerenciadorAdm(new Scanner(System.in));
    private final CRUDAdm crudAdm = new CRUDAdm();

    public void executar(){
        int opc;
        do{
            opc = ta.menu();

            switch (opc) {
                case 1:
                    crudAdm.create();
                    break;
                case 2:
                    crudAdm.read();
                    break;
                case 3:
                    crudAdm.listar();
                    break;
                case 4:
                    crudAdm.update();
                    break;
                case 5:
                    crudAdm.delete();
                    break;
                case 0:
                    ta.msgSaida();
                    break;
                default:
                    if(opc != 0){
                        ta.msgOpcInvalida();
                    }
                    break;
            }
        }while (opc != 0);
    }
}
