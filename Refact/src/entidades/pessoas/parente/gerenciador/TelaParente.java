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
        System.out.println("Digite o nome do Parente Responsável: ");
        p.setNome(teclado.nextLine());
        System.out.println("Digite o CPF: ");
        p.setCpf(teclado.nextLine());
        System.out.println("Digite o RG: ");
        p.setRg(teclado.nextLine());
        System.out.println("Digite a data de nascimento: ");
        p.setDataNascimento(teclado.nextLine());
        System.out.println("Digite o telefone: ");
        p.setTelefone(teclado.nextLine());
        System.out.println("Digite o e-mail: ");
        p.setEmail(teclado.nextLine());
        System.out.println("Digite o grau de parentesco: ");
        p.setGrauParentesco(teclado.nextLine());
        System.out.println("Digite o id do Finado");
        p.setIdDefunto(teclado.nextInt()); teclado.nextLine();
    }

    public void getParente(Parente p){
        if(p != null){
            System.out.println("O nome é: " + p.getNome());
            System.out.println("O CPF é: " + p.getCpf());
            System.out.println("O Rg é: " + p.getRg());
            System.out.println("A data de nascimento é: " + p.getDataNascimento());
            System.out.println("O telefone é: " + p.getTelefone());
            System.out.println("O e-mail é: " + p.getEmail());
            System.out.println("O grau de parentesco é: " + p.getGrauParentesco());
            System.out.println("O id do parente é: " + p.getIdDefunto());
        } else {
            msgIdInexistente();
        }
    }
}