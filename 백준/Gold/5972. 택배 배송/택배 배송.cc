#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <deque>
#include <stack>
#include <queue>
#define INF 2147483647
using namespace std;

vector<int> dijkstra(int start, int N, vector<vector<pair<int, int>>> graph) {
	
	vector<int> dist(N + 1, INF);
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>> > pq;

	dist[start] = 0;
	pq.push({ 0, start });

	while (!pq.empty()) {
		int cur_dist = pq.top().first;
		int cur_node = pq.top().second;
		pq.pop();

		if (cur_dist > dist[cur_node]) continue;

		for (auto& edge : graph[cur_node]) {
			int next_node = edge.first;
			int next_dist = cur_dist + edge.second;

			if (next_dist < dist[next_node]) {
				dist[next_node] = next_dist;
				pq.push({ next_dist, next_node });
			}
		}
	}

	return dist;
}

void solution() {
	int N, M;
	cin >> N >> M;

	vector<vector<pair<int, int>>> graph(N + 1);

	for (int i = 0; i < M; i++) {
		int from, to, cost;

		cin >> from >> to >> cost;

		graph[from].push_back({ to, cost });
		graph[to].push_back({ from, cost });
	}

	vector<int> dist = dijkstra(1, N, graph);

	cout << dist[N];
}

int main() {

	solution();
	return 0;
}