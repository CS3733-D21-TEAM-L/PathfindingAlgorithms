import java.util.ArrayList;

/**
 * <h1>Node</h1>
 * This class contains information about each node
 *
 */
public class Node {
    private ArrayList<Node> edgeTo; //Node that the current node is connected to
    private String nodeID; //Node's ID
    private Node parent; //for backtracking
    /** True if the node has a parent, and false if it doesn't. Useful for backtracking
     */
    public boolean hasParent;
    private String fullName; //Node's full name
    private String shortName; //Node's short name
    /** True if the node has been visited, helpful for graph traversal
     */
    public boolean visited; //Boolean used to check if the node has been visited or not

    /**
     * Creates a node with the specified nodeID
     * @param nodeID nodeID for this node
     */
    public Node(String nodeID) {
        this.nodeID = nodeID;
        this.edgeTo = new ArrayList<>(); //Instantiates the ArrayList of nodes this node can reach
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

    public ArrayList<Node> getEdges() {
        return edgeTo;
    }

    @Override
    public String toString() {
        return nodeID;
    }
}
