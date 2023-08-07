// Count minimum no of coins to make a given sum

package UnboundedKnapsack;

import static java.lang.Integer.MAX_VALUE;

public class _2CoinChangeMinNoCoins {
    public static int minNoCoins(int[] coin,int[][] t, int sum, int size){
        for (int i=0;i<sum+1;i++){
            t[0][i] = MAX_VALUE-1;
        }
        for(int i=1;i<size+1;i++){
            t[i][0] = 0;
        }
        for (int i=1;i<sum+1;i++){
            if (i % coin[0] != 0){
                t[1][i] = MAX_VALUE-1;
            }
            else {
                t[1][i] = i/coin[0];
            }
        }

        for (int i= 2;i < size+1;i++){
            for (int j=1; j < sum+1; j++){
                if (coin[i-1] <= j){
                    t[i][j] = Math.min(1+t[i][j-coin[i-1]], t[i-1][j]);
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[size][sum];
    }
    public static void main(String[] args) {
        // how many minimum no of coins will require to make the sum.
        // Here there is only one element require to make sum that is 6.

        int[] coin = {1,2,3,6,4};
        int sum = 6;
        int size = coin.length;

        int[][] t = new int[size+1][sum+1];
        for (int i=0;i<size+1;i++){
            for (int j=0;j<sum+1;j++){
                t[i][j] = -1;
            }
        }

        for (int i=0;i<size+1;i++){
            for (int j=0;j<sum+1;j++){
                System.out.print(t[i][j] + " ,  ");
            }
            System.out.println(" ");
        }

        System.out.println(minNoCoins(coin, t, sum, size));


        for (int i=0;i<size+1;i++){
            for (int j=0;j<sum+1;j++){
                System.out.print(t[i][j] + "  ,  ");
            }
            System.out.println(" ");
        }
    }
}
