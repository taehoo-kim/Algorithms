#include <iostream>
#define MAX 1001

using namespace std;

void solution() {

	int N, K;

	cin >> N >> K;

	int arr[2][7];
	int rooms = 0;
	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 7; j++) {
			arr[i][j] = 0;
		}
	}

	for (int i = 0; i < N; i++) {
		int S, Y;
		cin >> S >> Y;
		arr[S][Y]++;
	}

	for (int i = 0; i < 2; i++) {
		for (int j = 1; j < 7; j++) {
			if (arr[i][j] == 0) continue;

			if (arr[i][j] % K == 0) {
				rooms += arr[i][j] / K;
			}
			else if (arr[i][j] > K) {
				rooms += arr[i][j] / K + 1;
			}
			else {
				rooms++;
			}
		}
	}

	cout << rooms;

}

int main() {
	
	solution();
	
	return 0;
}