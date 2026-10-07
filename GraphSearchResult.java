import java.util.List;

public class GraphSearchResult {
    private final boolean found;
    private final List<Integer> visitedOrder;
    private final int steps;
    private final long timeNanos;

    public GraphSearchResult(boolean found, List<Integer> visitedOrder, int steps, long timeNanos) {
        this.found = found;
        this.visitedOrder = visitedOrder;
        this.steps = steps;
        this.timeNanos = timeNanos;
    }

    public boolean isFound() {
        return found;
    }

    public List<Integer> getVisitedOrder() {
        return visitedOrder;
    }

    public int getSteps() {
        return steps;
    }

    public long getTimeNanos() {
        return timeNanos;
    }
}
