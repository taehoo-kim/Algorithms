import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10];
        while(N > 0) {
            int idx = N % 10;
            arr[idx]++;
            N /= 10;
        }
        int res = 1;
        int sum = arr[6] + arr[9];
        if(sum % 2 == 0) {
            sum /= 2;
        }
        else {
            sum /= 2;
            sum++;
        }

        for(int i = 0; i < arr.length; i++) {
            if(i == 6 || i == 9) continue;
            if(res < arr[i]) res = arr[i];
        }

        if(res < sum) res = sum;

        System.out.println(res);
    }

}
