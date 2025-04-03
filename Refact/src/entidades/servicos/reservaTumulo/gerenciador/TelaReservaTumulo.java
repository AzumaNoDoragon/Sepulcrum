package entidades.servicos.reservaTumulo.gerenciador;

import java.util.Scanner;

import entidades.servicos.reservaTumulo.ReservaTumulo;
import gerenciadorPrincipal.heranca.TelaDefenicoes;

public class TelaReservaTumulo extends TelaDefenicoes{
    public TelaReservaTumulo(Scanner teclado) {
        super(teclado);
    }

    @Override
    public int menu() {
        System.out.println("Menu");
        System.out.println("1 - Cadastrar reserva de túmulo.");
        System.out.println("2 - Apresentar reserva de túmulo..");
        System.out.println("3 - Listar reserva de túmulo..");
        System.out.println("4 - Alterar reserva de túmulo..");
        System.out.println("5 - Deletar reserva de túmulo..");
        System.out.println("0 - Voltar");
        int opc = teclado.nextInt(); teclado.nextLine();

        return opc;
    }
    
    public void setReservaTumulo(ReservaTumulo rt){
        System.out.println("Digite a data do serviço: ");
        rt.setDataServico(teclado.nextLine());
        System.out.println("Digite a descrição: ");
        rt.setDescricao(teclado.nextLine());
        System.out.println("Digite as informações adicionais: ");
        rt.setInformacoesAdicionais(teclado.nextLine());
        System.out.println("Digite o status do serviço: ");
        rt.setStatusServico(teclado.nextLine());
        System.out.println("Digite o id do responsável pelo serviço: ");
        rt.setIdResponsavelServico(teclado.nextInt()); teclado.nextLine();
        System.out.println("Digite o id do túmulo: ");
        rt.setIdTumulo(teclado.nextInt()); teclado.nextLine();
        System.out.println("Digite o id da Comprador: ");
        rt.setIdPessoa(teclado.nextInt()); teclado.nextLine();
    }

    public void getReservaTumulo(ReservaTumulo rt){
        if(rt != null){
            System.out.println("A data de serviço: " + rt.getDataServico());
            System.out.println("A descrição do serviço: " + rt.getDescricao());
            System.out.println("As informações adicionais: " + rt.getInformacoesAdicionais());
            System.out.println("O status do serviço: " + rt.getStatusServico());
            System.out.println("O id do responsável pelo serviço: " + rt.getIdResponsavelServico());
            System.out.println("O id do túmulo: " + rt.getIdTumulo());
            System.out.println("O id do Comprador: " + rt.getIdPessoa());
        } else {
            msgIdInexistente();
        }
    }
}