import java.util.LinkedList;

public class GeneralSearch {
    public char initialState;
    public char solution;
    public LinkedList<Node> exploredList;

    public GeneralSearch(){
        this.initialState = 'S';
        this.solution = 'G';
        this.exploredList = new LinkedList<Node>();
    }

    public static void Main(){
        int iterativeDepthLimit = 0;
        int previousIterativeDepthLimit = 0;
        Node[] listOfNodes;
        LinkedList<Node> exploredList = new LinkedList<Node>();
    }

    public LinkedList<Node> makeQueue(Node initialNode){
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(initialNode);

        return queue;
    }

    public Node makeInitialNode(String nodeID, char startOrTarget){
        return new Node(nodeID, startOrTarget);
    }

    public Node removeFront(LinkedList<Node> inputQueue){
        return inputQueue.pop();
    }

    public int calculateHeuristicValue(Node inputNode){
        return inputNode.heuristic;
    }

    //TODO: add the other algo functions
}
