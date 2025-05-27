#include <iostream>
#include <algorithm>
using namespace std;

int cnt[200001];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N, K;
    cin >> N >> K;
    
    int arr[N];
    for(int i=0; i<N; i++) cin >> arr[i];
    
    int start = 0, max_len = 0;
    
    for(int end=0; end<N; end++){
        cnt[arr[end]]++;
        
        while(cnt[arr[end]] > K){
            cnt[arr[start]]--;
            start++;
        }
        
        max_len = max(max_len, end - start + 1);
    }
    
    cout << max_len;
    return 0;
}
