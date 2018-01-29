//source: http://www.programming-algorithms.net/article/40270/Shaker-sort

public class ShakerSorter {
    private ShakerSorter() {
        port = new SortPort();
    }

    private static ShakerSorter instance = new ShakerSorter();

    public SortPort port;

    /**
     * Shaker sort (bidirectional bubble sort)
     * Orders in descending order
     *
     * @param array array to be sorted
     */
    private void _sort(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            boolean swapped = false;
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    swapped = true;
                }
            }
            for (int j = array.length - 2 - i; j > i; j--) {
                if (array[j] > array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static ShakerSorter getInstance() {
        return instance;
    }

    public class SortPort implements ISorter {
        public void sort(int[] array) {
            _sort(array);
        }
    }
}