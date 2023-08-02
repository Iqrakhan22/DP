package ZeroOneKnapSack;

public class _4minSubsetSumDifference {
    public static int subsetDifference(int[] weight, int sum, int size){

        if (size == 0 || sum == 0){
            return 0;
        }
        else if (weight[size-1] <= sum){
            return Math.max(weight[size-1]+subsetDifference(weight,sum-weight[size-1],size-1),
                            subsetDifference(weight,sum,size-1));
        }
        else {
            return subsetDifference(weight,sum,size-1);
        }
    }

    public static void main(String[] args) {
//        int[] weight = {1,6,11,5,25,10,22,1};
        int [] weight = {1,2,42,79,24,9};
        int size = weight.length;
        int addition =0;
        for (int i=0; i < weight.length; i++){
            addition = addition + weight[i];
        }
        int sum = addition/2;
//        System.out.println(sum);
        int[][] t = new int[size+1][sum+1];
        for (int i=0;i<size+1;i++) {
            for (int j = 0; j < sum + 1; j++) {
                t[i][j] = -1;
            }
        }

//        System.out.println(subsetDifference(weight, sum, size));
        int num1 = subsetDifference(weight, sum, size);

        for (int i=0;i<addition/2;i++){
            if (sum == num1){
                int num2 = addition - num1;
//                System.out.println(num2 + "," + num1);
                System.out.println("Minimum difference is : " + Math.abs(num1-num2));
                break;
            }
            else if(sum != num1){
                sum +=1;
//                System.out.println(sum);
                num1 = (subsetDifference(weight, sum, size));
//                System.out.println(num1);
            }
        }



    }
}
