fun main() {
    val T = readln().toInt()

    for(i in 0 until T){
        // 한 팀은 6명의 선수로 구성
        // 팀 점수 -> 상위 4명의 점수 합산
        // 팀 수가 6명이 안되면 점수 계산에서 제외
        // 결승점을 통과한 순서대로 1점 2점 이런식
        // 가장 낮은 점수를 얻는 팀이 우승
        // 동점의 경우 다섯 번째 주자가 가장 빨리 들어온 팀이 우승
        val N = readln().toInt()
        val teamNumberList = readln().split(" ").map {it.toInt()}.toMutableList()
        val teamMemberCnt = Array(201) {0}
        for (i in 0 until teamNumberList.size){
            teamMemberCnt[teamNumberList[i]]++
        }

        val excludedTeam = Array(201) {0}
        val teamScoreList = Array(201) {0}
        val fourCheck = Array(201) {0}
        val fiveMemberScore = Array(201){0}
        var idx = 0

        for(i in 0 until teamMemberCnt.size){
            if(teamMemberCnt[i] < 6){
                excludedTeam[idx++] = i
            }
        }

        for(i in 0 until teamNumberList.size){
            if(teamNumberList[i] in excludedTeam){
                teamNumberList[i] = 0
            }
        }


        var score = 1
        for(i in 0 until teamNumberList.size){
            if(teamNumberList[i] == 0) continue
            if(fourCheck[teamNumberList[i]] < 4) {
                teamScoreList[teamNumberList[i]] += score
                fourCheck[teamNumberList[i]]++
            } else if(fiveMemberScore[teamNumberList[i]] == 0){
                fiveMemberScore[teamNumberList[i]] = score
            }
            score++
        }

        val winScore = teamScoreList.filter { it != 0 }.minOrNull()

        val winCandidates = mutableListOf<Int>()

        for (i in 0 until teamScoreList.size){
            if(winScore == teamScoreList[i]){
                winCandidates.add(i)
            }
        }
        val temp = mutableListOf<Int>()

        if(winCandidates.size == 1) {
            println(winCandidates[0])
        } else {
            for(i in 0 until winCandidates.size){
                temp.add(fiveMemberScore[winCandidates[i]])
            }

            val fiveMemberMin = temp.filter {it != 0}.minOrNull()

            for(i in 0 until winCandidates.size){
                if(fiveMemberMin == fiveMemberScore[winCandidates[i]]){
                    println(winCandidates[i])
                }
            }
        }

    }
}