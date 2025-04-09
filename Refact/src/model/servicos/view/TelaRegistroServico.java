package model.servicos.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaRegistroServico extends JFrame{
    protected JButton jbSalvar, jbCancelar;
    protected JTextField jtfOne, jtfTwo, jtfThree, jtfFour, jtfFive, jtfSix, jtfSeven, jtfEight;
    protected JLabel jlOne, jlTwo, jlThree, jlFour, jlFive, jlSix, jlSeven, jlEight;
    protected int fWidth, fHeight, qtdBotoes, jbY;

    public TelaRegistroServico(int seletor){
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
            button(seletor, i, jbX, y, jbY, jbWidth, jbHeight);
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
        JTextField text = switch (i){
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

    protected void button(int seletor, int i, int jbX, int y, int jbY, int jbWidth, int jbHeight){
        jbY = y * (i + 9);
        int index = i;
        JButton button = switch (index){
            case 0 -> jbSalvar;
            case 1 -> jbCancelar;
            default -> null;
        };
        if(button != null){
            defineBotoes(seletor, button, index, jbX + 70, jbY, jbWidth, jbHeight);
        }
    }

    protected void defineBotoes(int seletor, JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(e -> {
            switch(index){
                case 0 -> new TelaGerenciadorServico(seletor);
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
                jlOne = new JLabel("Registro Exumação.");
                jlTwo = new JLabel("Registro Exumação.");
                jlThree = new JLabel("Registro Exumação.");
                jlFour = new JLabel("Registro Exumação.");
                jlFive = new JLabel("Registro Exumação.");
                jlSix = new JLabel("Registro Exumação.");
                jlSeven = new JLabel("Registro Exumação.");
                jlEight = new JLabel("Registro Exumação.");
                
                // Text Field
                jtfOne = new JTextField("Registro Exumação.");
                jtfTwo = new JTextField("Registro Exumação.");
                jtfThree = new JTextField("Registro Exumação.");
                jtfFour = new JTextField("Registro Exumação.");
                jtfFive = new JTextField("Registro Exumação.");
                jtfSix = new JTextField("Registro Exumação.");
                jtfSeven = new JTextField("Registro Exumação.");
                jtfEight = new JTextField("Registro Exumação.");

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
                jlOne = new JLabel("Registro Manutenção.");
                jlTwo = new JLabel("Registro Manutenção.");
                jlThree = new JLabel("Registro Manutenção.");
                jlFour = new JLabel("Registro Manutenção.");
                jlFive = new JLabel("Registro Manutenção.");
                jlSix = new JLabel("Registro Manutenção.");
                jlSeven = new JLabel("Registro Manutenção.");
                jlEight = new JLabel("Registro Manutenção.");
                
                // Text Field
                jtfOne = new JTextField("Registro Manutenção.");
                jtfTwo = new JTextField("Registro Manutenção.");
                jtfThree = new JTextField("Registro Manutenção.");
                jtfFour = new JTextField("Registro Manutenção.");
                jtfFive = new JTextField("Registro Manutenção.");
                jtfSix = new JTextField("Registro Manutenção.");
                jtfSeven = new JTextField("Registro Manutenção.");
                jtfEight = new JTextField("Registro Manutenção.");

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
                jlOne = new JLabel("Registro Reserva.");
                jlTwo = new JLabel("Registro Reserva.");
                jlThree = new JLabel("Registro Reserva.");
                jlFour = new JLabel("Registro Reserva.");
                jlFive = new JLabel("Registro Reserva.");
                jlSix = new JLabel("Registro Reserva.");
                jlSeven = new JLabel("Registro Reserva.");
                jlEight = new JLabel("Registro Reserva.");
                
                // Text Field
                jtfOne = new JTextField("Registro Reserva.");
                jtfTwo = new JTextField("Registro Reserva.");
                jtfThree = new JTextField("Registro Reserva.");
                jtfFour = new JTextField("Registro Reserva.");
                jtfFive = new JTextField("Registro Reserva.");
                jtfSix = new JTextField("Registro Reserva.");
                jtfSeven = new JTextField("Registro Reserva.");
                jtfEight = new JTextField("Registro Reserva.");

                break;
            }
            case 4: {
                //Configura tamanho da janela e botões
                fWidth = 500;
                fHeight = 700;
                qtdBotoes = 8;

                // Janela
                this.setTitle("Registro Transferencia.");
                
                // Label
                jlOne = new JLabel("Registro Transferencia.");
                jlTwo = new JLabel("Registro Transferencia.");
                jlThree = new JLabel("Registro Transferencia.");
                jlFour = new JLabel("Registro Transferencia.");
                jlFive = new JLabel("Registro Transferencia.");
                jlSix = new JLabel("Registro Transferencia.");
                jlSeven = new JLabel("Registro Transferencia.");
                jlEight = new JLabel("Registro Transferencia.");
                
                // Text Field
                jtfOne = new JTextField("Registro Transferencia.");
                jtfTwo = new JTextField("Registro Transferencia.");
                jtfThree = new JTextField("Registro Transferencia.");
                jtfFour = new JTextField("Registro Transferencia.");
                jtfFive = new JTextField("Registro Transferencia.");
                jtfSix = new JTextField("Registro Transferencia.");
                jtfSeven = new JTextField("Registro Transferencia.");
                jtfEight = new JTextField("Registro Transferencia.");

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
                jlOne = new JLabel("Registro Vistoria.");
                jlTwo = new JLabel("Registro Vistoria.");
                jlThree = new JLabel("Registro Vistoria.");
                jlFour = new JLabel("Registro Vistoria.");
                jlFive = new JLabel("Registro Vistoria.");
                jlSix = new JLabel("Registro Vistoria.");
                jlSeven = new JLabel("Registro Vistoria.");
                jlEight = new JLabel("Registro Vistoria.");
                
                // Text Field
                jtfOne = new JTextField("Registro Vistoria.");
                jtfTwo = new JTextField("Registro Vistoria.");
                jtfThree = new JTextField("Registro Vistoria.");
                jtfFour = new JTextField("Registro Vistoria.");
                jtfFive = new JTextField("Registro Vistoria.");
                jtfSix = new JTextField("Registro Vistoria.");
                jtfSeven = new JTextField("Registro Vistoria.");
                jtfEight = new JTextField("Registro Vistoria.");

                break;
            }
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

    protected void msgConfirmacaoAlteracao(){
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
}