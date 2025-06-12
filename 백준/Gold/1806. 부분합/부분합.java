import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        int left = 0;
        int right = 0;
        int sum = arr[left];
        int res = Integer.MAX_VALUE;
        while(right < N){
            if(sum >= S) {
                if(res > right - left + 1) {
                    res = right - left + 1;
                }
                sum -= arr[left++];
            }
            else {
                if(right == N - 1) break;
                sum += arr[++right];
            }
        }

        System.out.print(res == Integer.MAX_VALUE ? 0 : res);
    }

}
