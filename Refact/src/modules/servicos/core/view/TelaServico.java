package modules.servicos.core.view;

import javax.swing.JButton;
import core.utils.TelaMenu;
import core.view.TelaGerenciador;
import modules.servicos.view.TelaGerenciadorServico;

public class TelaServico extends TelaMenu{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(e -> {
            switch(index){
                case 0 -> new TelaGerenciadorServico(1);
                case 1 -> new TelaGerenciadorServico(2);
                case 2 -> new TelaGerenciadorServico(3);
                case 3 -> new TelaGerenciadorServico(4);
                case 4 -> new TelaGerenciadorServico(5);
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
}