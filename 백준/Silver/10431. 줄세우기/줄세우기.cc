#include <iostream>
using namespace std;

int main() {
	int P;

	cin >> P;

	for (int i = 0; i < P; i++) {
		int T, stu[20], cnt = 0;

		cin >> T;

		for (int j = 0; j < 20; j++) {
			cin >> stu[j];
		}

		for (int j = 1; j < 20; j++) {
			for (int k = 0; k < j; k++) {
				if (stu[j] < stu[k]) {
					cnt++;
				}
			}
		}

		cout << T << " " << cnt << '\n';
	}

	return 0;
}
