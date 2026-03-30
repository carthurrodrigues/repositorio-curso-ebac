public class Escada {
    public static int subirEscada(int n) {
        // Casos Base
        if (n <= 1) return 1;
        if (n == 2) return 2;

        // Chamada Recursiva
        return subirEscada(n - 1) + subirEscada(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Maneiras para " + n + " degraus: " + subirEscada(n));
    }
}