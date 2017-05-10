package Stack;

import java.util.Scanner;

/**
 * Created by STay on 17-5-5.
 */
public class Hospital {
    private Queue queue = new Queue();

    public void putInQueue(Item id) throws Exception {
        queue.push(id);
    }

    public Item getFront() throws Exception {
        Item temp = queue.front();
        queue.pop();
        return temp;
    }

    @Override
    public String toString() {
        return "There is " + queue.size() + " patient(s) in queue" + queue.toString();
    }

    public static void main(String[] args) throws Exception {
        Hospital hs = new Hospital();
        while (true) {
            int temp = printINFO();
            if (temp == -1) {
                System.out.println("input error, please input number between 1 and 5!");
                continue;
            }
            switch (temp) {
                case 1: {
                    System.out.println("please enter the ID number of the patient");
                    Scanner in = new Scanner(System.in);
                    String s = in.next();
                    hs.putInQueue(new Item(s));
                    System.out.println("patient " + s + " is in queue");
                    break;
                }
                case 2: {
                    Item s = hs.getFront();
                    System.out.println("patient " + s + " is in treatment.");
                    break;
                }
                case 3: {
                    System.out.println(hs);
                    break;
                }
                case 4: {
                    System.out.println(hs);
                    System.out.println("System exits normally");
                    return;
                }
                case 5: {
                    System.out.println("System exits normally");
                    return;
                }
            }
        }
    }

    private static int printINFO() {
        System.out.println("Please enter one of those selections");
        System.out.println("1. Get in queue, please enter the patient's ID number");
        System.out.println("2. Send patient to see the doctor");
        System.out.println("3. List the IDs of all patients in queue");
        System.out.println("4. Stop queueing, List the IDs of all patients in queue and exit");
        System.out.println("5. exit");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        if (input < 1 || input > 5) return -1;
        return input;
    }
}
