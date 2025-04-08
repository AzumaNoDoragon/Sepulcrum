package modules.servicos.view;

import javax.swing.JButton;
import javax.swing.JFrame;

import modules.servicos.core.view.TelaServico;

public class TelaGerenciadorServico extends JFrame{
    protected JButton jbOne, jbTwo, jbThree, jbFour, jbFive, jbVoltar;
    protected int fWidth, fHeight, qtdBotoes;
    int seletor;

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
        int jbWidth = 160;
        int jbX = (fWidth - jbWidth) / 2;

        // Config centralização dos botões
        int y = (fHeight / (qtdBotoes + 1) - (jbHeight / 2));
        if(y < 30){ y = 30; }

        for(int i = 0; i < qtdBotoes; i++){
            int jbY = y * (i + 1);
            int index = i;
            JButton button = switch (index){
                case 0 -> jbOne; // ARRUMAR UMA FORMA DE TELAGERENCIADORSERVICO COLOCAR MAIS UM BOTÃO
                case 1 -> jbTwo; // ARRUMAR UMA FORMA DE TELAGERENCIADORSERVICO COLOCAR MAIS UM BOTÃO
                case 2 -> jbThree; // ARRUMAR UMA FORMA DE TELAGERENCIADORSERVICO COLOCAR MAIS UM BOTÃO
                case 3 -> jbFour; // ARRUMAR UMA FORMA DE TELAGERENCIADORSERVICO COLOCAR MAIS UM BOTÃO
                case 4 -> jbVoltar; // ARRUMAR UMA FORMA DE TELAGERENCIADORSERVICO COLOCAR MAIS UM BOTÃO
                default -> null; // ARRUMAR UMA FORMA DE TELAGERENCIADORSERVICO COLOCAR MAIS UM BOTÃO
            };
            if(button != null){
                defineBotoes(i, button, index, jbX, jbY, jbWidth, jbHeight);
            }
        };

        this.setVisible(true);
    }
    
    protected void defineBotoes(int seletor, JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(e -> {
            switch (seletor) {
                case 1:
                    switch(index){
                        case 0 -> dispose();
                        case 1 -> dispose();
                        case 2 -> dispose();
                        case 3 -> dispose();
                        case 4 -> new TelaServico();
                    }
                    break;
                case 2:
                    switch(index){
                        case 0 -> dispose();
                        case 1 -> dispose();
                        case 2 -> dispose();
                        case 3 -> dispose();
                        case 4 -> new TelaServico();
                    }
                    break;
                case 3:
                    switch(index){
                        case 0 -> dispose();
                        case 1 -> dispose();
                        case 2 -> dispose();
                        case 3 -> dispose();
                        case 4 -> new TelaServico();
                    }
                    break;
                case 4:
                    switch(index){
                        case 0 -> dispose();
                        case 1 -> dispose();
                        case 2 -> dispose();
                        case 3 -> dispose();
                        case 4 -> new TelaServico();
                    }
                    break;
                case 5:
                    switch(index){
                        case 0 -> dispose();
                        case 1 -> dispose();
                        case 2 -> dispose();
                        case 3 -> dispose();
                        case 4 -> new TelaServico();
                    }
                    break;
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

        jbOne = new JButton();
        jbTwo = new JButton();
        jbThree = new JButton();
        jbFour = new JButton();
        jbVoltar = new JButton();
        
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
