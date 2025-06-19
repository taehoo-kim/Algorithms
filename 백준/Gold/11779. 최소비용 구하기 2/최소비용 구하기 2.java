import java.io.*;
import java.util.*;

public class Main {
    static int[] distance;
    static boolean[] visited;
    static int[] prev;
    static List<List<Node>> graph = new ArrayList<>();
    static class Node {
        int idx;
        int cost;
        Node (int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        distance = new int[n + 1];
        prev = new int[n + 1];
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int u, v, w;
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        Stack<Integer> path = new Stack<>();
        int cur = end;
        while(cur != start){
            path.add(cur);
            cur = prev[cur];
        }
        path.add(cur);

        System.out.println(distance[end]);
        System.out.println(path.size());
        while(!path.isEmpty()){
            System.out.print(path.pop());
            System.out.print(" ");
        }
        
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>( (o1, o2) -> o1.cost - o2.cost);

        pq.add(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            if(visited[curr.idx]) continue;
            visited[curr.idx] = true;

            for(Node adjNode: graph.get(curr.idx)) {
                int adjNodeIdx = adjNode.idx;
                int adjNodeCost = adjNode.cost;

                if(visited[adjNodeIdx]) continue;
                if(distance[adjNodeIdx] > adjNodeCost + distance[curr.idx]){
                    distance[adjNodeIdx] = adjNodeCost + distance[curr.idx];
                    prev[adjNodeIdx] = curr.idx;
                    pq.add(new Node(adjNodeIdx, distance[adjNodeIdx]));
                }
            }
        }
    }
}
