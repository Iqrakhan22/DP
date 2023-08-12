package MatrixChainMultiplication;

import java.util.Arrays;

public class MCMMemoization {
    static int[][] t = new int[100][100];
    public static int MCMMemoization(int[] arr, int i, int j){
        if (i >= j){
            return 0;
        }
        if (t[i][j] != -1)
        {
            return t[i][j];
        }
        t[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++)
        {
            t[i][j] = Math.min(
                    t[i][j], MCMMemoization(arr, i, k)
                            + MCMMemoization(arr,k + 1, j)
                            + arr[i - 1] * arr[k] * arr[j]);
        }
        return t[i][j];
    }

    public static void main(String[] args) {
        int[] arr = {40,20,30,10,30};
        int len = arr.length;
        int j = len-1;

        for (int[] i : t){
            Arrays.fill(i, -1);
        }
        System.out.println(MCMMemoization(arr,1, j));
    }
}
