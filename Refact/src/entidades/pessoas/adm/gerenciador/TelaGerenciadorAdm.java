package entidades.pessoas.adm.gerenciador;

import javax.swing.JButton;
import javax.swing.JFrame;
import gerenciadorPrincipal.TelaGerenciador;

public class TelaGerenciadorAdm extends JFrame{
    private JButton jbCreate, jbRead, jbList, jbUpdate, jbDelete, jbVoltar;

    public TelaGerenciadorAdm(){
        inicializarVariaveis();
        
        int fWidth = 300;
        int fHeight = 300;

        this.setTitle("Menu Cemitério");
        this.setLayout(null);
        this.setSize(fWidth, fHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        // Config dos tamanho dos botões e centralização dos 
        int jbHeight = 30;
        int jbWidth = 160;
        int jbX = (fWidth - jbWidth) / 2;
        int qtdBotoes = 5;
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
                button.setBounds(jbX, jbY, jbWidth, jbHeight);
                button.addActionListener(e -> {
                    switch(index){
                        case 0 -> new TelaGerenciador(); // TROCAR ENTIDADE
                        case 1 -> new TelaGerenciador(); // TROCAR ENTIDADE
                        case 2 -> new TelaGerenciador(); // TROCAR ENTIDADE
                        case 3 -> new TelaGerenciador(); // TROCAR ENTIDADE
                        case 4 -> new TelaGerenciador(); // TROCAR ENTIDADE
                        case 5 -> new TelaGerenciador();
                    }
                    dispose();
                });
                this.add(button);
            }
        };

        this.setVisible(true);
    }

    private void inicializarVariaveis(){
        jbCreate = new JButton("Cadastrar Coveiro.");
        jbRead = new JButton("Apresentar Coveiro.");
        jbList = new JButton("Listar Coveiro.");
        jbUpdate = new JButton("Alterar Coveiro.");
        jbDelete = new JButton("Deletar Coveiro.");
        jbVoltar = new JButton("Voltar");
    }
}

/*public void setAdm(Adm a){
        System.out.println("Digite seu nome: ");
        a.setNome(teclado.nextLine());
        System.out.println("Digite seu CPF: ");
        a.setCpf(teclado.nextLine());
        System.out.println("Digite seu RG: ");
        a.setRg(teclado.nextLine());
        System.out.println("Digite sua data de nascimento: ");
        a.setDataNascimento(teclado.nextLine());
        System.out.println("Digite seu e-mail: ");
        a.setEmail(teclado.nextLine());
        System.out.println("Digite seu telefone: ");
        a.setTelefone(teclado.nextLine());
        System.out.println("Digite seu cargo: ");
        a.setCargo(teclado.nextLine());
        System.out.println("Digite a data de contratação: ");
        a.setDataContratacao(teclado.nextLine());
    }

    public void getAdm(Adm a){
        if(a != null){
            System.out.println("Nome: " + a.getNome());
            System.out.println("CPF: " + a.getCpf());
            System.out.println("RG: " + a.getRg());
            System.out.println("Data de Contratação: " + a.getDataContratacao());
            System.out.println("Data de Nascimento: " + a.getDataNascimento());
            System.out.println("E-mail: " + a.getEmail());
            System.out.println("Telefone: " + a.getCargo());
            System.out.println("Data de Contratação: " + a.getDataContratacao());
        } else {
            msgIdInexistente();
        }
    }*/