package entidades.servicos;

public class ManutencaoTumulo extends ServicoTumulo{
    private String horarioManutencao;

    public ManutencaoTumulo(int idTumulo, String horarioManutencao) {
        super(idTumulo);
        this.horarioManutencao = horarioManutencao;
    }

    public String getHorarioManutencao() {
        return horarioManutencao;
    }

    public void setHorarioManutencao(String horarioManutencao) {
        this.horarioManutencao = horarioManutencao;
    }
}
