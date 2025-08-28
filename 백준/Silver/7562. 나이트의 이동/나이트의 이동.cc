#include <iostream>
#include <string>
#include <deque>
#define MAX 301
using namespace std;

int dist[MAX][MAX];
int dx[8] = {2, 1, 2, 1, -2, -2, -1, -1};
int dy[8] = {1, 2, -1, -2, 1, -1, 2, -2};
int l;

void bfs(int x, int y) {
	
	dist[x][y] = 0;

	deque<pair<int, int>> dq;
	dq.push_back({ x, y });
	
	while (!dq.empty()) {
		int cx = dq.front().first;
		int cy = dq.front().second;

		dq.pop_front();

		for (int i = 0; i < 8; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (nx < l && nx >= 0 && ny < l && ny >= 0) {
				if (dist[nx][ny] == -1) {
					dist[nx][ny] = dist[cx][cy] + 1;
					dq.push_back({ nx, ny });
				}
			}
		}
	}

}

void solution() {
	
	int T;
	cin >> T;

	while (T--) {

		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				dist[i][j] = -1;
			}
		}

		cin >> l;
		int cur_x, cur_y;
		cin >> cur_x >> cur_y;
		int dest_x, dest_y;
		cin >> dest_x >> dest_y;

		bfs(cur_x, cur_y);

		cout << dist[dest_x][dest_y] << "\n";
	}
}

int main() {
	
	solution();
	
	return 0;
}