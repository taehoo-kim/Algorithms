#include <iostream>
#include <queue>

using namespace std;

int graph[101][101];
int visited[101];
int result;
int N, M;

void bfs(int x) {

	queue<int> q;
	q.push(x);

	visited[x] = 1;

	while (!q.empty()) {
		int k = q.front();
		q.pop();

		for (int i = 1; i <= N; i++) {
			if (graph[k][i] == 1 && !visited[i]) {
				visited[i] = 1;
				result++;
				q.push(i);
			}
		}
		

	}

}

int main() {

	cin >> N >> M;

	for (int i = 0; i < M; i++) {
		int x, y;
		cin >> x >> y;

		graph[x][y] = 1;
		graph[y][x] = 1;
	}

	bfs(1);
	cout << result;
}