package ZeroOneKnapSack;


public class _3CountOfSubsetWGivenSum {
    public static int countSubsetSum(int[] weight, int[][] t, int sum, int size){
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
        int weight[] = {4,3,2,3,5,2,1};
        int sum = 5;
        int size = weight.length;

        int[][] t = new int[size+1][sum+1];

        for (int i=0;i<size+1;i++) {
            for (int j = 0; j < sum + 1; j++) {
                t[i][j] = 0;
            }
        }
        System.out.println(countSubsetSum(weight,t,sum,size));

        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                System.out.print(t[i][j] + ",");
            }
            System.out.println();
        }
    }
}
