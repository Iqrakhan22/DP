package LongestCommonSubsequence;

public class _6PrintLongestCommonSubstring {
    public static String printLCSubStr(String str1, String str2, int[][] t, int len1, int len2){
        int len = 0;
        int row =0, column = 0;
        for (int i=0; i < len1+1; i++){
            for (int j=0; j < len2+1; j++){
                if (i==0 || j==0){
                    t[i][j] = 0;
                }
                else if (str1.charAt(i-1) == str2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                    len = t[i][j];
                    row = i;
                    column = j;
                }
                else {
                    t[i][j] = 0;
                }
            }
        }
//        System.out.println(len + "," + row + "," + column);
        StringBuilder resStr = new StringBuilder();

        if (len == 0){
            return "String does not contain any common elements ";
        }
        else {
            while (t[row][column] != 0) {
                resStr.append(str1.charAt(row-1));
                --len;
                row--;
                column--;
            }
        }
        resStr.reverse();
        return resStr.toString();
    }
    public static void main(String args[]) {
        String str1 = "Geksia";
        String str2 = "qGeksz";

        int len1 = str1.length();
        int len2 = str2.length();

        int[][] t = new int[len1+1][len2+1];
        System.out.println(printLCSubStr(str1, str2, t, len1, len2));
    }
}


//package LongestCommonSubsequence;
//
//public class _6PrintLongestCommonSubstring {
//
//    static void printLCSubStr(String X, String Y, int m, int n) {
//        int[][] LCSuff = new int[m + 1][n + 1];
//        int len = 0;
//
//        int row = 0, col = 0;
//
//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j <= n; j++) {
//                if (i == 0 || j == 0)
//                    LCSuff[i][j] = 0;
//
//                else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
//                    LCSuff[i][j] = LCSuff[i - 1][j - 1] + 1;
//                    if (len < LCSuff[i][j]) {
//                        len = LCSuff[i][j];
//                        row = i;
//                        col = j;
//                    }
//                }
//                else
//                    LCSuff[i][j] = 0;
//            }
//        }
//        System.out.println(len + " , " + row + " , " +col);
//        if (len == 0) {
//            System.out.println("No Common Substring");
//            return;
//        }
//        String resultStr = "";
//         while (LCSuff[row][col] != 0) {
//             resultStr = X.charAt(row - 1) + resultStr; // or Y[col-1]
//             --len;
//             row--;
//             col--;
//         }
//         System.out.println(resultStr);
//    }
//     public static void main(String args[]) {
//        String X = "Geksia";
//        String Y = "qGeksz";
//
//        int m = X.length();
//        int n = Y.length();
//        printLCSubStr(X, Y, m, n);
//

//         for (int i = 0; i <= m; i++) {
//             for (int j = 0; j <= n; j++) {
//                 System.out.print(LCSuff[i][j] + ",");
//             }
//             System.out.println("");
//         }
//    }
//}
