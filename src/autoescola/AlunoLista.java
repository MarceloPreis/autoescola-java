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

public class AlunoLista {
	
private List<Aluno> lista = new ArrayList<Aluno>();
	
	public List<Aluno> getLista() {
		return lista;
	}

	public void setLista(List<Aluno> lista) {
		this.lista = lista;
	}

	//Adicionar
	public boolean add(Aluno aluno) {
		for (int i = 0; i < lista.size(); i++) {
			Aluno controle = lista.get(i);
			if (aluno.getNome().equals(controle.getNome()) || aluno.getId() == controle.getId())
				return false;
			}
		lista.add(aluno);
		return true;
	}
	
	//Encontrar aluno
	public Aluno encontrar(String nome) {
		for (int i = 0; i < lista.size(); i++) {
			Aluno aluno = lista.get(i);
			if (aluno.getNome().equals(nome)) {
				return aluno;
			}
		}
		return null;
	}
	
	//Excluir Aluno
	public boolean excluir(int id) {
		for (int i = 0; i < lista.size(); i++) {
			Aluno aluno = lista.get(i);
			if (aluno.getId() == id) {
				lista.remove(lista.indexOf(aluno));
				return true;
			}
		}
		return false;
	}
	
	//Alterar nome do Aluno
	public void alterarNome(int id, String nome) {
		for (int i = 0; i < lista.size(); i++) {
			Aluno aluno = lista.get(i);
			if (aluno.getId() == id) {
				lista.get(lista.indexOf(aluno)).setNome(nome);
			}
		}
	}
	
	//Alterar Cpf do aluno
	public void alterarCpf(int id, String cpf) {
		for (int i = 0; i < lista.size(); i++) {
			Aluno aluno = lista.get(i);
			if (aluno.getId() == id) {
				lista.get(lista.indexOf(aluno)).setCpf(cpf);
			}
		}
	}
	
	public void gravar() {
		GsonBuilder builder = new GsonBuilder();
	    Gson gson = builder.create();
	    FileWriter writer;
		try {
			writer = new FileWriter("lista_JSON/json/listaaluno.json");
			writer.write(gson.toJson(lista));
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Aluno> ler() {
	    BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("lista_JSON/json/listaaluno.json"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    Type listType = new TypeToken<ArrayList<Aluno>>(){}.getType();
	    lista = new ArrayList<Aluno>();
	    lista = new Gson().fromJson(bufferedReader, listType);
	    return lista;
	}

	
	

}
