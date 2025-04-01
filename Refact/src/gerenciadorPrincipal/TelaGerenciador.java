package gerenciadorPrincipal;

import java.util.Scanner;

import gerenciadorPrincipal.heranca.tela.TelaDefenicoes;

public class TelaGerenciador extends TelaDefenicoes{
    public TelaGerenciador(Scanner teclado) {
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
}