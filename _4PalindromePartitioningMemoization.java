package MatrixChainMultiplication;

import java.util.Arrays;

public class _4PalindromePartitioningMemoization {
    static int[][] t = new int[1001][1001];

    public static int palindromPartitioningMemoization(String str, int i, int j) {
        if (i >= j || ispalindrom(str, i, j) == true) {
            return 0;
        } else if (t[i][j] != -1) {
            return t[i][j];
        }
        int min = Integer.MAX_VALUE - 1;
        for (int k = i; k < j; k++) {
            int temp = palindromPartitioningMemoization(str, i, k) + palindromPartitioningMemoization(str, k + 1, j) + 1;
//            int left, right;
//
//            if(palindromPartitioningMemoization(str, i, k) != -1){
//                left= t[i][k];
//            }
//            else {
//                left = palindromPartitioningMemoization(str, i, k);
//                t[i][k] = left;
//            }
//            if (palindromPartitioningMemoization(str, k+1, j) != -1){
//                right = t[k+1][j];
//            }
//            else{
//                right = palindromPartitioningMemoization(str, k+1, j);
//                t[k+1][j] = right;
//            }
//            int temp = 1+ left +right;

            min = Math.min(min, temp);
//            t[i][j] = min;
        }
        return t[i][j] = min;
    }

    public static boolean ispalindrom(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "aabcaa";
        int j = str.length()-1;

        for (int[] i:t){
            Arrays.fill(i,-1);
        }

        System.out.println(palindromPartitioningMemoization(str, 0, j));
        System.out.println(ispalindrom(str, 0, j));
    }
}
