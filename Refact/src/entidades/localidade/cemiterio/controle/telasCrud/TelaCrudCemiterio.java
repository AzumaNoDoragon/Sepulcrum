package entidades.localidade.cemiterio.controle.telasCrud;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class TelaCrudCemiterio extends JFrame{
    private JButton jbProx, jbCancelar;
    private JTextField jtfNome, jtfEstado, jtfCidade, jtfRua, jtfNumero, jtfCapacidadeMax, jtfTelefone, jtfCep;
    private JLabel jlNome, jlEstado, jlCidade, jlRua, jlNumero, jlCapacidadeMax, jlTelefone, jlCep;

    public TelaCrudCemiterio(){
        inicializarVariaveis();

        int fWidth = 500;
        int fHeight = 700;

        this.setTitle("Menu Cemitério");
        this.setLayout(null);
        this.setSize(fWidth, fHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        // Config dos tamanho dos botões
        int jbHeight = 30;
        int jbWidth = 160;
        int jbX = (fWidth - jbWidth) / 2;
        int qtdBotoes = 8;
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

    private void text(int i, int jbX, int jbY, int jbWidth, int jbHeight){
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

    private void button(int i, int jbX, int jbY, int jbWidth, int jbHeight){
        JButton button = switch (i){
            case 0 -> jbProx;
            case 1 -> jbCancelar;
            default -> null;
        };
        if(button != null){
            button.setBounds(jbX, jbY, jbWidth, jbHeight);
            button.addActionListener(e -> dispose());
            this.add(button);
        }
    }
    
    private void inicializarVariaveis(){
        // Button
        jbProx = new JButton("Próximo");
        jbCancelar = new JButton("Cancelar");
        
        // Label
        jlNome = new JLabel("Nome: ");
        jlEstado = new JLabel("Estado: ");
        jlCidade = new JLabel("Cidade: ");
        jlRua = new JLabel("Rua: ");
        jlNumero = new JLabel("Numero: ");
        jlCapacidadeMax = new JLabel("Capacidade: ");
        jlTelefone = new JLabel("Telefone: ");
        jlCep = new JLabel("Cep: ");

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
}