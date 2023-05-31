public class SearchTreeByName {
    private TreeNodeByName root;

    public SearchTreeByName() {
        this.root = null;
    }

    public void addNode(Product product) {
        TreeNodeByName newNode = new TreeNodeByName(product);

        if (root == null) {
            root = newNode;
        } else {
            TreeNodeByName currentNode = root;
            TreeNodeByName parent;

            while (true) {
                parent = currentNode;

                if (product.getName().compareTo(currentNode.getProduct().getName()) < 0) {
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

    public Product searchProduct(String name) {
        return searchNode(root, name);
    }

    private Product searchNode(TreeNodeByName currentNode, String name) {
        if (currentNode == null || currentNode.getProduct().getName().equals(name)) {
            return currentNode == null ? null : currentNode.getProduct();
        }

        if (name.compareTo(currentNode.getProduct().getName()) < 0) {
            return searchNode(currentNode.getLeft(), name);
        } else {
            return searchNode(currentNode.getRight(), name);
        }
    }
}

