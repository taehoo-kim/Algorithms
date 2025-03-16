#include <iostream>
#include <queue>
#include <tuple>
#define SIZE 101
using namespace std;

int M, N, H;

int dm[6] = {0, 0, 0, 0, -1, 1};
int dn[6] = {0, 0, -1, 1, 0, 0};
int dh[6] = {-1, 1, 0, 0, 0, 0};

int map[SIZE][SIZE][SIZE];
int visited[SIZE][SIZE][SIZE];
int tomato, sum, day;


queue<tuple<int,int,int>> q;



void bfs(){
	
	while(!q.empty()){
		int len = q.size();
		int check = 0;
		
		for(int k = 0; k < len; k++){
			int h = get<0>(q.front());
			int n = get<1>(q.front());
			int m = get<2>(q.front());
			
			q.pop();
			
			for(int i = 0; i < 6; i++){
				int nextH = h + dh[i];
				int nextN = n + dn[i];
				int nextM = m + dm[i];
				
				if(nextH < H && nextH >= 0 && nextN < N && nextN >= 0 && nextM < M && nextM >= 0){
					
					if(!visited[nextH][nextN][nextM] && map[nextH][nextN][nextM] == 0){
						visited[nextH][nextN][nextM] = 1;
						map[nextH][nextN][nextM] = 1;
						q.push(make_tuple(nextH, nextN, nextM));
						sum++;
						check = 1;
					}
				}
			}
		}
		if(check){
			day++;
		}
	}
}

int main() {
	
	cin >> M >> N >> H;
	
	for(int i = 0; i < H; i++){
		for(int j = 0; j < N; j++){
			for(int k = 0; k < M; k++){
				cin >> map[i][j][k];
				
				if(map[i][j][k] >= 0){
					tomato++;
				}
				if(map[i][j][k] == 1){
					sum++;
					q.push(make_tuple(i, j, k));
					visited[i][j][k] = 1;
				}
			}
		}
	}
	
	bfs();
	
	if(tomato == sum){
		cout << day << '\n';
	} else {
		cout << -1 << '\n';
	}
	
	
	return 0;
}