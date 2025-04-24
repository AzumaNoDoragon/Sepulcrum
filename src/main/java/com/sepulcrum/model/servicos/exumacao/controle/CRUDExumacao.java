package com.sepulcrum.model.servicos.exumacao.controle;
/* 
import java.util.Scanner;
import com.sepulcrum.model.servicos.exumacao.Exumacao;
import com.sepulcrum.model.servicos.exumacao.gerenciador.TelaExumacao;

public class CRUDExumacao{
    private final TelaExumacao te = new TelaExumacao(new Scanner(System.in));
    private final Exumacao[] lista = new Exumacao[5];

    public void create(){
        int pos = posVazia();

        if(pos >= 0){
            lista[pos] = new Exumacao();
            te.setExumacao(lista[pos]);
        } else {
            te.msgErro();
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
        int pos = te.selecionar();

        if(lista[pos] != null){
            te.getExumacao(lista[pos]);
        }
    }

    public void listar(){
        for(int i = 0; i < lista.length; i++){
            te.getExumacao(lista[i]);
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