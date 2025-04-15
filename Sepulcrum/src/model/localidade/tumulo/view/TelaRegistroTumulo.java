package model.localidade.tumulo.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import core.utils.TelaRegistro;

public class TelaRegistroTumulo extends TelaRegistro{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(_ -> {
            switch(index){
                case 0 -> new TelaGerenciadorTumulo(); // passar propriedade JOption + propriedade de crud
                case 1 -> new TelaGerenciadorTumulo();
            };
            dispose();
        });
        this.add(button);
    }
    
    @Override
    protected void inicializarVariaveis() {
        //Configura tamanho da janela e botões
        fWidth = 500;
        fHeight = 700;
        qtdBotoes = 8;

        // Janela
        this.setTitle("Registro Túmulo.");
        
        // Button
        jbSalvar = new JButton("Salvar");
        jbCancelar = new JButton("Cancelar");

        // Label
        jlOne = new JLabel("Tipo: ");
        jlTwo = new JLabel("Situação: ");
        jlThree = new JLabel("Data de ocupação: ");
        jlFour = new JLabel("Rua: ");
        jlFive = new JLabel("Numero: ");
        jlSix = new JLabel("Id Cemitério: ");
        jlSeven = new JLabel("Id defunto: ");
        
        // Text Field
        jtfOne = new JTextField();
        jtfTwo = new JTextField();
        jtfThree = new JTextField();
        jtfFour = new JTextField();
        jtfFive = new JTextField();
        jtfSix = new JTextField();
        jtfSeven = new JTextField();
    }

    protected void button(int i, int jbX, int y, int jbY, int jbWidth, int jbHeight){
        jbY = y * (i + 8);
        int index = i;
        JButton button = switch (index){
            case 0 -> jbSalvar;
            case 1 -> jbCancelar;
            default -> null;
        };
        if(button != null){
            defineBotoes(button, index, jbX + 70, jbY, jbWidth, jbHeight);
        }
    }
}