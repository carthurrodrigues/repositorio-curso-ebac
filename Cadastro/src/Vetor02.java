import java.util.Arrays;
import java.util.Scanner;

public class Vetor02 {
    public static void main(String[] args) {
        System.out.println("Digite a quantidade de espaço no vetor");
        Scanner scanner = new Scanner(System.in);
        int space = scanner.nextInt();
        int[] vetor2 = new int[space];

        for (int i = 0; i < space; i++) {
            System.out.println("Digite o valor para posição " + i + ": ");
            vetor2[i] = scanner.nextInt();

            if (vetor2[i] % 2 == 0) {
                vetor2[i] *= 2;
            } else {
                vetor2[i] = (int) Math.pow(vetor2[i], 2);
            }
        }
        System.out.println("Resultado do calculo:" + Arrays.toString(vetor2));
        scanner.close();
    }
}
