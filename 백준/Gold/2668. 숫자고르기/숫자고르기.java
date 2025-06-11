import java.io.*;
import java.util.*;

public class Main {
    static int[] graph;
    static boolean[] visited; // 이미 결과에 포함된 노드 표시
    static List<Integer> res = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new int[N + 1];
        visited = new boolean[N + 1];

        // 그래프 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        // 모든 노드에 대해 BFS로 사이클 탐색
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                boolean[] tempVisited = new boolean[N + 1];
                List<Integer> path = new ArrayList<>();
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                tempVisited[i] = true;
                path.add(i);

                boolean foundCycle = false;
                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    int next = graph[curr];
                    if (!tempVisited[next]) {
                        tempVisited[next] = true;
                        path.add(next);
                        queue.add(next);
                    } else if (next == i) { // 시작점으로 돌아옴 (사이클)
                        foundCycle = true;
                        break;
                    }
                }

                if (foundCycle) {
                    for (int num : path) {
                        if (!visited[num]) {
                            visited[num] = true;
                            res.add(num);
                        }
                    }
                }
            }
        }

        // 결과 출력
        Collections.sort(res);
        System.out.println(res.size());
        for (int num : res) {
            System.out.println(num);
        }
    }
}
