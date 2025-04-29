#include <iostream>
#define MAX 1001
using namespace std;

struct country {
	int index;
	int gold;
	int silver;
	int bronze;
	int rank = 0;
};

int arr[MAX][3];
int _rank[MAX];

int main() {
	
	int N, K;

	cin >> N >> K;

	for (int i = 1; i <= N; i++) {
		int country;
		cin >> country;
		for (int j = 0; j < 3; j++) {
			cin >> arr[country][j];
		}

		_rank[i] = 1;
	}

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			if (i == j) continue;

			if (arr[i][0] < arr[j][0]) {
				_rank[i]++;
			}
			else if (arr[i][0] == arr[j][0]) {

				if (arr[i][1] < arr[j][1]) {
					_rank[i]++;
				}
				else if (arr[i][1] == arr[j][1]) {
					if (arr[i][2] < arr[j][2]) {
						_rank[i]++;
					}
				}
			}
		}
	}

	cout << _rank[K];

	return 0;
}
