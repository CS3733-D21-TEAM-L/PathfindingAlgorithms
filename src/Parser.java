import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Parser for CSV files to load the nodes and edges from the provided csv files
 * @Author Emmanuel Ola
 */
public class Parser {
    /**
     * Method to read in csv files and convert them to a list of row elements
     * containing info for each file
     * @param path Path to the csv file
     * @Author Freud Oulon
     * @return
     */
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

    /**
     * Static method that reads the data passed from Parser.readFile() and converts
     * them into an ArrayList of nodes that information about each node.
     * It also loads the edges of each node while it parses the data
     * @Author
     * @return ArrayList of bidirectional nodes in the CSV file
     */
    public static ArrayList<Node> loadNodesandEdges() {
        List<List<String>> edgesData = Parser.readFile(System.getProperty("user.dir") + "/MapLedges.csv");
        ArrayList<Node> nodesList = new ArrayList<>(); //Instantiate the Arraylist of nodes

        //Load all the nodes into nodesList
        for (List<String> edgesDatum : edgesData) {
            if (Parser.indexOfNode(nodesList, edgesDatum.get(1)) == -1){
                nodesList.add(new Node(edgesDatum.get(1)));
            }
            if (Parser.indexOfNode(nodesList, edgesDatum.get(2)) == -1){
                nodesList.add(new Node(edgesDatum.get(2)));
            }
        }

        //Loads the edges for each node
        for (Node node : nodesList) {
            for (List<String> edgesDatum : edgesData) {
                if (node.getNodeID().equals(edgesDatum.get(1))){
                    node.addEdge(nodesList.get(Parser.indexOfNode(nodesList, edgesDatum.get(2))));
                    nodesList.get(Parser.indexOfNode(nodesList, edgesDatum.get(2))).addEdge(node);
                }
            }
        }

        return nodesList;
    }

    /**
     * Retrieves the index of a node within an ArrayList of nodes, when provided the nodeID for the node.
     * @param nodes ArrayList of nodes
     * @param nodeID nodeID for the missing node
     * @return index of provided node, or -1 if the node isn't in the list
     */
    public static int indexOfNode(ArrayList<Node> nodes, String nodeID) {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getNodeID().equals(nodeID))
                return i;
        }
        return -1;
    }
}
