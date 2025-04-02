#include <iostream>
#include <algorithm>
#include <vector>
#include <cstdlib>
#include <queue>
#define MAX 102

using namespace std;

int dx, dy;

int visited[MAX];

void bfs(int x, int y, int n, vector<pair<int, int> > v){
	visited[0] = 1;
	queue<pair<int, int> > q;
	q.push(make_pair(x, y));
	
	while(!q.empty()){
		int a = q.front().first;
		int b = q.front().second;
		
		if(a == dx && b == dy){
			cout << "happy\n";
			return;
		}
		
		q.pop();
		
		for(int i = 1; i < n + 2; i++){
			if(!visited[i] && ((abs(a - v[i - 1].first) + abs(b - v[i - 1].second)) <= 1000)){
				visited[i] = 1;
				q.push(make_pair(v[i - 1].first, v[i - 1].second));
			}
		}
	}
	
	cout << "sad\n";
}

int main(){
	
	int t;
	cin >> t;
	
	while(t--){
		int n;
		cin >> n;
		
		int hx, hy;
		
		cin >> hx >> hy;
		
		vector<pair<int, int> > v;
		for(int i = 0; i < n + 1; i++){
			int x, y;
			cin >> x >> y;
		
			v.push_back(make_pair(x, y));
		}
		
		dx = v[n].first;
		dy = v[n].second;
		
		bfs(hx, hy, n, v);
		
		for(int i = 0; i < MAX; i++) visited[i] = 0;
		
	}
	
	return 0;
}