package core.view;

import javax.swing.JButton;
import core.utils.TelaMenu;
import modules.localidade.cemiterio.view.TelaGerenciadorCemiterio;
import modules.pessoas.adm.view.TelaGerenciadorAdm;
import modules.localidade.tumulo.view.TelaGerenciadorTumulo;
import modules.pessoas.finado.view.TelaGerenciadorFinado;
import modules.servicos.gerenciadorServicos.TelaGerenciadorServicos;

public class TelaGerenciador extends TelaMenu{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(e -> {
            switch(index){
                case 0 -> new TelaGerenciadorCemiterio();
                case 1 -> new TelaGerenciadorAdm();
                case 2 -> new TelaGerenciadorTumulo();
                case 3 -> new TelaGerenciadorFinado(); // TROCAR ENTIDADE
                case 4 -> new TelaGerenciadorServicos(); // TROCAR ENTIDADE
            }
            dispose();
        });
        this.add(button);
    }

    @Override
    protected void inicializarVariaveis(){
        //Configura tamanho da janela e botões
        fWidth = 300;
        fHeight = 300;
        qtdBotoes = 5;

        // Janela
        this.setTitle("Menu Inicial");

        // Button
        jbCreate = new JButton("Cemitério");
        jbRead = new JButton("Adm");
        jbUpdate = new JButton("Túmulo");
        jbDelete = new JButton("Finado");
        jbVoltar = new JButton("Serviços");
    }
}