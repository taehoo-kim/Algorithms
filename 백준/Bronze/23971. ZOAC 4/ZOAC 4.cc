#include <iostream>

using namespace std;

int main() {

	int H, W, N, M;

	cin >> H >> W >> N >> M;

	int f, s;

	f = (H - 1) / (N + 1) + 1;
	s = (W - 1) / (M + 1) + 1;

	cout << f * s;

	return 0;
}
