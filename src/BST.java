public class BST {
    private TreeNode root;


    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data; //generic type


        public TreeNode(int data){
            this.data=data;
        }

    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
        bst.insert(6);

        bst.inOrder();

        if(null != bst.search(3)){
            System.out.println("Key found!!");
        } else  {
            System.out.println("Key not found!!");
        }

    }

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

    public void inOrder(){
       inOrder(root);
    }

    public void inOrder(TreeNode root){  //prints the nodes
        if(root == null){
            return;
        }


        inOrder(root.left);
        System.out.print(root.data+ " ");
        inOrder(root.right);

        System.out.println("");

    }

    public TreeNode search(int key) {
        return search(root, key);
    }

    public TreeNode search(TreeNode root, int key){ //recursive method
        if(root == null || root.data == key){ //base case
            return root;
        }

        if(key < root.data){
            return search(root.left, key);

            } else {
                return search(root.right, key);
            }
        }
    }


