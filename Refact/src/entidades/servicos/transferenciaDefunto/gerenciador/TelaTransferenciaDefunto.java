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
        throw new UnsupportedOperationException("Unimplemented method 'menu'");
    }

    public void setTransferenciaDefunto(TransferenciaDefunto tf){
        System.out.println("Implementar");
    }

    public void getTransferenciaDefunto(TransferenciaDefunto tf){
        System.out.println("Implementar");
    }
    
}