package LongestCommonSubsequence;

public class LCSubstringImplementation {
    static int LCSubstringRecursion(String s1, String s2, int len1, int len2, int count){

        if (len1 == 0 || len2 == 0) {
            return count;
        }

        if (s1.charAt(len1 - 1) == s2.charAt(len2 - 1)) {
            count = LCSubstringRecursion(s1, s2, len1-1, len2-1, count+1);
        }
        count = Math.max(count, Math.max(LCSubstringRecursion(s1, s2, len1, len2-1, 0),
                    LCSubstringRecursion(s1, s2, len1-1, len2, 0)) );
        return count;
    }
    public static int LCSubstringDP(String s1, String s2, int[][] t, int len1, int len2){
        int result = 0;
        for (int i=0;i < len1+1 ; i++) {
            for (int j = 0; j < len2 + 1; j++) {
                if (i == 0 || j == 0) {
                     t[i][j] = 0;
                }
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
//                    else if (s1[i - 1] == s2[j - 1]) {
//                        t[i][j]
                    t[i][j] = 1 + t[i-1][j-1];
                    result = Math.max(result, t[i][j]);
                }
                else {
                    t[i][j] = 0;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s1 = "abcdedg";
        String s2 = "gedabcd";
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] t = new int[len1+1][len2+1];

        for (int i=0;i < len1+1 ; i++) {
            for (int j = 0; j < len2 + 1; j++) {
                t[i][j] = -1;
            }
        }
        System.out.println(LCSubstringRecursion(s1, s2, len1, len2, 0));
        System.out.println( LCSubstringDP(s1, s2, t, len1, len2 ) );

        for (int i=0;i < len1+1 ; i++){
            for (int j=0; j < len2+1; j++){
                System.out.print(t[i][j] + ",");
            }
            System.out.println(" ");
        }
    }
}
