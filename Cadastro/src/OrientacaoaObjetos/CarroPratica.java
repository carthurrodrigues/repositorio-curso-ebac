package OrientacaoaObjetos;

public class CarroPratica {
    private String marca;
    private String modelo;
    private int ano;
    private String cor;
    private double preco;

    public CarroPratica() {
    }

    public CarroPratica(String marca, String modelo, int ano, String cor, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "CarroPratica [marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", cor=" + cor + ", preco="
                + preco + "]";
    }
}
