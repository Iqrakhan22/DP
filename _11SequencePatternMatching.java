//package LongestCommonSubsequence;
//
//public class _11SequencePatternMatching {
//    public static void main(String[] args) {
//        String s1 = "axyr";
//        String  s2 = "dacxiury";
//        int flag =0;
//        int token = 0;
//
//        for (int i = 0; i <s1.length();i++){
//            for (int j=flag; j < s2.length(); j++){
//                System.out.print(j + " , ");
//                if (s1.charAt(i) == s2.charAt(j)){
////                    System.out.println(j);
//                    token++;
//                    flag = j;
//                    break;
//                }
//            }
//            System.out.println(" ");
//        }
//        System.out.println("Token :  " + token);
//        if (token == s1.length()){
//            System.out.println("true");
//        }
//        else System.out.println("false");
//    }
//}



package LongestCommonSubsequence;

public class _11SequencePatternMatching {
    public static boolean patternMatching(String s1, String s2,int[][] t, int len1, int len2){
        for (int i=0; i < len1+1; i++){
            for (int j=0; j < len2+1; j++){
                if (i==0 || j==0){
                    t[i][j] = 0;
                }
                else if (s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = 1+ t[i-1][j-1];
                }
                else {
                    t[i][j] = Math.max(t[i-1][j] , t[i][j-1] );
                }
            }
        }
        int lenSubsequence = t[len1][len2];

        if (lenSubsequence == len1){
            return true;
        }
        else
            return false;
    }

    public static void main(String[] args) {
        String a = "adxy";
        String b = "aadxcpy";    //Input

        int len1 = a.length(), len2 = b.length();

        int[][] t = new int[len1+1][len2+1];

        System.out.println(patternMatching(a, b, t, len1, len2) );

//        for (int i=0; i < len1+1; i++) {
//            for (int j = 0; j < len2 + 1; j++) {
//                System.out.print(t[i][j] + " , ");
//            }
//            System.out.println(" ");
//        }
    }
}
