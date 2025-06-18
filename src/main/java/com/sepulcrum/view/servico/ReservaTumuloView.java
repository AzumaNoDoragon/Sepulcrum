package com.sepulcrum.view.servico;

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
import com.sepulcrum.controller.servico.ReservaTumuloController;
import com.sepulcrum.view.servico.comum.TelaGerenciadorServico;

public class ReservaTumuloView extends JFrame{
    protected JButton jbSalvar, jbCancelar;
    protected JTextField jtfOne, jtfTwo, jtfFour, jtfFive, jtfSix, jtfSeven, jtfEight, jtfNine, jtfTen;
    protected JLabel jlOne, jlTwo, jlThree, jlFour, jlFive, jlSix, jlSeven, jlEight, jlNine, jlTen;
    protected JComboBox<String> jtfThree;
    protected int fWidth, fHeight, qtdBotoes, jbY;
    private ReservaTumuloController rtc = new ReservaTumuloController();

    public ReservaTumuloView(int seletor, int seletorCrud, int id){
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
        Component text = switch (i){
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
                        try {
                            rtc.setReservaTumulo(this);
                            msgSucesso();
                        } catch (Exception e) {
                            e.printStackTrace();
                            msgErro(e);
                            return;
                        }
                    } else if (seletorCrud == 3){
                        rtc.updateReservaTumulo(this, id);
                        msgAlterada();
                    } else if(seletorCrud == 4){
                        msgConfirmacaoDelecao(id);
                    }
                    new TelaGerenciadorServico(seletor);
                }
                case 1 -> new TelaGerenciadorServico(seletor);
            };
            dispose();
        });
        this.add(button);
    }

    private void defineLabel(){
        // Label
        jlOne = new JLabel("*Tipo serviço: ");                                // tipoServico
        jlTwo = new JLabel("*Descricao: ");                                   // descricao
        jlThree = new JLabel("*Status Serviço: ");                            // statusServico
        jlFour = new JLabel("*Data Serviço: ");                               // dataServico
        jlFive = new JLabel("*Rua do Túmulo: ");                              // tumRua
        jlSix = new JLabel("*Número Tumulo: ");                               // tumNumero
        jlSeven = new JLabel("*CNPJ Cemitério: ");                            // cemCnpj
        jlEight = new JLabel("<html>*CPF Responsável <br> Serviço: <html/>"); // admCpf
        jlNine = new JLabel("<html>Informações<br>Adicionais: <html/>");      // informacoesAdicionais
        jlTen = new JLabel("<html>*CPF do<br> Comprador: <html/>");           // cpfPessoa == cpfFamiliar
    }

    private void defineText(){
        // Text Field
        jtfOne = new JTextField("Reserva");
        jtfTwo = new JTextField();
        jtfThree = new JComboBox<>(new String[] {"Marcado", "Andamento", "Concluido", "Adiado", "Cancelado"});
        jtfFour = new JTextField();
        jtfFive = new JTextField();
        jtfSix = new JTextField();
        jtfSeven = new JTextField();
        jtfEight = new JTextField();
        jtfNine = new JTextField();
        jtfTen = new JTextField();

        jtfOne.setEditable(false);
    }

    protected void inicializarVariaveis(int seletor){
        // Button
        jbSalvar = new JButton("Salvar");
        jbCancelar = new JButton("Cancelar");

        //Configura tamanho da janela e botões
        fWidth = 500;
        fHeight = 700;
        qtdBotoes = 10;

        // Janela
        this.setTitle("Registro Reserva.");

        // Label
        defineLabel();
        
        // Text Field
        defineText();
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

    protected void msgConfirmacaoDelecao(int id){
        int opcao = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente deletar este registro?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
        );
        if (opcao == JOptionPane.YES_OPTION) {
            rtc.deleteReservaTumulo(id);
            msgDelete();
        }
    }

    protected void msgErro(Exception e){
        JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    // tipoServico
    public String getJtfOne() {
        return jtfOne.getText();
    }

    public void setJtfOne(String value) {
        jtfOne.setText(value);
    }
    
    // descricao
    public String getJtfTwo() {
        return jtfTwo.getText();
    }

    public void setJtfTwo(String value) {
        jtfTwo.setText(value);
    }
    
    // statusServico
    public String getJtfThree() {
        return (String) jtfThree.getSelectedItem();
    }

    public void setJtfThree(String value) {
        jtfThree.setSelectedItem(value);
    }
    
    // dataServico
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String datFormatada = sdf.format(value);
        
        jtfFour.setText(datFormatada);
    }
    
    // tumRua
    public String getJtfFive() {
        return jtfFive.getText();
    }

    public void setJtfFive(String value) {
        jtfFive.setText(value);
    }

    // tumNumero
    public String getJtfSix() {
        return jtfSix.getText();
    }

    public void setJtfSix(String value) {
        jtfSix.setText(value);
    }

    // cemCnpj
    public String getJtfSeven() {
        return jtfSeven.getText();
    }

    public void setJtfSeven(String value) {
        jtfSeven.setText(value);
    }

    // admCpf
    public String getJtfEight() {
        return jtfEight.getText();
    }

    public void setJtfEight(String value) {
        jtfEight.setText(value);
    }
    
    // informacoesAdicionais
    public String getJtfNine() {
        return jtfNine.getText();
    }

    public void setJtfNine(String value) {
        jtfNine.setText(value);
    }
    
    // cpfPessoa == cpfFamiliar
    public String getJtfTen() {
        return jtfTen.getText();
    }

    public void setJtfTen(String value) {
        jtfTen.setText(value);
    }
}