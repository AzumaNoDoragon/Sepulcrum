package entidades.pessoas.parente.controle;

import entidades.pessoas.parente.Parente;
import entidades.pessoas.parente.gerenciador.TelaParente;

public class CRUDParente {
    private final TelaParente tp = new TelaParente();
    private final Parente[] lista = new Parente[5];

    public void create(){
        int pos = posVazia();

        if(pos >= 0){
            lista[pos] = new Parente();
            tp.setParente(lista[pos]);
        } else {
            tp.msgErro();
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
        int pos = tp.selecionar();

        if(lista[pos] != null){
            tp.getParente(lista[pos]);
        }
    }

    public void listar(){
        for(int i = 0; i < lista.length; i++){
            tp.getParente(lista[i]);
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
