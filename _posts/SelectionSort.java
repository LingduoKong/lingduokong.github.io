import java.util.Arrays;

class SelectionSort {

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 7, 5, 6, 4, 22, 0, -1};
        SelectionSort selectionSort = new SelectionSort();
        int[] result = selectionSort.result(test);
        System.out.println(Arrays.toString(result));
    }

    public int[] result(int[] input) {
        if (input == null || input.length == 0) {
            return input;
        }
        for (int i = 0; i < input.length; i++) {
            int minIndex = i;
            for (int j = i; j < input.length; j++) {
                if (input[j] < input[minIndex]) {
                    minIndex = j;
                }
            }
            swap(input, i, minIndex);
        }
        return input;
    }

    private void swap(int[] input, int left, int right) {
        int temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }
}
