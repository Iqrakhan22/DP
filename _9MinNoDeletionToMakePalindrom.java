// minimum number of deletion of element in a string to make a string palindrom
// input : only one string is given
// example : "agbcba";
// output : integer  ex: 1

package LongestCommonSubsequence;

public class _9MinNoDeletionToMakePalindrom {
    public static int minNoDeletion(String str1, String str2, int[][] t, int len1, int len2){
        for (int i=0; i <len1+1; i++){
            for (int j=0; j <len2+1; j++){
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
        int minDeletion = len1-t[len1][len2];
        return minDeletion;
    }
    public static void main(String[] args) {
        String str = "agbcrtba";
        StringBuilder str2=new StringBuilder();

        for (int i=str.length()-1;i>=0;i--){
            str2.append(str.charAt(i));
        }
        int len =str.length();
        int[][] t = new int[len+1][len+1];

        int minDeletion = minNoDeletion(str,String.valueOf(str2),t,len,len);

        System.out.println("Min Number Of Deletion to make it a Palindrome : " + minDeletion );
    }
}
