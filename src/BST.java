import java.util.ArrayList;
import java.util.Stack;

/**
 * An Integer Binary Search Tree
 * @author: Liliana Dhaliwal
 * @version: April 4, 2023
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        BSTNode current = root;

        // Calls recursive method
        return searchHelp(current, val);
    }

    public boolean searchHelp(BSTNode current, int val){
        // Returns true if the desired node is found
        if(current.getVal() == val){
            return true;
        }
        // Returns false if the desired node hasn't been found and there are no more nodes to explore
        if(current.getLeft() == null && current.getRight() == null){
            return false;
        }

        // Calls recursive method on the next node based on if the desired node
        // is greater or less than the current node in value
        if(current.getVal() > val){
            return searchHelp(current.getLeft(), val);
        }
        if(current.getVal() < val){
            return searchHelp(current.getRight(), val);
        }
        return false;
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        BSTNode current = root;
        // Create an ArrayList to store the sorted nodes
        ArrayList<BSTNode> sorted = new ArrayList<>();

        // Calls recursive method
        inorderHelp(current, sorted);
        return sorted;
    }

    public void inorderHelp(BSTNode current, ArrayList<BSTNode> sorted){
        // Returns if there are no more nodes to explore
        if(current == null) {
            return;
        }

        // Explores and adds nodes in inorder
        inorderHelp(current.getLeft(), sorted);
        sorted.add(current);
        inorderHelp(current.getRight(), sorted);
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        BSTNode current = root;
        // Create an ArrayList to store the sorted nodes
        ArrayList<BSTNode> sorted = new ArrayList<>();

        // Calls recursive method
        preorderHelp(current, sorted);
        return sorted;
    }

    public void preorderHelp(BSTNode current, ArrayList<BSTNode> sorted){
        // Returns if there are no more nodes to explore
        if(current == null){
            return;
        }

        // Explores and adds nodes in preorder
        sorted.add(current);
        preorderHelp(current.getLeft(), sorted);
        preorderHelp(current.getRight(), sorted);
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        BSTNode current = root;
        // Create an ArrayList to store the sorted nodes
        ArrayList<BSTNode> sorted = new ArrayList<>();

        // Calls recursive method
        postorderHelp(current, sorted);
        return sorted;
    }

    public void postorderHelp(BSTNode current, ArrayList<BSTNode> sorted){
        // Returns if there are no more nodes to explore
        if(current == null){
            return;
        }

        // Explores and adds nodes in postorder
        postorderHelp(current.getLeft(), sorted);
        postorderHelp(current.getRight(), sorted);
        sorted.add(current);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        BSTNode current = root;

        // Calls recursive method
        insertHelp(val, current);
    }

    public void insertHelp(int val, BSTNode current){
        // Returns if the node to insert is already in the tree
        if(current.getVal() == val){
            return;
        }
        // Inserts the node when there are no more nodes to explore
        else if (current.getLeft() == null && current.getRight() == null) {
            if(current.getVal() > val){
                // Inserts the node on the left if it is less than the parent
                current.setLeft(new BSTNode(val));
            }
            else{
                //Inserts the node on the right if it is greater than the parent
                current.setRight(new BSTNode(val));
            }
        }

        // Calls recursive method based on if the current node is less or greater than the node being inserted
        if(current.getVal() > val){
            insertHelp(val, current.getLeft());
        }
        if(current.getVal() < val){
            insertHelp(val, current.getRight());
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
