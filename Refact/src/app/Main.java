package app;

import core.view.TelaGerenciador;
import modules.localidade.cemiterio.view.TelaRegistroCemiterio;
import modules.localidade.tumulo.view.TelaRegistroTumulo;

public class Main {
    public static void main(String[] args){
        //new TelaGerenciador();
        new TelaRegistroCemiterio();
        new TelaRegistroTumulo();
    }
}