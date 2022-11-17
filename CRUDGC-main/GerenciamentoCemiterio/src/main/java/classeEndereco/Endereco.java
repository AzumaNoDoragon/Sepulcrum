package classeEndereco;

public class Endereco {

	protected Integer numeroEndereco;
	protected String quadraEndereco, ruaEndereco;

	public Endereco(Integer numeroEndereco, String quadraEndereco, String ruaEndereco) {
		super();
		this.numeroEndereco = numeroEndereco;
		this.quadraEndereco = quadraEndereco;
		this.ruaEndereco = ruaEndereco;
	}

	public Integer getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(Integer numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getQuadraEndereco() {
		return quadraEndereco;
	}

	public void setQuadraEndereco(String quadraEndereco) {
		this.quadraEndereco = quadraEndereco;
	}

	public String getRuaEndereco() {
		return ruaEndereco;
	}

	public void setRuaEndereco(String ruaEndereco) {
		this.ruaEndereco = ruaEndereco;
	}

}