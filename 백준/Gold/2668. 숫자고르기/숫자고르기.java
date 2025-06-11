import java.io.*;
import java.util.*;

public class Main {
    static int[] graph;
    static boolean[] visited;
    static List<Integer> res = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++){
            int dest = Integer.parseInt(br.readLine());
            graph[i] = dest;
            if(i == dest){
                res.add(dest);
                visited[i] = true;
            }
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                boolean[] tempVisited = new boolean[N + 1];
                List<Integer> path = new ArrayList<>();
                dfs(i, i, tempVisited, path);
            }
        }

        Collections.sort(res);
        System.out.println(res.size());
        for(int num: res) {
            System.out.println(num);
        }

    }

    private static void dfs(int start, int curr, boolean[] tempVisited, List<Integer> path){
        if (tempVisited[curr]){
            if(curr == start){
                for(int node : path){
                    if(!visited[node]){
                        visited[node] = true;
                        res.add(node);
                    }
                }
            }
            return;
        }

        tempVisited[curr] = true;
        path.add(curr);
        dfs(start, graph[curr], tempVisited, path);
    }
}
