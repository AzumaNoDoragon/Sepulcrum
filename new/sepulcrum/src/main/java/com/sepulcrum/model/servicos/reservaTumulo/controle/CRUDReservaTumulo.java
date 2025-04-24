package com.sepulcrum.model.servicos.reservaTumulo.controle;

import java.util.Scanner;

import com.sepulcrum.model.servicos.reservaTumulo.ReservaTumulo;
import com.sepulcrum.model.servicos.reservaTumulo.gerenciador.TelaReservaTumulo;

public class CRUDReservaTumulo {
    private final TelaReservaTumulo trt = new TelaReservaTumulo(new Scanner(System.in));
    private final ReservaTumulo[] lista = new ReservaTumulo[5];

    public void create(){
        int pos = posVazia();

        if(pos >= 0){
            lista[pos] = new ReservaTumulo();
            trt.setReservaTumulo(lista[pos]);
        } else {
            trt.msgErro();
        }
    }

    public int posVazia(){
        for(int i = 0; i < lista.length; i++){
            if(lista[i] == null){
                return i;
            }
        }
        return -1;
    }

    public void read(){
        int pos = trt.selecionar();

        if(lista[pos] != null){
            trt.getReservaTumulo(lista[pos]);
        }
    }

    public void listar(){
        for(int i = 0; i < lista.length; i++){
            trt.getReservaTumulo(lista[i]);
            System.out.println("***********");
        }
    }

    public void update(){
        System.out.println("Crud do Cemiterio");
    }

    public void delete(){
        System.out.println("Crud do Cemiterio");        
    }
}