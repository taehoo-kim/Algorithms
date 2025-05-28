#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Shortcut {
	int start;
	int end;
	int dist;
};

int main() {
	
	int N, K;

	cin >> N >> K;

	vector<Shortcut> shortcuts;

	for (int i = 0; i < N; i++) {
		int start, end, dist;

		cin >> start >> end >> dist;

		if (dist > end - start || end > K) continue;

		shortcuts.push_back({ start, end, dist });
	}

	vector<int> dp(K + 1, 10001);
	dp[0] = 0;

	for (int i = 0; i <= K; i++) {
		if (i > 0) dp[i] = min(dp[i], dp[i - 1] + 1);

		for (auto& sc : shortcuts) {
			if (sc.start == i && sc.end <= K) {
				dp[sc.end] = min(dp[sc.end], dp[i] + sc.dist);
			}
		}
	}

	cout << dp[K];

	return 0;
}
