package Stack;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by STay on 17-5-5.
 */
public class Stack<Item> implements Iterable {

    private ArrayList<Item> arrayList;

    public Stack() {
        arrayList = new ArrayList<>(16);
    }

    public void push(Item item) {
        arrayList.add(item);
    }

    public void pop() {
        arrayList.remove(this.size() - 1);
    }

    public int size() {
        if (arrayList.isEmpty()) return 0;
        else
            return arrayList.size();
    }

    public boolean empty() {
        return arrayList.isEmpty();
    }

    public void clear() {
        arrayList.clear();
    }

    private Item get(int pos) {
        return arrayList.get(pos);
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(arrayList);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private int size;
        ArrayList<Item> arrayList;

        public ListIterator(ArrayList<Item> arrayList) {
            this.size = arrayList.size() - 1;
            this.arrayList = arrayList;
        }

        @Override
        public boolean hasNext() {
            return size != -1;
        }

        @Override
        public Item next() {
            return this.arrayList.get(size--);
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("There is ").append(this.size()).append(" elements in stack:\n");
        for (Item i : arrayList) {
            s.append(i);
            s.append(' ');
        }
        s.append("\n");
        return s.toString();
    }

    public static void main(String[] args) {
        Stack<Character> st = new Stack<Character>();
        System.out.println(st.empty() ? "Stack is empty." : "Stack isn't empty.");
        for (char i : new char[]{'a', 'b', 'c', 'd', 'e'}) {
            st.push(i);
        }
        st.pop();
        System.out.print(st);
        for (Object i : st) {
            System.out.print(i + " ");
        }
        System.out.println();
        st.clear();
        System.out.print(st);
    }
}
