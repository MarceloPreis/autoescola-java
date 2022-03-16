package autoescola;

public class Veiculo {
	
	private int id;
	private String modelo;
	private String placa;
	private Cat cat;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Cat getCat() {
		return cat;
	}
	public void setCat(Cat cat) {
		this.cat = cat;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Veiculo [modelo=");
		builder.append(modelo);
		builder.append(", placa=");
		builder.append(placa);
		builder.append(", cat=");
		builder.append(cat);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	

}
