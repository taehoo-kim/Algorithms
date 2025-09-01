#include <iostream>
#include <string>
#include <deque>
#define MAX 10001
using namespace std;

int arr[MAX];

void solution() {
	
	int N, M;

	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	
	}
    int left = 0, right = 0;
    int sum = 0;
    int res = 0;

    while (right <= N) {
        if (sum < M) {
            if (right == N) break;
            sum += arr[right];
            right++;
        }
        else if (sum > M) {
            sum -= arr[left];
            left++;
        }
        else {
            res++;
            sum -= arr[left];
            left++;
        }
    }

    cout << res << endl;

}

int main() {
	
	solution();
	
	return 0;
}