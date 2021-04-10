import java.util.*;
import java.util.Hashtable;

/**
 * <h1>Node</h1>
 * This class contains information about each node
 *
 */
public class Node {
    /**
     * Hashtable of nodes connected to this node
     */
    private Hashtable<String, Integer> edges;
    /**
     * The Node's ID
     */
    private String nodeID; //Node's ID
    /**
     * The parent node. Useful for backtracking
     */
    private Node parent; //for backtracking
    /**
     * Boolean for if the node has a parent. Useful for backtracking
     */
    public boolean hasParent;
    /**
     * The Node's full name
     */
    private String fullName;
    /**
     * The Node's short name
     */
    private String shortName;
    /**
     * THe floor the node is located on
     */
    private String floor;
    /**
     * The building the node is located in
     */
    private String building;
    /**
     * The nodeType for the node
     */
    private String nodeType;
    /**
     * Boolean showing if the node has been visited. Useful for Graph traversal
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
     * Distance to node
     */
    private int heuristic;

    /**
     * Minimal constructor that loads the x, and y coordinates, as well as the edges connected to the constructor
     *
     * @param nodeID nodeID for this node
     * @param x      x value of the node's location
     * @param y      y value of the node's location
     * @param edges  Hashtable representing node and its associated cost
     */
    public Node(String nodeID, int x, int y, Hashtable<String, Integer> edges) {
        //coordinates
        this.x = x;
        this.y = y;

        //edges
        this.edges = edges;

        //nodeID
        this.nodeID = nodeID;
    }


    /**Minimal constructor that loads the x, and y coordinates without loading the edges
     * @param nodeID nodeID for this node
     * @param x x value of the node's location
     * @param y y value of the node's location
     */
    public Node(String nodeID, int x, int y) {
        this.nodeID = nodeID;
        this.x = x;
        this.y = y;
    }

    /**
     * Overloaded constructor that loads all of the info from the original constructor
     * as well as other extraneous info related to a node
     * @param edges     Hashtable representing node and its associated cost
     * @param nodeID    nodeID for this node
     * @param fullName the full name of the node
     * @param shortName the short name of the node
     * @param floor the floor the node is located on
     * @param building the building the node is located in
     * @param nodeType the node's type
     * @param x         x value of the node's location
     * @param y         y value of the node's location
     */
    public Node(Hashtable<String, Integer> edges, String nodeID, String fullName, String shortName, String floor, String building, String nodeType, int x, int y) {
        //coordinates
        this.x = x;
        this.y = y;

        //edges
        this.edges = edges;

        //nodeInfo
        this.nodeID = nodeID;
        this.fullName = fullName;
        this.shortName = shortName;
        this.floor = floor;
        this.building = building;
        this.nodeType = nodeType;

        this.heuristic = 0;
        this.visitedFlag = false;
    }

    /**
     * @return hashtable that contains the x and y coordinates for the given node
     */
    public Hashtable<String, Integer> getCoords() {
        Hashtable<String, Integer> xyCoord = new Hashtable<String, Integer>();
        xyCoord.put("x", this.x);
        xyCoord.put("y", this.y);

        return xyCoord;
    }

    /** <b>Note:</b> You have to call Node.getNodeInfo().get() with the info you're trying to receive to retrieve it
     * from the hashtable
     * @return hashtable that contains the nodeID, floor, building, nodeType, fullName and shortName for the given node
     */
    public Hashtable<String, String> getNodeInfo() {
        Hashtable<String, String> nodeInfo = new Hashtable<String, String>();
        nodeInfo.put("nodeID", this.nodeID);
        nodeInfo.put("floor", this.floor);
        nodeInfo.put("building", this.building);
        nodeInfo.put("nodeType", this.nodeType);
        nodeInfo.put("fullName", this.fullName);
        nodeInfo.put("shortName", this.shortName);

        return nodeInfo;
    }

    public void setNodeID(String nodeID){
        this.nodeID = nodeID;
    }

    /**
     * Retrieves the heuristic value
     *
     * @return Distance to node
     */
    public int getHeuristic() {
        return heuristic;
    }

    /**
     * Sets the heuristic value
     */
    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }

    /**
     * Retrieves the Parent for this node
     *
     * @return Parent node
     */
    public Node getParent() {
        return parent;
    }

    /**
     * Changes the parent node for this node and sets hasParent to true
     *
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
    public Hashtable<String, Integer> addEdges(Node aNode, int cost) {
        String aNodeID = aNode.nodeID;
        String currentNodeID = this.nodeID;
        this.edges.put(aNodeID, cost);
        aNode.edges.put(currentNodeID, cost);

        return this.edges;
    }

    /**
     * Retrieves all the nodes connected to this node
     *
     * @return An ArrayList of nodes connected to this node
     */
    public Hashtable<String, Integer> getEdges() {
        return this.edges;
    }

    /**
     * gets the nodeID for this node
     *
     * @return the nodeID
     */
    public String getNodeID() {
        return nodeID;
    }
}
