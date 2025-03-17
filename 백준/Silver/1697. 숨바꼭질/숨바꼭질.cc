#include <iostream>
#include <queue>

using namespace std;

int d[100001];
int N, K;

void bfs(int start) {
    queue<int> q;
    q.push(start);
    d[start] = 0;

    while (!q.empty()) {
        int u = q.front();
        q.pop();

        int directions[3] = {u - 1, u + 1, u * 2};
        for (int i = 0; i < 3; i++) {
            int now = directions[i];

            if (now >= 0 && now <= 100000 && !d[now]) {
                d[now] = d[u] + 1;
                q.push(now);

                if (now == K) {
                    cout << d[now];
                    return;
                }
            }
        }
    }
}

int main() {
    cin >> N >> K;

    if (N == K) {
        cout << 0;
        return 0;
    }

    bfs(N);

    return 0;
}
