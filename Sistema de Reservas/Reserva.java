public class Reserva {

    private String nomeHospede;
    private String tipoQuarto;
    private int numeroDias;
    private double valorDiaria;

    public Reserva(String nomeHospede, String tipoQuarto, int numeroDias, double valorDiaria) {
        this.nomeHospede = nomeHospede;
        this.tipoQuarto = tipoQuarto;
        setNumeroDias(numeroDias);
        setValorDiaria(valorDiaria);
    }

    public Reserva(String nomeHospede, String tipoQuarto) {
        this.nomeHospede = nomeHospede;
        this.tipoQuarto = tipoQuarto;
        this.numeroDias = 1;
        this.valorDiaria = 0.0;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = nomeHospede;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public int getNumeroDias() {
        return numeroDias;
    }

    public void setNumeroDias(int numeroDias) {
        if (numeroDias < 1) {
            System.out.println("[AVISO] Número de dias inválido. Definido como 1.");
            this.numeroDias = 1;
        } else {
            this.numeroDias = numeroDias;
        }
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        if (valorDiaria <= 0) {
            System.out.println("[AVISO] Valor de diária inválido. Definido como 0.01.");
            this.valorDiaria = 0.01;
        } else {
            this.valorDiaria = valorDiaria;
        }
    }

    public double calcularValorTotal() {
        return this.numeroDias * this.valorDiaria;
    }

    @Override
    public String toString() {
        return String.format(
                "┌─────────────────────────────────────────┐\n" +
                        "  Hóspede  : %-30s\n" +
                        "  Quarto   : %-30s\n" +
                        "  Dias     : %-30d\n" +
                        "  Diária   : R$ %,.2f%n" +
                        "  TOTAL    : R$ %,.2f%n" +
                        "└─────────────────────────────────────────┘",
                nomeHospede,
                tipoQuarto,
                numeroDias,
                valorDiaria,
                calcularValorTotal());
    }
}