import java.util.ArrayList;

/**
 * <h1>Node</h1>
 * This class contains information about each node
 *
 */
public class Node {
    /**ArrayList of nodes connected to this node
     */
    private ArrayList<Node> edgeTo;
    /**The Node's ID
     */
    private String nodeID; //Node's ID
    /**The parent node. Useful for backtracking
     */
    private Node parent; //for backtracking
    /** Boolean for if the node has a parent. Useful for backtracking
     */
    public boolean hasParent;
    /** The Node's full name
     */
    private String fullName;
    /** The Node's shortName
     */
    private String shortName;
    /** Boolean showing if the node has been visited. Useful for Graph traversal
     */
    public boolean visited;
    /**
     * X coordinate value
     */
    private int x;
    /**
     * Y coordinate value
     */
    private int y;

    /**
     * Creates a node with the specified nodeID
     * @param nodeID nodeID for this node
     */
    public Node(String nodeID) {
        this.nodeID = nodeID;
        this.edgeTo = new ArrayList<>(); //Instantiates the ArrayList of nodes this node can reach
    }

    /**
     * Retrieves the Parent for this node
     * @return Parent node
     */
    public Node getParent() {
        return parent;
    }

    /**
     * Changes the parent node for this node and sets hasParent to true
     * @param parent the parent node
     */
    public void setParent(Node parent) {
        this.parent = parent;
        this.hasParent = true;
    }

    /**
     * adds an edge to this node
     * @param edgeTo the target node
     */
    public void addEdge(Node edgeTo) {
        this.edgeTo.add(edgeTo);
    }

    /**
     * gets the nodeID for this node
     * @return the nodeID
     */
    public String getNodeID() {
        return nodeID;
    }

    /**
     * Retrieves all the nodes connected to this node
     * @return An ArrayList of nodes connected to this node
     */
    public ArrayList<Node> getEdges() {
        return edgeTo;
    }

}
