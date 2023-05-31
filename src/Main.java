import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManagementSystem inventorySystem = new InventoryManagementSystem();
        SearchTreeByName searchTreeByName = new SearchTreeByName();
        SearchTreeByPrice searchTreeByPrice = new SearchTreeByPrice();

        boolean running = true;
        while (running) {
            System.out.println("===== Gerenciamento de Estoque =====");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Atualizar quantidade em estoque");
            System.out.println("4. Exibir estoque");
            System.out.println("5. Buscar produto por nome");
            System.out.println("6. Buscar produto por preço");
            System.out.println("7. Sair");
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
                    inventorySystem.addProduct(product);
                    searchTreeByName.addNode(product);
                    searchTreeByPrice.addNode(product);
                    System.out.println("Produto adicionado ao estoque.");
                    System.out.println("\nEnter para continuar");
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.println("===== Remover Produto =====");
                    System.out.print("Código do produto a ser removido: ");
                    int removeCode = scanner.nextInt();
                    inventorySystem.removeProduct(removeCode);
                    System.out.println("Produto removido do estoque.");
                    System.out.println("\nEnter para continuar");
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("===== Atualizar Quantidade em Estoque =====");
                    System.out.print("Código do produto: ");
                    int updateCode = scanner.nextInt();
                    System.out.print("Nova quantidade: ");
                    int newQuantity = scanner.nextInt();
                    inventorySystem.updateQuantity(updateCode, newQuantity);
                    System.out.println("Quantidade em estoque atualizada.");
                    System.out.println("\nEnter para continuar");
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.println("===== Exibir Estoque =====");
                    inventorySystem.displayInventory();
                    System.out.println("\nEnter para continuar");
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.println("===== Buscar Produto por Nome =====");
                    System.out.print("Nome do produto: ");
                    String searchName = scanner.nextLine();
                    Product foundByName = searchTreeByName.searchProduct(searchName);
                    if (foundByName != null) {
                        Utils.displayProduct(foundByName);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    System.out.println("\nEnter para continuar");
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.println("===== Buscar Produto por Preço =====");
                    System.out.print("Preço do produto: ");
                    double searchPrice = scanner.nextDouble();
                    Product foundByPrice = searchTreeByPrice.searchProduct(searchPrice);
                    if (foundByPrice != null) {
                        Utils.displayProduct(foundByPrice);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    System.out.println("\nEnter para continuar");
                    scanner.nextLine();
                    break;
                case 7:
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
}
