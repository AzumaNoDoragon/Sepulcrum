package gerenciadorPrincipal.heranca;

import javax.swing.JFrame;
import javax.swing.JButton;
import gerenciadorPrincipal.TelaGerenciador;

public abstract class TelaMenu extends JFrame{
    protected JButton jbCreate, jbRead, jbList, jbUpdate, jbDelete, jbVoltar;

    public TelaMenu(){
        inicializarVariaveis();
        
        int fWidth = 300;
        int fHeight = 350;

        this.setLayout(null);
        this.setSize(fWidth, fHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        // Config dos tamanho dos botões e centralização dos 
        int jbHeight = 30;
        int jbWidth = 160;
        int jbX = (fWidth - jbWidth) / 2;
        int qtdBotoes = 6;
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
                case 0 -> new TelaGerenciador(); // TROCAR ENTIDADE
                case 1 -> new TelaGerenciador(); // TROCAR ENTIDADE
                case 2 -> new TelaGerenciador(); // TROCAR ENTIDADE
                case 3 -> new TelaGerenciador(); // TROCAR ENTIDADE
                case 4 -> new TelaGerenciador(); // TROCAR ENTIDADE
                case 5 -> new TelaGerenciador(); // TROCAR ENTIDADE
            }
            dispose();
        });
        this.add(button);
    }

    protected void inicializarVariaveis(){
        this.setTitle("Menu Cemitério");
        jbCreate = new JButton();
        jbRead = new JButton();
        jbList = new JButton();
        jbUpdate = new JButton();
        jbDelete = new JButton();
        jbVoltar = new JButton();
    }
}