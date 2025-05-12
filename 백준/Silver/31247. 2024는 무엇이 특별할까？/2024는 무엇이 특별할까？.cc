#include <iostream>
#include <string>
#include <set>

using namespace std;

int main() {
	
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int T;
	cin >> T;

	for (int i = 0; i < T; i++) {
		long long n, k;

		cin >> n >> k;

		while (n > 0 && k > 0) {
			n >>= 1;
			k--;
		}
		cout << (n + 1) / 2 << '\n';
	}


	return 0;
}
