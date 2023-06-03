import java.util.Scanner;
import java.text.Normalizer;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManagementSystem inventorySystem = new InventoryManagementSystem();
        SearchTreeByName searchTreeByName = new SearchTreeByName();
        SearchTreeByCode searchTreeByCode = new SearchTreeByCode();

        boolean running = true;
        while (running) {
            System.out.println("===== Gerenciamento de Estoque =====");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Atualizar quantidade em estoque");
            System.out.println("4. Exibir estoque");
            System.out.println("5. Buscar produto por nome");
            System.out.println("6. Buscar produto por Código");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("===== Adicionar Produto =====");

                    String name;
                    boolean nameExists = false;
                    boolean codeExists =false;
                    do {
                        System.out.print("Nome: ");
                        name = scanner.nextLine();
                        name=name.toLowerCase();
                        String normalized = Normalizer.normalize(name, Normalizer.Form.NFD);
                        normalized =normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
                        name = normalized;
                        Product foundByName = searchTreeByName.searchProduct(name);
                        if (foundByName != null) {
                            nameExists=true;
                            System.out.println("Nome de produto já inserido. Insira outro nome");
                        }else{nameExists=false;}
                    } while (name.trim().isEmpty() || nameExists);

                    int code;
                    do {
                        System.out.print("Código: ");
                        code = scanner.nextInt();
                        scanner.nextLine();
                        Product foundByCode = searchTreeByCode.searchProduct(Integer.parseInt(String.valueOf(code)));
                        if (foundByCode != null) {
                            codeExists = true;
                            System.out.println("Código do produto já inserido. Insira outro Código");
                        } else {codeExists=false;}
                    } while (code == 0 || codeExists);

                    int quantity;
                    do {
                        System.out.print("Quantidade: ");
                        quantity = scanner.nextInt();
                        scanner.nextLine();
                    } while (quantity == 0 );

                    double price;
                    do {
                        System.out.print("Preço: ");
                        price = scanner.nextDouble();
                        scanner.nextLine();
                    } while (price == 0.0);

                    Product product = new Product(code, name, quantity, price);
                    inventorySystem.addProduct(product);
                    searchTreeByName.addNode(product);
                    searchTreeByCode.addNode(product);
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
                    System.out.println("===== Buscar Produto por Código do Produto =====");
                    System.out.print("Código do Produto: ");
                    int searchCode = scanner.nextInt();
                    Product foundByCode = searchTreeByCode.searchProduct(Integer.parseInt(String.valueOf(searchCode)));
                    if (foundByCode != null) {
                        Utils.displayProduct(foundByCode);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    System.out.println("\nEnter para continuar");
                    scanner.nextLine();
                    scanner.nextLine(); // Adicione uma chamada extra para consumir a nova linha pendente
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
