import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * <h1>AStar Pathfinding</h1>
 * AStar Pathfinding Algorithm that navigates a map of provided nodes
 * @author Emmanuel Ola
 */
public class AStar {
    /**
     * ArrayList of provided nodes
     */
    private ArrayList nodes;
    /**
     * The starting node
     */
    private Node start;
    /**
     * The ending node
     */
    private Node goal;
    /**
     * Priority queue of open nodes. Instantiated with our NodeComparator class
     */
    private PriorityQueue<Node> openNodes;

    /** Loads the relevant information for the AStar algorithm and prints the result of the pathfinding operation
     * @param nodes the list of nodes
     * @param start the starting node
     * @param goal the ending node
     */
    public AStar(ArrayList nodes, Node start, Node goal) {
        this.nodes = nodes;
        this.start = start;
        start.setCostSoFar(0); //Initializes the cost so far of the starting node to 0
        this.goal = goal;
        openNodes = new PriorityQueue<>(new NodeComparator()); //Instantiates the priority queue with our overwrited comparator
        this.process();
        this.displayPath();
    }

    /**
     * Prints the path from the start node to the goal node
     */
    public void displayPath(){
        Stack<Node> finalPath = this.getPath(); //
        while (!finalPath.isEmpty())
            System.out.println(finalPath.pop().getNodeInfo().get("fullName"));
    }

    /**
     * Helper method for displayPath() and returnPath() that provides a stack containing the solution path
     * @return Stack containing the solution path for algorithm
     */
    private Stack<Node> getPath() {
        Stack<Node> finalPath = new Stack<>(); //Stack containing the final path of our algorithm


        Node current = goal;
        while (current.getParent() != null){
            finalPath.push(current);
            current = current.getParent();
        }
        finalPath.push(start); //Pushes the starting node on to the stack

        return finalPath;
    }

    /**
     * <b>*For JUnit Testing*</b> This method returns a list of nodes from start to finish that represents
     * the path of the AStar algorithm
     * @return a List of nodes representing the path of the algorithm
     */
    public ArrayList<Node> returnPath(){
        Stack<Node> finalPath = this.getPath();
        ArrayList<Node> returnPath = new ArrayList<Node>();
        while (!finalPath.isEmpty())
            returnPath.add(finalPath.pop());
        return returnPath;
    }

    /**
     * Navigates the map by processing the priority queue
     */
    public void process(){
        openNodes.add(start); //Adds our starting node to the priority queue
        Node current = start; //Sets the current node to the starting node
        double tentativeScore = 0;

        while (!openNodes.isEmpty()){
            if (current.getNodeID().equals(goal.getNodeID()))
                return; //Ends pathfinding when we reach our goal
            current = openNodes.poll();

            //Iterates through the neighbors of each node popped from the Priority Queue
            for (Node neighbor : current.getEdges().keySet()) {
                tentativeScore = (current.getCostSoFar() + distance(current, neighbor)); //Sets tentative score to the cost of taking this path to the neighbor
                if (tentativeScore < neighbor.getCostSoFar()){ //Checks if the current path to neighbor is cheaper than any other we've encountered
                    neighbor.setParent(current);
                    neighbor.setCostSoFar(tentativeScore);
                    neighbor.setHeuristic(calculateHeuristic(neighbor));
                    neighbor.updateAStarScore();
                    if (!openNodes.contains(neighbor))
                        openNodes.add(neighbor); //Adds neighbor to the priority queue if it isn't already in there
                }
            }
        }
    }

    /**
     * Calculates the heuristic for a provided node
     * @param node the node to calculate a heuristic for
     * @return the heuristic for the provide node
     */
    public double calculateHeuristic(Node node) {
        return distance(node, goal);
    }

    /**
     * Calculates the distance from one node to another
     * @param a the starting node
     * @param b the ending node
     * @return the euclidean distance between two nodes
     */
    public double distance(Node a, Node b) {
        //TODO MAKE THIS A SWITCH STATEMENT/MAKE DISTANCE FORMULA 3D
        int x1 = a.getCoords().get("x");
        int x2 = b.getCoords().get("x");
        int y1 = a.getCoords().get("y");
        int y2 = b.getCoords().get("y");
        double flatDistance = Math.sqrt((Math.pow((x2-x1),2)) + (Math.pow((y2-y1),2)));
        String afloor = a.getNodeInfo().get("floor");
        String bfloor = b.getNodeInfo().get("floor");
        if (afloor.equals("L1")||afloor.equals("L2"))
            if (afloor.equals("L1"))
                afloor = "0";
            else
                afloor = "-1";
        if (bfloor.equals("L1")||bfloor.equals("L2"))
            if (bfloor.equals("L1"))
                bfloor = "0";
            else
                bfloor = "-1";
        return flatDistance + (Math.abs(Integer.valueOf(afloor) - Integer.valueOf(bfloor)) * 50) ;
        //return flatDistance;
    }

    public static void main(String[] args) {
        //TODO make nodeID take click instance/drop-down  menu
        Stopwatch timer = new Stopwatch();
        ArrayList<Node> nodes = Parser.loadNodesandEdges();
        Node start = nodes.get(Parser.indexOfNode(nodes, "EEXIT00201"));
        Node goal = nodes.get(Parser.indexOfNode(nodes, "GDEPT00403"));
        AStar example = new AStar(nodes, start, goal);
        System.out.println(timer.elapsedTime());
    }
}
