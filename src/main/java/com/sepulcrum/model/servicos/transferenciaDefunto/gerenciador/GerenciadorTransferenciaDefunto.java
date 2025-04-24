package com.sepulcrum.model.servicos.transferenciaDefunto.gerenciador;
/* 
import java.util.Scanner;
import com.sepulcrum.model.servicos.transferenciaDefunto.controle.CRUDTransferenciaDefunto;
import com.sepulcrum.model.servicos.transferenciaDefunto.gerenciador.TelaTransferenciaDefunto;

public class GerenciadorTransferenciaDefunto {
    private final TelaTransferenciaDefunto ttd = new TelaTransferenciaDefunto(new Scanner(System.in));
    private final CRUDTransferenciaDefunto crudTD = new CRUDTransferenciaDefunto();

    public void executar(){
        int opc;
        do{
            opc = ttd.menu();

            switch (opc) {
                case 1:
                    crudTD.create();
                    break;
                case 2:
                    crudTD.read();
                    break;
                case 3:
                    crudTD.listar();
                    break;
                case 4:
                    crudTD.update();   
                    break;
                case 5:
                    crudTD.delete();
                    break;
                case 0:
                    ttd.msgSaida();
                    break;
                default:
                    if(opc != 0){
                        ttd.msgOpcInvalida();
                    }
                    break;
            }
        }while (opc != 0);
    }
}
*/