public class SearchTreeByPrice {
    private TreeNodeByPrice root;

    public SearchTreeByPrice() {
        this.root = null;
    }

    public void addNode(Product product) {
        TreeNodeByPrice newNode = new TreeNodeByPrice(product);

        if (root == null) {
            root = newNode;
        } else {
            TreeNodeByPrice currentNode = root;
            TreeNodeByPrice parent;

            while (true) {
                parent = currentNode;

                if (product.getPrice() < currentNode.getProduct().getPrice()) {
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

    public Product searchProduct(double price) {
        return searchNode(root, price);
    }

    private Product searchNode(TreeNodeByPrice currentNode, double price) {
        if (currentNode == null || currentNode.getProduct().getPrice() == price) {
            return currentNode == null ? null : currentNode.getProduct();
        }

        if (price < currentNode.getProduct().getPrice()) {
            return searchNode(currentNode.getLeft(), price);
        } else {
            return searchNode(currentNode.getRight(), price);
        }
    }
}
