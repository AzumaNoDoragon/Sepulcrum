package gerenciadorPrincipal.utils;

import javax.swing.JFrame;
import javax.swing.JButton;

public abstract class TelaMenu extends JFrame{
    protected JButton jbCreate, jbRead, jbList, jbUpdate, jbDelete, jbVoltar;
    protected int fWidth, fHeight, qtdBotoes;

    public TelaMenu(){
        inicializarVariaveis();

        // Janela
        this.setLayout(null);
        this.setSize(fWidth, fHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        // Config dos tamanho dos botões e centralização 
        int jbHeight = 30;
        int jbWidth = 160;
        int jbX = (fWidth - jbWidth) / 2;

        // Config centralização dos botões
        int y = (fHeight / (qtdBotoes + 1) - (jbHeight / 2));
        if(y < 30){ y = 30; }

        for(int i = 0; i < qtdBotoes; i++){
            int jbY = y * (i + 1);
            int index = i;
            JButton button = switch (index){
                case 0 -> jbCreate;
                case 1 -> jbRead;
                case 2 -> jbList;
                case 3 -> jbUpdate;
                case 4 -> jbDelete;
                case 5 -> jbVoltar;
                default -> null;
            };
            if(button != null){
                defineBotoes(button, index, jbX, jbY, jbWidth, jbHeight);
            }
        };

        this.setVisible(true);
    }
    
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(e -> {
            switch(index){
                case 0 -> dispose(); // TROCAR ENTIDADE
                case 1 -> dispose(); // TROCAR ENTIDADE
                case 2 -> dispose(); // TROCAR ENTIDADE
                case 3 -> dispose(); // TROCAR ENTIDADE
                case 4 -> dispose(); // TROCAR ENTIDADE
                case 5 -> dispose(); // TROCAR ENTIDADE
            }
            dispose();
        });
        this.add(button);
    }

    protected void inicializarVariaveis(){
        //Configura tamanho da janela e botões
        fWidth = 300;
        fHeight = 350;
        qtdBotoes = 6;

        // Janela
        this.setTitle("DEFINIR TÍTULO");

        // Button
        jbCreate = new JButton();
        jbRead = new JButton();
        jbList = new JButton();
        jbUpdate = new JButton();
        jbDelete = new JButton();
        jbVoltar = new JButton();
    }
}