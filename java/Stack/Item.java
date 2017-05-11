package Stack;

/**
 * Created by STay on 17-5-5.
 */

public class Item {
    public String c;

    public Item(String i) {
        c = i;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(c);
        return s.toString();
    }
}
