import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = left + 1;
        int res = Integer.MAX_VALUE;
        while(left <= right && right < N)
        {
            int sub = arr[right] - arr[left];
            if(sub > M) {
                left++;
                if(res > sub) res = sub;
            }
            if(sub < M) {
                right++;
            }
            if(sub == M) {
                res = sub;
                break;
            }
        }

        System.out.println(res);

    }

}
