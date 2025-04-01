package entidades.pessoas.adm.gerenciador;

import java.util.Scanner;

import entidades.pessoas.adm.controle.CRUDAdm;

public class GerenciadorAdm {
    private final TelaAdm ta = new TelaAdm();
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
                    crudAdm.ListarAdm();
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
