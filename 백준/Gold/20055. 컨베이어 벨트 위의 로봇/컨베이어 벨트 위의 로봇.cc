#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <deque>
#define MAX 201

using namespace std;


int solution() {

	int N, K;
	cin >> N >> K;

	int belt_hp[MAX]; // 벨트 내구도
	int belt[MAX]; // 벨트에 로봇이 있는지
	int cnt = 0; // 내구도가 0인 칸의 개수 
	int step = 1; // 수행 단계

	fill(belt, belt + MAX, 0);

	for (int i = 0; i < 2 * N; i++) {
		cin >> belt_hp[i];
	}

	while (1) {

		// 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
		int temp1 = belt_hp[2 * N - 1];
		int temp2 = belt[2 * N - 1];
		for (int i = 2 * N - 1; i >= 1; i--) {
			belt_hp[i] = belt_hp[i - 1];
			belt[i] = belt[i - 1];
		}

		belt_hp[0] = temp1;
		belt[0] = temp2;

		if (belt[N - 1] == 1) belt[N - 1] = 0;

		// 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면
		// 이동한다. 이동할 수 없다면 가만히 있는다.
		// 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상
		int first_idx = N - 2;

		for (int i = first_idx; i >= 0; i--) {

			if (belt[i + 1] == 0 && belt_hp[i + 1] >= 1 && belt[i] == 1) {
				belt[i] = 0;
				belt[i + 1] = 1;
				belt_hp[i + 1]--;

				if (belt_hp[i + 1] == 0) cnt++;
				if (i + 1 == N - 1) belt[i + 1] = 0;
			}
		}


		// 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
		if (belt_hp[0] > 0 && belt[0] == 0) {
			belt[0] = 1;
			belt_hp[0]--;
			if (belt_hp[0] == 0) cnt++;
		}


		// 내구도가 0인 칸의 개수가 K개 이상이면 과정 종료
		if (cnt >= K) break;

		step++;
	}


	return step;
}

int main() {

	cout << solution();
	return 0;
}