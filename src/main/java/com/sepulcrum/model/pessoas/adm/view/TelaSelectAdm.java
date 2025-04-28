package com.sepulcrum.model.pessoas.adm.view;

import javax.swing.JButton;

import com.sepulcrum.utils.TelaSelect;

public class TelaSelectAdm extends TelaSelect{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(_ -> {
            switch(index){
                case 0 -> new TelaRegistroAdm(); // Passar propriedade de crud
                case 1 -> new TelaGerenciadorAdm();
            }
            dispose();
        });
        this.add(button);
    }
}