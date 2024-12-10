package br.com.loja.service;

import br.com.loja.model.Venda;
import br.com.loja.model.Produto;
import java.util.List;

public class VendaService {
    private EstoqueService estoqueService;

    public VendaService(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    public Venda realizarVenda(List<Produto> produtos) {
        for (Produto produto : produtos) {
            Produto estoqueProduto = estoqueService.buscarProduto(produto.getId());
            if (estoqueProduto != null && estoqueProduto.getQuantidadeEstoque() > 0) {
                estoqueProduto.setQuantidadeEstoque(estoqueProduto.getQuantidadeEstoque() - 1);
            } else {
                System.out.println("Produto " + produto.getNome() + " não disponível em estoque.");
                return null;
            }
        }
        return new Venda(produtos);
    }
}
