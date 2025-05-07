fun main() {

    val (N, K) = readln().split(" ").map {it.toInt()}

    val pos = readln().toMutableList()

    // 다음 사람을 위해서 최대한 인덱스가 낮은 햄버거를 먹는다.
    var res = 0
    for (i in 0 until N){
        if(pos[i] == 'P'){

            var eaten = 0

            for(j in 0 until K){
                if(i - (K - j) < 0) continue
                if(pos[i - (K - j)] == 'H') {
                    eaten = 1
                    pos[i - (K - j)] = '0'
                    res++
                    break
                }
            }

            if(eaten == 0){
                for(j in 0 until K + 1) {
                    if(i + j >= N) break
                    if (pos[i + j] == 'H') {
                        pos[i + j] = '0'
                        res++
                        break
                    }
                }
            }
        }
    }

    print(res)
}