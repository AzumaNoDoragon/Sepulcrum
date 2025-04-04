package entidades.pessoas.adm.controle;

import java.util.Scanner;
import entidades.pessoas.adm.Adm;
import entidades.pessoas.adm.gerenciador.TelaGerenciadorAdm;

public class CRUDAdm {
    private final TelaGerenciadorAdm td = new TelaGerenciadorAdm(new Scanner(System.in));
    private final Adm[] lista = new Adm[5];
    
    public void create(){
        int pos = posVazia();

        if(pos >= 0){
            lista[pos] = new Adm();
            td.setAdm(lista[pos]);
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
            td.getAdm(lista[pos]);
        }
    }

    public void listar(){
        for(int i = 0; i < lista.length; i++){
            td.getAdm(lista[i]);
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
