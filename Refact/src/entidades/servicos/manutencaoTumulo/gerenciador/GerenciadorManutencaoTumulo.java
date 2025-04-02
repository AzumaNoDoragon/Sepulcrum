package entidades.servicos.manutencaoTumulo.gerenciador;

import java.util.Scanner;

import entidades.servicos.manutencaoTumulo.controle.CRUDManutencaoTumulo;

public class GerenciadorManutencaoTumulo {
    private final TelaManutencaoTumulo tmt = new TelaManutencaoTumulo(new Scanner(System.in));
    private final CRUDManutencaoTumulo crudMT = new CRUDManutencaoTumulo();

    public void executar(){
        int opc;
        do{
            opc = tmt.menu();

            switch (opc) {
                case 1:
                    crudMT.create();
                    break;
                case 2:
                    crudMT.read();
                    break;
                case 3:
                    crudMT.listar();
                    break;
                case 4:
                    crudMT.update();   
                    break;
                case 5:
                    crudMT.delete();
                    break;
                case 0:
                    tmt.msgSaida();
                    break;
                default:
                    if(opc != 0){
                        tmt.msgOpcInvalida();
                    }
                    break;
            }
        }while (opc != 0);
    }
}