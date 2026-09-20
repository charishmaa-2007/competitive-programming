import java.util.*;

public class Solution {

    static void search(String pat, String txt) {

        int n = txt.length();
        int m = pat.length();

        
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {

            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } 
            else {
                if (len != 0) {
                    len = lps[len - 1];
                } 
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

    
        i = 0;
        int j = 0;

        while (i < n) {

            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

          
            if (j == m) {
                System.out.println(i - j);
                j = lps[j - 1];
            }

         
            else if (i < n && txt.charAt(i) != pat.charAt(j)) {

                if (j != 0) {
                    j = lps[j - 1];
                } 
                else {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String txt = sc.nextLine();
        String pat = sc.nextLine();

        search(pat, txt);
    }
}
