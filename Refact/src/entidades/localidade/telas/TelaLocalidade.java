package entidades.localidade.telas;

import java.util.Scanner;

public abstract class TelaLocalidade {
    protected Scanner teclado;

    public TelaLocalidade(Scanner teclado){
        this.teclado = teclado;
    }

    public void setLocalidade(){
        System.out.println("Digite a rua: ");
        // Instanciar variavel rua
        System.out.println("Digite o numero: ");
        // Instanciar variavel numero
    }
    
    public void apresentar(){ //Implementar objeto no parametro
        if(teclado != null){ // Trocar teclado pela instancia
            System.out.println("Id: " + teclado);
            System.out.println("Rua: " + teclado);
            System.out.println("Numero: " + teclado);
        }
    }
}
