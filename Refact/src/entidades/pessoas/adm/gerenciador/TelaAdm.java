package entidades.pessoas.adm.gerenciador;

import java.util.Scanner;
import entidades.pessoas.adm.Adm;
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

    public void setAdm(Adm a){
        System.out.println("Digite seu nome: ");
        a.setNome(teclado.nextLine());
        System.out.println("Digite seu CPF: ");
        a.setCpf(teclado.nextLine());
        System.out.println("Digite seu RG: ");
        a.setRg(teclado.nextLine());
        System.out.println("Digite sua data de nascimento: ");
        a.setDataNascimento(teclado.nextLine());
        System.out.println("Digite seu e-mail: ");
        a.setEmail(teclado.nextLine());
        System.out.println("Digite seu telefone: ");
        a.setTelefone(teclado.nextLine());
        System.out.println("Digite seu cargo: ");
        a.setCargo(teclado.nextLine());
        System.out.println("Digite a data de contratação: ");
        a.setDataContratacao(teclado.nextLine());
    }

    public void getAdm(Adm a){
        if(a != null){
            System.out.println("Nome: " + a.getNome());
            System.out.println("CPF: " + a.getCpf());
            System.out.println("RG: " + a.getRg());
            System.out.println("Data de Contratação: " + a.getDataContratacao());
            System.out.println("Data de Nascimento: " + a.getDataNascimento());
            System.out.println("E-mail: " + a.getEmail());
            System.out.println("Telefone: " + a.getCargo());
            System.out.println("Data de Contratação: " + a.getDataContratacao());
        } else {
            msgIdInexistente();
        }
    }
}