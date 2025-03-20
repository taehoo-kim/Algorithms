#include <iostream>
#include <algorithm>

using namespace std;

int arr[100001];
int sum[100001];

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, K, count = 0, idx = 0, res = -101;


	cin >> N >> K;

	for (int i = 0; i < N; i++) {
		cin >> arr[i];
		if (i < K) {
			sum[0] += arr[i];
		}
	}

	res = sum[0];

	for (int i = 1; i < N - K + 1; i++) {
		sum[i] = sum[i - 1] + arr[i + K - 1] - arr[i - 1];
		res = max(sum[i], res);
	}

	cout << res;

	

	return 0;

}