fun main() {

    // 처음 입장한 플레이어 레벨 기준 -10부터 +10까지 입장 가능
    // 입장 가능한 방이 있다면 입장시킨 후 방의 정원이 모두 찰 때까지 대기
    // 입장 가능한 방이 여러 개라면 먼저 생성된 방에 입장
    val (p, m) = readln().split(" ").map {it.toInt()}
    val rooms = mutableListOf<MutableList<Pair<Int, String>>>()

    repeat(p){
        val (level, nickname) = readln().split(" ")
        val player = level.toInt() to nickname

        var isAdded = false

        // 기존 방 탐색 (생성 순)
        for (room in rooms){
            if(room.size < m && player.first in (room[0].first - 10..room[0].first + 10)) {
                room.add(player)
                isAdded = true
                break
            }
        }

        if(!isAdded){
            rooms.add(mutableListOf(player))
        }
    }

    val res = buildString {
        rooms.forEach { room ->
            appendLine(if (room.size == m) "Started!" else "Waiting!")
            room.sortedBy {it.second}.forEach {(l, n) ->
                appendLine("$l $n")
            }
        }
    }

    println(res)


}