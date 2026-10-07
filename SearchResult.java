public class SearchResult {
    private final boolean found;
    private final int index;
    private final int steps;
    private final long timeNanos;

    public SearchResult(boolean found, int index, int steps, long timeNanos) {
        this.found = found;
        this.index = index;
        this.steps = steps;
        this.timeNanos = timeNanos;
    }

    public boolean isFound() {
        return found;
    }

    public int getIndex() {
        return index;
    }

    public int getSteps() {
        return steps;
    }

    public long getTimeNanos() {
        return timeNanos;
    }
}
