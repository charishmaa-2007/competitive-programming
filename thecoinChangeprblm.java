import java.util.*;

public class Result {

    public static long getWays(int n, List<Long> c) {

        int m = c.size();

        long[][] dp = new long[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i == 0 && j == 0)
                    dp[i][j] = 1;

                else if (i == 0)
                    dp[i][j] = 0;

                else {
                    if (c.get(i - 1) > j)
                        dp[i][j] = dp[i - 1][j];

                    else {
                        long id = j - c.get(i - 1);

                        dp[i][j] = dp[i - 1][j]
                                + dp[i][(int) id];
                    }
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Long> coins = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            coins.add(sc.nextLong());
        }

        System.out.println(getWays(n, coins));

        sc.close();
    }
}
