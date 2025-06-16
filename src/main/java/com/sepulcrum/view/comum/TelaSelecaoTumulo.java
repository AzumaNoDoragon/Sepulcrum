package com.sepulcrum.view.comum;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.sepulcrum.controller.localidade.TumuloController;

public class TelaSelecaoTumulo extends JFrame{
    protected JButton jbBusca, jbCancelar;
    protected JTextField jtfOne, jtfTwo, jtfThree;
    protected JLabel jlOne, jlTwo, jlThree;
    protected int fWidth, fHeight, qtdBotoes;
    private String idOne, idTwo, idThree;
    private TumuloController tc = new TumuloController();

    public TelaSelecaoTumulo(int seletor, int seletorCrud){
        inicializarVariaveis();

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
            int jbY = y * (i + 2);
            if(i == 1){jbY = jbY - 15;}
            jbWidth = 150;
            button(seletorCrud, seletor, i, jbX + 70, jbY, jbWidth, jbHeight);
        };
        
        this.setVisible(true);
    }

    private void label(int i, int jbX, int jbY, int jbWidth, int jbHeight){
        JLabel label = switch (i){
            case 0 -> jlOne;
            case 1 -> jlTwo;
            case 2 -> jlThree;
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
            default -> null;
        };
        if(text != null){
            text.setBounds(jbX, jbY, jbWidth, jbHeight);
            this.add(text);
        }
    }

    protected void button(int seletorCrud, int seletor, int i, int jbX, int jbY, int jbWidth, int jbHeight){
        int index = i;
        JButton button = switch (index){
            case 0 -> jbBusca;
            case 1 -> jbCancelar;
            default -> null;
        };
        if(button != null){
            defineBotoes(seletorCrud, seletor, button, index, jbX, jbY, jbWidth, jbHeight);
        }
    }

    protected void defineBotoes(int seletorCrud, int seletor, JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(_ -> {
            switch(index){
                case 0 -> {
                    tc.selectTumulo(this, seletor, seletorCrud, getIdOne(), getIdTwo(), getIdThree());
                }
                case 1 -> {
                    dispose();
                    new TelaGerenciadorGeral(seletor);
                }
            }
        });
        this.add(button);
    }

    protected void inicializarVariaveis(){
        //Configura tamanho da janela e botões
        fWidth = 500;
        fHeight = 500;
        qtdBotoes = 3;

        // Janela
        this.setTitle("Seleção");

        // Button
        jbBusca = new JButton("Buscar");
        jbCancelar = new JButton("Cancelar");

        // Label
        jlOne = new JLabel("Número: ");
        jlTwo = new JLabel("Rua: ");
        jlThree = new JLabel("CNPJ: ");

        // Text Field
        jtfOne = new JTextField();
        jtfTwo = new JTextField();
        jtfThree = new JTextField();
    }

    public String getIdOne() {
        return idOne;
    }

    public String getIdTwo() {
        return idTwo;
    }

    public String getIdThree() {
        return idThree;
    }
}