

package LongestCommonSubsequence;

public class _5PrintShortestCommonSupersequence {
    public static void LCSubsequenceMatrix(String str1, String str2, int[][] t, int len1, int len2){
        for (int i=0; i < len1+1; i++) {
            for (int j = 0; j < len2 + 1; j++) {
                if (i==0 || j==0){
                    t[i][j] = 0;
                }
                else if (str1.charAt(i-1) == str2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
    }
    public static StringBuilder PrintSupersequence(String str1, String str2, int[][] t, int len1, int len2){
        StringBuilder strBuilder = new StringBuilder();
        int i = len1, j=len2;
        while (i > 0 && j > 0){
            if (str1.charAt(i-1) == str2.charAt(j-1)) {
                strBuilder.append(str1.charAt(i - 1));
                i--;   j--;
            }
            else if (t[i][j-1] < t[i-1][j]){
                strBuilder.append(str1.charAt(i-1));
                i--;
            }
            else if(t[i][j-1] >= t[i-1][j]){
                strBuilder.append(str2.charAt(j-1));
                j--;
            }
        }
        while (i>0){
            strBuilder.append(str1.charAt(i-1));
            i--;
        }
        while (j > 0){
            strBuilder.append(str2.charAt(j-1));
            j--;
        }
        return strBuilder.reverse();
    }
    public static void main(String[] args) {
        String str1 = "abcrsd", str2 = "lkfcbc";
        int len1 = str1.length(), len2 = str2.length();
        int[][] t = new int[len1+1][len2+1];

        for (int i=0; i < len1+1; i++){
            for (int j=0; j < len2+1; j++){
                t[i][j] = -1;
            }
        }

        LCSubsequenceMatrix(str1, str2, t, len1, len2);
        String s = String.valueOf(PrintSupersequence(str1, str2, t, len1, len2));
        System.out.println(s+" , "+s.length());
    }
}



//package LongestCommonSubsequence;
//
//public class _5PrintShortestCommonSupersequence {
//    static int[][] dp;
//
//    static int lcs(String str1, String str2, int n, int m) {
//        for(int i=1; i<=n; i++){
//            for(int j=1; j<=m; j++){
//                if(str1.charAt(i-1)==str2.charAt(j-1)){
//                    dp[i][j] = dp[i-1][j-1]+1;
//                }
//                else{
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//                }
//            }
//        }
//        return dp[n][m];
//    }
//
//    // method to get Shortest Supersequence
//    static String scs(String s1, String s2) {
//        StringBuilder sb = new StringBuilder();
//        int i=s1.length(), j=s2.length();
//
//        // traversing back the path which we used to get LCS
//        while(i>0 && j>0){
//            if(s1.charAt(i-1)==s2.charAt(j-1)){
//                sb.append(s1.charAt(i-1));
//                i--;
//                j--;
//            }
//            else if(dp[i-1][j]>dp[i][j-1]){
//                sb.append(s1.charAt(i-1));
//                i--;
//            }
//            else if(dp[i-1][j]<=dp[i][j-1]){
//                sb.append(s2.charAt(j-1));
//                j--;
//            }
//        }
//        while(i>0){
//            sb.append(s1.charAt(i-1));
//            i--;
//        }
//        while(j>0){
//            sb.append(s2.charAt(j-1));
//            j--;
//        }
//        return sb.reverse()+"";
//    }
//    public static String shortestCommonSupersequence(String str1, String str2) {
//        int n=str1.length(), m=str2.length();
//        dp = new int[n+1][m+1];
//        for(int i=0; i<n; i++) dp[i][0] = 0;
//        for(int j=0; j<m; j++) dp[0][j] = 0;
//        lcs(str1, str2, n, m);
//        return scs(str1, str2);
//    }
//
//    public static void main(String[] args) {
////        String str1 = "abac", str2 = "cab";
//        String str1 = "AGGTAB";
//        String str2 = "GXTXAYB";
//        System.out.println(shortestCommonSupersequence(str1, str2));
//    }
//}
