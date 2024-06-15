import java.util.Scanner;

public class assignment2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            // Test get_user_input
            int userInputInt = get_user_input(scanner, "Enter an integer: ", Integer.class);
            System.out.println("You entered an integer: " + userInputInt);

            double userInputDouble = get_user_input(scanner, "Enter a double: ", Double.class);
            System.out.println("You entered a double: " + userInputDouble);

            // Test maximum_element
            int[] arr = {5, 8, 2, 10, 3};
            int maxElement = maximum_element(arr);
            System.out.println("Maximum element in the array: " + maxElement);

            // Test element_uniqueness
            int[] arr2 = {1, 2, 3, 4, 5, 1};
            boolean isUnique = element_uniqueness(arr2);
            System.out.println("All elements in the array are unique: " + isUnique);

            // Test matrix_multiplication
            int[][] matrix1 = {{1, 2}, {3, 4}};
            int[][] matrix2 = {{5, 6}, {7, 8}};
            int[][] resultMatrix = matrix_multiplication(matrix1, matrix2);
            System.out.println("Result of matrix multiplication:");
            printMatrix(resultMatrix);

            // Test gaussian_elimination
            double[][] matrix = {{2, 1, -1}, {-3, -1, 2}, {-2, 1, 2}};
            double[] constants = {8, -11, -3};
            double[] solution = gaussian_elimination(matrix, constants);
            System.out.println("Solution to the system of equations:");
            printArray(solution);
        }
    }

    public static <T> T get_user_input(Scanner scanner, String message, Class<T> dataType) {
        System.out.print(message);
        while (true) {
            try {
                if (dataType == Integer.class) {
                    return dataType.cast(scanner.nextInt());
                } else if (dataType == Double.class) {
                    return dataType.cast(scanner.nextDouble());
                } else {
                    throw new IllegalArgumentException("Unsupported data type: " + dataType.getSimpleName());
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a " + dataType.getSimpleName());
                scanner.next(); // consume invalid input
            }
        }
    }

    public static void print_output(String message, Object output) {
        System.out.println(message + output);
    }

    // **Iterative Algorithms**

    public static int maximum_element(int[] arr) {
        int maxElement = arr[0];
        for (int num : arr) {
            if (num > maxElement) {
                maxElement = num;
            }
        }
        return maxElement;
    }

    public static boolean element_uniqueness(int[] arr) {
        boolean[] seen = new boolean[101]; // assuming input range from 0 to 100
        for (int num : arr) {
            if (num < 0 || num >= seen.length) {
                System.out.println("Error: Element out of range (0-100): " + num);
                return false;
            }
            if (seen[num]) {
                return false;
            }
            seen[num] = true;
        }
        return true;
    }

    public static int[][] matrix_multiplication(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        int[][] result = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static double[] gaussian_elimination(double[][] matrix, double[] constants) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int maxRow = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(matrix[j][i]) > Math.abs(matrix[maxRow][i])) {
                    maxRow = j;
                }
            }
            if (Math.abs(matrix[maxRow][i]) < 1e-10) {
                System.out.println("System may be singular or nearly singular.");
                return null;
            }
            // Swap rows
            double[] tempRow = matrix[i];
            matrix[i] = matrix[maxRow];
            matrix[maxRow] = tempRow;

            double tempConstant = constants[i];
            constants[i] = constants[maxRow];
            constants[maxRow] = tempConstant;

            for (int j = i + 1; j < n; j++) {
                double pivot = matrix[i][i];
                if (Math.abs(pivot) < 1e-10) {
                    continue;
                }
                double ratio = matrix[j][i] / pivot;
                for (int k = i; k < n; k++) {
                    matrix[j][k] -= matrix[i][k] * ratio;
                }
                constants[j] -= constants[i] * ratio;
            }
        }

        // Back substitution
        double[] solution = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += matrix[i][j] * solution[j];
            }
            solution[i] = (constants[i] - sum) / matrix[i][i];
        }
        return solution;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void printArray(double[] arr) {
        for (double num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
