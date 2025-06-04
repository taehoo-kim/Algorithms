#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <deque>

using namespace std;

void solution() {
	int T;
	cin >> T;

	while (T--) {
		string W;
		int K;

		cin >> W;
		cin >> K;
		

		vector<vector<int>> v(26);

		for (int i = 0; i < W.length(); i++) {
			v[W[i] - 'a'].push_back(i);
		}
		int min_len = 10001;
		int max_len = -1;

		for (int i = 0; i < 26; i++) {
			if (v[i].size() < K) {
				continue;
			}

			for (int j = 0; j < v[i].size(); j++) {

				if (j + K - 1 >= v[i].size()) break;

				int len = v[i][j + K - 1] - v[i][j] + 1;

				min_len = min(min_len, len);
				max_len = max(max_len, len);
			}

		}

		if (max_len == -1) cout << max_len << '\n';
		else {
			cout << min_len << ' ';
			cout << max_len << "\n";
		}
	}


}

int main() {

	solution();
	return 0;
}