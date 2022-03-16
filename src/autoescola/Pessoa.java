package autoescola;

public class Pessoa {
		
	protected String nome;
	protected String cpf;
	
	
	public Pessoa() {
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" Nome= ");
		builder.append(nome);
		builder.append(", CPF= ");
		builder.append(cpf);
		return builder.toString();
	}
	
	
	
	
}
