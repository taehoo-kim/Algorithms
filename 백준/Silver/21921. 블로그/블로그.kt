fun main() {

    val (N, X) = readln().split(" ").map { it.toInt() }
    val visitorCntList = readln().split(" ").map { it.toInt() }
    var maxCnt = -1L

    if (visitorCntList.maxOrNull()!! == 0) {
        print("SAD")
        return
    }

    val sumArray = LongArray(N + 1)

    sumArray[0] = visitorCntList[0].toLong()

    for(i in 1 until N){
        sumArray[i] = sumArray[i - 1] + visitorCntList[i]
    }

    var cnt = 0

    for(i in X - 1 until N){
        val total = if(i == X - 1) sumArray[i] else sumArray[i] - sumArray[i - X]
        if(maxCnt < total){
            cnt = 0
            maxCnt = total
        }

        if(maxCnt == total) {
            cnt++
        }
    }

    println(maxCnt)
    print(cnt)

}