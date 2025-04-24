package model.localidade.tumulo.view;

import javax.swing.JButton;

import com.sepulcrum.model.localidade.tumulo.view.TelaGerenciadorTumulo;
import com.sepulcrum.model.localidade.tumulo.view.TelaRegistroTumulo;

import core.utils.TelaSelect;

public class TelaSelectTumulo extends TelaSelect{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(_ -> {
            switch(index){
                case 0 -> new TelaRegistroTumulo(); // Passar propriedade de crud
                case 1 -> new TelaGerenciadorTumulo();
            }
            dispose();
        });
        this.add(button);
    }
}
