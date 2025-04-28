package com.sepulcrum.model.pessoas.parente.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sepulcrum.utils.TelaRegistro;

public class TelaRegistroParente extends TelaRegistro{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(_ -> {
            switch(index){
                case 0 -> new TelaGerenciadorParente(); // passar propriedade JOption + propriedade de crud
                case 1 -> new TelaGerenciadorParente();
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
        this.setTitle("Registro Cemitério.");
        
        // Button
        jbSalvar = new JButton("Salvar");
        jbCancelar = new JButton("Cancelar");

        // Label
        jlOne = new JLabel("Nome: ");
        jlTwo = new JLabel("CPF: ");
        jlThree = new JLabel("RG: ");
        jlFour = new JLabel("Data Nascimento: ");
        jlFive = new JLabel("Grau Parentesco: ");
        jlSix = new JLabel("Email: ");
        jlSeven = new JLabel("Telefone: ");
        jlEight = new JLabel("Id do finado");
        
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

    @Override
    protected void label(int i, int jbX, int jbY, int jbWidth, int jbHeight){
        JLabel label = switch (i){
            case 0 -> jlOne;
            case 1 -> jlTwo;
            case 2 -> jlThree;
            case 3 -> jlFour;
            case 4 -> jlFive;
            case 5 -> jlSix;
            case 6 -> jlSeven;
            case 7 -> jlEight;
            default -> null;
        };
        if(label != null){
            label.setBounds(jbX, jbY, jbWidth, jbHeight);
            this.add(label);
        }
    }

    @Override
    protected void text(int i, int jbX, int jbY, int jbWidth, int jbHeight){
        JTextField text = switch (i){
            case 0 -> jtfOne;
            case 1 -> jtfTwo;
            case 2 -> jtfThree;
            case 3 -> jtfFour;
            case 4 -> jtfFive;
            case 5 -> jtfSix;
            case 6 -> jtfSeven;
            case 7 -> jtfEight;
            default -> null;
        };
        if(text != null){
            text.setBounds(jbX, jbY, jbWidth, jbHeight);
            this.add(text);
        }
    }
}