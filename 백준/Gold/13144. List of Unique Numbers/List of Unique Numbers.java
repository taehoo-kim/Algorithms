import java.io.*;
import java.util.*;

public class Main {
    static int[] freq = new int[100001];
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0;
        long res = 0;
        while (right < N) {
            freq[arr[right]]++;
            while (freq[arr[right]] > 1) {
                freq[arr[left]]--;
                left++;
            }
            res += right - left + 1;
            right++;
        }

        System.out.println(res);

    }
}
