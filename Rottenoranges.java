import java.util.*;

public class Solution {

    static int m, n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int time = 0;

        while (true) {

            boolean changed = false;

            int[][] temp = new int[m][n];

            for (int i = 0; i < m; i++) {
                temp[i] = grid[i].clone();
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    if (grid[i][j] == 2) {

                        if (i > 0 && grid[i - 1][j] == 1) {
                            temp[i - 1][j] = 2;
                            changed = true;
                        }

                        if (i < m - 1 && grid[i + 1][j] == 1) {
                            temp[i + 1][j] = 2;
                            changed = true;
                        }

                        if (j > 0 && grid[i][j - 1] == 1) {
                            temp[i][j - 1] = 2;
                            changed = true;
                        }

                        if (j < n - 1 && grid[i][j + 1] == 1) {
                            temp[i][j + 1] = 2;
                            changed = true;
                        }
                    }
                }
            }

            grid = temp;

            if (!changed)
                break;

            time++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    System.out.println(-1);
                    sc.close();
                    return;
                }
            }
        }

        System.out.println(time);

        sc.close();
    }
}
