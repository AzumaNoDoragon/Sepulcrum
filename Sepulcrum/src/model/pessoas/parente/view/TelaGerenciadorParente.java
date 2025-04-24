package model.pessoas.parente.view;

import javax.swing.JButton;

import com.sepulcrum.model.pessoas.parente.view.TelaRegistroParente;
import com.sepulcrum.model.pessoas.parente.view.TelaSelectParente;

import core.utils.TelaMenu;
import core.view.TelaGerenciador;

public class TelaGerenciadorParente extends TelaMenu{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(_ -> {
            switch(index){
                case 0 -> new TelaRegistroParente();
                case 1 -> new TelaSelectParente(); // passar propriedade busca
                case 2 -> new TelaSelectParente(); // passar propriedade updade
                case 3 -> new TelaSelectParente(); // passar propriedade delete
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
        this.setTitle("Menu familiar");

        // Button
        jbOne = new JButton("Cadastrar familiar.");
        jbTwo = new JButton("Apresentar familiar.");
        jbThree = new JButton("Alterar familiar.");
        jbFour = new JButton("Deletar familiar.");
        jbVoltar = new JButton("Voltar");
    }
}
/*
@Override
public int menu() {
    System.out.println("Menu de Parente: ");
    System.out.println("1 - Cadastrar Parente.");
    System.out.println("2 - Apresentar Parente.");
    System.out.println("3 - Listar Parente.");
    System.out.println("4 - Alterar Parente.");
    System.out.println("5 - Deletar Parente.");
    System.out.println("0 - Voltar");
    int opc = teclado.nextInt(); teclado.nextLine();

    return opc;
}

public void setParente(Parente p){
    System.out.println("Digite o nome do Parente Responsável: ");
    p.setNome(teclado.nextLine());
    System.out.println("Digite o CPF: ");
    p.setCpf(teclado.nextLine());
    System.out.println("Digite o RG: ");
    p.setRg(teclado.nextLine());
    System.out.println("Digite a data de nascimento: ");
    p.setDataNascimento(teclado.nextLine());
    System.out.println("Digite o telefone: ");
    p.setTelefone(teclado.nextLine());
    System.out.println("Digite o e-mail: ");
    p.setEmail(teclado.nextLine());
    System.out.println("Digite o grau de parentesco: ");
    p.setGrauParentesco(teclado.nextLine());
    System.out.println("Digite o id do Finado");
    p.setIdDefunto(teclado.nextInt()); teclado.nextLine();
}

public void getParente(Parente p){
    if(p != null){
        System.out.println("O nome é: " + p.getNome());
        System.out.println("O CPF é: " + p.getCpf());
        System.out.println("O Rg é: " + p.getRg());
        System.out.println("A data de nascimento é: " + p.getDataNascimento());
        System.out.println("O telefone é: " + p.getTelefone());
        System.out.println("O e-mail é: " + p.getEmail());
        System.out.println("O grau de parentesco é: " + p.getGrauParentesco());
        System.out.println("O id do parente é: " + p.getIdDefunto());
    } else {
        msgIdInexistente();
    }
}
*/