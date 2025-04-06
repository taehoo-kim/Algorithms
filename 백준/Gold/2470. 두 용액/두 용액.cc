#include <iostream>
#include <algorithm>
#define MAX 100000
using namespace std;

int arr[MAX];

int abs(int n) {
	if (n < 0) n = -n;
	return n;
}


int main() {
	int N;

	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}

	int left = 0, right = N - 1;
	int resultSum = 2000000000;
	int resultLeft;
	int resultRight;

	sort(arr, arr + N);

	while (1) {
		if (left == right) {
			if (left + 1 < N) left++;
			else if (right - 1 >= 0) right--;
			else break;
		}

		int sum = arr[left] + arr[right];

		if (abs(sum) < resultSum) {
			resultSum = abs(sum);
			resultLeft = arr[left];
			resultRight = arr[right];
		}

		if (sum < 0) {
			if (arr[left] < arr[right] && left + 1 < N)
				left++;
			else if (right - 1 >= 0) right--;
			else break;
		}
		else if (sum > 0) {
			if (arr[left] > arr[right] && left + 1 < N)
				left++;
			else if (right - 1 >= 0) right--;
			else break;
		}
		else break;

	}

	if (resultLeft < resultRight)
		cout << resultLeft << ' ' << resultRight;
	else
		cout << resultRight << ' ' << resultLeft;

	return 0;

}