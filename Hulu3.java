import org.omg.CORBA.MARSHAL;

import java.util.Scanner;

public class Hulu3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) {
                    dp[i][j] = dp[i][j-1] + arr[i][j];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + arr[i][j];
            }
        }

        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i == n-1 && j == n-1) continue;
                if (i == n-1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j+1] + arr[i][j]);
                    continue;
                }
                if (j == n-1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i+1][j] + arr[i][j]);
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i][j+1] + arr[i][j]);
                dp[i][j] = Math.min(dp[i][j], dp[i+1][j] + arr[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + arr[i][j]);
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + arr[i][j]);
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + arr[i][j]);
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + arr[i][j]);
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}
