package domain.localidade.cemiterio.view;

import javax.swing.JLabel;
import javax.swing.JTextField;

import core.utils.TelaRegistro;

import javax.swing.JButton;

public class TelaRegistroCemiterio extends TelaRegistro{
    @Override
    protected void defineBotoes(JButton button, int index, int jbX, int jbY, int jbWidth, int jbHeight){
        button.setBounds(jbX, jbY, jbWidth, jbHeight);
        button.addActionListener(e -> {
            switch(index){
                case 0 -> dispose(); // TROCAR ENTIDADE
                case 1 -> new TelaGerenciadorCemiterio();
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
        
        // Button
        jbProx = new JButton("Próximo");
        jbCancelar = new JButton("Cancelar");

        // Label
        jlNome = new JLabel("Nome: ");
        jlEstado = new JLabel("Estado: ");
        jlCidade = new JLabel("Cidade: ");
        jlRua = new JLabel("Rua: ");
        jlNumero = new JLabel("Numero: ");
        jlCapacidadeMax = new JLabel("Capacidade: ");
        jlTelefone = new JLabel("Telefone: ");
        jlCep = new JLabel("Cep: ");
        
        // Text Field
        jtfNome = new JTextField();
        jtfEstado = new JTextField();
        jtfCidade = new JTextField();
        jtfRua = new JTextField();
        jtfNumero = new JTextField();
        jtfCapacidadeMax = new JTextField();
        jtfTelefone = new JTextField();
        jtfCep = new JTextField();
    }
}