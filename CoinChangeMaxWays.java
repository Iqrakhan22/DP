package UnboundedKnapsack;

public class CoinChangeMaxWays {
    public static int coinChangeRecursive(int[] coin, int sum, int size){
        if (sum == 0) {
            return 1;
        }
        else if( size == 0){
            return 0;
        }
        else if(coin[size-1] <= sum){
            return (coinChangeRecursive(coin,sum-coin[size-1],size)) + coinChangeRecursive(coin, sum, size-1);
        }
        else {
            return coinChangeRecursive(coin, sum, size-1);
        }
    }
    public static int coinChangeMemoization(int[] coin, int sum, int size) {
        int[][] t = new int[size+1][sum+1];
        for (int i=0;i<size+1;i++){
            for (int j=0;j<sum+1;j++){
                t[i][j] = -1;
            }
        }
        if (sum == 0){
            return  1;
        } else if (size == 0 ) {
            return 0;
        }
        else if (t[size][sum] != -1) {
            return t[size][sum];
        } else if (coin[size-1] <= sum) {
            return t[size][sum] = coinChangeMemoization(coin,sum-coin[size-1],size) + coinChangeMemoization(coin,sum,size-1);
        }
        else {
            return t[size][sum] = coinChangeMemoization(coin,sum,size-1);
        }
    }

    public static int coinChangeTopDown(int[] coin, int sum, int size){
        int[][] t = new int[size+1][sum+1];
        for (int i=0;i<size+1;i++){
            for (int j=0;j<sum+1;j++){
                t[i][j] = -1;
            }
        }
        t[0][0] = 1;
        for (int i = 1;i<sum+1;i++) {
            t[0][i] = 0;
        }
        for (int i = 1 ; i < size + 1 ; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (j == 0){
                    t[i][j] = 1;
                }
                else if (coin[i-1] <= j){
                    t[i][j] = t[i][j-coin[i-1]] + t[i-1][j];
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[size][sum];
    }
    public static void main(String[] args) {
        int[] coin = {1,2,3};
        int sum = 5;
//        PRINT NO OF WAYS SO THAT THE ADDITION SHOULD BE EQUALS TO SUM WHERE YOU CAN USE EACH ELEMENT REPETEDLY.
        int size = coin.length;

        System.out.println(coinChangeTopDown(coin, sum, size));
    }
}
