import java.util.Arrays;

public class PerformanceAnalyzer {

    public static void compareSearchAlgorithms(ArrayManager arrayManager, InputHelper input) {
        if (arrayManager.size() == 0) {
            System.out.println("Array is empty. Add values first.");
            return;
        }

        int target = input.readInt("Enter target value: ");

        int[] original = arrayManager.toArray();
        int[] sorted = Arrays.copyOf(original, original.length);

        Arrays.sort(sorted);

        SearchResult linear =
                SearchAlgorithms.linearSearch(original, target);

        SearchResult binary =
                SearchAlgorithms.binarySearch(sorted, target);

        System.out.println("\n==================================================");
        System.out.println(" SEARCH PERFORMANCE COMPARISON");
        System.out.println("==================================================");

        System.out.printf(
                "%-20s %-10s %-10s %-15s%n",
                "Algorithm",
                "Found",
                "Steps",
                "Time (ns)"
        );

        System.out.println("--------------------------------------------------");

        System.out.printf(
                "%-20s %-10s %-10d %-15d%n",
                "Linear Search",
                linear.isFound(),
                linear.getSteps(),
                linear.getTimeNanos()
        );

        System.out.printf(
                "%-20s %-10s %-10d %-15d%n",
                "Binary Search",
                binary.isFound(),
                binary.getSteps(),
                binary.getTimeNanos()
        );

        System.out.println("\nOriginal Array: " + Arrays.toString(original));
        System.out.println("Sorted Array  : " + Arrays.toString(sorted));

        System.out.println("\nComplexity:");
        System.out.println("Linear Search : O(n)");
        System.out.println("Binary Search : O(log n)");
        System.out.println("Binary Search requires sorted data.");
    }

    public static void compareGraphTraversals(Graph graph, InputHelper input) {
        if (graph.vertexCount() == 0) {
            System.out.println("Graph is empty.");
            return;
        }

        int start = input.readInt("Enter starting vertex: ");

        if (!graph.containsVertex(start)) {
            System.out.println("Vertex does not exist.");
            return;
        }

        TraversalResult bfs = graph.bfs(start);
        TraversalResult dfs = graph.dfs(start);

        System.out.println("\n==================================================");
        System.out.println(" GRAPH TRAVERSAL PERFORMANCE COMPARISON");
        System.out.println("==================================================");

        System.out.printf(
                "%-12s %-12s %-10s %-15s%n",
                "Algorithm",
                "Visited",
                "Steps",
                "Time (ns)"
        );

        System.out.println("--------------------------------------------------");

        System.out.printf(
                "%-12s %-12d %-10d %-15d%n",
                "BFS",
                bfs.getOrder().size(),
                bfs.getSteps(),
                bfs.getTimeNanos()
        );

        System.out.printf(
                "%-12s %-12d %-10d %-15d%n",
                "DFS",
                dfs.getOrder().size(),
                dfs.getSteps(),
                dfs.getTimeNanos()
        );

        System.out.println("\nBFS Order: " + bfs.getOrder());
        System.out.println("DFS Order: " + dfs.getOrder());

        System.out.println("\nComplexity:");
        System.out.println("BFS : O(V + E)");
        System.out.println("DFS : O(V + E)");
    }
}
