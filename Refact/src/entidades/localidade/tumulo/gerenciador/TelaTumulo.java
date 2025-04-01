package entidades.localidade.tumulo.gerenciador;

import java.util.Scanner;
import entidades.localidade.tumulo.Tumulo;
import gerenciadorPrincipal.heranca.tela.TelaDefenicoes;

public class TelaTumulo extends TelaDefenicoes{
    public TelaTumulo(Scanner teclado) {
        super(teclado);
    }

    @Override
    public int menu(){
        System.out.println("Menu do Túmulo: ");
        System.out.println("1 - Cadastrar Túmulo.");
        System.out.println("2 - Apresentar Túmulo.");
        System.out.println("3 - Listar Túmulo.");
        System.out.println("4 - Alterar Túmulo.");
        System.out.println("5 - Deletar Túmulo.");
        System.out.println("0 - Voltar");

        return teclado.nextInt();
    }

    public void setTumulo(Tumulo t){
        teclado.nextLine();
        System.out.println("Digite o tipo do tumulo: ");
        t.setTipo(teclado.nextLine());
        System.out.println("Digite a data de ocupação: ");
        t.setDataOcupacao(teclado.nextLine());
        System.out.println("Digite a situação: ");
        t.setSituacao(teclado.nextLine());
        System.out.println("Digite o id do cemiterio: ");
        t.setIdCemiterio(teclado.nextInt()); teclado.nextLine();
        System.out.println("Digite o bloco do Tumulo: ");
        t.setRua(teclado.nextLine());
        System.out.println("Digite o número do Túmulo: ");
        t.setNumero(teclado.nextInt()); teclado.nextLine();
        System.out.println("Digite o id do defunto: ");
        t.setIdDefunto(teclado.nextInt()); teclado.nextLine();
    }
    
    public void getTumulo(Tumulo t){
        if(t != null){ // Trocar teclado pela instancia
            System.out.println("Tipo do tumulo: " + teclado);
            System.out.println("Data de ocupação: " + teclado);
            System.out.println("Situação: " + teclado);
            System.out.println("Id do cemiterio: " + teclado);
            System.out.println("Id do defunto: " + teclado);
        } else {
            msgIdInexistente();
        }
    }
}
