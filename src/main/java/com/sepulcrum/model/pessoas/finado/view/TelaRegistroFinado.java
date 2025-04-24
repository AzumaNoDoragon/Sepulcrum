package com.sepulcrum.model.pessoas.finado.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.sepulcrum.core.utils.TelaRegistro;

public class TelaRegistroFinado extends TelaRegistro{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(_ -> {
            switch(index){
                case 0 -> new TelaGerenciadorFinado(); // passar propriedade JOption + propriedade de crud
                case 1 -> new TelaGerenciadorFinado();
            };
            dispose();
        });
        this.add(button);
    }
    
    @Override
    public void inicializarVariaveis() {
        //Configura tamanho da janela e botões
        fWidth = 500;
        fHeight = 700;
        qtdBotoes = 8;

        // Janela
        this.setTitle("Registro Finado.");
        
        // Button
        jbSalvar = new JButton("Salvar");
        jbCancelar = new JButton("Cancelar");

        // Label
        jlOne = new JLabel("Nome: ");
        jlTwo = new JLabel("CPF: ");
        jlThree = new JLabel("RG: ");
        jlFour = new JLabel("Data Nascimento: ");
        jlFive = new JLabel("Data Falecimento: ");
        jlSix = new JLabel("Causa da morte: ");
        jlSeven = new JLabel("id do túmulo: ");
        jlEight = new JLabel("id do parente: ");
        
        // Text Field
        jtfOne = new JTextField();
        jtfTwo = new JTextField();
        jtfThree = new JTextField();
        jtfFour = new JTextField();
        jtfFive = new JTextField();
        jtfSix = new JTextField();
        jtfSeven = new JTextField();
        jtfEight = new JTextField();
    }
}