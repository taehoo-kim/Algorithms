fun main() {

    // 같은 방향으로 두번 연속 움직일 수 없다.
    // 왼쪽 아래, 아래, 오른쪽 아래만 가능

    val (N, M) = readln().split(" ").map {it.toInt()}

    val space = Array(N) { IntArray(M) }
    val dx = arrayOf(-1, 0, 1)

    for(i in 0 until N){
        val line = readln().split(" ").map {it.toInt()}
        for(j in 0 until M){
            space[i][j] = line[j]
        }
    }

    val dp = Array(N)
        {Array(M) {
            IntArray(3) {Int.MAX_VALUE}
            }
        }

    for(j in 0 until M){
        for(dir in 0..2){
            dp[0][j][dir] = space[0][j]
        }
    }

    for(i in 1 until N){
        for(j in 0 until M){
            for(currDir in 0..2){
                val prevJ = j - dx[currDir]
                if(prevJ < 0 || prevJ >= M) continue

                for(prevDir in 0..2){
                    if(prevDir == currDir) continue
                    if(dp[i-1][prevJ][prevDir] == Int.MAX_VALUE) continue
                    if(dp[i][j][currDir] > dp[i-1][prevJ][prevDir] + space[i][j])
                        dp[i][j][currDir] = dp[i-1][prevJ][prevDir] + space[i][j]
                }

            }
        }
    }

    var res = Int.MAX_VALUE
    for(j in 0 until M){
        for(dir in 0..2){
            if(res > dp[N-1][j][dir])
                res = dp[N-1][j][dir]
        }
    }

    print(res)

}