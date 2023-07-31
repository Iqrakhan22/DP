package ZeroOneKnapSack;

public class knapsackTopDown {
    public static void main(String[] args) {
        int weight[] = {1,2,3,4,5,6,7};
        int value[] = {7,6,5,4,3,2,1};
        int capacity = 1;
        int size = weight.length;

        int t[][]  = new int[size+1][capacity+1];

        for (int i=0; i < size+1;i++) {
            for (int j = 0; j < capacity + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
                else if (weight[i - 1] <= j){
                    t[i][j] = Math.max(value[i-1] + t[i-1][j - weight[i-1]], t[i-1][j]);
                }
                else {
                    t[i][j] = t[i-1][j];
                }

            }
        }

        for (int i=0; i < size+1;i++) {
            for (int j = 0; j < capacity + 1; j++) {
                System.out.print(t[i][j] + ",");
            }
            System.out.println("");
        }
        System.out.println(t[size][capacity]);
    }
}
