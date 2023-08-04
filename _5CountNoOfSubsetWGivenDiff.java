package ZeroOneKnapSack;
public class _5CountNoOfSubsetWGivenDiff {
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
        int[] arr = {10,2,10,9,1,6,8,9,2,8};
        int difference = 5;
        int size = arr.length;
        int totalSum = 0;
        for (int i:arr){
            totalSum += i;
        }
//        System.out.println(totalSum);
        int sum = (difference + totalSum )/2;
//        int sum2 = sum1 + difference;
        System.out.println(sum);
        int[][] t = new int[size+1][sum+1];
        System.out.println(countSubsetSumDP(arr, t, sum ,size));

    }
    public int countKDifference(int[] nums, int k) {
        int count =0;

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if((Math.abs(nums[i]-nums[j])) == k){
                    count++;
                }
            }
        }
        return count;
    }
}
