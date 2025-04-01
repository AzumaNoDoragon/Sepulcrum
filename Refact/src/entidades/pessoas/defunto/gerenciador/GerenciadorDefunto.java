package entidades.pessoas.defunto.gerenciador;

import entidades.pessoas.defunto.controle.CRUDDefunto;

public class GerenciadorDefunto {
    private final TelaDefunto td = new TelaDefunto();
    private final CRUDDefunto crudD = new CRUDDefunto();

    public void executar(){
        int opc;
        do{
            opc = td.menu();

            switch (opc) {
                case 1:
                    crudD.create();
                    break;
                case 2:
                    crudD.read();
                    break;
                case 3:
                    crudD.listar();
                    break;
                case 4:
                    crudD.update();   
                    break;
                case 5:
                    crudD.delete();
                    break;
                default:
                    if(opc != 0){
                        td.msgOpcInvalida();
                    }
                    break;
            }
        }while(opc != 0);
    }
}
