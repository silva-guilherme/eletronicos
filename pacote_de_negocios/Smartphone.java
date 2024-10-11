package pacote_de_negocios;

public class Smartphone extends Produto {
    private String versao;

    public Smartphone(String marca, String modelo, double preco, int quantidadeEstoque, String categoria, String versao) {
        super(marca, modelo, preco, quantidadeEstoque, categoria);
        this.versao = versao;
    }

    
    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }
    
}