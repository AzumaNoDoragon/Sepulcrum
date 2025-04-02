package entidades.servicos.exumacao.gerenciador;

import java.util.Scanner;
import entidades.servicos.exumacao.Exumacao;
import gerenciadorPrincipal.heranca.TelaDefenicoes;

public class TelaExumacao extends TelaDefenicoes{
    public TelaExumacao(Scanner teclado) {
        super(teclado);
    }

    @Override
    public int menu(){
        System.out.println("Menu");
        System.out.println("1 - Informações do Cemiterio");
        System.out.println("2 - Informações do Adm.");
        System.out.println("3 - Informações do Tumulo.");
        System.out.println("4 - Informações do Defunto.");
        System.out.println("5 - Informações de Serviços.");
        System.out.println("0 - Voltar");

        return teclado.nextInt();
    }

    public void setExumacao(Exumacao e){

    }

    public void getExumacao(Exumacao e){
        if(e != null){
            

        } else {
            msgIdInexistente();
        }
    }
}
