#include <iostream>
#include <queue>
using namespace std;

int n, m;
int d[100][100];
int map[100][100];
int visited[100][100];
int d_r[4] = { -1, 0, 1, 0 };
int d_c[4] = { 0, -1, 0, 1 };


void bfs(int x, int y){

	visited[x][y] = 1;
	queue<pair<int, int>> q;
	q.push(make_pair(x, y));

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;

		q.pop();

		for (int i = 0; i < 4; i++) {
			int n_r = x + d_r[i];
			int n_c = y + d_c[i];

			if (n_r >= 0 && n_r < n && n_c >= 0 && n_c < m) {
				if (map[n_r][n_c] == 1 && visited[n_r][n_c] == 0) {
					d[n_r][n_c] = d[x][y] + 1;
					visited[n_r][n_c] = 1;
					q.push(make_pair(n_r, n_c));
				}
			}
		}
	}
}

int main() {
	cin >> n >> m;

	string str;

	for (int i = 0; i < n; i++) {
		cin >> str;
		for (int j = 0; j < m; j++) {
			if (str[j] == '1') map[i][j] = 1;
			else map[i][j] = 0;
		}
	}

	bfs(0, 0);
	cout << d[n - 1][m - 1] + 1;
}