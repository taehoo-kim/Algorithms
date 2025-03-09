#include <iostream>
#include <algorithm>
#include <map>

using namespace std;

int main() {
	
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M;

	cin >> N;

	vector<int> v;

	map<int, int> m;

	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;
		if (m.count(num) != 0) {
			m[num]++;
		}
		else {
			m[num] = 1;
		}
	}

	cin >> M;

	for (int i = 0; i < M; i++) {
		int num;
		cin >> num;
		cout << m[num] << " ";
	}

	return 0;
}