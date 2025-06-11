package com.sepulcrum.view.comum.utils;

import javax.swing.JButton;
import javax.swing.JFrame;

public abstract class TelaMenu extends JFrame{
    protected JButton jbOne, jbTwo, jbThree, jbFour, jbFive, jbVoltar;
    protected int fWidth, fHeight, qtdBotoes;

    public TelaMenu(){
        inicializarVariaveis();

        // Janela
        this.setLayout(null);
        this.setSize(fWidth, fHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        // Config dos tamanho dos botões e centralização 
        int jbHeight = 30;
        int jbWidth = 160;
        int jbX = (fWidth - jbWidth) / 2;

        // Config centralização dos botões
        int y = (fHeight / (qtdBotoes + 1) - (jbHeight / 2));
        if(y < 30){ y = 30; }

        button(qtdBotoes, y, jbX, jbWidth, jbHeight);
       
        this.setVisible(true);
    }

    protected void button(int qtdBotoes, int y, int jbX, int jbWidth, int jbHeight){
        for(int i = 0; i < qtdBotoes; i++){
            int jbY = y * (i + 1);
            int index = i;
            JButton button = switch (index){
                case 0 -> jbOne;
                case 1 -> jbTwo;
                case 2 -> jbThree;
                case 3 -> jbFour;
                case 4 -> jbVoltar;
                default -> null;
            };
            if(button != null){
                defineBotoes(button, index, jbX, jbY, jbWidth, jbHeight);
            }
        };
    }
    
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(_ -> {
            switch(index){
                case 0 -> dispose(); // TROCAR ENTIDADE
                case 1 -> dispose(); // TROCAR ENTIDADE
                case 2 -> dispose(); // TROCAR ENTIDADE
                case 3 -> dispose(); // TROCAR ENTIDADE
                case 4 -> dispose(); // TROCAR ENTIDADE
            }
            dispose();
        });
        this.add(button);
    }

    protected void inicializarVariaveis(){
        //Configura tamanho da janela e botões
        fWidth = 300;
        fHeight = 350;
        qtdBotoes = 5;

        // Janela
        this.setTitle("DEFINIR TÍTULO");

        // Button
        jbOne = new JButton();
        jbTwo = new JButton();
        jbThree = new JButton();
        jbFour = new JButton();
        jbVoltar = new JButton();
    }
}