package modules.servicos.gerenciadorServicos;

import javax.swing.JButton;
import core.utils.TelaMenu;

public class TelaGerenciadorServicos extends TelaMenu{

    /*public int menu(){
        System.out.println("Menu");
        System.out.println("1 - Informações de Exumação");
        System.out.println("2 - Informações de ManutençãoTumular.");
        System.out.println("3 - Informações de Tumulo.");
        System.out.println("4 - Informações de TransferênciadeTumulo.");
        System.out.println("5 - Informações de Vistoria.");
        System.out.println("0 - Voltar");

        return teclado.nextInt();
    }    */
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(e -> {
            switch(index){
                case 0 -> dispose();
                case 1 -> dispose();
                case 2 -> dispose();
                case 3 -> dispose();
                case 4 -> dispose();
            }
            dispose();
        });
        this.add(button);
    }

    @Override
    protected void inicializarVariaveis(){
        //Configura tamanho da janela e botões
        fWidth = 300;
        fHeight = 350;
        qtdBotoes = 5;
        
        // Janela
        this.setTitle("Menu Cemitério");

        // Button
        jbCreate = new JButton("
        jbRead = new JButton("
        jbUpdate = new JButton("
        jbDelete = new JButton("
        jbVoltar = new JButton("Voltar");
    }
}
