

//         0/1 Knapsack MAXIMUM PROFIT  Recursive        //


package ZeroOneKnapSack;

import java.util.Arrays;

public class RecursiveKnapsack {
//    static int[][] t = new int[8][29];

     static int recursiveKnapsack(int[] weight, int[] val, int capacity, int size){
//     static int recursiveKnapsack(int[] weight, int[] val, int capacity, int size){
        if (size == 0 || capacity == 0) {
            return 0;
        }
        else if (weight[size - 1] <= capacity) {
            return  Math.max(val[size - 1] + recursiveKnapsack(weight, val, capacity - weight[size - 1], size - 1),
                    recursiveKnapsack(weight, val, capacity, size - 1));
        }
        else {
            return recursiveKnapsack(weight, val, capacity, size - 1);
        }
    }

    public static void main(String[] args) {
        int[] weight = {1,2,3,4,5,6,7};
        int[] value =  {7,6,5,4,3,2,1};
        int capacity = 28;
        int size = weight.length;

        System.out.println(recursiveKnapsack(weight, value, capacity, size));

    }
}