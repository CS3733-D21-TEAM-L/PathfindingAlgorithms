import java.util.ArrayList;

public class Node {
    private ArrayList<Node> edgeTo; //Node that current node is connected to
    private String nodeID; //Node's ID
    private String fullName; //Node's full name
    private String shortName; //Node's short name

    public Node(String nodeID) {
        this.nodeID = nodeID;
        this.edgeTo = new ArrayList<>();
    }

    public void addEdge(Node edgeTo) {
        this.edgeTo.add(edgeTo);
    }

    public String getNodeID() {
        return nodeID;
    }

    public ArrayList<Node> getEdgeTo() {
        return edgeTo;
    }

    @Override
    public String toString() {
        return nodeID;
    }
}
