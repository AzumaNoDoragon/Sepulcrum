package modules.servicos.view;

import javax.swing.JButton;
import core.utils.TelaSelect;

public class TelaSelectServico extends TelaSelect{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(e -> {
            switch(index){
                case 0 -> new TelaRegistroServico(); // Passar propriedade de crud
                case 1 -> new TelaGerenciadorServico();
            }
            dispose();
        });
        this.add(button);
    }
}
