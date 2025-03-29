package gerenciador;

//import pessoas.*;
import java.util.Scanner;

public class Gerenciador {
    private TelaGerenciador tg = new TelaGerenciador(new Scanner(System.in));

    public void executar(){
        int opc;

        do{
            opc = tg.menu();

            switch (opc) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                
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