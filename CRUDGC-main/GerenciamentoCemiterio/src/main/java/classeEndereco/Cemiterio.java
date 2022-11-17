package classeEndereco;

public class Cemiterio extends Endereco {

	private Integer idCemiterio, telefoneCemiterio, cepCemiterio;
	private String nomeCemiterio, estadoCemiterio, cidadeCemiterio;

	public Cemiterio(Integer numeroEndereco, String quadraEndereco, String ruaEndereco, Integer idCemiterio,
			Integer telefoneCemiterio, Integer cepCemiterio, String nomeCemiterio, String estadoCemiterio,
			String cidadeCemiterio) {
		super(numeroEndereco, quadraEndereco, ruaEndereco);
		this.idCemiterio = idCemiterio;
		this.telefoneCemiterio = telefoneCemiterio;
		this.cepCemiterio = cepCemiterio;
		this.nomeCemiterio = nomeCemiterio;
		this.estadoCemiterio = estadoCemiterio;
		this.cidadeCemiterio = cidadeCemiterio;
	}

	@Override
	public Integer getNumeroEndereco() {
		// TODO Auto-generated method stub
		return super.getNumeroEndereco();
	}

	@Override
	public void setNumeroEndereco(Integer numeroEndereco) {
		// TODO Auto-generated method stub
		super.setNumeroEndereco(numeroEndereco);
	}

	@Override
	public String getQuadraEndereco() {
		// TODO Auto-generated method stub
		return super.getQuadraEndereco();
	}

	@Override
	public void setQuadraEndereco(String quadraEndereco) {
		// TODO Auto-generated method stub
		super.setQuadraEndereco(quadraEndereco);
	}

	@Override
	public String getRuaEndereco() {
		// TODO Auto-generated method stub
		return super.getRuaEndereco();
	}

	@Override
	public void setRuaEndereco(String ruaEndereco) {
		// TODO Auto-generated method stub
		super.setRuaEndereco(ruaEndereco);
	}

	public Integer getIdCemiterio() {
		return idCemiterio;
	}

	public void setIdCemiterio(Integer idCemiterio) {
		this.idCemiterio = idCemiterio;
	}

	public Integer getTelefoneCemiterio() {
		return telefoneCemiterio;
	}

	public void setTelefoneCemiterio(Integer telefoneCemiterio) {
		this.telefoneCemiterio = telefoneCemiterio;
	}

	public Integer getCepCemiterio() {
		return cepCemiterio;
	}

	public void setCepCemiterio(Integer cepCemiterio) {
		this.cepCemiterio = cepCemiterio;
	}

	public String getNomeCemiterio() {
		return nomeCemiterio;
	}

	public void setNomeCemiterio(String nomeCemiterio) {
		this.nomeCemiterio = nomeCemiterio;
	}

	public String getEstadoCemiterio() {
		return estadoCemiterio;
	}

	public void setEstadoCemiterio(String estadoCemiterio) {
		this.estadoCemiterio = estadoCemiterio;
	}

	public String getCidadeCemiterio() {
		return cidadeCemiterio;
	}

	public void setCidadeCemiterio(String cidadeCemiterio) {
		this.cidadeCemiterio = cidadeCemiterio;
	}

}