package LongestCommonSubsequence;

public class PrintLCSubsequence {
    public static String subsequence(String s1, String s2, int[][] t, int len1, int len2){
        String str = "";
        for (int i=0; i < len1+1; i++){
            for (int j=0; j < len2 + 1; j++){
                if (i==0 || j==0){
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
        return printStr(s1,s2,t,len1,len2);
    }
    public static String printStr(String s1, String s2, int[][] t, int len1, int len2){
        String str = "";
        while (len1 > 0 && len2 > 0){
            if (s1.charAt(len1 - 1) == s2.charAt(len2 - 1)) {

//                System.out.println(s1.charAt(i - 1) + "," + s2.charAt(j - 1));

                str = str + s1.charAt(len1 - 1);
//                System.out.println(str);
                len1--;
                len2--;
            }
            else {
                if (t[len1 - 1][len2] > t[len1][len2 - 1]) {
                    len1--;
                }
                else {
                    len2--;
                }
            }
        }
        return str;
    }
    public static String reverseStr(String str){
        int size = str.length();
        String revStr = "";
        for (int i = size-1;i>=0; i--){
//            System.out.println(str.charAt(i));
            revStr = revStr + str.charAt(i);
        }
        return revStr;
    }
    public static void main(String[] args) {
        String s1 = "abcdaf";
        String s2 = "acbcf";
        int len1 =s1.length();
        int len2 = s2.length();

        int[][] t = new int[len1+1][len2+1];


        String str = subsequence(s1, s2, t, len1, len2) ;
        System.out.println(reverseStr(str));

//        for(int i = 0 ; i < len1 + 1 ; i++){
//            for (int j = 0 ; j < len2 + 1 ; j++){
//                System.out.print(t[i][j] + ",");
//            }
//            System.out.println(" ");
//        }
    }
}
