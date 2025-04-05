package entidades.localidade.cemiterio.view;

import javax.swing.JButton;
import gerenciadorPrincipal.utils.TelaMenu;
import gerenciadorPrincipal.view.TelaGerenciador;

public class TelaGerenciadorCemiterio extends TelaMenu{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(e -> {
            switch(index){
                case 0 -> new TelaRegistroCemiterio();
                case 1 -> new TelaSelectCemiterio();
                case 2 -> dispose(); // TROCAR ENTIDADE
                case 3 -> dispose(); // TROCAR ENTIDADE
                case 4 -> dispose(); // TROCAR ENTIDADE
                case 5 -> new TelaGerenciador(); // TROCAR ENTIDADE
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
        this.setTitle("Menu Cemitério");

        // Button
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