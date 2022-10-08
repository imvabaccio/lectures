import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    static List<String> res = new ArrayList<String>();

    public static char[] swap(char[] arr, int x, int y) {
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

        return arr;
    }

    public List<String> find_permutation(String S) {
        char[] arr = S.toCharArray();
        backtrack(arr, 0, arr.length - 1);
        return res;
    }

    public static void backtrack(char[] arr, int start, int end) {
        if (start == end) {
            // for (char i : arr)
            // System.out.print(i);
            // System.out.println();
            res.add(Arrays.toString(arr));
            return;
        }
        for (int i = start; i <= end; i++) {
            arr = swap(arr, start, i);
            backtrack(arr, start + 1, end);
            arr = swap(arr, start, i);
        }
    }
}