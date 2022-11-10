package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ManutencaoTumular implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idManutencao, idAdm, idTumulo, dataManutencao, horarioManutencao;
	private String informacaoManutencao;

	public ManutencaoTumular(Integer idManutencao, Integer idAdm, Integer idTumulo, Integer dataManutencao,
			Integer horarioManutencao, String informacaoManutencao) {
		super();
		this.idManutencao = idManutencao;
		this.idAdm = idAdm;
		this.idTumulo = idTumulo;
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

	public Integer getIdAdm() {
		return idAdm;
	}

	public void setIdAdm(Integer idAdm) {
		this.idAdm = idAdm;
	}

	public Integer getIdTumulo() {
		return idTumulo;
	}

	public void setIdTumulo(Integer idTumulo) {
		this.idTumulo = idTumulo;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ManutencaoTumular [idManutencao=" + idManutencao + ", idAdm=" + idAdm + ", idTumulo=" + idTumulo
				+ ", dataManutencao=" + dataManutencao + ", horarioManutencao=" + horarioManutencao
				+ ", informacaoManutencao=" + informacaoManutencao + "]";
	}
}