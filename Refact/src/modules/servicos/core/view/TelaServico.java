package modules.servicos.core.view;

import javax.swing.JButton;
import core.utils.TelaMenu;
import core.view.TelaGerenciador;
import modules.servicos.view.TelaGerenciadorServico;

public class TelaServico extends TelaMenu{
    public int i;

    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(e -> {
            switch(index){
                case 0 -> { setI(1); new TelaGerenciadorServico();}
                case 1 -> { setI(2); new TelaGerenciadorServico();}
                case 2 -> { setI(3); new TelaGerenciadorServico();}
                case 3 -> { setI(4); new TelaGerenciadorServico();}
                case 4 -> { setI(5); new TelaGerenciadorServico();}
                case 5 -> new TelaGerenciador();
            }
            dispose();
        });
        this.add(button);
    }

    @Override
    protected void inicializarVariaveis(){
        //Configura tamanho da janela e botões
        fWidth = 300;
        fHeight = 400;
        qtdBotoes = 6;
        
        // Janela
        this.setTitle("Menu Serviços");

        // Button
        jbOne = new JButton("Exumação.");
        jbTwo = new JButton("Manutenção.");
        jbThree = new JButton("Reserva.");
        jbFour = new JButton("Transferencia.");
        jbFive = new JButton("Vistoria.");
        jbVoltar = new JButton("Voltar");
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}