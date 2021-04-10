//pseudo code

// basic understanding of A*: f(n) = g(n) + h(n)
// f(n) is the estimated cost of the path passing through n
// g(n) is the KNOWN distance
// h(n) is estimated by the heuristic

import java.util.Hashtable;
import java.util.PriorityQueue;

public class AStar {

    public static void createPath(Node start, Node goal) { //(mapData, Node start, Node goal)
        // Initialize variable to track cost
        int cost = 0;

        // Set up instance of the priority queue (maybe a class we have to make)
        PriorityQueue<Node> frontier = new PriorityQueue<Node>();

        // Adds the start location to the queue
        frontier.add(start);

        // Initialize dictionaries to track past nodes and costs
        Hashtable<Node, Integer> costSoFar = new Hashtable<Node, Integer>();
        Hashtable<Node, Node> cameFrom = new Hashtable<Node, Node>();
        // Iterate through the queue
        while (!frontier.isEmpty()) //frontier is not empty
        {
            // Set up current location
            Node current = frontier.poll(); //current item in queue;

            // If we reach our goal location in the queue break out of the loop
            if (current.getNodeID().equals(goal.getNodeID())) {
                break; // Exit if goal is found
            }

            // Iterate through all nodes connected to current node
            for (Node next : current.getEdges()) {
                // Calculates the cost of the next point (this represents g(n))
                cost = costSoFar.get(current) + current.getHeuristic(); //costSoFar[current location in iteration] + current point distance;

                // Checks if the next location is not already in the cost_so_far dictionary
                // Or if the new calculated cost is less than the locations previous cost
                if (costSoFar.contains(next) || cost < costSoFar.get(next)) { //next+1??

                    // Adds the next location and the new cost to the cost_so_far dictionary
                    // cost_so_far[next location in iteration] = new_cost;
                    costSoFar.put(next, cost);

                    // Calculate the priority or f(n) based off the new calculated cost and the Euclidean distance
                    // f(n) = g(n) + h(n)
                    int priority = cost + current.getHeuristic(); //priority = new_cost + euclidean distance from current location to goal;

                    // Adds the next location and its priority to the priority queue
                    frontier.remove(next);
                    frontier.add(next); //frontier.put(next location in iteration, priority);
                    // Adds the next location to the came_from dictionary with the current location as its value
                    cameFrom.put(next, current);//came_from[next] = current;
                }
            }
        }
    }
}
