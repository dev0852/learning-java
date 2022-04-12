//this class is used to create a kdTree
public class kdTree {
    private Node root;
    private int size;

    //constructor
    public kdTree() {
        root = null;
        size = 0;
    }

    //returns the size of the tree
    public int size() {
        return size;
    }

    //returns true if the tree is empty
    public boolean isEmpty() {
        return size == 0;
    }

    //inserts a point into the tree
    public void insert(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        root = insert(root, p, 0);
        size++;
    }

    //helper method for insert
    private Node insert(Node node, Point2D p, int depth) {
        if (node == null) {
            return new Node(p, depth);
        }
        if (p.equals(node.p)) {
            return node;
        }
        if (p.get(depth) < node.p.get(depth)) {
            node.left = insert(node.left, p, depth + 1);
        } else {
            node.right = insert(node.right, p, depth + 1);
        }
        return node;
    }

    //returns true if the tree contains p
    public boolean contains(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        return contains(root, p, 0);
    }

    //helper method for contains
    private boolean contains(Node node, Point2D p, int depth) {
        if (node == null) {
            return false;
        }
        if (p.equals(node.p)) {
            return true;
        }
        if (p.get(depth) < node.p.get(depth)) {
            return contains(node.left, p, depth + 1);
        } else {
            return contains(node.right, p, depth + 1);
        }
    }

    //returns the nearest neighbor to p
    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        return nearest(root, p, 0, root.p);
    }

    //helper method for nearest
    private Point2D nearest(Node node, Point2D p, int depth, Point2D nearest) {
        if (node == null) {
            return nearest;
        }
        if (p.equals(node.p)) {
            return node.p;
        }
        if (p.get(depth) < node.p.get(depth)) {
            if (node.p.distanceTo(p) < nearest.distanceTo(p)) {
                nearest = node.p;
            }
            return nearest(node.left, p, depth + 1, nearest);
        } else {
            if (node.p.distanceTo(p) < nearest.distanceTo(p)) {
                nearest = node.p;
            }
            return nearest(node.right, p, depth + 1, nearest);
        }
    }

    //inner class for nodes
    private class Node {
        private Point2D p;
        private int depth;
        private Node left;
        private Node right;

        //constructor
        public Node(Point2D p, int depth) {
            this.p = p;
            this.depth = depth;
            left = null;
            right = null;
        }
    }

}

