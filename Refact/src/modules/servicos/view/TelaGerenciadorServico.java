package modules.servicos.view;

import javax.swing.JButton;
import core.utils.TelaMenu;
import modules.servicos.core.view.TelaServico;

public class TelaGerenciadorServico extends TelaMenu{
    int i;

    public void getI(TelaServico ts){
        i = ts.getI();
    }

    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(e -> {
            switch (i) {
                case 1:
                    switch(index){
                        case 0 -> dispose();
                        case 1 -> dispose();
                        case 2 -> dispose();
                        case 3 -> dispose();
                        case 4 -> dispose();
                    }
                    break;
                case 2:
                    switch(index){
                        case 0 -> dispose();
                        case 1 -> dispose();
                        case 2 -> dispose();
                        case 3 -> dispose();
                        case 4 -> dispose();
                    }
                    break;
                case 3:
                    switch(index){
                        case 0 -> dispose();
                        case 1 -> dispose();
                        case 2 -> dispose();
                        case 3 -> dispose();
                        case 4 -> dispose();
                    }
                    break;
                case 4:
                    switch(index){
                        case 0 -> dispose();
                        case 1 -> dispose();
                        case 2 -> dispose();
                        case 3 -> dispose();
                        case 4 -> dispose();
                    }
                    break;
                case 5:
                    switch(index){
                        case 0 -> dispose();
                        case 1 -> dispose();
                        case 2 -> dispose();
                        case 3 -> dispose();
                        case 4 -> dispose();
                    }
                    break;
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

        switch(i){
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
