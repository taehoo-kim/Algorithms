#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

int map[26][26];
int visited[26][26];
vector<int> cntVec;

int direction_row[4] = { -1, 0, 1, 0 };
int direction_column[4] = { 0, 1, 0, -1 };
int N;
int cnt;

void dfs(int row, int column) {
	
	for (int i = 0; i < 4; i++) {
		int n_row = row + direction_row[i];
		int n_column = column + direction_column[i];

		if (n_row > N || n_row <= 0 || n_column > N || n_column <= 0) continue;

		if (visited[n_row][n_column] == 0 && map[n_row][n_column] == 1) { // 방문 X, 집 O
			visited[n_row][n_column] = 1;
			cnt++;
			dfs(n_row, n_column); 
		}
	}
}

int main() {

	int res = 0;

	cin >> N;

	string str;

	for (int i = 1; i <= N; i++) {
		cin >> str;
		for (int j = 1; j <= str.length(); j++) {
			visited[i][j] = 0;

			if (str[j-1] == '1') {
				map[i][j] = 1;
			}
			else map[i][j] = 0;
		}
	}

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			if (map[i][j] == 1 && visited[i][j] == 0) {
				visited[i][j] = 1;
				cnt = 1;
				dfs(i, j);
				cntVec.push_back(cnt);
				res++;
			}
		}
	}

	sort(cntVec.begin(), cntVec.end());
	cout << res << '\n';

	for (auto x : cntVec) {
		cout << x << '\n';
	}

	return 0;
}