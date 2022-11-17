package classeEndereco;

public class Tumulo extends Endereco {

	private Integer idTumulo, ocupadoDesdeTumulo;
	private Boolean permaneteTumulo, ocupadoTumulo;

	public Tumulo(Integer numeroEndereco, String quadraEndereco, String ruaEndereco, Integer idTumulo,
			Integer ocupadoDesdeTumulo, Boolean permaneteTumulo, Boolean ocupadoTumulo) {
		super(numeroEndereco, quadraEndereco, ruaEndereco);
		this.idTumulo = idTumulo;
		this.ocupadoDesdeTumulo = ocupadoDesdeTumulo;
		this.permaneteTumulo = permaneteTumulo;
		this.ocupadoTumulo = ocupadoTumulo;
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

	public Integer getIdTumulo() {
		return idTumulo;
	}

	public void setIdTumulo(Integer idTumulo) {
		this.idTumulo = idTumulo;
	}

	public Integer getOcupadoDesdeTumulo() {
		return ocupadoDesdeTumulo;
	}

	public void setOcupadoDesdeTumulo(Integer ocupadoDesdeTumulo) {
		this.ocupadoDesdeTumulo = ocupadoDesdeTumulo;
	}

	public Boolean getPermaneteTumulo() {
		return permaneteTumulo;
	}

	public void setPermaneteTumulo(Boolean permaneteTumulo) {
		this.permaneteTumulo = permaneteTumulo;
	}

	public Boolean getOcupadoTumulo() {
		return ocupadoTumulo;
	}

	public void setOcupadoTumulo(Boolean ocupadoTumulo) {
		this.ocupadoTumulo = ocupadoTumulo;
	}

}