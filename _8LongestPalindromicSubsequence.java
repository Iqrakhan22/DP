//Input only one string given find longest palindromic subsequence
//example :  agbcba
//output  :   abcba


package LongestCommonSubsequence;

public class _8LongestPalindromicSubsequence {
    public static int LCSubsequence(String str1, String str2, int[][] t, int len1,int len2){
        for (int i=0; i < len1+1; i++){
            for (int j=0; j < len2+1; j++){
                if (i==0 || j==0){
                    t[i][j] = 0;
                }
                else if (str1.charAt(i-1) == str2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else {
                    t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
                }
            }
        }
        return t[len1][len2];
    }
    public static void main(String[] args) {
        String str = "agbcba";
        int len = str.length();
//        String str2 = "";
        StringBuilder str2 = new StringBuilder();

        for (int i=str.length()-1; i>=0; i--){
//            System.out.println(i);
//            str2 = str2+str.charAt(i);
            str2.append(str.charAt(i));
        }
        System.out.println(str2);

        int[][] t = new int[len+1][len+1];
        System.out.println(LCSubsequence(str, String.valueOf(str2), t, len, len));

        for (int i=0; i < len+1; i++) {
            for (int j = 0; j < len + 1; j++) {
                System.out.print(t[i][j] + ",");
            }
            System.out.println("");
        }
    }
}
