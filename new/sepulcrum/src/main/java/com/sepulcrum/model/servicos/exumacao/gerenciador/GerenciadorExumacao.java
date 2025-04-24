package com.sepulcrum.model.servicos.exumacao.gerenciador;

import java.util.Scanner;

import com.sepulcrum.model.servicos.exumacao.controle.CRUDExumacao;

import model.servicos.exumacao.gerenciador.TelaExumacao;

public class GerenciadorExumacao {
    private TelaExumacao te = new TelaExumacao(new Scanner(System.in));
    private final CRUDExumacao crudE = new CRUDExumacao();

    public void executar(){
        int opc;
        do{
            opc = te.menu();

            switch (opc) {
                case 1:
                    crudE.create();
                    break;
                case 2:
                    crudE.read();
                    break;
                case 3:
                    crudE.listar();
                    break;
                case 4:
                    crudE.update();   
                    break;
                case 5:
                    crudE.delete();
                    break;
                case 0:
                    te.msgSaida();
                    break;
                default:
                    if(opc != 0){
                        te.msgOpcInvalida();
                    }
                    break;
            }
        }while (opc != 0);
    }
}