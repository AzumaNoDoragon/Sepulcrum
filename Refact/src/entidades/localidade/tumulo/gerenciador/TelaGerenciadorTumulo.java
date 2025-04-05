package entidades.localidade.tumulo.gerenciador;

import javax.swing.JButton;

import gerenciadorPrincipal.utils.TelaMenu;
import gerenciadorPrincipal.view.TelaGerenciador;

public class TelaGerenciadorTumulo extends TelaMenu{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(e -> {
            switch(index){
                case 0 -> new TelaGerenciadorTumulo(); // TROCAR ENTIDADE
                case 1 -> new TelaGerenciadorTumulo(); // TROCAR ENTIDADE
                case 2 -> new TelaGerenciadorTumulo(); // TROCAR ENTIDADE
                case 3 -> new TelaGerenciadorTumulo(); // TROCAR ENTIDADE
                case 4 -> new TelaGerenciadorTumulo(); // TROCAR ENTIDADE
                case 5 -> new TelaGerenciador();
            }
            dispose();
        });
        this.add(button);
    }

    @Override
    protected void inicializarVariaveis(){
        //Configura tamanho da janela e botões
        fWidth = 300;
        fHeight = 350;
        qtdBotoes = 6;
        
        // Janela
        this.setTitle("Menu Túmulo");

        // Button
        jbCreate = new JButton("Cadastrar Túmulo.");
        jbRead = new JButton("Apresentar Túmulo.");
        jbList = new JButton("Listar Túmulo.");
        jbUpdate = new JButton("Alterar Túmulo.");
        jbDelete = new JButton("Deletar Túmulo.");
        jbVoltar = new JButton("Voltar");
    }
}
    /*public TelaTumulo(Scanner teclado) {
        super(teclado);
    }

    @Override
    public int menu(){
        System.out.println("Menu do Túmulo: ");
        System.out.println("1 - Cadastrar Túmulo.");
        System.out.println("2 - Apresentar Túmulo.");
        System.out.println("3 - Listar Túmulo.");
        System.out.println("4 - Alterar Túmulo.");
        System.out.println("5 - Deletar Túmulo.");
        System.out.println("0 - Voltar");
        int opc = teclado.nextInt(); teclado.nextLine();

        return opc;
    }

    public void setTumulo(Tumulo t){
        System.out.println("Digite o tipo do tumulo: ");
        t.setTipo(teclado.nextLine());
        System.out.println("Digite a data de ocupação: ");
        t.setDataOcupacao(teclado.nextLine());
        System.out.println("Digite a situação: ");
        t.setSituacao(teclado.nextLine());
        System.out.println("Digite o id do cemiterio: ");
        t.setIdCemiterio(teclado.nextInt()); teclado.nextLine();
        System.out.println("Digite o bloco do Tumulo: ");
        t.setRua(teclado.nextLine());
        System.out.println("Digite o número do Túmulo: ");
        t.setNumero(teclado.nextInt()); teclado.nextLine();
        System.out.println("Digite o id do defunto: ");
        t.setIdDefunto(teclado.nextInt()); teclado.nextLine();
    }
    
    public void getTumulo(Tumulo t){
        if(t != null){
            System.out.println("Tipo do tumulo: " + t.getTipo());
            System.out.println("Data de ocupação: " + t.getDataOcupacao());
            System.out.println("Situação: " + t.getSituacao());
            System.out.println("Id do cemiterio: " + t.getIdCemiterio());
            System.out.println("Id do defunto: " + t.getIdDefunto());
        } else {
            msgIdInexistente();
        }
    }*/