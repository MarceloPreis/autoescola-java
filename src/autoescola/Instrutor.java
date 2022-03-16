package autoescola;

public class Instrutor extends Pessoa {
	
	private double salario;
	private int id;
	

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Instrutor: ");
		builder.append(super.toString());
		builder.append(", ");
		builder.append("Salario= ");
		builder.append(salario);
		builder.append(" ]");
		
		return builder.toString();
	}
	
	

}
