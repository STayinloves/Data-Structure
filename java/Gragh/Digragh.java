package Gragh;

import java.util.*;
import java.lang.reflect.*;
class DirectedEdge
{
    private final int v;
    private final int w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public int from() {
        return v;
    }
    public int to() {
        return w;
    }
    public double weight() {
        return weight;
    }
    public String toString() {
        return String.format("%d->%d %.2f", v, w, weight);
    }
    public static void main(String[] args) {
        DirectedEdge e = new DirectedEdge(1, 2, 3);
        System.out.println(e);
    }
}

class EdgeWeightedDigragh
{
    private final int V;
    private int E;
    private Vector<DirectedEdge>[] adj;

    @SuppressWarnings("unchecked")
    public EdgeWeightedDigragh(int V) {
        this.V = V;
        this.E = 0;
        adj = (Vector<DirectedEdge>[]) Array.newInstance(Vector.class, V);
        for (int v = 0; v < V; v++) {
            adj[v] = new Vector<DirectedEdge>();
        }
    }
    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }
    public int V() {
        return this.V;
    }
    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < V; i++) {
            for (DirectedEdge e : adj[i]) {
                s = s.concat(e.toString() + "\n");
            }
        }
        return s;
    }
    public static void main(String[] args) {
        EdgeWeightedDigragh d = new EdgeWeightedDigragh(1);
        DirectedEdge e = new DirectedEdge(0, 2, 3);
        d.addEdge(e);
        System.out.println(d);
    }
}

class Dijkstra
{
    private Double[] distTo;
    private Boolean[] vis;

    public double distTo(int w) {
        return distTo[w];
    }
    public Dijkstra(EdgeWeightedDigragh G, int v) {
        double min, BGT = Double.MAX_VALUE;
        int t = v;
        vis = (Boolean[]) Array.newInstance(Boolean.class, G.V());
        distTo = (Double[]) Array.newInstance(Double.class, G.V());
        for (int i = 0; i < G.V(); i++) {
            vis[i] = false;
            distTo[i] = BGT;
        }
        for (DirectedEdge i : G.adj(v)) {
            distTo[i.to()] = i.weight();
        }
        vis[v] = true;
        distTo[v] = (double)0;
        for (;;) {
            min = BGT;
            for (DirectedEdge i : G.adj(v)) {
                if (!vis[i.to()] && min > distTo[i.to()]) {
                    min = distTo[i.to()];
                    t = i.to();
                }
            }
            if (min == BGT) break;
            vis[t] = true;
            for (DirectedEdge i : G.adj(t)) {
                if (!vis[i.to()] && distTo[t] + i.weight() < distTo[i.to()])
                    distTo[i.to()] = distTo[t] + i.weight();
            }
        }
    } 
    public static void main(String args[]) {
        EdgeWeightedDigragh g = new EdgeWeightedDigragh(3);
        g.addEdge(new DirectedEdge(0, 1, 1));
        g.addEdge(new DirectedEdge(0, 2, 4));
        g.addEdge(new DirectedEdge(1, 2, 2));
        Dijkstra d = new Dijkstra(g, 0);
        System.out.println(d.distTo(2));
    }
}