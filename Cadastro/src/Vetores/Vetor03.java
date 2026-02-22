package Vetores;

import java.util.Scanner;

public class Vetor03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um nome para ser invertido: ");
        String name2 = scanner.nextLine();
        String inverted = new StringBuilder(name2).reverse().toString();
        System.out.println("O nome invertido é: " + inverted);
        scanner.close();
    }
}
