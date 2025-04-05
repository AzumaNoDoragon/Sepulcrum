package gerenciadorPrincipal.view;

import javax.swing.JButton;

import entidades.localidade.cemiterio.view.TelaGerenciadorCemiterio;
import entidades.pessoas.adm.gerenciador.TelaGerenciadorAdm;
import gerenciadorPrincipal.utils.TelaMenu;
import entidades.localidade.tumulo.gerenciador.TelaGerenciadorTumulo;

public class TelaGerenciador extends TelaMenu{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(e -> {
            switch(index){
                case 0 -> new TelaGerenciadorCemiterio();
                case 1 -> new TelaGerenciadorAdm();
                case 2 -> new TelaGerenciadorTumulo();
                case 3 -> new TelaGerenciadorCemiterio(); // TROCAR ENTIDADE
                case 4 -> new TelaGerenciadorCemiterio(); // TROCAR ENTIDADE
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
        jbList = new JButton("Túmulo");
        jbUpdate = new JButton("Finado");
        jbDelete = new JButton("Serviços");
    }
}