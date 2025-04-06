package domain.servicos.transferenciaDefunto.controle;

import java.util.Scanner;

import domain.servicos.transferenciaDefunto.TransferenciaDefunto;
import domain.servicos.transferenciaDefunto.gerenciador.TelaTransferenciaDefunto;

public class CRUDTransferenciaDefunto {
    private final TelaTransferenciaDefunto ttd = new TelaTransferenciaDefunto(new Scanner(System.in));
    private final TransferenciaDefunto[] lista = new TransferenciaDefunto[5];

    public void create(){
        int pos = posVazia();

        if(pos >= 0){
            lista[pos] = new TransferenciaDefunto();
            ttd.setTransferenciaDefunto(lista[pos]);
        } else {
            ttd.msgErro();
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
        int pos = ttd.selecionar();

        if(lista[pos] != null){
            ttd.getTransferenciaDefunto(lista[pos]);
        }
    }

    public void listar(){
        for(int i = 0; i < lista.length; i++){
            ttd.getTransferenciaDefunto(lista[i]);
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