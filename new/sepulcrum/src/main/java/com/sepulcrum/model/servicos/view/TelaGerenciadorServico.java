package com.sepulcrum.model.servicos.view;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.sepulcrum.model.servicos.core.view.TelaServico;

import model.servicos.view.TelaRegistroServico;
import model.servicos.view.TelaSelectServico;

public class TelaGerenciadorServico extends JFrame{
    protected JButton jbOne, jbTwo, jbThree, jbFour, jbFive, jbVoltar;
    protected int fWidth, fHeight, qtdBotoes;

    public TelaGerenciadorServico(int seletor){
        inicializarVariaveis(seletor);

        // Janela
        this.setLayout(null);
        this.setSize(fWidth, fHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        // Config dos tamanho dos botões e centralização 
        int jbHeight = 30;
        int jbWidth = 190;
        int jbX = (fWidth - jbWidth) / 2;

        // Config centralização dos botões
        int y = (fHeight / (qtdBotoes + 1) - (jbHeight / 2));
        if(y < 30){ y = 30; }

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
                defineBotoes(seletor, button, index, jbX, jbY, jbWidth, jbHeight);
            }
        };

        this.setVisible(true);
    }
    
    protected void defineBotoes(int seletor, JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(_ -> {
            switch(index){
                case 0 -> new TelaRegistroServico(seletor, 1, -1);
                case 1 -> new TelaSelectServico(seletor, 2);
                case 2 -> new TelaSelectServico(seletor, 3);
                case 3 -> new TelaSelectServico(seletor, 4);
                case 4 -> new TelaServico();
            }
            dispose();
        });
        this.add(button);
    }

    protected void inicializarVariaveis(int seletor){
        //Configura tamanho da janela e botões
        fWidth = 300;
        fHeight = 350;
        qtdBotoes = 5;
        
        switch(seletor){
            case 1:
                // Janela
                this.setTitle("Menu Exumação");
                
                // Button
                jbOne = new JButton("Cadastrar Exumação.");
                jbTwo = new JButton("Apresentar Exumação.");
                jbThree = new JButton("Alterar Exumação.");
                jbFour = new JButton("Deletar Exumação.");
                jbVoltar = new JButton("Voltar");
                break;
            case 2:
                // Janela
                this.setTitle("Menu Manutenção");
                
                // Button
                jbOne = new JButton("Cadastrar Manutenção.");
                jbTwo = new JButton("Apresentar Manutenção.");
                jbThree = new JButton("Alterar Manutenção.");
                jbFour = new JButton("Deletar Manutenção.");
                jbVoltar = new JButton("Voltar");
                break;
            case 3:
                // Janela
                this.setTitle("Menu Reserva");
                
                // Button
                jbOne = new JButton("Cadastrar Reserva.");
                jbTwo = new JButton("Apresentar Reserva.");
                jbThree = new JButton("Alterar Reserva.");
                jbFour = new JButton("Deletar Reserva.");
                jbVoltar = new JButton("Voltar");
                break;
            case 4:
                // Janela
                this.setTitle("Menu Transferencia");

                // Button
                jbOne = new JButton("Cadastrar Transferencia.");
                jbTwo = new JButton("Apresentar Transferencia.");
                jbThree = new JButton("Alterar Transferencia.");
                jbFour = new JButton("Deletar Transferencia.");
                jbVoltar = new JButton("Voltar");
                break;
            case 5:
                // Janela
                this.setTitle("Menu Vistoria");

                // Button
                jbOne = new JButton("Cadastrar Vistoria.");
                jbTwo = new JButton("Apresentar Vistoria.");
                jbThree = new JButton("Alterar Vistoria.");
                jbFour = new JButton("Deletar Vistoria.");
                jbVoltar = new JButton("Voltar");
                break;
        }
    }
}
