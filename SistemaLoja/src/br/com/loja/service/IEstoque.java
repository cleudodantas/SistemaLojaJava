package br.com.loja.service;

import br.com.loja.model.Produto;

public interface IEstoque {
    void adicionarProduto(Produto produto);
    void removerProduto(int id);
    void atualizarEstoque(int id, int novaQuantidade);
    Produto buscarProduto(int id);
}
