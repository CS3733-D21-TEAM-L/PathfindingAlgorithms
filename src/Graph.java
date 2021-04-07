import java.util.LinkedList;

public class Graph {
    private LinkedList<Node> path;
    private float costOfPath;
    private float costOfHeuristic;

    //setter
    public void addNodeToPath(Node nodeToAdd) {
        this.path = new LinkedList<Node>();
        this.path.add(nodeToAdd);
    }


}
