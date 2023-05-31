//A classe InventoryManagementSystem é responsável por gerenciar o estoque de produtos.
// Ela utiliza uma estrutura de árvore binária de busca do tipo ProductTree para armazenar os produtos de forma organizada.
// A classe possui métodos para adicionar um produto ao estoque, remover um produto, atualizar a quantidade de um produto e exibir o estoque atual.
// Esses métodos interagem com a árvore de produtos e realizam as operações correspondentes.
// A classe também utiliza a classe Utils para exibir as informações dos produtos de forma legível.
// O InventoryManagementSystem é a classe principal que coordena as funcionalidades de gerenciamento do estoque
// e é utilizada pela classe Main para interagir com o usuário através de um menu de opções.

import java.util.Scanner;

public class InventoryManagementSystem {
    private ProductTree searchTreeByName;
    private ProductTree searchTreeByPrice;
    private boolean useSearchTreeByName;

    public InventoryManagementSystem() {
        searchTreeByName = new ProductTree();
        searchTreeByPrice = new ProductTree();
        useSearchTreeByName = true;
    }

    public void addProduct(int code, String name, int quantity, double price) {
        Product product = new Product(code, name, quantity, price);
        searchTreeByName.addProduct(product);
        searchTreeByPrice.addProduct(product);
        System.out.println("Produto adicionado com sucesso!");
    }

    public void removeProduct(int code) {
        searchTreeByName.removeProduct(code);
        searchTreeByPrice.removeProduct(code);
        System.out.println("Produto removido com sucesso!");
    }

    public void updateQuantity(int code, int quantity) {
        searchTreeByName.updateQuantity(code, quantity);
        searchTreeByPrice.updateQuantity(code, quantity);
        System.out.println("Quantidade atualizada com sucesso!");
    }

    public void displayInventory() {
        System.out.println("Estoque:");
        if (useSearchTreeByName) {
            displayProductTree(searchTreeByName.getRoot());
        } else {
            displayProductTree(searchTreeByPrice.getRoot());
        }
    }

    private void displayProductTree(TreeNode root) {
        if (root != null) {
            displayProductTree(root.getLeft());
            Utils.displayProduct(root.getProduct());
            displayProductTree(root.getRight());
        }
    }

    public void setSearchTreeByName() {
        useSearchTreeByName = true;
        System.out.println("Utilizando a árvore de busca por nome.");
    }

    public void setSearchTreeByPrice() {
        useSearchTreeByName = false;
        System.out.println("Utilizando a árvore de busca por preço.");
    }

    public Product searchProduct(String keyword) {
        if (useSearchTreeByName) {
            return searchTreeByName.searchProductByName(keyword);
        } else {
            return searchTreeByPrice.searchProductByPrice(Double.parseDouble(keyword));
        }
    }

    public void addProduct(Product product) {
        searchTreeByName.addProduct(product);
        searchTreeByPrice.addProduct(product);
        System.out.println("Produto adicionado com sucesso!");
    }
}




