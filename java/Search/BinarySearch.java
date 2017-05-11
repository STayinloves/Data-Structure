package Search;

/**
 * Created by STay on 17-5-11.
 */
public class BinarySearch {
    public static int search(int value, int[] a) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int i = (left + right) >> 1;
            System.out.print("Find " + a[i] + " at position " + i);
            if (value == a[i]) {
                System.out.println(" equal.");
                return i;
            } else {
                System.out.println(" not equal.");
                if (value < a[i]) {
                    right = i;
                } else {
                    left = i + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        search(1, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    }
}
