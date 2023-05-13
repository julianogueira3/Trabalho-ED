import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductTree productTree = new ProductTree();

        boolean running = true;
        while (running) {
            System.out.println("===== Gerenciamento de Estoque =====");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Atualizar quantidade em estoque");
            System.out.println("4. Exibir estoque");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("===== Adicionar Produto =====");
                    System.out.print("Código: ");
                    int code = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    String name = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Preço: ");
                    double price = scanner.nextDouble();

                    Product product = new Product(code, name, quantity, price);
                    productTree.addProduct(product);
                    System.out.println("Produto adicionado ao estoque.");
                    break;
                case 2:
                    System.out.println("===== Remover Produto =====");
                    System.out.print("Código do produto a ser removido: ");
                    int removeCode = scanner.nextInt();
                    productTree.removeProduct(removeCode);
                    System.out.println("Produto removido do estoque.");
                    break;
                case 3:
                    System.out.println("===== Atualizar Quantidade em Estoque =====");
                    System.out.print("Código do produto: ");
                    int updateCode = scanner.nextInt();
                    System.out.print("Nova quantidade: ");
                    int newQuantity = scanner.nextInt();
                    productTree.updateQuantity(updateCode, newQuantity);
                    System.out.println("Quantidade em estoque atualizada.");
                    break;
                case 4:
                    System.out.println("===== Exibir Estoque =====");
                    displayStock(productTree.getRoot());
                    break;
                case 5:
                    running = false;
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void displayStock(TreeNode root) {
        if (root != null) {
            displayStock(root.getLeft());
            Product product = root.getProduct();
            System.out.println("Código: " + product.getCode());
            System.out.println("Nome: " + product.getName());
            System.out.println("Quantidade: " + product.getQuantity());
            System.out.println("Preço: " + product.getPrice());
            System.out.println("--------------------");
            displayStock(root.getRight());
        }
    }
}