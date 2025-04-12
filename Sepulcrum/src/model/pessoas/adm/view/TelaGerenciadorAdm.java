package model.pessoas.adm.view;

import javax.swing.JButton;
import core.utils.TelaMenu;
import core.view.TelaGerenciador;

public class TelaGerenciadorAdm extends TelaMenu{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(e -> {
            switch(index){
                case 0 -> new TelaRegistroAdm();
                case 1 -> new TelaSelectAdm(); // passar propriedade busca
                case 2 -> new TelaSelectAdm(); // passar propriedade updade
                case 3 -> new TelaSelectAdm(); // passar propriedade delete
                case 4 -> new TelaGerenciador();
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
        qtdBotoes = 5;
        
        // Janela
        this.setTitle("Menu Adm");

        // Button
        jbOne = new JButton("Cadastrar coveiro.");
        jbTwo = new JButton("Apresentar coveiro.");
        jbThree = new JButton("Alterar coveiro.");
        jbFour = new JButton("Deletar coveiro.");
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