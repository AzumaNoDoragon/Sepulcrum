package entidades.servicos;

import java.time.LocalDate;

public class ReservaTumulo extends ServicoTumulo{
    private String  nomeResponsavel;
    private LocalDate dataRealizacao;
    
    public ReservaTumulo(int idTumulo, String nomeResponsavel, LocalDate dataRealizacao) {
        super(idTumulo);
        this.nomeResponsavel = nomeResponsavel;
        this.dataRealizacao = dataRealizacao;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }
}
