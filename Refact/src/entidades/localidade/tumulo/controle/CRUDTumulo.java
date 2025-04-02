package entidades.localidade.tumulo.controle;

import java.util.Scanner;
import entidades.localidade.tumulo.Tumulo;
import entidades.localidade.tumulo.gerenciador.TelaTumulo;

public class CRUDTumulo {
    private final TelaTumulo tt = new TelaTumulo(new Scanner(System.in));
    private final Tumulo[] lista = new Tumulo[5];

    public void create(){
        int pos = posVazia();

        if(pos >= 0){
            lista[pos] = new Tumulo();
            tt.setTumulo(lista[pos]);
        } else {
            tt.msgErro();
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
        int pos = tt.selecionar();

        if(lista[pos] != null){
            tt.getTumulo(lista[pos]);
        }
    }

    public void listar(){
        for(int i = 0; i < lista.length; i++){
            tt.getTumulo(lista[i]);
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
