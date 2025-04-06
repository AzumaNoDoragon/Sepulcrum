package core.controller;

import core.view.TelaGerenciador;
import modules.localidade.cemiterio.controller.GerenciadorCemiterio;
import modules.localidade.tumulo.controller.GerenciadorTumulo;
import modules.pessoas.adm.controller.GerenciadorAdm;
import modules.pessoas.finado.controller.GerenciadorFinado;
import modules.servicos.core.controller.GerenciadorServicos;

public class Gerenciador {
    private final GerenciadorCemiterio gc = new GerenciadorCemiterio();
    private final GerenciadorAdm ga = new GerenciadorAdm();
    private final GerenciadorTumulo gt = new GerenciadorTumulo();
    private final GerenciadorFinado gd = new GerenciadorFinado();
    private final GerenciadorServicos gs = new GerenciadorServicos();

    public void executar(){
        int opc;
        do{
            new TelaGerenciador();
            opc = 1;

            switch (opc) {
                case 1:
                    gc.executar();
                    break;
                case 2:
                    ga.executar();
                    break;
                case 3:
                    gt.executar();
                    break;
                case 4:
                    gd.executar();
                    break;
                case 5:
                    gs.executar();
                    break;
                case 0:
                    //tg.msgSaida();
                    break;
                default:
                    if(opc != 0){
                        //tg.msgOpcInvalida();
                    }
                    break;
            }
        }while (opc != 0);
    }
}