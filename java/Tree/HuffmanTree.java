package Tree;

/**
 * Created by STay on 17-5-6.
 */
public class HuffmanTree {

    Node root;

    private static class Node implements Comparable<Node> {
        private char data;
        private float freq;
        private Node left, right;

        Node(char data, float freq, Node left, Node right) {
            this.data = data;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public boolean isLeaf() {
            return this.right == null && this.left == null;
        }

        @Override
        public int compareTo(Node o) {
            if (this.freq > o.freq) return 1;
            else if (this.freq < o.freq) return -1;
            else return 0;
        }
    }

    private static class MinHeap<Item extends Comparable<Item>> {
        private Item[] mh;
        private int N = 0;

        @SuppressWarnings("unchecked")
        public MinHeap(int maxn) {
            mh = (Item[]) new Comparable[maxn + 1];
        }

        public void Insert(Item v) {
            mh[++N] = v;
            swim(N);
        }

        public Item Top() {
            return mh[1];
        }

        public void deleteMax() {
            exchange(1, N--);
            mh[N + 1] = null;
            sink(1);
        }

        private void sink(int k) {
            while (2 * k <= N) {
                int j = 2 * k;
                if (j < N && less(j, j + 1)) j++;
                if (!less(k, j)) break;
                exchange(k, j);
                k = j;
            }
        }

        private void swim(int k) {
            while (k > 1 && less(k / 2, k)) {
                exchange(k / 2, k);
                k = k / 2;
            }
        }

        private boolean less(int i, int j) {
            return mh[i].compareTo(mh[j]) > 0;
        }

        private void exchange(int i, int j) {
            Item temp = mh[i];
            mh[i] = mh[j];
            mh[j] = temp;
        }

        public int Size() {
            return this.N;
        }

        public boolean Empty() {
            return N == 0;
        }

        public static void main(String arg[]) {
            MinHeap<Integer> mh = new MinHeap<Integer>(20);
            for (int i : new int[]{1, 2, 5, 7, 3, 4}) {
                mh.Insert(i);
                System.out.println(mh.Size() + " -> " + mh.Top());
            }
            System.out.println("-------");
            while (!mh.Empty()) {
                System.out.println(mh.Top());
                mh.deleteMax();
            }
        }
    }

    public HuffmanTree(float[] w, int n) {
        MinHeap<Node> mh = new MinHeap<Node>(100);
        Node parent = null, first, second, work;
        for (int i = 0; i < n; i++) {
            work = new Node(' ', w[i], null, null);
            mh.Insert(work);
        }
        for (int i = 0; i < n - 1; i++) {
            first = mh.Top();
            mh.deleteMax();
            second = mh.Top();
            mh.deleteMax();
            parent = mergeTree(first, second);
            mh.Insert(parent);
        }
        root = parent;
    }

    private Node mergeTree(Node first, Node second) {
        return new Node(' ', first.freq + second.freq, first, second);
    }

    public static void main(String[] args) {
        HuffmanTree tree = new HuffmanTree(new float[]{1, 22, (float) 0.33, 4, 5}, 5);
        System.out.println(tree.root.freq);
    }
}
