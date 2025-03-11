#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int is_checked(int n) {
	
	for (int i = 2; i < n; i++) {
		if (n % i == 0) return 0;
	}

	return 1;
}

int main() {
	
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, cnt = 0;
	
	cin >> N;

	for (int i = 0; i < N; i++) {
		int temp;
		cin >> temp;
		if (temp == 1) continue;
		if (is_checked(temp)) cnt++;
	}

	cout << cnt;

	return 0;
}