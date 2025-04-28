package com.sepulcrum.model.servicos.model.vistoria.gerenciador;
/* 
import java.util.Scanner;
import com.sepulcrum.model.servicos.vistoria.Vistoria;
import com.sepulcrum.core.utils.TelaMenu;

public class TelaVistoria extends TelaMenu{
    public TelaVistoria(Scanner teclado) {
        super(teclado);
    }

    @Override
    public int menu() {
        System.out.println("Menu de Vistoria: ");
        System.out.println("1 - Cadastrar Vistoria.");
        System.out.println("2 - Apresentar Vistoria.");
        System.out.println("3 - Listar Vistoria.");
        System.out.println("4 - Alterar Vistoria.");
        System.out.println("5 - Deletar Vistoria.");
        System.out.println("0 - Voltar");
        int opc = teclado.nextInt(); teclado.nextLine();

        return opc;
    }

    public void setVistoria(Vistoria v){
        System.out.println("Digite a descrição da serviço: ");
        v.setDescricao(teclado.nextLine());
        System.out.println("Digite a data do serviço");
        v.setDataServico(teclado.nextLine());
        System.out.println("Digite o status do serviço: ");
        v.setStatusServico(teclado.nextLine());
        System.out.println("Digite as Informações Adicionais: ");
        v.setInformacoesAdicionais(teclado.nextLine());
        System.out.println("Digite o id do responsável: ");
        v.setIdResponsavelServico(teclado.nextInt()); teclado.nextLine();
        System.out.println("Digite o id do Túmulo: ");
        v.setIdTumulo(teclado.nextInt()); teclado.nextLine();
    }

    public void getVistoria(Vistoria v){
        if(v != null){
            System.out.println("A descrição do serviço: " + v.getDescricao());
            System.out.println("A data de serviço: " + v.getDataServico());
            System.out.println("O status do serviço: " + v.getStatusServico());
            System.out.println("As informações adicionais: " + v.getInformacoesAdicionais());
            System.out.println("O id do responsável pelo serviço: " + v.getIdResponsavelServico());
            System.out.println("O id do túmulo: " + v.getIdTumulo());
        } else {
            msgIdInexistente();
        }
    }
}
*/