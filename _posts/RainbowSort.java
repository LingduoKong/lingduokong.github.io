import java.util.Arrays;

// abacbcaaba => aaaaabbbcc
class RainbowSort {

    public static void main(String[] args) {
        char[] test = new char[]{'a', 'b', 'a', 'c', 'b', 'c', 'a', 'a', 'b', 'a'};
        RainbowSort rainbowSort = new RainbowSort();
        char[] result = rainbowSort.result(test);
        System.out.println(Arrays.toString(result));
    }
    public char[] result(char[] input) {
        if (input == null || input.length <= 1) {
            return input;
        }
        int bStart = 0;
        int cStart = input.length - 1;
        int cur = 0;
        while (cur <= cStart) {
            if (input[cur] == 'a') {
                swap(input, cur, bStart);
                bStart++;
                if (cur < bStart) {
                    cur = bStart;
                }
            } else if (input[cur] == 'b') {
                cur++;
            } else {
                swap(input, cur, cStart);
                cStart--;
            }
        }
        return input;
    }

    private void swap(char[] input, int left, int right) {
        char temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }
}