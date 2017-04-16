import java.util.Arrays;

class MergeSort {
    public static void main(String[] args) {
        int[] test = new int[]{0, 2, -1, 22, 31, -12, -5, 51, 32};
        MergeSort mergeSort = new MergeSort();
        mergeSort.result(test);
        System.out.println(Arrays.toString(test));
    }
    public int[] result(int[] input) {
        if (input == null || input.length == 0) {
            return input;
        }
        mergeSort(input, 0, input.length - 1);
        return input;
    }
    private void mergeSort(int[] input, int left, int right) {
        if (left >= right) {
            return;
        }
        if (left + 1 == right) {
            if (input[left] > input[right]) {
                int temp = input[left];
                input[left] = input[right];
                input[right] = temp;
            }
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(input, left, mid - 1);
        mergeSort(input, mid, right);
        merge(input, left, right);
    }

    private void merge(int[] input, int left, int right) {
        if (left >= right) {
            return;
        }
        int[] temp = Arrays.copyOf(input, input.length);
        int mid = left + (right - left) / 2;
        int leftStart = left, rightStart = mid, cur = left;
        while(leftStart < mid && rightStart <= right) {
            if (temp[leftStart] > temp[rightStart]) {
                input[cur] = temp[rightStart];
                rightStart++;
            } else {
                input[cur] = temp[leftStart];
                leftStart++;
            }
            cur++;
        }
        while (leftStart < mid) {
            input[cur] = temp[leftStart];
            cur++;
            leftStart++;
        }
    }
}