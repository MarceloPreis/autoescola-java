package autoescola;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class VeiculoLista {
	
private List<Veiculo> lista = new ArrayList<Veiculo>();
	
	public List<Veiculo> getLista() {
		return lista;
	}

	public void setLista(List<Veiculo> lista) {
		this.lista = lista;
	}

	public boolean add(Veiculo veiculo) {
		for (int i = 0; i < lista.size(); i++) {
			Veiculo controle = lista.get(i);
			if (veiculo.getPlaca().equals(controle.getPlaca()))
				return false;
			
			}
		lista.add(veiculo);
		return true;
		
	}
	
	//Encontrar Veículo
	public Veiculo encontrar(String placa) {
		for (int i = 0; i < lista.size(); i++) {
			Veiculo veiculo = lista.get(i);
			if (veiculo.getPlaca().equals(placa)) {
				return veiculo;
			}
		}
		return null;
	}
	
	//Excluir
	public void excluir(int id) {
		for (int i = 0; i < lista.size(); i++) {
			Veiculo veiculo= lista.get(i);
			if (veiculo.getId() == id) {
				lista.remove(lista.indexOf(veiculo));
			}
		}
	}
	
	//Alterar placa 
	public void alterarPlaca(int id, String placa) {
		for (int i = 0; i < lista.size(); i++) {
			Veiculo veiculo= lista.get(i);
			if (veiculo.getId() == id) {
				lista.get(lista.indexOf(veiculo)).setPlaca(placa);
			}
		}
	}
	
	//Alterar Modelo
	public void alterarModelo(int id, String modelo) {
		for (int i = 0; i < lista.size(); i++) {
			Veiculo veiculo= lista.get(i);
			if (veiculo.getId() == id) {
				lista.get(lista.indexOf(veiculo)).setModelo(modelo);
			}
		}
	}
	
	public void gravar() {
		GsonBuilder builder = new GsonBuilder();
	    Gson gson = builder.create();
	    FileWriter writer;
		try {
			writer = new FileWriter("lista_JSON/json/listaVeiculo.json");
			writer.write(gson.toJson(lista));
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Veiculo> ler() {
	    BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("lista_JSON/json/listaVeiculo.json"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    Type listType = new TypeToken<ArrayList<Veiculo>>(){}.getType();
	    lista = new ArrayList<Veiculo>();
	    lista = new Gson().fromJson(bufferedReader, listType);
	    return lista;
	}

}
