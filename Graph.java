import java.util.*;

public class Graph {

    private final Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new LinkedHashMap<>();
    }

    public boolean addVertex(int vertex) {
        if (adjacencyList.containsKey(vertex)) {
            return false;
        }

        adjacencyList.put(vertex, new ArrayList<>());
        return true;
    }

    public boolean addEdge(int source, int destination) {
        if (!adjacencyList.containsKey(source) ||
            !adjacencyList.containsKey(destination)) {

            System.out.println("Both vertices must exist before adding an edge.");
            return false;
        }

        if (source == destination) {
            System.out.println("Self-loop is not allowed.");
            return false;
        }

        if (adjacencyList.get(source).contains(destination)) {
            System.out.println("Edge already exists.");
            return false;
        }

        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);

        return true;
    }

    public void display() {
        if (adjacencyList.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }

        System.out.println("Adjacency List:");

        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public TraversalResult bfs(int start) {
        long startTime = System.nanoTime();

        List<Integer> order = new ArrayList<>();
        Set<Integer> visited = new LinkedHashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();

        int steps = 0;

        visited.add(start);
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            order.add(current);
            steps++;

            for (int neighbor : adjacencyList.get(current)) {
                steps++;

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        long endTime = System.nanoTime();

        return new TraversalResult(order, steps, endTime - startTime);
    }

    public TraversalResult dfs(int start) {
        long startTime = System.nanoTime();

        List<Integer> order = new ArrayList<>();
        Set<Integer> visited = new LinkedHashSet<>();
        int[] steps = {0};

        dfsRecursive(start, visited, order, steps);

        long endTime = System.nanoTime();

        return new TraversalResult(order, steps[0], endTime - startTime);
    }

    private void dfsRecursive(
            int current,
            Set<Integer> visited,
            List<Integer> order,
            int[] steps) {

        visited.add(current);
        order.add(current);
        steps[0]++;

        for (int neighbor : adjacencyList.get(current)) {
            steps[0]++;

            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited, order, steps);
            }
        }
    }

    public GraphSearchResult bfsSearch(int start, int target) {
        long startTime = System.nanoTime();

        List<Integer> order = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();

        int steps = 0;

        visited.add(start);
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            order.add(current);
            steps++;

            if (current == target) {
                long endTime = System.nanoTime();

                return new GraphSearchResult(
                        true,
                        order,
                        steps,
                        endTime - startTime
                );
            }

            for (int neighbor : adjacencyList.get(current)) {
                steps++;

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        long endTime = System.nanoTime();

        return new GraphSearchResult(
                false,
                order,
                steps,
                endTime - startTime
        );
    }

    public boolean containsVertex(int vertex) {
        return adjacencyList.containsKey(vertex);
    }

    public int vertexCount() {
        return adjacencyList.size();
    }
}
