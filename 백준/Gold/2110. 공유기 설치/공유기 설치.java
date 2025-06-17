import java.io.*;
import java.util.*;

import static java.lang.Math.max;

public class Main {
    static int[] pos;
    static int N, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        pos = new int[N];
        for(int i = 0; i < N; i++){
            pos[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(pos);

        int left = 1; // 집 사이의 최소 거리
        int right = pos[N - 1] - pos[0]; // 집 사이의 최대 거리
        int res = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            if(check(mid)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(res);
    }

    private static boolean check(int distance){
        int cnt = 1;
        int last = pos[0];

        for(int i = 1; i < N; i++){
            if(pos[i] - last >= distance) {
                cnt++;
                last = pos[i];
                if(cnt >= C) return true;
            }
        }

        return false;

    }
}
