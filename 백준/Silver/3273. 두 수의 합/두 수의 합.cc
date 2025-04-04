#include <iostream>
#include <vector>
#include <algorithm>

#define MAX 100000
using namespace std;

int arr[MAX];
int sub[MAX];

int main() {

	int n, x;

	cin >> n;
	vector<int> v;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
		v.push_back(arr[i]);
	}

	cin >> x;

	for (int i = 0; i < n; i++) {
		sub[i] = x - arr[i];
	}
	int cnt = 0;
	sort(v.begin(), v.end());
	for (int i = 0; i < n; i++) {
		if(binary_search(v.begin(), v.end(), sub[i]))
			cnt++;
	}

	cout << cnt / 2;
}