package domain.servicos.gerenciadorServicos;

import java.util.Scanner;

import core.utils.TelaMenu;

public class TelaGerenciadorServicos extends TelaMenu{
    public TelaGerenciadorServicos(Scanner teclado) {
        super(teclado);
    }

    @Override
    public int menu(){
        System.out.println("Menu");
        System.out.println("1 - Informações de Exumação");
        System.out.println("2 - Informações de Manutenção Tumular.");
        System.out.println("3 - Informações de Tumulo.");
        System.out.println("4 - Informações de Transferência de Tumulo.");
        System.out.println("5 - Informações de Vistoria.");
        System.out.println("0 - Voltar");

        return teclado.nextInt();
    }    
}
