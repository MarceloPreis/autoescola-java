	package autoescola;

public class Endereco {
	private String rua;
	private String bairro;
	private String cidade;
		
	public Endereco(String rua, String bairro, String cidade) {
		setRua(rua);
		setBairro(bairro);
		setCidade(cidade);
	}
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		if (rua.length()>0)
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		if (bairro.length()>0)
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		if (cidade.length()>0)
		this.cidade = cidade;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rua= ");
		builder.append(rua);
		builder.append(", Bairro= ");
		builder.append(bairro);
		builder.append(", Cidade= ");
		builder.append(cidade);
		return builder.toString();
	}
	
	

}
