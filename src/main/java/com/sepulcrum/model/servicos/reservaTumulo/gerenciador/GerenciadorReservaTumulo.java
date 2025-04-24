package com.sepulcrum.model.servicos.reservaTumulo.gerenciador;
/* 
import java.util.Scanner;
import com.sepulcrum.model.servicos.reservaTumulo.controle.CRUDReservaTumulo;
import com.sepulcrum.model.servicos.reservaTumulo.gerenciador.TelaReservaTumulo;

public class GerenciadorReservaTumulo {
    private final TelaReservaTumulo trt = new TelaReservaTumulo(new Scanner(System.in));
    private final CRUDReservaTumulo crudRT = new CRUDReservaTumulo();


    public void executar(){
        int opc;
        do{
            opc = trt.menu();

            switch (opc) {
                case 1:
                    crudRT.create();
                    break;
                case 2:
                    crudRT.read();
                    break;
                case 3:
                    crudRT.listar();
                    break;
                case 4:
                    crudRT.update();   
                    break;
                case 5:
                    crudRT.delete();
                    break;
                case 0:
                    trt.msgSaida();
                    break;
                default:
                    if(opc != 0){
                        trt.msgOpcInvalida();
                    }
                    break;
            }
        }while (opc != 0);
    }
}
*/