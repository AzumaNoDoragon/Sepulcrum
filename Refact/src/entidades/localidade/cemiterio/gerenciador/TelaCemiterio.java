package entidades.localidade.cemiterio.gerenciador;

import java.util.Scanner;

import entidades.localidade.cemiterio.Cemiterio;
import entidades.localidade.heranca.gerenciador.TelaLocalidade;

public class TelaCemiterio extends TelaLocalidade{
    private Cemiterio c = new Cemiterio(null, 0, 0, null, null, null, 0, 0, 0);

    public TelaCemiterio(Scanner teclado) {
        super(teclado);
    }

    public void setCemiterio(){
        System.out.println("Digite o nome do cemiterio: ");
        c.setNome(teclado.nextLine());
        System.out.println("Digite o estado: ");
        c.setEstado(teclado.nextLine());
        System.out.println("Digite o cidade: ");
        c.setCidade(teclado.nextLine());
        System.out.println("Digite o capacidade máxima: ");
        c.setCapacidadeMax(teclado.nextInt());
        System.out.println("Digite o telefone: ");
        c.setTelefone(teclado.nextInt());
        System.out.println("Digite o cep: ");
        c.setCep(teclado.nextInt());
        System.out.println("Nome do cemiterio: " + c.getNome());
        System.out.println("Estado: " + c.getEstado());
        System.out.println("Cidade: " + c.getCidade());
        System.out.println("Capacidade máxima: " + c.getCapacidadeMax());
        System.out.println("Telefone: " + c.getTelefone());
        System.out.println("Cep: " + c.getCep());
    }
    
    /* 
    public void getCemiterio(Cemiterio c){ //Implementar objeto no parametro
        System.out.println("Qual id do cemiterio que deseja verificar: ");
        int opc = teclado.nextInt();
        if(c != null){ // Trocar teclado pela instancia
            System.out.println("Nome do cemiterio: " + c.getNome());
            System.out.println("Estado: " + c.getEstado());
            System.out.println("Cidade: " + c.getCidade());
            System.out.println("Capacidade máxima: " + c.getCapacidadeMax());
            System.out.println("Telefone: " + c.getTelefone());
            System.out.println("Cep: " + c.getCep());
        } else {
            System.out.println("Id inexistente!");
        }
    }
        */
}
