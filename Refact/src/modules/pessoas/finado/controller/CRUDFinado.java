package modules.pessoas.finado.controller;

import java.util.Scanner;

import modules.pessoas.finado.model.Finado;
import modules.pessoas.finado.view.TelaFinado;

public class CRUDFinado {
    private final TelaFinado td = new TelaFinado(new Scanner(System.in));
    private final Finado[] lista = new Finado[5];

    public void create(){
        int pos = posVazia();

        if(pos >= 0){
            lista[pos] = new Finado();
            td.setDefunto(lista[pos]);
        } else {
            td.msgErro();
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
        int pos = td.selecionar();

        if(lista[pos] != null){
            td.getDefunto(lista[pos]);
        }
    }

    public void listar(){
        for(int i = 0; i < lista.length; i++){
            td.getDefunto(lista[i]);
            System.out.println("**********");
        }
    }

    public void update(){
        System.out.println("Crud do Cemiterio");
    }

    public void delete(){
        System.out.println("Crud do Cemiterio");        
    }
}