#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <deque>

using namespace std;

int graph[100][100];
int cnt[101];

int solution() {
	int N, M;

	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		int x, y;
		cin >> x >> y;
		graph[x][y] = 1;
	}

	for (int i = 0; i < M; i++) {
		int x, y;
		cin >> x >> y;
		graph[x][y] = 1;
	}

	deque<int> dq;

	int start = 1;
	dq.push_back(start);
	cnt[start] = 0;

	while (!dq.empty()) {
		int curr = dq.front();
		dq.pop_front();

		for (int i = 1; i <= 6; i++) {
			int next = curr + i;
			int flag = 0;
			if (next > 100) continue;
			if (next == 100) {
				return cnt[curr] + 1;
			}
			for (int j = 0; j < 100; j++) {
				if (graph[next][j]) {
					next = j;
					break;
				}
			}

			
			if (!cnt[next] && next < 100) {
				cnt[next] = cnt[curr] + 1;
				dq.push_back(next);
			}
			
		}
	}
	 
	return cnt[100];

}

int main() {

	cout << solution();
	return 0;
}