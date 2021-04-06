import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static void main(String[] args) {
        loadNodesandEdges();
    }

    public static void loadNodesandEdges() {
        List<List<String>> nodesData = Parser.readFile(System.getProperty("user.dir") + "/MapLnodes.csv");
        List<List<String>> edgesData = Parser.readFile(System.getProperty("user.dir") + "/MapLedges.csv");
        ArrayList<Node> nodesList = new ArrayList<>();
        for (List<String> edgesDatum : edgesData) {
            if ((findNode(nodesList, edgesDatum.get(1)) == -1) || (findNode(nodesList, edgesDatum.get(2)) == -1)) {
                if ((findNode(nodesList, edgesDatum.get(1)) == -1)) {
                    nodesList.add(new Node(edgesDatum.get(1)));
                    if ((findNode(nodesList, edgesDatum.get(2)) == -1)) {
                        nodesList.add(new Node(edgesDatum.get(2)));
                    }
                    nodesList.get(findNode(nodesList, edgesDatum.get(1))).addEdge(nodesList.get(findNode(nodesList, edgesDatum.get(2))));
                    nodesList.get(findNode(nodesList, edgesDatum.get(2))).addEdge(nodesList.get(findNode(nodesList, edgesDatum.get(1))));
                }

                if ((findNode(nodesList, edgesDatum.get(2)) == -1)) {
                    nodesList.add(new Node(edgesDatum.get(2)));
                    if ((findNode(nodesList, edgesDatum.get(1)) == -1)) {
                        nodesList.add(new Node(edgesDatum.get(1)));
                    }
                    nodesList.get(findNode(nodesList, edgesDatum.get(1))).addEdge(nodesList.get(findNode(nodesList, edgesDatum.get(2))));
                    nodesList.get(findNode(nodesList, edgesDatum.get(2))).addEdge(nodesList.get(findNode(nodesList, edgesDatum.get(1))));
                }

            }
        }
    }

    public static int findNode(ArrayList<Node> nodes, String nodeID) {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getNodeID().equals(nodeID))
                return i;
        }
        return -1;
    }


}
