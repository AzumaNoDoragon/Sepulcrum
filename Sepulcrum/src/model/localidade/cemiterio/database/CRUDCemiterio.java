package model.localidade.cemiterio.database;

import java.util.Scanner;

import model.localidade.cemiterio.gerenciador.TelaGerenciadorCemiterio;
import model.localidade.cemiterio.model.Cemiterio;

public class CRUDCemiterio {
    private final TelaGerenciadorCemiterio tc = new TelaGerenciadorCemiterio(new Scanner(System.in));
    private final Cemiterio[] lista = new Cemiterio[5];

    public void create(){
        int pos = posVazia();

        if(pos >= 0){
            lista[pos] = new Cemiterio();
            tc.setCemiterio(lista[pos]);
        } else {
            tc.msgErro();
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
        int pos = tc.selecionar();

        if(lista[pos] != null){
            tc.getCemiterio(lista[pos]);
        } else {
            tc.msgIdInexistente();
        }
    }

    public void listar(){
        for(int i = 0; i < lista.length; i++){
            tc.getCemiterio(lista[i]);
            System.out.println("***********");
        }
    }

    public void update(){
        int pos = tc.selecionar();

        if(lista[pos] != null){
            lista[pos] = new Cemiterio();
            tc.setCemiterio(lista[pos]);
            tc.msgAlteracao();
        } else {
            tc.msgIdInexistente();
        }
    }

    public void delete(){
        int pos = tc.selecionar();

        if(lista[pos] != null){
            lista[pos] = null;
            tc.msgDelecao();
        } else {
            tc.msgIdInexistente();
        }
    }
}