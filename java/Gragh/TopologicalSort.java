package Gragh;


import Stack.Stack;

/**
 * Created by STay on 17-5-11.
 */
public class TopologicalSort {
    public static void sort(EdgeWeightedDigragh g) {
        int[] num = new int[g.V()];
        EdgeWeightedDigragh temp = new EdgeWeightedDigragh(g.V());
        Stack<Integer> st = new Stack<Integer>();
        Stack<Integer> ans = new Stack<Integer>();
        for (int i = 1; i < g.V(); i++) {
            num[i] = 0;
            for (DirectedEdge e : g.adj(i)) {
                num[i]++;
                temp.addEdge(new DirectedEdge(e.to(), e.from(), 0));
            }
        }
        for (int i = 1; i < g.V(); i++) {
            if (num[i] == 0) {
                st.push(i);
            }
        }
        while (!st.empty()) {
            int top = st.top();
            st.pop();
            for (DirectedEdge e : temp.adj(top)) {
                if (--num[e.to()] == 0) {
                    st.push(e.to());
                }
            }
            ans.push(top);
        }
        System.out.print(ans.top());
        ans.pop();
        while (!ans.empty()) {
            System.out.print("->" + ans.top());
            ans.pop();
        }
    }

    public static void main(String[] args) {
        EdgeWeightedDigragh g = new EdgeWeightedDigragh(10);
        g.addEdge(new DirectedEdge(1, 3, 0));
        g.addEdge(new DirectedEdge(2, 3, 0));
        g.addEdge(new DirectedEdge(1, 4, 0));
        g.addEdge(new DirectedEdge(2, 5, 0));
        g.addEdge(new DirectedEdge(3, 6, 0));
        g.addEdge(new DirectedEdge(4, 6, 0));
        g.addEdge(new DirectedEdge(5, 6, 0));
        g.addEdge(new DirectedEdge(6, 7, 0));
        g.addEdge(new DirectedEdge(6, 8, 0));
        g.addEdge(new DirectedEdge(7, 8, 0));
        g.addEdge(new DirectedEdge(6, 9, 0));
        g.addEdge(new DirectedEdge(7, 9, 0));
        g.addEdge(new DirectedEdge(8, 9, 0));
        sort(g);
    }
}
