package entidades.servicos.vistoria;

import java.time.LocalDate;

import entidades.servicos.heranca.ServicoTumulo;

public class Vistoria extends ServicoTumulo{
    public Vistoria(String responsavelServico, String descricao, String informacoesAdicionaris,
            String statusServico, LocalDate dataServico, int idServico, int idTumulo) {
        super(responsavelServico, descricao, informacoesAdicionaris, statusServico, dataServico, idServico, idTumulo);
    }
}
