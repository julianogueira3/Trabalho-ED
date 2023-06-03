public class TreeNodeByCode {
    private Product product;
    private TreeNodeByCode left;
    private TreeNodeByCode right;

    public TreeNodeByCode(Product product) {
        this.product = product;
        this.left = null;
        this.right = null;
    }

    public Product getProduct() {
        return product;
    }

    public TreeNodeByCode getLeft() {
        return left;
    }

    public void setLeft(TreeNodeByCode left) {
        this.left = left;
    }

    public TreeNodeByCode getRight() {
        return right;
    }

    public void setRight(TreeNodeByCode right) {
        this.right = right;
    }
}

