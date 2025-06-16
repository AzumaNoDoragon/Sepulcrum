package com.sepulcrum.view.comum;

import javax.swing.JButton;
import javax.swing.JFrame;
import com.sepulcrum.view.localidade.CemiterioView;
import com.sepulcrum.view.localidade.TumuloView;
import com.sepulcrum.view.pessoa.AdmView;
import com.sepulcrum.view.pessoa.FamiliarView;
import com.sepulcrum.view.pessoa.FinadoView;

public class TelaGerenciadorGeral extends JFrame{
    protected JButton jbOne, jbTwo, jbThree, jbFour, jbFive, jbVoltar;
    protected int fWidth, fHeight, qtdBotoes;

    public TelaGerenciadorGeral(int seletor){
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
                case 0 -> {
                    switch(seletor){
                        case 1 -> new CemiterioView(seletor, 1, "");
                        case 2 -> new AdmView(seletor, 1, "");
                        case 3 -> new TumuloView(seletor, 1, "", "", "");
                        case 4 -> new FinadoView(seletor, 1, "");
                        case 5 -> new FamiliarView(seletor, 1, "");
                    }
                }
                case 1 -> {
                    if(seletor != 3)
                        new TelaSelecao(seletor, 2);
                    else
                        new TelaSelecaoTumulo(seletor, 2);
                }
                case 2 -> {
                    if(seletor != 3)
                        new TelaSelecao(seletor, 3);
                    else
                        new TelaSelecaoTumulo(seletor, 3);
                }
                case 3 -> {
                    if(seletor != 3)
                        new TelaSelecao(seletor, 4);
                    else
                        new TelaSelecaoTumulo(seletor, 4);
                }
                case 4 -> new TelaPrincipal();
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
        
        switch(seletor) {
            case 1:
                // Janela
                this.setTitle("Menu Cemitério");

                // Button
                jbOne = new JButton("Cadastrar Cemitério.");
                jbTwo = new JButton("Apresentar Cemitério.");
                jbThree = new JButton("Alterar Cemitério.");
                jbFour = new JButton("Deletar Cemitério.");
                jbVoltar = new JButton("Voltar");
                break;
            case 2:
                // Janela
                this.setTitle("Menu Adm");

                // Button
                jbOne = new JButton("Cadastrar coveiro.");
                jbTwo = new JButton("Apresentar coveiro.");
                jbThree = new JButton("Alterar coveiro.");
                jbFour = new JButton("Deletar coveiro.");
                jbVoltar = new JButton("Voltar");
                break;
            case 3:
                // Janela
                this.setTitle("Menu Túmulo");

                // Button
                jbOne = new JButton("Cadastrar Túmulo.");
                jbTwo = new JButton("Apresentar Túmulo.");
                jbThree = new JButton("Alterar Túmulo.");
                jbFour = new JButton("Deletar Túmulo.");
                jbVoltar = new JButton("Voltar");
                break;
            case 4:
                // Janela
                this.setTitle("Menu Finado");

                // Button
                jbOne = new JButton("Cadastrar Finado.");
                jbTwo = new JButton("Apresentar Finado.");
                jbThree = new JButton("Alterar Finado.");
                jbFour = new JButton("Deletar Finado.");
                jbVoltar = new JButton("Voltar");
                break;
            case 5:
                // Janela
                this.setTitle("Menu familiar");

                // Button
                jbOne = new JButton("Cadastrar familiar.");
                jbTwo = new JButton("Apresentar familiar.");
                jbThree = new JButton("Alterar familiar.");
                jbFour = new JButton("Deletar familiar.");
                jbVoltar = new JButton("Voltar");
                break;
        } 
    }
}