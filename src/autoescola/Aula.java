package autoescola;

public class Aula {	
	
	
	private int id;
	protected Instrutor intrutor;
	protected Aluno aluno;
	protected Veiculo veiculo;
	private String dia;
	private String inicio;
	private String fim;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Instrutor getIntrutor() {
		return intrutor;
	}
	public void setIntrutor(Instrutor intrutor) {
		this.intrutor = intrutor;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}	
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFim() {
		return fim;
	}
	public void setFim(String fim) {
		this.fim = fim;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Aula [id=");
		builder.append(id);
		builder.append(", Intrutor= ");
		builder.append(intrutor.getNome());
		builder.append(" - ");
		builder.append(intrutor.getCpf());
		builder.append(", Aluno= ");
		builder.append(aluno.getNome());
		builder.append(" - ");
		builder.append(aluno.getCpf());
		builder.append(", Veiculo=");
		builder.append(veiculo.getPlaca());
		builder.append(" - ");
		builder.append(veiculo.getModelo());
		builder.append(", Inicio= ");
		builder.append(dia);
		builder.append(" ");
		builder.append(inicio);
		builder.append(", Fim= ");
		builder.append(fim);
		builder.append("]");
		return builder.toString();
	}
	 	
	
	
	

	
	
	
	
	
	

}
