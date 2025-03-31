#include <iostream>
#define MAX 100
#include <queue>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

using namespace std;

int arr[MAX + 1][MAX + 1];
int visited[MAX + 1][MAX + 1];
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, -1, 0, 1};
int N;

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
			
			if(nextA >= 0 && nextA < N && nextB >= 0 && nextB < N){
				if(!visited[nextA][nextB]){
					visited[nextA][nextB] = 1;
					q.push(make_pair(nextA, nextB));
					
				}
				
			}
			
		}
		
	}
	return 1;
	
}


int main() {
	
	cin >> N;
	
	for(int i = 0; i < N; i++){
		for(int j = 0; j < N; j++){
			cin >> arr[i][j];
		}
	}
	
	int max = 1;
	
	for(int i = 1; i <= MAX; i++){
		int temp = 0;
		for(int j = 0; j < MAX; j++){
			for(int k = 0; k < MAX; k++){
				if(arr[j][k] <= i) visited[j][k] = 1;
				else visited[j][k] = 0;
			}
		}
		
		for(int j = 0; j < N; j++){
			for(int k = 0; k < N; k++){
				temp += bfs(j, k);
			}
		}
		
		if(max < temp) max = temp;
	}
	
	cout << max;
	
	return 0;
}