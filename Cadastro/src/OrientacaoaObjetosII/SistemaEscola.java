package OrientacaoaObjetosII;

import java.util.Scanner;

public class SistemaEscola {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a quantidade de alunos que deseja cadastrar:");
        int quantidadeAlunos = scanner.nextInt();

        System.out.println("Quantas provas foram realizadas no ano?");
        int quantidadeProvas = scanner.nextInt();

        AlunoObjeto[] alunos = new AlunoObjeto[quantidadeAlunos];

        for (int i = 0; i < quantidadeAlunos; i++) {
            scanner.nextLine();
            System.out.println("----Cadastro do Aluno " + (i + 1) + "-----");
            System.out.println("Digite o nome do aluno: ");
            String nome = scanner.nextLine();
            System.out.println("Digite a matricula do aluno: ");
            String matricula = scanner.nextLine();

            alunos[i] = new AlunoObjeto(nome, matricula, quantidadeProvas);

            for (int j = 0; j < quantidadeProvas; j++) {
                System.out.println("Digite a nota do aluno na prova " + (j + 1) + ": ");
                double notas = scanner.nextDouble();
                alunos[i].setNotaIndividual(j, notas);
                if (notas < 0 || notas > 10) {
                    System.out.println("Nota inválida");
                    return;
                }
            }
        }
        System.out.println("--- Relatório Aluno---");
        for (AlunoObjeto aluno : alunos) {
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Matricula: " + aluno.getMatricula());
            System.out.println("Media: " + aluno.calcularMedia());
        }
        scanner.close();
    }
}
