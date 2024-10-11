package pacote_de_dados;
import pacote_de_negocios.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositorio {
    private static ProdutoRepositorio instance;
    private List<Produto> produtos;

  
    private ProdutoRepositorio() {
        this.produtos = new ArrayList<>();
    }

   
    public static synchronized ProdutoRepositorio getInstance() {
        if (instance == null) {
            instance = new ProdutoRepositorio();
        }
        return instance;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}