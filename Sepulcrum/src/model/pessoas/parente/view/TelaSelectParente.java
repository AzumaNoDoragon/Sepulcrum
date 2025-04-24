package model.pessoas.parente.view;

import javax.swing.JButton;

import com.sepulcrum.model.pessoas.parente.view.TelaGerenciadorParente;
import com.sepulcrum.model.pessoas.parente.view.TelaRegistroParente;

import core.utils.TelaSelect;

public class TelaSelectParente extends TelaSelect{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(_ -> {
            switch(index){
                case 0 -> new TelaRegistroParente(); // Passar propriedade de crud
                case 1 -> new TelaGerenciadorParente();
            }
            dispose();
        });
        this.add(button);
    }
}