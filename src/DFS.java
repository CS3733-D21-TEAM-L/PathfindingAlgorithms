import java.util.*;

public class DFS {
    private ArrayList<Node> nodes = new ArrayList<>();
    private Node start;
    private Node end;
    private Stack<Node> solution;

    public DFS(Node start, Node end) {
        this.nodes = Parser.loadNodesandEdges();
        this.start = start;
        this.end = end;
        this.solution = new Stack<>();

        for (int i = 0; i < nodes.size(); i++) {
            if (!nodes.get(i).visited) {
                DFSUtil(start, end);
            }
        }
    }

    void DFSUtil(Node current, Node end) {
        current.visited = true;


        Iterator<Node> i = current.getEdges().listIterator();
        while (i.hasNext()) {
            Node n = i.next();
            if (!n.getNodeID().equals(end.getNodeID()))
                if (Parser.findNode(n.getEdges(), current.getNodeID()) != -1 || !n.hasParent)
                    n.setParent(current);
                else {
                    end.setParent(current);
                    Node temp = end;
                    while (!temp.getNodeID().equals(start.getNodeID())) {
                        solution.push(temp);
                        temp = temp.getParent();
                    }
                    return;
                }
            if (!n.visited) {
                DFSUtil(n, end);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Node> nodes = Parser.loadNodesandEdges();
        DFS dfs = new DFS(nodes.get(Parser.findNode(nodes, "lPARK001GG")), nodes.get(Parser.findNode(nodes, "lEXIT002GG")));
        Stack print = dfs.solution;
        while (!print.isEmpty()) {
            System.out.print(print.pop() + " ");
        }
    }

}
