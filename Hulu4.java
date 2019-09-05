import java.util.HashSet;
import java.util.Scanner;

public class Hulu4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int now = 0;
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        boolean justStop = false;
        for (int i = 0; i < n; i++) {
            if (n-i == k && justStop) {
                ans += k;
                break;
            }
            if (n-i == k-1 && !justStop) {
                ans += k + now;
                break;
            }
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
                now++;
                justStop = true;
                continue;
            }
            ans += now;
            now = 1;
            set.clear();
            set.add(arr[i]);
            k--;
            justStop = false;
        }

        System.out.println(ans);
    }
}
