import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = StringTokenizer(br.readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }

    val words = mutableMapOf<String, Int>()

    repeat(N) {
        val word = br.readLine()
        if (word.length < M) return@repeat
        words[word] = (words[word] ?: 0) + 1
    }

    val sortedList = words.keys.sortedWith(
        compareByDescending<String> { words[it] ?: 0 }  // 1. 빈도 내림차순
            .thenByDescending { it.length }             // 2. 길이 내림차순
            .thenBy { it }                              // 3. 사전순 오름차순
    )

    println(sortedList.joinToString("\n"))
}
