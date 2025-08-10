import java.util.*;

class Solution {
    
    class Edge implements Comparable<Edge> {
        int a, b, cost;
        
        Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge other) {
            return this.cost - other.cost;
        }
    }
    
    public int solution(int n, int[][] costs) {
        List<Edge> edges = new ArrayList<>();
        for (int[] c : costs) {
            edges.add(new Edge(c[0], c[1], c[2]));
        }
        
        Collections.sort(edges);
        
        int[] parents = new int[n];
        for(int i = 0; i < n; i++) parents[i] = i;
        
        int answer = 0;
        for(Edge e : edges) {
            if(find(parents, e.a) != find(parents, e.b)) {
                union(parents, e.a, e.b);
                answer += e.cost;
            }
        }
        
        return answer;
    }
    
    static int find(int[] parents, int x) {
        if(parents[x] != x) {
            parents[x] = find(parents, parents[parents[x]]);
        }
        
        return parents[x];
    }
    
    static void union(int[] parents, int a, int b) {
        a = find(parents, a);
        b = find(parents, b);
        if(a < b) parents[b] = a;
        else parents[a] = b;
    }
}