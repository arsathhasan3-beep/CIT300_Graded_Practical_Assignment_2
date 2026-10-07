import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final InputHelper input = new InputHelper(scanner);

    private static final ArrayManager arrayManager =
            new ArrayManager(100);

    private static final StackManager stackManager =
            new StackManager(50);

    private static final QueueManager queueManager =
            new QueueManager(50);

    private static final LinkedListManager linkedListManager =
            new LinkedListManager();

    private static final Graph graph =
            new Graph();

    private static final List<String> resultHistory =
            new ArrayList<>();

    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        while (true) {
            printHeader("DATA STRUCTURE & GRAPH ANALYZER");

            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Complexity Reference");
            System.out.println("0. Exit");

            int choice = input.readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> arrayMenu();
                case 2 -> stackMenu();
                case 3 -> queueMenu();
                case 4 -> linkedListMenu();
                case 5 -> searchingMenu();
                case 6 -> graphMenu();
                case 7 -> performanceMenu();
                case 8 -> displayAllResults();
                case 9 -> displayComplexityReference();

                case 0 -> {
                    System.out.println(
                            "\nThank you for using the Data Structure & Graph Analyzer."
                    );
                    return;
                }

                default ->
                        System.out.println("Invalid choice.");
            }

            input.pause();
        }
    }

    // =========================================================
    // ARRAY MENU
    // =========================================================

    private static void arrayMenu() {
        while (true) {
            printHeader("ARRAY OPERATIONS");

            System.out.println("1. Insert at End");
            System.out.println("2. Insert at Position");
            System.out.println("3. Delete by Value");
            System.out.println("4. Search");
            System.out.println("5. Display");
            System.out.println("6. Return to Main Menu");

            int choice = input.readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> {
                    int value =
                            input.readInt("Enter value: ");

                    if (arrayManager.insertAtEnd(value)) {
                        System.out.println(
                                "Value inserted successfully."
                        );

                        record(
                                "Array: inserted " + value
                        );
                    }
                }

                case 2 -> {
                    int value =
                            input.readInt("Enter value: ");

                    int position =
                            input.readInt(
                                    "Enter position (0 to "
                                            + arrayManager.size()
                                            + "): "
                            );

                    if (arrayManager.insertAtPosition(
                            position,
                            value)) {

                        System.out.println(
                                "Value inserted successfully."
                        );

                        record(
                                "Array: inserted "
                                        + value
                                        + " at position "
                                        + position
                        );
                    }
                }

                case 3 -> {
                    int value =
                            input.readInt(
                                    "Enter value to delete: "
                            );

                    if (arrayManager.deleteByValue(value)) {
                        System.out.println(
                                "Value deleted successfully."
                        );

                        record(
                                "Array: deleted " + value
                        );
                    } else {
                        System.out.println(
                                "Value not found."
                        );
                    }
                }

                case 4 -> {
                    int target =
                            input.readInt(
                                    "Enter value to search: "
                            );

                    SearchResult result =
                            arrayManager.search(target);

                    printSearchResult(
                            "Array Linear Search",
                            target,
                            result
                    );
                }

                case 5 ->
                        arrayManager.display();

                case 6 -> {
                    return;
                }

                default ->
                        System.out.println("Invalid choice.");
            }

            input.pause();
        }
    }

    // =========================================================
    // STACK MENU
    // =========================================================

    private static void stackMenu() {
        while (true) {
            printHeader("STACK OPERATIONS");

            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");

            int choice =
                    input.readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> {
                    int value =
                            input.readInt(
                                    "Enter value to push: "
                            );

                    if (stackManager.push(value)) {
                        System.out.println(
                                "Value pushed successfully."
                        );

                        record(
                                "Stack: pushed " + value
                        );
                    }
                }

                case 2 -> {
                    Integer value =
                            stackManager.pop();

                    if (value != null) {
                        System.out.println(
                                "Popped value: " + value
                        );

                        record(
                                "Stack: popped " + value
                        );
                    }
                }

                case 3 -> {
                    Integer value =
                            stackManager.peek();

                    if (value != null) {
                        System.out.println(
                                "Top value: " + value
                        );
                    }
                }

                case 4 ->
                        stackManager.display();

                case 5 -> {
                    return;
                }

                default ->
                        System.out.println("Invalid choice.");
            }

            input.pause();
        }
    }

    // =========================================================
    // QUEUE MENU
    // =========================================================

    private static void queueMenu() {
        while (true) {
            printHeader("QUEUE OPERATIONS");

            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek / Front");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");

            int choice =
                    input.readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> {
                    int value =
                            input.readInt(
                                    "Enter value to enqueue: "
                            );

                    if (queueManager.enqueue(value)) {
                        System.out.println(
                                "Value enqueued successfully."
                        );

                        record(
                                "Queue: enqueued " + value
                        );
                    }
                }

                case 2 -> {
                    Integer value =
                            queueManager.dequeue();

                    if (value != null) {
                        System.out.println(
                                "Dequeued value: " + value
                        );

                        record(
                                "Queue: dequeued " + value
                        );
                    }
                }

                case 3 -> {
                    Integer value =
                            queueManager.peek();

                    if (value != null) {
                        System.out.println(
                                "Front value: " + value
                        );
                    }
                }

                case 4 ->
                        queueManager.display();

                case 5 -> {
                    return;
                }

                default ->
                        System.out.println("Invalid choice.");
            }

            input.pause();
        }
    }

    // =========================================================
    // LINKED LIST MENU
    // =========================================================

    private static void linkedListMenu() {
        while (true) {
            printHeader("LINKED LIST OPERATIONS");

            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete by Value");
            System.out.println("4. Search");
            System.out.println("5. Display");
            System.out.println("6. Return to Main Menu");

            int choice =
                    input.readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> {
                    int value =
                            input.readInt("Enter value: ");

                    linkedListManager
                            .insertAtBeginning(value);

                    System.out.println(
                            "Value inserted successfully."
                    );

                    record(
                            "Linked List: inserted "
                                    + value
                                    + " at beginning"
                    );
                }

                case 2 -> {
                    int value =
                            input.readInt("Enter value: ");

                    linkedListManager
                            .insertAtEnd(value);

                    System.out.println(
                            "Value inserted successfully."
                    );

                    record(
                            "Linked List: inserted "
                                    + value
                                    + " at end"
                    );
                }

                case 3 -> {
                    int value =
                            input.readInt(
                                    "Enter value to delete: "
                            );

                    if (linkedListManager
                            .deleteByValue(value)) {

                        System.out.println(
                                "Value deleted successfully."
                        );

                        record(
                                "Linked List: deleted "
                                        + value
                        );
                    } else {
                        System.out.println(
                                "Value not found."
                        );
                    }
                }

                case 4 -> {
                    int target =
                            input.readInt(
                                    "Enter value to search: "
                            );

                    SearchResult result =
                            linkedListManager
                                    .search(target);

                    printSearchResult(
                            "Linked List Search",
                            target,
                            result
                    );
                }

                case 5 ->
                        linkedListManager.display();

                case 6 -> {
                    return;
                }

                default ->
                        System.out.println("Invalid choice.");
            }

            input.pause();
        }
    }

    // =========================================================
    // SEARCHING MENU
    // =========================================================

    private static void searchingMenu() {
        while (true) {
            printHeader("SEARCHING OPERATIONS");

            System.out.println(
                    "Current Array: "
                            + Arrays.toString(
                            arrayManager.toArray()
                    )
            );

            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println(
                    "3. Compare Linear vs Binary Search"
            );
            System.out.println(
                    "4. Return to Main Menu"
            );

            int choice =
                    input.readInt("Enter your choice: ");

            switch (choice) {
                case 1 ->
                        performLinearSearch();

                case 2 ->
                        performBinarySearch();

                case 3 ->
                        PerformanceAnalyzer
                                .compareSearchAlgorithms(
                                        arrayManager,
                                        input
                                );

                case 4 -> {
                    return;
                }

                default ->
                        System.out.println("Invalid choice.");
            }

            input.pause();
        }
    }

    private static void performLinearSearch() {
        if (arrayManager.size() == 0) {
            System.out.println(
                    "Array is empty."
            );
            return;
        }

        int target =
                input.readInt(
                        "Enter target value: "
                );

        SearchResult result =
                SearchAlgorithms.linearSearch(
                        arrayManager.toArray(),
                        target
                );

        printSearchResult(
                "Linear Search",
                target,
                result
        );

        record(
                "Linear Search: target="
                        + target
                        + ", steps="
                        + result.getSteps()
        );
    }

    private static void performBinarySearch() {
        if (arrayManager.size() == 0) {
            System.out.println(
                    "Array is empty."
            );
            return;
        }

        int target =
                input.readInt(
                        "Enter target value: "
                );

        int[] sorted =
                arrayManager.toArray();

        Arrays.sort(sorted);

        System.out.println(
                "Sorted Array: "
                        + Arrays.toString(sorted)
        );

        SearchResult result =
                SearchAlgorithms.binarySearch(
                        sorted,
                        target
                );

        printSearchResult(
                "Binary Search",
                target,
                result
        );

        record(
                "Binary Search: target="
                        + target
                        + ", steps="
                        + result.getSteps()
        );
    }

    // =========================================================
    // GRAPH MENU
    // =========================================================

    private static void graphMenu() {
        while (true) {
            printHeader("GRAPH OPERATIONS");

            System.out.println(
                    "Graph Representation: Adjacency List"
            );

            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println(
                    "6. Search Vertex using BFS"
            );
            System.out.println(
                    "7. Return to Main Menu"
            );

            int choice =
                    input.readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> {
                    int vertex =
                            input.readInt(
                                    "Enter vertex number: "
                            );

                    if (graph.addVertex(vertex)) {
                        System.out.println(
                                "Vertex added successfully."
                        );

                        record(
                                "Graph: added vertex "
                                        + vertex
                        );
                    } else {
                        System.out.println(
                                "Vertex already exists."
                        );
                    }
                }

                case 2 -> {
                    int source =
                            input.readInt(
                                    "Enter source vertex: "
                            );

                    int destination =
                            input.readInt(
                                    "Enter destination vertex: "
                            );

                    if (graph.addEdge(
                            source,
                            destination)) {

                        System.out.println(
                                "Edge added successfully."
                        );

                        record(
                                "Graph: added edge "
                                        + source
                                        + " -- "
                                        + destination
                        );
                    }
                }

                case 3 ->
                        graph.display();

                case 4 ->
                        performBFS();

                case 5 ->
                        performDFS();

                case 6 ->
                        searchGraphUsingBFS();

                case 7 -> {
                    return;
                }

                default ->
                        System.out.println("Invalid choice.");
            }

            input.pause();
        }
    }

    private static void performBFS() {
        Integer start =
                getValidGraphStartVertex();

        if (start == null) {
            return;
        }

        TraversalResult result =
                graph.bfs(start);

        printTraversalResult(
                "BFS",
                result
        );

        record(
                "BFS: order="
                        + result.getOrder()
                        + ", steps="
                        + result.getSteps()
        );
    }

    private static void performDFS() {
        Integer start =
                getValidGraphStartVertex();

        if (start == null) {
            return;
        }

        TraversalResult result =
                graph.dfs(start);

        printTraversalResult(
                "DFS",
                result
        );

        record(
                "DFS: order="
                        + result.getOrder()
                        + ", steps="
                        + result.getSteps()
        );
    }

    private static void searchGraphUsingBFS() {
        Integer start =
                getValidGraphStartVertex();

        if (start == null) {
            return;
        }

        int target =
                input.readInt(
                        "Enter target vertex: "
                );

        GraphSearchResult result =
                graph.bfsSearch(
                        start,
                        target
                );

        System.out.println(
                "Visited Order : "
                        + result.getVisitedOrder()
        );

        System.out.println(
                "Found         : "
                        + result.isFound()
        );

        System.out.println(
                "Steps         : "
                        + result.getSteps()
        );

        System.out.println(
                "Time (ns)     : "
                        + result.getTimeNanos()
        );

        record(
                "Graph BFS Search: target="
                        + target
                        + ", found="
                        + result.isFound()
        );
    }

    private static Integer getValidGraphStartVertex() {
        if (graph.vertexCount() == 0) {
            System.out.println(
                    "Graph is empty."
            );
            return null;
        }

        int start =
                input.readInt(
                        "Enter starting vertex: "
                );

        if (!graph.containsVertex(start)) {
            System.out.println(
                    "Starting vertex does not exist."
            );
            return null;
        }

        return start;
    }

    // =========================================================
    // PERFORMANCE MENU
    // =========================================================

    private static void performanceMenu() {
        while (true) {
            printHeader(
                    "PERFORMANCE / COMPLEXITY ANALYSIS"
            );

            System.out.println(
                    "1. Compare Linear vs Binary Search"
            );

            System.out.println(
                    "2. Compare BFS vs DFS"
            );

            System.out.println(
                    "3. Run Both Comparisons"
            );

            System.out.println(
                    "4. Return to Main Menu"
            );

            int choice =
                    input.readInt("Enter your choice: ");

            switch (choice) {
                case 1 ->
                        PerformanceAnalyzer
                                .compareSearchAlgorithms(
                                        arrayManager,
                                        input
                                );

                case 2 ->
                        PerformanceAnalyzer
                                .compareGraphTraversals(
                                        graph,
                                        input
                                );

                case 3 -> {
                    PerformanceAnalyzer
                            .compareSearchAlgorithms(
                                    arrayManager,
                                    input
                            );

                    System.out.println();

                    PerformanceAnalyzer
                            .compareGraphTraversals(
                                    graph,
                                    input
                            );
                }

                case 4 -> {
                    return;
                }

                default ->
                        System.out.println(
                                "Invalid choice."
                        );
            }

            input.pause();
        }
    }

    // =========================================================
    // DISPLAY ALL RESULTS
    // =========================================================

    private static void displayAllResults() {
        printHeader("DISPLAY ALL RESULTS");

        System.out.println("[ARRAY]");
        arrayManager.display();

        System.out.println("\n[STACK]");
        stackManager.display();

        System.out.println("\n[QUEUE]");
        queueManager.display();

        System.out.println("\n[LINKED LIST]");
        linkedListManager.display();

        System.out.println("\n[GRAPH]");
        graph.display();

        System.out.println(
                "\n[RECENT OPERATION HISTORY]"
        );

        if (resultHistory.isEmpty()) {
            System.out.println(
                    "No recorded operations."
            );
        } else {
            int start =
                    Math.max(
                            0,
                            resultHistory.size() - 15
                    );

            for (int i = start;
                 i < resultHistory.size();
                 i++) {

                System.out.println(
                        (i + 1)
                                + ". "
                                + resultHistory.get(i)
                );
            }
        }
    }

    // =========================================================
    // COMPLEXITY REFERENCE
    // =========================================================

    private static void displayComplexityReference() {
        printHeader("COMPLEXITY REFERENCE");

        System.out.printf(
                "%-30s %-18s%n",
                "Operation",
                "Complexity"
        );

        System.out.println(
                "------------------------------------------------"
        );

        System.out.printf(
                "%-30s %-18s%n",
                "Array Access",
                "O(1)"
        );

        System.out.printf(
                "%-30s %-18s%n",
                "Array Search",
                "O(n)"
        );

        System.out.printf(
                "%-30s %-18s%n",
                "Stack Push/Pop",
                "O(1)"
        );

        System.out.printf(
                "%-30s %-18s%n",
                "Queue Enqueue/Dequeue",
                "O(1)"
        );

        System.out.printf(
                "%-30s %-18s%n",
                "Linked List Search",
                "O(n)"
        );

        System.out.printf(
                "%-30s %-18s%n",
                "Linear Search",
                "O(n)"
        );

        System.out.printf(
                "%-30s %-18s%n",
                "Binary Search",
                "O(log n)"
        );

        System.out.printf(
                "%-30s %-18s%n",
                "BFS",
                "O(V + E)"
        );

        System.out.printf(
                "%-30s %-18s%n",
                "DFS",
                "O(V + E)"
        );
    }

    // =========================================================
    // HELPERS
    // =========================================================

    private static void printSearchResult(
            String algorithm,
            int target,
            SearchResult result) {

        System.out.println(
                "\nAlgorithm : " + algorithm
        );

        System.out.println(
                "Target    : " + target
        );

        System.out.println(
                "Found     : " + result.isFound()
        );

        System.out.println(
                "Index     : "
                        + (
                        result.isFound()
                                ? result.getIndex()
                                : "N/A"
                )
        );

        System.out.println(
                "Steps     : "
                        + result.getSteps()
        );

        System.out.println(
                "Time (ns) : "
                        + result.getTimeNanos()
        );
    }

    private static void printTraversalResult(
            String algorithm,
            TraversalResult result) {

        System.out.println(
                "\nAlgorithm : " + algorithm
        );

        System.out.println(
                "Order     : "
                        + result.getOrder()
        );

        System.out.println(
                "Steps     : "
                        + result.getSteps()
        );

        System.out.println(
                "Time (ns) : "
                        + result.getTimeNanos()
        );
    }

    private static void printHeader(String title) {
        System.out.println();

        System.out.println(
                "=================================================="
        );

        System.out.println(
                " " + title
        );

        System.out.println(
                "=================================================="
        );
    }

    private static void record(String message) {
        resultHistory.add(message);
    }

}
