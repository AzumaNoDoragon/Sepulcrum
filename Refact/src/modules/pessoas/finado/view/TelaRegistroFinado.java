package modules.pessoas.finado.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import core.utils.TelaRegistro;

public class TelaRegistroFinado extends TelaRegistro{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(e -> {
            switch(index){
                case 0 -> new TelaGerenciadorFinado(); // passar propriedade JOption + propriedade de crud
                case 1 -> new TelaGerenciadorFinado();
            };
            dispose();
        });
        this.add(button);
    }
    
    @Override
    public void inicializarVariaveis() {
        //Configura tamanho da janela e botões
        fWidth = 500;
        fHeight = 700;
        qtdBotoes = 8;

        // Janela
        this.setTitle("Registro Finado.");
        
        // Button
        jbSalvar = new JButton("Salvar");
        jbCancelar = new JButton("Cancelar");

        // Label
        jlOne = new JLabel("Nome: ");
        jlTwo = new JLabel("CPF: ");
        jlThree = new JLabel("RG: ");
        jlFour = new JLabel("Data de nascimento: ");
        jlFive = new JLabel("Data de Falecimento: ");
        jlSix = new JLabel("Causa da morte: ");
        jlSeven = new JLabel("id do túmulo: ");
        jlEight = new JLabel("id do parente: ");
        
        // Text Field
        jtfOne = new JTextField();
        jtfTwo = new JTextField();
        jtfThree = new JTextField();
        jtfFour = new JTextField();
        jtfFive = new JTextField();
        jtfSix = new JTextField();
        jtfSeven = new JTextField();
        jtfEight = new JTextField();
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