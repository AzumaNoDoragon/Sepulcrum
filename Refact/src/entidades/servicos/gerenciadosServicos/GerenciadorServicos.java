package entidades.servicos.gerenciadosServicos;

import java.util.Scanner;
import entidades.servicos.exumacao.gerenciador.TelaExumacao;
import entidades.servicos.manutencaoTumulo.gerenciador.TelaManutencaoTumulo;
import entidades.servicos.reservaTumulo.gerenciador.TelaReservaTumulo;
import entidades.servicos.transferenciaDefunto.gerenciador.TelaTransferenciaDefunto;
import entidades.servicos.vistoria.gerenciador.TelaVistoria;

public class GerenciadorServicos {
    private TelaGerenciadorServicos tgs = new TelaGerenciadorServicos(new Scanner(System.in));
    private TelaExumacao te = new TelaExumacao(new Scanner(System.in));
    private TelaManutencaoTumulo tmt = new TelaManutencaoTumulo(new Scanner(System.in));
    private TelaReservaTumulo trt = new TelaReservaTumulo(new Scanner(System.in));
    private TelaTransferenciaDefunto ttd = new TelaTransferenciaDefunto(new Scanner(System.in));
    private TelaVistoria tv = new TelaVistoria(new Scanner(System.in));

    public void executar(){
        int opc;
        do{
            opc = tgs.menu();

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
                    tg.msgSaida();
                    break;
                default:
                    if(opc != 0){
                        tg.msgOpcInvalida();
                    }
                    break;
            }
        }while (opc != 0);
    }
}
