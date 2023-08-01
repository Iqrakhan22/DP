package ZeroOneKnapSack;

public class practice {
    public static boolean canPartition(int[] nums) {
            int size = nums.length;
            int sum =0;
            for (int i=0;i < size; i++){
                sum = sum + nums[i];
            }
            int sum1 = sum/2;

            if(sum % 2 != 0){
                return false;
            }
            else{
                return Subsetsum(nums, new boolean[size+1][sum1+1], sum1, sum, size);
            }
    }
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int size = nums.length;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
        }
        int sum1 = sum/k;
        if (sum % k != 0){
            return false;
        }
        else{
            boolean x = Subsetsum(nums, new boolean[size+1][sum1+1], sum1, sum, size);
            return x;
        }
    }
    public static boolean Subsetsum(int[] nums, boolean[][] t, int sum1, int sum, int size){
        for(int i=0; i < size + 1; i++){
            for(int j=0; j < sum1 + 1; j++){
                if( i == 0){
                    t[i][j] = false;
                }
                else if ( j == 0){
                    t[i][j] = true;
                }
                else if(nums[i-1] <= j){
                    t[i][j] = t[i-1][j-nums[i-1]] || t[i-1][j] ;
                }
                else{
                    t[i][j] = t[i-1][j] ;
                }
            }
        }
        System.out.println(size + "," + sum1);
        return t[size][sum1-1];
    }

    public static void main(String[] args) {
        int[] weight = {4,3,2,3,5,2,1};
        int size = weight.length;
        int k = 4;
        boolean[][] t =new boolean[size+1][k+1];
        System.out.println(canPartitionKSubsets(weight, k));


        for(int i=0; i < 7 + 1; i++) {
            for (int j = 0; j < 4 + 1; j++) {
                System.out.print(t[i][j] + ",");
            }
            System.out.println();
        }
//        System.out.println(t[7][4]);
    }
}
