import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TSPExhaustiveSearch {

    // Function to calculate the total distance of a given tour
    public static int calculateTourDistance(int[][] distances, List<Integer> tour) {
        int totalDistance = 0;
        for (int i = 0; i < tour.size() - 1; i++) {
            totalDistance += distances[tour.get(i)][tour.get(i + 1)];
        }
        return totalDistance;
    }

    // Function to find the shortest path using exhaustive search
    public static List<Integer> findShortestPath(int[][] distances, int start, int end, String[] mainCities, String[][] minorTowns) {
        List<Integer> citiesList = new ArrayList<>();
        for (int i = 0; i < distances.length; i++) {
            if (i != start && i != end) {
                citiesList.add(i);
            }
        }

        List<Integer> shortestPath = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;

        // Generate all permutations of the cities excluding start and end
        List<List<Integer>> permutations = generatePermutations(citiesList);

        for (List<Integer> permutation : permutations) {
            // Add the start and end points to the current permutation
            permutation.add(0, start);
            permutation.add(end);
            int currentDistance = calculateTourDistance(distances, permutation);
            if (currentDistance < minDistance) {
                minDistance = currentDistance;
                shortestPath = new ArrayList<>(permutation);
            }
        }
        System.out.println("Minimum Distance: " + minDistance + " kilometers");
        return shortestPath;
    }

    // Function to generate all permutations of a list
    public static List<List<Integer>> generatePermutations(List<Integer> original) {
        if (original.size() == 0) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        Integer firstElement = original.remove(0);
        List<List<Integer>> returnValue = new ArrayList<>();
        List<List<Integer>> permutations = generatePermutations(original);

        for (List<Integer> smallerPermutated : permutations) {
            for (int index = 0; index <= smallerPermutated.size(); index++) {
                List<Integer> temp = new ArrayList<>(smallerPermutated);
                temp.add(index, firstElement);
                returnValue.add(temp);
            }
        }
        original.add(0, firstElement); // Restore original list state
        return returnValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Main city names
        String[] mainCities = {"Accra", "Kumasi", "Cape Coast", "Ho", "Koforidua"};

        // Minor town names corresponding to main cities
        String[][] minorTowns = {
                {"Tema", "Prampram", "Aflao"},
                {"Madina", "Oyarifa", "Aburi"},
                {"Kasoa", "Winneba", "Saltpond"},
                {},
                {"Pokuase", "Nsawam", "Konongo", "Obuasi"}
        };

        // Distance matrix (distances are approximate and in kilometers)
        int[][] distances = {
                // Accra, Kumasi, Cape Coast, Ho, Koforidua
                {0, 250, 150, 160, 85},   // Accra
                {250, 0, 280, 175, 115},  // Kumasi
                {150, 280, 0, 195, 105},  // Cape Coast
                {160, 175, 195, 0, 85},   // Ho
                {85, 115, 105, 85, 0}     // Koforidua
        };

        // Display main cities for user selection
        System.out.println("Choose a starting city:");
        for (int i = 0; i < mainCities.length; i++) {
            System.out.println((i + 1) + ". " + mainCities[i]);
        }
        int startChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Choose an ending city:");
        for (int i = 0; i < mainCities.length; i++) {
            System.out.println((i + 1) + ". " + mainCities[i]);
        }
        int endChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Get indices for start and end cities
        int start = startChoice - 1; // Adjust index for array
        int end = endChoice - 1; // Adjust index for array

        // Validate input
        if (start < 0 || start >= mainCities.length || end < 0 || end >= mainCities.length || start == end) {
            System.out.println("Invalid start or end city choice.");
            return;
        }

        // Get the shortest path including main cities and minor towns
        List<Integer> shortestPath = findShortestPath(distances, start, end, mainCities, minorTowns);

        // Output the shortest path (city names)
        System.out.print("Shortest Path: ");
        for (int i = 0; i < shortestPath.size(); i++) {
            int cityIndex = shortestPath.get(i);
            if (i == 0 || i == shortestPath.size() - 1) {
                // Main city
                System.out.print(mainCities[cityIndex]);
            } else {
                // Minor town
                if (minorTowns[cityIndex].length > 0) {
                    System.out.print(" -> " + minorTowns[cityIndex][0]); // Display the first minor town
                }
            }
            if (i < shortestPath.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();

        scanner.close();
    }
}
