#include <iostream>
#include <string>
#include <unordered_map>
#include <stack>
#include <vector>
#include <algorithm>
#include <list>
#define MAX 501
using namespace std;
int visited[MAX];

void solution() {
	
	int n;
	
	cin >> n;

	int m;

	cin >> m;

	vector<vector<int>> graph(n + 1);

	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y;

		graph[x].push_back(y);
		graph[y].push_back(x);
	}


	deque<int> dq;

	dq.push_back(1);

	while (!dq.empty()) {
		int cur = dq.front();
		dq.pop_front();

		for (int next : graph[cur]) {
			if (!visited[next] && next != 1) {
				visited[next] = visited[cur] + 1;
				if (visited[next] <= 2) dq.push_back(next);
			}
		}
	}

	int cnt = 0;
	for (int i = 2; i <= n; i++) {
		if (visited[i] >= 1 && visited[i] <= 2) cnt++;
	}

	cout << cnt;

}

int main() {
	
	solution();
	
	return 0;
}