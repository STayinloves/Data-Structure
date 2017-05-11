package Stack;

public class Queue {
    int maxsize = 100;
    private int front, rear, size;
    private Item[] items;

    public Queue() {
        items = new Item[maxsize];
        front = rear = size = 0;
    }


    public void push(Item i) throws Exception {
        if (size == maxsize) throw new Exception("maxsize exceed!");
        items[rear++] = i;
        if (rear == maxsize) rear = 0;
        size++;
    }

    public void pop() throws Exception {
        if (size == 0) throw new Exception("empty queue!");
        front++;
        if (front == maxsize) front = 0;
        size--;
    }

    public Item front() {
        return items[front];
    }

    public Item back() {
        return items[rear - 1];
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public void clear() {
        size = front = rear = 0;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = front; i != rear; i++) {
            s.append("\n").append(items[i]);
        }
        return s.toString();
    }

    public static void main(String[] args) throws Exception {
        Queue q = new Queue();
        for (String i : new String[]{"a", "b", "c", "d", "d"})
            q.push(new Item(i));
        System.out.println(q);
        q.clear();
        System.out.println(q);
    }
}
