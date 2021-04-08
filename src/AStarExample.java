import java.util.PriorityQueue;

// Astar example: John Canessa- https://www.johncanessa.com/2020/01/29/a-search-algorithm/

/**
 * <h1>A* Pathfinding</h1>
 * This program performs A* Pathfinding
 */
public class AStarExample {

    /**Instantiates cost for diagonal moves
     */
    public static final int DIAGONAL_COST = 14;
    /**Instantiates cost for vertical and horizontal moves
     */
    public static final int V_H_COST = 10;
    //Cells of our grid
    private Cell[][] grid;
    //We define a priority queue for open cells
    //Open Cells: the set of nodes to be evaluated
    //we put cells with lowest cost in first
    private PriorityQueue<Cell> openCells;
    //Closed Cells : the set of nodes already evaluated
    private boolean[][] closedCells;
    //start cell
    private int startI, startJ;
    //End cell
    private int endI, endJ;

    /**
     * Sets up the grid for the pathfinding algorithm as well as the start and ending coordinates
     * @param width the width of the grid
     * @param height the height of the grid
     * @param si the row of the start cell
     * @param sj the column of the start cell
     * @param ei the row of the end cell
     * @param ej the column of the end cell
     * @param blocks the coordinates of the path blocks
     */
    public AStarExample(int width, int height, int si, int sj, int ei, int ej, int[][] blocks) {
        grid = new Cell[width][height];
        closedCells = new boolean[width][height];
        openCells = new PriorityQueue<Cell>((Cell c1, Cell c2) -> {
            return c1.finalCost < c2.finalCost ? -1 : c1.finalCost > c2.finalCost ? 1 : 0;
        });
        startCell(si, sj);
        endCell(ei, ej);

        //init heuristic and cells
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Cell(i, j);
                grid[i][j].heuristicCost = Math.abs(i - endI) + Math.abs(j - endJ);
                grid[i][j].solution = false;
            }
        }

        grid[startI][startJ].finalCost = 0;

        //we put the blocks on the grid
        for (int i = 0; i < blocks.length; i++) {
            addBlockOnCell(blocks[i][0], blocks[i][1]);
        }

    }

    private void endCell(int ei, int ej) {
        endJ = ej;
        endI = ei;
    }

    private void startCell(int i, int j) {
        startI = i;
        startJ = j;
    }

    private void addBlockOnCell(int i, int j) {
        grid[i][j] = null;
    }

    /**
     * Updates the cost of each route as needed
     * @param current the current cell we're on
     * @param t the cell we're moving to
     * @param cost the cost of making this move
     */
    public void updateCostIfNeeded(Cell current, Cell t, int cost) {
        if (t == null || closedCells[t.i][t.j])
            return;

        int tFinalCost = t.heuristicCost + cost;
        boolean isOpen = openCells.contains(t);

        if (!isOpen || tFinalCost < t.finalCost){
            t.finalCost = tFinalCost;
            t.parent = current;

            if (!isOpen)
                openCells.add(t);
        }
    }

    /**Processes the cost of the board
     */
    public void process() {
        //we add the start location to open list
        openCells.add(grid[startI][startJ]);
        Cell current;

        while (true) {
            current = openCells.poll();

            if (current == null) {
                break;
            }

            closedCells[current.i][current.j] = true;

            if (current.equals(grid[endI][endJ]))
                return;

            Cell t;

            if (current.i - 1 >= 0){
                t = grid[current.i - 1][current.j];
                updateCostIfNeeded(current, t, current.finalCost + V_H_COST);

                if (current.j - 1 >= 0) {
                    t = grid[current.i - 1][current.j - 1];
                    updateCostIfNeeded(current, t, current.finalCost + DIAGONAL_COST);
                }

                if (current.j + 1 < grid[0].length) {
                    t = grid[current.i - 1][current.j + 1];
                    updateCostIfNeeded(current, t, current.finalCost + DIAGONAL_COST);
                }
            }

            if (current.j - 1 >= 0){
                t = grid[current.i][current.j - 1];
                updateCostIfNeeded(current, t, current.finalCost + V_H_COST);
            }

            if (current.j + 1 < grid[0].length) {
                t = grid[current.i][current.j + 1];
                updateCostIfNeeded(current, t, current.finalCost + V_H_COST);
            }

            if (current.i + 1 < grid.length) {
                t = grid[current.i + 1][current.j];
                updateCostIfNeeded(current, t, current.finalCost + V_H_COST);

                if (current.j - 1 >= 0) {
                    t = grid[current.i + 1][current.j - 1];
                    updateCostIfNeeded(current, t, current.finalCost + DIAGONAL_COST);
                }

                if (current.j + 1 < grid[0].length) {
                    t = grid[current.i + 1][current.j + 1];
                    updateCostIfNeeded(current, t, current.finalCost + DIAGONAL_COST);
                }
            }
        }
    }

    /**
     * Displays the board
     */
    public void display() {
        System.out.println("Grid: ");

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++) {
                if (i==startI && j==startJ)
                    System.out.print("SO "); //Source cell
                else if (i ==  endI && j == endJ)
                    System.out.print("DE "); //Destination cell
                else if (grid[i][j] != null)
                    System.out.printf("%-3d", 0);
                else
                    System.out.print("BL "); //Block Cell
            }

            System.out.println();
        }

        System.out.println();
    }

    /**
     * Displays the cost of each reachable location on the board along the path to the end
     */
    public void displayScores() {
        System.out.println("\nScores for cells: ");

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != null) {
                    System.out.printf("%-3d ", grid[i][j].finalCost);
                }
                else
                    System.out.print("BL  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Displays the chosen path
     */
    public void displaySolution(){
        if (closedCells[endI][endJ]) {
            //We track back the path
            System.out.print("Path: ");
            Cell current = grid[endI][endJ];
            System.out.print(current);
            grid[current.i][current.j].solution = true;

            while (current.parent != null){
                System.out.print(" -> " + current.parent);
                grid[current.parent.i][current.parent.j].solution = true;
                current = current.parent;
            }

            System.out.println("\n");

            for (int i = 0; i < grid.length; i++){
                for (int j = 0; j < grid[i].length; j++) {
                    if (i==startI && j==startJ)
                        System.out.print("SO "); //Source cell
                    else if (i ==  endI && j == endJ)
                        System.out.print("DE "); //Destination cell
                    else if (grid[i][j] != null)
                        System.out.printf("%-3s", grid[i][j].solution ? "X" : "0");
                    else
                        System.out.print("BL "); //Block Cell
                }

                System.out.println();
            }

            System.out.println();
        } else
            System.out.println("No possible path");
    }

    public static void main(String[] args) {
        AStarExample aStar = new AStarExample(5, 5, 0, 0, 3, 0,
                new int[][]{
                        {0,4}, {2,2}, {2,0}, {3,1}, {3,3}, {2,1}, {2,3}
                }
                );
        aStar.display();
        aStar.process(); //Apply A* Algorithm
        aStar.displayScores(); //Display Scores on grid
        aStar.displaySolution(); //Display Solution Path
    }
}
