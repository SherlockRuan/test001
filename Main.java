import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hulu1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        int good = 0;
        int bad = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            if (arr[i] == 1) good++;
            else bad++;
        }

        int sum = 0;
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
            sum += w[i];
        }

        boolean[] can = new boolean[n];


        double ans = 0.0;
        for (int i = 0; i < n; i++) {
            double isHere = (double)w[i] / (double)sum;
            for (int j = 0; j < n; j++) {
                can[j] = true;
            }
            ans += helper(i, n, good, bad, arr, can, m) * isHere;
        }

        System.out.println(String.format("%.5f", ans));
    }

    private static double helper(int start, int n, int good, int bad, int[] a, boolean[] can, int m) {
        if (n == good) return 1;
        if (n == bad) return 0;
        int good_ = good;
        int bad_ = bad;
        int now = start;
        int M = m;
        while (m > 0) {
            if (can[now]) m--;
            if (m == 0 && can[now]) {
                can[now] = false;
                if (a[now] == 1) good_--;
                else bad_--;
            }
            now++;
            if (now == a.length) now = 0;
        }
        return helper(now, n-1, good_, bad_, a, can, M);
    }
}
