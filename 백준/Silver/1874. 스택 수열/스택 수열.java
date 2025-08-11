import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            q.add(i);
        }

        for(int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            if(s.isEmpty()) {
                while(!q.isEmpty() && q.peek() <= t) {
                    s.push(q.poll());
                    sb.append("+\n");
                }
                s.pop();
                sb.append("-\n");
            }
            else if(s.peek() == t) {
                s.pop();
                sb.append("-\n");
            }
            else if(s.peek() < t) {
                while(!q.isEmpty() && q.peek() <= t) {
                    s.push(q.poll());
                    sb.append("+\n");
                }
                s.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.print(sb);
    }

}
