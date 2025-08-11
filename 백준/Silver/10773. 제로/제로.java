import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < K; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number == 0) {
                s.pop();
            } else {
                s.push(number);
            }
        }
        int sum = 0;
        while(!s.isEmpty()) {
            sum += s.pop();
        }
        System.out.println(sum);
    }

}
