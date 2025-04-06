package domain.pessoas.finado.controller;

import java.util.Scanner;

import domain.pessoas.finado.view.TelaFinado;

public class GerenciadorFinado {
    private final TelaFinado td = new TelaFinado(new Scanner(System.in));
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
