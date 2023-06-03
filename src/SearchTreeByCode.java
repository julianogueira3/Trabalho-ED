public class SearchTreeByCode {
    private TreeNodeByCode root;

    public SearchTreeByCode() {
        this.root = null;
    }

    public void addNode(Product product) {
        TreeNodeByCode newNode = new TreeNodeByCode(product);

        if (root == null) {
            root = newNode;
        } else {
            TreeNodeByCode currentNode = root;
            TreeNodeByCode parent;

            while (true) {
                parent = currentNode;

                if (product.getCode() < currentNode.getProduct().getCode()) {
                    currentNode = currentNode.getLeft();

                    if (currentNode == null) {
                        parent.setLeft(newNode);
                        return;
                    }
                } else {
                    currentNode = currentNode.getRight();

                    if (currentNode == null) {
                        parent.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }

    public Product searchProduct(int code) {
        return searchNode(root, code);
    }

    private Product searchNode(TreeNodeByCode currentNode, int code) {
        if (currentNode == null || currentNode.getProduct().getCode() == code) {
            return currentNode == null ? null : currentNode.getProduct();
        }

        if (code < currentNode.getProduct().getCode()) {
            return searchNode(currentNode.getLeft(), code);
        } else {
            return searchNode(currentNode.getRight(), code);
        }
    }
}
