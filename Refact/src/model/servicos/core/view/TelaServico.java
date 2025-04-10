package model.servicos.core.view;

import javax.swing.JButton;
import core.utils.TelaMenu;
import core.view.TelaGerenciador;
import model.servicos.view.TelaGerenciadorServico;

public class TelaServico extends TelaMenu{
    @Override
    protected void button(int qtdBotoes, int y, int jbX, int jbWidth, int jbHeight){
        for(int i = 0; i < qtdBotoes; i++){
            int jbY = y * (i + 1);
            int index = i;
            JButton button = switch (index){
                case 0 -> jbOne;
                case 1 -> jbTwo;
                case 2 -> jbThree;
                case 3 -> jbFour;
                case 4 -> jbFive;
                case 5 -> jbVoltar;
                default -> null;
            };
            if(button != null){
                defineBotoes(button, index, jbX, jbY, jbWidth, jbHeight);
            }
        };
    }

    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(e -> {
            switch(index){
                case 0 -> new TelaGerenciadorServico(1); // Exumação
                case 1 -> new TelaGerenciadorServico(2); // Manutenção
                case 2 -> new TelaGerenciadorServico(3); // Reserva
                case 3 -> new TelaGerenciadorServico(4); // Transferencia
                case 4 -> new TelaGerenciadorServico(5); // vistoria
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