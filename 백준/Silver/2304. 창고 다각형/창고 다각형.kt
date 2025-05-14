fun main() {
    val N = readln().toInt()
    val posList = mutableListOf<Pair<Int, Int>>().apply {
        repeat(N) {
            val (L, H) = readln().split(" ").map { it.toInt() }
            add(L to H)
        }
    }

    // 1. 위치 기준 정렬
    val sorted = posList.sortedBy { it.first }
    val maxH = sorted.maxOf { it.second }

    // 2. 최대 높이의 첫 번째와 마지막 위치 찾기
    val firstMaxIdx = sorted.indexOfFirst { it.second == maxH }
    val lastMaxIdx = sorted.indexOfLast { it.second == maxH }

    var totalArea = 0
    var currentH = sorted[0].second
    var currentPos = sorted[0].first

    // 3. 왼쪽 -> 첫 번째 최대 높이까지 계산
    for (i in 1..firstMaxIdx) {
        totalArea += (sorted[i].first - currentPos) * currentH
        currentPos = sorted[i].first
        if (sorted[i].second > currentH) {
            currentH = sorted[i].second
        }
    }

    // 4. 최대 높이 영역 계산 (가로 길이)
    totalArea += (sorted[lastMaxIdx].first - sorted[firstMaxIdx].first + 1) * maxH

    // 5. 오른쪽 <- 마지막 최대 높이까지 계산
    currentH = sorted.last().second
    currentPos = sorted.last().first
    for (i in sorted.lastIndex - 1 downTo lastMaxIdx) {
        totalArea += (currentPos - sorted[i].first) * currentH
        currentPos = sorted[i].first
        if (sorted[i].second > currentH) {
            currentH = sorted[i].second
        }
    }

    println(totalArea)
}
