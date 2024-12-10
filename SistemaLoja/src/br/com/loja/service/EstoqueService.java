package br.com.loja.service;

import br.com.loja.model.Produto;
import java.util.List;
import java.util.ArrayList;

public class EstoqueService implements IEstoque {
    private List<Produto> produtos;

    public EstoqueService() {
        produtos = new ArrayList<>();
    }

    @Override
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public void removerProduto(int id) {
        produtos.removeIf(p -> p.getId() == id);
    }

    @Override
    public void atualizarEstoque(int id, int novaQuantidade) {
        Produto produto = buscarProduto(id);
        if (produto != null) {
            produto.setQuantidadeEstoque(novaQuantidade);
        }
    }

    @Override
    public Produto buscarProduto(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }
}
