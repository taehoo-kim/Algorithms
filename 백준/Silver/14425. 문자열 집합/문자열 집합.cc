#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m, res = 0;

	cin >> n >> m;

	vector<string> v;

	for (int i = 0; i < n; i++) {
		string temp;
		cin >> temp;
		v.push_back(temp);
	}

	sort(v.begin(), v.end());

	for (int i = 0; i < m; i++) {
		string temp;
		cin >> temp;

		if (binary_search(v.begin(), v.end(), temp))
			res++;
	}

	cout << res;

	return 0;
}