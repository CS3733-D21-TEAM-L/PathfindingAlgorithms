import java.util.ArrayList;
import java.util.*;

public class Path {
    private LinkedList<Node> path;
    private float costOfPath;
    private float costOfHeuristic;

    //setter
    public void add(){

    }

    public void getNode(){

    }
}

//Class Node: contains all the information that a Node contains
//FIELDS:
//    xCoord (type: int): the x coordinate of the node
//    yCoord (type: int): the y coordinate of the node
//    nodeID (type: string): ID associated with the node
//    floor (type: string): number associated with the floor level
//    building (type: string): the name of the building
//    nodeType (type: string): describes the node type
//    longName (type: string): the long name associated with the node e.g. "Anesthesia"
//    shortName (type: string): the shorter name associated with the node e.g. "ConfC001L1"
//    heuristic (type: int): The (under)estimated distance from this state to the goal state of the graph.
//    edges (type: dictionary): A dictionary relating the names of the adjacent nodes to the respective path cost from itself to this node.
//    visitedFlag (type: boolean): flag that determines if you have visited this node before
public class Node {
    private int xCoord;
    private int yCoord;
    private String nodeID;
    private String floor;
    private String building;
    private String nodeType;
    private String longName;
    private String shortName;
    public int heuristic;
    public Hashtable<String, Integer> edges;
    public boolean visitedFlag;

    public Node(int heuristic, Hashtable<String, Integer> edges, boolean visitedFlag) {
        this.heuristic = heuristic;
        this.edges = edges;
        this.visitedFlag = visitedFlag;
    }

    //Setters and getters for coordinates
    public void setCoords(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public Hashtable<String, Integer> getCoords() {
        Hashtable<String, Integer> xyCoord = new Hashtable<String, Integer>();
        xyCoord.put("x", this.xCoord);
        xyCoord.put("y", this.yCoord);

        return xyCoord;
    }

    //Setters and getters for peripheral information for Node
    public Node setNodeInfo(String NodeID, String floor, String building, String nodeType, String longName, String shortName) {
        this.nodeID = NodeID;
        this.floor = floor;
        this.building = building;
        this.nodeType = nodeType;
        this.longName = longName;
        this.shortName = shortName;
    }

    public Hashtable<String, String> getNodeInfo() {
        Hashtable<String, String> nodeInfo = new Hashtable<String, String>();
        nodeInfo.put("NodeID", this.nodeID);
        nodeInfo.put("floor", this.floor);
        nodeInfo.put("building", this.building);
        nodeInfo.put("nodeType", this.nodeType);
        nodeInfo.put("longName", this.longName);
        nodeInfo.put("shortName", this.shortName);

        return nodeInfo;
    }
}
