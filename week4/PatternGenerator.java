package week4;

    import java.util.Scanner;

public class PatternGenerator {
    public static void main(String[] args) {

        // Create a Scanner object.
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the number of rows.
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        // ============================================================
        // PATTERN 1: Right Triangle (Increasing Stars)
        // ============================================================
        System.out.println("\n=== PATTERN 1: Right Triangle ===");

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // ============================================================
        // PATTERN 2: Inverted Right Triangle (Decreasing Stars)
        // ============================================================
        System.out.println("\n=== PATTERN 2: Inverted Right Triangle ===");

        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // ============================================================
        // PATTERN 3: Pyramid (Centered Stars)
        // ============================================================
        System.out.println("\n=== PATTERN 3: Pyramid ===");

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // ============================================================
        // PATTERN 4: Number Triangle
        // ============================================================
        System.out.println("\n=== PATTERN 4: Number Triangle ===");

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // ============================================================
        // PATTERN 5: Multiplication Table
        // ============================================================
        System.out.println("\n=== PATTERN 5: Multiplication Table ===");

        System.out.print(" ");
        for (int i = 1; i <= rows; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println();

        System.out.print(" ");
        for (int i = 1; i <= rows; i++) {
            System.out.print("----");
        }
        System.out.println();

        for (int i = 1; i <= rows; i++) {
            System.out.printf("%3d|", i);

            for (int j = 1; j <= rows; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }

        // Close the scanner.
        scanner.close();
    }
}

