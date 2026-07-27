import java.io.*;
import java.util.*;

public class Median {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        for (int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();

        for (int i = 0; i < m; i++)
            arr2[i] = sc.nextInt();

        int[] res = new int[n + m];

        for (int i = 0; i < n; i++)
            res[i] = arr1[i];

        for (int i = 0; i < m; i++)
            res[n + i] = arr2[i];

        Arrays.sort(res);

        int total = n + m;

        if (total % 2 != 0) {
            System.out.printf("%.1f", (double) res[total / 2]);
        } else {
            int idx = total / 2;
            double median = ((long) res[idx - 1] + (long) res[idx]) / 2.0;
            System.out.printf("%.1f", median);
        }
    }
}
