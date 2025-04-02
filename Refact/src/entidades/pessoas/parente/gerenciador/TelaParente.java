package entidades.pessoas.parente.gerenciador;

import java.util.Scanner;

import entidades.pessoas.parente.Parente;
import gerenciadorPrincipal.heranca.TelaDefenicoes;

public class TelaParente extends TelaDefenicoes{
    public TelaParente(Scanner teclado) {
        super(teclado);
    }

    @Override
    public int menu() {
        throw new UnsupportedOperationException("Unimplemented method 'menu'");
    }

    public void setParente(Parente p){
        System.out.println("Implementar");
    }

    public void getParente(Parente p){
        System.out.println("Implementar");
    }
}
