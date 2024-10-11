package pacote_de_interface;

import java.util.Scanner;
import pacote_de_dados.GestorProdutos;
import pacote_de_negocios.Produto;

public class Menu {
	public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        GestorProdutos gestorProdutos = new GestorProdutos();

        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Consultar produtos cadastrados");
            System.out.println("3 - Remover produto");
            System.out.println("4 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarProduto(scanner, gestorProdutos);
                    break;
                case 2:
                    consultarProdutos(gestorProdutos);
                    break;
                case 3:
                	 removerProduto(scanner, gestorProdutos);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarProduto(Scanner scanner, GestorProdutos gestorProdutos) {
        scanner.nextLine(); 
        System.out.println("Digite a marca do produto:");
        String marca = scanner.nextLine();
        System.out.println("Digite o modelo do produto:");
        String modelo = scanner.nextLine();
        System.out.println("Digite o preço do produto:");
        double preco = scanner.nextDouble();
        System.out.println("Digite a quantidade em estoque do produto:");
        int quantidadeEstoque = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Digite a categoria do produto:");
        String categoria = scanner.nextLine();

        Produto produto = new Produto(marca, modelo, preco, quantidadeEstoque, categoria);
        gestorProdutos.adicionarProduto(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void consultarProdutos(GestorProdutos gestorProdutos) {
        System.out.println("Produtos cadastrados:");
        for (Produto produto : gestorProdutos.consultarProdutos()) {
            System.out.println("Marca: " + produto.getMarca() + ", Modelo: " + produto.getModelo() +
                    ", Preço: " + produto.getPreco() + ", Quantidade em estoque: " + produto.getQuantidadeEstoque() +
                    ", Categoria: " + produto.getCategoria());
        }
    
    }


    private static void removerProduto(Scanner scanner, GestorProdutos gestorProdutos) {
        scanner.nextLine();
        System.out.println("Digite a marca do produto que deseja remover:");
        String marca = scanner.nextLine();
        System.out.println("Digite o modelo do produto que deseja remover:");
        String modelo = scanner.nextLine();
        
        Produto produtoRemover = null;
        for (Produto produto : gestorProdutos.consultarProdutos()) {
            if (produto.getMarca().equals(marca) && produto.getModelo().equals(modelo)) {
                produtoRemover = produto;
                break;
            }
        }
        
        if (produtoRemover != null) {
            System.out.println("Deseja remover todas as unidades do produto ou uma quantidade específica?");
            System.out.println("1 - Todas as unidades");
            System.out.println("2 - Quantidade específica");
            
            int opcao = scanner.nextInt();
            
            if (opcao == 1) {
                gestorProdutos.removerProduto(produtoRemover);
                System.out.println("Todas as unidades do produto foram removidas do estoque.");
            } else if (opcao == 2) {
                System.out.println("Digite a quantidade que deseja remover do estoque:");
                int quantidade = scanner.nextInt();
                if (quantidade <= produtoRemover.getQuantidadeEstoque()) {
                    produtoRemover.setQuantidadeEstoque(produtoRemover.getQuantidadeEstoque() - quantidade);
                    System.out.println(quantidade + " unidades do produto foram removidas do estoque.");
                } else {
                    System.out.println("Quantidade inválida. A quantidade em estoque é menor que a quantidade a ser removida.");
                }
            } else {
                System.out.println("Opção inválida.");
            }
        } else {
            System.out.println("Produto não encontrado.");
	
}

    }
    
    }