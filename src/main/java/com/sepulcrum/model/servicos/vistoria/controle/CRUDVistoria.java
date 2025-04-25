package com.sepulcrum.model.servicos.vistoria.controle;
/* 
import java.util.Scanner;
import com.sepulcrum.model.servicos.vistoria.Vistoria;
import com.sepulcrum.model.servicos.vistoria.gerenciador.TelaVistoria;

public class CRUDVistoria {
    private final TelaVistoria tv = new TelaVistoria(new Scanner(System.in));
    private final Vistoria[] lista = new Vistoria[5];

    public void create(){
        int pos = posVazia();

        if(pos >= 0){
            lista[pos] = new Vistoria();
            tv.setVistoria(lista[pos]);
        } else {
            tv.msgErro();
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
        int pos = tv.selecionar();

        if(lista[pos] != null){
            tv.getVistoria(lista[pos]);
        }
    }

    public void listar(){
        for(int i = 0; i < lista.length; i++){
            tv.getVistoria(lista[i]);
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
*/