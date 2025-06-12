package com.sepulcrum.view.localidade;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.sepulcrum.controller.localidade.CemiteiroController;
import com.sepulcrum.view.comum.TelaGerenciadorGeral;

public class CemiterioView extends JFrame{
    protected JButton jbSalvar, jbCancelar;
    protected JTextField jtfOne, jtfTwo, jtfThree, jtfFour, jtfFive, jtfSix, jtfSeven, jtfEight, jtfNine, jtfTen;
    protected JLabel jlOne, jlTwo, jlThree, jlFour, jlFive, jlSix, jlSeven, jlEight, jlNine, jlTen;
    protected int fWidth, fHeight, qtdBotoes, jbY;
    private CemiteiroController gc = new CemiteiroController();

    public CemiterioView(int seletor, int seletorCrud, int id){
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
            case 8 -> jlNine;
            case 9 -> jlTen;
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
            case 9 -> jtfTen;
            default -> null;
        };
        if(text != null){
            text.setBounds(jbX, jbY, jbWidth, jbHeight);
            this.add(text);
        }
    }

    protected void button(int id, int seletorCrud, int qtdBotoes, int seletor, int i, int jbX, int y, int jbY, int jbWidth, int jbHeight){
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
    
    protected void defineBotoes(int id, int seletorCrud, int seletor, JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(_ -> {
            switch(index){
                case 0 -> {
                    if(seletorCrud == 1){
                        try{
                            gc.setCemiterio(this);
                            msgSucesso();
                        } catch (Exception e){
                            e.printStackTrace();
                            msgErro(e);
                            return;
                        }
                    } else if (seletorCrud == 3){
                        gc.updateCemiterio(this, id);
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
        qtdBotoes = 10;

        // Janela
        this.setTitle("Registro Cemitério.");
        
        // Label
        jlOne = new JLabel("*Nome: ");           // nome
        jlTwo = new JLabel("*Estado: ");         // estado
        jlThree = new JLabel("*Cidade: ");       // cidade
        jlFour = new JLabel("*Rua: ");           // rua
        jlFive = new JLabel("*Numero: ");        // numero
        jlSix = new JLabel("*Cep: ");            // cep
        jlSeven = new JLabel("Capacidade: ");    // capacidadeMax
        jlEight = new JLabel("*Telefone: ");     // telefone
        jlNine = new JLabel("*Cnpj: ");          // cnpj
        jlTen = new JLabel("*Adiministrador: "); // admCpf

        // Text Field
        jtfOne = new JTextField();
        jtfTwo = new JTextField();
        jtfThree = new JTextField();
        jtfFour = new JTextField();
        jtfFive = new JTextField();
        jtfSix = new JTextField();
        jtfSeven = new JTextField();
        jtfEight = new JTextField();
        jtfNine = new JTextField();
        jtfTen = new JTextField();
            
        if(seletorCrud == 2 | seletorCrud == 4){
            jtfOne.setEditable(false);
            jtfTwo.setEditable(false);
            jtfThree.setEditable(false);
            jtfFour.setEditable(false);
            jtfFive.setEditable(false);
            jtfSix.setEditable(false);
            jtfSeven.setEditable(false);
            jtfEight.setEditable(false);
            jtfNine.setEditable(false);
            jtfTen.setEditable(false);
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
    
    protected void msgErro(Exception e){
        JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    protected void msgConfirmacaoDelecao(int id){
        CemiteiroController gc = new CemiteiroController();
        int opcao = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente deletar este registro?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
        );
        if (opcao == JOptionPane.YES_OPTION) {
            gc.deleteCemiterio(id);
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

    public String getJtfFourString() {
        return jtfFour.getText();
    }

    public Date getJtfFourDate() {
        String text = jtfFour.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            java.util.Date utilDate = sdf.parse(text);
            return new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public String getJtfFiveString() {
        return jtfFive.getText();
    }

    public Date getJtfFiveDate() {
        String text = jtfFive.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            java.util.Date utilDate = sdf.parse(text);
            return new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public String getJtfSix() {
        return jtfSix.getText();
    }

    public String getJtfSevenString() {
        return jtfSeven.getText();
    }

    public int getJtfSevenInt() {
        String text = jtfSeven.getText();
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        return Integer.parseInt(text);
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

    public void setJtfFour(Date value) {
        if (value != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String dataFormatada = sdf.format(value);
            jtfFour.setText(dataFormatada);
        } else {
            jtfFour.setText("Data não encontrada");
        }
    }

    public void setJtfFive(String value) {
        jtfFive.setText(value);
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