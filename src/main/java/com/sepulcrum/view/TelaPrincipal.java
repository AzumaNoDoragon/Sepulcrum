package com.sepulcrum.view;

import javax.swing.JButton;

import com.sepulcrum.model.servicos.view.TelaServico;
import com.sepulcrum.model.view.TelaGerenciadorGeral;
import com.sepulcrum.view.utils.TelaMenu;

public class TelaPrincipal extends TelaMenu{
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
        button.addActionListener(_ -> {
            switch(index){
                case 0 -> new TelaGerenciadorGeral(1);
                case 1 -> new TelaGerenciadorGeral(2);
                case 2 -> new TelaGerenciadorGeral(3);
                case 3 -> new TelaGerenciadorGeral(4);
                case 4 -> new TelaGerenciadorGeral(5);
                case 5 -> new TelaServico();
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
        this.setTitle("Menu Inicial");

        // Button
        jbOne = new JButton("Cemitério");
        jbTwo = new JButton("Adm");
        jbThree = new JButton("Túmulo");
        jbFour = new JButton("Finado");
        jbFive = new JButton("Familiar");
        jbVoltar = new JButton("Serviços");
    }
}