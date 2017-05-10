package tree;

/**
 * Created by STay on 17-5-5.
 */

public class BinaryTree {
    private TreeNode root;

    private class TreeNode<Item> {
        Item val;
        public TreeNode left, right;

        public TreeNode(Item item) {
            val = item;
            left = right = null;
        }

        public void setRight(TreeNode<Item> node) {
            right = node;
        }

        public void setLeft(TreeNode<Item> node) {
            left = node;
        }

        public boolean isLeaf() {
            return this.right == null && this.left == null;
        }
        public int countLeafNode() {
            if (this.isLeaf()) return 1;
            int cnt = 0;
            if (this.right != null)
                cnt += this.right.countLeafNode();
            if (this.left != null)
                cnt += this.left.countLeafNode();
            return cnt;
        }

        public int countNode() {
            int cnt = 1;
            if (this.right != null)
                cnt += this.right.countNode();
            if (this.left != null)
                cnt += this.left.countNode();
            return cnt;
        }

    }

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(String table) {
        root = buildTreeByTable(table);
    }

    public TreeNode buildTreeByTable(String table) {
        if (table.length() == 0) return null;
        if (table.charAt(0) == '(') {
            table = table.substring(1, table.length() - 1);
        }
        int cnt = 0, l = 0, r = 0;
        String value = null;
        for (int i = 0; i < table.length(); i++) {
            if (table.charAt(i) == '(') cnt++;
            else if (table.charAt(i) == ')') cnt--;
            else if (table.charAt(i) == ',' && cnt == 0) {
                l = i + 1;
                StringBuilder s = new StringBuilder();
                for (int j = i + 1; j < table.length(); j++) {
                    if (table.charAt(j) == ',') break;
                    r = j;
                    s.append(table.charAt(j));
                }
                value = s.toString();
                break;
            }
        }
        System.out.println(table + " -> " + (value == null ? table : value));
        if (value == null) return new TreeNode(table);
        TreeNode node = new TreeNode(value);
        String rowTable = table;
        node.setLeft(buildTreeByTable(table.substring(0, l - 1)));
        table = rowTable;
        node.setRight(buildTreeByTable(table.substring(r + 2, table.length())));
        return node;
    }

    public void printTree() {
        System.out.println("The tree print in inorder is:");
        printTree(root);
        System.out.println();
    }

    public void printTree(TreeNode node) {
        if (node == null) return;
        printTree(node.left);
        System.out.print(node.val + "  ");
        printTree(node.right);
    }

    public void printPostorder() {
        System.out.println("The tree print in postorder is:");
        printPostorder(root);
        System.out.println();
    }

    public void printPostorder(TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            System.out.print(node.val);
            return;
        }
        System.out.print("(");
        printPostorder(node.left);
        System.out.print(",");
        printPostorder(node.right);
        System.out.print(",");
        System.out.print(node.val + ")");
    }

    public void printPreorder() {
        System.out.println("The tree print in preorder is:");
        printPreorder(root);
        System.out.println();
    }

    public void printPreorder(TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            System.out.print(node.val);
            return;
        }
        System.out.print("(" + node.val + ",");
        printPreorder(node.left);
        System.out.print(",");
        printPreorder(node.right);
        System.out.print(")");
    }

    public void testPrint() {
        this.printTree();
        this.printPostorder();
        this.printPreorder();
    }

    public TreeNode findNodeByValue(String s) {
        return findNodeByValue(root, s);
    }

    private TreeNode findNodeByValue(TreeNode root, String s) {
        if (root == null) return null;
        else if (s.compareTo((String) root.val) == 0) return root;
        TreeNode left = findNodeByValue(root.left, s),
                right = findNodeByValue(root.right, s);
        if (left == null) return right;
        else return left;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree("((e,b,(i,f,j)),a,(g,c,h))");
        binaryTree.testPrint();
        System.out.println("The node a has " + binaryTree.findNodeByValue("a").countLeafNode() + " left nodes.");
        System.out.println("The tree has " + binaryTree.root.countNode() + " nodes.");
        binaryTree =  new BinaryTree("((e,b,(i2,f1,)),a,(,cc,hh))");
        binaryTree.testPrint();
    }
}
