import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < N; i++){
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        int[] arr = new int[N];
        int idx = 0;


        Collections.sort(numbers);

        for(int i: numbers){
            arr[idx++] = i;
        }
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            int left = 0, right = N - 1;

            while (left < right) {

                if(left == i) {
                    left++;
                }

                else if(right == i){
                    right--;
                } else {
                    int sum = arr[left] + arr[right];
                    if (sum == arr[i]) {
                        cnt++;
                        break;
                    } else if (sum < arr[i]) left++;
                    else right--;
                }

            }
        }

        System.out.print(cnt);
    }
}
