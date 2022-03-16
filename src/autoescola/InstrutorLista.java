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

public class InstrutorLista {
	
private List<Instrutor> lista = new ArrayList<Instrutor>();
	
	public List<Instrutor> getLista() {
		return lista;
	}

	public void setLista(List<Instrutor> lista) {
		this.lista = lista;
	}

	//Adicionar
	public boolean add(Instrutor instrutor) {
		for (int i = 0; i < lista.size(); i++) {
			Instrutor controle = lista.get(i);
			if (instrutor.getNome().equals(controle.getNome()) || instrutor.getId() == controle.getId())
				return false;
		}
		
		lista.add(instrutor);
		return true;
	}
	
	//Encotrar na listagem
	public Instrutor encontrar(String nome) {
		for (int i = 0; i < lista.size(); i++) {
			Instrutor instrutor = lista.get(i);
			if (instrutor.getNome().equals(nome)) {
				return 	instrutor;
			}
		}
		return null;
	}
	
	
	
	//Remover da listagem
	public boolean excluir(int nome) {
		for (int i = 0; i < lista.size(); i++) {
			Instrutor instrutor = lista.get(i);
			if (instrutor.getNome().equals(nome)) {
				lista.remove(lista.indexOf(instrutor));
				return true;
			}
		}
		return false;
	}
	
	//Alterar nome do Instrutor
	public void alterarNome(int id, String nome) {
		for (int i = 0; i < lista.size(); i++) {
			Instrutor instrutor = lista.get(i);
			if (instrutor.getId() == id) {
				lista.get(lista.indexOf(instrutor)).setNome(nome);
			}
		}
	}
	
	//Alterar CPF do instrutor
	public void alterarCpf(int id, String cpf) {
		for (int i = 0; i < lista.size(); i++) {
			Instrutor instrutor = lista.get(i);
			if (instrutor.getId() == id) {
				lista.get(lista.indexOf(instrutor)).setCpf(cpf);
			}
		}
	}
	
	//Alterar Salario do Instrutor
	public void alterarSalario(int id, double salario) {
		for (int i = 0; i < lista.size(); i++) {
			Instrutor instrutor = lista.get(i);
			if (instrutor.getId() == id) {
				lista.get(lista.indexOf(instrutor)).setSalario(salario);
			}
		}
	}
	
 	public void gravar() {
		GsonBuilder builder = new GsonBuilder();
	    Gson gson = builder.create();
	    FileWriter writer;
		try {
			writer = new FileWriter("lista_JSON/json/listainstrutor.json");
			writer.write(gson.toJson(lista));
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Instrutor> ler() {
	    BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(
							 new FileReader("lista_JSON/json/listainstrutor.json"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    Type listType = new TypeToken<ArrayList<Instrutor>>(){}.getType();
	    lista = new ArrayList<Instrutor>();
	    lista = new Gson().fromJson(bufferedReader, listType);
	    return lista;
	}

}
