import java.util.ArrayList;

public class Node {
    private ArrayList<Node> edgeTo; //Node that current node is connected to
    private String nodeID; //Node's ID
    private Node parent; //for backtracking
    public boolean hasParent;
    private String fullName; //Node's full name
    private String shortName; //Node's short name
    public boolean visited; //Boolean used to check if the node has been visited or not

    public Node(String nodeID) {
        this.nodeID = nodeID;
        this.edgeTo = new ArrayList<>();
        this.visited = false;
        this.hasParent=false;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
        this.hasParent = true;
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
