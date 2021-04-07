//pseudo code

// basic understanding of A*: f(n) = g(n) + h(n)
// f(n) is the estimated cost of the path passing through n
// g(n) is the KNOWN distance
// h(n) is estimated by the heuristic

import java.util.Hashtable;

public class AStar {

    public static void createPath(mapData, start, goal) {

        // Set up instance of the priority queue (maybe a class we have to make)
        PriorityQueue frontier = new PriorityQueue();

        // Adds the start location to the queue
        frontier.put(startPoint);

        // Initialize dictionaries to track past nodes and costs
        Hashtable<> cost_so_far = new Hashtable<>();
        Hashtable<> came_from = new Hashtable<>();

        // iterate through the queue
        while (frontier is not empty)
        {
            // set up current location
            current = (current item in queue);

            // if we reach our goal location in the queue break out of the loop
            if (current == goal) {
                break;
            }

            // iterate through all nodes connected to current node
            for () {
                // Calculates the cost of the next point (this represents g(n))
                new_cost = cost_so_far[current location in iteration] + current point distance;

                // Checks if the next location is not already in the cost_so_far dictionary
                // Or if the new calculated cost is less than the locations previous cost
                if () {

                    // Adds the next location and the new cost to the cost_so_far dictionary
                    cost_so_far[next location in iteration] = new_cost;

                    // Calculate the priority or f(n) based off the new calculated cost and the Euclidean distance
                    // f(n) = g(n) + h(n)
                    priority = new_cost + euclidean distance from current location to goal;

                    // Adds the next location and its priority to the priority queue
                    frontier.put(next location in iteration, priority);

                    // Adds the next location to the came_from dictionary with the current location as its value
                    came_from[next] = current;
                }
            }
        }
    }
}
