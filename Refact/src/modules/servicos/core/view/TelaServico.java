package modules.servicos.core.view;

import javax.swing.JButton;

import core.utils.TelaMenu;
import core.view.TelaGerenciador;
import modules.servicos.view.TelaGerenciadorServicos;

public class TelaServico extends TelaMenu{
    int i;
    
    public int getI() {
        return i;
    }

    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(e -> {
            switch(index){
                case 0 -> { i = 1; new TelaGerenciadorServicos(); }
                case 1 -> { i = 2; new TelaGerenciadorServicos(); }
                case 2 -> { i = 3; new TelaGerenciadorServicos(); }
                case 3 -> { i = 4; new TelaGerenciadorServicos(); }
                case 4 -> { i = 5; new TelaGerenciadorServicos(); }
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
        fHeight = 350;
        qtdBotoes = 5;
        
        // Janela
        this.setTitle("Menu Serviços");

        // Button
        jbOne = new JButton("Cadastrar coveiro.");
        jbTwo = new JButton("Apresentar coveiro.");
        jbThree = new JButton("Alterar coveiro.");
        jbFour = new JButton("Deletar coveiro.");
        jbVoltar = new JButton("Voltar");
    }
    
    
}
