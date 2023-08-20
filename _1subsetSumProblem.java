package ZeroOneKnapSack;

public class _1subsetSumProblem {
    public static int recursiveSubsetSum(int[] weight, int sum, int size){
        int num;
        if (sum == 0 || size == 0){
            return 0;
        }
        else if (weight[size-1] <= sum){
            return Math.max(weight[size - 1] + recursiveSubsetSum(weight, sum - weight[size-1],size-1 ),
                    recursiveSubsetSum(weight,sum,size-1));
        }
        else {return recursiveSubsetSum(weight, sum, size-1);}
    }

    public static int SubsetSumMemoization(int[] weight, int[][]t, int sum,int size){
        if (sum == 0 || size == 0){
            return 0;
        }
        else if (t[size][sum] != -1){
            return t[size][sum];
        }
        else if (weight[size-1] <= sum){
            return t[size][sum] = Math.max(weight[size-1] + SubsetSumMemoization(weight, t, sum - weight[size-1],size - 1),
                    SubsetSumMemoization(weight, t, sum, size-1));
        }
        else {
            return t[size][sum] = SubsetSumMemoization(weight, t, sum,size-1);
        }
    }
    public static boolean dpSubsetSum(int[] weight, boolean[][]t, int sum,int size){
        t[0][0] = true;
        for(int i = 1; i < sum+1; i++)
            t[0][i] = false;
        for (int i = 1; i < size + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if(j == 0){
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
    public static void main(String[] args) {
        int[] weight = {2,3,7,8,10};
        int sum = 30;
        int size = weight.length;
        boolean[][] t = new boolean[size + 1][sum + 1];

        for (int i=0;i<size+1;i++) {
            for (int j = 0; j < sum + 1; j++) {
                t[i][j] = true;
            }
        }

//        int num = (recursiveSubsetSum(weight, sum, size));       //RECURSIVE
//        int num = (SubsetSumMemoization(weight, t, sum, size));  //MEMOIZATION
        System.out.println(dpSubsetSum(weight, t, sum, size));     // DYNAMIC PROGRAMMING  return boolean directly


        for (int i=0;i<size+1;i++) {
            for (int j = 0; j < sum + 1; j++) {
                System.out.print(t[i][j] + ",");
            }
            System.out.println(" ");
        }

//        System.out.println(num);
//        if (num == sum){
//            System.out.println("True");
//        }
//        else
//            System.out.println("False");
    }
}




