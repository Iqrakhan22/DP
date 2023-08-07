

//Question
//  ROD Cutting problem + Unbounded Knapsack
// Rod cutting :  input = length of rod , profit array,
//                output = maximum profit
//                you can cut a rod however you want to

package UnboundedKnapsack;

public class ImplementationUKnapsack {
    public static int unboundedKnapsack(int[] weight, int[] val, int capacity, int size){
        if (size == 0 || capacity == 0){
            return 0;
        }
        else if (weight[size-1] <= capacity){
            return Math.max(val[size-1]+unboundedKnapsack(weight,val,capacity-weight[size-1], size),
                        unboundedKnapsack(weight, val, capacity, size-1));
        }
        else {
            return unboundedKnapsack(weight, val, capacity, size-1);
        }
    }
    public static int unboundedMemoization(int[] weight, int[] val, int capacity, int size){
        int[][] t = new int[size+1][capacity+1];
        for (int i=0;i<size+1;i++){
            for (int j=0;j<capacity+1;j++){
                t[i][j] = -1;
            }
        }
        if( size == 0 || capacity == 0){
            return t[size][capacity] = 0;
        }
        else if (t[size][capacity] != -1){
            return t[size][capacity];
        }
        else if (weight[size-1] <= capacity) {
            return t[size][capacity] = Math.max(val[size-1]+unboundedMemoization(weight,val,capacity-weight[size-1],size),
                                                unboundedMemoization(weight,val,capacity,size-1));
        }
        else {
            return t[size][capacity] = unboundedMemoization(weight,val,capacity,size-1);
        }
    }
    public static int unboundedTopDown(int[] weight, int[] value, int capacity, int size){
        int[][] t = new int[size+1][capacity+1];
        for (int i=0;i<size+1;i++){
            for (int j=0;j<capacity+1;j++){
                t[i][j] = -1;
            }
        }
        for (int i=0;i<size+1;i++){
            for (int j=0;j<capacity+1;j++){
                if (i == 0 || j == 0){
                    t[i][j] = 0;
                }
                else if (weight[i-1] <= j) {
                    t[i][j] = Math.max(value[i-1]+t[i][j-weight[i-1]], t[i-1][j]);
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[size][capacity];
    }
    public static void main(String[] args) {
        int[] weight = {1,2,3,4,5,6,7,8};
        int[] value = {3,5,8,9,10,17,17,20};
        int capacity = 9;
        int size = weight.length;

        System.out.println(unboundedTopDown(weight, value, capacity, size));
    }
}
