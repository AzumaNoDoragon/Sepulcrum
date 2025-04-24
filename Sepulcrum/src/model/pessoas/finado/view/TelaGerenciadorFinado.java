package model.pessoas.finado.view;

import javax.swing.JButton;

import com.sepulcrum.model.pessoas.finado.view.TelaRegistroFinado;
import com.sepulcrum.model.pessoas.finado.view.TelaSelectFinado;

import core.utils.TelaMenu;
import core.view.TelaGerenciador;

public class TelaGerenciadorFinado extends TelaMenu{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(_ -> {
            switch(index){
                case 0 -> new TelaRegistroFinado();
                case 1 -> new TelaSelectFinado(); // passar propriedade busca
                case 2 -> new TelaSelectFinado(); // passar propriedade updade
                case 3 -> new TelaSelectFinado(); // passar propriedade delete
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
        this.setTitle("Menu Finado");

        // Button
        jbOne = new JButton("Cadastrar Finado.");
        jbTwo = new JButton("Apresentar Finado.");
        jbThree = new JButton("Alterar Finado.");
        jbFour = new JButton("Deletar Finado.");
        jbVoltar = new JButton("Voltar");
    }
}

/*public void setDefunto(Finado d){
    System.out.println("Digite o nome do Finado: ");
    d.setNome(teclado.nextLine());
    System.out.println("Digite o CPF: ");
    d.setCpf(teclado.nextLine());
    System.out.println("Digite o RG: ");
    d.setRg(teclado.nextLine());
    System.out.println("Digite a data de nascimento: ");
    d.setDataNascimento(teclado.nextLine());
    System.out.println("Digite a data de falecimento: ");
    d.setDataFalecimento(teclado.nextLine());
    System.out.println("Digite a causa da morte: ");
    d.setCausaMorte(teclado.nextLine());
    System.out.println("Digite o id do parente: ");
    d.setIdParente(teclado.nextInt());teclado.nextLine();
    System.out.println("Digite o id do tumulo: ");
    d.setIdTumulo(teclado.nextInt());teclado.nextLine();
}

public void getDefunto(Finado d){
    if(d != null){
        System.out.println("nome do Finado: " + d.getNome());
        System.out.println("CPF: " + d.getCpf());
        System.out.println("RG: " + d.getRg());
        System.out.println("Data de nascimento: " + d.getDataNascimento());
        System.out.println("Data de falecimento: " + d.getDataFalecimento());
        System.out.println("Causa da morte: " + d.getCausaMorte());
        System.out.println("Id do parente: " + d.getIdParente());
        System.out.println("Id do tumulo: " + d.getIdTumulo());
    } else {
        msgIdInexistente();
    }
}*/