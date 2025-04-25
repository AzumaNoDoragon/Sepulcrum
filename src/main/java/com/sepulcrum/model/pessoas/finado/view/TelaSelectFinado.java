package com.sepulcrum.model.pessoas.finado.view;

import javax.swing.JButton;
import com.sepulcrum.core.utils.TelaSelect;

public class TelaSelectFinado extends TelaSelect{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(_ -> {
            switch(index){
                case 0 -> new TelaRegistroFinado(); // Passar propriedade de crud
                case 1 -> new TelaGerenciadorFinado();
            }
            dispose();
        });
        this.add(button);
    }
}