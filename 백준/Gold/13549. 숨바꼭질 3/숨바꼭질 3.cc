#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <deque>

using namespace std;

void solution() {
	int N, K;
	cin >> N >> K;

	vector<int> dist(100001, -1);

	deque<int> dq;
	dist[N] = 0;
	dq.push_back(N);

	while (!dq.empty()) {
		int curr = dq.front();
		dq.pop_front();

		if (curr == K) {
			cout << dist[curr];
			return;
		}

		int teleport = curr * 2;
		if (teleport < 100001 && dist[teleport] == -1) {
			dist[teleport] = dist[curr];
			dq.push_back(teleport);
		}

		int walk[] = { curr - 1, curr + 1 };
		for (int next : walk) {
			if (next >= 0 && next < 100001 && dist[next] == -1) {
				dist[next] = dist[curr] + 1;
				dq.push_back(next);
			}
		}
	}

}

int main() {

	solution();
	return 0;
}