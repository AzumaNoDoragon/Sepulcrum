package entidades.localidade.telas;

import java.util.Scanner;

public class TelaTumulo extends TelaLocalidade{
    public TelaTumulo(Scanner teclado) {
        super(teclado);
    }

    public void setCemiterio(){
        System.out.println("Digite o tipo do tumulo: ");
        // Instanciar variavel
        System.out.println("Digite a data de ocupação: ");
        // Instanciar variavel
        System.out.println("Digite a situação: ");
        // Instanciar variavel
        System.out.println("Digite o id do cemiterio: ");
        // Instanciar variavel
        System.out.println("Digite o id do defunto: ");
        // Instanciar variavel
    }
    
    public void apresentar(){ //Implementar objeto no parametro
        if(teclado != null){ // Trocar teclado pela instancia
            System.out.println("Tipo do tumulo: " + teclado);
            System.out.println("Data de ocupação: " + teclado);
            System.out.println("Situação: " + teclado);
            System.out.println("Id do cemiterio: " + teclado);
            System.out.println("Id do defunto: " + teclado);
        }
    }

    // Implementar listar, caso mauloseu
}
