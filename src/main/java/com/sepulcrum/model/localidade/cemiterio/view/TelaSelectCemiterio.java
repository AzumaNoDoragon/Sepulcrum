package com.sepulcrum.model.localidade.cemiterio.view;

import javax.swing.JButton;
import com.sepulcrum.core.utils.TelaSelect;

public class TelaSelectCemiterio extends TelaSelect{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(_ -> {
            switch(index){
                case 0 -> new TelaRegistroCemiterio(); // Passar propriedade de crud
                case 1 -> new TelaGerenciadorCemiterio();
            }
            dispose();
        });
        this.add(button);
    }
}