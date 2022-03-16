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

public class AulaLista {
	
private List<Aula> lista = new ArrayList<Aula>();
private List<Aula> relatorio = new ArrayList<Aula>();

	
	public List<Aula> getLista() {
		return lista;
	}

	public void setLista(List<Aula> lista) {
		this.lista = lista;
	}
	
	
	//Adicionar aula
	public void add(Aula aula) {
		lista.add(aula);
	}
	
	
	//aletarações
	public boolean alterarInstrutor(Instrutor instrutor, int id) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == id) { 
				lista.get(i).setIntrutor(instrutor);
				return true;
			}
		}
		return false;
	}
	
	public boolean alterarAluno(Aluno aluno, int id) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == id) { 
				lista.get(i).setAluno(aluno);
				return true;
			}
		}
		return false;
	}
	
	public boolean alterarVeiculo(Veiculo veiculo, int id) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == id) { 
				lista.get(i).setVeiculo(veiculo);
				return true;
			}
		}
		return false;
	}
			
	
	
	//Relatórios 
	public List<Aula> relatorioData(String data) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getDia().equals(data)) {
				relatorio.add(lista.get(i));
			}	
		}
		return relatorio;
	}
	
	public List<Aula> relatorioInstrutor(String nome) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getIntrutor().getNome().equals(nome)) {
				relatorio.add(lista.get(i));
			}	
		}
		return relatorio;
	}
	
	public List<Aula> relatorioAluno(String nome) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getAluno().getNome().equals(nome)) {
				relatorio.add(lista.get(i));
			}	
		}
		return relatorio;
	}
	
	public List<Aula> relatorioVeiculo(String placa) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getVeiculo().getPlaca().equals(placa)) {
				relatorio.add(lista.get(i));
			}	
		}
		return relatorio;
	}
	
	
	//Econtrar Aula
	public Aula encontrar(int id) {
		for (int i = 0; i < lista.size(); i++) {
			Aula aula = lista.get(i);
			if (aula.getId() == id) {
				return aula;
			}
		}
		return null;
	}
	
	//Excluir Aula
	public boolean excluir(int id) {
		for (int i = 0; i < lista.size(); i++) {
			Aula aula = lista.get(i);
			if (aula.getId() == id) {
				lista.remove(lista.indexOf(aula));
				return true;
			}
		}
		return false;
	}
	
	//Gravar	
	public void gravar() {
		GsonBuilder builder = new GsonBuilder();
	    Gson gson = builder.create();
	    FileWriter writer;
		try {
			writer = new FileWriter("lista_JSON/json/listaaula.json");
			writer.write(gson.toJson(lista));
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Ler
	public List<Aula> ler() {
	    BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("lista_JSON/json/listaaula.json"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    Type listType = new TypeToken<ArrayList<Aula>>(){}.getType();
	    lista = new ArrayList<Aula>();
	    lista = new Gson().fromJson(bufferedReader, listType);
	    return lista;
	}

	
	

}
