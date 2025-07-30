#include <iostream>
#include <queue>
#include <vector>
#include <string>
using namespace std;

int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};
int N, M;
const int INF = 1e9;
int arr[101][101]; // 미로 정보
int dist[101][101]; // 최소 벽 부순 횟수

struct Node {
    int x, y, cnt;
    bool operator<(const Node &a) const { // cnt 기준 오름차순(최소)
        return cnt > a.cnt;
    }
};

int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    cin >> M >> N;
    for (int i = 0; i < N; i++) {
        string line; cin >> line;
        for (int j = 0; j < M; j++) {
            arr[i][j] = line[j] - '0';
            dist[i][j] = INF;
        }
    }

    priority_queue<Node> pq;
    pq.push({0, 0, 0});
    dist[0][0] = 0;

    while (!pq.empty()) {
        Node cur = pq.top(); pq.pop();
        if (cur.x == N-1 && cur.y == M-1) {
            cout << cur.cnt << "\n";
            return 0;
        }

        for (int d = 0; d < 4; d++) {
            int nx = cur.x + dx[d];
            int ny = cur.y + dy[d];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            int ncnt = cur.cnt + arr[nx][ny]; // 벽이면 +1, 아니면 0
            if (dist[nx][ny] > ncnt) {
                dist[nx][ny] = ncnt;
                pq.push({nx, ny, ncnt});
            }
        }
    }
}