package Search;

/**
 * Created by STay on 17-5-11.
 */
public class HashTable<Key, Value> {
    private int m;
    private int n;
    private Key[] keys;
    private Value[] vals;

    public HashTable(int capacity) {
        m = capacity;
        keys = (Key[]) new Object[m];
        vals = (Value[]) new Object[m];
        n = 0;
    }

    private int hash(Key key) {
        return key.hashCode() % m;
    }

    public void put(Key key, Value value) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m)
            if (keys[i].equals(key)) {
                vals[i] = value;
                return;
            }
        keys[i] = key;
        vals[i] = value;

    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (this.get(key) == null) return;

        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }

        keys[i] = null;
        vals[i] = null;

        i = (i + 1) % m;
        while (keys[i] != null) {
            Key keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }

        n--;
    }

    public static void main(String[] args) {
        HashTable<Integer, Boolean> st = new HashTable<>(12);
        int[] a = new int[]{16, 74, 60, 43, 54, 90, 46, 31, 29, 88, 77};
        for (int anA : a) {
            st.put(anA, true);
        }
        System.out.println("Search 29 in the hash table find " + st.get(29));
        st.delete(29);
        System.out.println("Search 29 in the hash table find " + st.get(77));
        st.put(77, true);
        System.out.println("Search 29 in the hash table find " + st.get(77));
    }
}
