package entidades.pessoas.adm.gerenciador;

public class GerenciadorAdm {
    

    public void executar(){
        int opc;
        do{
            opc = tg.menu();

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
