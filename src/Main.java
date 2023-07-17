import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 0;

        // Ask the user to input the size of the grid.
        do {
            System.out.println("Please enter the size of the grid (an x*x grid between 7 and 25):");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a valid number! Please enter a number between 7 and 25:");
                scanner.next();
            }
            size = scanner.nextInt();
        } while (size < 7 || size > 25);

        // Create a new grid with the input size and display it.
        Grid grid = new Grid(size);
        System.out.println("Here is your randomly generated grid:");
        grid.display();

        // Ask the user if they want to see the solution.
        String response;
        do {
            System.out.println("Would you like to see the solution? Please answer with 'yes' or 'no':");
            response = scanner.next();
        } while (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no"));

        // If the user wants to see the solution, calculate the number of visible trees
        // and display the grid again with visible trees marked.
        if (response.equalsIgnoreCase("yes")) {
            VisibilityCalculator calculator = new VisibilityCalculator(grid);
            int visibleTrees = calculator.calculateVisibleTrees();
            System.out.println("The total number of trees visible from outside the grid is: " + visibleTrees);
            System.out.println("Here is the grid with visible trees marked by '*':");
            grid.displayWithVisibleTrees();
        } else {
            System.out.println("Okay, solution not displayed.");
        }

        // Close the scanner to prevent a memory leak.
        scanner.close();
    }
}
