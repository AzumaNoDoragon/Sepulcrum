package entidades.localidade.telas;

import java.util.Scanner;

public class TelaCemiterio extends TelaLocalidade{
    public TelaCemiterio(Scanner teclado) {
        super(teclado);
    }

    public void setCemiterio(){
        System.out.println("Digite o nome do cemiterio: ");
        // Instanciar variavel
        System.out.println("Digite o estado: ");
        // Instanciar variavel
        System.out.println("Digite o cidade: ");
        // Instanciar variavel
        System.out.println("Digite o capacidade máxima: ");
        // Instanciar variavel
        System.out.println("Digite o telefone: ");
        // Instanciar variavel
        System.out.println("Digite o cep: ");
        // Instanciar variavel
    }
    
    public void apresentar(){ //Implementar objeto no parametro
        if(teclado != null){ // Trocar teclado pela instancia
            System.out.println("Nome do cemiterio: " + teclado);
            System.out.println("Estado: " + teclado);
            System.out.println("Cidade: " + teclado);
            System.out.println("Capacidade máxima: " + teclado);
            System.out.println("Telefone: " + teclado);
            System.out.println("Cep: " + teclado);
        }
    }
}
