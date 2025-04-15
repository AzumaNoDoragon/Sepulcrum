package core.view;

import javax.swing.JButton;
import core.utils.TelaMenu;
import model.localidade.cemiterio.view.TelaGerenciadorCemiterio;
import model.localidade.tumulo.view.TelaGerenciadorTumulo;
import model.pessoas.adm.view.TelaGerenciadorAdm;
import model.pessoas.finado.view.TelaGerenciadorFinado;
import model.pessoas.parente.view.TelaGerenciadorParente;
import model.servicos.core.view.TelaServico;

public class TelaGerenciador extends TelaMenu{
    @Override
    protected void button(int qtdBotoes, int y, int jbX, int jbWidth, int jbHeight){
        for(int i = 0; i < qtdBotoes; i++){
            int jbY = y * (i + 1);
            int index = i;
            JButton button = switch (index){
                case 0 -> jbOne; 
                case 1 -> jbTwo; 
                case 2 -> jbThree; 
                case 3 -> jbFour;
                case 4 -> jbFive; 
                case 5 -> jbVoltar; 
                default -> null; 
            };
            if(button != null){
                defineBotoes(button, index, jbX, jbY, jbWidth, jbHeight);
            }
        };
    }

    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(_ -> {
            switch(index){
                case 0 -> new TelaGerenciadorCemiterio();
                case 1 -> new TelaGerenciadorAdm();
                case 2 -> new TelaGerenciadorTumulo();
                case 3 -> new TelaGerenciadorFinado();
                case 4 -> new TelaGerenciadorParente();
                case 5 -> new TelaServico();
            }
            dispose();
        });
        this.add(button);
    }

    @Override
    protected void inicializarVariaveis(){
        //Configura tamanho da janela e botões
        fWidth = 300;
        fHeight = 400;
        qtdBotoes = 6;

        // Janela
        this.setTitle("Menu Inicial");

        // Button
        jbOne = new JButton("Cemitério");
        jbTwo = new JButton("Adm");
        jbThree = new JButton("Túmulo");
        jbFour = new JButton("Finado");
        jbFive = new JButton("Familiar");
        jbVoltar = new JButton("Serviços");
    }
}