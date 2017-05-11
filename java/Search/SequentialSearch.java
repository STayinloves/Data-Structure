package Search;

/**
 * Created by STay on 17-5-11.
 */
public class SequentialSearch {
    public static int search(int value, int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print("Find " + a[i] + " at position " + i);
            if (value == a[i]) {
                System.out.println(" equal.");
                return i;
            } else {
                System.out.println(" not equal.");
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        search(5, new int[]{3, 6, 2, 10, 1, 8, 5, 7, 4, 9});
    }
}
