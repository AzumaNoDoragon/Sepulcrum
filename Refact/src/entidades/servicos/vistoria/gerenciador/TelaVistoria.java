package entidades.servicos.vistoria.gerenciador;

import java.time.LocalDate;

import entidades.servicos.vistoria.Vistoria;
import gerenciadorPrincipal.heranca.TelaDefenicoes;

public class TelaVistoria extends TelaDefenicoes{
    @Override
    public int menu() {
        System.out.println("Menu de Vistoria: ");
        System.out.println("1 - Cadastrar Vistoria.");
        System.out.println("2 - Apresentar Vistoria.");
        System.out.println("3 - Listar Vistoria.");
        System.out.println("4 - Alterar Vistoria.");
        System.out.println("5 - Deletar Vistoria.");
        System.out.println("0 - Voltar");

        return teclado.nextInt();
    }

    public void setVistoria(Vistoria v){
        System.out.println("Digite a descrição da Vistoria: ");
        v.setDescricao(teclado.nextLine());
        System.out.println("Digite a data da Vistoria");
        v.setDataServico(teclado.nextLine());
    }
}
String responsavelServico, informacoesAdicionaris, statusServico;
LocalDate dataServico;
int idServico, idTumulo;