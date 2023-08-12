package MatrixChainMultiplication;

public class _3PalindromePartitioningRecursive {
    public static int palindromPartitioning(String str, int i, int j){
        if (i >= j){
            return 0;
        }
        if (isPalindrom(str, i, j) == true){
            return 0;
        }
        int min = Integer.MAX_VALUE;

        for (int k=i; k < j; k++){
            int temp = palindromPartitioning(str,i,k) + palindromPartitioning(str, k+1, j) + 1;

            min = Math.min(min, temp);
        }
        return min;
    }
    public static boolean isPalindrom(String str, int i, int j){
        while (i < j){
            if (str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            }
            else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "ababbbabbababa";
        int j = str.length()-1;

        System.out.println(palindromPartitioning(str, 0, j));
//        System.out.println(isPalindrom(str, 0, j));
    }
}
