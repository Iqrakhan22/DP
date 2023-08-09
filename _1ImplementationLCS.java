package LongestCommonSubsequence;

public class _1ImplementationLCS {
    public static int recursiveLCS(String s1, String s2, int len1, int len2){
        if (len1 == 0 || len2==0){
            return 0;
        }
        else if (s1.charAt(len1-1) == s2.charAt(len2-1)) {
            return (1 + recursiveLCS(s1, s2,len1-1,len2-1));
        }
        else {
            return Math.max(recursiveLCS(s1, s2, len1, len2-1), recursiveLCS(s1, s2,len1-1, len2));
        }
    }
    public static int MemoizationLCS(String s1, String s2, int[][] t, int len1, int len2){

        if (len1==0 || len2==0){
            return t[len1][len2] = 0;
        }
        else if (t[len1][len2] != -1) {
            return t[len1][len2];
        }
        else if (s1.charAt(len1-1) == s2.charAt(len2-1)) {
            return t[len1][len2] = 1 + MemoizationLCS(s1, s2, t, len1-1, len2-1);
        }
        else {
            return t[len1][len2] = Math.max(MemoizationLCS(s1, s2, t, len1, len2-1), MemoizationLCS(s1, s2, t, len1-1, len2));
        }
    }
    public static int DynamicPLCS(String s1, String s2, int[][] t, int len1, int len2){
                for (int i = 0 ; i < len1 + 1; i++){
            for (int j = 0 ; j < len2 + 1 ; j++){
                if (i == 0 || j == 0){
                    t[i][j] = 0;
                }
                else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else {
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }
        return t[len1][len2];
    }
    public static void main(String []args){
        String s1=" AGGTAB";
        String s2 = " GXTXAYB";
        int len1 = s1.length(); int len2 = s2.length();

//        System.out.println(len1 + "," + len2);

        int[][] t= new int[len1+1][len2+1];
        for (int i=0;i<len1+1;i++){
            for (int j=0;j<len2+1;j++){
                t[i][j] = -1;
            }
        }

        System.out.println(recursiveLCS(s1, s2, len1, len2));
        System.out.println(MemoizationLCS(s1, s2, t, len1, len2));
        System.out.println(DynamicPLCS(s1, s2, t, len1, len2));


        for (int i=0;i<len1+1;i++){
            for (int j=0;j<len2+1;j++){
                System.out.print(t[i][j] + ",");
            }
            System.out.println(" ");
        }
    }
}
