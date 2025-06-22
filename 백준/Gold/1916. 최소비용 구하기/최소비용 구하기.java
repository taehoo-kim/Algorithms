import java.io.*;
import java.util.*;

public class Main {
    static List<List<Node>> graph = new ArrayList<>();
    static int[] distance;
    static boolean[] visited;
    static class Node {
        int idx;
        int cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        distance = new int[N + 1];
        visited = new boolean[N + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);

        System.out.println(distance[end]);

    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            if(visited[curr.idx]) continue;
            visited[curr.idx] = true;

            for(Node adjNode: graph.get(curr.idx)){
                int adjNodeIdx = adjNode.idx;
                int adjNodeCost = adjNode.cost;

                if(visited[adjNodeIdx]) continue;
                if(distance[adjNodeIdx] > distance[curr.idx] + adjNodeCost){
                    distance[adjNodeIdx] = distance[curr.idx] + adjNodeCost;
                    pq.add(new Node(adjNodeIdx, distance[adjNodeIdx]));
                }
            }
        }
    }
}
