import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;


public class AStarTest {
    ArrayList<Node> nodes = new ArrayList<Node>();
    Node s1 = nodes.get(Parser.indexOfNode(nodes, ""));
    Node g1 = nodes.get(Parser.indexOfNode(nodes, ""));
    Node s2 = nodes.get(Parser.indexOfNode(nodes, ""));
    Node g2 = nodes.get(Parser.indexOfNode(nodes, ""));
    AStarOther a = new AStarOther(nodes, s1, g1);
    ArrayList<Node> path = new ArrayList<>();

    public AStarTest() {
        path = a.returnPath();
    }

    @Test
    public void pathFindingTest1(){
        ArrayList<Node> testPath = new ArrayList<>();
        testPath.add(nodes.get(Parser.indexOfNode(nodes,"")));
        assertNotSame(testPath, path);
        assertEquals(testPath, path);
    }
}
