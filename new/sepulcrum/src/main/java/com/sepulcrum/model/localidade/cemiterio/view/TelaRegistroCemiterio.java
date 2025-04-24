package com.sepulcrum.model.localidade.cemiterio.view;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sepulcrum.model.localidade.cemiterio.model.Cemiterio;

import core.utils.TelaRegistro;
import model.localidade.cemiterio.view.TelaGerenciadorCemiterio;

import javax.swing.JButton;

public class TelaRegistroCemiterio extends TelaRegistro{
    private Cemiterio c = new Cemiterio();
    
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(_ -> {
            switch(index){
                case 0 -> new TelaGerenciadorCemiterio(); // passar propriedade JOption + propriedade de crud
                case 1 -> new TelaGerenciadorCemiterio();
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
        jlTwo = new JLabel("Estado: ");
        jlThree = new JLabel("Cidade: ");
        jlFour = new JLabel("Rua: ");
        jlFive = new JLabel("Numero: ");
        jlSix = new JLabel("Capacidade: ");
        jlSeven = new JLabel("Telefone: ");
        jlEight = new JLabel("Cep: ");

        c.setNome(jtfOne.getText());
        c.setEstado(jtfTwo.getText());
        c.setCidade(jtfThree.getText());
        c.setRua(jtfFour.getText());
        c.setNumero(Integer.parseInt(jtfFive.getText()));
        c.setCapacidadeMax(Integer.parseInt(jtfSix.getText()));
        c.setTelefone(jtfSeven.getText());
        c.setCep(jtfEight.getText());
        
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