import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][2];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N + 2];
        for(int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            if(arr[i][0] + i > N + 1) continue;
            dp[i + arr[i][0]] = Math.max(dp[i] + arr[i][1], dp[i + arr[i][0]]);
        }
        int res = 0;
        for(int i = 1; i <= N + 1; i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.print(res);

    }
}