package gerenciadorPrincipal;

import java.util.Scanner;

public class TelaGerenciador{
    private Scanner teclado;

    public TelaGerenciador(Scanner teclado){
        this.teclado = teclado;
    }

    public int menu(){
        System.out.println("Menu");
        System.out.println("1 - Cadastrar Cemiterio");
        System.out.println("2 - Apresentar Cemiterio.");
        System.out.println("3 - Cadastrar Defunto.");
        System.out.println("4 - Requisitar serviço.");
        System.out.println("5 - Cadastrar");
        System.out.println("0 - Sair");

        return teclado.nextInt();
    }

    public void msgOpcInvalida(){
        System.out.println("Opção invalida!");
    }

    public void msgIdInexistente(){
        System.out.println("Id Inexistente no sistema!");
    }
    
    public void msgSaida(){
        System.out.println("Saindo do Sistema...");
    }

    public void msgSucesso(){
        System.out.println("Inserido no sistema!");
    }

    public int alterar(){
        System.out.println("Digite o id para alterar: ");
        return teclado.nextInt();
    }
}