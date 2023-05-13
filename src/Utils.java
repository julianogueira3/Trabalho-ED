public class Utils {
    public static void displayProduct(Product product) {
        System.out.println("Código: " + product.getCode());
        System.out.println("Nome: " + product.getName());
        System.out.println("Quantidade: " + product.getQuantity());
        System.out.println("Preço: " + product.getPrice());
        System.out.println("-------------------------");
    }
}
