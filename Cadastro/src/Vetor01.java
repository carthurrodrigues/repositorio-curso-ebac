import java.util.Scanner;

public class Vetor01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos números tera o vetor?");

        int num = scanner.nextInt();
        int[] vetor = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.println("Digite o valor para posição " + i + ": ");
            vetor[i] = scanner.nextInt();
        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
        System.out.println("Vetor Ordenado!");

        System.out.println("Digite um nome");
        String name = scanner.nextLine();

        int count = 0;
        for (int i = 0; i < name.length(); i++) {
            char c = Character.toLowerCase(name.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        System.out.println("A quantidade de vogais no nome é: " + count);

        scanner.close();
    }
}
