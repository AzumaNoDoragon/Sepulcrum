package gerenciadorPrincipal.heranca;

import java.util.Scanner;

public abstract class TelaDefenicoes {
    protected Scanner teclado;
    
    public TelaDefenicoes(Scanner teclado){
        this.teclado = teclado;
    }
    
    public abstract int menu();

    public void msgOpcInvalida(){
        System.out.println("Opção invalida!");
    }

    public void msgIdInexistente(){
        System.out.println("Id Inexistente no sistema!");
    }
    
    public void msgSaida(){
        System.out.println("Saindo do Sistema...");
    }

    public void msgRetornando(){
        System.out.println("Voltando para o menu anterior!");
    }

    public void msgSucesso(){
        System.out.println("Inserido no sistema!");
    }

    public void msgErro(){
        System.out.println("Erro!");
    }

    public int alterar(){
        System.out.println("Digite o id para alterar: ");
        return teclado.nextInt();
    }

    public int selecionar(){
        System.out.println("Digite o id: ");
        return teclado.nextInt();
    }
}