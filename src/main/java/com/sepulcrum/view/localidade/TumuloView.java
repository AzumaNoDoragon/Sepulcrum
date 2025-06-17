package com.sepulcrum.view.localidade;

import java.awt.Component;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.sepulcrum.controller.localidade.TumuloController;
import com.sepulcrum.view.comum.TelaGerenciadorGeral;

public class TumuloView extends JFrame{
    protected JButton jbSalvar, jbCancelar;
    protected JTextField jtfThree, jtfFour, jtfFive, jtfSix, jtfSeven;
    protected JLabel jlOne, jlTwo, jlThree, jlFour, jlFive, jlSix, jlSeven;
    protected JComboBox<String> jtfOne, jtfTwo;
    protected int fWidth, fHeight, qtdBotoes, jbY;
    private TumuloController gt = new TumuloController();

    public TumuloView(int seletor, int seletorCrud, String num, String rua, String cnpj){
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
            button(num, rua, cnpj, seletorCrud, qtdBotoes, seletor, i, jbX, y, jbY, jbWidth, jbHeight);
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
            default -> null;
        };
        if(text != null){
            text.setBounds(jbX, jbY, jbWidth, jbHeight);
            this.add(text);
        }
    }

    protected void button(String num, String rua, String cnpj, int seletorCrud, int qtdBotoes, int seletor, int i, int jbX, int y, int jbY, int jbWidth, int jbHeight){
        jbY = y * (qtdBotoes + 1 + i);
        int index = i;
        JButton button = switch (index){
            case 0 -> jbSalvar;
            case 1 -> jbCancelar;
            default -> null;
        };
        if(button != null){
            defineBotoes(num, rua, cnpj, seletorCrud, seletor, button, index, jbX + 70, jbY, jbWidth, jbHeight);
        }
    }
    
    protected void defineBotoes(String num, String rua, String cnpj, int seletorCrud, int seletor, JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(_ -> {
            switch(index){
                case 0 -> {
                    if(seletorCrud == 1){
                        try{
                            gt.setTumulo(this);
                            msgSucesso();
                        } catch (Exception e){
                            e.printStackTrace();
                            msgErro(e);
                            return;
                        }
                    } else if (seletorCrud == 3){
                        gt.updateTumulo(this, num, rua, cnpj);
                        msgAlterada();
                    } else if(seletorCrud == 4){
                        msgConfirmacaoDelecao(num, rua, cnpj);
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
        fHeight = 600;
        qtdBotoes = 8;

        // Janela
        this.setTitle("Registro Túmulo.");

        // Label
        jlOne = new JLabel("*Tipo: ");                                 // tipo
        jlTwo = new JLabel("*Situação: ");                             // situacao
        jlThree = new JLabel("Data de ocupação: ");                    // dataOcupacao
        jlFour = new JLabel("*Rua: ");                                 // rua
        jlFive = new JLabel("*Numero: ");                              // numero
        jlSix = new JLabel("<html>*CNPJ do <BR>  Cemitério: <html/>"); // cemCnpj
        jlSeven = new JLabel("<html>CPF do <BR>  Comprador: <html/>"); // famCpf
        
        // Text Field
        jtfOne = new JComboBox<>(new String[] {"Cova Rasa", "Tumulo Alvenaria", "Jazigo Perpetuo", "Ossuario", "Mausoleu", "Columbario"});
        jtfTwo = new JComboBox<>(new String[] {"Vazio", "Reservado", "Comprado", "Ocupado", "Manutencao", "Aguardando Exumação", "Desativado/Indisponível"});
        jtfThree = new JTextField();
        jtfFour = new JTextField();
        jtfFive = new JTextField();
        jtfSix = new JTextField();
        jtfSeven = new JTextField();

        if(seletorCrud == 2 | seletorCrud == 4){
            jtfOne.setEnabled(false);
            jtfTwo.setEnabled(false);
            jtfThree.setEditable(false);
            jtfFour.setEditable(false);
            jtfFive.setEditable(false);
            jtfSix.setEditable(false);
            jtfSeven.setEditable(false);
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

    protected void msgConfirmacaoDelecao(String num, String rua, String cnpj){
        TumuloController tc = new TumuloController();
        int opcao = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente deletar este registro?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
        );
        if (opcao == JOptionPane.YES_OPTION) {
            tc.deleteTumulo(num, rua, cnpj);
            msgDelete();
        }
    }
    
    // tipo
    public String getJtfOne() {
        return (String) jtfOne.getSelectedItem();
    }

    public void setJtfOne(String value) {
        jtfOne.setSelectedItem(value);
    }
    
    // situacao
    public String getJtfTwo() {
        return (String) jtfTwo.getSelectedItem();
    }

    public void setJtfTwo(String value) {
        jtfTwo.setSelectedItem(value);
    }
    
    // dataOcupacao
    public Date getJtfThree() {
        String text = jtfFour.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            java.util.Date utilDate = sdf.parse(text);
            return new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public void setJtfThree(Date value) {
        if (value != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String dataFormatada = sdf.format(value);
            jtfFive.setText(dataFormatada);
        } else {
            jtfFive.setText("Data não encontrada");
        }
    }
    
    // rua
    public String getJtfFour() {
        return jtfFour.getText();
    }

    public void setJtfFour(String value) {
        jtfFour.setText(value);
    }
    
    // numero
    public String getJtfFive() {
        return jtfFive.getText();
    }

    public void setJtfFive(String value) {
        jtfFive.setText(value);
    }
    
    // cemCnpj
    public String getJtfSix() {
        return jtfSix.getText();
    }

    public void setJtfSix(String value) {
        jtfSix.setText(value);
    }
    
    // famCpf
    public String getJtfSeven() {
        return jtfSeven.getText();
    }

    public void setJtfSeven(String value) {
        jtfSeven.setText(value);
    }
}