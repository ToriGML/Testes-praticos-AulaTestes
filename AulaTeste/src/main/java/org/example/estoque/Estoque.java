package org.example.estoque;

import java.util.HashMap;
import java.util.Map;

public class Estoque {
  
    private Map<Integer, Produto> produtos;

    public Estoque() {
        produtos = new HashMap<>();
    }

    public void adicionarProduto(Produto produto) {
        if (!produtos.containsKey(produto.getId())) {
            produtos.put(produto.getId(), produto);
        }
    }

    public void removerProduto(int id) {
        produtos.remove(id);
    }

    public void atualizarQuantidade(int id, int quantidade) {
        Produto produto = produtos.get(id);
        if (produto != null) {
            produto.setQuantidade(quantidade);
        }
    }

    public int obterQuantidade(int id) {
        Produto produto = produtos.get(id);
        if (produto != null) {
            return produto.getQuantidade();
        } else {
            return -1;
        }
    }
}
