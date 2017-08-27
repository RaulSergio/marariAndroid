package ucdb.br.sweccamobile;

/**
 * Created by drago on 27/08/2017.
 */

public class Produto {
    private String nomeProduto, codigoProduto;
    private double estoqueProduto, valorProduto;

    public Produto(String nomeProduto, String codigoProduto, double estoqueProduto, double valorProduto) {
        this.nomeProduto = nomeProduto;
        this.codigoProduto = codigoProduto;
        this.estoqueProduto = estoqueProduto;
        this.valorProduto = valorProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public double getEstoqueProduto() {
        return estoqueProduto;
    }

    public void setEstoqueProduto(double estoqueProduto) {
        this.estoqueProduto = estoqueProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }
}
