
// video 86 - 87

// 88 is Stack so just skip

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {


    private TreeNode root;


    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data; //generic type


        public TreeNode(int data){
            this.data=data;
        }

    }



    public void createBinrayTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
       TreeNode fifth = new TreeNode(5);


        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right =fifth;


    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinrayTree();
     //   bt.preOrder(bt.root);  // printing the elements in bt BinaryTree

     //   bt.preOrderIt();

  //      bt.inOrderRec(bt.root);
      //  bt.levelOrder();
        System.out.println(bt.findMax());
    }




    public int findMax() { //no parameter here
       return findMax(root);
    }


    public int findMax(TreeNode root) { //Recursive method
        if(root == null){  //base case
            return Integer.MIN_VALUE;
        }

        int result = root.data;
        int right = findMax(root.right);
        int left = findMax(root.left);
        if(left > result)
            result = left;
        if(right> result)
            result = right;

        return result;



    }

    /*

    ################################## B I N A R Y - S E A R C H - T R E E #####################################
    public void insert(int value){
        root = insert(root, value);
    }

    public TreeNode insert(TreeNode root, int value){
        if(root == null){
            root = new TreeNode(value);
            return root;
        }
        if(value < root.data) {
            root.left = insert(root.left, value);
        }
        else {
                root.right = insert(root.right, value);
            }
            return root;
        }

        public TreeNode search(int key){
        return search(root, key) }

        public TreeNode search(TreeNode root, int key){
        if(root==null || root.data ==key){
        return root; //will return null if value is not found
       }
       if (key < root.data) {
       return search(root.left, key) }
       else {
       return search(root.right, key) }
       }

*/




    public void preOrderRec(TreeNode root){     // Recursive method
        //print all nodes starting from root to the left then left then right..etc

        if(root == null){
            return;
        }

        System.out.print(root.data+ " ");
        preOrderRec(root.left);
        preOrderRec(root.right);
    }
    public  void preOrderIt() {  // Iterative method

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) { // we are printing all nodes inside this loop
            TreeNode temp = stack.pop();  //temp is reciving the value in root node
            System.out.println(temp.data); //printing the value of temp that is the root
            if (temp.right != null) {
                stack.push(temp.right);
            }

            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    public void inOrderRec(TreeNode root){ //printing elements from further left to top then right

        if (root==null){
            return; }

        inOrderRec(root.left);
        System.out.println(root.data+ " ");
        inOrderRec(root.right);

    }

    public void inOrderIt(TreeNode root) {  //iterative inOrder
     //print elments starting from far left to its top then right of the top then out to the topper node ..osv
        if (root == null) {
            return;
        }


        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + "");
                temp = temp.right;  //visit the left subtree completely then the right subtree completely if we reach null
                // we return to the nearest root and print it if we reched the null value in right part
                //we print the further left to the left then the further right to the right then the top
            }
        }
    }

    public void postOrderRec(TreeNode root){  //Recursive method

        //visit the left subtree completely then the right subtree completely if we reach null
        // we return to the nearest root and print it if we reched the null value in right part
        //we print the further left to the left then the further right to the right then the top

        if(root == null){
            return;
        }

        postOrderRec(root.left);
        postOrderRec(root.right);
        System.out.print(root.data + "");

    }

    public void postOrderIt(TreeNode root) {  //Recursive method



        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();

        while(current != null || !stack.isEmpty()){
            if(current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if(temp == null) {
                    temp = stack.pop();
                    System.out.println(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.println(temp.data + " ");
                    }
                }
                    else {
                        current = temp;
                    }
                }
            }
        }

        public void levelOrder(){
        //prints root parents from lrft to right the nodes in left then in right side
        if(root== null){
            return; }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll(); //poping the root node so that temp is getting its value
            System.out.print(temp.data + " ");
            if(temp.left != null) {
                queue.offer(temp.left);
            }
            if(temp.right != null) {
                queue.offer(temp.right);
            }
        }
        }

    }





