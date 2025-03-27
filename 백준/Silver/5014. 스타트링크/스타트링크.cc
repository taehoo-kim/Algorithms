#include <iostream>
#include <queue>

using namespace std;

int visited[1000001];
int button[1000001];
int F, U, D;

void bfs(int start){
	
	visited[start] = 1;
	queue<int> q;
	q.push(start);
	
	while(!q.empty()){
		int curr = q.front();
		q.pop();
		
		int currUp = curr + U;
		
		if(currUp <= F && !visited[currUp]){
			visited[currUp] = 1;
			q.push(currUp);
			button[currUp] = button[curr] + 1;	
		}
		
		int currDown = curr - D;
		
		if(currDown >= 1 && !visited[currDown]){
			visited[currDown] = 1;
			q.push(currDown);
			button[currDown] = button[curr] + 1;
		}
		
	}
	
}

int main(){
	int S, G;
	
	cin >> F >> S >> G >> U >> D;
	
	bfs(S);
	
	if(S != G && button[G] == 0){
		cout << "use the stairs";
	} else {
		cout << button[G];
	}
	
	return 0;
		
}