package entidades.localidade.heranca.gerenciador;

import java.util.Scanner;

public abstract class TelaLocalidade {
    protected Scanner teclado;

    public TelaLocalidade(Scanner teclado){
        this.teclado = teclado;
    }
}
