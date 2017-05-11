package Sort;

/**
 * Created by STay on 17-5-10.
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
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
