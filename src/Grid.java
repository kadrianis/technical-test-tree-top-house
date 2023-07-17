import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grid {
    // List to hold all trees in the grid
    private List<Tree> trees;

    // List to hold only the visible trees
    private List<Tree> visibleTrees;

    // The size of the grid
    private int size;

    // Constructor of the grid that accepts a size
    public Grid(int size) {
        this.size = size; // Set the size of the grid
        this.trees = new ArrayList<>(); // Initialize the list of trees
        this.visibleTrees = new ArrayList<>(); // Initialize the list of visible trees
        Random random = new Random();

        // For each grid cell, create a new tree with random height between 0 and 9
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int height = random.nextInt(10); // random number between 0 and 9
                this.trees.add(new Tree(height, i, j)); // Add the new tree to the list of trees
            }
        }
    }

    // Display the grid in the console
    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Print the height of each tree in the grid
                System.out.print(trees.get(i*size + j).getHeight() + " ");
            }
            System.out.println();
        }
    }

    // Display the grid with visible trees indicated by "*"
    public void displayWithVisibleTrees() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Tree tree = trees.get(i*size + j);
                // If the tree is in the list of visible trees, print "*"
                if (visibleTrees.contains(tree)) {
                    System.out.print("* ");
                }
                // If the tree is not in the list of visible trees, print "."
                else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    // Add a tree to the list of visible trees
    public void addVisibleTree(Tree tree) {
        visibleTrees.add(tree);
    }

    // Getter method for the list of trees
    public List<Tree> getTrees() {
        return trees;
    }

    // Getter method for the size of the grid
    public int getSize() {
        return size;
    }

    // Returns the Tree object located at position (x, y) in the grid
    public Tree getTreeAt(int x, int y) {
        return trees.get(x*size + y);
    }
}
