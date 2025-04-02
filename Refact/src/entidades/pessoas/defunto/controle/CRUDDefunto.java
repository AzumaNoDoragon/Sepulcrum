package entidades.pessoas.defunto.controle;

import entidades.pessoas.defunto.Defunto;
import entidades.pessoas.defunto.gerenciador.TelaDefunto;

public class CRUDDefunto {
    private final TelaDefunto td = new TelaDefunto();
    private final Defunto[] lista = new Defunto[5];

    public void create(){
        int pos = posVazia();

        if(pos >= 0){
            lista[pos] = new Defunto();
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