public class InventoryManagementSystem {
    private ProductTree productTree;

    public InventoryManagementSystem() {
        productTree = new ProductTree();
    }

    public void addProduct(int code, String name, int quantity, double price) {
        Product product = new Product(code, name, quantity, price);
        productTree.addProduct(product);
        System.out.println("Produto adicionado com sucesso!");
    }

    public void removeProduct(int code) {
        productTree.removeProduct(code);
        System.out.println("Produto removido com sucesso!");
    }

    public void updateQuantity(int code, int quantity) {
        productTree.updateQuantity(code, quantity);
        System.out.println("Quantidade atualizada com sucesso!");
    }

    public void displayInventory() {
        System.out.println("Estoque:");
        displayProductTree(productTree.getRoot());
    }

    private void displayProductTree(TreeNode root) {
        if (root != null) {
            displayProductTree(root.getLeft());
            Utils.displayProduct(root.getProduct());
            displayProductTree(root.getRight());
        }
    }
}

