package com.sepulcrum.model.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaRegistroGeral extends JFrame{
    protected JButton jbSalvar, jbCancelar;
    protected JTextField jtfOne, jtfTwo, jtfThree, jtfFour, jtfFive, jtfSix, jtfSeven, jtfEight, jtfNine, jtfTen;
    protected JLabel jlOne, jlTwo, jlThree, jlFour, jlFive, jlSix, jlSeven, jlEight, jlNine, jlTen;
    protected int fWidth, fHeight, qtdBotoes, jbY;

    public TelaRegistroGeral(int seletor, int seletorCrud, int id){
        inicializarVariaveis(seletor);
        
        // Janela
        this.setLayout(null);
        this.setSize(fWidth, fHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        // Config dos tamanho dos botões
        int jbHeight = 30;
        int jbWidth = 160;
        int jbX = (fWidth - jbWidth) / 2;

        // Config centralização dos botões
        int y = (fHeight / (qtdBotoes + 1) - (jbHeight / 2));
        if(y < 30){ y = 30; }

        for(int i = 0; i < qtdBotoes; i++){
            int jbY = y * (i + 1);
            jbX = 50;
            label(i, jbX, jbY, jbWidth, jbHeight);
        };
        for(int i = 0; i < qtdBotoes; i++){
            int jbY = y * (i + 1);
            jbX = 160;
            jbWidth = 300;
            text(i, jbX, jbY, jbWidth, jbHeight);
        };
        for(int i = 0; i < qtdBotoes; i++){
            if(i == 1){jbY = jbY - 15;}
            jbWidth = 150;
            button(seletorCrud, qtdBotoes, seletor, i, jbX, y, jbY, jbWidth, jbHeight);
        };
        
        this.setVisible(true);
    }

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
            case 8 -> jlNine;
            default -> null;
        };
        if(label != null){
            label.setBounds(jbX, jbY, jbWidth, jbHeight);
            this.add(label);
        }
    }

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
            case 8 -> jtfNine;
            default -> null;
        };
        if(text != null){
            text.setBounds(jbX, jbY, jbWidth, jbHeight);
            this.add(text);
        }
    }

    protected void button(int seletorCrud, int qtdBotoes, int seletor, int i, int jbX, int y, int jbY, int jbWidth, int jbHeight){
        jbY = y * (qtdBotoes + 1 + i);
        int index = i;
        JButton button = switch (index){
            case 0 -> jbSalvar;
            case 1 -> jbCancelar;
            default -> null;
        };
        if(button != null){
            defineBotoes(seletorCrud, seletor, button, index, jbX + 70, jbY, jbWidth, jbHeight);
        }
    }
    
    protected void defineBotoes(int seletorCrud, int seletor, JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(_ -> {
            switch(index){
                case 0 -> {
                    if(seletorCrud == 1){
                        if(seletor == 1){
                            System.out.println("Debug 1");
                        } else if(seletor == 2){
                            System.out.println("debug 2");
                        } else if(seletor == 3){
                            System.out.println("Debug 3");
                        } else if(seletor == 4){
                            System.out.println("Debug 4");
                        } else if(seletor == 5){
                            System.out.println("Debug 5");
                        }
                        msgSucesso();
                    } else if (seletorCrud == 3){
                        msgAlterada();
                    } else if(seletorCrud == 4){
                        msgConfirmacaoDelecao();
                    }
                    new TelaGerenciadorGeral(seletor);
                }
                case 1 -> new TelaGerenciadorGeral(seletor);
            };
            dispose();
        });
        this.add(button);
    }
    
    public void inicializarVariaveis(int seletor) {
        // Button
        jbSalvar = new JButton("Salvar");
        jbCancelar = new JButton("Cancelar");
        
        switch (seletor) {
            case 1:
                //Configura tamanho da janela e botões
                fWidth = 500;
                fHeight = 700;
                qtdBotoes = 8;

                // Janela
                this.setTitle("Registro Cemitério.");
                
                // Label
                jlOne = new JLabel("Nome: ");
                jlTwo = new JLabel("Estado: ");
                jlThree = new JLabel("Cidade: ");
                jlFour = new JLabel("Rua: ");
                jlFive = new JLabel("Numero: ");
                jlSix = new JLabel("Capacidade: ");
                jlSeven = new JLabel("Telefone: ");
                jlEight = new JLabel("Cep: ");
                
                // Text Field
                jtfOne = new JTextField();
                jtfTwo = new JTextField();
                jtfThree = new JTextField();
                jtfFour = new JTextField();
                jtfFive = new JTextField();
                jtfSix = new JTextField();
                jtfSeven = new JTextField();
                jtfEight = new JTextField();
                break;
            case 2:
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
                jlFive = new JLabel("Data Contratação: ");
                jlSix = new JLabel("Email: ");
                jlSeven = new JLabel("Telefone: ");
                
                // Text Field
                jtfOne = new JTextField();
                jtfTwo = new JTextField();
                jtfThree = new JTextField();
                jtfFour = new JTextField();
                jtfFive = new JTextField();
                jtfSix = new JTextField();
                jtfSeven = new JTextField();
                break;
            case 3:
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
                break;
            case 4:
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
                break;
            case 5:
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
                break;
        }
    }

    protected void msgSucesso(){
        JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
    }

    protected void msgAlterada(){
        JOptionPane.showMessageDialog(this, "Atualização concluída!");
    }

    protected void msgDelete(){
        JOptionPane.showMessageDialog(this, "Registro deletado!");
    }

    protected void msgConfirmacaoDelecao(){
        int opcao = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente deletar este registro?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
        );
        if (opcao == JOptionPane.YES_OPTION) {
            msgDelete();
        }
    }

    public String getJtfOne() {
        return jtfOne.getText();
    }

    public String getJtfTwo() {
        return jtfTwo.getText();
    }

    public String getJtfThree() {
        return jtfThree.getText();
    }

    public String getJtfFour() {
        return jtfFour.getText();
    }

    public int getJtfFive() {
        return Integer.parseInt(jtfFive.getText());
    }

    public int getJtfSix() {
        return Integer.parseInt(jtfSix.getText());
    }

    public int getJtfSeven() {
        return Integer.parseInt(jtfSeven.getText());
    }

    public String getJtfEight() {
        return jtfEight.getText();
    }

    public String getJtfNine() {
        return jtfNine.getText();
    }

    public String getJtfTen() {
        return jtfTen.getText();
    }

    public void setJtfOne(String value) {
        jtfOne.setText(value);
    }

    public void setJtfTwo(String value) {
        jtfTwo.setText(value);
    }

    public void setJtfThree(String value) {
        jtfThree.setText(value);
    }

    public void setJtfFour(String value) {
        jtfFour.setText(value);
    }

    public void setJtfFive(String value) {
        jtfFive.setText(value);
    }

    public void setJtfSix(String value) {
        jtfSix.setText(value);
    }

    public void setJtfSeven(String value) {
        jtfSeven.setText(value);
    }

    public void setJtfEight(String value) {
        jtfEight.setText(value);
    }

    public void setJtfNine(String value) {
        jtfNine.setText(value);
    }

    public void setJtfTen(String value) {
        jtfTen.setText(value);
    }
}