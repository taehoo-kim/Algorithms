import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int[][] distance;
    static List<List<Node>> graph = new ArrayList<>();
    static class Node {
        int idx;
        int cost;

        Node(int _idx, int _cost){
            idx = _idx;
            cost = _cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 수
        int M = Integer.parseInt(st.nextToken()); // 간선 수
        int X = Integer.parseInt(st.nextToken());

        distance = new int[N + 1][N + 1];
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i < N + 1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, cost));
        }

        for(int i = 1; i <= N; i++){
            visited = new boolean[N + 1];
            dijkstra(i);
        }
        int res = 0;
        for(int i = 1 ; i <= N; i++){
            if(res < distance[i][X] + distance[X][i]){
                res = distance[i][X] + distance[X][i];
            }
        }

        System.out.println(res);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>( (o1, o2) -> o1.cost - o2.cost );
        distance[start][start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            if(visited[curr.idx]) continue;

            visited[curr.idx] = true;

            for(Node adjNode: graph.get(curr.idx)) {
                int adjNodeIdx = adjNode.idx;
                int adjNodeCost = adjNode.cost;
                if(!visited[adjNodeIdx] && distance[start][adjNodeIdx] > adjNodeCost + distance[start][curr.idx]){
                    distance[start][adjNodeIdx] = adjNodeCost + distance[start][curr.idx];
                    pq.add(new Node(adjNodeIdx, distance[start][adjNodeIdx]));
                }
            }
        }
    }
}
