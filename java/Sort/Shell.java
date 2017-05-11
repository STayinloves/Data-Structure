package Sort;

/**
 * Created by STay on 17-5-11.
 */
public class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Comparable a, Comparable b) {
        if (a.compareTo(b) > 0) return false;
        else return true;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 3, 2, -1, 4};
        sort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
