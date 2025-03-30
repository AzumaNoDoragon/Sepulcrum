package entidades.localidade.cemiterio.gerenciador;

import java.util.Scanner;
import entidades.localidade.cemiterio.Cemiterio;
import gerenciadorPrincipal.heranca.TelaDefenicoes;

public class TelaCemiterio extends TelaDefenicoes{
    public TelaCemiterio(Scanner teclado) {
        super(teclado);
    }

    @Override
    public int menu(){
        System.out.println("Menu do Cemiterio: ");
        System.out.println("1 - Cadastrar Cemiterio.");
        System.out.println("2 - Apresentar Cemiterio.");
        System.out.println("3 - Listar Cemiterio.");
        System.out.println("4 - Alterar Cemiterio.");
        System.out.println("5 - Deletar Cemiterio.");
        System.out.println("0 - Voltar");

        return teclado.nextInt();
    }

    public void setCemiterio(Cemiterio c){
        teclado.nextLine();
        System.out.println("Digite o nome do cemiterio: ");
        c.setNome(teclado.nextLine());
        System.out.println("Digite o estado: ");
        c.setEstado(teclado.nextLine());
        System.out.println("Digite o cidade: ");
        c.setCidade(teclado.nextLine());
        System.out.println("Digite a rua: ");
        c.setRua(teclado.nextLine());
        System.out.println("Digite o número do lote: ");
        c.setNumero(teclado.nextInt()); teclado.nextLine();
        System.out.println("Digite o capacidade máxima: ");
        c.setCapacidadeMax(teclado.nextInt()); teclado.nextLine();
        System.out.println("Digite o telefone: ");
        c.setTelefone(teclado.nextLine());
        System.out.println("Digite o cep: ");
        c.setCep(teclado.nextLine());
        System.out.println("Id: " + c.getId());
        System.out.println("Nome do cemiterio: " + c.getNome());
        System.out.println("Estado: " + c.getEstado());
        System.out.println("Cidade: " + c.getCidade());
        System.out.println("Rua: " + c.getRua());
        System.out.println("Numero: " + c.getNumero());
        System.out.println("Capacidade máxima: " + c.getCapacidadeMax());
        System.out.println("Telefone: " + c.getTelefone());
        System.out.println("Cep: " + c.getCep());
    }
    
    public void getCemiterio(Cemiterio c){
        if(c != null){ 
            System.out.println("Nome do cemiterio: " + c.getNome());
            System.out.println("Estado: " + c.getEstado());
            System.out.println("Cidade: " + c.getCidade());
            System.out.println("Rua: " + c.getRua());
            System.out.println("Numero: " + c.getNumero());
            System.out.println("Capacidade máxima: " + c.getCapacidadeMax());
            System.out.println("Telefone: " + c.getTelefone());
            System.out.println("Cep: " + c.getCep());
        } else {
            msgIdInexistente();
        }
    }
}