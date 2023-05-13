public class TreeNode {
    private Product product;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Product product) {
        this.product = product;
        this.left = null;
        this.right = null;
    }

    public Product getProduct() {
        return product;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setProduct(Product product) {
    }
}
