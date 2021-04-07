import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<List<String>> readFile(String path) {
        List<List<String>> allElements = new ArrayList<>();
        List<String> elementData;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            boolean skip = true;
            while ((line = br.readLine()) != null) {
                if (skip) {
                    skip = false;
                } else {
                    String[] values = line.split(",");
                    elementData = Arrays.asList(values);
                    allElements.add(elementData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allElements;
    }

    public static ArrayList<Node> loadNodesandEdges() {
        List<List<String>> edgesData = Parser.readFile(System.getProperty("user.dir") + "/MapLedges.csv");
        ArrayList<Node> nodesList = new ArrayList<>();
        for (List<String> edgesDatum : edgesData) {
            if ((findNode(nodesList, edgesDatum.get(1)) == -1) || (findNode(nodesList, edgesDatum.get(2)) == -1)) {
                if ((findNode(nodesList, edgesDatum.get(1)) == -1)) {
                    nodesList.add(new Node(edgesDatum.get(1)));
                    if ((findNode(nodesList, edgesDatum.get(2)) == -1)) {
                        nodesList.add(new Node(edgesDatum.get(2)));
                        nodesList.get(findNode(nodesList, edgesDatum.get(1))).addEdge(nodesList.get(findNode(nodesList, edgesDatum.get(2))));
                    }
                    nodesList.get(findNode(nodesList, edgesDatum.get(2))).addEdge(nodesList.get(findNode(nodesList, edgesDatum.get(1))));
                }

                if ((findNode(nodesList, edgesDatum.get(2)) == -1)) {
                    nodesList.add(new Node(edgesDatum.get(2)));
                    if ((findNode(nodesList, edgesDatum.get(1)) == -1)) {
                        nodesList.add(new Node(edgesDatum.get(1)));
                        nodesList.get(findNode(nodesList, edgesDatum.get(2))).addEdge(nodesList.get(findNode(nodesList, edgesDatum.get(1))));
                    }
                    nodesList.get(findNode(nodesList, edgesDatum.get(1))).addEdge(nodesList.get(findNode(nodesList, edgesDatum.get(2))));
                }

            }
        }

        System.out.println("done");

        return nodesList;
    }

    public static int findNode(ArrayList<Node> nodes, String nodeID) {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getNodeID().equals(nodeID))
                return i;
        }
        return -1;
    }
}