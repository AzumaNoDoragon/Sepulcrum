package entidades.servicos.manutencaoTumulo;

import java.time.LocalDate;

import entidades.servicos.heranca.ServicoTumulo;

public class ManutencaoTumulo extends ServicoTumulo{
    public ManutencaoTumulo(String responsavelServico, String descricao, String informacoesAdicionaris,
            String statusServico, LocalDate dataServico, int idServico, int idTumulo) {
        super(responsavelServico, descricao, informacoesAdicionaris, statusServico, dataServico, idServico, idTumulo);
    }
}
