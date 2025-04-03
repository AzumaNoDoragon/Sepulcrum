package entidades.servicos.gerenciadorServicos;

import java.util.Scanner;

import entidades.localidade.tumulo.gerenciador.GerenciadorTumulo;
import entidades.servicos.exumacao.gerenciador.GerenciadorExumacao;
import entidades.servicos.manutencaoTumulo.gerenciador.GerenciadorManutencaoTumulo;
import entidades.servicos.transferenciaDefunto.gerenciador.GerenciadorTransferenciaDefunto;
import entidades.servicos.vistoria.gerenciador.GerenciadorVistoria;

public class GerenciadorServicos {
    private TelaGerenciadorServicos tgs = new TelaGerenciadorServicos(new Scanner(System.in));
    private GerenciadorExumacao ge = new GerenciadorExumacao();
    private GerenciadorManutencaoTumulo gmt = new GerenciadorManutencaoTumulo();
    private GerenciadorTumulo gt = new GerenciadorTumulo();
    private GerenciadorTransferenciaDefunto gtd = new GerenciadorTransferenciaDefunto();
    private GerenciadorVistoria gv = new GerenciadorVistoria();

    public void executar(){
        int opc;
        do{
            opc = tgs.menu();

            switch (opc) {
                case 1:
                    ge.executar();
                    break;
                case 2:
                    gmt.executar();
                    break;
                case 3:
                    gt.executar();
                    break;
                case 4:
                    gtd.executar();
                    break;
                case 5:
                    gv.executar();
                    break;
                case 0:
                    tgs.msgRetornando();
                    break;
                default:
                    if(opc != 0){
                        tgs.msgOpcInvalida();
                    }
                    break;
            }
        }while (opc != 0);
    }
}