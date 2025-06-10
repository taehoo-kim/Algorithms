import java.io.*;
import java.util.*;

public class Main {

    public static int absSum(int a, int b){
        if(a + b < 0) return -(a + b);
        else return (a + b);
    }

    static int[] arr = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int left = 0;
        int right = N - 1;

        StringBuilder sb = new StringBuilder();

        int res = 2147483647;
        int a = 0, b = 0;
        while(left < right){

            if(arr[left] + arr[right] == 0) {
                sb.append(arr[left]).append(" ").append(arr[right]);
                System.out.println(sb);
                return;
            }

            if(res > absSum(arr[left], arr[right])){
                res = absSum(arr[left], arr[right]);
                a = arr[left];
                b = arr[right];
            }

            if(arr[left] + arr[right] < 0){
                left++;
            }
            else {
                right--;
            }

        }

        sb.append(a).append(" ").append(b);
        System.out.println(sb);

    }
}