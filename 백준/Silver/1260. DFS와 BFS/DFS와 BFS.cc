#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

vector<vector<int>> dfsNode;
vector<vector<int>> bfsNode;
vector<bool> dfsVisited;
vector<bool> bfsVisited;

void dfs(int start) {
	if (dfsVisited[start]) return;

	dfsVisited[start] = true;
	cout << start << ' ';
	for (int i = 0; i < dfsNode[start].size(); i++) {
		int x = dfsNode[start][i];
		dfs(x);
	}
}

void bfs(int start) {
	queue<int> q;
	q.push(start);
	bfsVisited[start] = true;

	while (!q.empty()) {
		int temp = q.front();
		cout << q.front() << ' ';
		q.pop();
		for (int i = 0; i < bfsNode[temp].size(); i++) {
			int x = bfsNode[temp][i];
			if (!bfsVisited[x]) {
				q.push(x);
				bfsVisited[x] = true;
			}
		}
	}

}

int main() {
	
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M, V;

	cin >> N >> M >> V;

	dfsNode.resize(N + 1);
	bfsNode.resize(N + 1);
	dfsVisited.resize(N + 1);
	bfsVisited.resize(N + 1);

	for (int i = 0; i < M; i++) {
		int x, y;
		cin >> x >> y;

		dfsNode[x].push_back(y);
		dfsNode[y].push_back(x);

		bfsNode[x].push_back(y);
		bfsNode[y].push_back(x);

		sort(dfsNode[x].begin(), dfsNode[x].end());
		sort(dfsNode[y].begin(), dfsNode[y].end());
		sort(bfsNode[x].begin(), bfsNode[x].end());
		sort(bfsNode[y].begin(), bfsNode[y].end());
	}

	dfs(V);

	cout << "\n";

	bfs(V);


	return 0;
}