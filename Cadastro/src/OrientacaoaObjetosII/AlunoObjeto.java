package OrientacaoaObjetosII;

public class AlunoObjeto {
    private String nome;
    private String matricula;
    private double[] notas;

    public AlunoObjeto(String nome, String matricula, int quantidadeProvas) {
        this.nome = nome;
        this.matricula = matricula;
        this.notas = new double[quantidadeProvas];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotaIndividual(int index, double valor) {
        this.notas[index] = valor;
    }

    public double calcularMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }
}
