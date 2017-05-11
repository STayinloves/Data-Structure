package Tree;

/**
 * Created by STay on 17-5-11.
 */
public class ThreadTree<Item> {
    private TreeNode<Item> pre = null;
    public TreeNode<Item> root;
    public TreeNode<Item> first;

    public ThreadTree(String s) {
        root = buildTreeByTable(s);
        buildThread();
        TreeNode temp = root;
        while (temp.pred != null) {
            temp = temp.pred;
        }
        first = temp;
        System.out.println("Thread tree initialized successfully.");

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

    private void buildThread() {
        inorderDFS(root);
    }

    private void inorderDFS(TreeNode root) {
        if (root.left != null)
            inorderDFS(root.left);
        root.pred = pre;
        if (pre != null) pre.succ = root;
        pre = root;
        if (root.right != null)
            inorderDFS(root.right);
    }

    public TreeNode<Item> findElementByValue(Item val) {
        TreeNode<Item> temp = new TreeNode<Item>(first);
        while (temp != null) {
            if (temp.val.equals(val)) return temp;
            temp = temp.succ;
        }
        return null;
    }

    private static class TreeNode<Item> {
        public TreeNode pred, succ;
        public Item val;
        public TreeNode left, right;

        public TreeNode(Item item) {
            val = item;
            left = right = null;
            pred = null;
            succ = null;
        }

        public TreeNode(TreeNode<Item> node) {
            val = node.val;
            left = node.left;
            right = node.right;
            pred = node.pred;
            succ = node.succ;
        }

        public void setRight(TreeNode<Item> node) {
            right = node;
        }

        public void setLeft(TreeNode<Item> node) {
            left = node;
        }
    }

    public static void main(String[] args) {
        ThreadTree threadTree = new ThreadTree<String>("((C,B,E),A,((Y,F,),D,G))");
        TreeNode<String> temp = new TreeNode<String>(threadTree.first);
        while (temp != null) {
            System.out.print(temp.val);
            temp = temp.succ;
        }
        System.out.println();
        temp = threadTree.findElementByValue("F");
        System.out.println("F's direct precursor is " + temp.pred.val + ", ans it's succeed is " + temp.succ.val + ".");
    }
}
