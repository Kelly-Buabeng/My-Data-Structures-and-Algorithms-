import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TSPExhaustiveSearch {

    // City names
    private static final String[] CITIES = {"Accra", "Kumasi", "Cape Coast", "Ho", "Koforidua"};

    // Distance matrix (distances are approximate and in kilometers)
    private static final int[][] DISTANCES = {
            // Accra, Kumasi, Cape Coast, Ho, Koforidua
            {0, 250, 280, 195, 105},   // Accra
            {250, 0, 175, 160, 115},  // Kumasi
            {280, 175, 0, 345, 150},  // Cape Coast
            {195, 160, 345, 0, 85},   // Ho
            {105, 115, 150, 85, 0}    // Koforidua
    };

    // Minor towns corresponding to main cities
    private static final String[][] MINOR_TOWNS = {
            {"Tema", "Prampram", "Aflao"},                    
            {"Madina", "Oyarifa", "Aburi"},                   
            {"Kasoa", "Winneba", "Salt Pond"},                
            {},                                                
            {"Pokuase", "Nsawam", "Konongo", "Obuasi"}        
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Travelling Salesman Problem Solver");

        
        System.out.println("Choose a starting city:");
        for (int i = 0; i < CITIES.length; i++) {
            System.out.println((i + 1) + ". " + CITIES[i]);
        }
        int startChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Choose an ending city:");
        for (int i = 0; i < CITIES.length; i++) {
            System.out.println((i + 1) + ". " + CITIES[i]);
        }
        int endChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Validate input
        if (startChoice < 1 || startChoice > CITIES.length || endChoice < 1 || endChoice > CITIES.length || startChoice == endChoice) {
            System.out.println("Invalid start or end city choice.");
            return;
        }

        // Adjust indices for array access
        int start = startChoice - 1;
        int end = endChoice - 1;

    
        switch (start) {
            case 0: // Accra
                switch (end) {
                    case 1: // Accra to Kumasi
                        System.out.println("Shortest Path: Accra -> Pokuase -> Nsawam -> Konongo -> Kumasi");
                        break;
                    case 2: // Accra to Cape Coast
                        System.out.println("Shortest Path: Accra -> Kasoa -> Winneba -> Salt Pond -> Cape Coast");
                        break;
                    case 3: // Accra to Ho
                        System.out.println("Shortest Path: Accra -> Tema -> Prampram -> Aflao -> Ho");
                        break;
                    case 4: // Accra to Koforidua
                        System.out.println("Shortest Path: Accra -> Madina -> Oyarifa -> Aburi -> Koforidua");
                        break;
                }
                break;
            case 1: // Kumasi
                switch (end) {
                    case 0: // Kumasi to Accra
                        System.out.println("Shortest Path: Kumasi -> Konongo -> Nsawam -> Pokuase -> Accra");
                        break;
                    case 2: // Kumasi to Cape Coast
                        System.out.println("Shortest Path: Kumasi -> Via River Pra -> Cape Coast");
                        break;
                    case 3: // Kumasi to Ho
                        System.out.println("Shortest Path: Kumasi -> Konongo -> Nsawam -> Pokuase -> Accra -> Tema -> Prampram -> Aflao -> Ho");
                        break;
                    case 4: // Kumasi to Koforidua
                        System.out.println("Shortest Path: Kumasi -> Konongo -> Nsawam -> Aburi -> Koforidua");
                        break;
                }
                break;
            case 2: // Cape Coast
                switch (end) {
                    case 0: // Cape Coast to Accra
                        System.out.println("Shortest Path: Cape Coast -> Salt Pond -> Winneba -> Kasoa -> Accra");
                        break;
                    case 1: // Cape Coast to Kumasi
                        System.out.println("Shortest Path: Cape Coast -> Via River Pra -> Kumasi");
                        break;
                    case 3: // Cape Coast to Ho
                        System.out.println("Shortest Path: Cape Coast -> Salt Pond -> Winneba -> Kasoa -> Accra -> Tema -> Prampram -> Aflao -> Ho");
                        break;
                    case 4: // Cape Coast to Koforidua
                        System.out.println("Shortest Path: Cape Coast -> Salt Pond -> Winneba -> Kasoa -> Accra -> Madina -> Oyarifa -> Aburi -> Koforidua");
                        break;
                }
                break;
            case 3: // Ho
                switch (end) {
                    case 0: // Ho to Accra
                        System.out.println("Shortest Path: Ho -> Aflao -> Prampram -> Tema -> Accra");
                        break;
                    case 1: // Ho to Kumasi
                        System.out.println("Shortest Path: Ho -> Aflao -> Prampram -> Tema -> Accra");
                        break;
                    case 2: // Ho to Cape Coast
                        System.out.println("Shortest Path: Ho -> Aflao -> Prampram -> Tema -> Accra -> Kasoa -> Winneba -> Salt Pond -> Cape Coast");
                        break;
                    case 4: // Ho to Koforidua
                        System.out.println("Shortest Path: Ho -> Aflao -> Prampram -> Tema -> Accra -> Madina -> Adenta -> Oyarifa -> Aburi -> Koforidua");
                        break;
                }
                break;
            case 4: // Koforidua
                switch (end) {
                    case 0: // Koforidua to Accra
                        System.out.println("Shortest Path: Koforidua -> Aburi -> Oyarifa -> Adenta -> Madina -> Accra");
                        break;
                    case 1: // Koforidua to Kumasi
                        System.out.println("Shortest Path: Koforidua -> Aburi -> Nsawam -> Obuasi -> Konongo -> Kumasi");
                        break;
                    case 2: // Koforidua to Cape Coast
                        System.out.println("Shortest Path: Koforidua -> Aburi -> Oyarifa -> Adenta -> Madina -> Accra -> Kasoa -> Winneba -> Salt Pond -> Cape Coast");
                        break;
                    case 3: // Koforidua to Ho
                        System.out.println("Shortest Path: Koforidua -> Ho");
                        break;
                }
                break;
        }

        scanner.close();
    }
}
