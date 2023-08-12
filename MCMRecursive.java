package MatrixChainMultiplication;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MCMRecursive {
    public static int minNoOfMultiplication(int[] arr, int i, int j){
        if (i >= j){
            return 0;
        }
        int min = Integer.MAX_VALUE-1;

        for (int k = i; k < j; k++){
            int temp = minNoOfMultiplication(arr, i, k) + minNoOfMultiplication(arr, k+1, j) + (arr[i-1]*arr[j]*arr[k]);

            if (temp < min){
                min = temp;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] arr = {40,20,30,10,30};
        int len = arr.length;
        int j = len-1;

        System.out.println(minNoOfMultiplication(arr, 1, j) );
    }
}