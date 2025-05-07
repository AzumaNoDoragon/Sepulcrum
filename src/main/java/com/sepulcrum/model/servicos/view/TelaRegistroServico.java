package com.sepulcrum.model.servicos.view;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sepulcrum.model.servicos.controller.GerenciadorServicos;

public class TelaRegistroServico extends JFrame{
    protected JButton jbSalvar, jbCancelar;
    protected JTextField jtfOne, jtfTwo, jtfThree, jtfFour, jtfFive, jtfSix, jtfSeven, jtfEight, jtfNine, jtfTen, jtfEleven, jtfTwelve, jtfThirteen;
    protected JLabel jlOne, jlTwo, jlThree, jlFour, jlFive, jlSix, jlSeven, jlEight, jlNine, jlTen, jlEleven, jlTwelve, jlThirteen;
    protected int fWidth, fHeight, qtdBotoes, jbY;
    private GerenciadorServicos gs = new GerenciadorServicos();

    public TelaRegistroServico(int seletor, int seletorCrud, int id){
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
            case 9 -> jlTen;
            case 10 -> jlEleven;
            case 11 -> jlTwelve;
            case 12 -> jlThirteen;
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
            case 10 -> jtfEleven;
            case 11 -> jtfTwelve;
            case 12 -> jtfThirteen;
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
                    try {
                        if(seletorCrud == 1){
                            try {
                                if(seletor == 1){
                                    gs.setExumacao(this);
                                } else if(seletor == 2){
                                    gs.setManutencaoTumulo(this);
                                    System.out.println("Debug 2");
                                } else if(seletor == 3){
                                    gs.setReservaTumulo(this);
                                    System.out.println("Debug 3");
                                } else if(seletor == 4){
                                    gs.setTransferenciaDefunto(this);
                                    System.out.println("Debug 4");
                                } else if(seletor == 5){
                                    gs.setVistoria(this);
                                    System.out.println("Debug 5");
                                }
                                msgSucesso();
                            } catch (Exception e) {
                                e.printStackTrace();
                                msgErro(e);
                                return;
                            }
                        } else if (seletorCrud == 3){
                            msgAlterada();
                        } else if(seletorCrud == 4){
                            msgConfirmacaoDelecao();
                        }
                        new TelaGerenciadorServico(seletor);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 1 -> new TelaGerenciadorServico(seletor);
            };
            dispose();
        });
        this.add(button);
    }

    private void defineLabel(){
        // Label
        jlOne = new JLabel("*Tipo serviço: "); // tipoServico
        jlTwo = new JLabel("*Descricao: "); // descricao
        jlThree = new JLabel("*Status Serviço: "); // statusServico
        jlFour = new JLabel("*Data Serviço: "); // dataServico
        jlFive = new JLabel("*Rua do Túmulo: "); // tumRua
        jlSix = new JLabel("*Número Tumulo: "); // tumNumero
        jlSeven = new JLabel("*CNPJ Cemitério: "); // cemCnpj
        jlEight = new JLabel("<html>*CPF Responsável <br> Serviço: <html/>"); // admCpf
        jlNine = new JLabel("<html>Informações<br>Adicionais: <html/>"); // informacoesAdicionais
    }

    private void defineText(){
        // Text Field
        jtfTwo = new JTextField();
        jtfThree = new JTextField();
        jtfFour = new JTextField();
        jtfFive = new JTextField();
        jtfSix = new JTextField();
        jtfSeven = new JTextField();
        jtfEight = new JTextField();
        jtfNine = new JTextField();
    }

    protected void inicializarVariaveis(int seletor){
        // Button
        jbSalvar = new JButton("Salvar");
        jbCancelar = new JButton("Cancelar");
        
        switch(seletor){
            case 1: {
                //Configura tamanho da janela e botões
                fWidth = 500;
                fHeight = 700;
                qtdBotoes = 10;

                // Janela
                this.setTitle("Registro Exumação.");

                // Label
                defineLabel();
                jlTen = new JLabel("*Certidão de Óbito: "); // finCertidaoObito

                // Text Field
                jtfOne = new JTextField("Exumação");
                defineText();
                jtfTen = new JTextField();

                break;
            }
            case 2: {
                //Configura tamanho da janela e botões
                fWidth = 500;
                fHeight = 700;
                qtdBotoes = 9;

                // Janela
                this.setTitle("Registro Manutenção.");

                // Label
                defineLabel();

                // Text Field
                jtfOne = new JTextField("Manutenção");
                defineText();

                break;
            }
            case 3: {
                //Configura tamanho da janela e botões
                fWidth = 500;
                fHeight = 700;
                qtdBotoes = 10;

                // Janela
                this.setTitle("Registro Reserva.");

                // Label
                defineLabel();
                jlTen = new JLabel("<html>*CPF do<br> Comprador: <html/>"); // cpfPessoa == cpfFamiliar
                
                // Text Field
                jtfOne = new JTextField("Reserva");
                defineText();
                jtfTen = new JTextField();

                break;
            }
            case 4: {
                //Configura tamanho da janela e botões
                fWidth = 500;
                fHeight = 800;
                qtdBotoes = 13;

                // Janela
                this.setTitle("Registro Transferência.");

                // Label
                defineLabel();
                jlTen = new JLabel("<html>*Rua Túmulo <br> destino: <html/>"); // tumRuaDestino
                jlEleven = new JLabel("<html>*Número Túmulo <br> destino: <html/>"); // tumNumeroDestino
                jlTwelve = new JLabel("<html>*CNPJ Cemitério <br> destino: <html/>"); // cemCnpjDestino
                jlThirteen = new JLabel("*Certidão de Óbito: "); // finCertidaoObito
                
                // Text Field
                jtfOne = new JTextField("Transferência");
                defineText();
                jtfTen = new JTextField();
                jtfEleven = new JTextField();
                jtfTwelve = new JTextField();
                jtfThirteen = new JTextField();

                break;
            }
            case 5: {
                //Configura tamanho da janela e botões
                fWidth = 500;
                fHeight = 700;
                qtdBotoes = 9;

                // Janela
                this.setTitle("Registro Vistoria.");

                // Label
                defineLabel();

                // Text Field
                jtfOne = new JTextField("Vistoria");
                defineText();

                break;
            }
        }
        jtfOne.setEditable(false);
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

    protected void msgErro(Exception e){
        JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public String getJtfOne() { // tipoServico
        return jtfOne.getText();
    }

    public String getJtfTwo() { // descricao
        return jtfTwo.getText();
    }

    public String getJtfThree() { // statusServico
        return jtfThree.getText();
    }

    public Date getJtfFour() { // dataServico
        String text = jtfFour.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            java.util.Date utilDate = sdf.parse(text);
            return new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public String getJtfFive() { // tumRua
        return jtfFive.getText();
    }

    public String getJtfSix() { // tumNumero
        return jtfSix.getText();
    }

    public String getJtfSeven() { // cemCnpj
        return jtfSeven.getText();
    }

    public String getJtfEight() { // admCpf
        return jtfEight.getText();
    }

    public String getJtfNine() { // informacoesAdicionais
        return jtfNine.getText();
    }

    public String getJtfTen() {
        return jtfTen.getText();
    }

    public String getJtfEleven() {
        return jtfEleven.getText();
    }
    
    public String getJtfTwelve() {
        return jtfTwelve.getText();
    }
    
    public String getJtfThirteen() {
        return jtfThirteen.getText();
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

    public void setJtfFour(Date value) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String datFormatada = sdf.format(value);
        
        jtfFour.setText(datFormatada);
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

    public void setJtfEleven(String value) {
        jtfEleven.setText(value);
    }
    
    public void setJtfTwelve(String value) {
        jtfTwelve.setText(value);
    }
    
    public void setJtfThirteen(String value) {
        jtfThirteen.setText(value);
    }
}