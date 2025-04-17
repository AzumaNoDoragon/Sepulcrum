package model.servicos.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.servicos.core.controller.GerenciadorServicos;
import model.servicos.exumacao.Exumacao;

public class TelaRegistroServico extends JFrame{
    protected JButton jbSalvar, jbCancelar;
    protected JTextField jtfOne, jtfTwo, jtfThree, jtfFour, jtfFive, jtfSix, jtfSeven, jtfEight, jtfNine, jtfTen;
    protected JLabel jlOne, jlTwo, jlThree, jlFour, jlFive, jlSix, jlSeven, jlEight, jlNine, jlTen;
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
                        gs.setServico(this, seletor);
                        msgSucesso();
                    } else if (seletorCrud == 3){
                        msgAlterada();
                    } else if(seletorCrud == 4){
                        msgConfirmacaoDelecao();
                    }
                    new TelaGerenciadorServico(seletor);
                }
                case 1 -> new TelaGerenciadorServico(seletor);
            };
            dispose();
        });
        this.add(button);
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
                qtdBotoes = 8;

                // Janela
                this.setTitle("Registro Exumação.");

                // Label
                jlOne = new JLabel("Tipo serviço:"); //adicionar a classe de herança
                jlTwo = new JLabel("Descricao");
                jlThree = new JLabel("Status Serviço");
                jlFour = new JLabel("Data Serviço");
                jlFive = new JLabel("Id Defunto");
                jlSix = new JLabel("Id Tumulo");
                jlSeven = new JLabel("<html>Id do Responsavel<br>pelo Serviço:</html>");
                jlEight = new JLabel("<html>Informações<br>Adicionais:</html>");
                
                // Text Field
                jtfOne = new JTextField("Exumação");
                jtfTwo = new JTextField();
                jtfThree = new JTextField();
                jtfFour = new JTextField();
                jtfFive = new JTextField();
                jtfSix = new JTextField();
                jtfSeven = new JTextField();
                jtfEight = new JTextField();

                break;
            }
            case 2: {
                //Configura tamanho da janela e botões
                fWidth = 500;
                fHeight = 700;
                qtdBotoes = 8;

                // Janela
                this.setTitle("Registro Manutenção.");

                // Label
                jlOne = new JLabel("Tipo serviço:"); //adicionar a classe de herança
                jlTwo = new JLabel("Descricao");
                jlThree = new JLabel("Status Serviço");
                jlFour = new JLabel("Data Serviço");
                jlFive = new JLabel("Id Tumulo");
                jlSix = new JLabel("<html>Id do Responsavel<br>pelo Serviço:</html>");
                jlSeven = new JLabel("<html>Informações<br>Adicionais:</html>");
                
                // Text Field
                jtfOne = new JTextField("Manutenção");
                jtfTwo = new JTextField();
                jtfThree = new JTextField();
                jtfFour = new JTextField();
                jtfFive = new JTextField();
                jtfSix = new JTextField();
                jtfSeven = new JTextField();

                break;
            }
            case 3: {
                //Configura tamanho da janela e botões
                fWidth = 500;
                fHeight = 700;
                qtdBotoes = 8;

                // Janela
                this.setTitle("Registro Reserva.");

                // Label
                jlOne = new JLabel("Tipo serviço:"); // adicionar a classe de herança
                jlTwo = new JLabel("Descricao");
                jlThree = new JLabel("Status Serviço");
                jlFour = new JLabel("Data Serviço");
                jlFive = new JLabel("Id Comprador"); // comprador == familiar
                jlSix = new JLabel("Id Tumulo");
                jlSeven = new JLabel("<html>Id do Responsavel<br>pelo Serviço:</html>");
                jlEight = new JLabel("<html>Informações<br>Adicionais:</html>");
                
                // Text Field
                jtfOne = new JTextField("Reserva");
                jtfTwo = new JTextField();
                jtfThree = new JTextField();
                jtfFour = new JTextField();
                jtfFive = new JTextField();
                jtfSix = new JTextField();
                jtfSeven = new JTextField();
                jtfEight = new JTextField();

                break;
            }
            case 4: {
                //Configura tamanho da janela e botões
                fWidth = 500;
                fHeight = 700;
                qtdBotoes = 9;

                // Janela
                this.setTitle("Registro Transferência.");

                // Label
                jlOne = new JLabel("Tipo serviço:"); //adicionar a classe de herança
                jlTwo = new JLabel("Descricao");
                jlThree = new JLabel("Status Serviço");
                jlFour = new JLabel("Data Serviço");
                jlFive = new JLabel("Id Defunto");
                jlSix = new JLabel("Id Tumulo");
                jlSeven = new JLabel("Id Destino");
                jlEight = new JLabel("<html>Id do Responsavel<br>pelo Serviço:</html>");
                jlNine = new JLabel("<html>Informações<br>Adicionais:</html>");
                
                // Text Field
                jtfOne = new JTextField("Transferência");
                jtfTwo = new JTextField();
                jtfThree = new JTextField();
                jtfFour = new JTextField();
                jtfFive = new JTextField();
                jtfSix = new JTextField();
                jtfSeven = new JTextField();
                jtfEight = new JTextField();
                jtfNine = new JTextField();

                break;
            }
            case 5: {
                //Configura tamanho da janela e botões
                fWidth = 500;
                fHeight = 700;
                qtdBotoes = 8;

                // Janela
                this.setTitle("Registro Vistoria.");

                // Label
                jlOne = new JLabel("Tipo serviço:"); //adicionar a classe de herança
                jlTwo = new JLabel("Descricao:");
                jlThree = new JLabel("Status do Serviço:");
                jlFour = new JLabel("Data do Serviço:");
                jlFive = new JLabel("Id do Tumulo:");
                jlSix = new JLabel("<html>Id do Responsavel<br>pelo Serviço:</html>");
                jlSeven = new JLabel("<html>Informações<br>Adicionais:</html>");
                
                // Text Field
                jtfOne = new JTextField("Vistoria");
                jtfTwo = new JTextField();
                jtfThree = new JTextField();
                jtfFour = new JTextField();
                jtfFive = new JTextField();
                jtfSix = new JTextField();
                jtfSeven = new JTextField();

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