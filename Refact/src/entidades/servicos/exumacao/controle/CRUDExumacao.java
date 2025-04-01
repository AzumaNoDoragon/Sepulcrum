package entidades.servicos.exumacao.controle;

import java.util.Scanner;
import entidades.servicos.exumacao.Exumacao;
import entidades.servicos.exumacao.gerenciador.TelaExumacao;

public class CRUDExumacao{
    private final TelaExumacao te = new TelaExumacao(new Scanner(System.in));
    private final Exumacao[] lista = new Exumacao[5];

    public void create(){
        int pos = posVazia();

        if(pos >= 0){
            lista[pos] = new Exumacao(null, null, null, null, null, pos, pos, pos);
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

    public void listarExumacao(){
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