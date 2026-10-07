public class SearchAlgorithms {

    public static SearchResult linearSearch(int[] data, int target) {
        long startTime = System.nanoTime();
        int steps = 0;

        for (int i = 0; i < data.length; i++) {
            steps++;

            if (data[i] == target) {
                long endTime = System.nanoTime();
                return new SearchResult(true, i, steps, endTime - startTime);
            }
        }

        long endTime = System.nanoTime();
        return new SearchResult(false, -1, steps, endTime - startTime);
    }

    public static SearchResult binarySearch(int[] sortedData, int target) {
        long startTime = System.nanoTime();

        int low = 0;
        int high = sortedData.length - 1;
        int steps = 0;

        while (low <= high) {
            steps++;

            int mid = low + (high - low) / 2;

            if (sortedData[mid] == target) {
                long endTime = System.nanoTime();
                return new SearchResult(true, mid, steps, endTime - startTime);
            }

            if (sortedData[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        long endTime = System.nanoTime();
        return new SearchResult(false, -1, steps, endTime - startTime);
    }
}
