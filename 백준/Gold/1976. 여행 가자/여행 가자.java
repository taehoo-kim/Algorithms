import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] graph = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] plan = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++){
            plan[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList();
        q.add(plan[0]);
        visited[plan[0]] = true;

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int next = 1; next <= N; next++){
                if (graph[curr][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        boolean possible = true;
        for (int city: plan){
            if(!visited[city]){
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");

    }
}
