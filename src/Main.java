import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManagementSystem inventorySystem = new InventoryManagementSystem();

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

                    inventorySystem.addProduct(code, name, quantity, price);
                    System.out.println("Produto adicionado ao estoque.");
                    break;
                case 2:
                    System.out.println("===== Remover Produto =====");
                    System.out.print("Código do produto a ser removido: ");
                    int removeCode = scanner.nextInt();
                    inventorySystem.removeProduct(removeCode);
                    System.out.println("Produto removido do estoque.");
                    break;
                case 3:
                    System.out.println("===== Atualizar Quantidade em Estoque =====");
                    System.out.print("Código do produto: ");
                    int updateCode = scanner.nextInt();
                    System.out.print("Nova quantidade: ");
                    int newQuantity = scanner.nextInt();
                    inventorySystem.updateQuantity(updateCode, newQuantity);
                    System.out.println("Quantidade em estoque atualizada.");
                    break;
                case 4:
                    System.out.println("===== Exibir Estoque =====");
                    inventorySystem.displayInventory();
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
}
