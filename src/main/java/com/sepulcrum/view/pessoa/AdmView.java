package com.sepulcrum.view.pessoa;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.sepulcrum.controller.pessoa.AdmController;
import com.sepulcrum.view.comum.TelaGerenciadorGeral;

public class AdmView extends JFrame{
    protected JButton jbSalvar, jbCancelar;
    protected JTextField jtfOne, jtfTwo, jtfThree, jtfFour, jtfFive, jtfSix, jtfSeven;
    protected JLabel jlOne, jlTwo, jlThree, jlFour, jlFive, jlSix, jlSeven, jlEight;
    protected JComboBox<String> jtfEight;
    protected int fWidth, fHeight, qtdBotoes, jbY;
    private AdmController ga = new AdmController();

    public AdmView(int seletor, int seletorCrud, String id){
        inicializarVariaveis(seletor, seletorCrud);
        
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
            button(id, seletorCrud, qtdBotoes, seletor, i, jbX, y, jbY, jbWidth, jbHeight);
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
            default -> null;
        };
        if(label != null){
            label.setBounds(jbX, jbY, jbWidth, jbHeight);
            this.add(label);
        }
    }

    protected void text(int i, int jbX, int jbY, int jbWidth, int jbHeight){
        Component text = switch (i){
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

    protected void button(String id, int seletorCrud, int qtdBotoes, int seletor, int i, int jbX, int y, int jbY, int jbWidth, int jbHeight){
        jbY = y * (qtdBotoes + 1 + i);
        int index = i;
        JButton button = switch (index){
            case 0 -> jbSalvar;
            case 1 -> jbCancelar;
            default -> null;
        };
        if(button != null){
            defineBotoes(id, seletorCrud, seletor, button, index, jbX + 70, jbY, jbWidth, jbHeight);
        }
    }
    
    protected void defineBotoes(String id, int seletorCrud, int seletor, JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(_ -> {
            switch(index){
                case 0 -> {
                    if(seletorCrud == 1){
                        try{
                            ga.setAdm(this);
                            msgSucesso();
                        } catch (Exception e){
                            e.printStackTrace();
                            msgErro(e);
                            return;
                        }
                    } else if (seletorCrud == 3){
                        ga.updateAdm(this, id);
                        msgAlterada();
                    } else if(seletorCrud == 4){
                        msgConfirmacaoDelecao(id);
                    }
                    new TelaGerenciadorGeral(seletor);
                }
                case 1 -> new TelaGerenciadorGeral(seletor);
            };
            dispose();
        });
        this.add(button);
    }
    
    public void inicializarVariaveis(int seletor, int seletorCrud) {
        // Button
        if(seletorCrud == 1 || seletorCrud == 3){
            jbSalvar = new JButton("Salvar");
            jbCancelar = new JButton("Cancelar");
        } else if(seletorCrud == 2){
            jbSalvar = new JButton("Concluir");
            jbCancelar = new JButton("Voltar");
        } else if(seletorCrud == 4){
            jbSalvar = new JButton("DELETAR");
            jbCancelar = new JButton("Cancelar");
        }
        
        //Configura tamanho da janela e botões
        fWidth = 500;
        fHeight = 700;
        qtdBotoes = 8;

        // Janela
        this.setTitle("Registro Coveiro.");

        // Label
        jlOne = new JLabel("*Nome: ");                                 // nome
        jlTwo = new JLabel("*CPF: ");                                  // cpf
        jlThree = new JLabel("RG: ");                                  // RG
        jlFour = new JLabel("*Data Nascimento: ");                     // dataNascimento
        jlFive = new JLabel("*Data Contratação: ");                    // dataContratacao
        jlSix = new JLabel("*Email: ");                                // email
        jlSeven = new JLabel("*Telefone: ");                           // telefone
        jlEight = new JLabel("*Cargo: ");                              // cargo
        
        // Text Field
        jtfOne = new JTextField();
        jtfTwo = new JTextField();
        jtfThree = new JTextField();
        jtfFour = new JTextField();
        jtfFive = new JTextField();
        jtfSix = new JTextField();
        jtfSeven = new JTextField();
        jtfEight = new JComboBox<>(new String[] {"Coveiro", "Adm"});

        if(seletorCrud == 2 | seletorCrud == 4){
            jtfOne.setEditable(false);
            jtfTwo.setEditable(false);
            jtfThree.setEditable(false);
            jtfFour.setEditable(false);
            jtfFive.setEditable(false);
            jtfSix.setEditable(false);
            jtfSeven.setEditable(false);
            jtfEight.setEnabled(false);
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

    protected void msgConfirmacaoDelecao(String id){
        AdmController ac = new AdmController();
        int opcao = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente deletar este registro?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
        );
        if (opcao == JOptionPane.YES_OPTION) {
            ac.deleteAdm(id);
            msgDelete();
        }
    }

    protected void msgErro(Exception e){
        JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    // nome
    public String getJtfOne() {
        return jtfOne.getText();
    }

    public void setJtfOne(String value) {
        jtfOne.setText(value);
    }
    
    // cpf
    public String getJtfTwo() {
        return jtfTwo.getText();
    }

    public void setJtfTwo(String value) {
        jtfTwo.setText(value);
    }
    
    // RG
    public String getJtfThree() {
        return jtfThree.getText();
    }

    public void setJtfThree(String value) {
        jtfThree.setText(value);
    }
    
    // dataNascimento
    public Date getJtfFour() {
        String text = jtfFour.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            java.util.Date utilDate = sdf.parse(text);
            return new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public void setJtfFour(Date value) {
        if (value != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String dataFormatada = sdf.format(value);
            jtfFour.setText(dataFormatada);
        } else {
            jtfFour.setText("Data não encontrada");
        }
    }
    
    // dataContratacao
    public Date getJtfFive() {
        String text = jtfFive.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            java.util.Date utilDate = sdf.parse(text);
            return new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public void setJtfFive(Date value) {
        if (value != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String dataFormatada = sdf.format(value);
            jtfFive.setText(dataFormatada);
        } else {
            jtfFive.setText("Data não encontrada");
        }
    }
    
    // email
    public String getJtfSix() {
        return jtfSix.getText();
    }
    
    public void setJtfSix(String value) {
        jtfSix.setText(value);
    }

    // telefone
    public String getJtfSeven() {
        return jtfSeven.getText();
    }

    public void setJtfSeven(String value) {
        jtfSeven.setText(value);
    }
    
    // cargo
    public String getJtfEight() {
        return (String) jtfEight.getSelectedItem();
    }

    public void setJtfEight(String value) {
        jtfEight.setSelectedItem(value);
    }
}