import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] distance;
    static List<List<Node>> graph = new ArrayList<>();
    static class Node {
        int idx;
        int cost;

        Node(int _idx, int _cost) {
            idx = _idx;
            cost = _cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        visited = new boolean[V + 1];
        distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i = 0; i < V + 1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u, v, w;
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        dijkstra(start);

        for(int i = 1; i <= V; i++){
            if(distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>( (o1, o2) -> o1.cost - o2.cost );;
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            int currIdx = curr.idx;

            if(visited[currIdx]) continue;
            visited[currIdx] = true;

            for(Node adjNode: graph.get(currIdx)){
                int adjNodeIdx = adjNode.idx;
                int adjNodeCost = adjNode.cost;
                if(visited[adjNodeIdx]) continue;
                if(distance[adjNodeIdx] > adjNodeCost + distance[currIdx]){
                    distance[adjNodeIdx] = adjNodeCost + distance[currIdx];
                    pq.add(new Node(adjNodeIdx, distance[adjNodeIdx]));
                }
            }
        }
    }
}
