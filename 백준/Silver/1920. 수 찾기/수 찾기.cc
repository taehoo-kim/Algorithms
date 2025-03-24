#include <iostream>
#include <algorithm>
#include <vector>
#define MAX 100001
using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m;

	vector<int> v;

	cin >> n;

	for (int i = 0; i < n; i++) {
		int temp;
		cin >> temp;
		v.push_back(temp);
	}

	sort(v.begin(), v.end());

	cin >> m;
	
	for (int i = 0; i < m; i++) {
		int temp;
		cin >> temp;
		if (binary_search(v.begin(), v.end(), temp)) {
			cout << "1" << '\n';
		}
		else {
			cout << "0" << '\n';
		}
	}

	return 0;

}