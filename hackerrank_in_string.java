import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String word = "hackerrank";

        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            if (j < word.length() && s.charAt(i) == word.charAt(j)) {
                j++;
            }
        }

        if (j == word.length())
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
