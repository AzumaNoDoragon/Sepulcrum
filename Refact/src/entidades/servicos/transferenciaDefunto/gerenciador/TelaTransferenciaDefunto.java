package entidades.servicos.transferenciaDefunto.gerenciador;

import java.util.Scanner;

import entidades.servicos.transferenciaDefunto.TransferenciaDefunto;
import gerenciadorPrincipal.heranca.TelaDefenicoes;

public class TelaTransferenciaDefunto extends TelaDefenicoes{
    public TelaTransferenciaDefunto(Scanner teclado) {
        super(teclado);
    }

    @Override
    public int menu() {
        System.out.println("Menu");
        System.out.println("1 - Cadastrar transferencia finado");
        System.out.println("2 - Apresentar transferencia finado.");
        System.out.println("3 - Listar transferencia finado.");
        System.out.println("4 - Alterar transferencia finado.");
        System.out.println("5 - Deletar transferencia finado.");
        System.out.println("0 - Voltar");
        int opc = teclado.nextInt(); teclado.nextLine();

        return opc;
    }

    public void setTransferenciaDefunto(TransferenciaDefunto tf){
        System.out.println("Digite a data do serviço: ");
        tf.setDataServico(teclado.nextLine());
        System.out.println("Digite o status do serviço: ");
        tf.setStatusServico(teclado.nextLine());
        System.out.println("Digite a descrição: ");
        tf.setDescricao(teclado.nextLine());
        System.out.println("Digite as informações adicionais: ");
        tf.setInformacoesAdicionais(teclado.nextLine());
        System.out.println("Digite o id do responsável pelo serviço: ");
        tf.setIdResponsavelServico(teclado.nextInt()); teclado.nextLine();
        System.out.println("Digite o id do finado: ");
        tf.setIdDefunto(teclado.nextInt()); teclado.nextLine();
        System.out.println("Digite o id do túmulo inicial: ");
        tf.setIdTumulo(teclado.nextInt()); teclado.nextLine();
        System.out.println("Digite o id do túmulo de destino: ");
        tf.setIdTumuloDestino(teclado.nextInt()); teclado.nextLine();
    }

    public void getTransferenciaDefunto(TransferenciaDefunto tf){
        if(tf != null){
            System.out.println("A data de serviço: " + tf.getDataServico());
            System.out.println("O status do serviço: " + tf.getStatusServico());
            System.out.println("A descrição do serviço: " + tf.getDescricao());
            System.out.println("As informações adicionais: " + tf.getInformacoesAdicionais());
            System.out.println("O id do responsável pelo serviço: " + tf.getIdResponsavelServico());
            System.out.println("O id do túmulo: " + tf.getIdTumulo());
            System.out.println("O id do finado: " + tf.getIdDefunto());
            System.out.println("O id do túmulo de destino: " + tf.getIdTumuloDestino());
        } else {
            msgIdInexistente();
        }
    }
    
}