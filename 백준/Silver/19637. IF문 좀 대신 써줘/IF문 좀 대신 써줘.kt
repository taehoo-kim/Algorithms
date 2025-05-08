fun main() {

    val (N, M) = readln().split(" ").map {it.toInt()}

    val style = mutableListOf<Pair<String, Int>>()

    repeat(N){
        val line = readln().split(" ").map {it}
        style.add(Pair(line[0], line[1].toInt()))
    }

    val res = StringBuilder()

    repeat(M){
        val input = readln().toInt()

        var left = 0
        var right = N - 1
        var answer = ""

        while(left <= right){
            val mid = (left + right) / 2
            if(input <= style[mid].second){
                answer = style[mid].first
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        res.appendLine(answer)
    }

    println(res)
}