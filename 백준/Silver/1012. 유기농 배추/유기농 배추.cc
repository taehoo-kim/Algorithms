#include <iostream>
#include <string>
#include <deque>
#define MAX 51
using namespace std;

int map[MAX][MAX];
int visited[MAX][MAX];
int dx[4] = { -1, 0, 1, 0 };
int dy[4] = { 0, -1, 0, 1 };
int N, M, res ;

void bfs(int y, int x) {

	if (visited[y][x] || map[y][x] == 0) return;

	deque<pair<int, int>> dq;
	dq.push_back({ y, x });
	visited[y][x] = 1;

	while (!dq.empty()) {
		int cur_x = dq.front().second;
		int cur_y = dq.front().first;
		dq.pop_front();

		for (int i = 0; i < 4; i++) {
			int nx = cur_x + dx[i];
			int ny = cur_y + dy[i];

			if (nx < M && nx >= 0 && ny < N && ny >= 0) {
				if (!visited[ny][nx] && map[ny][nx] == 1) {
					visited[ny][nx] = 1;
					dq.push_back({ ny, nx });
				}
			}
		}
	}
	res++;
}

void solution() {
	
	int T;
	cin >> T;
	while (T--) {
		res = 0;
		int K;
		cin >> M >> N >> K;

		for (int i = 0; i < K; i++) {
			int x, y;
			cin >> x >> y;

			map[y][x] = 1;
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				bfs(j, i);
			}
		}

		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				visited[i][j] = 0;
				map[i][j] = 0;
			}
		}

		cout << res << "\n";
	}

}

int main() {
	
	solution();
	
	return 0;
}