import java.io.*;
import java.util.*;

public class Binarysearch{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int dd = sc.nextInt();
        int div = sc.nextInt();

        int[] arr = new int[dd];

        for (int i = 0; i < dd; i++)
            arr[i] = i;

        int low = 0, high = dd, ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if ((long) mid * div <= dd) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
