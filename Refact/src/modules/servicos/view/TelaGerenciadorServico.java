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
                this.setTitle("Menu Cemitério");
                
                // Button
                jbOne = new JButton("Cadastrar coveiro.");
                jbTwo = new JButton("Apresentar coveiro.");
                jbThree = new JButton("Alterar coveiro.");
                jbFour = new JButton("Deletar coveiro.");
                jbVoltar = new JButton("Voltar");
                break;
            case 2:
                // Janela
                this.setTitle("Menu Cemitério");
                
                // Button
                jbOne = new JButton("Cadastrar coveiro.");
                jbTwo = new JButton("Apresentar coveiro.");
                jbThree = new JButton("Alterar coveiro.");
                jbFour = new JButton("Deletar coveiro.");
                jbVoltar = new JButton("Voltar");
                break;
            case 3:
                // Janela
                this.setTitle("Menu Cemitério");
                
                // Button
                jbOne = new JButton("Cadastrar coveiro.");
                jbTwo = new JButton("Apresentar coveiro.");
                jbThree = new JButton("Alterar coveiro.");
                jbFour = new JButton("Deletar coveiro.");
                jbVoltar = new JButton("Voltar");
                break;
            case 4:
                // Janela
                this.setTitle("Menu Cemitério");

                // Button
                jbOne = new JButton("Cadastrar coveiro.");
                jbTwo = new JButton("Apresentar coveiro.");
                jbThree = new JButton("Alterar coveiro.");
                jbFour = new JButton("Deletar coveiro.");
                jbVoltar = new JButton("Voltar");
                break;
            case 5:
                // Janela
                this.setTitle("Menu Cemitério");

                // Button
                jbOne = new JButton("Cadastrar coveiro.");
                jbTwo = new JButton("Apresentar coveiro.");
                jbThree = new JButton("Alterar coveiro.");
                jbFour = new JButton("Deletar coveiro.");
                jbVoltar = new JButton("Voltar");
                break;
        }
    }
}
