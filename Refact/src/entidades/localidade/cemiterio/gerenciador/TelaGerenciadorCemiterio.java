package entidades.localidade.cemiterio.gerenciador;

import javax.swing.JButton;

import entidades.localidade.cemiterio.controle.telasCrud.TelaCrudCemiterio;
import gerenciadorPrincipal.TelaGerenciador;
import gerenciadorPrincipal.heranca.TelaMenu;

public class TelaGerenciadorCemiterio extends TelaMenu{
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(e -> {
            switch(index){
                case 0 -> new TelaCrudCemiterio(); // TROCAR ENTIDADE
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