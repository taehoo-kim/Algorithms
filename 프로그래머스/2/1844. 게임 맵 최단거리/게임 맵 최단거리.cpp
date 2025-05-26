#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
using namespace std;
int n;
int m;
int visited[101][101];

int solution(vector<vector<int> > maps)
{
    int answer = 0;
    n = maps.size();
    m = maps[0].size();
    
    int target_x = n - 1;
    int target_y = m - 1;
    
    int dx[4] = {-1, 1, 0, 0};
    int dy[4] = {0, 0, -1, 1};
    
    visited[0][0] = 1;
    queue<pair<int, int>> q;
    q.push(make_pair(0, 0));
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        
        q.pop();
        
        for(int i = 0; i < 4; i++){
            int next_x = x + dx[i];
            int next_y = y + dy[i];
            
            if(next_x >= 0 && next_y >= 0 && next_x <= target_x && next_y <= target_y){
                if(!visited[next_x][next_y] && maps[next_x][next_y] == 1){
                    visited[next_x][next_y] = visited[x][y] + 1;
                    q.push(make_pair(next_x, next_y));
                }
            }
        }
    }
    
    if(visited[target_x][target_y] == 0) return -1;
    return visited[target_x][target_y];
}