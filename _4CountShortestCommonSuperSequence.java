package LongestCommonSubsequence;

public class _4CountShortestCommonSuperSequence {
    public static int LCSubsequence(String s1, String s2, int len1, int len2) {
        if (len1 == 0 || len2 == 0){
            return 0;
        }
        else if (s1.charAt(len1-1) == s2.charAt(len2-1)){
            return 1+LCSubsequence(s1,s2,len1-1,len2-1);
        }
        else {
            return Math.max(LCSubsequence(s1,s2,len1,len2-1), LCSubsequence(s1,s2,len1-1,len2));
        }
    }
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        int len1 = s1.length();
        int len2 = s2.length();

        int commonSubsequence = LCSubsequence(s1,s2,len1,len2);
        int modifiedLen1 = len1 - commonSubsequence;
        int modifiedLen2 = len2 - commonSubsequence;

        System.out.println(commonSubsequence+modifiedLen1+modifiedLen2);
    }
}
