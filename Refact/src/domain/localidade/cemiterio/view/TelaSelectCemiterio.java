package domain.localidade.cemiterio.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import core.utils.TelaSelect;

public class TelaSelectCemiterio extends TelaSelect{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(e -> {
            switch(index){
                case 0 -> new TelaRegistroCemiterio(); // TROCAR ENTIDADE
                case 1 -> new TelaGerenciadorCemiterio();
            }
            dispose();
        });
        this.add(button);
    }

    @Override
    protected void inicializarVariaveis(){
        // Janela
        this.setTitle("Seleção");

        // Button
        jbBusca = new JButton("Buscar");
        jbCancelar = new JButton("Cancelar");

        // Label
        jlId = new JLabel("Busca por id: ");

        // Text Field
        jtfId = new JTextField();
    }
}
