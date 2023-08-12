//   Minimun number of insertion and deletion to convert string a to b
//   str1 = "heap"  str2 = "pea"
//   pheap
//   Insert P at position 0 and delete h and p .
//   Insertion = 1, Deletion = 2

package LongestCommonSubsequence;

public class _7minNoInsertion_Deletoin {
    public static void LCSubstr(String str1, String str2, int[][] t, int len1, int len2){
//        int result = 0;
        for (int i=0; i < len1+1; i++){
            for (int j=0; j < len2+1; j++){
                if (i==0 || j==0){
                    t[i][j] = 0;
                }
                else if (str1.charAt(i-1) == str2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
//                    result = Math.max(result,t[i][j]);
                }
                else {
//                    t[i][j] = 0;
                    t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
                }
            }
        }
        int result = t[len1][len2];
//        System.out.println("result : " + result);
//        System.out.println("len1 : " + len1 + "  , len2 : " + len2);

        int deletion = len1-result;
//        int newLen1 = len1 - deletion;
//        System.out.println("nwelen1 : " + newLen1 + "  , len2 : " + len2);
        int insertion = len2-result;
        System.out.println("Insertion : " + insertion + " ,  Deletion : " + deletion );
    }
    public static void main(String[] args) {
        String str1 = "geeksforgeeks", str2 = "geeks";
        int len1 = str1.length(), len2 = str2.length();
        int[][] t = new int[len1+1][len2+1];

        LCSubstr(str1, str2, t, len1, len2);
    }
}
