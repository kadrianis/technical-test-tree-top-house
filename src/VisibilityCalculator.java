import java.util.List;

public class VisibilityCalculator {
    // Grid of trees
    private Grid grid;

    // Directions array representing up, down, left, and right
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Constructor that accepts a Grid
    public VisibilityCalculator(Grid grid) {
        this.grid = grid;
    }

    // Method to calculate the number of visible trees
    public int calculateVisibleTrees() {
        int visibleTrees = 0; // Initialize the visibleTrees counter
        List<Tree> trees = grid.getTrees(); // Get the list of trees

        // For each tree in the list of trees
        for (Tree tree : trees) {
            // If the tree is on the edge of the grid, it is visible
            if (tree.getX() == 0 || tree.getY() == 0 || tree.getX() == grid.getSize() - 1 || tree.getY() == grid.getSize() - 1) {
                grid.addVisibleTree(tree); // Add the tree to the list of visible trees
                visibleTrees++; // Increment the counter of visible trees
            } else {
                // If the tree is not on the edge, check if it is visible from any direction
                for (int[] direction : directions) {
                    if (isVisible(tree, direction)) {
                        grid.addVisibleTree(tree); // If it is visible, add it to the list of visible trees
                        visibleTrees++; // Increment the counter of visible trees
                        break;
                    }
                }
            }
        }

        // Return the number of visible trees
        return visibleTrees;
    }

    // Helper method to check if a tree is visible in a certain direction
    private boolean isVisible(Tree tree, int[] direction) {
        int x = tree.getX() + direction[0];
        int y = tree.getY() + direction[1];

        // Check all trees in the given direction
        while (x >= 0 && y >= 0 && x < grid.getSize() && y < grid.getSize()) {
            Tree nextTree = grid.getTreeAt(x, y); // Get the next tree in the direction
            // If the next tree is taller or the same height, the current tree is not visible
            if (nextTree.getHeight() >= tree.getHeight()) {
                return false;
            }
            x += direction[0];
            y += direction[1];
        }

        // If none of the trees in the direction are taller, the tree is visible
        return true;
    }
}
