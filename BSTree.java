import java.util.NoSuchElementException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BSTree <Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node father;
        private Node left;
        private Node right;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public void inorder(){
        inorder(root);
    }

    private void inorder(Node x) {
        if(x == null) return;
        inorder(x.left);
        System.out.println(x.key + " " + x.val);
        inorder(x.right);
    }

    public void revorder(){
        revorder(root);
    }

    private void revorder(Node x) {
        if(x == null) return;
        revorder(x.right);
        System.out.println(x.key + " " + x.val);
        revorder(x.left);
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(Node x) {
        if(x == null) return;
        System.out.println(x.key + " " + x.val);
        preorder(x.left);
        preorder(x.right);
    }

    public void posorder() {
        posorder(root);
    }

    private void posorder(Node x) {
        if(x == null) return;
        posorder(x.left);
        posorder(x.right);
        System.out.println(x.key + " " + x.val);
    }

    /**
     * Inicializes an empty symbol table
     */
    public BSTree(){ }

    public boolean contains(Key key) {
        if(key == null)
            throw new NullPointerException("argument to contains() is null");
        return get(key) != null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key); //Algorithms
        if (cmp < 0)
            return get(x.left, key);
        else if (cmp > 0) 
            return get(x.right, key);
        else
            return x.val;
    }

    public void put (Key key, Value val) {
        int cmp;
        Node z = new Node(key, val);
        Node x = root;
        Node y = null;
        while(x != null) {
            y = x;
            cmp = key.compareTo(x.key);
            if(cmp < 0)
                x = x.left;
            if(cmp > 0)
                x = x.right;
            if(cmp == 0) {
                if (val == null) 
                    delete(key);
                else 
                    x.val = val;
            }
        }
        z.father = y;
        if(y == null)
            root = z;
        else {
            cmp = key.compareTo(y.key);
            if(cmp < 0)
                y.left = z;
            else
                y.right = z;
        }
    }
}