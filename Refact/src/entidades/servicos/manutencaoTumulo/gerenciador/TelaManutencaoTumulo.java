package entidades.servicos.manutencaoTumulo.gerenciador;

import java.util.Scanner;
import entidades.servicos.manutencaoTumulo.ManutencaoTumulo;
import gerenciadorPrincipal.heranca.TelaDefenicoes;

public class TelaManutencaoTumulo extends TelaDefenicoes{
    public TelaManutencaoTumulo(Scanner teclado) {
        super(teclado);
    }

    @Override
    public int menu() {
        throw new UnsupportedOperationException("Unimplemented method 'menu'");
    }

    public void setManutencaoTumulo(ManutencaoTumulo mt){
        System.out.println("Implementar");
    }

    public void getManutencaoTumulo(ManutencaoTumulo mt){
        System.out.println("Implementar");
    }
}