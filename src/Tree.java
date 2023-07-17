public class Tree {
    // Each tree has a height and a position (x, y)
    private int height;
    private int x;
    private int y;

    // The constructor for a Tree object requires its height and position
    public Tree(int height, int x, int y) {
        this.height = height;  // Sets the height of the tree
        this.x = x;  // Sets the x-coordinate of the tree
        this.y = y;  // Sets the y-coordinate of the tree
    }

    // Getter method for height of the tree
    public int getHeight() {
        return height;
    }

    // Getter method for x-coordinate of the tree
    public int getX() {
        return x;
    }

    // Getter method for y-coordinate of the tree
    public int getY() {
        return y;
    }
}
