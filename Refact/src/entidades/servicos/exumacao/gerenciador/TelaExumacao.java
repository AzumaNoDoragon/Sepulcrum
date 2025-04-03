package entidades.servicos.exumacao.gerenciador;

import java.util.Scanner;
import entidades.servicos.exumacao.Exumacao;
import gerenciadorPrincipal.heranca.TelaDefenicoes;

public class TelaExumacao extends TelaDefenicoes{
    public TelaExumacao(Scanner teclado) {
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

    public void setExumacao(Exumacao e){
        System.out.println("Digite a data do serviço: ");
        e.setDataServico(teclado.nextLine());
        System.out.println("Digite o status do serviço: ");
        e.setStatusServico(teclado.nextLine());
        System.out.println("Digite a descrição: ");
        e.setDescricao(teclado.nextLine());
        System.out.println("Digite as informações adicionais: ");
        e.setInformacoesAdicionais(teclado.nextLine());
        System.out.println("Digite o id do responsável pelo serviço: ");
        e.setIdResponsavelServico(teclado.nextInt()); teclado.nextLine();
        System.out.println("Digite o id do túmulo: ");
        e.setIdTumulo(teclado.nextInt()); teclado.nextLine();
        System.out.println("Digite o id do finado: ");
        e.setIdDefunto(teclado.nextInt()); teclado.nextLine();
    }

    public void getExumacao(Exumacao e){
        if(e != null){
            System.out.println("A data de serviço: " + e.getDataServico());
            System.out.println("O status do serviço: " + e.getStatusServico());
            System.out.println("A descrição do serviço: " + e.getDescricao());
            System.out.println("As informações adicionais: " + e.getInformacoesAdicionais());
            System.out.println("O id do responsável pelo serviço: " + e.getIdResponsavelServico());
            System.out.println("O id do túmulo: " + e.getIdTumulo());
            System.out.println("O id do finado: " + e.getIdDefunto());
        } else {
            msgIdInexistente();
        }
    }
}