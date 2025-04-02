package entidades.pessoas.parente.gerenciador;

import java.util.Scanner;

import entidades.pessoas.parente.Parente;
import gerenciadorPrincipal.heranca.TelaDefenicoes;

public class TelaParente extends TelaDefenicoes{
    public TelaParente(Scanner teclado) {
        super(teclado);
    }

    @Override
    public int menu() {
        System.out.println("Menu de Parente: ");
        System.out.println("1 - Cadastrar Parente.");
        System.out.println("2 - Apresentar Parente.");
        System.out.println("3 - Listar Parente.");
        System.out.println("4 - Alterar Parente.");
        System.out.println("5 - Deletar Parente.");
        System.out.println("0 - Voltar");
        int opc = teclado.nextInt(); teclado.nextLine();

        return opc;
    }

    public void setParente(Parente p){
        System.out.println("Implementar");
    }

    public void getParente(Parente p){
        System.out.println("Implementar");
    }
}
/*
private String grauParentesco; email, telefone; nome, cpf, rg, dataNascimento;
    private int idDefunto;
*/