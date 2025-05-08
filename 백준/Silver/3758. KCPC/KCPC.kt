fun main() {
    // 한 문제에 대한 풀이를 여러 번 제출 가능
    // 최고 점수가 그 문제에 대한 최종 점수
    // 팀의 최종 점수는 각 문제에 대해 받은 점수의 총합
    // 점수가 동일한 경우
    // 1. 최종 점수가 같은 경우, 풀이를 제출한 횟수가 적은 팀의 순위가 높다
    // 2. 최종 점수도 같고 제출 횟수도 같은 경우, 마지막 제출 시간이 더 빠른 팀의 순위가 높다
    // 우리 팀의 순위 출력

    val T = readln().toInt()

    for(case in 0 until T){
        // n: 팀의 개수
        // k: 문제의 개수
        // t: 우리 팀의 ID
        // m: 로그 엔트리 개수
        val (n, k, t, m) = readln().split(" ").map {it.toInt()}

        val team = IntArray(n + 1)

        // 팀의 인덱스와 문제 번호
        val teamScore = Array(n + 1){ IntArray(k + 1) {0} }

        // 풀이 제출 횟수
        val teamCnt = Array(n + 1){0}

        // 마지막 제출 몇 번째인지
        val teamLast = Array(n + 1){0}

        // 팀 점수 총 합
        val teamTotalScore = Array(n + 1){0}

        // 풀이에 대한 정보가 제출되는 순서
        for(entry in 0 until m){
            // 팀 ID, 문제 번호, 획득한 점수 순서
            val (i, j, s) = readln().split(" ").map {it.toInt()}
            if(teamScore[i][j] == 0){ // 만약 안 푼 문제면
                teamScore[i][j] = s
            } else { // 푼 문제라면
                if(teamScore[i][j] < s){ // 더 큰 경우 갱신한다
                    teamScore[i][j] = s
                }
            }

            teamCnt[i]++
            teamLast[i] = entry + 1
        }

        for(index in 1..n){
            for(number in 1..k){
                teamTotalScore[index] += teamScore[index][number]
            }
        }


        val teamRank = Array(n + 1){1}

        for(index in 1..n){
            for(compareIndex in 1..n){
                if(index == compareIndex) continue

                if(teamTotalScore[index] < teamTotalScore[compareIndex]){
                    teamRank[index]++
                }

                else if(teamTotalScore[index] == teamTotalScore[compareIndex]){
                    if(teamCnt[index] > teamCnt[compareIndex]){
                        teamRank[index]++
                    } 
                    else if(teamCnt[index] == teamCnt[compareIndex]){
                        if(teamLast[index] > teamLast[compareIndex]){
                            teamRank[index]++
                        }
                    }
                }

            }
        }

        println(teamRank[t])

    }

}