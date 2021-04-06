public class Node {
    private Node edgeTo; //Node that current node is connected to
    private String nodeID; //Node's ID
    private String fullName; //Node's full name
    private String shortName; //Node's short name

    public Node(String nodeID) {
        this.nodeID = nodeID;
    }

    public void addEdge(Node edgeTo) {
        this.edgeTo = edgeTo;
    }

    public String getNodeID() {
        return nodeID;
    }

    @Override
    public String toString() {
        return nodeID;
    }
}
