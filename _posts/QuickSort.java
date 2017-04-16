import java.util.Arrays;

class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] test = new int[]{0, 2, -1, 22, 31, -12, -5, 51, 32};
        int[] result = quickSort.result(test);
        System.out.println(Arrays.toString(result));
    }
    public int[] result(int[] input) {
        if (input == null || input.length == 0) {
            return input;
        }
        quickSort(input, 0, input.length - 1);
        return input;
    }

    private void quickSort(int[] input, int left, int right) {
        if (left >= right) {
            return;
        }
        if (left + 1 == right) {
            if (input[left] > input[right]) {
                swap(input, left, right);
            }
            return;
        }
        int start = left;
        int end = right - 1;
        int pivot = right;
        while (start <= end) {
            if (input[start] > input[pivot]) {
                swap(input, start, end);
                end--;
            } else {
                start++;
            }
        }
        swap(input, start, pivot);
        quickSort(input, left, start - 1);
        quickSort(input, start + 1, right);
    }

    private void swap(int[] input, int left, int right) {
        int temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }
}