package domain.servicos.manutencaoTumulo.gerenciador;

import java.util.Scanner;

import core.utils.TelaMenu;
import domain.servicos.manutencaoTumulo.ManutencaoTumulo;

public class TelaManutencaoTumulo extends TelaMenu{
    public TelaManutencaoTumulo(Scanner teclado) {
        super(teclado);
    }

    @Override
    public int menu() {
        System.out.println("Menu");
        System.out.println("1 - Cadastrar Manutencao Tumular");
        System.out.println("2 - Apresentar Manutencao Tumular.");
        System.out.println("3 - Listar Manutencao Tumular.");
        System.out.println("4 - Alterar Manutencao Tumular.");
        System.out.println("5 - Deletar Manutencao Tumular.");
        System.out.println("0 - Voltar");
        int opc = teclado.nextInt(); teclado.nextLine();

        return opc;
    }

    public void setManutencaoTumulo(ManutencaoTumulo mt){
        System.out.println("Digite a data do serviço");
        mt.setDataServico(teclado.nextLine());
        System.out.println("Digite a descrição da serviço: ");
        mt.setDescricao(teclado.nextLine());
        System.out.println("Digite as Informações Adicionais: ");
        mt.setInformacoesAdicionais(teclado.nextLine());
        System.out.println("Digite o status do serviço: ");
        mt.setStatusServico(teclado.nextLine());
        System.out.println("Digite o id do responsável: ");
        mt.setIdResponsavelServico(teclado.nextInt()); teclado.nextLine();
        System.out.println("Digite o id do Túmulo: ");
        mt.setIdTumulo(teclado.nextInt()); teclado.nextLine();
    }

    public void getManutencaoTumulo(ManutencaoTumulo mt){
        if(mt != null){
            System.out.println("A data de serviço: " + mt.getDataServico());
            System.out.println("A descrição do serviço: " + mt.getDescricao());
            System.out.println("As informações adicionais: " + mt.getInformacoesAdicionais());
            System.out.println("O status do serviço: " + mt.getStatusServico());
            System.out.println("O id do responsável pelo serviço: " + mt.getIdResponsavelServico());
            System.out.println("O id do túmulo: " + mt.getIdTumulo());
        } else {
            msgIdInexistente();
        }
    }   
}