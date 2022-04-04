public class Btree {
    private Node root;
    private int size;
    private int height;

    public Btree() {
        root = null;
        size = 0;
        height = 0;
    }

    public Node getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    public int getHeight() {
        return height;
    }

    public void getLeft(Node node) {
        if (node.getLeft() != null) {
            System.out.println(node.getLeft().getData());
        }
    }

    public void getRight(Node node) {
        if (node.getRight() != null) {
            System.out.println(node.getRight().getData());
        }
    }

    public void getParent(Node node) {
        if (node.getParent() != null) {
            System.out.println(node.getParent().getData());
        }
    }

    public void getData(Node node) {
        if (node != null) {
            System.out.println(node.getData());
        }
    }

    public void getHeight(Node node) {
        if (node != null) {
            System.out.println(node.getHeight());
        }
    }

    public void getSize(Node node) {
        if (node != null) {
            System.out.println(node.getSize());
        }
    }

    public void getBalance(Node node) {
        if (node != null) {
            System.out.println(node.getBalance());
        }
    }

    public void getLeftHeight(Node node) {
        if (node != null) {
            System.out.println(node.getLeftHeight());
        }
    }

    public void getRightHeight(Node node) {
        if (node != null) {
            System.out.println(node.getRightHeight());
        }
    }

    public void getLeftSize(Node node) {
        if (node != null) {
            System.out.println(node.getLeftSize());
        }
    }

    public void getRightSize(Node node) {
        if (node != null) {
            System.out.println(node.getRightSize());
        }
    }

    public void getLeftBalance(Node node) {
        if (node != null) {
            System.out.println(node.getLeftBalance());
        }
    }

    public void getRightBalance(Node node) {
        if (node != null) {
            System.out.println(node.getRightBalance());

        }

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
            size++;
            height = 1;
        } else {
            insert(key, root);
        }
    }

    private void insert(int key, Node node) {
        if (node.getKey() == key) {
            return;
        } else if (key < node.getKey()) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(key));
                size++;
                height = Math.max(height, node.getLeft().getHeight() + 1);
            } else {
                insert(key, node.getLeft());
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new Node(key));
                size++;
                height = Math.max(height, node.getRight().getHeight() + 1);
            } else {
                insert(key, node.getRight());
            }
        }
    }

    public void delete(int key) {
        if (root == null) {
            return;
        } else {
            delete(key, root);
        }
    }

    private void delete(int key, Node node) {
        if (node.getKey() == key) {
            if (node.getLeft() == null && node.getRight() == null) {
                node = null;
                size--;
                height = Math.max(height, node.getHeight() - 1);
            } else if (node.getLeft() == null) {
                node = node.getRight();
                size--;
                height = Math.max(height, node.getHeight() - 1);
            } else if (node.getRight() == null) {
                node = node.getLeft();
                size--;
                height = Math.max(height, node.getHeight() - 1);

            }
        }
    }
}

