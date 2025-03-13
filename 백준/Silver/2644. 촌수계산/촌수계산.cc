#include <iostream>
#include <queue>

using namespace std;

int N, M;
int graph[101][101];
int dist[101];

void bfs(int start) {

	queue<int> q;
	q.push(start);

	while (!q.empty()) {
		int k = q.front();

		q.pop();

		for (int i = 1; i <= N; i++) {
			int temp = graph[k][i];
			if (!dist[i] && temp) {
				dist[i] = dist[k] + 1;
				q.push(i);
			}
		}
	}

}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;

	int a, b;

	cin >> a >> b;

	cin >> M;

	for (int i = 0; i < M; i++) {
		int x, y;
		cin >> x >> y;
		graph[x][y] = 1;
		graph[y][x] = 1;
	}

	bfs(a);

	if (!dist[b]) cout << -1;
	else cout << dist[b];

	return 0;
}