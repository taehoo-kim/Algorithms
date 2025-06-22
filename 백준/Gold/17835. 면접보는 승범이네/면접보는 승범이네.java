import java.io.*;
import java.util.*;

public class Main {
    static List<List<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static Long[] distance;
    static int[] pos;
    static int K;
    static class Node {
        int idx;
        long cost;

        Node(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(v).add(new Node(u, c)); // 그래프 방향 반대로
        }

        visited = new boolean[N + 1];
        pos = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            pos[i] = Integer.parseInt(st.nextToken());
        }

        distance = new Long[N + 1];
        Arrays.fill(distance, Long.MAX_VALUE);

        dijkstra();

        int city = 0;

        long max = -1;

        for(int i = 1; i <= N; i++){
            if(max < distance[i]){
                max = distance[i];
                city = i;
            }
        }

        System.out.println(city);
        System.out.println(max);

    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>( (o1, o2) -> Long.compare(o1.cost, o2.cost));

        // 면접 장소가 여러 개이기 때문에 우선순위 큐에 add 함.
        // (출발지가 여러 개인 그래프 탐색 스킬)
        for(int i = 0; i < K; i++) {
            pq.add(new Node(pos[i], 0));
            distance[pos[i]] = 0L;
        }

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            if(visited[curr.idx]) continue;
            visited[curr.idx] = true;

            for(Node adjNode: graph.get(curr.idx)) {
                int adjNodeIdx = adjNode.idx;
                long adjNodeCost = adjNode.cost;

                if(visited[adjNodeIdx]) continue;
                if(distance[adjNodeIdx] > distance[curr.idx] + adjNodeCost) {
                    distance[adjNodeIdx] = distance[curr.idx] + adjNodeCost;
                    pq.add(new Node(adjNodeIdx, distance[adjNodeIdx]));
                }
            }
        }
    }

}
