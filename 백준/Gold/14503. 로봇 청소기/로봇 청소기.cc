#include <iostream>
#include <queue>
#define MAX 51
using namespace std;

int room[MAX][MAX];
int visited[MAX][MAX];
int dx[4] = { -1, 0, 1, 0 };
int dy[4] = { 0, -1, 0, 1 };
int res = 0;
int N, M;

void dfs(int x, int y, int d) {
	
	if (!visited[x][y]) {
		visited[x][y] = 1;
		res++;
	}

	int flag = 0;

	for (int i = 0; i < 4; i++) {
		int nextX = x + dx[i];
		int nextY = y + dy[i];
		if (nextX < N && nextX >= 0 && nextY < M && nextY >= 0) {
			if (!visited[nextX][nextY]) {
				flag = 1;
			}
		}

	}
	int nextX, nextY;

	if (!flag) { // 청소할 곳이 없는 경우

		if (d == 0) {
			nextX = x + 1;
			nextY = y;
			if (nextX < N && !room[nextX][nextY])
				dfs(nextX, nextY, d);

		}
		else if (d == 1) {
			nextX = x;
			nextY = y - 1;

			if (nextY >= 0 && !room[nextX][nextY])
				dfs(nextX, nextY, d);

		}
		else if (d == 2) {
			nextX = x - 1;
			nextY = y;

			if (nextX >= 0 && !room[nextX][nextY])
				dfs(nextX, nextY, d);


		}
		else {
			nextX = x;
			nextY = y + 1;

			if (nextY < M && !room[nextX][nextY])
				dfs(nextX, nextY, d);
		}
	}
	else { // 청소할 곳이 있는 경우 
		

		if (d == 0) {
			int check = 0;
			nextX = x;
			nextY = y - 1;
			
			if (nextY >= 0) {
				if (!visited[nextX][nextY]) {
					check = 1;
					dfs(nextX, nextY, 3);
				}
			}

			if (check == 0) {
				nextX = x + 1;
				nextY = y;
				if (nextX < N) {
					if (!visited[nextX][nextY]) {
						check = 1;
						dfs(nextX, nextY, 2);
					}
				}
			}

			if (check == 0) {
				nextX = x;
				nextY = y + 1;

				if (nextY < M) {
					if (!visited[nextX][nextY]) {
						check = 1;
						dfs(nextX, nextY, 1);
					}
				}
			}

			if (check == 0) {
				if (nextX >= 0) {
					nextX = x - 1;
					nextY = y;
					if (!visited[nextX][nextY]) {
						check = 1;
						dfs(nextX, nextY, 0);
					}
				}
			}

		}
		else if (d == 1) {
			int check = 0;
			nextX = x - 1;
			nextY = y;

			if (nextX >= 0) {
				if (!visited[nextX][nextY]) {
					check = 1;
					dfs(nextX, nextY, 0);
				}
			}

			if (check == 0) {
				nextX = x;
				nextY = y - 1;

				if (nextY >= 0)
					if (!visited[nextX][nextY]) {
						check = 1;
						dfs(nextX, nextY, 3);
					}
			}

			if (check == 0) {
				nextX = x + 1;
				nextY = y;

				if (nextX < N) {
					if (!visited[nextX][nextY]) {
						check = 1;
						dfs(nextX, nextY, 2);
					}
				}
			}

			if (check == 0) {
				nextX = x;
				nextY = y + 1;

				if (nextY < M) {
					if (!visited[nextX][nextY]) {
						check = 1;
						dfs(nextX, nextY, 1);
					}
				}
			}
		}
		else if (d == 2) {
			int check = 0;
			nextX = x;
			nextY = y + 1;

			if (nextY < M) {
				if (!visited[nextX][nextY]) {
					check = 1;
					dfs(nextX, nextY, 1);
				}
			}

			if (check == 0) {
				nextX = x - 1;
				nextY = y;

				if (nextX >= 0) {
					if (!visited[nextX][nextY]) {
						check = 1;
						dfs(nextX, nextY, 0);
					}
				}
			}

			if (check == 0) {
				nextX = x;
				nextY = y - 1;

				if (nextY >= 0)
					if (!visited[nextX][nextY]) {
						check = 1;
						dfs(nextX, nextY, 3);
					}
			}

			if (check == 0) {
				nextX = x + 1;
				nextY = y;
				if (nextX < N) {
					if (!visited[nextX][nextY]) {
						check = 1;
						dfs(nextX, nextY, 2);
					}
				}
			}

		}
		else if (d == 3) {
			int check = 0;
			nextX = x + 1;
			nextY = y;

			if (nextX < N) {
				if (!visited[nextX][nextY]) {
					check = 1;
					dfs(nextX, nextY, 2);
				}
			}

			if (check == 0) {
				nextX = x;
				nextY = y + 1;

				if (nextY < M) {
					if (!visited[nextX][nextY]) {
						check = 1;
						dfs(nextX, nextY, 1);
					}
				}
			}

			if (check == 0) {
				nextX = x - 1;
				nextY = y;

				if (nextX >= 0) {
					if (!visited[nextX][nextY]) {
						check = 1;
						dfs(nextX, nextY, 0);
					}
				}
			}

			if (check == 0) {
				nextX = x;
				nextY = y - 1;

				if(nextY >= 0)
					if (!visited[nextX][nextY]) {
						check = 1;
						dfs(nextX, nextY, 3);
					}
			}
		}
	}



}

// 0은 북쪽, 1인 동쪽, 2는 남쪽, 3은 서쪽 
int main() {

	cin >> N >> M;

	int r, c, d;

	cin >> r >> c >> d;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> room[i][j];

			if (room[i][j] == 1) visited[i][j] = 1;
		}
	}

	dfs(r, c, d);

	cout << res;

	return 0;
}