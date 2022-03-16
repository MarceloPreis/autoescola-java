package autoescola;

public class Aluno extends Pessoa {
	
	protected Endereco endereco;
	private int id;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Aluno: ");
		builder.append(super.toString());
		builder.append(" Endereço: ");
		builder.append(endereco);
		return builder.toString();
	}

	
	
	
	

}
