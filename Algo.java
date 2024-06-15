import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Algo {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is an app that helps you in your sorting or searching endeavours.");
        System.out.println("Choose whether you want to search or sort and then choose the algorithm you want to use");
        System.out.println("Type 1 to search and 2 to sort and hit enter:");
        System.out.println("1: Search");
        System.out.println("2: Sort");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("One Selected");
                chooseSearchAlgorithm(scanner);
                break;
            case 2:
                System.out.println("Two Selected");
                chooseSortAlgorithm(scanner);

                break;
            default:
                System.out.println("Invalid choice");
        }
        scanner.close();
    }

    private static void chooseSearchAlgorithm(Scanner scanner) {
        System.out.println("Choose the search algorithm you want to use:");
        System.out.println("1: Linear Search");
        System.out.println("2: Binary Search");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                linearSearch();
                System.out.println("The time complexity of this algorithm is O(n)");
                break;
            case 2:
                binarySearch();
                System.out.println("The time complexity of this algorithm is O(logn)");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static void chooseSortAlgorithm(Scanner scanner) {
        System.out.println("Choose the sorting algorithm you want by typing the number and hit enter:");
        System.out.println("1: Bubble Sort Algorithm");
        System.out.println("2: Selection Sort Algorithm");
        System.out.println("3: Insertion Sort Algorithm");
        System.out.println("4: Nearly Sorted Sort Algorithm");
        System.out.println("5: Shell Sort Algorithm");
        System.out.println("6: Quick Sort Algorithm");
        System.out.println("7: Merge Sort Algorithm");
        System.out.println("8: Radix Sort Algorithm");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                bubbleSort();
                break;
            case 2:
                selectionSort();
                break;
            case 3:
                insertionSort();
                break;
            case 4:
                nearlySorted();
                break;
            case 5:
                shellSort();
                break;
            case 6:
                quickSort();
                break;
            case 7:
                mergeSort();
                break;
            case 8:
                radixSort();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void linearSearch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is the Linear Search Algorithm");
        System.out.println("Enter the size of the list:");
        int size = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        System.out.println("Enter the elements of the list:");
        for (int i = 0; i < size; i++) {
            list.add(scanner.nextInt());
        }

        System.out.println("Enter the value to search:");
        int searchValue = scanner.nextInt();

        long startTime = System.nanoTime();
        int result = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == searchValue) {
                result = i;
                break;
            }
        }
        long endTime = System.nanoTime();

        System.out.println("Search result: " + (result == -1 ? "Not found" : "Found at index " + result));
        System.out.println("Running time: " + (endTime - startTime) + " nanoseconds");
    }

    public static void binarySearch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is the Binary Search Algorithm");

        System.out.println("Enter the size of the list:");
        int size = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        System.out.println("Enter the elements of the list (in sorted order):");
        for (int i = 0; i < size; i++) {
            list.add(scanner.nextInt());
        }

        System.out.println("Enter the value to search:");
        int searchValue = scanner.nextInt();

        long startTime = System.nanoTime();
        int result = binarySearch(list, searchValue);
        long endTime = System.nanoTime();

        System.out.println("Search result: " + (result == -1 ? "Not found" : "Found at index " + result));
        System.out.println("Running time: " + (endTime - startTime) + " nanoseconds");
        System.out.println("The time complexity of this algorithm is O(log n).");
    }

    public static int binarySearch(List<Integer> list, int searchValue) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) == searchValue) {
                return mid;
            }

            if (list.get(mid) < searchValue) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void bubbleSort() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("This is the Bubble Sort Algorithm");
        System.out.println("Enter the size of the list:");
        int size = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        System.out.println("Enter the elements of the list:");
        for (int i = 0; i < size; i++) {
            list.add(scanner.nextInt());
        }

        long startTime = System.nanoTime();
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        long endTime = System.nanoTime();

        System.out.println("Sorted list: " + list);
        System.out.println("Running time: " + (endTime - startTime) + " nanoseconds");
        System.out.println("The time complexity of this algorithm is O(n^2)");
    }

    public static void insertionSort() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("This is the Insertion Sort Algorithm");
        System.out.println("Enter the size of the list:");
        int size = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        System.out.println("Enter the elements of the list:");
        for (int i = 0; i < size; i++) {
            list.add(scanner.nextInt());
        }

        long startTime = System.nanoTime();
        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
        long endTime = System.nanoTime();

        System.out.println("Sorted list: " + list);
        System.out.println("Running time: " + (endTime - startTime) + " nanoseconds");
        System.out.println("The time complexity of this algorithm is O(n^2)");
    }

    public static void nearlySorted() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("This is the Nearly Sorted Sort Algorithm");
        System.out.println("Enter the size of the list:");
        int size = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        System.out.println("Enter the elements of the list:");
        for (int i = 0; i < size; i++) {
            list.add(scanner.nextInt());
        }

        long startTime = System.nanoTime();
        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
        long endTime = System.nanoTime();

        System.out.println("Sorted list: " + list);
        System.out.println("Running time: " + (endTime - startTime) + " nanoseconds");
        System.out.println("The time complexity of this algorithm is O(n^2)");
    }

    public static void quickSort() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("This is the Quick Sort Algorithm");
        System.out.println("Enter the size of the list:");
        int size = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        System.out.println("Enter the elements of the list:");
        for (int i = 0; i < size; i++) {
            list.add(scanner.nextInt());
        }

        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

        long startTime = System.nanoTime();
        quickSortHelper(arr, 0, arr.length - 1);
        long endTime = System.nanoTime();

        List<Integer> sortedList = Arrays.stream(arr).boxed().collect(Collectors.toList());

        System.out.println("Sorted list: " + sortedList);
        System.out.println("Running time: " + (endTime - startTime) + " nanoseconds");
        System.out.println("The time complexity of this algorithm is O(n^2)");
    }

    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortHelper(arr, low, pi - 1);
            quickSortHelper(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    public static void radixSort() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("This is the Radix Sort Algorithm");
        System.out.println("Enter the size of the list:");
        int size = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        System.out.println("Enter the elements of the list:");
        for (int i = 0; i < size; i++) {
            list.add(scanner.nextInt());
        }

        long startTime = System.nanoTime();

        // Find the maximum number to determine the number of digits
        int max = Integer.MIN_VALUE;
        for (int num : list) {
            if (num > max) {
                max = num;
            }
        }

        // Apply counting sort for each digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(list, exp);
        }

        long endTime = System.nanoTime();

        System.out.println("Sorted list: " + list);
        System.out.println("Running time: " + (endTime - startTime) + " nanoseconds");
        System.out.println("The time complexity of this algorithm is O(nk)");
    }

    private static void countingSort(List<Integer> list, int exp) {
        int n = list.size();
        List<Integer> output = new ArrayList<>(n);
        int[] count = new int[10];

        // Initialize count array
        for (int i = 0; i < 10; i++) {
            count[i] = 0;
        }

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(list.get(i) / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains the actual
        // position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output.add(list.get(i));
        }

        for (int i = n - 1; i >= 0; i--) {
            list.set(count[(output.get(i) / exp) % 10] - 1, output.get(i));
            count[(output.get(i) / exp) % 10]--;
        }
    }

    public static void mergeSort() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("This is the Merge Sort Algorithm");
        System.out.println("Enter the size of the list:");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter the elements of the list:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        long startTime = System.nanoTime();
        mergeSort(arr, 0, arr.length - 1);
        long endTime = System.nanoTime();

        System.out.println("Sorted list: " + Arrays.toString(arr));
        System.out.println("Running time: " + (endTime - startTime) + " nanoseconds");
        System.out.println("The time complexity of this algorithm is O(nlogn)");
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void shellSort() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("This is the Shell Sort Algorithm");
        System.out.println("Enter the size of the list:");
        int size = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        System.out.println("Enter the elements of the list:");
        for (int i = 0; i < size; i++) {
            list.add(scanner.nextInt());
        }

        long startTime = System.nanoTime();
        int n = list.size();
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = list.get(i);
                int j = i;
                while (j >= gap && list.get(j - gap) > temp) {
                    list.set(j, list.get(j - gap));
                    j -= gap;
                }
                list.set(j, temp);
            }
        }
        long endTime = System.nanoTime();

        System.out.println("Sorted list: " + list);
        System.out.println("Running time: " + (endTime - startTime) + " nanoseconds");
        System.out.println("The time complexity of this algorithm is O(n^2)");
    }

    public static void selectionSort() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selection Sort Algorithm");
        System.out.println("Enter the size of the list:");
        int size = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        System.out.println("Enter the elements of the list:");
        for (int i = 0; i < size; i++) {
            list.add(scanner.nextInt());
        }

        long startTime = System.nanoTime();
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
        long endTime = System.nanoTime();

        System.out.println("Sorted list: " + list);
        System.out.println("Running time: " + (endTime - startTime) + " nanoseconds");
        System.out.println("The time complexity of this algorithm is O(n^2)");
    }




}
