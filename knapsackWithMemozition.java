package ZeroOneKnapSack;

import java.util.Arrays;

public class knapsackWithMemozition {
    public static int recursiveWMemozition(int[] weight,int[] val, int[][]t, int capacity, int size){
        if (size == 0 || capacity == 0){
            return 0;
        }
        else if (t[size][capacity] != -1){
            return t[size][capacity];
        }
        else if (weight[size-1] <= capacity){
            return t[size][capacity] = Math.max(val[size-1] + recursiveWMemozition(weight, val, t,capacity - weight[size-1],size-1),
                    recursiveWMemozition(weight, val, t, capacity, size-1));
        }
        else {
            return t[size][capacity] = recursiveWMemozition(weight, val, t, capacity, size-1);
        }
    }
    public static void main(String[] args) {
        int[] weight = {1,2,3,4,5,6,7};
        int[] value = {7,6,5,4,3,2,1};
        int capacity =0;
        int size = weight.length;

        int[][] t = new int[size+1][capacity+1];

        // FILL 2D ARRAY WITH SAME VALUE
        // Arrays.stream(t).forEach(row->Arrays.fill(row,-1));
        for (int i=0;i<size+1;i++){
            for (int j=0;j < capacity+1;j++){
                t[i][j] = -1;
            }
        }

        System.out.println(recursiveWMemozition(weight, value, t, capacity, size));
    }
}
