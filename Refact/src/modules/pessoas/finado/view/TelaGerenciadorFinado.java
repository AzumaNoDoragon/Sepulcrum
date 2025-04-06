package modules.pessoas.finado.view;

import javax.swing.JButton;
import core.utils.TelaMenu;

public class TelaGerenciadorFinado extends TelaMenu{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(e -> {
            switch(index){
                case 0 -> dispose();
                case 1 -> dispose();
                case 2 -> dispose();
                case 3 -> dispose();
                case 4 -> dispose();
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
        jbCreate = new JButton("Cadastrar Finado.");
        jbRead = new JButton("Apresentar Finado.");
        jbUpdate = new JButton("Alterar Finado.");
        jbDelete = new JButton("Deletar Finado.");
        jbVoltar = new JButton("Voltar");
    }
}
