fun main() {
    // S가 포함하는 0의 개수와 1의 개수는 짝수
    // 절반의 0과 절반의 1을 제거하여 새로운 문자열 S'을 만들고자 함
    // S'로 가능한 문자열 중 사전순으로 가장 빠른 것 찾기

    val S = readln().toMutableList()

    var zeroCnt = 0
    var oneCnt = 0

    for(i in S){
        if(i == '0')
            zeroCnt++
        else
            oneCnt++
    }

    zeroCnt /= 2
    oneCnt /= 2

    var cnt = 0

    for(i in 0 until S.size) {
        if(cnt == oneCnt) break
        if (S[i] == '1') {
            S[i] = '2'
            cnt++
        }
    }

    cnt = 0

    for(i in 0 until S.size){
        if(cnt == zeroCnt) break
        if(S[S.size - i - 1] == '0')
        {
            S[S.size - i - 1] = '2'
            cnt++
        }
    }

    for(i in S){
        if(i != '2')
            print(i)
    }

}