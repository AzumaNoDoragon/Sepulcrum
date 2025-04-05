package entidades.localidade.cemiterio.controle.telasCrud;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import gerenciadorPrincipal.heranca.TelaRegistro;

public class TelaCrudCemiterio extends TelaRegistro{
    @Override
    public void inicializarVariaveis() {
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