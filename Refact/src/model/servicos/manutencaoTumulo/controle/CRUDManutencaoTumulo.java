package model.servicos.manutencaoTumulo.controle;

import java.util.Scanner;

import model.servicos.manutencaoTumulo.ManutencaoTumulo;
import model.servicos.manutencaoTumulo.gerenciador.TelaManutencaoTumulo;

public class CRUDManutencaoTumulo {
    private final TelaManutencaoTumulo tmt = new TelaManutencaoTumulo(new Scanner(System.in));
    private final ManutencaoTumulo[] lista = new ManutencaoTumulo[5];

    public void create(){
        int pos = posVazia();

        if(pos >= 0){
            lista[pos] = new ManutencaoTumulo();
            tmt.setManutencaoTumulo(lista[pos]);
        } else {
            tmt.msgErro();
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
        int pos = tmt.selecionar();

        if(lista[pos] != null){
            tmt.getManutencaoTumulo(lista[pos]);
        }
    }

    public void listar(){
        for(int i = 0; i < lista.length; i++){
            tmt.getManutencaoTumulo(lista[i]);
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