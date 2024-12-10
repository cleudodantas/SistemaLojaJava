//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package br.com.loja.main;

import br.com.loja.model.Produto;
import br.com.loja.model.Venda;
import br.com.loja.service.EstoqueService;
import br.com.loja.service.VendaService;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EstoqueService estoqueService = new EstoqueService();
        VendaService vendaService = new VendaService(estoqueService);

        Produto p1 = new Produto(1, "Camiseta", 50.0, 10);
        Produto p2 = new Produto(2, "Calça", 120.0, 5);
        Produto p3 = new Produto(3, "Tênis", 200.0, 2);

        estoqueService.adicionarProduto(p1);
        estoqueService.adicionarProduto(p2);
        estoqueService.adicionarProduto(p3);

        Venda venda = vendaService.realizarVenda(Arrays.asList(p1, p2));

        if (venda != null) {
            System.out.println("Venda realizada: " + venda);
        }

        System.out.println("\nRelatório de Estoque:");
        estoqueService.listarProdutos().forEach(System.out::println);
    }
}
