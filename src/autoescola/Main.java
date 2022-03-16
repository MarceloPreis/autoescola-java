package autoescola;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int op1;
		int op2;
		int op3;

		AlunoLista al = new AlunoLista();
		InstrutorLista il = new InstrutorLista();
		VeiculoLista vl = new VeiculoLista();
		AulaLista aulas = new AulaLista();

		Aluno aluno = new Aluno();
		Instrutor instrutor = new Instrutor();
		Veiculo veiculo = new Veiculo();
		Aula aula = new Aula();

		al.setLista(al.ler());
		il.setLista(il.ler());
		vl.setLista(vl.ler());
		aulas.setLista(aulas.ler());

		System.out.println("1-CADASTRAR | 2-ALTERAR | 3-EXLCUIR | 4-RELATÓRIO DE AULAS | 5-LISTAGENS");
		op1 = in.nextInt();
		if (op1 == 1) {
			System.out.println("1-AULA | 2-ALUNO | 3-INSTRUTOR | 4-VEICULO");
			op2 = in.nextInt();
			if (op2 == 1) {

				System.out.println("Código da aula: ");
				int id = in.nextInt();
				aula.setId(id);

				System.out.println("Nome do instrutor:");
				String nome = in.next();
				aula.setIntrutor(il.encontrar(nome));

				System.out.println("Nome do Aluno:");
				nome = in.next();
				aula.setAluno(al.encontrar(nome));

				System.out.println("Placa do Veículo:");
				String placa = in.next();
				aula.setVeiculo(vl.encontrar(placa));

				System.out.println("Incio no formato dd/mm/yyyy hh:mm:ss");
				String dia = in.next();
				String inicio = in.next();
				aula.setInicio(inicio);
				aula.setDia(dia);

				System.out.println("Fim no formato hh:mm:ss");
				String fim = in.next();
				aula.setFim(fim);

				aulas.add(aula);
				aulas.gravar();
				aulas = new AulaLista();

				aulas.setLista(aulas.ler());

				for (Aula x : aulas.getLista()) {
					System.out.println(x);
				}
			}
			if (op2 == 2) {
				System.out.println("Id");
				int id = in.nextInt();
				aluno.setId(id);

				System.out.println("Nome");
				String nome = in.next();
				aluno.setNome(nome);

				System.out.println("CPF");
				String cpf = in.next();
				aluno.setCpf(cpf);

				System.out.println("Rua");
				String rua = in.next();

				System.out.println("Bairro");
				String bairro = in.next();

				System.out.println("Cidade");
				String cidade = in.next();

				Endereco endereco = new Endereco(rua, bairro, cidade);
				aluno.setEndereco(endereco);

				al.add(aluno);
				al.gravar();
				al = new AlunoLista();
				al.setLista(al.ler());

				for (Aluno x : al.getLista()) {
					System.out.println(x);
				}

			}
			if (op2 == 3) {
				System.out.println("Id");
				int id = in.nextInt();
				instrutor.setId(id);

				System.out.println("Nome");
				String nome = in.next();
				instrutor.setNome(nome);

				System.out.println("CPF");
				String cpf = in.next();
				instrutor.setCpf(cpf);

				System.out.println("Salário");
				double salario = in.nextDouble();
				instrutor.setSalario(salario);

				il.add(instrutor);
				il.gravar();
				il = new InstrutorLista();
				il.setLista(il.ler());

				for (Instrutor x : il.getLista()) {
					System.out.println(x);
				}
			}
			if (op2 == 4) {
				System.out.println("Id");
				int id = in.nextInt();
				veiculo.setId(id);

				System.out.println("Placa");
				String placa = in.next();
				veiculo.setPlaca(placa);

				System.out.println("Modelo");
				String modelo = in.next();
				veiculo.setModelo(modelo);
				
				System.out.println("Categoria");
				String x = in.next();
				if (x.equals("A")) {
					veiculo.setCat(Cat.A);
				}else{
					if (x.equals("B")) {
						veiculo.setCat(Cat.B);
					}else {
						if (x.equals("C")) {
							veiculo.setCat(Cat.C);
						}else {
							if (x.equals("D")) {
								veiculo.setCat(Cat.D);
							}else {
								veiculo.setCat(Cat.E);
							}			
						}
					}
				}

				vl.add(veiculo);
				vl.gravar();
				vl = new VeiculoLista();
				vl.setLista(vl.ler());

				for (Veiculo y : vl.getLista()) {
					System.out.println(y);
				}
			}
		}
		if (op1 == 2) {
			System.out.println("1-AULA | 2-ALUNO | 3-INSTRUTOR | 4-VEICULO");
			op2 = in.nextInt();
			if (op2 == 1) {
				System.out.println("ALTERAR | 1-ALUNO | 2-INSTRUTOR | 3-VEICULO");
				op3 = in.nextInt();
				if (op3 == 1) {
					System.out.println("Informe o id da aula");
					int idAula = in.nextInt();
					System.out.println("Informe o nome do novo aluno:");
					String nome = in.next();
					aulas.alterarAluno(al.encontrar(nome), idAula);
					aulas.gravar();

				}
				if (op3 == 2) {
					System.out.println("Informe o id da aula");
					int idAula = in.nextInt();
					System.out.println("Informe o nome do novo instrutor:");
					String nome = in.next();
					aulas.alterarInstrutor(il.encontrar(nome), idAula);
					aulas.gravar();

				}
				if (op3 == 3) {
					System.out.println("Informe o id da aula");
					int idAula = in.nextInt();
					System.out.println("Informe a placa do novo Veiculo:");
					String placa = in.next();
					aulas.alterarVeiculo(vl.encontrar(placa), idAula);
					aulas.gravar();

				}
			}
		}
		if (op1 == 3) {
			System.out.println("1-AULA | 2-ALUNO | 3-INSTRUTOR | 4-VEICULO");
			op2 = in.nextInt();
			if (op2 == 1) {
				System.out.println("Informe o id da aula");
				int id = in.nextInt();
				aulas.excluir(id);
			}
			if (op2 == 2) {
				System.out.println("Informe o id do Aluno");
				int id = in.nextInt();
				al.excluir(id);
			}
			if (op2 == 3) {
				System.out.println("Informe o id Instrutor");
				int id = in.nextInt();
				il.excluir(id);
			}
			if (op2 == 4) {
				System.out.println("Informe o id do Veiculo");
				int id = in.nextInt();
				vl.excluir(id);
			}
		}
		if (op1 == 4) {
			System.out.println("1-DATA | 2-ALUNO | 3-INSTRUTOR | 4-VEICULO");
			op2 = in.nextInt();
			if (op2 == 1) {
				System.out.println("Informe o dia");
				String dia = in.next();
				System.out.println(aulas.relatorioData(dia));
			}
			if (op2 == 2) {
				System.out.println("Informe o nome do Aluno");
				String nome = in.next();
				aulas.setLista(aulas.ler());
				System.out.println(aulas.relatorioAluno(nome));
			}
			if (op2 == 3) {
				System.out.println("Informe o nome do Instrutor");
				String nome = in.next();
				System.out.println(aulas.relatorioInstrutor(nome));
			}
			if (op2 == 4) {
				System.out.println("Informe o placa do Veiculo");
				String placa = in.next();
				System.out.println(aulas.relatorioVeiculo(placa));
			}
		}
		if (op1 == 5) {
			System.out.println("1-AULA | 2-ALUNO | 3-INSTRUTOR | 4-VEICULO");
			op2 = in.nextInt();
			if (op2 == 1) {
				aulas = new AulaLista();

				aulas.setLista(aulas.ler());

				for (Aula x : aulas.getLista()) {
					System.out.println(x);
				}

			}
			if (op2 == 2) {
				al = new AlunoLista();

				al.setLista(al.ler());

				for (Aluno x : al.getLista()) {
					System.out.println(x);
				}

			}
			if (op2 == 3) {
				il = new InstrutorLista();

				il.setLista(il.ler());

				for (Instrutor x : il.getLista()) {
					System.out.println(x);
				}

			}
			if (op2 == 4) {
				vl = new VeiculoLista();

				vl.setLista(vl.ler());

				for (Veiculo x : vl.getLista()) {
					System.out.println(x);
				}

			}

		}

		in.close();

	}
}
