package entidades.localidade.cemiterio.gerenciador;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TelaGerenciadorCemiterio extends JFrame{
    private JButton jbCreate, jbRead, jbList, jbUpdate, jbDelete, jbVoltar;

    public TelaGerenciadorCemiterio(){
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
            JButton button = switch (i){
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
                button.addActionListener(e -> dispose());
                this.add(button);
            }
        };

        this.setVisible(true);
    }

    private void inicializarVariaveis(){
        jbCreate = new JButton("Cadastrar Cemitério.");
        jbRead = new JButton("Apresentar Cemitério.");
        jbList = new JButton("Listar Cemitério.");
        jbUpdate = new JButton("Alterar Cemitério.");
        jbDelete = new JButton("Deletar Cemitério.");
        jbVoltar = new JButton("Voltar");
    }
}
    /*public void setCemiterio(Cemiterio c){
        System.out.println("Digite o nome do Cemitério: ");
        c.setNome(teclado.nextLine());
        System.out.println("Digite o estado: ");
        c.setEstado(teclado.nextLine());
        System.out.println("Digite o cidade: ");
        c.setCidade(teclado.nextLine());
        System.out.println("Digite a rua: ");
        c.setRua(teclado.nextLine());
        System.out.println("Digite o número do lote: ");
        c.setNumero(teclado.nextInt()); teclado.nextLine();
        System.out.println("Digite o capacidade máxima: ");
        c.setCapacidadeMax(teclado.nextInt()); teclado.nextLine();
        System.out.println("Digite o telefone: ");
        c.setTelefone(teclado.nextLine());
        System.out.println("Digite o cep: ");
        c.setCep(teclado.nextLine());
    }
    
    public void getCemiterio(Cemiterio c){
        if(c != null){ 
            System.out.println("Nome do cemiterio: " + c.getNome());
            System.out.println("Estado: " + c.getEstado());
            System.out.println("Cidade: " + c.getCidade());
            System.out.println("Rua: " + c.getRua());
            System.out.println("Numero: " + c.getNumero());
            System.out.println("Capacidade máxima: " + c.getCapacidadeMax());
            System.out.println("Telefone: " + c.getTelefone());
            System.out.println("Cep: " + c.getCep());
        } else {
            msgIdInexistente();
        }
    } */