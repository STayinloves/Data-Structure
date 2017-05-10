package LinkedList;

import java.util.Iterator;

import static java.util.Objects.compare;

class Node<Item> {
    Item item;
    Node<Item> next;

    Node(Item i, Node<Item> o) {
        this.item = i;
        this.next = o;
    }
}

public class List<Item extends Comparable<Item>> implements Iterable<Item> {
    private int N = 0;
    private Node<Item> beginNode;
    private Node<Item> endNode;

    List(Item i) {
        Node<Item> newNode = new Node<>(i, null);
        beginNode = endNode = newNode;
        N++;
    }

    public int size() {
        return N;
    }

    public boolean empty() {
        return N == 0;
    }

    public Item getNthElement(int n) {
        Node<Item> temp = beginNode;
        for (int i = 0; i < n - 1; i++) {
            temp = temp.next;
        }
        return temp.item;
    }

    public int getPositionByValue(Item v) {
        int pos = 1;
        for (Item i : this) {
            if (i.compareTo(v) == 0) return pos;
            pos++;
        }
        return -1;
    }

    public void push_back(Item i) {
        endNode.next = new Node<Item>(i, null);
        endNode = endNode.next;
        N++;
    }

    public void push_front(Item i) {
        beginNode = new Node<Item>(i, beginNode);
        N++;
    }

    public void pop_front() {
        beginNode = beginNode.next;
        N--;
    }

    public boolean insert(int pos, Item value, int repeat) {
        if (pos > N + 1) return false;
        if (pos == N + 1) {
            for (int i = 0; i < repeat; i++) this.push_back(value);
        }
        else if (pos == 1) {
            Node<Item> tempNext = beginNode;
            for (int i = 0; i < repeat; i++) this.push_front(value);
        } else {
            Node<Item> temp = beginNode;
            for (int i = 0; i < pos - 2; i++) {
                temp = temp.next;
            }
            Node<Item> tempNext = temp.next;
            for (int i = 0; i < repeat; i++) {
                temp.next = new Node<Item>(value, null);
                temp = temp.next;
            }
            temp.next = tempNext;
            N += repeat;
        }
        return true;
    }

    public boolean deleteIthElement(int pos) {
        if (pos > N) return false;
        if (pos == 1) {
            this.pop_front();
            return true;
        } else if (pos == N) {
            Node<Item> temp = beginNode;
            for (int i = 2; i < N; i++) {
                temp = temp.next;
            }
            temp.next = null;
            endNode = temp;
            N--;
            return true;
        }
        Node<Item> temp = beginNode;
        Node<Item> pre = beginNode;
        for (int i = 1; i < pos; i++) {
            pre = temp;
            temp = temp.next;
        }
        pre.next = temp.next;
        N--;
        return true;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node<Item> i = beginNode;

        @Override
        public boolean hasNext() {
            return i != null;
        }

        @Override
        public Item next() {
            Item temp = i.item;
            i = i.next;
            return temp;
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("The list has follow " + this.size() + " element(s):");
        for (Item i : this) {
            ret.append("\n").append(i);
        }
        ret.append('\n');
        return ret.toString();
    }

    public static void main(String[] args) {
        List<Character> ls = new List<>('a');
        ls.push_back('b');
        ls.push_back('c');
        ls.push_back('d');
        ls.push_back('e');
        System.out.print(ls);

        System.out.println("The list's length is " + ls.size());
        System.out.println(ls.empty() ? "The list is empty" : "The list isn't empty");
        System.out.println(ls.getNthElement(3));
        System.out.println("The element 'd' is in the position " + ls.getPositionByValue('d'));

        ls.insert(2, 'f', 2);
        System.out.print(ls);

        ls.deleteIthElement(1);
        System.out.print(ls);
    }
}
