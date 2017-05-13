package Stack;

import java.util.Scanner;

/**
 * Created by STay on 5/12/17.
 */
public class NotationConvert {
    public static void main(String[] args) {
        System.out.println("请输入要转换的十进制数字及要转换的进制:");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int base = in.nextInt();
        Stack<Integer> st = new Stack<Integer>();
        System.out.println(number + " 转化为 " + base + " 进制为:");
        while (number > 0) {
            st.push(number % base);
            number /= base;
        }
        while (!st.empty()) {
            System.out.print(st.top());
            st.pop();
        }
    }
}
