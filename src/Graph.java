import java.util.ArrayList;

/**
 * <h1>Graph</h1>
 * Keeps track of vertices, edges between vertices, and our adjacency list
 * @author Emmanuel Ola
 */
public class Graph {
    private final int V;
    private int E;
    private ArrayList<Integer>[] adj;

    /**
     * Initializes the graph
     * @param V Size of our graph
     */
    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj =  new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    /**Returns the number of vertices in the graph
     * @return the number of vertices in the graph
     */
    public int V() {return V;}

    /**
     * @return the number of edges in our graph
     */
    public int E() {return E;}

    /**
     * Adds an edge between two nodes
     * @param v source node
     * @param w target node
     */
    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    /**
     * Returns an adjacency list for a specified vertex
     * @param v the vertex whose adjacency list you want
     * @return the adjacency list for the specified vertex
     */
    public Iterable<Integer> adj (int v) {return adj[v];}
}
