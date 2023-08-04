package ZeroOneKnapSack;

public class _4minSubsetSumDifference {
    public static int dpSubsetSum(int[] weight, boolean[][]t, int sum,int size){
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
        int len = ((sum));
        int[] res = new int[len];

        for (int j = 0 ; j < len ; j++){
            if (t[size][j] == true){
                res[j] = j;
            }
        }
        for (int j = 0 ; j < len ; j++){
            System.out.print(res[j] + ",");
        }
//        int min = 0;
//        for (int i=0; i < res.length; i++){
//            min = Math.max(min, res[i]);
//        }
        int min = Integer.MAX_VALUE;
//        System.out.println(min);

        for (int i=0; i < res.length; i++){
            min = Math.min(min, Math.abs( sum -(2 *res[i]) ));
            if (min == 0){
                return min;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] weight = {-36,36};
        int sum = 0;
        int size = weight.length;

        for (int i:weight){
            sum += i;
        }
        boolean[][] t = new boolean[size + 1][sum + 1];

        for (int i=0;i<size+1;i++) {
            for (int j = 0; j < sum + 1; j++) {
                t[i][j] = false;
            }
        }
        System.out.println(dpSubsetSum(weight, t, sum, size));

//        for (int i=0;i<size+1;i++) {
//            for (int j = 0; j < sum + 1; j++) {
//                System.out.print(t[i][j] + ",");
//            }
//            System.out.println(" ");
//        }
    }
}
