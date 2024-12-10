package br.com.loja.model;

import java.util.List;

public class Venda {
    private List<Produto> produtosVendidos;
    private double totalVenda;

    public Venda(List<Produto> produtosVendidos) {
        this.produtosVendidos = produtosVendidos;
        this.totalVenda = calcularTotalVenda();
    }

    private double calcularTotalVenda() {
        double total = 0;
        for (Produto produto : produtosVendidos) {
            total += produto.getPreco();
        }
        return total;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public List<Produto> getProdutosVendidos() {
        return produtosVendidos;
    }

    @Override
    public String toString() {
        return "Venda [produtosVendidos=" + produtosVendidos + ", totalVenda=" + totalVenda + "]";
    }
}
