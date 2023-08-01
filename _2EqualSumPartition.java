package ZeroOneKnapSack;

public class _2EqualSumPartition {
    public static int equalSumPartition(int[] arr,int[][] t, int sum,int size){
        if (sum == 0 || size == 0){
            return 0;
        }
        else if (t[size][sum] != -1){
            return t[size][sum];
        }
        else if (arr[size-1] <= sum){
            return t[size][sum] = Math.max(arr[size-1] + equalSumPartition(arr, t, sum - arr[size-1],size - 1),
                    equalSumPartition(arr, t, sum, size-1));
        }
        else {
            return t[size][sum] = equalSumPartition(arr, t, sum,size-1);
        }
    }
    public static void main(String[] args) {
//        int[] arr = {1,5,11,5};
        int[] arr ={4,3,2,3,5,2,1};
        int k = 4;
        int sum = 9;
        int size = arr.length;

        int[][] t =new int[size+1][sum+1];

        for (int i=0;i<size+1;i++) {
            for (int j = 0; j < sum + 1; j++) {
                t[i][j] = -1;
            }
        }
        int num = equalSumPartition(arr, t, sum, size);
        for (int i=0;i<size+1;i++) {
            for (int j = 0; j < sum + 1; j++) {
                System.out.print(t[i][j] + ",");
            }
            System.out.println("");
        }

        int sum1 = 0;
        for (int i=0;i<size;i++){
            sum1 = sum1 +arr[i];
        }

        if(sum1 % 2 != 0){
            System.out.println("false");
        }
        else if (sum1 == 2*num){
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}
