package model.localidade.cemiterio.view;

import javax.swing.JButton;

import com.sepulcrum.model.localidade.cemiterio.view.TelaRegistroCemiterio;
import com.sepulcrum.model.localidade.cemiterio.view.TelaSelectCemiterio;

import core.utils.TelaMenu;
import core.view.TelaGerenciador;

public class TelaGerenciadorCemiterio extends TelaMenu{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(_ -> {
            switch(index){
                case 0 -> new TelaRegistroCemiterio();
                case 1 -> new TelaSelectCemiterio(); // passar propriedade busca
                case 2 -> new TelaSelectCemiterio(); // passar propriedade updade
                case 3 -> new TelaSelectCemiterio(); // passar propriedade delete
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
        this.setTitle("Menu Cemitério");

        // Button
        jbOne = new JButton("Cadastrar Cemitério.");
        jbTwo = new JButton("Apresentar Cemitério.");
        jbThree = new JButton("Alterar Cemitério.");
        jbFour = new JButton("Deletar Cemitério.");
        jbVoltar = new JButton("Voltar");
    }
}