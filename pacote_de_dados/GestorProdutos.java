package pacote_de_dados;

import pacote_de_negocios.Produto;
import java.util.List;

public class GestorProdutos {
	private ProdutoRepositorio produtoRepositorio;

    public GestorProdutos() {
        this.produtoRepositorio = ProdutoRepositorio.getInstance();
    }

    public void adicionarProduto(Produto produto) {
        produtoRepositorio.adicionarProduto(produto);
    }

    public void removerProduto(Produto produto) {
        produtoRepositorio.removerProduto(produto);
    }

    public List<Produto> consultarProdutos() {
        return produtoRepositorio.getProdutos();
    }


}
