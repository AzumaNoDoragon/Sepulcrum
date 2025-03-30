package entidades.localidade.cemiterio.gerenciador;

import java.util.Scanner;

import entidades.localidade.cemiterio.Cemiterio;

public class CRUD {
    private Scanner teclado;
    private final TelaCemiterio tc = new TelaCemiterio(new Scanner(System.in));
    private final Cemiterio[] lista = new Cemiterio[5];
    private final Cemiterio c = new Cemiterio(null, 0, 0, null, null, null, 0, 0, 0);

    public CRUD(Scanner teclado){
        this.teclado = teclado;
    }

    protected void create(){
        int pos = posVazia();

        if(pos >= 0 ){
            lista[pos] = new Cemiterio(null, pos, pos, null, null, null, pos, pos, pos);
            tc.setCemiterio(lista[pos]);
        } else {
            System.out.println("Erro!");
        }
    }

    private int posVazia(){
        for(int i = 0; i < lista.length; i++){
            if(lista[i] == null){
                return i;
            }
        }
        return -1;
    }

    public void read(){
        int pos = 

    }

    public void update(){

    }

    public void delete(){
        
    }
}
