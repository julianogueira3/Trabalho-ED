public class ProductTree {
    TreeNode root;

    public ProductTree() {
        root = null;
    }

    public void addProduct(Product product) {
        root = addProductRec(root, product);
    }

    private TreeNode addProductRec(TreeNode root, Product product) {
        if (root == null) {
            return new TreeNode(product);
        }

        if (product.code < root.product.code) {
            root.left = addProductRec(root.left, product);
        } else if (product.code > root.product.code) {
            root.right = addProductRec(root.right, product);
        }

        return root;
    }

    public void removeProduct(int code) {
        root = removeProductRec(root, code);
    }

    private TreeNode removeProductRec(TreeNode root, int code) {
        if (root == null) {
            return null;
        }

        if (code < root.product.code) {
            root.left = removeProductRec(root.left, code);
        } else if (code > root.product.code) {
            root.right = removeProductRec(root.right, code);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.product = findMin(root.right).product;
            root.right = removeProductRec(root.right, root.product.code);
        }

        return root;
    }

    public void updateQuantity(int code, int quantity) {
        TreeNode node = findProductNode(root, code);
        if (node != null) {
            node.product.quantity = quantity;
        }
    }

    private TreeNode findProductNode(TreeNode root, int code) {
        if (root == null || root.product.code == code) {
            return root;
        }

        if (code < root.product.code) {
            return findProductNode(root.left, code);
        }

        return findProductNode(root.right, code);
    }

    private TreeNode findMin(TreeNode root) {
        if (root.left != null) {
            return findMin(root.left);
        }

        return root;
    }
}
