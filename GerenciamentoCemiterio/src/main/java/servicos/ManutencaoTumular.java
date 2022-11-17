package servicos;

public class ManutencaoTumular {

	private Integer idManutencao, dataManutencao, horarioManutencao;
	private String informacaoManutencao;

	public ManutencaoTumular(Integer idManutencao, Integer dataManutencao, Integer horarioManutencao,
			String informacaoManutencao) {
		super();
		this.idManutencao = idManutencao;
		this.dataManutencao = dataManutencao;
		this.horarioManutencao = horarioManutencao;
		this.informacaoManutencao = informacaoManutencao;
	}

	public Integer getIdManutencao() {
		return idManutencao;
	}

	public void setIdManutencao(Integer idManutencao) {
		this.idManutencao = idManutencao;
	}

	public Integer getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(Integer dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	public Integer getHorarioManutencao() {
		return horarioManutencao;
	}

	public void setHorarioManutencao(Integer horarioManutencao) {
		this.horarioManutencao = horarioManutencao;
	}

	public String getInformacaoManutencao() {
		return informacaoManutencao;
	}

	public void setInformacaoManutencao(String informacaoManutencao) {
		this.informacaoManutencao = informacaoManutencao;
	}

}