package entidades.servicos.reservaTumulo;

import entidades.servicos.heranca.ServicoTumulo;

public class ReservaTumulo extends ServicoTumulo{
    private int idPessoa;

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
}