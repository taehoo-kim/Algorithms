import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int prev = 0;
        int cnt = 1;

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        for(int i = 0; i < M; i++) {
            int curr = Integer.parseInt(br.readLine());
            int gap = curr - prev - 1;
            if (gap > 0) {
                cnt *= dp[gap];
            }
            prev = curr;
        }

        int lastGap = N - prev;
        if (lastGap > 0) {
            cnt *= dp[lastGap];
        }

        System.out.println(cnt);
    }
}
