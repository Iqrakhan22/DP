package LongestCommonSubsequence;

public class _10LongestRepeatingSubsequence {
    public static int longestRepeatingSubsequence(String str1, String str2, int[][] t, int len){
        for (int i=0;i < len+1; i++){
            for (int j=0; j < len+1; j++){
                if (i==0 || j==0){
                    t[i][j] = 0;
                }
                else if (str1.charAt(i-1) == str2.charAt(j-1) && i!=j){
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else {
                    t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
                }
            }
        }
        return t[len][len];
    }
    public static void main(String[] args) {
        String str = "AABCBDD";      //Input
        String str2 = str;        //Solution

        int[][] t = new int[str.length()+1][str2.length()+1];
        System.out.println(longestRepeatingSubsequence(str, str2, t, str.length()) );

    }
}
