import java.util.*;

public class Solution {

    static int findGCD(int a, int b) {
        if (b == 0)
            return a;

        return findGCD(b, a % b);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int t = sc.nextInt();

        sc.close();

        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        int gcd = findGCD(a, b);

        if (t > a || t % gcd != 0) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
