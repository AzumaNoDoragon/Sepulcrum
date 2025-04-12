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
                jlOne = new JLabel("Tipo serviço:");
                jlTwo = new JLabel("Descricao");
                jlThree = new JLabel("Status Serviço");
                jlFour = new JLabel("Data Servico");
                jlFive = new JLabel("Id Defunto");
                jlSix = new JLabel("Id Tumulo");
                jlSeven = new JLabel("Id Responsavel Servico");
                jlEight = new JLabel("Informações Adicionais");
                
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
                /*
                    protected String dataServico, descricao, informacoesAdicionais, statusServico;
                    protected int idResponsavelServico, idTumulo;
                */
                // Label
                jlOne = new JLabel("Tipo serviço:");
                jlTwo = new JLabel("");
                jlThree = new JLabel("");
                jlFour = new JLabel("");
                jlFive = new JLabel("");
                jlSix = new JLabel("");
                jlSeven = new JLabel("");
                jlEight = new JLabel("");
                
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
            case 3: {
                //Configura tamanho da janela e botões
                fWidth = 500;
                fHeight = 700;
                qtdBotoes = 8;

                // Janela
                this.setTitle("Registro Reserva.");
                /*
                    protected String dataServico, descricao, informacoesAdicionais, statusServico;
                    private int idPessoa, idResponsavelServico, idTumulo;
                */
                // Label
                jlOne = new JLabel("Tipo serviço:");
                jlTwo = new JLabel("");
                jlThree = new JLabel("");
                jlFour = new JLabel("");
                jlFive = new JLabel("");
                jlSix = new JLabel("");
                jlSeven = new JLabel("");
                jlEight = new JLabel("");
                
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
            case 4: {
                //Configura tamanho da janela e botões
                fWidth = 500;
                fHeight = 700;
                qtdBotoes = 8;

                // Janela
                this.setTitle("Registro Transferencia.");
                /*
                    protected String dataServico, descricao, informacoesAdicionais, statusServico;
                    private int idTumuloDestino, idDefunto, idTumulo, idResponsavelServico;
                */
                // Label
                jlOne = new JLabel("Tipo serviço:");
                jlTwo = new JLabel("");
                jlThree = new JLabel("");
                jlFour = new JLabel("");
                jlFive = new JLabel("");
                jlSix = new JLabel("");
                jlSeven = new JLabel("");
                jlEight = new JLabel("");
                
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
            case 5: {
                //Configura tamanho da janela e botões
                fWidth = 500;
                fHeight = 700;
                qtdBotoes = 8;

                // Janela
                this.setTitle("Registro Vistoria.");
                /*
                    protected String dataServico, descricao, informacoesAdicionais, statusServico;
                    protected int idTumulo, idResponsavelServico;
                */
                // Label
                jlOne = new JLabel("Tipo serviço:");
                jlTwo = new JLabel("");
                jlThree = new JLabel("");
                jlFour = new JLabel("");
                jlFive = new JLabel("");
                jlSix = new JLabel("");
                jlSeven = new JLabel("");
                jlEight = new JLabel("");
                
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