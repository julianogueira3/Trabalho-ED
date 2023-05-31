public class TreeNodeByPrice {
    private Product product;
    private TreeNodeByPrice left;
    private TreeNodeByPrice right;

    public TreeNodeByPrice(Product product) {
        this.product = product;
        this.left = null;
        this.right = null;
    }

    public Product getProduct() {
        return product;
    }

    public TreeNodeByPrice getLeft() {
        return left;
    }

    public void setLeft(TreeNodeByPrice left) {
        this.left = left;
    }

    public TreeNodeByPrice getRight() {
        return right;
    }

    public void setRight(TreeNodeByPrice right) {
        this.right = right;
    }
}

