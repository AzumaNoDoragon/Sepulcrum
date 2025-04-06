package core.utils;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public abstract class TelaRegistro extends JFrame{
    protected JButton jbProx, jbCancelar;
    protected JTextField jtfNome, jtfEstado, jtfCidade, jtfRua, jtfNumero, jtfCapacidadeMax, jtfTelefone, jtfCep;
    protected JLabel jlNome, jlEstado, jlCidade, jlRua, jlNumero, jlCapacidadeMax, jlTelefone, jlCep;
    protected int fWidth, fHeight, qtdBotoes;

    public TelaRegistro(){
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
            int jbY = y * (i + 9);
            if(i == 1){jbY = jbY - 15;}
            jbWidth = 150;
            button(i, jbX + 70, jbY, jbWidth, jbHeight);
        };
        
        this.setVisible(true);
    }

    private void label(int i, int jbX, int jbY, int jbWidth, int jbHeight){
        JLabel label = switch (i){
            case 0 -> jlNome;
            case 1 -> jlEstado;
            case 2 -> jlCidade;
            case 3 -> jlRua;
            case 4 -> jlNumero;
            case 5 -> jlCapacidadeMax;
            case 6 -> jlTelefone;
            case 7 -> jlCep;
            default -> null;
        };
        if(label != null){
            label.setBounds(jbX, jbY, jbWidth, jbHeight);
            this.add(label);
        }
    }

    protected void text(int i, int jbX, int jbY, int jbWidth, int jbHeight){
        JTextField text = switch (i){
            case 0 -> jtfNome;
            case 1 -> jtfEstado;
            case 2 -> jtfCidade;
            case 3 -> jtfRua;
            case 4 -> jtfNumero;
            case 5 -> jtfCapacidadeMax;
            case 6 -> jtfTelefone;
            case 7 -> jtfCep;
            default -> null;
        };
        if(text != null){
            text.setBounds(jbX, jbY, jbWidth, jbHeight);
            this.add(text);
        }
    }

    protected void button(int i, int jbX, int jbY, int jbWidth, int jbHeight){
        int index = i;
        JButton button = switch (index){
            case 0 -> jbProx;
            case 1 -> jbCancelar;
            default -> null;
        };
        if(button != null){
            defineBotoes(button, index, jbX, jbY, jbWidth, jbHeight);
        }
    }

    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(e -> {
            switch(index){
                case 0 -> dispose(); // TROCAR ENTIDADE
                case 1 -> dispose(); // TROCAR ENTIDADE
            };
            dispose();
        });
        this.add(button);
    }

    protected void inicializarVariaveis(){
        //Configura tamanho da janela e botões
        fWidth = 500;
        fHeight = 700;
        qtdBotoes = 8;
        
        // Janela
        this.setTitle("DEFINIR TÍTULO");

        // Button
        jbProx = new JButton();
        jbCancelar = new JButton();
        
        // Label
        jlNome = new JLabel();
        jlEstado = new JLabel();
        jlCidade = new JLabel();
        jlRua = new JLabel();
        jlNumero = new JLabel();
        jlCapacidadeMax = new JLabel();
        jlTelefone = new JLabel();
        jlCep = new JLabel();

        // Text Field
        jtfNome = new JTextField();
        jtfEstado = new JTextField();
        jtfCidade = new JTextField();
        jtfRua = new JTextField();
        jtfNumero = new JTextField();
        jtfCapacidadeMax = new JTextField();
        jtfTelefone = new JTextField();
        jtfCep = new JTextField();
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