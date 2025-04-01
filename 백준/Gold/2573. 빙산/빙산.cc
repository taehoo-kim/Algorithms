#include <iostream>
#include <queue>
#define MAX 300

using namespace std;

int arr[MAX][MAX];
int visited[MAX][MAX];
int sub[MAX][MAX];
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, -1, 0, 1};
int N, M;

int bfs(int x, int y){
	
	if(visited[x][y]) return 0;
	
	queue<pair<int, int> > q;
	visited[x][y] = 1;
	q.push(make_pair(x, y));
	
	while(!q.empty()){
		int a = q.front().first;
		int b = q.front().second;
		q.pop();
		
		for(int i = 0; i < 4; i++){
			int nextA = a + dx[i];
			int nextB = b + dy[i];
			
			if(nextA < N - 1 && nextA >= 1 && nextB >= 1 && nextB < M - 1){
				if(!visited[nextA][nextB]){
					visited[nextA][nextB] = 1;
					q.push(make_pair(nextA, nextB));
				}
			}
 		}
	}
	
	return 1;
}

int main(){
	
	
	cin >> N >> M;
	
	for(int i = 0; i < N; i++){
		for(int j = 0; j < M; j++){
			cin >> arr[i][j];
		}
	}
	
	int year = 0, flag = 0;
	
	for(int i = 0; i <= 900; i++){
		int cnt = 0;
		
		for(int j = 0; j < N; j++){
			for(int k = 0; k < M; k++){
				sub[j][k] = 0;
				if(arr[j][k] != 0){	
					visited[j][k] = 0;
				} else {
					visited[j][k] = 1;
				}
			}
		}
		
		for(int j = 1; j < N - 1; j++){
			for(int k = 1; k < M - 1; k++){
				cnt += bfs(j, k);
			}
		}
		
		if(cnt >= 2){
			flag = 1;
			cout << year;
			break; 
		}
		
		year++;
		
		for(int j = 1; j < N - 1; j++){
			for(int k = 1; k < M - 1; k++){
				for(int m = 0; m <= 4; m++){
					int x = j + dx[m];
					int y = k + dy[m];
					
					if(x < N && x >= 0 && y < M && y >= 0){
						if(arr[x][y] == 0)
							sub[j][k]++;
					}
				}
			}
		}
		
		for(int j = 1; j < N - 1; j++){
			for(int k = 1; k < M - 1; k++){
				if(arr[j][k] >= sub[j][k])
					arr[j][k] -= sub[j][k];
				else 
					arr[j][k] = 0;
			}
		}
		
	}
	
	if(flag == 0) cout << 0;
	
	return 0;
	
}