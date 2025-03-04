#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m;

	cin >> n;

	vector<int> v;

	for (int i = 0; i < n; i++) {
		int temp;
		cin >> temp;
		v.push_back(temp);
	}

	sort(v.begin(), v.end());

	cin >> m;

	for (int i = 0; i < m; i++) {
		int temp, check = 0;
		cin >> temp;
		if (binary_search(v.begin(), v.end(), temp))
			cout << "1 ";
		else
			cout << "0 ";
	}



	return 0;
}