#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <deque>

using namespace std;

void solution() {
	int T;

	cin >> T;

	int dp[10001][4];

	dp[1][1] = 1;
	dp[1][2] = 1;
	dp[1][3] = 1;
	dp[2][1] = 1;
	dp[2][2] = 2;
	dp[2][3] = 2;
	dp[3][1] = 1;
	dp[3][2] = 2;
	dp[3][3] = 3;


	for (int i = 4; i < 10001; i++) {
		for (int j = 1; j <= 3; j++) {
			if (j == 1) {
				dp[i][j] = dp[i - j][j];
			}
			else {
				dp[i][j] = dp[i][j - 1] + dp[i - j][j];
			}
		}
	}

	while (T--) {
		int n;
		cin >> n;

		cout << dp[n][3] << "\n";

	}
}

int main() {

	solution();
	return 0;
}