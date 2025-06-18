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
import com.sepulcrum.controller.pessoa.FamiliarController;
import com.sepulcrum.view.comum.TelaGerenciadorGeral;

public class FamiliarView extends JFrame{
    protected JButton jbSalvar, jbCancelar;
    protected JTextField jtfOne, jtfTwo, jtfThree, jtfFour, jtfSix, jtfSeven, jtfEight;
    protected JLabel jlOne, jlTwo, jlThree, jlFour, jlFive, jlSix, jlSeven, jlEight;
    protected JComboBox<String> jtfFive; 
    protected int fWidth, fHeight, qtdBotoes, jbY;
    private FamiliarController gfam = new FamiliarController();

    public FamiliarView(int seletor, int seletorCrud, String id){
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
                            gfam.setFamiliar(this);
                            msgSucesso();
                        } catch (Exception e){
                            e.printStackTrace();
                            msgErro(e);
                            return;
                        }
                    } else if (seletorCrud == 3){
                        gfam.updateFamiliar(this, id);
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
        this.setTitle("Registro Familiar.");

        // Label
        jlOne = new JLabel("*Nome: ");                                        // nome
        jlTwo = new JLabel("*CPF: ");                                         // cpf
        jlThree = new JLabel("RG: ");                                         // rg
        jlFour = new JLabel("*Data Nascimento: ");                            // dataNascimento
        jlFive = new JLabel("Grau Parentesco: ");                             // grauParentesco
        jlSix = new JLabel("*Email: ");                                       // email
        jlSeven = new JLabel("*Telefone: ");                                  // telefone
        jlEight = new JLabel("<html>Certidão de<br>óbito de finado:</html>"); // certidaoObito

        // Text Field
        jtfOne = new JTextField();
        jtfTwo = new JTextField();
        jtfThree = new JTextField();
        jtfFour = new JTextField();
        jtfFive = new JComboBox<>(new String[] {"Selecione", "Ascendente", "Descendente", "Colateral", "Conjuge", "Não Parente"});
        jtfSix = new JTextField();
        jtfSeven = new JTextField();
        jtfEight = new JTextField();

        if(seletorCrud == 2 | seletorCrud == 4){
            jtfOne.setEditable(false);
            jtfTwo.setEditable(false);
            jtfThree.setEditable(false);
            jtfFour.setEditable(false);
            jtfFive.setEditable(false);
            jtfSix.setEditable(false);
            jtfSeven.setEditable(false);
            jtfEight.setEditable(false);
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
        FamiliarController famC = new FamiliarController();
        int opcao = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente deletar este registro?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
        );
        if (opcao == JOptionPane.YES_OPTION) {
            famC.deleteFamiliar(id);
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
    
    // rg
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
    
    // grauParentesco
    public String getJtfFive() {
        return (String) jtfFive.getSelectedItem();
    }

    public void setJtfFive(String value) {
        jtfFive.setSelectedItem(value);
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
    
    // certidaoObito
    public String getJtfEight() {
        return jtfEight.getText();
    }

    public void setJtfEight(String value) {
        jtfEight.setText(value);
    }
}