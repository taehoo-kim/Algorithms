import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] level = new Integer[N];

        for(int i = 0; i < N; i++) {
            level[i] = Integer.parseInt(br.readLine());
        }
        int res = 0;
        for(int i = N - 2; i >= 0; i--) {
            if(level[i] >= level[i+1]) {
                res += level[i] - level[i+1] + 1;
                level[i] = level[i+1] - 1;
            }
        }


        System.out.print(res);

    }
}