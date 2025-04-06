package modules.pessoas.finado.controller;

import java.util.Scanner;

import modules.pessoas.finado.database.CRUDFinado;
import modules.pessoas.finado.view.TelaRegistroFinado;

public class GerenciadorFinado {
    private final TelaRegistroFinado td = new TelaRegistroFinado(new Scanner(System.in));
    private final CRUDFinado crudD = new CRUDFinado();

    public void executar(){
        int opc;
        do{
            opc = td.menu();

            switch (opc) {
                case 1:
                    crudD.create();
                    break;
                case 2:
                    crudD.read();
                    break;
                case 3:
                    crudD.listar();
                    break;
                case 4:
                    crudD.update();   
                    break;
                case 5:
                    crudD.delete();
                    break;
                default:
                    if(opc != 0){
                        td.msgOpcInvalida();
                    }
                    break;
            }
        }while(opc != 0);
    }
}
