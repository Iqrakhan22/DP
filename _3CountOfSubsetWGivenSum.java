package ZeroOneKnapSack;

public class _3CountOfSubsetWGivenSum {

    public static int countSubsetSumRecursion(int[] weight, int sum, int size){
        if (sum == 0) {
            return 1;
        }
        else if( size == 0){
            return 0;
        }
        else if (weight[size-1] <= sum) {
            int x = countSubsetSumRecursion(weight, sum-weight[size-1],size-1)
                    + countSubsetSumRecursion(weight,sum,size-1);
            return x;
        }
        else {
            return countSubsetSumRecursion(weight, sum,size-1);
        }
    }

    public static int countSubsetSumMemoization(int[] weight, int[][] t, int sum, int size){
//        t[0][0] = 1;
        if (sum == 0){
           return  1;
        } else if (size == 0 ) {
            return 0;
        } else if (t[size][sum] != -1) {
            return t[size][sum];
        }
        else if (weight[size-1] <= sum) {
            return t[size][sum] = countSubsetSumMemoization(weight, t, sum-weight[size-1], size-1) +
                    countSubsetSumMemoization(weight, t, sum, size-1);
        }
        else {
            return t[size][sum] =  countSubsetSumMemoization(weight, t, sum, size-1);
        }
    }
    public static int countSubsetSumDP(int[] weight, int[][] t, int sum, int size){
        t[0][0] = 1;
        for(int i = 1; i <= sum; i++)
            t[0][i] = 0;
        for (int i = 1; i < size + 1; i++){
            for (int j = 0; j < sum + 1; j++){
                if (j == 0){
                    t[i][j] = 1;
                }
                else if (weight[i-1] <= j){
                    t[i][j] = t[i-1][j-weight[i-1]] + t[i-1][j];
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[size][sum];
    }
    public static void main(String[] args) {
//        int[] weight = {2,3,5,6,8,10};
        int[] weight = {1, 2, 3, 3};
        int sum = 6;
        int size = weight.length;
        int[][] t = new int[size+1][sum+1];

        for (int i=0;i<size+1;i++) {
            for (int j = 0; j < sum + 1; j++) {
                t[i][j] = -1;
            }
        }
        System.out.println(countSubsetSumDP(weight, t, sum,size));

        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                System.out.print(t[i][j] + " , ");
            }
            System.out.println();
        }
    }
}
