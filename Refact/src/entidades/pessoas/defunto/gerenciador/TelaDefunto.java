package entidades.pessoas.defunto.gerenciador;

import java.util.Scanner;

import entidades.pessoas.defunto.Defunto;
import gerenciadorPrincipal.heranca.TelaDefenicoes;

public class TelaDefunto extends TelaDefenicoes{
    public TelaDefunto(Scanner teclado) {
        super(teclado);
    }

    @Override
    public int menu(){
        System.out.println("Menu do Finado: ");
        System.out.println("1 - Cadastrar Finado.");
        System.out.println("2 - Apresentar Finado.");
        System.out.println("3 - Listar Finado.");
        System.out.println("4 - Alterar Finado.");
        System.out.println("5 - Deletar Finado.");
        System.out.println("0 - Voltar");

        return teclado.nextInt();
    }

    public void setDefunto(Defunto d){
        teclado.nextLine();
        System.out.println("Digite o nome do Finados: ");
        d.setNome(teclado.nextLine());
        System.out.println("Digite o CPF: ");
        d.setCpf(teclado.nextLine());
        System.out.println("Digite o RG: ");
        d.setRg(teclado.nextLine());
        System.out.println("Digite a data de nascimento: ");
        d.setDataNascimento(teclado.nextLine());
        System.out.println("Digite a data de falecimento: ");
        d.setDataFalecimento(teclado.nextLine());
        System.out.println("Digite a causa da morte: ");
        d.setCausaMorte(teclado.nextLine());
        System.out.println("Digite o id do parente: ");
        d.setIdParente(teclado.nextInt());teclado.nextLine();
        System.out.println("Digite o id do tumulo: ");
        d.setIdTumulo(teclado.nextInt());teclado.nextLine();
    }
    
    public void getDefunto(Defunto d){
        if(d != null){
            System.out.println("nome do Finados" + d.getNome());
            System.out.println("CPF: " + d.getCpf());
            System.out.println("RG: " + d.getRg());
            System.out.println("data de nascimento" + d.getDataNascimento());
            System.out.println("data de falecimento" + d.getDataFalecimento());
            System.out.println("causa da morte" + d.getCausaMorte());
            System.out.println("id do parente" + d.getIdParente());
            System.out.println("id do tumulo" + d.getIdTumulo());
        } else {
            msgIdInexistente();
        }
    }
}
