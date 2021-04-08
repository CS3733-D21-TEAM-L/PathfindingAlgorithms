import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public class Graph {
    private Hashtable<String, Node> nodesInGraph;
    public ArrayList<Node> path;
    public float costOfPath;

    public Graph(ArrayList<Node> path){
        this.costOfPath = 0;
        this.path = path;
    }

    public void addStatesAndEdges(String nodeID_A, String nodeID_B, int cost){
        boolean keyFlagA = nodesInGraph.containsKey(nodeID_A);
        boolean keyFlagB = nodesInGraph.containsKey(nodeID_B);

        if (keyFlagA){
            Node newNode = new Node(nodeID_A, 'N');
            String newNodeID_A = newNode.getNodeInfo().get(nodeID_A);
            this.nodesInGraph.put(newNodeID_A, newNode);
        }

        if (keyFlagB){
            Node newNode = new Node(nodeID_B, 'N');
            String newNodeID_B = newNode.getNodeInfo().get(nodeID_B);
            this.nodesInGraph.put(newNodeID_B, newNode);
        }

        this.nodesInGraph.get(nodeID_A).addEdges(this.nodesInGraph.get(nodeID_B), cost);
    }

    public void setNodeHeuristic(String nodeID, int heuristic){
        Node theNode = this.nodesInGraph.get("nodeID");
        theNode.setHeuristic(heuristic);
    }

    public Node getNode(String nodeID){
        return this.nodesInGraph.get("nodeID");
    }

}
