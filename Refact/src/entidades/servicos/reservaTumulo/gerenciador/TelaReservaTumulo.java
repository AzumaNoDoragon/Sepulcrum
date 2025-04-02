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
        throw new UnsupportedOperationException("Unimplemented method 'menu'");
    }
    
    public void setReservaTumulo(ReservaTumulo rt){
        System.out.println("Implementar");
    }

    public void getReservaTumulo(ReservaTumulo rt){
        System.out.println("Implementar");
    }
}
