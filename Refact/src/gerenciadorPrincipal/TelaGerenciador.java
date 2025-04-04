package gerenciadorPrincipal;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TelaGerenciador extends JFrame{
	private final JButton jbCemiterio, jbAdm, jbTumulo, jbDefunto, jbServicos;

    public TelaGerenciador(){
        jbCemiterio = new JButton("Cemitério");
        jbAdm = new JButton("Administrador");
        jbTumulo = new JButton("Túmulo");
        jbDefunto = new JButton("Defunto");
        jbServicos = new JButton("Serviços");

        int fWidth = 300;
        int fHeight = 300;

        this.setTitle("Menu Inicial");
        this.setLayout(null);
        this.setSize(fWidth, fHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        // Config dos tamanho dos botões e centralização dos 
        int jbHeight = 30;
        int jbWidth = 120;
        int jbX = (fWidth - jbWidth) / 2;
        int qtdBotoes = 5;
        // Config centralização dos botões
        int y = (fHeight / (qtdBotoes + 1) - (jbHeight / 2));
        if(y < 30){ y = 30; }

        for(int i = 0; i < qtdBotoes; i++){
            int jbY = y * (i + 1);
            JButton button = switch (i){
                case 0 -> jbCemiterio;
                case 1 -> jbAdm;
                case 2 -> jbTumulo;
                case 3 -> jbDefunto;
                case 4 -> jbServicos;
                default -> null;
            };
            if(button != null){
                button.setBounds(jbX, jbY, jbWidth, jbHeight);
                button.addActionListener(e -> dispose());
                this.add(button);
            }
        };

        this.setVisible(true);
    }
}