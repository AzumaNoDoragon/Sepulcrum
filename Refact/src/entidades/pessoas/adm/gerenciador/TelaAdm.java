package entidades.pessoas.adm.gerenciador;

import java.util.Scanner;
import gerenciadorPrincipal.heranca.TelaDefenicoes;

public class TelaAdm extends TelaDefenicoes{

    public TelaAdm(Scanner teclado) {
        super(teclado);
    }

    @Override
    public int menu() {
        System.out.println("Menu do Coveiro: ");
        System.out.println("1 - Cadastrar Coveiro.");
        System.out.println("2 - Apresentar Coveiro.");
        System.out.println("3 - Listar Coveiro.");
        System.out.println("4 - Alterar Coveiro.");
        System.out.println("5 - Deletar Coveiro.");
        System.out.println("0 - Voltar");

        return teclado.nextInt();
    }
}
