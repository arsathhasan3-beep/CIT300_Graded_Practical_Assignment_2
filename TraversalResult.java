import java.util.List;

public class TraversalResult {
    private final List<Integer> order;
    private final int steps;
    private final long timeNanos;

    public TraversalResult(List<Integer> order, int steps, long timeNanos) {
        this.order = order;
        this.steps = steps;
        this.timeNanos = timeNanos;
    }

    public List<Integer> getOrder() {
        return order;
    }

    public int getSteps() {
        return steps;
    }

    public long getTimeNanos() {
        return timeNanos;
    }
}
