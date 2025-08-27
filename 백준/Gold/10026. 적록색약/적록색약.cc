#include <iostream>
#include <string>
#include <deque>
#define MAX 101
using namespace std;

char pic[MAX][MAX];
int visited[MAX][MAX];
int dx[4] = { -1, 0, 1, 0 };
int dy[4] = { 0, -1, 0, 1 };
int N, normal_res, abnormal_res;

void bfs(int x, int y, char color) {
	
	if (visited[x][y] || pic[x][y] != color) return;

	deque<pair<int, int>> dq;
	dq.push_back({ x, y });
	visited[x][y] = 1;

	while (!dq.empty()) {
		int cx = dq.front().first;
		int cy = dq.front().second;
		dq.pop_front();

		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (nx < N && nx >= 0 && ny < N && ny >= 0) {
				if (!visited[nx][ny] && pic[nx][ny] == color) {
					visited[nx][ny] = 1;
					dq.push_back({ nx, ny });
				}
			}
		}
	}

	normal_res++;
}

void bfs_ab(int x, int y, char color) {

	if (visited[x][y] || pic[x][y] != color) return;

	deque<pair<int, int>> dq;
	dq.push_back({ x, y });
	visited[x][y] = 1;

	while (!dq.empty()) {
		int cx = dq.front().first;
		int cy = dq.front().second;
		dq.pop_front();

		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (nx < N && nx >= 0 && ny < N && ny >= 0) {
				if (!visited[nx][ny] && pic[nx][ny] == color) {
					visited[nx][ny] = 1;
					dq.push_back({ nx, ny });
				}
			}
		}
	}

	abnormal_res++;
}

void solution() {
	
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> pic[i];
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			bfs(i, j, 'R');
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			visited[i][j] = 0;
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			bfs(i, j, 'G');
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			visited[i][j] = 0;
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			bfs(i, j, 'B');
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (pic[i][j] == 'G') {
				pic[i][j] = 'R';
			}
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			visited[i][j] = 0;
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			bfs_ab(i, j, 'R');
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			visited[i][j] = 0;
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			bfs_ab(i, j, 'B');
		}
	}


	cout << normal_res << " " << abnormal_res;
}

int main() {
	
	solution();
	
	return 0;
}