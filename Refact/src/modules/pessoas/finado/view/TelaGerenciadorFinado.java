package modules.pessoas.finado.view;

import javax.swing.JButton;
import core.utils.TelaMenu;
import core.view.TelaGerenciador;

public class TelaGerenciadorFinado extends TelaMenu{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(e -> {
            switch(index){
                case 0 -> new TelaGerenciadorFinado();
                case 1 -> new TelaSelectFinado(); // passar propriedade busca
                case 2 -> new TelaSelectFinado(); // passar propriedade updade
                case 3 -> new TelaSelectFinado(); // passar propriedade delete
                case 4 -> new TelaGerenciador();
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
        this.setTitle("Menu Finado");

        // Button
        jbOne = new JButton("Cadastrar Finado.");
        jbTwo = new JButton("Apresentar Finado.");
        jbThree = new JButton("Alterar Finado.");
        jbFour = new JButton("Deletar Finado.");
        jbVoltar = new JButton("Voltar");
    }
}
