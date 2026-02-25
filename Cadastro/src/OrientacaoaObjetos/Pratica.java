package OrientacaoaObjetos;

import java.util.Scanner;

public class Pratica {
    public static void main(String[] args) {
        System.out.println("Fale a quantidade de objetos do tipo carro ( Máximo 50 )");
        Scanner scanner = new Scanner(System.in);
        int quantidade = scanner.nextInt();
        if (quantidade > 50) {
            System.out.println("Quantidade inválida");
            return;
        }
        CarroPratica[] carros = new CarroPratica[quantidade];
        for (int i = 0; i < quantidade; i++) {
            carros[i] = new CarroPratica();
            System.out.println("Digite a marca do carro: ");
            carros[i].setMarca(scanner.next());
            System.out.println("Digite o modelo do carro: ");
            carros[i].setModelo(scanner.next());
            System.out.println("Digite o ano do carro: ");
            carros[i].setAno(scanner.nextInt());
            System.out.println("Digite a cor do carro: ");
            carros[i].setCor(scanner.next());
            System.out.println("Digite o preço do carro: ");
            carros[i].setPreco(scanner.nextDouble());
        }
        for (int i = 0; i < quantidade; i++) {
            System.out.println(carros[i]);
        }
        scanner.close();
    }
}
