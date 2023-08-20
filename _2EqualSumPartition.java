package ZeroOneKnapSack;

public class _2EqualSumPartition {
    public static boolean equalSumPartitionRecursion(int[] arr, int sum, int size){
        if (size == 0){
            return false;
        }
        else if (sum == 0){
            return true;
        }
        else if (arr[size-1] <= sum){
            return equalSumPartitionRecursion(arr,sum-arr[size-1],size-1) || equalSumPartitionRecursion(arr,sum, size-1);
        }
        else if(arr[size-1] > sum){
            return equalSumPartitionRecursion(arr, sum, size-1);
        }
        else
            return false;
    }
    public static boolean equalSumPartitionmemozaition(int[] arr,boolean[][] t, int sum,int size){

        if (size == 0){
            return false;
        }
        else if (sum == 0 ){
            return true;
        }
        else if (arr[size-1] <= sum){
            return t[size][sum] = equalSumPartitionmemozaition(arr, t, sum - arr[size-1],size - 1) ||
                                    equalSumPartitionmemozaition(arr, t, sum, size-1);
        }
        else if (arr[size-1] > sum){
            return t[size][sum] = equalSumPartitionmemozaition(arr, t, sum,size-1);
        }
        return t[size][sum];
    }
    public static boolean equalSumPartitionDp(int[] weight, boolean[][]t, int sum,int size){
        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 ) {
                    t[i][j] = false;
                }
                else if(j == 0){
                    t[i][j] = true;
                }
                else if (weight[i - 1] <= j){
                    t[i][j] = t[i-1][j - weight[i-1]] || t[i-1][j];
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[size][sum];
    }

    public static boolean equalSumPartitionBoolean(int[] arr,boolean[][] t, int sum1, int sum,int size){
        if(sum1 % 2 != 0){
            return false;
        }
        else {
//            return equalSumPartitionRecursion(arr, sum, size);
//            return equalSumPartitionmemozaition(arr, t, sum, size);
            return equalSumPartitionDp(arr, t, sum, size);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        int size = arr.length;
        int sum1 =0;
        for (int i=0;i<size;i++){
            sum1 = sum1 +arr[i];
        }
        int sum = sum1/2;

        boolean[][] t = new boolean[size+1][sum+1];

        for (int i=0;i<size+1;i++) {
            for (int j = 0; j < sum + 1; j++) {
                t[i][j] = false;
            }
        }

        System.out.println(equalSumPartitionBoolean(arr, t, sum1, sum, size));
    }
}
