import java.io.*;
import java.util.*;

public class Main {
    static List<List<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[][] distance;
    static class Node {
        int idx;
        int cost;

        Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        distance = new int[N + 1][N + 1];

        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i <= E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        dijkstra(1);

        visited = new boolean[N + 1];
        dijkstra(v1);

        visited = new boolean[N + 1];
        dijkstra(v2);



        int path1 = add(distance[1][v1], distance[v1][v2], distance[v2][N]);

        int path2 = add(distance[1][v2], distance[v2][v1], distance[v1][N]);

        int res = path1 > path2 ? path2 : path1;

        if(res == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }

    }

    static int add(int a, int b, int c) {
        if (a == Integer.MAX_VALUE || b == Integer.MAX_VALUE || c == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return a + b + c;
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>( (o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        distance[start][start] = 0;

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            if(visited[curr.idx]) continue;
            visited[curr.idx] = true;

            for(Node adjNode: graph.get(curr.idx)){
                int adjNodeIdx = adjNode.idx;
                int adjNodeCost = adjNode.cost;

                if(visited[adjNodeIdx]) continue;
                if(distance[start][adjNodeIdx] > distance[start][curr.idx] + adjNodeCost) {
                    distance[start][adjNodeIdx] = distance[start][curr.idx] + adjNodeCost;
                    pq.add(new Node(adjNodeIdx, distance[start][adjNodeIdx]));
                }
            }
        }

    }

}
